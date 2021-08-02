package Frames;



import BeanClasses.ClassBean;
import BeanClasses.SectionBean;
import BeanClasses.StudentBean;
import BeanClasses.WingBean;
import DatabaseManager.DatabaseManager;
import EnDeCoder.Decoder;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Danish
 */
public class StudentFrame extends javax.swing.JFrame {

    /**
     * Creates new form StudentFrame
     */
    public StudentFrame() {
        initComponents();
        getWing();
//        	genderComboBox.addItem("MALE");
//		genderComboBox.addItem("FEMALE");
                          
    }
private void getWing(){
	try{
                Vector v=DatabaseManager.getWing();
		wingComboBox.removeAllItems();
		for(int i=0; i<v.size(); i++)
			wingComboBox.addItem(v.elementAt(i));            
	}catch(Exception e){
		e.printStackTrace();
		javax.swing.JOptionPane.showMessageDialog(this,"Error: "+e.getMessage());
	}
}//end method 
       
private void getClasss(){
        WingBean wingBean=(WingBean)wingComboBox.getSelectedItem();
        if(wingBean==null)return; 
	try{
            Vector v=DatabaseManager.getClasss(wingBean.getWingId());
		classComboBox.removeAllItems();
		for(int i=0; i<v.size(); i++)
			classComboBox.addItem(v.elementAt(i));               	

      }catch(Exception e){
        e.printStackTrace();
        javax.swing.JOptionPane.showMessageDialog(this,"Error: "+e.getMessage());
    }    
	
}//end Method 
private void getSection(){
        ClassBean classBean=(ClassBean)classComboBox.getSelectedItem();
        if(classBean==null)return; 
        
	try{
            Vector v=DatabaseManager.getSection(classBean.getClassId());
		sectionComboBox.removeAllItems();
		for(int i=0; i<v.size(); i++)
			sectionComboBox.addItem(v.elementAt(i));                  		

      }catch(Exception e){
        e.printStackTrace();
        javax.swing.JOptionPane.showMessageDialog(this,"Error: "+e.getMessage());
    } 
}
private void getStudent(){
        SectionBean sectionBean=(SectionBean)sectionComboBox.getSelectedItem();
        if(sectionBean==null)return; 
        
	try{
			Vector v=DatabaseManager.getStudent(sectionBean.getSectionId());
                       DefaultTableModel model=(DefaultTableModel)stdTable.getModel();
                        tableClear();
                Vector vector =null;
               for(int i=0; i<v.size(); i++){
                   StudentBean stdBean= (StudentBean)v.elementAt(i);
                     vector = new Vector();
                     
                     vector.addElement(stdBean.getStdId());
                     vector.addElement(stdBean.getName());
                     vector.addElement(stdBean.getfName());
                     vector.addElement(stdBean.getSurname());
                     vector.addElement(stdBean.getStdCnic());
                     vector.addElement(stdBean.getGender());
                     vector.addElement(stdBean.getReligion());
                     vector.addElement(stdBean.getDateOfBirth());
                     vector.addElement(stdBean.getStdMobile());
                     vector.addElement(stdBean.getPresentAddress());
                     vector.addElement(stdBean.getRemarks());
                     model.addRow(vector);
                }  		

      }catch(Exception e){
        e.printStackTrace();
        javax.swing.JOptionPane.showMessageDialog(this,"Error: "+e.getMessage());
    } 
}
   private void addStudent(){            
       
            String name=nameTextField.getText();
            String surname=surnameTextField.getText();
            String dob=Decoder.getDateFormat(dobDateChooser.getDate());
            String stdCnic=stdCnicTextField.getText();
            String presentAddress=presentAddressTextField.getText();
            String parmanentAddress=parmanentAddressTextField.getText();
            String gender=null;
            if(maleCheckBox.isSelected())
               gender="M";
            if(femaleCheckBox.isSelected()) 
               gender="F";
            String religion=religionTextField.getText();
            String stdMobile=stdMobileTextField.getText();
            String dateOfAddmission=Decoder.getDateFormat(doaDateChooser.getDate());
            String lastAttendClass=lastAttendedClassTextField.getText();
            String passingYear=pYearTextField.getText();
            String lastAttendedSchoolName=lastAttendedSchoolNameTextField.getText();
            String lastSchoolLeavingReason=lastSchoolLeavingReasonsTextField.getText();
            String remarks=remarksTextArea.getText();
            String fName=fathersNameTextField.getText();
            String fCnic=fathersCnicTextField.getText();
            String fMobile=fathersMobileTextField.getText();
            String fQualification=fathersQualicationTextField.getText();
            String fOccupation=fathersOccupationTextField.getText();
            String mName=mothersNameTextField.getText();;
            String mCnic=mothersCnicTextField.getText();;
            String mMobile=mothersMobileTextField.getText();;
            String mQualification=mothersQualificationTextField.getText();;
            String mOccupation=mothersOccupationTextField.getText();;
            String gName=guardiansNameTextField.getText();
            String gCnic=guardiansCnicTextField.getText();
            String gMobile=guardiansMobileTextField.getText();
            String gQualification=guardiansQualificationTextField.getText();
            String gOccupation=guardiansOccupationTextField.getText();
            String gRelationship=guardiansRelationshipTextField.getText();    
    
    try{
        SectionBean sectionBean=(SectionBean)sectionComboBox.getSelectedItem();
              int rows=DatabaseManager.addStudent(sectionBean.getSectionId(),name,surname,dob,stdCnic,presentAddress,parmanentAddress,gender,religion,stdMobile,dateOfAddmission,lastAttendClass,passingYear,lastAttendedSchoolName,lastSchoolLeavingReason,remarks,fName,fCnic,fMobile,fQualification,fOccupation,mName,mCnic,mMobile,mQualification,mOccupation,gName,gCnic,gMobile,gQualification,gOccupation,gRelationship);
                
	if(rows>=1){
	        	javax.swing.JOptionPane.showMessageDialog(this,rows+" Records Inserted."); 
		clear();
		getStudent();				
	}
    }catch(Exception e){
        e.printStackTrace();
        javax.swing.JOptionPane.showMessageDialog(this,"Error: "+e.getMessage()); 
    }

}   //end 
private void deleteStudent(){
     int row =stdTable.getSelectedRow();
     String stdId=stdTable.getModel().getValueAt(row, 0).toString();
    try{
           int rows = DatabaseManager.deleteStudent(stdId);
           if(rows>=1){
           javax.swing.JOptionPane.showMessageDialog(this,rows+" Rrecord Removed.");
           getStudent();
           clear();
           }
    }catch(Exception e){
        e.printStackTrace();
        javax.swing.JOptionPane.showMessageDialog(this,"Error: "+e.getMessage()); 
    }
}   
private void updateStudent(){
    int row =stdTable.getSelectedRow();
     String stdId=stdTable.getModel().getValueAt(row, 0).toString();
     
           String name=nameTextField.getText();
            String surname=surnameTextField.getText();
            String dob=Decoder.getDateFormat(dobDateChooser.getDate());
            String stdCnic=stdCnicTextField.getText();
            String presentAddress=presentAddressTextField.getText();
            String parmanentAddress=parmanentAddressTextField.getText();
            String gender=null;
            if(maleCheckBox.isSelected())
               gender="M";
            if(femaleCheckBox.isSelected()) 
               gender="F";
            String religion=religionTextField.getText();
            String stdMobile=stdMobileTextField.getText();
            String dateOfAddmission=Decoder.getDateFormat(doaDateChooser.getDate());
            String lastAttendClass=lastAttendedClassTextField.getText();
            String passingYear=pYearTextField.getText();
            String lastAttendedSchoolName=lastAttendedSchoolNameTextField.getText();
            String lastSchoolLeavingReason=lastSchoolLeavingReasonsTextField.getText();
            String remarks=remarksTextArea.getText();
            String fName=fathersNameTextField.getText();
            String fCnic=fathersCnicTextField.getText();
            String fMobile=fathersMobileTextField.getText();
            String fQualification=fathersQualicationTextField.getText();
            String fOccupation=fathersOccupationTextField.getText();
            String mName=mothersNameTextField.getText();;
            String mCnic=mothersCnicTextField.getText();;
            String mMobile=mothersMobileTextField.getText();;
            String mQualification=mothersQualificationTextField.getText();;
            String mOccupation=mothersOccupationTextField.getText();;
            String gName=guardiansNameTextField.getText();
            String gCnic=guardiansCnicTextField.getText();
            String gMobile=guardiansMobileTextField.getText();
            String gQualification=guardiansQualificationTextField.getText();
            String gOccupation=guardiansOccupationTextField.getText();
            String gRelationship=guardiansRelationshipTextField.getText();    

     try{
	int rows=DatabaseManager.updateStudent(stdId,name,surname,dob,stdCnic,presentAddress,parmanentAddress,gender,religion,stdMobile,dateOfAddmission,lastAttendClass,passingYear,lastAttendedSchoolName,lastSchoolLeavingReason,remarks,fName,fCnic,fMobile,fQualification,fOccupation,mName,mCnic,mMobile,mQualification,mOccupation,gName,gCnic,gMobile,gQualification,gOccupation,gRelationship);
	if(rows>=1){
	    javax.swing.JOptionPane.showMessageDialog(this,rows+" Record Modified.");
	    getStudent();
	    clear();
        	}
     }catch(Exception e){
         e.printStackTrace();
         javax.swing.JOptionPane.showMessageDialog(this,"Error: "+e.getMessage());
     } 
}
private void clear(){
            nameTextField.setText("");
            surnameTextField.setText("");
            dobDateChooser.setDate(null);
            stdCnicTextField.setText("");
            presentAddressTextField.setText("");
            parmanentAddressTextField.setText("");
            //String gender=null;
            maleCheckBox.setSelected(false);
                    //gender="";
            femaleCheckBox.setSelected(false);
              // gender="F";
            religionTextField.setText("");
            stdMobileTextField.setText("");
            doaDateChooser.setDate(null);
            lastAttendedClassTextField.setText("");
            pYearTextField.setText("");
            lastAttendedSchoolNameTextField.setText("");
            lastSchoolLeavingReasonsTextField.setText("");
            remarksTextArea.setText("");
            fathersNameTextField.setText("");
            fathersCnicTextField.setText("");
            fathersMobileTextField.setText("");
            fathersQualicationTextField.setText("");
            fathersOccupationTextField.setText("");
            mothersNameTextField.setText("");;
            mothersCnicTextField.setText("");;
            mothersMobileTextField.setText("");;
            mothersQualificationTextField.setText("");;
            mothersOccupationTextField.setText("");;
            guardiansNameTextField.setText("");
            guardiansCnicTextField.setText("");
            guardiansMobileTextField.setText("");
            guardiansQualificationTextField.setText("");
            guardiansOccupationTextField.setText("");
            guardiansRelationshipTextField.setText("");
}    
private void tableClear(){
    DefaultTableModel model=(DefaultTableModel)stdTable.getModel();
    while(model.getRowCount()>0){
        for(int i=0;i<model.getRowCount();++i){
            model.removeRow(i);
        }
    }    
}    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        fathersMobileLabel = new javax.swing.JLabel();
        sectionComboBox = new javax.swing.JComboBox();
        wingComboBox = new javax.swing.JComboBox();
        wingLabel = new javax.swing.JLabel();
        classLabel = new javax.swing.JLabel();
        classComboBox = new javax.swing.JComboBox();
        sectionLabel = new javax.swing.JLabel();
        stdLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        surnameLabel = new javax.swing.JLabel();
        presentAddressLabel = new javax.swing.JLabel();
        doaLabel = new javax.swing.JLabel();
        fathersLabel = new javax.swing.JLabel();
        fathersCnicLabel = new javax.swing.JLabel();
        fathersOccupationLabel = new javax.swing.JLabel();
        genderLabel = new javax.swing.JLabel();
        religionLabel = new javax.swing.JLabel();
        stdIdTextField = new javax.swing.JTextField();
        fathersMobileTextField = new javax.swing.JTextField();
        surnameTextField = new javax.swing.JTextField();
        religionTextField = new javax.swing.JTextField();
        maleCheckBox = new javax.swing.JCheckBox();
        femaleCheckBox = new javax.swing.JCheckBox();
        presentAddressTextField = new javax.swing.JTextField();
        doaDateChooser = new com.toedter.calendar.JDateChooser();
        jScrollPane2 = new javax.swing.JScrollPane();
        remarksTextArea = new javax.swing.JTextArea();
        nameTextField = new javax.swing.JTextField();
        fathersOccupationTextField = new javax.swing.JTextField();
        picLabel = new javax.swing.JLabel();
        guardiansLabel = new javax.swing.JLabel();
        mothersLabel = new javax.swing.JLabel();
        parmanentAddressTextField = new javax.swing.JTextField();
        permanentAddressLabel = new javax.swing.JLabel();
        stdMobileTextField = new javax.swing.JTextField();
        stdMobileLabel = new javax.swing.JLabel();
        lastAttendedSchoolNameTextField = new javax.swing.JTextField();
        lastAttendedSchoolNameLabel = new javax.swing.JLabel();
        fathersNameTextField = new javax.swing.JTextField();
        fathersNameLabel = new javax.swing.JLabel();
        fathersQualificationLabel = new javax.swing.JLabel();
        fathersQualicationTextField = new javax.swing.JTextField();
        guardiansOccupationTextField = new javax.swing.JTextField();
        guardiansQualificationTextField = new javax.swing.JTextField();
        guardiansQualificationLabel = new javax.swing.JLabel();
        guardiansOccupationLabel = new javax.swing.JLabel();
        guardiansMobileTextField = new javax.swing.JTextField();
        guardiansMobileLabel = new javax.swing.JLabel();
        guardiansCnicTextField = new javax.swing.JTextField();
        guardiansCnicLabel = new javax.swing.JLabel();
        guardiansNameLabel = new javax.swing.JLabel();
        guardiansNameTextField = new javax.swing.JTextField();
        mothersCnicLabel = new javax.swing.JLabel();
        mothersQualificationLabel = new javax.swing.JLabel();
        mothersMobileTextField = new javax.swing.JTextField();
        mothersOccupationTextField = new javax.swing.JTextField();
        mothersNameLabel = new javax.swing.JLabel();
        mothersCnicTextField = new javax.swing.JTextField();
        mothersOccupationLabel = new javax.swing.JLabel();
        mothersQualificationTextField = new javax.swing.JTextField();
        mothersNameTextField = new javax.swing.JTextField();
        mothersMobileLabel = new javax.swing.JLabel();
        stdCnicLabel = new javax.swing.JLabel();
        stdCnicTextField = new javax.swing.JTextField();
        pYearTextField = new javax.swing.JTextField();
        passingYearTextField = new javax.swing.JLabel();
        lastAttendedClassTextField = new javax.swing.JTextField();
        lastAttendedClassLabel = new javax.swing.JLabel();
        lastSchoolLeavingReasonsTextField = new javax.swing.JTextField();
        lastSchoolLeavingReasonsLabel = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        addButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        remarksLabel1 = new javax.swing.JLabel();
        chooseFileButton1 = new javax.swing.JButton();
        printButton = new javax.swing.JButton();
        searchLabel = new javax.swing.JLabel();
        searchTextField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        fathersCnicTextField = new javax.swing.JTextField();
        dobDateChooser = new com.toedter.calendar.JDateChooser();
        dobLabel = new javax.swing.JLabel();
        guardiansRelationshipLabel = new javax.swing.JLabel();
        guardiansRelationshipTextField = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        stdTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(2000, 1000));
        setMinimumSize(new java.awt.Dimension(2000, 1000));
        setPreferredSize(new java.awt.Dimension(2000, 1000));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titleLabel.setFont(new java.awt.Font("Ravie", 1, 60)); // NOI18N
        titleLabel.setText("STUDENT DATABASE MANAGEMENT SYSTEM");
        jPanel1.add(titleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 70));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1890, 70));

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(15, 158, 160), 4));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fathersMobileLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        fathersMobileLabel.setText("FATHER'S MOBILE#");
        jPanel3.add(fathersMobileLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 150, 170, 20));

        sectionComboBox.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        sectionComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sectionComboBoxActionPerformed(evt);
            }
        });
        jPanel3.add(sectionComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 150, 30));

        wingComboBox.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        wingComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wingComboBoxActionPerformed(evt);
            }
        });
        jPanel3.add(wingComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 150, 30));

        wingLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        wingLabel.setText("WING");
        jPanel3.add(wingLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, -1, -1));

        classLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        classLabel.setText("CLASS");
        jPanel3.add(classLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, -1, -1));

        classComboBox.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        classComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                classComboBoxActionPerformed(evt);
            }
        });
        jPanel3.add(classComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 150, 30));

        sectionLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        sectionLabel.setText("SECTION");
        jPanel3.add(sectionLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, -1, -1));

        stdLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        stdLabel.setText("STUDENT ID");
        jPanel3.add(stdLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, -1));

        nameLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        nameLabel.setText("NAME");
        jPanel3.add(nameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, -1, -1));

        surnameLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        surnameLabel.setText("SURNAME");
        jPanel3.add(surnameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, -1, -1));

        presentAddressLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        presentAddressLabel.setText("PRESENT ADDRESS");
        jPanel3.add(presentAddressLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 420, -1, 20));

        doaLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        doaLabel.setText("DATE OF BIRTH");
        jPanel3.add(doaLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 130, 30));

        fathersLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        fathersLabel.setText("                               FATHER'S DETAILS");
        fathersLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 51), 4));
        jPanel3.add(fathersLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 20, 500, 30));

        fathersCnicLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        fathersCnicLabel.setText("FATHER'S CNIC");
        jPanel3.add(fathersCnicLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 110, 130, 20));

        fathersOccupationLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        fathersOccupationLabel.setText("FATHER'S OCCUPATION");
        jPanel3.add(fathersOccupationLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 230, 200, 20));

        genderLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        genderLabel.setText("GENDER");
        jPanel3.add(genderLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 250, -1, -1));

        religionLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        religionLabel.setText("RELIGION");
        jPanel3.add(religionLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, 90, -1));

        stdIdTextField.setEditable(false);
        stdIdTextField.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jPanel3.add(stdIdTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, 70, -1));

        fathersMobileTextField.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jPanel3.add(fathersMobileTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 150, 220, -1));

        surnameTextField.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jPanel3.add(surnameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 210, 270, -1));

        religionTextField.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jPanel3.add(religionTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 330, 150, -1));

        maleCheckBox.setText("MALE");
        jPanel3.add(maleCheckBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 250, -1, -1));

        femaleCheckBox.setText("FEMALE");
        jPanel3.add(femaleCheckBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 250, -1, -1));

        presentAddressTextField.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        presentAddressTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                presentAddressTextFieldActionPerformed(evt);
            }
        });
        jPanel3.add(presentAddressTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 440, 260, 20));
        jPanel3.add(doaDateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 390, -1, -1));

        remarksTextArea.setColumns(20);
        remarksTextArea.setRows(5);
        jScrollPane2.setViewportView(remarksTextArea);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 510, 690, 60));

        nameTextField.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        nameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTextFieldActionPerformed(evt);
            }
        });
        jPanel3.add(nameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 270, -1));

        fathersOccupationTextField.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jPanel3.add(fathersOccupationTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 230, 220, -1));

        picLabel.setText("PIC LABEL");
        jPanel3.add(picLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 20, 200, 210));

        guardiansLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        guardiansLabel.setText("                               GUARDIANS DETAILS");
        guardiansLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 51), 4));
        jPanel3.add(guardiansLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 300, 490, 30));

        mothersLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        mothersLabel.setText("                              MOTHER'S DETAILS");
        mothersLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 51), 4));
        jPanel3.add(mothersLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1420, 20, 430, 30));

        parmanentAddressTextField.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jPanel3.add(parmanentAddressTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 480, 260, 20));

        permanentAddressLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        permanentAddressLabel.setText("PERMANENT ADDRESS");
        jPanel3.add(permanentAddressLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 460, -1, 20));

        stdMobileTextField.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        stdMobileTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stdMobileTextFieldActionPerformed(evt);
            }
        });
        jPanel3.add(stdMobileTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 360, 150, -1));

        stdMobileLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        stdMobileLabel.setText("MOBILE#");
        jPanel3.add(stdMobileLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 360, 80, -1));

        lastAttendedSchoolNameTextField.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jPanel3.add(lastAttendedSchoolNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 410, 380, 30));

        lastAttendedSchoolNameLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lastAttendedSchoolNameLabel.setText("LAST ATTENDED SCHOOL NAME");
        jPanel3.add(lastAttendedSchoolNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 390, -1, 20));

        fathersNameTextField.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        fathersNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fathersNameTextFieldActionPerformed(evt);
            }
        });
        jPanel3.add(fathersNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 70, 220, -1));

        fathersNameLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        fathersNameLabel.setText("FATHER'S NAME");
        jPanel3.add(fathersNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 70, 140, 20));

        fathersQualificationLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        fathersQualificationLabel.setText("FATHER'S QUALIFICATION");
        jPanel3.add(fathersQualificationLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 190, 230, 20));

        fathersQualicationTextField.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jPanel3.add(fathersQualicationTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 190, 220, -1));

        guardiansOccupationTextField.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jPanel3.add(guardiansOccupationTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 500, 220, -1));

        guardiansQualificationTextField.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jPanel3.add(guardiansQualificationTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 460, 220, -1));

        guardiansQualificationLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        guardiansQualificationLabel.setText("GUARDIAN'S QUALIFICATION");
        jPanel3.add(guardiansQualificationLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 460, 260, 20));

        guardiansOccupationLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        guardiansOccupationLabel.setText("GUARDIAN'S OCCUPATION");
        jPanel3.add(guardiansOccupationLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 500, 230, 20));

        guardiansMobileTextField.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jPanel3.add(guardiansMobileTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 420, 220, -1));

        guardiansMobileLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        guardiansMobileLabel.setText("GUARDIAN'S MOBILE#");
        jPanel3.add(guardiansMobileLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 420, 190, 20));

        guardiansCnicTextField.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jPanel3.add(guardiansCnicTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 380, 220, -1));

        guardiansCnicLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        guardiansCnicLabel.setText("GUARDIAN'S CNIC");
        jPanel3.add(guardiansCnicLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 380, 160, 20));

        guardiansNameLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        guardiansNameLabel.setText("GUARDIAN'S NAME");
        jPanel3.add(guardiansNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 340, 160, 20));

        guardiansNameTextField.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jPanel3.add(guardiansNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 340, 220, -1));

        mothersCnicLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        mothersCnicLabel.setText("MOTHER'S CNIC");
        jPanel3.add(mothersCnicLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1470, 110, 140, 20));

        mothersQualificationLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        mothersQualificationLabel.setText("MOTHER'S QUALIFICATION");
        jPanel3.add(mothersQualificationLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1390, 190, 230, 20));

        mothersMobileTextField.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jPanel3.add(mothersMobileTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(1630, 150, 220, -1));

        mothersOccupationTextField.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jPanel3.add(mothersOccupationTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(1630, 230, 220, -1));

        mothersNameLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        mothersNameLabel.setText("MOTHER'S NAME");
        jPanel3.add(mothersNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1470, 70, 140, 20));

        mothersCnicTextField.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jPanel3.add(mothersCnicTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(1630, 110, 220, -1));

        mothersOccupationLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        mothersOccupationLabel.setText("MOTHER'S OCCUPATION");
        jPanel3.add(mothersOccupationLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 230, 210, 20));

        mothersQualificationTextField.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jPanel3.add(mothersQualificationTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(1630, 190, 220, -1));

        mothersNameTextField.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jPanel3.add(mothersNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(1630, 70, 220, -1));

        mothersMobileLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        mothersMobileLabel.setText("MOTHER'S MOBILE#");
        jPanel3.add(mothersMobileLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1440, 150, 170, 20));

        stdCnicLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        stdCnicLabel.setText("CNIC");
        jPanel3.add(stdCnicLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 290, 50, 20));

        stdCnicTextField.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jPanel3.add(stdCnicTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 290, 150, -1));

        pYearTextField.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jPanel3.add(pYearTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 460, 380, 30));

        passingYearTextField.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        passingYearTextField.setText("PASSING YEAR");
        jPanel3.add(passingYearTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 440, -1, 20));

        lastAttendedClassTextField.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jPanel3.add(lastAttendedClassTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 300, 380, 30));

        lastAttendedClassLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lastAttendedClassLabel.setText("LAST ATTENDED CLASS");
        jPanel3.add(lastAttendedClassLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 280, -1, 20));

        lastSchoolLeavingReasonsTextField.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jPanel3.add(lastSchoolLeavingReasonsTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 360, 380, 30));

        lastSchoolLeavingReasonsLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lastSchoolLeavingReasonsLabel.setText("LAST SCHOOL LEAVING REASONS");
        jPanel3.add(lastSchoolLeavingReasonsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 340, -1, 20));

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(15, 158, 160), 4));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addButton.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        addButton.setText("ADD NEW");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        jPanel5.add(addButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, 50));

        updateButton.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        updateButton.setText("UPDATE");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });
        jPanel5.add(updateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 130, 50));

        clearButton.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        clearButton.setText("CLEAR");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });
        jPanel5.add(clearButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 130, 50));

        backButton.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        backButton.setText("BACK");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        jPanel5.add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, 120, 50));

        saveButton.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        saveButton.setText("SAVE");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        jPanel5.add(saveButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 120, 50));

        deleteButton.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        deleteButton.setText("DELETE");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        jPanel5.add(deleteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 120, 50));

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1420, 280, 410, 130));

        remarksLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        remarksLabel1.setText("REMARKS");
        jPanel3.add(remarksLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 510, -1, -1));

        chooseFileButton1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        chooseFileButton1.setText("CHOOSE FILE");
        chooseFileButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseFileButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(chooseFileButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 240, 220, 40));

        printButton.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        printButton.setText("PRINT");
        printButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printButtonActionPerformed(evt);
            }
        });
        jPanel3.add(printButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1740, 540, 120, 30));

        searchLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        searchLabel.setText("ENTER NAME OF STUDENT");
        jPanel3.add(searchLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1430, 420, -1, 30));

        searchTextField.setText("SEARCH");
        searchTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTextFieldActionPerformed(evt);
            }
        });
        jPanel3.add(searchTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(1430, 450, 400, 30));

        searchButton.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        searchButton.setText("SEARCH");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });
        jPanel3.add(searchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1430, 490, 350, 30));

        fathersCnicTextField.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        fathersCnicTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fathersCnicTextFieldActionPerformed(evt);
            }
        });
        jPanel3.add(fathersCnicTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 110, 220, -1));
        jPanel3.add(dobDateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 250, -1, -1));

        dobLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        dobLabel.setText("DATE OF BIRTH");
        jPanel3.add(dobLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 250, 130, 30));

        guardiansRelationshipLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        guardiansRelationshipLabel.setText("GUARDIAN'S RELATIONSHIP");
        jPanel3.add(guardiansRelationshipLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 540, 240, 20));

        guardiansRelationshipTextField.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jPanel3.add(guardiansRelationshipTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 540, 220, -1));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1880, 580));

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(15, 158, 160), 4));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        stdTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NAME", "F.NAME", "SURNAME", "CNIC", "GENDER", "RELIGION", "DOB", "MOBILE", "ADDRESS", "REMARKS"
            }
        ));
        stdTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stdTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(stdTable);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1860, 260));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 600, 1880, 280));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 1900, 890));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        clear();
    }//GEN-LAST:event_clearButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_backButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saveButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        deleteStudent();
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        addStudent();
    }//GEN-LAST:event_addButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        updateStudent();
    }//GEN-LAST:event_updateButtonActionPerformed

    private void printButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_printButtonActionPerformed

    private void wingComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wingComboBoxActionPerformed
        getClasss();
    }//GEN-LAST:event_wingComboBoxActionPerformed

    private void classComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_classComboBoxActionPerformed
        getSection();
    }//GEN-LAST:event_classComboBoxActionPerformed

    private void sectionComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sectionComboBoxActionPerformed
        getStudent();
    }//GEN-LAST:event_sectionComboBoxActionPerformed

    private void stdTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stdTableMouseClicked
      int row =stdTable.getSelectedRow();
     String stdId=stdTable.getModel().getValueAt(row, 0).toString();
             
     StudentBean bean=DatabaseManager.getStudentById(stdId);
     
            nameTextField.setText(bean.getName());
            surnameTextField.setText(bean.getSurname());
            dobDateChooser.setDate(bean.getDateOfBirth());
            stdCnicTextField.setText(bean.getStdCnic());
            presentAddressTextField.setText(bean.getPresentAddress());
            parmanentAddressTextField.setText(bean.getParmanentAddress());
            if(bean.getGender()=="M")
               maleCheckBox.isSelected();
          //  maleCheckBox.setSelected(true);
            if(bean.getGender()=="F")
                femaleCheckBox.isSelected();
           // femaleCheckBox.setSelected(false);
             
            religionTextField.setText(bean.getReligion());
            stdMobileTextField.setText(bean.getStdMobile());
            doaDateChooser.setDate(bean.getDateOfAddmission());
            lastAttendedClassTextField.setText(bean.getLastAttendClass());
            pYearTextField.setText(bean.getPassingYear());
            lastAttendedSchoolNameTextField.setText(bean.getLastAttendedSchoolName());
            lastSchoolLeavingReasonsTextField.setText(bean.getLastSchoolLeavingReason());
            remarksTextArea.setText(bean.getRemarks());
            fathersNameTextField.setText(bean.getfName());
            fathersCnicTextField.setText(bean.getfCnic());
            fathersMobileTextField.setText(bean.getfMobile());
            fathersQualicationTextField.setText(bean.getfQualification());
            fathersOccupationTextField.setText(bean.getfOccupation());
            mothersNameTextField.setText(bean.getmName());;
            mothersCnicTextField.setText(bean.getmCnic());;
            mothersMobileTextField.setText(bean.getmMobile());;
            mothersQualificationTextField.setText(bean.getmQualification());;
            mothersOccupationTextField.setText(bean.getmOccupation());;
            guardiansNameTextField.setText(bean.getgName());
            guardiansCnicTextField.setText(bean.getgCnic());
            guardiansMobileTextField.setText(bean.getgMobile());
            guardiansQualificationTextField.setText(bean.getgQualification());
            guardiansOccupationTextField.setText(bean.getgOccupation());
            guardiansRelationshipTextField.setText(bean.getgRelationship());

    }//GEN-LAST:event_stdTableMouseClicked

    private void nameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTextFieldActionPerformed

    private void chooseFileButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseFileButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chooseFileButton1ActionPerformed

    private void stdMobileTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stdMobileTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stdMobileTextFieldActionPerformed

    private void searchTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTextFieldActionPerformed

    private void fathersNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fathersNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fathersNameTextFieldActionPerformed

    private void fathersCnicTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fathersCnicTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fathersCnicTextFieldActionPerformed

    private void presentAddressTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_presentAddressTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_presentAddressTextFieldActionPerformed
 

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StudentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton backButton;
    private javax.swing.JButton chooseFileButton1;
    private javax.swing.JComboBox classComboBox;
    private javax.swing.JLabel classLabel;
    private javax.swing.JButton clearButton;
    private javax.swing.JButton deleteButton;
    private com.toedter.calendar.JDateChooser doaDateChooser;
    private javax.swing.JLabel doaLabel;
    private com.toedter.calendar.JDateChooser dobDateChooser;
    private javax.swing.JLabel dobLabel;
    private javax.swing.JLabel fathersCnicLabel;
    private javax.swing.JTextField fathersCnicTextField;
    private javax.swing.JLabel fathersLabel;
    private javax.swing.JLabel fathersMobileLabel;
    private javax.swing.JTextField fathersMobileTextField;
    private javax.swing.JLabel fathersNameLabel;
    private javax.swing.JTextField fathersNameTextField;
    private javax.swing.JLabel fathersOccupationLabel;
    private javax.swing.JTextField fathersOccupationTextField;
    private javax.swing.JTextField fathersQualicationTextField;
    private javax.swing.JLabel fathersQualificationLabel;
    private javax.swing.JCheckBox femaleCheckBox;
    private javax.swing.JLabel genderLabel;
    private javax.swing.JLabel guardiansCnicLabel;
    private javax.swing.JTextField guardiansCnicTextField;
    private javax.swing.JLabel guardiansLabel;
    private javax.swing.JLabel guardiansMobileLabel;
    private javax.swing.JTextField guardiansMobileTextField;
    private javax.swing.JLabel guardiansNameLabel;
    private javax.swing.JTextField guardiansNameTextField;
    private javax.swing.JLabel guardiansOccupationLabel;
    private javax.swing.JTextField guardiansOccupationTextField;
    private javax.swing.JLabel guardiansQualificationLabel;
    private javax.swing.JTextField guardiansQualificationTextField;
    private javax.swing.JLabel guardiansRelationshipLabel;
    private javax.swing.JTextField guardiansRelationshipTextField;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lastAttendedClassLabel;
    private javax.swing.JTextField lastAttendedClassTextField;
    private javax.swing.JLabel lastAttendedSchoolNameLabel;
    private javax.swing.JTextField lastAttendedSchoolNameTextField;
    private javax.swing.JLabel lastSchoolLeavingReasonsLabel;
    private javax.swing.JTextField lastSchoolLeavingReasonsTextField;
    private javax.swing.JCheckBox maleCheckBox;
    private javax.swing.JLabel mothersCnicLabel;
    private javax.swing.JTextField mothersCnicTextField;
    private javax.swing.JLabel mothersLabel;
    private javax.swing.JLabel mothersMobileLabel;
    private javax.swing.JTextField mothersMobileTextField;
    private javax.swing.JLabel mothersNameLabel;
    private javax.swing.JTextField mothersNameTextField;
    private javax.swing.JLabel mothersOccupationLabel;
    private javax.swing.JTextField mothersOccupationTextField;
    private javax.swing.JLabel mothersQualificationLabel;
    private javax.swing.JTextField mothersQualificationTextField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JTextField pYearTextField;
    private javax.swing.JTextField parmanentAddressTextField;
    private javax.swing.JLabel passingYearTextField;
    private javax.swing.JLabel permanentAddressLabel;
    private javax.swing.JLabel picLabel;
    private javax.swing.JLabel presentAddressLabel;
    private javax.swing.JTextField presentAddressTextField;
    private javax.swing.JButton printButton;
    private javax.swing.JLabel religionLabel;
    private javax.swing.JTextField religionTextField;
    private javax.swing.JLabel remarksLabel1;
    private javax.swing.JTextArea remarksTextArea;
    private javax.swing.JButton saveButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JLabel searchLabel;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JComboBox sectionComboBox;
    private javax.swing.JLabel sectionLabel;
    private javax.swing.JLabel stdCnicLabel;
    private javax.swing.JTextField stdCnicTextField;
    private javax.swing.JTextField stdIdTextField;
    private javax.swing.JLabel stdLabel;
    private javax.swing.JLabel stdMobileLabel;
    private javax.swing.JTextField stdMobileTextField;
    private javax.swing.JTable stdTable;
    private javax.swing.JLabel surnameLabel;
    private javax.swing.JTextField surnameTextField;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JButton updateButton;
    private javax.swing.JComboBox wingComboBox;
    private javax.swing.JLabel wingLabel;
    // End of variables declaration//GEN-END:variables
}

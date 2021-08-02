package Frames;



import BeanClasses.ClassBean;
import BeanClasses.SectionBean;
import BeanClasses.SessionBean;
import BeanClasses.StudentBean;
import BeanClasses.StudentPromotionBean;
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
public class PromotionClassFrame extends javax.swing.JFrame {

    /**
     * Creates new form StudentFrame
     */
    public PromotionClassFrame() {
        initComponents();
        getClassWing();
        getStdWing();
        getSession();

                          
    }
private void getClassWing(){
	try{
                Vector v=DatabaseManager.getWing();
		classWingComboBox.removeAllItems();
		for(int i=0; i<v.size(); i++)
			classWingComboBox.addItem(v.elementAt(i));            
	}catch(Exception e){
		e.printStackTrace();
		javax.swing.JOptionPane.showMessageDialog(this,"Error: "+e.getMessage());
	}
}//end method 
       
private void getClasss(){
        WingBean wingBean=(WingBean)classWingComboBox.getSelectedItem();
        if(wingBean==null)return; 
	try{
            Vector v=DatabaseManager.getClasss(wingBean.getWingId());
		promotionClassComboBox.removeAllItems();
		for(int i=0; i<v.size(); i++)
			promotionClassComboBox.addItem(v.elementAt(i));               	

      }catch(Exception e){
        e.printStackTrace();
        javax.swing.JOptionPane.showMessageDialog(this,"Error: "+e.getMessage());
    }    
	
}//end Method 

private void getSession(){
	try{
            Vector v=DatabaseManager.getSession();
		sessionComboBox.removeAllItems();
		for(int i=0; i<v.size(); i++)
			sessionComboBox.addItem(v.elementAt(i));                  		

      }catch(Exception e){
        e.printStackTrace();
        javax.swing.JOptionPane.showMessageDialog(this,"Error: "+e.getMessage());
    } 
}
private void getStdWing(){
	try{
                Vector v=DatabaseManager.getWing();
		stdWingComboBox.removeAllItems();
		for(int i=0; i<v.size(); i++)
			stdWingComboBox.addItem(v.elementAt(i));            
	}catch(Exception e){
		e.printStackTrace();
		javax.swing.JOptionPane.showMessageDialog(this,"Error: "+e.getMessage());
	}
}//end method 
private void getStdClasss(){
        WingBean wingBean=(WingBean)stdWingComboBox.getSelectedItem();
        if(wingBean==null)return; 
	try{
            Vector v=DatabaseManager.getClasss(wingBean.getWingId());
		stdClassComboBox.removeAllItems();
		for(int i=0; i<v.size(); i++)
			stdClassComboBox.addItem(v.elementAt(i));               	

      }catch(Exception e){
        e.printStackTrace();
        javax.swing.JOptionPane.showMessageDialog(this,"Error: "+e.getMessage());
    }    
	
}//end Method 
private void getSection(){
        ClassBean classBean=(ClassBean)stdClassComboBox.getSelectedItem();
        if(classBean==null)return; 
        
	try{
			Vector v=DatabaseManager.getSection(classBean.getClassId());
                        stdSectionComboBox.removeAllItems();
                            for(int i=0; i<v.size(); i++)
                            stdSectionComboBox.addItem(v.elementAt(i)); 
                     
      }catch(Exception e){
        e.printStackTrace();
        javax.swing.JOptionPane.showMessageDialog(this,"Error: "+e.getMessage());
    } 
}
private void getStudent(){
        SectionBean sectionBean=(SectionBean)stdSectionComboBox.getSelectedItem();
        if(sectionBean==null)return; 
        
	try{
			Vector v=DatabaseManager.getStudent(sectionBean.getSectionId());
                        stdComboBox.removeAllItems();
                                    for(int i=0; i<v.size(); i++)
                                    stdComboBox.addItem(v.elementAt(i)); 

      }catch(Exception e){
        e.printStackTrace();
        javax.swing.JOptionPane.showMessageDialog(this,"Error: "+e.getMessage());
    } 
}

private void getStudentPromotion(){
        ClassBean classBean=(ClassBean)promotionClassComboBox.getSelectedItem();
        if(classBean==null)return;
        StudentBean stdBean=(StudentBean)stdComboBox.getSelectedItem();
        if(stdBean==null)return;
        SessionBean sessionBean=(SessionBean)sessionComboBox.getSelectedItem();
        if(sessionBean==null)return;        
        
	try{
			Vector v=DatabaseManager.getStudentPromotion(classBean.getClassId(),stdBean.getStdId(),sessionBean.getSessionId());
                       DefaultTableModel model=(DefaultTableModel)stdPromotionTable.getModel();
                        tableClear();
                Vector vector =null;
               for(int i=0; i<v.size(); i++){
                   StudentPromotionBean stdProBean= (StudentPromotionBean)v.elementAt(i);
                     vector = new Vector();
                     
                     vector.addElement(stdProBean.getClassId());
                     vector.addElement(stdProBean.getStdId());
                     vector.addElement(stdProBean.getSessionId());
                     vector.addElement(stdProBean.getProClassId());
                     vector.addElement(stdProBean.getDescription());
                     vector.addElement(stdProBean.getPromotionDate());
                     vector.addElement(stdProBean.getRemarks());

                    model.addRow(vector);
                }  		

      }catch(Exception e){
        e.printStackTrace();
        javax.swing.JOptionPane.showMessageDialog(this,"Error: "+e.getMessage());
    } 
}

   private void addStudentPromotion(){            
       
            String description=descriptionTextField.getText();
            String promotionDate=Decoder.getDateFormat(promotionDateChooser.getDate());
            String remarks=remarksTextArea.getText();
//            
//            String stdCnic=stdCnicTextField.getText();
//            String presentAddress=presentAddressTextField.getText();
//            String parmanentAddress=parmanentAddressTextField.getText();
//            String gender=null;
//            if(maleCheckBox.isSelected())
//               gender="M";
//            if(femaleCheckBox.isSelected()) 
//               gender="F";
//            String religion=religionTextField.getText();
//            String stdMobile=stdMobileTextField.getText();
//            String dateOfAddmission=Decoder.getDateFormat(doaDateChooser.getDate());
//            String lastAttendClass=lastAttendedClassTextField.getText();
//            String passingYear=pYearTextField.getText();
//            String lastAttendedSchoolName=lastAttendedSchoolNameTextField.getText();
//            String lastSchoolLeavingReason=lastSchoolLeavingReasonsTextField.getText();
//            
//            String fName=fathersNameTextField.getText();
//            String fCnic=fathersCnicTextField.getText();
//            String fMobile=fathersMobileTextField.getText();
//            String fQualification=fathersQualicationTextField.getText();
//            String fOccupation=fathersOccupationTextField.getText();
//            String mName=mothersNameTextField.getText();;
//            String mCnic=mothersCnicTextField.getText();;
//            String mMobile=mothersMobileTextField.getText();;
//            String mQualification=mothersQualificationTextField.getText();;
//            String mOccupation=mothersOccupationTextField.getText();;
//            String gName=guardiansNameTextField.getText();
//            String gCnic=guardiansCnicTextField.getText();
//            String gMobile=guardiansMobileTextField.getText();
//            String gQualification=guardiansQualificationTextField.getText();
//            String gOccupation=guardiansOccupationTextField.getText();
//            String gRelationship=guardiansRelationshipTextField.getText();    
    
    try{
        ClassBean classBean=(ClassBean)promotionClassComboBox.getSelectedItem();
        if(classBean==null)return;
        StudentBean stdBean=(StudentBean)stdComboBox.getSelectedItem();
        if(stdBean==null)return;
        SessionBean sessionBean=(SessionBean)sessionComboBox.getSelectedItem();
        if(sessionBean==null)return;  
              int rows=DatabaseManager.addStudentPromotion(classBean.getClassId(),stdBean.getStdId(),sessionBean.getSessionId(),description,promotionDate,remarks);
                
	if(rows>=1){
	        	javax.swing.JOptionPane.showMessageDialog(this,rows+" Records Inserted."); 
		//clear();
		getStudentPromotion();				
	}
    }catch(Exception e){
        e.printStackTrace();
        javax.swing.JOptionPane.showMessageDialog(this,"Error: "+e.getMessage()); 
    }

}   //end 

private void deleteStudentPromotion(){
     int row =stdPromotionTable.getSelectedRow();
     String proClassId=stdPromotionTable.getModel().getValueAt(row, 3).toString();
    try{
           int rows = DatabaseManager.deleteStudentPromotion(proClassId);
           if(rows>=1){
           javax.swing.JOptionPane.showMessageDialog(this,rows+" Rrecord Removed.");
           getStudentPromotion();
           //clear();
           }
    }catch(Exception e){
        e.printStackTrace();
        javax.swing.JOptionPane.showMessageDialog(this,"Error: "+e.getMessage()); 
    }
}   
   
private void updateStudentPromotion(){
     int row =stdPromotionTable.getSelectedRow();
     String proClassId=stdPromotionTable.getModel().getValueAt(row, 3).toString();
     
            String description=descriptionTextField.getText();
            String promotionDate=Decoder.getDateFormat(promotionDateChooser.getDate());
            String remarks=remarksTextArea.getText();
     
//           String name=nameTextField.getText();
//            String surname=surnameTextField.getText();
//            String dob=Decoder.getDateFormat(dobDateChooser.getDate());
//            String stdCnic=stdCnicTextField.getText();
//            String presentAddress=presentAddressTextField.getText();
//            String parmanentAddress=parmanentAddressTextField.getText();
//            String gender=null;
//            if(maleCheckBox.isSelected())
//               gender="M";
//            if(femaleCheckBox.isSelected()) 
//               gender="F";
//            String religion=religionTextField.getText();
//            String stdMobile=stdMobileTextField.getText();
//            String dateOfAddmission=Decoder.getDateFormat(doaDateChooser.getDate());
//            String lastAttendClass=lastAttendedClassTextField.getText();
//            String passingYear=pYearTextField.getText();
//            String lastAttendedSchoolName=lastAttendedSchoolNameTextField.getText();
//            String lastSchoolLeavingReason=lastSchoolLeavingReasonsTextField.getText();
//            String remarks=remarksTextArea.getText();
//            String fName=fathersNameTextField.getText();
//            String fCnic=fathersCnicTextField.getText();
//            String fMobile=fathersMobileTextField.getText();
//            String fQualification=fathersQualicationTextField.getText();
//            String fOccupation=fathersOccupationTextField.getText();
//            String mName=mothersNameTextField.getText();;
//            String mCnic=mothersCnicTextField.getText();;
//            String mMobile=mothersMobileTextField.getText();;
//            String mQualification=mothersQualificationTextField.getText();;
//            String mOccupation=mothersOccupationTextField.getText();;
//            String gName=guardiansNameTextField.getText();
//            String gCnic=guardiansCnicTextField.getText();
//            String gMobile=guardiansMobileTextField.getText();
//            String gQualification=guardiansQualificationTextField.getText();
//            String gOccupation=guardiansOccupationTextField.getText();
//            String gRelationship=guardiansRelationshipTextField.getText();    

     try{
        ClassBean classBean=(ClassBean)promotionClassComboBox.getSelectedItem();
        if(classBean==null)return;
        StudentBean stdBean=(StudentBean)stdComboBox.getSelectedItem();
        if(stdBean==null)return;
        SessionBean sessionBean=(SessionBean)sessionComboBox.getSelectedItem();
        if(sessionBean==null)return;         
	int rows=DatabaseManager.updateStudentPromotion(classBean.getClassId(),stdBean.getStdId(),sessionBean.getSessionId(),proClassId,description,promotionDate,remarks);
	if(rows>=1){
	    javax.swing.JOptionPane.showMessageDialog(this,rows+" Record Modified.");
	    getStudentPromotion();
	   // clear();
        	}
     }catch(Exception e){
         e.printStackTrace();
         javax.swing.JOptionPane.showMessageDialog(this,"Error: "+e.getMessage());
     } 
}

private void clear(){
            promotionClassIdTextField.setText("");
            descriptionTextField.setText("");
            promotionDateChooser.setDate(null);
            remarksTextArea.setText("");
            fathersNameTextField.setText("");
            fathersCnicTextField.setText("");
            fathersMobileTextField.setText("");
            fathersQualicationTextField.setText("");
            fathersOccupationTextField.setText("");
            stdNameTextField.setText("");
            stdCnicTextField.setText("");
            stdMobileTextField.setText("");
            passingYearTextField.setText("");
            dateOfAddmissionTextField.setText("");
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
    DefaultTableModel model=(DefaultTableModel)stdPromotionTable.getModel();
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
        fathersLabel = new javax.swing.JLabel();
        fathersCnicLabel = new javax.swing.JLabel();
        fathersOccupationLabel = new javax.swing.JLabel();
        fathersMobileTextField = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        remarksTextArea = new javax.swing.JTextArea();
        fathersOccupationTextField = new javax.swing.JTextField();
        guardiansLabel = new javax.swing.JLabel();
        mothersLabel = new javax.swing.JLabel();
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
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        addButton1 = new javax.swing.JButton();
        updateButton1 = new javax.swing.JButton();
        clearButton1 = new javax.swing.JButton();
        backButton1 = new javax.swing.JButton();
        saveButton1 = new javax.swing.JButton();
        deleteButton1 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        addButton2 = new javax.swing.JButton();
        updateButton2 = new javax.swing.JButton();
        clearButton2 = new javax.swing.JButton();
        backButton2 = new javax.swing.JButton();
        saveButton2 = new javax.swing.JButton();
        deleteButton2 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        addButton3 = new javax.swing.JButton();
        updateButton3 = new javax.swing.JButton();
        clearButton3 = new javax.swing.JButton();
        backButton3 = new javax.swing.JButton();
        saveButton3 = new javax.swing.JButton();
        deleteButton3 = new javax.swing.JButton();
        wingLabel = new javax.swing.JLabel();
        classLabel = new javax.swing.JLabel();
        classWingComboBox = new javax.swing.JComboBox();
        promotionClassComboBox = new javax.swing.JComboBox();
        sectionLabel5 = new javax.swing.JLabel();
        searchLabel = new javax.swing.JLabel();
        searchTextField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        fathersCnicTextField = new javax.swing.JTextField();
        guardiansRelationshipLabel = new javax.swing.JLabel();
        guardiansRelationshipTextField = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        addButton4 = new javax.swing.JButton();
        updateButton4 = new javax.swing.JButton();
        clearButton4 = new javax.swing.JButton();
        backButton4 = new javax.swing.JButton();
        saveButton4 = new javax.swing.JButton();
        deleteButton4 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        addButton5 = new javax.swing.JButton();
        updateButton5 = new javax.swing.JButton();
        clearButton5 = new javax.swing.JButton();
        backButton5 = new javax.swing.JButton();
        saveButton5 = new javax.swing.JButton();
        deleteButton5 = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        addButton6 = new javax.swing.JButton();
        updateButton6 = new javax.swing.JButton();
        clearButton6 = new javax.swing.JButton();
        backButton6 = new javax.swing.JButton();
        saveButton6 = new javax.swing.JButton();
        deleteButton6 = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        addButton7 = new javax.swing.JButton();
        updateButton7 = new javax.swing.JButton();
        clearButton7 = new javax.swing.JButton();
        backButton7 = new javax.swing.JButton();
        saveButton7 = new javax.swing.JButton();
        deleteButton7 = new javax.swing.JButton();
        printButton = new javax.swing.JButton();
        pasteButton = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        addButton8 = new javax.swing.JButton();
        updateButton8 = new javax.swing.JButton();
        clearButton8 = new javax.swing.JButton();
        backButton8 = new javax.swing.JButton();
        saveButton8 = new javax.swing.JButton();
        deleteButton8 = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        addButton9 = new javax.swing.JButton();
        updateButton9 = new javax.swing.JButton();
        clearButton9 = new javax.swing.JButton();
        backButton9 = new javax.swing.JButton();
        saveButton9 = new javax.swing.JButton();
        deleteButton9 = new javax.swing.JButton();
        jPanel16 = new javax.swing.JPanel();
        addButton10 = new javax.swing.JButton();
        updateButton10 = new javax.swing.JButton();
        clearButton10 = new javax.swing.JButton();
        backButton10 = new javax.swing.JButton();
        saveButton10 = new javax.swing.JButton();
        deleteButton10 = new javax.swing.JButton();
        sessionComboBox = new javax.swing.JComboBox();
        sectionLabel3 = new javax.swing.JLabel();
        sectionLabel = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        addButton11 = new javax.swing.JButton();
        updateButton11 = new javax.swing.JButton();
        clearButton11 = new javax.swing.JButton();
        backButton11 = new javax.swing.JButton();
        saveButton11 = new javax.swing.JButton();
        deleteButton11 = new javax.swing.JButton();
        jPanel19 = new javax.swing.JPanel();
        addButton12 = new javax.swing.JButton();
        updateButton12 = new javax.swing.JButton();
        clearButton12 = new javax.swing.JButton();
        backButton12 = new javax.swing.JButton();
        saveButton12 = new javax.swing.JButton();
        deleteButton12 = new javax.swing.JButton();
        jPanel20 = new javax.swing.JPanel();
        addButton13 = new javax.swing.JButton();
        updateButton13 = new javax.swing.JButton();
        clearButton13 = new javax.swing.JButton();
        backButton13 = new javax.swing.JButton();
        saveButton13 = new javax.swing.JButton();
        deleteButton13 = new javax.swing.JButton();
        wingLabel1 = new javax.swing.JLabel();
        classLabel1 = new javax.swing.JLabel();
        sectionLabel1 = new javax.swing.JLabel();
        sectionLabel2 = new javax.swing.JLabel();
        stdComboBox = new javax.swing.JComboBox();
        stdSectionComboBox = new javax.swing.JComboBox();
        stdClassComboBox = new javax.swing.JComboBox();
        stdWingComboBox = new javax.swing.JComboBox();
        sectionLabel6 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        addButton14 = new javax.swing.JButton();
        updateButton14 = new javax.swing.JButton();
        clearButton14 = new javax.swing.JButton();
        backButton14 = new javax.swing.JButton();
        saveButton14 = new javax.swing.JButton();
        deleteButton14 = new javax.swing.JButton();
        jPanel23 = new javax.swing.JPanel();
        addButton15 = new javax.swing.JButton();
        updateButton15 = new javax.swing.JButton();
        clearButton15 = new javax.swing.JButton();
        backButton15 = new javax.swing.JButton();
        saveButton15 = new javax.swing.JButton();
        deleteButton15 = new javax.swing.JButton();
        jPanel24 = new javax.swing.JPanel();
        addButton16 = new javax.swing.JButton();
        updateButton16 = new javax.swing.JButton();
        clearButton16 = new javax.swing.JButton();
        backButton16 = new javax.swing.JButton();
        saveButton16 = new javax.swing.JButton();
        deleteButton16 = new javax.swing.JButton();
        stdLabel = new javax.swing.JLabel();
        promotionClassIdTextField = new javax.swing.JTextField();
        remarksLabel1 = new javax.swing.JLabel();
        dobLabel = new javax.swing.JLabel();
        sectionLabel7 = new javax.swing.JLabel();
        descriptionTextField = new javax.swing.JTextField();
        nameLabel = new javax.swing.JLabel();
        promotionDateChooser = new com.toedter.calendar.JDateChooser();
        studentsLabel = new javax.swing.JLabel();
        studentsNameLabel = new javax.swing.JLabel();
        stdNameTextField = new javax.swing.JTextField();
        studentsCnicLabel = new javax.swing.JLabel();
        stdCnicTextField = new javax.swing.JTextField();
        studentsMobileLabel = new javax.swing.JLabel();
        stdMobileTextField = new javax.swing.JTextField();
        passingYearTextField = new javax.swing.JTextField();
        passingYearLabel = new javax.swing.JLabel();
        fathersOccupationLabel1 = new javax.swing.JLabel();
        dateOfAddmissionTextField = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        stdPromotionTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(2000, 1000));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titleLabel.setFont(new java.awt.Font("Ravie", 1, 57)); // NOI18N
        titleLabel.setText("PROMOTION DATABASE MANAGEMENT SYSTEM");
        jPanel1.add(titleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 70));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1890, 70));

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(15, 158, 160), 4));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fathersMobileLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        fathersMobileLabel.setText("FATHER'S MOBILE#");
        jPanel3.add(fathersMobileLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1440, 160, 170, 20));

        fathersLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        fathersLabel.setText("                               FATHER'S DETAILS");
        fathersLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 51), 4));
        jPanel3.add(fathersLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1410, 30, 440, 30));

        fathersCnicLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        fathersCnicLabel.setText("FATHER'S CNIC");
        jPanel3.add(fathersCnicLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1480, 120, 130, 20));

        fathersOccupationLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        fathersOccupationLabel.setText("FATHER'S OCCUPATION");
        jPanel3.add(fathersOccupationLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1410, 240, 200, 20));

        fathersMobileTextField.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jPanel3.add(fathersMobileTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(1630, 160, 220, -1));

        remarksTextArea.setColumns(20);
        remarksTextArea.setRows(5);
        jScrollPane2.setViewportView(remarksTextArea);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 490, 330, 70));

        fathersOccupationTextField.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jPanel3.add(fathersOccupationTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(1630, 240, 220, -1));

        guardiansLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        guardiansLabel.setText("                               GUARDIANS DETAILS");
        guardiansLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 51), 4));
        jPanel3.add(guardiansLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 300, 490, 30));

        mothersLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        mothersLabel.setText("                              MOTHER'S DETAILS");
        mothersLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 51), 4));
        jPanel3.add(mothersLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1420, 300, 430, 30));

        fathersNameTextField.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        fathersNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fathersNameTextFieldActionPerformed(evt);
            }
        });
        jPanel3.add(fathersNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(1630, 80, 220, -1));

        fathersNameLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        fathersNameLabel.setText("FATHER'S NAME");
        jPanel3.add(fathersNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1470, 80, 140, 20));

        fathersQualificationLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        fathersQualificationLabel.setText("FATHER'S QUALIFICATION");
        jPanel3.add(fathersQualificationLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1390, 200, 230, 20));

        fathersQualicationTextField.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jPanel3.add(fathersQualicationTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(1630, 200, 220, -1));

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
        jPanel3.add(mothersCnicLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1470, 390, 140, 20));

        mothersQualificationLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        mothersQualificationLabel.setText("MOTHER'S QUALIFICATION");
        jPanel3.add(mothersQualificationLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1390, 470, 230, 20));

        mothersMobileTextField.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jPanel3.add(mothersMobileTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(1630, 430, 220, -1));

        mothersOccupationTextField.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jPanel3.add(mothersOccupationTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(1630, 510, 220, -1));

        mothersNameLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        mothersNameLabel.setText("MOTHER'S NAME");
        jPanel3.add(mothersNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1470, 350, 140, 20));

        mothersCnicTextField.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jPanel3.add(mothersCnicTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(1630, 390, 220, -1));

        mothersOccupationLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        mothersOccupationLabel.setText("MOTHER'S OCCUPATION");
        jPanel3.add(mothersOccupationLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 510, 210, 20));

        mothersQualificationTextField.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jPanel3.add(mothersQualificationTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(1630, 470, 220, -1));

        mothersNameTextField.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jPanel3.add(mothersNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(1630, 350, 220, -1));

        mothersMobileLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        mothersMobileLabel.setText("MOTHER'S MOBILE#");
        jPanel3.add(mothersMobileLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1440, 430, 170, 20));

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(15, 158, 160), 4));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(15, 158, 160), 4));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addButton1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        addButton1.setText("ADD NEW");
        addButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButton1ActionPerformed(evt);
            }
        });
        jPanel6.add(addButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, 50));

        updateButton1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        updateButton1.setText("UPDATE");
        updateButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButton1ActionPerformed(evt);
            }
        });
        jPanel6.add(updateButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 130, 50));

        clearButton1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        clearButton1.setText("CLEAR");
        clearButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButton1ActionPerformed(evt);
            }
        });
        jPanel6.add(clearButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 130, 50));

        backButton1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        backButton1.setText("BACK");
        backButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButton1ActionPerformed(evt);
            }
        });
        jPanel6.add(backButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, 120, 50));

        saveButton1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        saveButton1.setText("SAVE");
        saveButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButton1ActionPerformed(evt);
            }
        });
        jPanel6.add(saveButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 120, 50));

        deleteButton1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        deleteButton1.setText("DELETE");
        deleteButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButton1ActionPerformed(evt);
            }
        });
        jPanel6.add(deleteButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 120, 50));

        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1410, 280, 410, 130));

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(15, 158, 160), 4));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addButton2.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        addButton2.setText("ADD NEW");
        addButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButton2ActionPerformed(evt);
            }
        });
        jPanel7.add(addButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, 50));

        updateButton2.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        updateButton2.setText("UPDATE");
        updateButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButton2ActionPerformed(evt);
            }
        });
        jPanel7.add(updateButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 130, 50));

        clearButton2.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        clearButton2.setText("CLEAR");
        clearButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButton2ActionPerformed(evt);
            }
        });
        jPanel7.add(clearButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 130, 50));

        backButton2.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        backButton2.setText("BACK");
        backButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButton2ActionPerformed(evt);
            }
        });
        jPanel7.add(backButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, 120, 50));

        saveButton2.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        saveButton2.setText("SAVE");
        saveButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButton2ActionPerformed(evt);
            }
        });
        jPanel7.add(saveButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 120, 50));

        deleteButton2.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        deleteButton2.setText("DELETE");
        deleteButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButton2ActionPerformed(evt);
            }
        });
        jPanel7.add(deleteButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 120, 50));

        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(15, 158, 160), 4));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addButton3.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        addButton3.setText("ADD NEW");
        addButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButton3ActionPerformed(evt);
            }
        });
        jPanel8.add(addButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, 50));

        updateButton3.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        updateButton3.setText("UPDATE");
        updateButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButton3ActionPerformed(evt);
            }
        });
        jPanel8.add(updateButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 130, 50));

        clearButton3.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        clearButton3.setText("CLEAR");
        clearButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButton3ActionPerformed(evt);
            }
        });
        jPanel8.add(clearButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 130, 50));

        backButton3.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        backButton3.setText("BACK");
        backButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButton3ActionPerformed(evt);
            }
        });
        jPanel8.add(backButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, 120, 50));

        saveButton3.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        saveButton3.setText("SAVE");
        saveButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButton3ActionPerformed(evt);
            }
        });
        jPanel8.add(saveButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 120, 50));

        deleteButton3.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        deleteButton3.setText("DELETE");
        deleteButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButton3ActionPerformed(evt);
            }
        });
        jPanel8.add(deleteButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 120, 50));

        jPanel7.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1410, 280, 410, 130));

        jPanel5.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1430, 280, 410, 130));

        wingLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        wingLabel.setText("WING");
        jPanel5.add(wingLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, 30));

        classLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        classLabel.setText("CLASS");
        jPanel5.add(classLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, 30));

        classWingComboBox.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        classWingComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                classWingComboBoxActionPerformed(evt);
            }
        });
        jPanel5.add(classWingComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 150, 30));

        promotionClassComboBox.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        promotionClassComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                promotionClassComboBoxActionPerformed(evt);
            }
        });
        jPanel5.add(promotionClassComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 150, 30));

        sectionLabel5.setFont(new java.awt.Font("Stencil", 1, 19)); // NOI18N
        sectionLabel5.setForeground(new java.awt.Color(0, 153, 153));
        sectionLabel5.setText("SELECT CLASS FOR PROMOTION");
        jPanel5.add(sectionLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 20));

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 330, 110));

        searchLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        searchLabel.setText("ENTER NAME OF STUDENT");
        jPanel3.add(searchLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 460, -1, 30));

        searchTextField.setText("SEARCH");
        searchTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTextFieldActionPerformed(evt);
            }
        });
        jPanel3.add(searchTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 490, 300, 30));

        searchButton.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        searchButton.setText("SEARCH");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });
        jPanel3.add(searchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 530, 130, 30));

        fathersCnicTextField.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        fathersCnicTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fathersCnicTextFieldActionPerformed(evt);
            }
        });
        jPanel3.add(fathersCnicTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(1630, 120, 220, -1));

        guardiansRelationshipLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        guardiansRelationshipLabel.setText("GUARDIAN'S RELATIONSHIP");
        jPanel3.add(guardiansRelationshipLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 540, 240, 20));

        guardiansRelationshipTextField.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jPanel3.add(guardiansRelationshipTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 540, 220, -1));

        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(15, 158, 160), 4));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addButton4.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        addButton4.setText("ADD NEW");
        addButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButton4ActionPerformed(evt);
            }
        });
        jPanel9.add(addButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, 60));

        updateButton4.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        updateButton4.setText("UPDATE");
        updateButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButton4ActionPerformed(evt);
            }
        });
        jPanel9.add(updateButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 130, 60));

        clearButton4.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        clearButton4.setText("CLEAR");
        clearButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButton4ActionPerformed(evt);
            }
        });
        jPanel9.add(clearButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 130, 60));

        backButton4.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        backButton4.setText("BACK");
        backButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButton4ActionPerformed(evt);
            }
        });
        jPanel9.add(backButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 120, 60));

        saveButton4.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        saveButton4.setText("SAVE");
        saveButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButton4ActionPerformed(evt);
            }
        });
        jPanel9.add(saveButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 120, 60));

        deleteButton4.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        deleteButton4.setText("DELETE");
        deleteButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButton4ActionPerformed(evt);
            }
        });
        jPanel9.add(deleteButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 130, 60));

        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(15, 158, 160), 4));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addButton5.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        addButton5.setText("ADD NEW");
        addButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButton5ActionPerformed(evt);
            }
        });
        jPanel10.add(addButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, 50));

        updateButton5.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        updateButton5.setText("UPDATE");
        updateButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButton5ActionPerformed(evt);
            }
        });
        jPanel10.add(updateButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 130, 50));

        clearButton5.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        clearButton5.setText("CLEAR");
        clearButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButton5ActionPerformed(evt);
            }
        });
        jPanel10.add(clearButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 130, 50));

        backButton5.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        backButton5.setText("BACK");
        backButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButton5ActionPerformed(evt);
            }
        });
        jPanel10.add(backButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, 120, 50));

        saveButton5.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        saveButton5.setText("SAVE");
        saveButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButton5ActionPerformed(evt);
            }
        });
        jPanel10.add(saveButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 120, 50));

        deleteButton5.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        deleteButton5.setText("DELETE");
        deleteButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButton5ActionPerformed(evt);
            }
        });
        jPanel10.add(deleteButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 120, 50));

        jPanel9.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1410, 280, 410, 130));

        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(15, 158, 160), 4));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addButton6.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        addButton6.setText("ADD NEW");
        addButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButton6ActionPerformed(evt);
            }
        });
        jPanel11.add(addButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, 50));

        updateButton6.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        updateButton6.setText("UPDATE");
        updateButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButton6ActionPerformed(evt);
            }
        });
        jPanel11.add(updateButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 130, 50));

        clearButton6.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        clearButton6.setText("CLEAR");
        clearButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButton6ActionPerformed(evt);
            }
        });
        jPanel11.add(clearButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 130, 50));

        backButton6.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        backButton6.setText("BACK");
        backButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButton6ActionPerformed(evt);
            }
        });
        jPanel11.add(backButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, 120, 50));

        saveButton6.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        saveButton6.setText("SAVE");
        saveButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButton6ActionPerformed(evt);
            }
        });
        jPanel11.add(saveButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 120, 50));

        deleteButton6.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        deleteButton6.setText("DELETE");
        deleteButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButton6ActionPerformed(evt);
            }
        });
        jPanel11.add(deleteButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 120, 50));

        jPanel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(15, 158, 160), 4));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addButton7.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        addButton7.setText("ADD NEW");
        addButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButton7ActionPerformed(evt);
            }
        });
        jPanel12.add(addButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, 50));

        updateButton7.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        updateButton7.setText("UPDATE");
        updateButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButton7ActionPerformed(evt);
            }
        });
        jPanel12.add(updateButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 130, 50));

        clearButton7.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        clearButton7.setText("CLEAR");
        clearButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButton7ActionPerformed(evt);
            }
        });
        jPanel12.add(clearButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 130, 50));

        backButton7.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        backButton7.setText("BACK");
        backButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButton7ActionPerformed(evt);
            }
        });
        jPanel12.add(backButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, 120, 50));

        saveButton7.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        saveButton7.setText("SAVE");
        saveButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButton7ActionPerformed(evt);
            }
        });
        jPanel12.add(saveButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 120, 50));

        deleteButton7.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        deleteButton7.setText("DELETE");
        deleteButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButton7ActionPerformed(evt);
            }
        });
        jPanel12.add(deleteButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 120, 50));

        jPanel11.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1410, 280, 410, 130));

        jPanel9.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1430, 280, 410, 130));

        printButton.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        printButton.setText("PRINT");
        printButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printButtonActionPerformed(evt);
            }
        });
        jPanel9.add(printButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 120, 90));

        pasteButton.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        pasteButton.setText("PASTE");
        pasteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pasteButtonActionPerformed(evt);
            }
        });
        jPanel9.add(pasteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 130, 90));

        jPanel3.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 130, 280, 320));

        jPanel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(15, 158, 160), 4));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(15, 158, 160), 4));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addButton8.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        addButton8.setText("ADD NEW");
        addButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButton8ActionPerformed(evt);
            }
        });
        jPanel14.add(addButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, 50));

        updateButton8.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        updateButton8.setText("UPDATE");
        updateButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButton8ActionPerformed(evt);
            }
        });
        jPanel14.add(updateButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 130, 50));

        clearButton8.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        clearButton8.setText("CLEAR");
        clearButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButton8ActionPerformed(evt);
            }
        });
        jPanel14.add(clearButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 130, 50));

        backButton8.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        backButton8.setText("BACK");
        backButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButton8ActionPerformed(evt);
            }
        });
        jPanel14.add(backButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, 120, 50));

        saveButton8.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        saveButton8.setText("SAVE");
        saveButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButton8ActionPerformed(evt);
            }
        });
        jPanel14.add(saveButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 120, 50));

        deleteButton8.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        deleteButton8.setText("DELETE");
        deleteButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButton8ActionPerformed(evt);
            }
        });
        jPanel14.add(deleteButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 120, 50));

        jPanel13.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(1410, 280, 410, 130));

        jPanel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(15, 158, 160), 4));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addButton9.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        addButton9.setText("ADD NEW");
        addButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButton9ActionPerformed(evt);
            }
        });
        jPanel15.add(addButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, 50));

        updateButton9.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        updateButton9.setText("UPDATE");
        updateButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButton9ActionPerformed(evt);
            }
        });
        jPanel15.add(updateButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 130, 50));

        clearButton9.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        clearButton9.setText("CLEAR");
        clearButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButton9ActionPerformed(evt);
            }
        });
        jPanel15.add(clearButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 130, 50));

        backButton9.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        backButton9.setText("BACK");
        backButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButton9ActionPerformed(evt);
            }
        });
        jPanel15.add(backButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, 120, 50));

        saveButton9.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        saveButton9.setText("SAVE");
        saveButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButton9ActionPerformed(evt);
            }
        });
        jPanel15.add(saveButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 120, 50));

        deleteButton9.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        deleteButton9.setText("DELETE");
        deleteButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButton9ActionPerformed(evt);
            }
        });
        jPanel15.add(deleteButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 120, 50));

        jPanel16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(15, 158, 160), 4));
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addButton10.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        addButton10.setText("ADD NEW");
        addButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButton10ActionPerformed(evt);
            }
        });
        jPanel16.add(addButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, 50));

        updateButton10.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        updateButton10.setText("UPDATE");
        updateButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButton10ActionPerformed(evt);
            }
        });
        jPanel16.add(updateButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 130, 50));

        clearButton10.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        clearButton10.setText("CLEAR");
        clearButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButton10ActionPerformed(evt);
            }
        });
        jPanel16.add(clearButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 130, 50));

        backButton10.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        backButton10.setText("BACK");
        backButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButton10ActionPerformed(evt);
            }
        });
        jPanel16.add(backButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, 120, 50));

        saveButton10.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        saveButton10.setText("SAVE");
        saveButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButton10ActionPerformed(evt);
            }
        });
        jPanel16.add(saveButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 120, 50));

        deleteButton10.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        deleteButton10.setText("DELETE");
        deleteButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButton10ActionPerformed(evt);
            }
        });
        jPanel16.add(deleteButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 120, 50));

        jPanel15.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(1410, 280, 410, 130));

        jPanel13.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(1430, 280, 410, 130));

        sessionComboBox.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        sessionComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sessionComboBoxActionPerformed(evt);
            }
        });
        jPanel13.add(sessionComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 390, 30));

        sectionLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        sectionLabel3.setText("SESSION");
        jPanel13.add(sectionLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, 30));

        sectionLabel.setFont(new java.awt.Font("Stencil", 1, 19)); // NOI18N
        sectionLabel.setForeground(new java.awt.Color(0, 153, 153));
        sectionLabel.setText("SELECT SESSION FOR PROMOTION");
        jPanel13.add(sectionLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, 30));

        jPanel3.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, 510, 110));

        jPanel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(15, 158, 160), 4));
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(15, 158, 160), 4));
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addButton11.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        addButton11.setText("ADD NEW");
        addButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButton11ActionPerformed(evt);
            }
        });
        jPanel18.add(addButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, 50));

        updateButton11.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        updateButton11.setText("UPDATE");
        updateButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButton11ActionPerformed(evt);
            }
        });
        jPanel18.add(updateButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 130, 50));

        clearButton11.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        clearButton11.setText("CLEAR");
        clearButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButton11ActionPerformed(evt);
            }
        });
        jPanel18.add(clearButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 130, 50));

        backButton11.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        backButton11.setText("BACK");
        backButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButton11ActionPerformed(evt);
            }
        });
        jPanel18.add(backButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, 120, 50));

        saveButton11.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        saveButton11.setText("SAVE");
        saveButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButton11ActionPerformed(evt);
            }
        });
        jPanel18.add(saveButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 120, 50));

        deleteButton11.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        deleteButton11.setText("DELETE");
        deleteButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButton11ActionPerformed(evt);
            }
        });
        jPanel18.add(deleteButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 120, 50));

        jPanel17.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(1410, 280, 410, 130));

        jPanel19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(15, 158, 160), 4));
        jPanel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addButton12.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        addButton12.setText("ADD NEW");
        addButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButton12ActionPerformed(evt);
            }
        });
        jPanel19.add(addButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, 50));

        updateButton12.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        updateButton12.setText("UPDATE");
        updateButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButton12ActionPerformed(evt);
            }
        });
        jPanel19.add(updateButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 130, 50));

        clearButton12.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        clearButton12.setText("CLEAR");
        clearButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButton12ActionPerformed(evt);
            }
        });
        jPanel19.add(clearButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 130, 50));

        backButton12.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        backButton12.setText("BACK");
        backButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButton12ActionPerformed(evt);
            }
        });
        jPanel19.add(backButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, 120, 50));

        saveButton12.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        saveButton12.setText("SAVE");
        saveButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButton12ActionPerformed(evt);
            }
        });
        jPanel19.add(saveButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 120, 50));

        deleteButton12.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        deleteButton12.setText("DELETE");
        deleteButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButton12ActionPerformed(evt);
            }
        });
        jPanel19.add(deleteButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 120, 50));

        jPanel20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(15, 158, 160), 4));
        jPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addButton13.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        addButton13.setText("ADD NEW");
        addButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButton13ActionPerformed(evt);
            }
        });
        jPanel20.add(addButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, 50));

        updateButton13.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        updateButton13.setText("UPDATE");
        updateButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButton13ActionPerformed(evt);
            }
        });
        jPanel20.add(updateButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 130, 50));

        clearButton13.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        clearButton13.setText("CLEAR");
        clearButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButton13ActionPerformed(evt);
            }
        });
        jPanel20.add(clearButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 130, 50));

        backButton13.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        backButton13.setText("BACK");
        backButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButton13ActionPerformed(evt);
            }
        });
        jPanel20.add(backButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, 120, 50));

        saveButton13.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        saveButton13.setText("SAVE");
        saveButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButton13ActionPerformed(evt);
            }
        });
        jPanel20.add(saveButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 120, 50));

        deleteButton13.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        deleteButton13.setText("DELETE");
        deleteButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButton13ActionPerformed(evt);
            }
        });
        jPanel20.add(deleteButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 120, 50));

        jPanel19.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(1410, 280, 410, 130));

        jPanel17.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(1430, 280, 410, 130));

        wingLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        wingLabel1.setText("WING");
        jPanel17.add(wingLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, 30));

        classLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        classLabel1.setText("CLASS");
        jPanel17.add(classLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, 30));

        sectionLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        sectionLabel1.setText("SECTIONS");
        jPanel17.add(sectionLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, 30));

        sectionLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        sectionLabel2.setText("STUDENTS");
        jPanel17.add(sectionLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, 30));

        stdComboBox.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        stdComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stdComboBoxActionPerformed(evt);
            }
        });
        jPanel17.add(stdComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 430, 30));

        stdSectionComboBox.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        stdSectionComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stdSectionComboBoxActionPerformed(evt);
            }
        });
        jPanel17.add(stdSectionComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 150, 30));

        stdClassComboBox.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        stdClassComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stdClassComboBoxActionPerformed(evt);
            }
        });
        jPanel17.add(stdClassComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 150, 30));

        stdWingComboBox.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        stdWingComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stdWingComboBoxActionPerformed(evt);
            }
        });
        jPanel17.add(stdWingComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 150, 30));

        sectionLabel6.setFont(new java.awt.Font("Stencil", 1, 19)); // NOI18N
        sectionLabel6.setForeground(new java.awt.Color(0, 153, 153));
        sectionLabel6.setText("SELECT STUUDENT FOR PROMOTION");
        jPanel17.add(sectionLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, 30));

        jPanel3.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 560, 190));

        jPanel21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(15, 158, 160), 4));
        jPanel21.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(15, 158, 160), 4));
        jPanel22.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addButton14.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        addButton14.setText("ADD NEW");
        addButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButton14ActionPerformed(evt);
            }
        });
        jPanel22.add(addButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, 50));

        updateButton14.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        updateButton14.setText("UPDATE");
        updateButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButton14ActionPerformed(evt);
            }
        });
        jPanel22.add(updateButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 130, 50));

        clearButton14.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        clearButton14.setText("CLEAR");
        clearButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButton14ActionPerformed(evt);
            }
        });
        jPanel22.add(clearButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 130, 50));

        backButton14.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        backButton14.setText("BACK");
        backButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButton14ActionPerformed(evt);
            }
        });
        jPanel22.add(backButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, 120, 50));

        saveButton14.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        saveButton14.setText("SAVE");
        saveButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButton14ActionPerformed(evt);
            }
        });
        jPanel22.add(saveButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 120, 50));

        deleteButton14.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        deleteButton14.setText("DELETE");
        deleteButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButton14ActionPerformed(evt);
            }
        });
        jPanel22.add(deleteButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 120, 50));

        jPanel21.add(jPanel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(1410, 280, 410, 130));

        jPanel23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(15, 158, 160), 4));
        jPanel23.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addButton15.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        addButton15.setText("ADD NEW");
        addButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButton15ActionPerformed(evt);
            }
        });
        jPanel23.add(addButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, 50));

        updateButton15.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        updateButton15.setText("UPDATE");
        updateButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButton15ActionPerformed(evt);
            }
        });
        jPanel23.add(updateButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 130, 50));

        clearButton15.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        clearButton15.setText("CLEAR");
        clearButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButton15ActionPerformed(evt);
            }
        });
        jPanel23.add(clearButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 130, 50));

        backButton15.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        backButton15.setText("BACK");
        backButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButton15ActionPerformed(evt);
            }
        });
        jPanel23.add(backButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, 120, 50));

        saveButton15.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        saveButton15.setText("SAVE");
        saveButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButton15ActionPerformed(evt);
            }
        });
        jPanel23.add(saveButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 120, 50));

        deleteButton15.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        deleteButton15.setText("DELETE");
        deleteButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButton15ActionPerformed(evt);
            }
        });
        jPanel23.add(deleteButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 120, 50));

        jPanel24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(15, 158, 160), 4));
        jPanel24.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addButton16.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        addButton16.setText("ADD NEW");
        addButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButton16ActionPerformed(evt);
            }
        });
        jPanel24.add(addButton16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, 50));

        updateButton16.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        updateButton16.setText("UPDATE");
        updateButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButton16ActionPerformed(evt);
            }
        });
        jPanel24.add(updateButton16, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 130, 50));

        clearButton16.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        clearButton16.setText("CLEAR");
        clearButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButton16ActionPerformed(evt);
            }
        });
        jPanel24.add(clearButton16, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 130, 50));

        backButton16.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        backButton16.setText("BACK");
        backButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButton16ActionPerformed(evt);
            }
        });
        jPanel24.add(backButton16, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, 120, 50));

        saveButton16.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        saveButton16.setText("SAVE");
        saveButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButton16ActionPerformed(evt);
            }
        });
        jPanel24.add(saveButton16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 120, 50));

        deleteButton16.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        deleteButton16.setText("DELETE");
        deleteButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButton16ActionPerformed(evt);
            }
        });
        jPanel24.add(deleteButton16, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 120, 50));

        jPanel23.add(jPanel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(1410, 280, 410, 130));

        jPanel21.add(jPanel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(1430, 280, 410, 130));

        stdLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        stdLabel.setText("PROMOTION CLASS ID");
        jPanel21.add(stdLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, 30));

        promotionClassIdTextField.setEditable(false);
        promotionClassIdTextField.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        promotionClassIdTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                promotionClassIdTextFieldActionPerformed(evt);
            }
        });
        jPanel21.add(promotionClassIdTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, 70, 30));

        remarksLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        remarksLabel1.setText("REMARKS");
        jPanel21.add(remarksLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, -1, -1));

        dobLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        dobLabel.setText("PROMOTION DATE");
        jPanel21.add(dobLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 160, 30));

        sectionLabel7.setFont(new java.awt.Font("Stencil", 1, 19)); // NOI18N
        sectionLabel7.setForeground(new java.awt.Color(0, 153, 153));
        sectionLabel7.setText("PROMOTION DETAILS");
        jPanel21.add(sectionLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, -1, 30));

        descriptionTextField.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        descriptionTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descriptionTextFieldActionPerformed(evt);
            }
        });
        jPanel21.add(descriptionTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, 330, -1));

        nameLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        nameLabel.setText("DESCRIPTION");
        jPanel21.add(nameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, -1, -1));
        jPanel21.add(promotionDateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, 160, -1));

        jPanel3.add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 560, 240));

        studentsLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        studentsLabel.setText("                               STUDENT'S DETAILS");
        studentsLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 51), 4));
        jPanel3.add(studentsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 30, 450, 30));

        studentsNameLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        studentsNameLabel.setText("STUDENT'S NAME");
        jPanel3.add(studentsNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 80, 150, 20));

        stdNameTextField.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        stdNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stdNameTextFieldActionPerformed(evt);
            }
        });
        jPanel3.add(stdNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 80, 220, -1));

        studentsCnicLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        studentsCnicLabel.setText("STUDENT'S CNIC");
        jPanel3.add(studentsCnicLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 120, 150, -1));

        stdCnicTextField.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        stdCnicTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stdCnicTextFieldActionPerformed(evt);
            }
        });
        jPanel3.add(stdCnicTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 120, 220, -1));

        studentsMobileLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        studentsMobileLabel.setText("STUDENT'S MOBILE#");
        jPanel3.add(studentsMobileLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 160, 180, -1));

        stdMobileTextField.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jPanel3.add(stdMobileTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 160, 220, -1));

        passingYearTextField.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jPanel3.add(passingYearTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 200, 220, -1));

        passingYearLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        passingYearLabel.setText("PASSING YEAR");
        jPanel3.add(passingYearLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 200, 130, 20));

        fathersOccupationLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        fathersOccupationLabel1.setText("DATE OF ADDMISSION");
        jPanel3.add(fathersOccupationLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 240, 190, 20));

        dateOfAddmissionTextField.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jPanel3.add(dateOfAddmissionTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 240, 220, -1));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1880, 580));

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(15, 158, 160), 4));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        stdPromotionTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CLASS ID", "STD ID", "SESSION ID", "PROMONTION CLASS ID", "DESCRIPTION", "PROMOTION DATE", "REMARKS"
            }
        ));
        stdPromotionTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stdPromotionTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(stdPromotionTable);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1860, 260));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 600, 1880, 280));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 1900, 890));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void stdPromotionTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stdPromotionTableMouseClicked
     int row =stdPromotionTable.getSelectedRow();
     String proClassId=stdPromotionTable.getModel().getValueAt(row, 3).toString();
             
     StudentPromotionBean bean=DatabaseManager.getClassPromotionById(proClassId);
     
            promotionClassIdTextField.setText(""+bean.getProClassId());
            descriptionTextField.setText(bean.getDescription());
            promotionDateChooser.setDate(bean.getPromotionDate());
            remarksTextArea.setText(bean.getRemarks());     
     
            stdNameTextField.setText(bean.getName());
           
            stdCnicTextField.setText(bean.getStdCnic());
         
             
            
            stdMobileTextField.setText(bean.getStdMobile());
            dateOfAddmissionTextField.setText(""+bean.getDateOfAddmission());
            
            passingYearTextField.setText(bean.getPassingYear());
            
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

    }//GEN-LAST:event_stdPromotionTableMouseClicked

    private void fathersCnicTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fathersCnicTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fathersCnicTextFieldActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchButtonActionPerformed

    private void searchTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTextFieldActionPerformed

    private void printButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_printButtonActionPerformed

    private void fathersNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fathersNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fathersNameTextFieldActionPerformed

    private void descriptionTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descriptionTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_descriptionTextFieldActionPerformed

    private void promotionClassComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_promotionClassComboBoxActionPerformed
      getStudentPromotion();
    }//GEN-LAST:event_promotionClassComboBoxActionPerformed

    private void classWingComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_classWingComboBoxActionPerformed
        getClasss();
    }//GEN-LAST:event_classWingComboBoxActionPerformed

    private void sessionComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sessionComboBoxActionPerformed
       // getStudent();
    }//GEN-LAST:event_sessionComboBoxActionPerformed

    private void stdWingComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stdWingComboBoxActionPerformed
        getStdClasss();
    }//GEN-LAST:event_stdWingComboBoxActionPerformed

    private void stdClassComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stdClassComboBoxActionPerformed
     getSection();
    }//GEN-LAST:event_stdClassComboBoxActionPerformed

    private void stdSectionComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stdSectionComboBoxActionPerformed
        getStudent();
    }//GEN-LAST:event_stdSectionComboBoxActionPerformed

    private void stdComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stdComboBoxActionPerformed
        getStudentPromotion();
    }//GEN-LAST:event_stdComboBoxActionPerformed

    private void addButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addButton1ActionPerformed

    private void updateButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateButton1ActionPerformed

    private void clearButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clearButton1ActionPerformed

    private void backButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_backButton1ActionPerformed

    private void saveButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saveButton1ActionPerformed

    private void deleteButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteButton1ActionPerformed

    private void addButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addButton2ActionPerformed

    private void updateButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateButton2ActionPerformed

    private void clearButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clearButton2ActionPerformed

    private void backButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_backButton2ActionPerformed

    private void saveButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saveButton2ActionPerformed

    private void deleteButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteButton2ActionPerformed

    private void addButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addButton3ActionPerformed

    private void updateButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateButton3ActionPerformed

    private void clearButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clearButton3ActionPerformed

    private void backButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_backButton3ActionPerformed

    private void saveButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saveButton3ActionPerformed

    private void deleteButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteButton3ActionPerformed

    private void addButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButton4ActionPerformed
        addStudentPromotion();
    }//GEN-LAST:event_addButton4ActionPerformed

    private void updateButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButton4ActionPerformed
        updateStudentPromotion();
    }//GEN-LAST:event_updateButton4ActionPerformed

    private void clearButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clearButton4ActionPerformed

    private void backButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_backButton4ActionPerformed

    private void saveButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saveButton4ActionPerformed

    private void deleteButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButton4ActionPerformed
       deleteStudentPromotion();
    }//GEN-LAST:event_deleteButton4ActionPerformed

    private void addButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addButton5ActionPerformed

    private void updateButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateButton5ActionPerformed

    private void clearButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clearButton5ActionPerformed

    private void backButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_backButton5ActionPerformed

    private void saveButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saveButton5ActionPerformed

    private void deleteButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteButton5ActionPerformed

    private void addButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addButton6ActionPerformed

    private void updateButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateButton6ActionPerformed

    private void clearButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clearButton6ActionPerformed

    private void backButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_backButton6ActionPerformed

    private void saveButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saveButton6ActionPerformed

    private void deleteButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteButton6ActionPerformed

    private void addButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addButton7ActionPerformed

    private void updateButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateButton7ActionPerformed

    private void clearButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clearButton7ActionPerformed

    private void backButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_backButton7ActionPerformed

    private void saveButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saveButton7ActionPerformed

    private void deleteButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteButton7ActionPerformed

    private void addButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addButton8ActionPerformed

    private void updateButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateButton8ActionPerformed

    private void clearButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clearButton8ActionPerformed

    private void backButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_backButton8ActionPerformed

    private void saveButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saveButton8ActionPerformed

    private void deleteButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteButton8ActionPerformed

    private void addButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButton9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addButton9ActionPerformed

    private void updateButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButton9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateButton9ActionPerformed

    private void clearButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButton9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clearButton9ActionPerformed

    private void backButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButton9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_backButton9ActionPerformed

    private void saveButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButton9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saveButton9ActionPerformed

    private void deleteButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButton9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteButton9ActionPerformed

    private void addButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButton10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addButton10ActionPerformed

    private void updateButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButton10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateButton10ActionPerformed

    private void clearButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButton10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clearButton10ActionPerformed

    private void backButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButton10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_backButton10ActionPerformed

    private void saveButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButton10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saveButton10ActionPerformed

    private void deleteButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButton10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteButton10ActionPerformed

    private void addButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButton11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addButton11ActionPerformed

    private void updateButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButton11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateButton11ActionPerformed

    private void clearButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButton11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clearButton11ActionPerformed

    private void backButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButton11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_backButton11ActionPerformed

    private void saveButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButton11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saveButton11ActionPerformed

    private void deleteButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButton11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteButton11ActionPerformed

    private void addButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButton12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addButton12ActionPerformed

    private void updateButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButton12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateButton12ActionPerformed

    private void clearButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButton12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clearButton12ActionPerformed

    private void backButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButton12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_backButton12ActionPerformed

    private void saveButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButton12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saveButton12ActionPerformed

    private void deleteButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButton12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteButton12ActionPerformed

    private void addButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButton13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addButton13ActionPerformed

    private void updateButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButton13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateButton13ActionPerformed

    private void clearButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButton13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clearButton13ActionPerformed

    private void backButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButton13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_backButton13ActionPerformed

    private void saveButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButton13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saveButton13ActionPerformed

    private void deleteButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButton13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteButton13ActionPerformed

    private void addButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButton14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addButton14ActionPerformed

    private void updateButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButton14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateButton14ActionPerformed

    private void clearButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButton14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clearButton14ActionPerformed

    private void backButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButton14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_backButton14ActionPerformed

    private void saveButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButton14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saveButton14ActionPerformed

    private void deleteButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButton14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteButton14ActionPerformed

    private void addButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButton15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addButton15ActionPerformed

    private void updateButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButton15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateButton15ActionPerformed

    private void clearButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButton15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clearButton15ActionPerformed

    private void backButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButton15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_backButton15ActionPerformed

    private void saveButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButton15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saveButton15ActionPerformed

    private void deleteButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButton15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteButton15ActionPerformed

    private void addButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButton16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addButton16ActionPerformed

    private void updateButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButton16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateButton16ActionPerformed

    private void clearButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButton16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clearButton16ActionPerformed

    private void backButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButton16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_backButton16ActionPerformed

    private void saveButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButton16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saveButton16ActionPerformed

    private void deleteButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButton16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteButton16ActionPerformed

    private void promotionClassIdTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_promotionClassIdTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_promotionClassIdTextFieldActionPerformed

    private void pasteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pasteButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pasteButtonActionPerformed

    private void stdNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stdNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stdNameTextFieldActionPerformed

    private void stdCnicTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stdCnicTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stdCnicTextFieldActionPerformed
 

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
            java.util.logging.Logger.getLogger(PromotionClassFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PromotionClassFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PromotionClassFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PromotionClassFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PromotionClassFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton1;
    private javax.swing.JButton addButton10;
    private javax.swing.JButton addButton11;
    private javax.swing.JButton addButton12;
    private javax.swing.JButton addButton13;
    private javax.swing.JButton addButton14;
    private javax.swing.JButton addButton15;
    private javax.swing.JButton addButton16;
    private javax.swing.JButton addButton2;
    private javax.swing.JButton addButton3;
    private javax.swing.JButton addButton4;
    private javax.swing.JButton addButton5;
    private javax.swing.JButton addButton6;
    private javax.swing.JButton addButton7;
    private javax.swing.JButton addButton8;
    private javax.swing.JButton addButton9;
    private javax.swing.JButton backButton1;
    private javax.swing.JButton backButton10;
    private javax.swing.JButton backButton11;
    private javax.swing.JButton backButton12;
    private javax.swing.JButton backButton13;
    private javax.swing.JButton backButton14;
    private javax.swing.JButton backButton15;
    private javax.swing.JButton backButton16;
    private javax.swing.JButton backButton2;
    private javax.swing.JButton backButton3;
    private javax.swing.JButton backButton4;
    private javax.swing.JButton backButton5;
    private javax.swing.JButton backButton6;
    private javax.swing.JButton backButton7;
    private javax.swing.JButton backButton8;
    private javax.swing.JButton backButton9;
    private javax.swing.JLabel classLabel;
    private javax.swing.JLabel classLabel1;
    private javax.swing.JComboBox classWingComboBox;
    private javax.swing.JButton clearButton1;
    private javax.swing.JButton clearButton10;
    private javax.swing.JButton clearButton11;
    private javax.swing.JButton clearButton12;
    private javax.swing.JButton clearButton13;
    private javax.swing.JButton clearButton14;
    private javax.swing.JButton clearButton15;
    private javax.swing.JButton clearButton16;
    private javax.swing.JButton clearButton2;
    private javax.swing.JButton clearButton3;
    private javax.swing.JButton clearButton4;
    private javax.swing.JButton clearButton5;
    private javax.swing.JButton clearButton6;
    private javax.swing.JButton clearButton7;
    private javax.swing.JButton clearButton8;
    private javax.swing.JButton clearButton9;
    private javax.swing.JTextField dateOfAddmissionTextField;
    private javax.swing.JButton deleteButton1;
    private javax.swing.JButton deleteButton10;
    private javax.swing.JButton deleteButton11;
    private javax.swing.JButton deleteButton12;
    private javax.swing.JButton deleteButton13;
    private javax.swing.JButton deleteButton14;
    private javax.swing.JButton deleteButton15;
    private javax.swing.JButton deleteButton16;
    private javax.swing.JButton deleteButton2;
    private javax.swing.JButton deleteButton3;
    private javax.swing.JButton deleteButton4;
    private javax.swing.JButton deleteButton5;
    private javax.swing.JButton deleteButton6;
    private javax.swing.JButton deleteButton7;
    private javax.swing.JButton deleteButton8;
    private javax.swing.JButton deleteButton9;
    private javax.swing.JTextField descriptionTextField;
    private javax.swing.JLabel dobLabel;
    private javax.swing.JLabel fathersCnicLabel;
    private javax.swing.JTextField fathersCnicTextField;
    private javax.swing.JLabel fathersLabel;
    private javax.swing.JLabel fathersMobileLabel;
    private javax.swing.JTextField fathersMobileTextField;
    private javax.swing.JLabel fathersNameLabel;
    private javax.swing.JTextField fathersNameTextField;
    private javax.swing.JLabel fathersOccupationLabel;
    private javax.swing.JLabel fathersOccupationLabel1;
    private javax.swing.JTextField fathersOccupationTextField;
    private javax.swing.JTextField fathersQualicationTextField;
    private javax.swing.JLabel fathersQualificationLabel;
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
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
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
    private javax.swing.JLabel passingYearLabel;
    private javax.swing.JTextField passingYearTextField;
    private javax.swing.JButton pasteButton;
    private javax.swing.JButton printButton;
    private javax.swing.JComboBox promotionClassComboBox;
    private javax.swing.JTextField promotionClassIdTextField;
    private com.toedter.calendar.JDateChooser promotionDateChooser;
    private javax.swing.JLabel remarksLabel1;
    private javax.swing.JTextArea remarksTextArea;
    private javax.swing.JButton saveButton1;
    private javax.swing.JButton saveButton10;
    private javax.swing.JButton saveButton11;
    private javax.swing.JButton saveButton12;
    private javax.swing.JButton saveButton13;
    private javax.swing.JButton saveButton14;
    private javax.swing.JButton saveButton15;
    private javax.swing.JButton saveButton16;
    private javax.swing.JButton saveButton2;
    private javax.swing.JButton saveButton3;
    private javax.swing.JButton saveButton4;
    private javax.swing.JButton saveButton5;
    private javax.swing.JButton saveButton6;
    private javax.swing.JButton saveButton7;
    private javax.swing.JButton saveButton8;
    private javax.swing.JButton saveButton9;
    private javax.swing.JButton searchButton;
    private javax.swing.JLabel searchLabel;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JLabel sectionLabel;
    private javax.swing.JLabel sectionLabel1;
    private javax.swing.JLabel sectionLabel2;
    private javax.swing.JLabel sectionLabel3;
    private javax.swing.JLabel sectionLabel5;
    private javax.swing.JLabel sectionLabel6;
    private javax.swing.JLabel sectionLabel7;
    private javax.swing.JComboBox sessionComboBox;
    private javax.swing.JComboBox stdClassComboBox;
    private javax.swing.JTextField stdCnicTextField;
    private javax.swing.JComboBox stdComboBox;
    private javax.swing.JLabel stdLabel;
    private javax.swing.JTextField stdMobileTextField;
    private javax.swing.JTextField stdNameTextField;
    private javax.swing.JTable stdPromotionTable;
    private javax.swing.JComboBox stdSectionComboBox;
    private javax.swing.JComboBox stdWingComboBox;
    private javax.swing.JLabel studentsCnicLabel;
    private javax.swing.JLabel studentsLabel;
    private javax.swing.JLabel studentsMobileLabel;
    private javax.swing.JLabel studentsNameLabel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JButton updateButton1;
    private javax.swing.JButton updateButton10;
    private javax.swing.JButton updateButton11;
    private javax.swing.JButton updateButton12;
    private javax.swing.JButton updateButton13;
    private javax.swing.JButton updateButton14;
    private javax.swing.JButton updateButton15;
    private javax.swing.JButton updateButton16;
    private javax.swing.JButton updateButton2;
    private javax.swing.JButton updateButton3;
    private javax.swing.JButton updateButton4;
    private javax.swing.JButton updateButton5;
    private javax.swing.JButton updateButton6;
    private javax.swing.JButton updateButton7;
    private javax.swing.JButton updateButton8;
    private javax.swing.JButton updateButton9;
    private javax.swing.JLabel wingLabel;
    private javax.swing.JLabel wingLabel1;
    // End of variables declaration//GEN-END:variables
}

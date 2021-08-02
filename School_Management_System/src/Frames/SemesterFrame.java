package Frames;



import BeanClasses.ClassBean;
import BeanClasses.MonthBean;
import BeanClasses.SectionBean;
import BeanClasses.SemesterBean;
import BeanClasses.StudentBean;
import BeanClasses.SubjectsBean;
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
public class SemesterFrame extends javax.swing.JFrame {

    /**
     * Creates new form StudentFrame
     */
    public SemesterFrame() {
        initComponents();
        getWing();
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
private void getSemester(){
        ClassBean classBean=(ClassBean)classComboBox.getSelectedItem();
        if(classBean==null)return; 
        
	try{
			Vector v=DatabaseManager.getSemester(classBean.getClassId());
                       DefaultTableModel model=(DefaultTableModel)semesterTable.getModel();
                        tableClear();
                Vector vector =null;
               for(int i=0; i<v.size(); i++){
                   SemesterBean semesterBean= (SemesterBean)v.elementAt(i);
                     vector = new Vector();
                     
                    // vector.addElement(monthBean.getWingId());
                     vector.addElement(semesterBean.getClassId());
                     vector.addElement(semesterBean.getSemesterId());
                     vector.addElement(semesterBean.getSemester());
                     vector.addElement(semesterBean.getSemesterDate());
                     vector.addElement(semesterBean.getRemarks());
                     model.addRow(vector);
                     
                }  		

      }catch(Exception e){
        e.printStackTrace();
        javax.swing.JOptionPane.showMessageDialog(this,"Error: "+e.getMessage());
    } 
}
   private void addSemester(){
    
            String semesterName=semesterNameTextField.getText();
            String semesterDate=Decoder.getDateFormat(semesterDateChooser.getDate());
            String remarks=remarksTextArea.getText();

    try{
        ClassBean classBean=(ClassBean)classComboBox.getSelectedItem();
        if(classBean==null)return;
               	int rows=DatabaseManager.addSemester(classBean.getClassId(),semesterName,semesterDate,remarks);
                
	if(rows>=1){
	        	javax.swing.JOptionPane.showMessageDialog(this,rows+" Records Inserted."); 
		clear();
		getSemester();				
	}
    }catch(Exception e){
        e.printStackTrace();
        javax.swing.JOptionPane.showMessageDialog(this,"Error: "+e.getMessage()); 
    }

}   //end 
private void deleteSemester(){
     int row =semesterTable.getSelectedRow();
     String semesterId=semesterTable.getModel().getValueAt(row, 1).toString();
    try{
           int rows = DatabaseManager.deleteSemester(semesterId);
           if(rows>=1){
           javax.swing.JOptionPane.showMessageDialog(this,rows+" Rrecord Removed.");
           getSemester();
           clear();
           }
    }catch(Exception e){
        e.printStackTrace();
        javax.swing.JOptionPane.showMessageDialog(this,"Error: "+e.getMessage()); 
    }
}   
private void updateSemester(){
    int row =semesterTable.getSelectedRow();
     String semesterId=semesterTable.getModel().getValueAt(row, 1).toString();
     
     String semesterName=semesterNameTextField.getText();
     String semesterDate=Decoder.getDateFormat(semesterDateChooser.getDate());
    String remarks=remarksTextArea.getText();

     try{
	int rows=DatabaseManager.updateSemester(semesterId,semesterName,semesterDate,remarks);
	if(rows>=1){
	    javax.swing.JOptionPane.showMessageDialog(this,rows+" Record Modified.");
	    getSemester();
	    clear();
        	}
     }catch(Exception e){
         e.printStackTrace();
         javax.swing.JOptionPane.showMessageDialog(this,"Error: "+e.getMessage());
     } 
}
private void clear(){
        semesterIdTextField.setText("");
        semesterNameTextField.setText("");
        remarksTextArea.setText("");
}    
private void tableClear(){
    DefaultTableModel model=(DefaultTableModel)semesterTable.getModel();
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
        wingIdLabel = new javax.swing.JLabel();
        semesterDateLabel = new javax.swing.JLabel();
        remarksLabel = new javax.swing.JLabel();
        semesterDetailsLabel = new javax.swing.JLabel();
        semesterIdTextField = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        remarksTextArea = new javax.swing.JTextArea();
        semesterNameTextField = new javax.swing.JTextField();
        subjectsIdLabel = new javax.swing.JLabel();
        wingComboBox = new javax.swing.JComboBox();
        classIdLabel = new javax.swing.JLabel();
        classComboBox = new javax.swing.JComboBox();
        semesterNameLabel1 = new javax.swing.JLabel();
        semesterDateChooser = new com.toedter.calendar.JDateChooser();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        semesterTable = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        printButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(2000, 1000));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titleLabel.setFont(new java.awt.Font("Ravie", 1, 57)); // NOI18N
        titleLabel.setText("SEMESTER DATABASE MANAGEMENT SYSTEM");
        jPanel1.add(titleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 1860, 70));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1890, 90));

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(15, 158, 160), 4));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        wingIdLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        wingIdLabel.setText("WING");
        jPanel3.add(wingIdLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, -1, -1));

        semesterDateLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        semesterDateLabel.setText("SEMESTER DATE");
        jPanel3.add(semesterDateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, -1, -1));

        remarksLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        remarksLabel.setText("REMARKS");
        jPanel3.add(remarksLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 510, -1, -1));

        semesterDetailsLabel.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        semesterDetailsLabel.setText("   SEMESTER DETAILS");
        semesterDetailsLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 51), 4));
        jPanel3.add(semesterDetailsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 470, 80));

        semesterIdTextField.setEditable(false);
        semesterIdTextField.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        semesterIdTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semesterIdTextFieldActionPerformed(evt);
            }
        });
        jPanel3.add(semesterIdTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 290, 110, -1));

        remarksTextArea.setColumns(20);
        remarksTextArea.setRows(5);
        jScrollPane2.setViewportView(remarksTextArea);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 510, 310, 220));

        semesterNameTextField.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jPanel3.add(semesterNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 360, 250, 50));

        subjectsIdLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        subjectsIdLabel.setText("SEMESTER ID");
        jPanel3.add(subjectsIdLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, -1, -1));

        wingComboBox.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        wingComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wingComboBoxActionPerformed(evt);
            }
        });
        jPanel3.add(wingComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, 220, 50));

        classIdLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        classIdLabel.setText("CLASS");
        jPanel3.add(classIdLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, -1, -1));

        classComboBox.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        classComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                classComboBoxActionPerformed(evt);
            }
        });
        jPanel3.add(classComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, 220, 50));

        semesterNameLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        semesterNameLabel1.setText("SEMESTER NAME");
        jPanel3.add(semesterNameLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, -1, -1));
        jPanel3.add(semesterDateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 430, 250, 50));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 490, 750));

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(15, 158, 160), 4));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        semesterTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CLASS", "SEMESTER ID", "SEMESTER", "SEMESTER DATE", "REMARKS"
            }
        ));
        semesterTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                semesterTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(semesterTable);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1350, 730));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, 1370, 750));

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(15, 158, 160), 4));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        printButton.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        printButton.setText("PRINT");
        printButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printButtonActionPerformed(evt);
            }
        });
        jPanel5.add(printButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1610, 10, 230, 70));

        addButton.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        addButton.setText("ADD NEW");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        jPanel5.add(addButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 230, 70));

        updateButton.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        updateButton.setText("UPDATE");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });
        jPanel5.add(updateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 230, 70));

        clearButton.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        clearButton.setText("CLEAR");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });
        jPanel5.add(clearButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 10, 230, 70));

        backButton.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        backButton.setText("BACK");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        jPanel5.add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 10, 230, 70));

        saveButton.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        saveButton.setText("SAVE");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        jPanel5.add(saveButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1350, 10, 230, 70));

        deleteButton.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        deleteButton.setText("DELETE");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        jPanel5.add(deleteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 10, 230, 70));

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 770, 1870, 90));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 1890, 880));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
        deleteSemester();
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
       addSemester();
    }//GEN-LAST:event_addButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
       updateSemester();
    }//GEN-LAST:event_updateButtonActionPerformed

    private void printButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_printButtonActionPerformed

    
    
    private void semesterIdTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semesterIdTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_semesterIdTextFieldActionPerformed

    private void wingComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wingComboBoxActionPerformed
            getClasss();
    }//GEN-LAST:event_wingComboBoxActionPerformed

    private void classComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_classComboBoxActionPerformed
        getSemester();
    }//GEN-LAST:event_classComboBoxActionPerformed

    private void semesterTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_semesterTableMouseClicked
     int row =semesterTable.getSelectedRow();
     String semesterId=semesterTable.getModel().getValueAt(row, 1).toString();
             
     SemesterBean bean=DatabaseManager.getSemesterById(semesterId);
         semesterIdTextField.setText(""+bean.getSemesterId());
         semesterNameTextField.setText(bean.getSemester());
         remarksTextArea.setText(bean.getRemarks());
    }//GEN-LAST:event_semesterTableMouseClicked



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
            java.util.logging.Logger.getLogger(SemesterFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SemesterFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SemesterFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SemesterFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SemesterFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton backButton;
    private javax.swing.JComboBox classComboBox;
    private javax.swing.JLabel classIdLabel;
    private javax.swing.JButton clearButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton printButton;
    private javax.swing.JLabel remarksLabel;
    private javax.swing.JTextArea remarksTextArea;
    private javax.swing.JButton saveButton;
    private com.toedter.calendar.JDateChooser semesterDateChooser;
    private javax.swing.JLabel semesterDateLabel;
    private javax.swing.JLabel semesterDetailsLabel;
    private javax.swing.JTextField semesterIdTextField;
    private javax.swing.JLabel semesterNameLabel1;
    private javax.swing.JTextField semesterNameTextField;
    private javax.swing.JTable semesterTable;
    private javax.swing.JLabel subjectsIdLabel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JButton updateButton;
    private javax.swing.JComboBox wingComboBox;
    private javax.swing.JLabel wingIdLabel;
    // End of variables declaration//GEN-END:variables
}

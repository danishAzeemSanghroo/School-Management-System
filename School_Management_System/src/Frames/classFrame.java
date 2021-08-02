package Frames;



import BeanClasses.ClassBean;
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
public class classFrame extends javax.swing.JFrame {

    /**
     * Creates new form StudentFrame
     */
    public classFrame() {
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
                       DefaultTableModel model=(DefaultTableModel)classTable.getModel();
                        tableClear();
                Vector vector =null;
               for(int i=0; i<v.size(); i++){
                   ClassBean classBean= (ClassBean)v.elementAt(i);
                     vector = new Vector();
                    
                     vector.addElement(classBean.getWingId());
                      vector.addElement(classBean.getClassId());
                     vector.addElement(classBean.getClassName());
                     vector.addElement(classBean.getFees());
                     vector.addElement(classBean.getRemarks());
                     model.addRow(vector);
                     
                }  		

      }catch(Exception e){
        e.printStackTrace();
        javax.swing.JOptionPane.showMessageDialog(this,"Error: "+e.getMessage());
    }    
	
}//end Method 
   private void addClass(){
       
            String className=classNameTextField.getText();
            String fees=feesTextField.getText();
            String remarks=remarksTextArea.getText();

    try{
        WingBean wingBean=(WingBean)wingComboBox.getSelectedItem();
               	int rows=DatabaseManager.addClass(wingBean.getWingId(),className,fees,remarks);
                
	if(rows>=1){
	        	javax.swing.JOptionPane.showMessageDialog(this,rows+" Records Inserted."); 
		clear();
		getClass();				
	}
    }catch(Exception e){
        e.printStackTrace();
        javax.swing.JOptionPane.showMessageDialog(this,"Error: "+e.getMessage()); 
    }

}   //end 
private void deleteClass(){
     int row =classTable.getSelectedRow();
     String classId=classTable.getModel().getValueAt(row, 0).toString();
    try{
           int rows = DatabaseManager.deleteClass(classId);
           if(rows>=1){
           javax.swing.JOptionPane.showMessageDialog(this,rows+" Rrecord Removed.");
           getClass();
           clear();
           }
    }catch(Exception e){
        e.printStackTrace();
        javax.swing.JOptionPane.showMessageDialog(this,"Error: "+e.getMessage()); 
    }
}   
private void updateClass(){
    int row =classTable.getSelectedRow();
     String classId=classTable.getModel().getValueAt(row, 0).toString();
     
     String className=classNameTextField.getText();
     String fees=feesTextField.getText();
    String remarks=remarksTextArea.getText();

     try{
	int rows=DatabaseManager.updateClass(classId,className,fees,remarks);
	if(rows>=1){
	    javax.swing.JOptionPane.showMessageDialog(this,rows+" Record Modified.");
	    getClass();
	    clear();
        	}
     }catch(Exception e){
         e.printStackTrace();
         javax.swing.JOptionPane.showMessageDialog(this,"Error: "+e.getMessage());
     } 
}
private void clear(){
        classIdTextField.setText("");
        classNameTextField.setText("");
        remarksTextArea.setText("");
}    
private void tableClear(){
    DefaultTableModel model=(DefaultTableModel)classTable.getModel();
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
        wingNameLabel = new javax.swing.JLabel();
        remarksLabel = new javax.swing.JLabel();
        guardiansLabel = new javax.swing.JLabel();
        classIdTextField = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        remarksTextArea = new javax.swing.JTextArea();
        classNameTextField = new javax.swing.JTextField();
        wingIdLabel1 = new javax.swing.JLabel();
        wingComboBox = new javax.swing.JComboBox();
        feesLabel = new javax.swing.JLabel();
        feesTextField = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        classTable = new javax.swing.JTable();
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

        titleLabel.setFont(new java.awt.Font("Ravie", 1, 60)); // NOI18N
        titleLabel.setText("CLASS DATABASE MANAGEMENT SYSTEM");
        jPanel1.add(titleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, -1, 70));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1890, 90));

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(15, 158, 160), 4));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        wingIdLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        wingIdLabel.setText("WING");
        jPanel3.add(wingIdLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, -1, -1));

        wingNameLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        wingNameLabel.setText("CLASS NAME");
        jPanel3.add(wingNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, -1, -1));

        remarksLabel.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        remarksLabel.setText("REMARKS");
        jPanel3.add(remarksLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, -1, -1));

        guardiansLabel.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        guardiansLabel.setText("         CLASS DETAILS");
        guardiansLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 51), 4));
        jPanel3.add(guardiansLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 470, 80));

        classIdTextField.setEditable(false);
        classIdTextField.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        classIdTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                classIdTextFieldActionPerformed(evt);
            }
        });
        jPanel3.add(classIdTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, 110, -1));

        remarksTextArea.setColumns(20);
        remarksTextArea.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 24)); // NOI18N
        remarksTextArea.setRows(5);
        jScrollPane2.setViewportView(remarksTextArea);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 410, 270, 320));

        classNameTextField.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jPanel3.add(classNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 290, 270, -1));

        wingIdLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        wingIdLabel1.setText("CLASS ID");
        jPanel3.add(wingIdLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, -1, -1));

        wingComboBox.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        wingComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wingComboBoxActionPerformed(evt);
            }
        });
        jPanel3.add(wingComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, 260, 40));

        feesLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        feesLabel.setText("FEES");
        jPanel3.add(feesLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 350, -1, -1));

        feesTextField.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jPanel3.add(feesTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 350, 270, -1));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 490, 750));

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(15, 158, 160), 4));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        classTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "WING", "CLASS ID", "CLASS NAME", "FEES", "REMARKS"
            }
        ));
        classTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                classTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(classTable);

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
       deleteClass();
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
       addClass();
    }//GEN-LAST:event_addButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        updateClass();
    }//GEN-LAST:event_updateButtonActionPerformed

    private void printButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_printButtonActionPerformed

    
    
    private void classIdTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_classIdTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_classIdTextFieldActionPerformed

    private void classTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_classTableMouseClicked
     int row =classTable.getSelectedRow();
     String classId=classTable.getModel().getValueAt(row, 1).toString();
             
     ClassBean bean=DatabaseManager.getClassById(classId);
         classIdTextField.setText(""+bean.getClassId());
         classNameTextField.setText(bean.getClassName());
         feesTextField.setText(bean.getFees());
         remarksTextArea.setText(bean.getRemarks());
    }//GEN-LAST:event_classTableMouseClicked

    private void wingComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wingComboBoxActionPerformed
        getClasss();
    }//GEN-LAST:event_wingComboBoxActionPerformed



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
            java.util.logging.Logger.getLogger(classFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(classFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(classFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(classFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new classFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton backButton;
    private javax.swing.JTextField classIdTextField;
    private javax.swing.JTextField classNameTextField;
    private javax.swing.JTable classTable;
    private javax.swing.JButton clearButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel feesLabel;
    private javax.swing.JTextField feesTextField;
    private javax.swing.JLabel guardiansLabel;
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
    private javax.swing.JLabel titleLabel;
    private javax.swing.JButton updateButton;
    private javax.swing.JComboBox wingComboBox;
    private javax.swing.JLabel wingIdLabel;
    private javax.swing.JLabel wingIdLabel1;
    private javax.swing.JLabel wingNameLabel;
    // End of variables declaration//GEN-END:variables
}

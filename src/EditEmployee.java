
import CSVUtil.MotorPHEmployeeCSVUtil;
import Class.Employee;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class EditEmployee extends javax.swing.JFrame {

    private DefaultTableModel tableModel;
    private List<Employee> Employees;
    private final EmployeeInformation parentView;
    
    public EditEmployee(EmployeeInformation This) {
        this.parentView = This;
        initComponents();
        loadEmpInfo();
        addTableSelectionListener();
//        PopulateFields();
        
        btnUpdate.setEnabled(false);
        btnDelete.setEnabled(false);
        txtEmpID.setEnabled(false);
        txtLastName.setEnabled(false);
        txtFirstName.setEnabled(false);
        cboxPosition.setEnabled(false);
        cboxGender.setEnabled(false);
        txtBirthday.setEnabled(false);
        txtPhoneNumber.setEnabled(false);
        
        
    }

    
    
    private void loadEmpInfo(){
        Employees = MotorPHEmployeeCSVUtil.LoadEmployeeInfo();
        String[] ColumnHeader = {"Employee ID", "Employee Position","Last Name", "First Name", "Gender", "Birthday", "Phone Number"};
        tableModel = new DefaultTableModel(ColumnHeader, 0){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        
        for(Employee employee: Employees){
        String[] row = {
                    employee.getEmployeeID(),
                    employee.getPosition(),
                    employee.getLastName(),
                    employee.getFirstName(),
                    employee.getGender(),
                    employee.getBirthday(),
                    employee.getPhoneNumber()
                    };
                    tableModel.addRow(row);
        }
        
        tblEmpInfo.setModel(tableModel);
    }
    
    public void refreshTable(){
        loadEmpInfo();
    }
    
    private void addTableSelectionListener(){
        tblEmpInfo.getSelectionModel().addListSelectionListener((ListSelectionEvent e) -> {
            boolean selected = tblEmpInfo.getSelectedRow() != -1;
            btnDelete.setEnabled(selected);
            btnUpdate.setEnabled(selected);
            txtEmpID.setEnabled(selected);
            txtLastName.setEnabled(selected);
            txtFirstName.setEnabled(selected);
            cboxPosition.setEnabled(selected);
            cboxGender.setEnabled(selected);
            txtBirthday.setEnabled(selected);
            txtPhoneNumber.setEnabled(selected);
            
            int selectedRow = tblEmpInfo.getSelectedRow();

            if (selectedRow != -1) {
                String EmployeeID = tableModel.getValueAt(selectedRow, 0).toString();
                Employee selectedEmployee = MotorPHEmployeeCSVUtil.getEmployeeByID(EmployeeID);

                txtEmpID.setText(EmployeeID);
                cboxPosition.setSelectedItem(selectedEmployee.getPosition());
                txtLastName.setText(selectedEmployee.getLastName());
                txtFirstName.setText(selectedEmployee.getFirstName());
                cboxGender.setSelectedItem(selectedEmployee.getGender());
                txtBirthday.setText(selectedEmployee.getBirthday());
                txtPhoneNumber.setText(selectedEmployee.getPhoneNumber());
            }
        });
        

        
        btnDelete.addActionListener((ActionEvent e) -> {
            int selectedRow = tblEmpInfo.getSelectedRow();
            if(selectedRow != -1){
                String EmployeeID = tableModel.getValueAt(selectedRow, 0).toString();
                int confirm = JOptionPane.showConfirmDialog(EditEmployee.this,
                        "Are you sure you want to delete this Employee Information?",
                        "Confirm Delete",
                        JOptionPane.YES_NO_OPTION
                );
                if(confirm == JOptionPane.YES_OPTION){
                    boolean deleted = MotorPHEmployeeCSVUtil.DeleteEmpInfo(EmployeeID);
                    if(deleted){
                        tableModel.removeRow(selectedRow);
                        JOptionPane.showMessageDialog(EditEmployee.this,
                                "Employee Record deleted successfully!"
                        );
                    } else{
                        JOptionPane.showMessageDialog(EditEmployee.this,
                                "Failed to Delete record.",
                                "Error!",
                                JOptionPane.ERROR_MESSAGE
                        );
                    }
                }
            }
        });
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblEmpInfo = new javax.swing.JTable();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtEmpID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtLastName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtBirthday = new javax.swing.JTextField();
        jlabel11 = new javax.swing.JLabel();
        txtPhoneNumber = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtFirstName = new javax.swing.JTextField();
        cboxGender = new javax.swing.JComboBox<>();
        cboxPosition = new javax.swing.JComboBox<>();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel1.setText("Edit Employee Information");

        tblEmpInfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblEmpInfo.setCellSelectionEnabled(true);
        tblEmpInfo.setRowHeight(40);
        jScrollPane2.setViewportView(tblEmpInfo);

        btnDelete.setText("Delete");

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        jLabel2.setText("Employee ID");

        jLabel3.setText("Position");

        jLabel4.setText("Last Name");

        jLabel5.setText("Gender");

        jLabel6.setText("Birthday");

        jlabel11.setText("Phone Number");

        jLabel8.setText("First Name");

        cboxGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));

        cboxPosition.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "HR", "Finance", "IT", "Employee" }));

        btnBack.setText("Go Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 763, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBack))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(74, 74, 74))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cboxGender, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(12, 12, 12)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(txtBirthday, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlabel11)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnDelete)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnUpdate))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txtEmpID, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(cboxPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnBack))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEmpID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboxPosition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cboxGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jlabel11)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnDelete)
                                .addComponent(btnUpdate))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBirthday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(7, 7, 7))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        EmployeeInformation EI = new EmployeeInformation();
        EI.setVisible(true);
        dispose();
        
    }//GEN-LAST:event_formWindowClosing

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        try{
        
        String EmployeeID = txtEmpID.getText();
        String EmployeePosition = cboxPosition.getSelectedItem().toString();
        String LastName = txtLastName.getText();
        String FirstName = txtFirstName.getText();
        String EmployeeGender = cboxGender.getSelectedItem().toString();
        String Birthday = txtBirthday.getText();
        String PhoneNumber = txtPhoneNumber.getText();
        
        if (EmployeeID.trim().isEmpty()||LastName.trim().isEmpty()&&FirstName.trim().isEmpty()||Birthday.trim().isEmpty()&&PhoneNumber.trim().isEmpty()){
            JOptionPane.showMessageDialog(this,"Please Enter values inside the Text Fields", "Missing Info", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Employee updatedEmpInfo = new Employee(EmployeeID, EmployeePosition, LastName, FirstName, EmployeeGender, Birthday, PhoneNumber);
        
        boolean Success = MotorPHEmployeeCSVUtil.UpdateEmpInfo(updatedEmpInfo);
        
        int confirm = JOptionPane.showConfirmDialog(EditEmployee.this,
                        "Are you sure you want to Update?",
                        "Confirm Logout",
                        JOptionPane.YES_NO_OPTION
                );
  
        if (Success && confirm == JOptionPane.YES_OPTION){
            JOptionPane.showMessageDialog(this,"Employee information updated successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
            parentView.refreshTable();
            this.refreshTable();
        } else {
            JOptionPane.showMessageDialog(this, "Failed to update Employee Information", "Error", JOptionPane.WARNING_MESSAGE);
        }
        
        } catch(InputMismatchException e){
            JOptionPane.showMessageDialog(this, 
            "Please enter STRING ONLY in the text fields.", 
            "INPUT ERROR!", 
            JOptionPane.WARNING_MESSAGE);
        }  
    
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        EmployeeInformation EmpInfo = new EmployeeInformation();
        EmpInfo.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

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
            java.util.logging.Logger.getLogger(EditEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new EditEmployee(null).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cboxGender;
    private javax.swing.JComboBox<String> cboxPosition;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jlabel11;
    private javax.swing.JTable tblEmpInfo;
    private javax.swing.JTextField txtBirthday;
    private javax.swing.JTextField txtEmpID;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtPhoneNumber;
    // End of variables declaration//GEN-END:variables
}

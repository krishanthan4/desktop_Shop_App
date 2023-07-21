package gui;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import model.MySQL;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class employeeRegistration extends javax.swing.JFrame {

    private static HashMap<String, String> employeeTypeMap = new HashMap<>();
    private static HashMap<String, String> employeegenderMap = new HashMap<>();

    public employeeRegistration() {
        initComponents();
        loadTypes();
        loadGender();
        loadEmployees();
    }

    private void loadTypes() {
        try {

            ResultSet resultset = MySQL.execute("SELECT * FROM `employee_type`");
            Vector<String> vector = new Vector<>();
            vector.add("Select");

            while (resultset.next()) {
                vector.add(resultset.getString("name"));
                employeeTypeMap.put(resultset.getString("name"), resultset.getString("id"));
            }
            DefaultComboBoxModel model = new DefaultComboBoxModel(vector);
            jComboBox1.setModel(model);

        } catch (Exception e) {
        }
    }

    private void loadGender() {
        try {

            ResultSet resultset = MySQL.execute("SELECT * FROM `gender`");
            Vector<String> vector = new Vector<>();
            vector.add("Select");

            while (resultset.next()) {
                vector.add(resultset.getString("name"));
                employeegenderMap.put(resultset.getString("name"), resultset.getString("id"));
            }
            DefaultComboBoxModel model = new DefaultComboBoxModel(vector);
            jComboBox2.setModel(model);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadEmployees() {
        try {
            ResultSet resultset = MySQL.execute("SELECT * FROM `employee` INNER JOIN `gender` ON `gender`.`id`=`employee`.`gender_id` INNER JOIN `employee_type` ON `employee_type`.`id`=`employee`.`employee_type_id`;");

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            while (resultset.next()) {
                Vector<String> vector = new Vector<>();

                vector.add(resultset.getString("email"));
                vector.add(resultset.getString("first_name"));
                vector.add(resultset.getString("last_name"));
                vector.add(resultset.getString("nic"));
                vector.add(resultset.getString("mobile"));
                vector.add(resultset.getString("gender.name"));
                vector.add(resultset.getString("password"));
                vector.add(resultset.getString("employee_type.name"));
                vector.add(resultset.getString("employee.date_registered"));

                model.addRow(vector);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Email");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 33, -1, -1));
        jPanel2.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 33, 135, 31));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("First Name");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 76, -1, -1));
        jPanel2.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 76, 160, 31));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Last name");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 119, -1, -1));
        jPanel2.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 119, 160, 31));
        jPanel2.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 162, 160, 31));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("NIC");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 162, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Mobile");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 205, -1, -1));
        jPanel2.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 205, 160, 31));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Password");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 249, -1, -1));
        jPanel2.add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 248, 160, 32));

        jPanel2.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 336, 160, 32));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Type");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 337, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("Gender");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 293, -1, -1));

        jPanel2.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 292, 160, 32));

        jButton1.setText("Update Account");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 454, 260, 37));

        jButton2.setText("Create Account");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 411, 260, 37));

        jButton3.setText("...");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 37, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Email", "First Name", "Last Name", "NIC", "Mobile", "Gender", "Password", "Type", "Date Registered"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(100);
            jTable1.getColumnModel().getColumn(5).setMaxWidth(50);
            jTable1.getColumnModel().getColumn(7).setMaxWidth(50);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 742, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {

            String email = jTextField1.getText();
            String fname = jTextField2.getText();
            String lname = jTextField3.getText();
            String nic = jTextField4.getText();
            String mobile = jTextField5.getText();
            String gender = String.valueOf(jComboBox2.getSelectedItem());
            String password = String.valueOf(jPasswordField1.getPassword());
            String type = String.valueOf(jComboBox1.getSelectedItem());

            if (email.isEmpty()) {

                JOptionPane.showMessageDialog(this, "please enter employee email", "Warning", JOptionPane.WARNING_MESSAGE);

            } else if (nic.isEmpty()) {
                JOptionPane.showMessageDialog(this, "please enter employee nic", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (mobile.isEmpty()) {
                JOptionPane.showMessageDialog(this, "please enter employee mobile", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (!mobile.matches("^07[01245678]{1}[0-9]{7}$")) {
                JOptionPane.showMessageDialog(this, "please enter valid mobile", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "please enter employee password", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (gender.equals("Select")) {
                JOptionPane.showMessageDialog(this, "please Select employee gender", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (type.equals("Select")) {
                JOptionPane.showMessageDialog(this, "please Select employee type ", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {

                ResultSet resultSet = MySQL.execute("SELECT * FROM `employee` WHERE `nic`= '" + nic + "' OR `mobile`='" + mobile + "'");

                if (resultSet.next()) {

                    if (!resultSet.getString("email").equals(email)) {
                        JOptionPane.showMessageDialog(this, "Email,Mobile or NIC already used", "Warning", JOptionPane.WARNING_MESSAGE);
                    } else {

                    }

                } else {
                    
                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

                    MySQL.execute("INSSaSaERT INTO `employee` (`email`,`password`,`first_name`,`last_name`,`nic`,`mobile`,`employee_type_id`,`gender_id`,`date_registered`) VALUES ('" + email + "','" + password + "','" + fname + "','" + lname + "','" + nic + "','" + mobile + "','" + employeeTypeMap.get(type) + "','" + employeegenderMap.get(gender) + "','" + sdf.format(date) + "')");
//System.out.println( sdf.format(date));

                    loadEmployees();
                    reset();
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void reset() {
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jTextField1.setText("");
        jPasswordField1.setText("");
        jComboBox1.setSelectedIndex(0);
        jComboBox2.setSelectedIndex(0);
        jTextField1.grabFocus();

    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try {

            String email = jTextField1.getText();
            String fname = jTextField2.getText();
            String lname = jTextField3.getText();
            String nic = jTextField4.getText();
            String mobile = jTextField5.getText();
            String gender = String.valueOf(jComboBox2.getSelectedItem());
            String password = String.valueOf(jPasswordField1.getPassword());
            String type = String.valueOf(jComboBox1.getSelectedItem());

            if (nic.isEmpty()) {
                JOptionPane.showMessageDialog(this, "please enter employee nic", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (mobile.isEmpty()) {
                JOptionPane.showMessageDialog(this, "please enter employee mobile", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (!mobile.matches("^07[01245678]{1}[0-9]{7}$")) {
                JOptionPane.showMessageDialog(this, "please enter valid mobile", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "please enter employee password", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (gender.equals("Select")) {
                JOptionPane.showMessageDialog(this, "please Select employee gender", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (type.equals("Select")) {
                JOptionPane.showMessageDialog(this, "please Select employee type ", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {

                ResultSet resultSet = MySQL.execute("SELECT * FROM `employee` WHERE `nic`= '" + nic + "' OR `mobile`='" + mobile + "'");

                boolean canUpdate = false;

                if (resultSet.next()) {

                    if (!resultSet.getString("email").equals(email)) {
                        JOptionPane.showMessageDialog(this, "Email,Mobile or NIC already used", "Warning", JOptionPane.WARNING_MESSAGE);
                    } else {
                        System.out.println("Same Data");
                        canUpdate = true;

                    }
                } else {
                    canUpdate = true;
                }

                if (canUpdate) {
                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

                    MySQL.execute("UPDATE `employee` SET `email`='" + email + "',`password`='" + password + "',`first_name`='" + fname + "',`last_name`='" + lname + "',`nic`='" + nic + "',`mobile`='" + mobile + "',`employee_type_id`='" + employeeTypeMap.get(type) + "',`gender_id`='" + employeegenderMap.get(gender) + "',`date_registered`='" + sdf.format(date) + "' WHERE `email`='" + email + "'");

                    loadEmployees();
                    reset();
                    jButton2.setEnabled(true);
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        
        if(evt.getClickCount()==1){
        
        int row = jTable1.getSelectedRow();
        String email = String.valueOf(jTable1.getValueAt(row, 0));
        String fname = String.valueOf(jTable1.getValueAt(row, 1));
        String lname = String.valueOf(jTable1.getValueAt(row, 2));
        String nic = String.valueOf(jTable1.getValueAt(row, 3));
        String mobile = String.valueOf(jTable1.getValueAt(row, 4));
        String gender = String.valueOf(jTable1.getValueAt(row, 5));
        String password = String.valueOf(jTable1.getValueAt(row, 6));
        String type = String.valueOf(jTable1.getValueAt(row, 7));

        jTextField1.setText(email);
        jTextField1.setEditable(false);
        jTextField2.setText(fname);
        jTextField3.setText(lname);
        jTextField4.setText(nic);
        jTextField5.setText(mobile);
        jComboBox2.setSelectedItem(gender);
        jPasswordField1.setText(password);
        jComboBox1.setSelectedItem(type);
        jButton2.setEnabled(false);
                }
        else if(evt.getClickCount()==2) {
                int row = jTable1.getSelectedRow();
        String email = String.valueOf(jTable1.getValueAt(row, 0));
        
        
              AddressView address = new AddressView(this,true,email);
            address.setVisible(true);
        }
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        jTextField1.setEditable(true);
                            jButton2.setEnabled(true);

        jTable1.clearSelection();
        reset();

    }//GEN-LAST:event_jButton3ActionPerformed

    public static void main(String args[]) {
        FlatMacDarkLaf.setup();

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new employeeRegistration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}

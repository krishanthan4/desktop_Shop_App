package gui;

import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.MySQL;

public class CompanyRegistration extends javax.swing.JDialog {

    SupplierRegistration sr;
    
    public CompanyRegistration(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        loadCompany();
        sr  =(SupplierRegistration) parent;
    }

    private void reset() {  
        
        jTextField1.setText("");
        jTextField2.setText("");
        jButton2.setEnabled(true);
   
    }

    private void loadCompany() {

        try {

            ResultSet resultset = MySQL.execute("SELECT * FROM `company`");
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            while (resultset.next()) {
                Vector vector = new Vector();
                vector.add(resultset.getString("id"));
                vector.add(resultset.getString("name"));
                vector.add(resultset.getString("hot line"));
                model.addRow(vector);
            }
        } catch (Exception e) {
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "id", "name", "hotline"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
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

        jLabel1.setText("Name");

        jLabel2.setText("Name");

        jButton1.setText("Update");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Add");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(51, 51, 51)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String name = jTextField1.getText();
        String hotline = jTextField2.getText();

        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "please enter name", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (hotline.isEmpty()) {
            JOptionPane.showMessageDialog(this, "please enter hotline number", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (!hotline.matches("^0((11)|(2(1|[3-7]))|(3[1-8])|(4(1|5|7))|(5(1|2|4|5|7))|(6(3|[5-7]))|([8-9]1))[0-9]{7}$")) {
            JOptionPane.showMessageDialog(this, "Invalid Company Hotline Number", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            try {

                ResultSet resultset = MySQL.execute("SELECT * FROM WHERE `name`='" + name + "' OR `hotline`='" + hotline + "'");

                if (resultset.next()) {
                    JOptionPane.showMessageDialog(this, "Company name or otline already used", "Warning", JOptionPane.WARNING_MESSAGE);

                } else {
                    MySQL.execute("INSERT INTO `compnay` (`name`,`hotline`) VALUES ('" + name + "','" + hotline + "')");

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        int row = jTable1.getSelectedRow();

        jTextField1.setText(String.valueOf(jTable1.getValueAt(row, 1)));
        jTextField2.setText(String.valueOf(jTable1.getValueAt(row, 2)));

        jButton2.setEnabled(false);

        if (evt.getClickCount() == 2) {

            String name = String.valueOf(jTable1.getValueAt(row, 1));
((SupplierRegistration)sr).jTextField1.setText(name); 
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (jTable1.getSelectedRow() == 1) {
            JOptionPane.showMessageDialog(this, "please Select Company name", "Warning", JOptionPane.WARNING_MESSAGE);

        } else {

            String name = jTextField1.getText();
            String hotline = jTextField2.getText();

            int row = jTable1.getSelectedRow();
            String id = String.valueOf(jTable1.getValueAt(row, 0));
            String SelectedName = String.valueOf(jTable1.getValueAt(row, 1));
            String SelectedHotline = String.valueOf(jTable1.getValueAt(row, 2));

            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(this, "please enter name", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (hotline.isEmpty()) {
                JOptionPane.showMessageDialog(this, "please enter hotline number", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (!hotline.matches("^0((11)|(2(1|[3-7]))|(3[1-8])|(4(1|5|7))|(5(1|2|4|5|7))|(6(3|[5-7]))|([8-9]1))[0-9]{7}$")) {
                JOptionPane.showMessageDialog(this, "Invalid Company Hotline Number", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (SelectedName.equals(name) && SelectedHotline.equals(hotline)) {
                JOptionPane.showMessageDialog(this, "Invalid Company Hotline Number", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {
                try {
                    ResultSet resultset = MySQL.execute("SELECT * FROM ( WHERE `name`='" + name + "' OR `hotline`='" + hotline + "') AND `id`!= '" + id + "'");
                    if (resultset.next()) {
                        JOptionPane.showMessageDialog(this, "Company name or otline already used", "Warning", JOptionPane.WARNING_MESSAGE);
                    } else {
                        MySQL.execute("UPDATE `company` SET `name`='" + name + "',`hotline`='" + hotline + "' WHERE `id`='" + id + "'");
                        loadCompany();
                        reset();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CompanyRegistration dialog = new CompanyRegistration(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}

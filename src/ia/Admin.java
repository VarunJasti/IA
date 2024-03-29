/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia;

import java.sql.ResultSet;

/**
 *
 * @author Varun Jasti
 */
public class Admin extends javax.swing.JPanel {

    /**
     * Creates new form Admin
     */
    public Admin() {
        initComponents();
    }

    public void loadTable(ResultSet rs) {
        try {
            for (int i = 0; i < usersTable.getRowCount(); i++) {
                rs.next();
                usersTable.setValueAt(rs.getString(3), i, 0);
                usersTable.setValueAt(rs.getString(4), i, 1);
            }
        } catch (Exception e) {
            System.out.println("error");
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        usersTable = new javax.swing.JTable();
        viewTripsButton = new javax.swing.JButton();
        newAdminButton = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Users:");

        usersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "First", "Last"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(usersTable);
        if (usersTable.getColumnModel().getColumnCount() > 0) {
            usersTable.getColumnModel().getColumn(0).setResizable(false);
            usersTable.getColumnModel().getColumn(1).setResizable(false);
        }

        viewTripsButton.setText("View Trips");
        viewTripsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewTripsButtonActionPerformed(evt);
            }
        });

        newAdminButton.setText("Add Admin");
        newAdminButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newAdminButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(viewTripsButton)
                            .addComponent(newAdminButton))))
                .addContainerGap(237, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(viewTripsButton)
                        .addGap(18, 18, 18)
                        .addComponent(newAdminButton)))
                .addContainerGap(159, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void viewTripsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewTripsButtonActionPerformed
        if (usersTable.getValueAt(usersTable.getSelectedRow(), 0) instanceof String && usersTable.getValueAt(usersTable.getSelectedRow(), 1) instanceof String) {
            IA.base.getAdminTrips().setName((String) usersTable.getValueAt(usersTable.getSelectedRow(), 0));
            IA.base.getAdminTrips().setUser(IA.user((String)usersTable.getValueAt(usersTable.getSelectedRow(), 0), (String)usersTable.getValueAt(usersTable.getSelectedRow(), 1)));
            IA.base.showPanel(8);
        }
    }//GEN-LAST:event_viewTripsButtonActionPerformed

    private void newAdminButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newAdminButtonActionPerformed
        IA.base.showPanel(11);
    }//GEN-LAST:event_newAdminButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton newAdminButton;
    private javax.swing.JTable usersTable;
    private javax.swing.JButton viewTripsButton;
    // End of variables declaration//GEN-END:variables
}

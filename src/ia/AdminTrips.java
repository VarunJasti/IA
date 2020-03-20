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
public class AdminTrips extends javax.swing.JPanel {

    private static String user;
    private static String name;

    /**
     * Creates new form AdminTrips
     */
    public AdminTrips() {
        initComponents();
    }

    public void loadLabel() {
        label.setText(name + "'s Trips:");
    }

    public void setUser(String user) {
        this.user = (String) user;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void loadTable() {
        ResultSet rs = IA.getTrips(user);
        for (int i = 0; i < tripsTable.getRowCount(); i++) {
            for (int j = 0; j < tripsTable.getColumnCount(); j++) {
                tripsTable.setValueAt("", i, j);
            }
        }
        try {
            for (int i = 0; i < tripsTable.getRowCount(); i++) {
                rs.next();
                tripsTable.setValueAt(rs.getString("trip_name"), i, 0);
                tripsTable.setValueAt(rs.getString("trip_name"), i, 1);
                tripsTable.setValueAt(rs.getString("trip_name"), i, 2);
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

        label = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tripsTable = new javax.swing.JTable();
        summaryButton = new javax.swing.JButton();
        usersButton = new javax.swing.JButton();

        label.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        label.setText("jLabel1");

        tripsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Trip Name", "Start Date", "End Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tripsTable);
        if (tripsTable.getColumnModel().getColumnCount() > 0) {
            tripsTable.getColumnModel().getColumn(0).setResizable(false);
            tripsTable.getColumnModel().getColumn(1).setResizable(false);
            tripsTable.getColumnModel().getColumn(2).setResizable(false);
        }

        summaryButton.setText("View Expense Summary");
        summaryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                summaryButtonActionPerformed(evt);
            }
        });

        usersButton.setText("Users");
        usersButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usersButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(summaryButton)
                            .addComponent(usersButton))))
                .addContainerGap(183, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(summaryButton)
                        .addGap(18, 18, 18)
                        .addComponent(usersButton)))
                .addContainerGap(131, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void summaryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_summaryButtonActionPerformed
        IA.base.getSummary().setUser(user);
        if (tripsTable.getValueAt(tripsTable.getSelectedRow(), 0) instanceof String) {
            IA.base.getSummary().setTrip((String)tripsTable.getValueAt(tripsTable.getSelectedRow(), 0));
        }
        IA.base.getSummary().setName(name);
        IA.base.showPanel(9);
    }//GEN-LAST:event_summaryButtonActionPerformed

    private void usersButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usersButtonActionPerformed
        IA.base.showPanel(7);
    }//GEN-LAST:event_usersButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label;
    private javax.swing.JButton summaryButton;
    private javax.swing.JTable tripsTable;
    private javax.swing.JButton usersButton;
    // End of variables declaration//GEN-END:variables
}

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
public class AdminExpenseSummary extends javax.swing.JPanel {

    /**
     * Creates new form AdminExpenseSummary
     */
    private static String user;
    private static String name;
    private static String trip;

    public AdminExpenseSummary() {
        initComponents();
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTrip(String trip) {
        this.trip = trip;
    }

    public void loadTable() {
        ResultSet rs = IA.getSummary(user, trip);
        double trans = 0;
        double per = 0;
        double bus = 0;
        double park = 0;
        double hotel = 0;
        double flight = 0;
        double other = 0;
        String curr = "";
        try {
            while (rs.next()) {
                if (rs.getString("expenseType").equals("Transportation")) {
                    trans += rs.getDouble("amount");
                } else if (rs.getString("expenseType").equals("Personal Meal")) {
                    per += rs.getDouble("amount");
                } else if (rs.getString("expenseType").equals("Business Meal")) {
                    bus += rs.getDouble("amount");
                } else if (rs.getString("expenseType").equals("Parking")) {
                    park += rs.getDouble("amount");
                } else if (rs.getString("expenseType").equals("Hotel")) {
                    hotel += rs.getDouble("amount");
                } else if (rs.getString("expenseType").equals("Flight")) {
                    flight += rs.getDouble("amount");
                } else if (rs.getString("expenseType").equals("Other")) {
                    other += rs.getDouble("amount");
                }
                curr = rs.getString("currency");
            }
            summaryTable.setValueAt(curr, 0, 0);
            summaryTable.setValueAt(trans, 0, 1);
            summaryTable.setValueAt(per, 0, 2);
            summaryTable.setValueAt(bus, 0, 3);
            summaryTable.setValueAt(park, 0, 4);
            summaryTable.setValueAt(hotel, 0, 5);
            summaryTable.setValueAt(flight, 0, 6);
            summaryTable.setValueAt(other, 0, 7);
            summaryTable.setValueAt(trans + per + bus + park + hotel + flight + other, 0, 8);
        } catch (Exception e) {
            System.out.println("error");
            e.printStackTrace();
        }
    }

    public void setLabel() {
        label.setText(name + " " + trip + " Expenses Summary");
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
        summaryTable = new javax.swing.JTable();
        viewExpsButton = new javax.swing.JButton();
        tripsButton = new javax.swing.JButton();

        label.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        label.setText("Summary");

        summaryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Currency", "Transportation", "Personal Meal", "Business Meal", "Parking", "Hotel", "Flight", "Other", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(summaryTable);
        if (summaryTable.getColumnModel().getColumnCount() > 0) {
            summaryTable.getColumnModel().getColumn(0).setResizable(false);
            summaryTable.getColumnModel().getColumn(1).setResizable(false);
            summaryTable.getColumnModel().getColumn(2).setResizable(false);
            summaryTable.getColumnModel().getColumn(3).setResizable(false);
            summaryTable.getColumnModel().getColumn(4).setResizable(false);
            summaryTable.getColumnModel().getColumn(5).setResizable(false);
            summaryTable.getColumnModel().getColumn(6).setResizable(false);
            summaryTable.getColumnModel().getColumn(7).setResizable(false);
            summaryTable.getColumnModel().getColumn(8).setResizable(false);
        }

        viewExpsButton.setText("View Selected Expenses");
        viewExpsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewExpsButtonActionPerformed(evt);
            }
        });

        tripsButton.setText("Trips");
        tripsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tripsButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label)
                            .addComponent(viewExpsButton)
                            .addComponent(tripsButton))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(viewExpsButton)
                .addGap(18, 18, 18)
                .addComponent(tripsButton)
                .addContainerGap(267, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void viewExpsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewExpsButtonActionPerformed
        if (!(summaryTable.getSelectedColumn() == 0 || summaryTable.getSelectedColumn() == 8)) {
            IA.base.getAdminExps().setUser(user);
            IA.base.getAdminExps().setName(name);
            IA.base.getAdminExps().setTrip(trip);
            IA.base.getAdminExps().setType(summaryTable.getColumnName(summaryTable.getSelectedColumn()));
            IA.base.getAdminExps().setLabel();
            IA.base.showPanel(10);
        }
    }//GEN-LAST:event_viewExpsButtonActionPerformed

    private void tripsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tripsButtonActionPerformed
        IA.base.showPanel(8);
    }//GEN-LAST:event_tripsButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label;
    private javax.swing.JTable summaryTable;
    private javax.swing.JButton tripsButton;
    private javax.swing.JButton viewExpsButton;
    // End of variables declaration//GEN-END:variables
}

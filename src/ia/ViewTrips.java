/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia;

import java.sql.ResultSet;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author jastvar21
 */
public class ViewTrips extends javax.swing.JPanel implements TableModelListener {

    /**
     * Creates new form ViewTrips
     */
    public ViewTrips() {
        initComponents();
    }
    
    @Override
    public void tableChanged (TableModelEvent e) {
        TableModel model = (TableModel)e.getSource();
        int r = e.getFirstRow();
        int c = e.getColumn();
        //IA.updateTrips(tripTable.getValueAt(r, 0), tripTable.getValueAt(r, 1), tripTable.getValueAt(r, 2), c);
        System.out.println(r + " " + c);
    }
    
    public void updateTable() {
        ResultSet rs = IA.getTrips(IA.base.getUser());
        try {
            rs.next();
            for (int i = 0; i < tripTable.getRowCount(); i++) {
                tripTable.setValueAt(rs.getString("trip_name"), i, 0);
                tripTable.setValueAt(rs.getString("strt_date"), i, 1);
                tripTable.setValueAt(rs.getString("end_date"), i, 2);
                rs.next();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tripTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        addTripsButton = new javax.swing.JButton();

        tripTable.setModel(new javax.swing.table.DefaultTableModel(
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
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tripTable);
        if (tripTable.getColumnModel().getColumnCount() > 0) {
            tripTable.getColumnModel().getColumn(0).setResizable(false);
            tripTable.getColumnModel().getColumn(1).setResizable(false);
            tripTable.getColumnModel().getColumn(2).setResizable(false);
        }

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Trips");

        addTripsButton.setText("Add Trips");
        addTripsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTripsButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(213, 213, 213)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(175, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(addTripsButton)
                .addGap(65, 65, 65))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel1)
                .addGap(38, 38, 38)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(addTripsButton)
                .addContainerGap(30, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addTripsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTripsButtonActionPerformed
        IA.base.showPanel(4);
    }//GEN-LAST:event_addTripsButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addTripsButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tripTable;
    // End of variables declaration//GEN-END:variables
}
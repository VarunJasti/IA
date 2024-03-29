package ia;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.sql.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import javax.imageio.ImageIO;
import static javax.management.Query.gt;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author jastvar21
 */
public class ViewExpenses extends javax.swing.JPanel implements TableModelListener {

    /**
     * Creates new form ViewExpenses
     */
    public ViewExpenses() {
        initComponents();
        expensesTable.getModel().addTableModelListener(this);
        expensesTable.getColumnModel().getColumn(1).setPreferredWidth(15);
        expensesTable.getColumnModel().getColumn(3).setPreferredWidth(15);
        orderDrop.removeAllItems();
        orderDrop.addItem("Ascending");
        orderDrop.addItem("Descending");
        orderDrop.setSelectedIndex(-1);
    }

    @Override
    public void tableChanged(TableModelEvent e) {
        int r = e.getFirstRow();
        int c = e.getColumn();
        IA.updateExps(expensesTable.getValueAt(r, 0), expensesTable.getValueAt(r, 1), expensesTable.getValueAt(r, 2), expensesTable.getValueAt(r, 3), expensesTable.getValueAt(r, 4), c);
    }

    public void updateTable() {
        expensesTable.getModel().removeTableModelListener(this);
        for (int i = 0; i < expensesTable.getRowCount(); i++) {
            for (int j = 0; j < expensesTable.getColumnCount(); j++) {
                expensesTable.setValueAt("", i, j);
            }
        }
        ResultSet rs = IA.getExps(IA.base.getUser());
        try {
            for (int i = 0; i < expensesTable.getRowCount(); i++) {
                rs.next();
                expensesTable.setValueAt(rs.getString("trip"), i, 0);
                expensesTable.setValueAt(rs.getString("amount"), i, 1);
                expensesTable.setValueAt(rs.getString("expenseType"), i, 2);
                expensesTable.setValueAt(rs.getString("currency"), i, 3);
                expensesTable.setValueAt(rs.getString("dates"), i, 4);
            }
        } catch (Exception e) {
            System.out.println("error");
        }
        expensesTable.getModel().addTableModelListener(this);
    }

    public void sortTable(ResultSet rs) {
        expensesTable.getModel().removeTableModelListener(this);
        for (int i = 0; i < expensesTable.getRowCount(); i++) {
            for (int j = 0; j < expensesTable.getColumnCount(); j++) {
                expensesTable.setValueAt("", i, j);
            }
        }
        try {
            for (int i = 0; i < expensesTable.getRowCount(); i++) {
                rs.next();
                expensesTable.setValueAt(rs.getString("trip"), i, 0);
                expensesTable.setValueAt(rs.getString("amount"), i, 1);
                expensesTable.setValueAt(rs.getString("expenseType"), i, 2);
                expensesTable.setValueAt(rs.getString("currency"), i, 3);
                expensesTable.setValueAt(rs.getString("dates"), i, 4);
            }
        } catch (Exception e) {
            System.out.println("error");
        }
        expensesTable.getModel().addTableModelListener(this);
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
        expensesTable = new javax.swing.JTable();
        expensesLabel = new javax.swing.JLabel();
        addExpButton = new javax.swing.JButton();
        delExpButton = new javax.swing.JButton();
        sortLabel = new javax.swing.JLabel();
        orderDrop = new javax.swing.JComboBox();
        tripButton = new javax.swing.JButton();
        amtButton = new javax.swing.JButton();
        typeButton = new javax.swing.JButton();
        currButton = new javax.swing.JButton();
        dateButton = new javax.swing.JButton();
        viewImgButton = new javax.swing.JButton();

        expensesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, "", null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Trip", "Amount", "Type", "Currency", "Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(expensesTable);
        if (expensesTable.getColumnModel().getColumnCount() > 0) {
            expensesTable.getColumnModel().getColumn(0).setResizable(false);
            expensesTable.getColumnModel().getColumn(1).setResizable(false);
            expensesTable.getColumnModel().getColumn(2).setResizable(false);
            expensesTable.getColumnModel().getColumn(3).setResizable(false);
            expensesTable.getColumnModel().getColumn(4).setResizable(false);
        }

        expensesLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        expensesLabel.setText("Expenses");

        addExpButton.setText("Add Expenses");
        addExpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addExpButtonActionPerformed(evt);
            }
        });

        delExpButton.setText("Delete Selected Row(s)");
        delExpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delExpButtonActionPerformed(evt);
            }
        });

        sortLabel.setText("Sort:");

        orderDrop.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        tripButton.setText("Trip");
        tripButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tripButtonActionPerformed(evt);
            }
        });

        amtButton.setText("Amount");
        amtButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amtButtonActionPerformed(evt);
            }
        });

        typeButton.setText("Type");
        typeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeButtonActionPerformed(evt);
            }
        });

        currButton.setText("Currency");
        currButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                currButtonActionPerformed(evt);
            }
        });

        dateButton.setText("Date");
        dateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateButtonActionPerformed(evt);
            }
        });

        viewImgButton.setText("View Image");
        viewImgButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewImgButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(expensesLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 599, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(delExpButton)
                            .addComponent(sortLabel)
                            .addComponent(orderDrop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tripButton)
                            .addComponent(amtButton)
                            .addComponent(typeButton)
                            .addComponent(currButton)
                            .addComponent(dateButton)
                            .addComponent(viewImgButton)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(556, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(addExpButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(expensesLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(delExpButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(viewImgButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(sortLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(orderDrop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tripButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(amtButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(typeButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(currButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(addExpButton)
                .addContainerGap(49, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addExpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addExpButtonActionPerformed
        IA.base.showPanel(3);
    }//GEN-LAST:event_addExpButtonActionPerformed

    private void delExpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delExpButtonActionPerformed
        expensesTable.getModel().removeTableModelListener(this);
        int[] rows = expensesTable.getSelectedRows();
        for (int i = 0; i < rows.length; i++) {
            IA.deleteExp(expensesTable.getValueAt(rows[i], 0), expensesTable.getValueAt(rows[i], 1), expensesTable.getValueAt(rows[i], 2), expensesTable.getValueAt(rows[i], 3), expensesTable.getValueAt(rows[i], 4));
        }
        expensesTable.getModel().addTableModelListener(this);
        updateTable();
    }//GEN-LAST:event_delExpButtonActionPerformed

    private void tripButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tripButtonActionPerformed
        if (orderDrop.getSelectedIndex() == 0) {
            sortTable(IA.sortExps("trip", "asc"));
        } else if (orderDrop.getSelectedIndex() == 1) {
            sortTable(IA.sortExps("trip", "desc"));
        }
    }//GEN-LAST:event_tripButtonActionPerformed

    private void amtButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amtButtonActionPerformed
        if (orderDrop.getSelectedIndex() == 0) {
            sortTable(IA.sortExps("amount", "asc"));
        } else if (orderDrop.getSelectedIndex() == 1) {
            sortTable(IA.sortExps("amount", "desc"));
        }
    }//GEN-LAST:event_amtButtonActionPerformed

    private void typeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeButtonActionPerformed
        if (orderDrop.getSelectedIndex() == 0) {
            sortTable(IA.sortExps("expenseType", "asc"));
        } else if (orderDrop.getSelectedIndex() == 1) {
            sortTable(IA.sortExps("expenseType", "desc"));
        }
    }//GEN-LAST:event_typeButtonActionPerformed

    private void currButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_currButtonActionPerformed
        if (orderDrop.getSelectedIndex() == 0) {
            sortTable(IA.sortExps("currency", "asc"));
        } else if (orderDrop.getSelectedIndex() == 1) {
            sortTable(IA.sortExps("currency", "desc"));
        }
    }//GEN-LAST:event_currButtonActionPerformed

    private void dateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateButtonActionPerformed
        if (orderDrop.getSelectedIndex() == 0) {
            sortTable(IA.sortExps("dates", "asc"));
        } else if (orderDrop.getSelectedIndex() == 1) {
            sortTable(IA.sortExps("dates", "desc"));
        }
    }//GEN-LAST:event_dateButtonActionPerformed

    private void viewImgButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewImgButtonActionPerformed
        int r = expensesTable.getSelectedRow();
        ResultSet rs = IA.viewImg(expensesTable.getValueAt(r, 0), expensesTable.getValueAt(r, 1), expensesTable.getValueAt(r, 2), expensesTable.getValueAt(r, 3), expensesTable.getValueAt(r, 4), IA.base.getUser());
        try {
            rs.next();
            if (rs.getString("images") == null) {
                ViewImg frame = new ViewImg();
                frame.setVisible(true);
            } else {
                Blob blob = rs.getBlob("images");
                InputStream in = blob.getBinaryStream();
                BufferedImage img = ImageIO.read(rs.getBinaryStream("images"));
                ViewImg frame = new ViewImg(img);
                frame.setVisible(true);
            }
        } catch (Exception e) {
            System.out.println("error");
            e.printStackTrace();
        }
    }//GEN-LAST:event_viewImgButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addExpButton;
    private javax.swing.JButton amtButton;
    private javax.swing.JButton currButton;
    private javax.swing.JButton dateButton;
    private javax.swing.JButton delExpButton;
    private javax.swing.JLabel expensesLabel;
    private javax.swing.JTable expensesTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox orderDrop;
    private javax.swing.JLabel sortLabel;
    private javax.swing.JButton tripButton;
    private javax.swing.JButton typeButton;
    private javax.swing.JButton viewImgButton;
    // End of variables declaration//GEN-END:variables
}

package raven.application.form.other.hoadon;

import com.formdev.flatlaf.FlatClientProperties;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

public class FormHoaDon extends javax.swing.JPanel {

    public FormHoaDon() {
        initComponents();
        init();
    }
    
    public void init(){
        lb.putClientProperty(FlatClientProperties.STYLE, "font:$h1.font");
        jTable1.putClientProperty(FlatClientProperties.STYLE,"font:$h1.font" );
        // Set JTable properties
        jTable1.setShowGrid(true);
        jTable1.setGridColor(UIManager.getColor("Table.gridColor"));
        jTable1.setRowHeight(30);

        // Center align table headers
        ((DefaultTableCellRenderer) jTable1.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(DefaultTableCellRenderer.CENTER);

        // Center align table cells
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        for (int i = 0; i < jTable1.getColumnCount(); i++) {
            jTable1.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        // Customize columns width
        TableColumn column;
        for (int i = 0; i < jTable1.getColumnCount(); i++) {
            column = jTable1.getColumnModel().getColumn(i);
            if (i == 0) {
                column.setPreferredWidth(50); // first column is wider
            } else {
                column.setPreferredWidth(100);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        lb = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        lb.setText("HÓA ĐƠN");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 609, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(175, 175, 175)
                .addComponent(lb)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb)
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(286, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lb;
    // End of variables declaration//GEN-END:variables
}

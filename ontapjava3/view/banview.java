/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ontapjava3.view;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import ontapjava3.Service.BanService;
import ontapjava3.model.Ban;

/**
 *
 * @author Admin
 */
public class banview extends javax.swing.JFrame {

   private BanService banservice;
   private DefaultTableModel model;
    public banview() {
        initComponents();
        banservice = new BanService();
        model = (DefaultTableModel) table.getModel();
        setuptable();
    }

    public void setuptable(){
        List<Ban> nv = banservice.laynv();
        for (Ban x : nv) {
            model.addRow(new Object[]{x.getId(),x.getTen(),x.getMa(),x.isGioitinh()});
        }
    }

    
    public Ban validatennv(){
        String id = txtid.getText();
        String ten = txtten.getText();
        String ma = txtma.getText();
        boolean gioitinh = rdnam.isSelected();
        
        if(ten.isBlank()){
            JOptionPane.showMessageDialog(this, "Ko duoc de trong");
            txtten.requestFocus();
            return null;
        }
        if(ten.isBlank()){
            JOptionPane.showMessageDialog(this, "Ko duoc de trong");
            txtten.requestFocus();
            return null;
            }
        
        Ban nv = new Ban();
        nv.setId(id);
        nv.setTen(ten);
        nv.setMa(ma);
        nv.setGioitinh(gioitinh);
        
        return nv;
    }
    
    
    
    public void xoanv(String id){
        this.banservice.xoanv(id);
    }
    
    public  void suanv(Ban nv){
        this.banservice.suanv(nv);
    }
    
    
    public void addnv(Ban nv){
        Ban nv1 = banservice.addsv(nv);
        String id = nv1.getId();
        String ten = nv1.getTen();
        String ma = nv1.getMa();
        boolean gioitinh = nv1.isGioitinh();
        
        model.addRow(new Object[]{id, ten, ma, gioitinh});
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        rdnam = new javax.swing.JRadioButton();
        rdnu = new javax.swing.JRadioButton();
        txtten = new javax.swing.JTextField();
        txtma = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        btnthem = new javax.swing.JButton();
        btnxoa = new javax.swing.JButton();
        txtid = new javax.swing.JTextField();
        btnsua = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("ID");

        jLabel2.setText("Mã");

        jLabel3.setText("Tên");

        jLabel4.setText("Giới tính");

        buttonGroup1.add(rdnam);
        rdnam.setText("Nam");

        buttonGroup1.add(rdnu);
        rdnu.setText("Nữ");

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tên", "Mã", "Giới tính"
            }
        ));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tableMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        btnthem.setText("Thêm");
        btnthem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemActionPerformed(evt);
            }
        });

        btnxoa.setText("Xóa");
        btnxoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoaActionPerformed(evt);
            }
        });

        txtid.setText("_\n");
        txtid.setToolTipText("");
        txtid.setBorder(null);

        btnsua.setText("Sửa");
        btnsua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtma, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rdnam)
                                        .addGap(27, 27, 27)
                                        .addComponent(rdnu))
                                    .addComponent(txtten, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnthem)
                                .addGap(34, 34, 34)
                                .addComponent(btnxoa)
                                .addGap(18, 18, 18)
                                .addComponent(btnsua))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(198, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(txtten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(rdnam)
                    .addComponent(rdnu)
                    .addComponent(txtma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnthem)
                    .addComponent(btnxoa)
                    .addComponent(btnsua))
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnthemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemActionPerformed
        // TODO add your handling code here:
        Ban nv = validatennv();
        if(nv != null){
            addnv(nv);
        }
    }//GEN-LAST:event_btnthemActionPerformed

    private void tableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMousePressed
        // TODO add your handling code here:
      int selectrow = table.getSelectedRow();
      
      if(selectrow < 0){
          return;
      }
      
      String id = ((DefaultTableModel) table.getModel()).getValueAt(selectrow, 0).toString();
      String ten = ((DefaultTableModel) table.getModel()).getValueAt(selectrow, 1).toString();
      String ma = ((DefaultTableModel) table.getModel()).getValueAt(selectrow, 2).toString();
      String gioitinh = ((DefaultTableModel) table.getModel()).getValueAt(selectrow, 3).toString();
       
      txtid.setText(id);
      txtten.setText(ten);
      txtma.setText(ma);
      rdnam.setSelected(rootPaneCheckingEnabled);
    }//GEN-LAST:event_tableMousePressed

    private void btnxoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoaActionPerformed
        // TODO add your handling code here:
        int xoa = table.getSelectedRow();
        
        if(xoa<0){
            JOptionPane.showMessageDialog(this, "Vui long chon 1 nv",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        String id = model.getValueAt(xoa, 0).toString();
        xoanv(id);
        model.removeRow(xoa);
    }//GEN-LAST:event_btnxoaActionPerformed

    private void btnsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuaActionPerformed
        // TODO add your handling code here:
        Ban nv = validatennv();
        
        if(nv != null){
            int select = table.getSelectedRow();
            
            if(select<0){
                JOptionPane.showMessageDialog(this, "Chon de sua",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
            
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            
            
            suanv(nv);
            
            String id = nv.getId();
            String ten = nv.getTen();
            String ma = nv.getMa();
            boolean gioitinh = nv.isGioitinh();
            
            model.setValueAt(id, select, 0);
            model.setValueAt(ten, select, 1);
            model.setValueAt(ma, select, 2);
            model.setValueAt(gioitinh, select, 3);
            
            
            JOptionPane.showMessageDialog(this, "sua thanh cong");
        }
    }//GEN-LAST:event_btnsuaActionPerformed

    
   
    
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
            java.util.logging.Logger.getLogger(banview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(banview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(banview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(banview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new banview().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnsua;
    private javax.swing.JButton btnthem;
    private javax.swing.JButton btnxoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdnam;
    private javax.swing.JRadioButton rdnu;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtma;
    private javax.swing.JTextField txtten;
    // End of variables declaration//GEN-END:variables
}

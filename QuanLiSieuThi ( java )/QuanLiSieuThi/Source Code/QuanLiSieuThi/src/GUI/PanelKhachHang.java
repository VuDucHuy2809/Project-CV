
package GUI;

import BUS.KhachHangBUS;
import DTO.KhachHangDTO;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import static untils.CheckData.checkNumber;
import static untils.CheckData.checkSoDienThoai;


public class PanelKhachHang extends javax.swing.JPanel {
    DefaultTableModel model = new DefaultTableModel();
    KhachHangBUS bus = new KhachHangBUS();
    public PanelKhachHang() {
        initComponents();
        initData();
        load();
        model = (DefaultTableModel) tb_kh.getModel();
    }
    private void initData(){
        txt_kh.setEnabled(false);
        txt_hokh.setEnabled(false);
        txt_tenkh.setEnabled(false);
        txt_sdtkh.setEnabled(false);
        txt_dckh.setEnabled(false);
    }
    public KhachHangDTO getText(){
        KhachHangDTO kh = new KhachHangDTO();
        kh.setMaKH(txt_kh.getText().trim());
        kh.setHoKH(txt_hokh.getText().trim());                    
        kh.setTenKH(txt_tenkh.getText().trim());
        kh.setsDTKH(txt_sdtkh.getText().trim());
        kh.setDiaChiKH(txt_dckh.getText().trim());
        return kh;
    }
    private void load(){
        KhachHangBUS bus = new KhachHangBUS();       
        try{
           bus.docKh();
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, "Lỗi kết nối đến Database.");
           return;
       }
       Vector header = new Vector();
        header.add("Mã khách hàng");
        header.add("Họ khách hàng");
        header.add("Tên khách hàng");
        header.add("Số điện thoại");
        header.add("Địa chỉ");
            model = new DefaultTableModel(header,0){
            public boolean isCellEditable(int row, int column)
                {
                  return false;
                }
       };	
       showOnTable(bus.list);
    }
    private Vector setVector(KhachHangDTO kh){
            Vector head = new Vector();
            head.add(kh.getMaKH());
            head.add(kh.getHoKH());
            head.add(kh.getTenKH());
            head.add(kh.getsDTKH());
            head.add(kh.getDiaChiKH());
            return head;
    }    
    private void showOnTable(ArrayList<KhachHangDTO> list){
        model.setRowCount(0);
        for(KhachHangDTO kh:list){
           Vector data = setVector(kh);
           model.addRow(data);
       }
       tb_kh.setModel(model);
    }
    private void setModelValue(KhachHangDTO kh, int i){
        model.setValueAt(kh.getMaKH(),i,0);
        model.setValueAt(kh.getHoKH(),i,1);
        model.setValueAt(kh.getTenKH(),i,2);
        model.setValueAt(kh.getsDTKH(),i,3);
        model.setValueAt(kh.getDiaChiKH(),i,4);     
        tb_kh.setModel(model);            
    } 
   public void auto_increaseMaKh(){
        String i = null;
        KhachHangDTO kh= bus.docKh().get(bus.docKh().size()-1);
        String b="00";
        String c="0";
        int a= Integer.parseInt(kh.getMaKH().substring(2,5));
        a++;
        if(a<10){ i="KH"+b+a; }
        if(10<=a && a<=99) {  i ="KH"+c+a; }
        if(a>100){  i="KH"+a; }
        txt_kh.setText(i);
    }
    public void search(){
        model.setRowCount(0);
        for(KhachHangDTO kh:bus.timkiemtongquan(txt_findkh.getText())){
            model.addRow(new Object[]{
                kh.getMaKH(),kh.getHoKH(),kh.getTenKH(),kh.getsDTKH(),kh.getDiaChiKH()
            });
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel2 = new javax.swing.JPanel();
        pn_ttkh = new javax.swing.JPanel();
        lb_kh = new javax.swing.JLabel();
        txt_kh = new javax.swing.JTextField();
        lb_tenkh = new javax.swing.JLabel();
        txt_tenkh = new javax.swing.JTextField();
        lb_dckh = new javax.swing.JLabel();
        txt_dckh = new javax.swing.JTextField();
        lb_sdtkh = new javax.swing.JLabel();
        lb_hokh = new javax.swing.JLabel();
        txt_hokh = new javax.swing.JTextField();
        txt_sdtkh = new javax.swing.JTextField();
        pn_dokh = new javax.swing.JPanel();
        bt_addkh = new javax.swing.JButton();
        bt_resetkh = new javax.swing.JButton();
        bt_changekh = new javax.swing.JButton();
        pn_findkh = new javax.swing.JPanel();
        txt_findkh = new javax.swing.JTextField();
        lb_findkh = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_kh = new javax.swing.JTable(){
            public boolean isCellEditable ( int row, int col)
            {
                return false;
            }
        };

        Panel2.setBackground(new java.awt.Color(0, 204, 204));

        pn_ttkh.setBackground(new java.awt.Color(255, 255, 255));
        pn_ttkh.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin khách hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(255, 102, 102))); // NOI18N

        lb_kh.setText("Mã khách hàng:");

        lb_tenkh.setText("Tên khách hàng:");

        lb_dckh.setText("Địa chỉ:");

        lb_sdtkh.setText("Số điện thoại:");

        lb_hokh.setText("Họ khách hàng:");

        txt_sdtkh.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_sdtkhKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout pn_ttkhLayout = new javax.swing.GroupLayout(pn_ttkh);
        pn_ttkh.setLayout(pn_ttkhLayout);
        pn_ttkhLayout.setHorizontalGroup(
            pn_ttkhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_ttkhLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_ttkhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pn_ttkhLayout.createSequentialGroup()
                        .addComponent(lb_kh)
                        .addGap(22, 22, 22)
                        .addComponent(txt_kh, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(lb_hokh)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_hokh, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pn_ttkhLayout.createSequentialGroup()
                        .addComponent(lb_tenkh)
                        .addGap(18, 18, 18)
                        .addComponent(txt_tenkh)))
                .addGap(44, 44, 44)
                .addGroup(pn_ttkhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_sdtkh)
                    .addComponent(lb_dckh))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pn_ttkhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_dckh, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                    .addComponent(txt_sdtkh))
                .addContainerGap())
        );
        pn_ttkhLayout.setVerticalGroup(
            pn_ttkhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_ttkhLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_ttkhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_kh)
                    .addComponent(txt_kh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_hokh)
                    .addComponent(txt_hokh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_sdtkh)
                    .addComponent(txt_sdtkh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pn_ttkhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_tenkh)
                    .addComponent(txt_tenkh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_dckh)
                    .addComponent(txt_dckh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pn_dokh.setBackground(new java.awt.Color(255, 255, 204));
        pn_dokh.setBorder(javax.swing.BorderFactory.createTitledBorder("Thực hiện"));

        bt_addkh.setBackground(new java.awt.Color(204, 204, 204));
        bt_addkh.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bt_addkh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/add.png"))); // NOI18N
        bt_addkh.setText("Thêm");
        bt_addkh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_addkhActionPerformed(evt);
            }
        });

        bt_resetkh.setBackground(new java.awt.Color(204, 204, 204));
        bt_resetkh.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bt_resetkh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/reset.png"))); // NOI18N
        bt_resetkh.setText("Đặt lại");
        bt_resetkh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_resetkhActionPerformed(evt);
            }
        });

        bt_changekh.setBackground(new java.awt.Color(204, 204, 204));
        bt_changekh.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bt_changekh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/change.png"))); // NOI18N
        bt_changekh.setText("Sửa");
        bt_changekh.setMaximumSize(new java.awt.Dimension(65, 23));
        bt_changekh.setMinimumSize(new java.awt.Dimension(65, 23));
        bt_changekh.setPreferredSize(new java.awt.Dimension(65, 23));
        bt_changekh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_changekhActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pn_dokhLayout = new javax.swing.GroupLayout(pn_dokh);
        pn_dokh.setLayout(pn_dokhLayout);
        pn_dokhLayout.setHorizontalGroup(
            pn_dokhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_dokhLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bt_addkh, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103)
                .addComponent(bt_changekh, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
                .addComponent(bt_resetkh, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pn_dokhLayout.setVerticalGroup(
            pn_dokhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_dokhLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_dokhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt_addkh, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_changekh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bt_resetkh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pn_findkh.setBackground(new java.awt.Color(204, 255, 204));
        pn_findkh.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm"));

        txt_findkh.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_findkhKeyReleased(evt);
            }
        });

        lb_findkh.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lb_findkh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/find.png"))); // NOI18N
        lb_findkh.setText("Tìm kiếm:");

        javax.swing.GroupLayout pn_findkhLayout = new javax.swing.GroupLayout(pn_findkh);
        pn_findkh.setLayout(pn_findkhLayout);
        pn_findkhLayout.setHorizontalGroup(
            pn_findkhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_findkhLayout.createSequentialGroup()
                .addComponent(lb_findkh)
                .addGap(18, 18, 18)
                .addComponent(txt_findkh, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pn_findkhLayout.setVerticalGroup(
            pn_findkhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_findkhLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pn_findkhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_findkh, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_findkh, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        tb_kh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tb_kh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_khMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_kh);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout Panel2Layout = new javax.swing.GroupLayout(Panel2);
        Panel2.setLayout(Panel2Layout);
        Panel2Layout.setHorizontalGroup(
            Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(Panel2Layout.createSequentialGroup()
                        .addComponent(pn_dokh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pn_findkh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(pn_ttkh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        Panel2Layout.setVerticalGroup(
            Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pn_ttkh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pn_dokh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pn_findkh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bt_resetkhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_resetkhActionPerformed
        txt_kh.setText("");
        txt_hokh.setText("");
        txt_tenkh.setText("");
        txt_sdtkh.setText("");
        txt_dckh.setText("");
        txt_findkh.setText("");        
    }//GEN-LAST:event_bt_resetkhActionPerformed

    private void bt_changekhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_changekhActionPerformed
    if (bt_changekh.getText().toString().equals("Sửa")) {
        txt_hokh.setEnabled(true);
        txt_tenkh.setEnabled(true);
        txt_sdtkh.setEnabled(true);
        txt_dckh.setEnabled(true); 
            bt_changekh.setText("Xác nhận");}
    else {
        if (txt_kh.getText().length() != 0 && txt_hokh.getText().length() != 0
                && txt_tenkh.getText().length() != 0 && txt_sdtkh.getText().length() != 0
                && txt_dckh.getText().length() != 0) {
                bt_changekh.setText("Sửa");    
            int i = tb_kh.getSelectedRow();
            if(i>=0){
                    int k =JOptionPane.showConfirmDialog(null, "Xác nhận sửa", "Xác nhận", JOptionPane.YES_NO_CANCEL_OPTION);
                    if (k==1)
                    {
                        initData();
                        return;
                    }
                    if (k==2)
                    {
                        bt_changekhActionPerformed(evt);
                        return;
                    }                
                KhachHangDTO kh = getText();
                int check = bus.suaKh(kh,i);
                if(check == 1){
                    setModelValue(kh,i);
                    JOptionPane.showMessageDialog(null, "Sửa thành công");}
                }else{
                    JOptionPane.showMessageDialog(null, "Sửa thất bại");}                    
                }else{
                JOptionPane.showMessageDialog(null, "Bạn cần nhập đầy đủ thông tin vào bảng");}
            }
    }//GEN-LAST:event_bt_changekhActionPerformed

    private void bt_addkhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_addkhActionPerformed
    if (bt_addkh.getText().toString().equals("Thêm")) {
            txt_kh.setEnabled(true);
            txt_kh.setEditable(false);            
            txt_hokh.setEnabled(true);
            txt_tenkh.setEnabled(true);
            txt_sdtkh.setEnabled(true);
            txt_dckh.setEnabled(true);
            bt_addkh.setText("Xác nhận");
            txt_kh.setText("");
            txt_hokh.setText("");
            txt_tenkh.setText("");
            txt_sdtkh.setText("");
            txt_dckh.setText("");}
        else {
            if (txt_kh.getText().length() != 0 && txt_hokh.getText().length() != 0
                && txt_tenkh.getText().length() != 0 && txt_sdtkh.getText().length() != 0
                && txt_dckh.getText().length() != 0) {
                if(checkSoDienThoai(txt_sdtkh.getText())){
                    bt_addkh.setText("Thêm");
                    int k =JOptionPane.showConfirmDialog(null, "Xác nhận thêm", "Xác nhận", JOptionPane.YES_NO_CANCEL_OPTION);
                    if (k==1)
                    {
                        initData();
                        return;
                    }
                    if (k==2)
                    {
                        bt_addkhActionPerformed(evt);
                        return;
                    }                    
                KhachHangDTO kh = getText();
                Vector head = setVector(kh);
                int check = bus.themKh(kh);
                if(check == 1){ 
                    model.addRow(head);
                    tb_kh.setModel(model);
                    JOptionPane.showMessageDialog(null, "Thêm thành công");
                    }else{JOptionPane.showMessageDialog(null, "Mã đã tồn tại. Thêm thất bại");}                    
                }else{  JOptionPane.showMessageDialog(null, "Số điện thoại không đủ 10 số");}
            }else{ JOptionPane.showMessageDialog(null, "Bạn cần nhập đầy đủ thông tin vào bảng");}
        }
    auto_increaseMaKh();
    }//GEN-LAST:event_bt_addkhActionPerformed

    private void tb_khMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_khMouseClicked
        int i = tb_kh.getSelectedRow();
        if(i>=0){
            txt_kh.setText(tb_kh.getModel().getValueAt(i, 0).toString());
            txt_hokh.setText(tb_kh.getModel().getValueAt(i, 1).toString());
            txt_tenkh.setText(tb_kh.getModel().getValueAt(i, 2).toString());
            txt_sdtkh.setText(tb_kh.getModel().getValueAt(i, 3).toString());
            txt_dckh.setText(tb_kh.getModel().getValueAt(i, 4).toString());
        }
    }//GEN-LAST:event_tb_khMouseClicked

    private void txt_findkhKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_findkhKeyReleased
        search();
    }//GEN-LAST:event_txt_findkhKeyReleased

    private void txt_sdtkhKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_sdtkhKeyReleased
            if(!checkNumber(txt_sdtkh.getText())){
            JOptionPane.showMessageDialog(null, "Sai định dạng số điện thoại");}
    }//GEN-LAST:event_txt_sdtkhKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel2;
    private javax.swing.JButton bt_addkh;
    private javax.swing.JButton bt_changekh;
    private javax.swing.JButton bt_resetkh;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_dckh;
    private javax.swing.JLabel lb_findkh;
    private javax.swing.JLabel lb_hokh;
    private javax.swing.JLabel lb_kh;
    private javax.swing.JLabel lb_sdtkh;
    private javax.swing.JLabel lb_tenkh;
    private javax.swing.JPanel pn_dokh;
    private javax.swing.JPanel pn_findkh;
    private javax.swing.JPanel pn_ttkh;
    private javax.swing.JTable tb_kh;
    private javax.swing.JTextField txt_dckh;
    private javax.swing.JTextField txt_findkh;
    private javax.swing.JTextField txt_hokh;
    private javax.swing.JTextField txt_kh;
    private javax.swing.JTextField txt_sdtkh;
    private javax.swing.JTextField txt_tenkh;
    // End of variables declaration//GEN-END:variables
}

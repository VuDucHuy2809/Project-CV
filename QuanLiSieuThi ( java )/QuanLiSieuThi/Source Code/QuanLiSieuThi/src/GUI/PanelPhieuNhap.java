 
package GUI;
 
import BUS.ChiTietPhieuNhapBUS;
import BUS.PhieuNhapBUS;
import DTO.ChiTietPhieuNhapDTO;
import DTO.PhieuNhapDTO;
import java.awt.BorderLayout;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PanelPhieuNhap extends javax.swing.JPanel {
    DefaultTableModel model1 = new DefaultTableModel();
    DefaultTableModel model2 = new DefaultTableModel();    
    ArrayList<PhieuNhapDTO> tempsearch = new ArrayList<PhieuNhapDTO>();    
    ArrayList<PhieuNhapDTO> arr = new ArrayList<PhieuNhapDTO>();
    PhieuNhapBUS bus = new PhieuNhapBUS();
    ChiTietPhieuNhapBUS busct = new ChiTietPhieuNhapBUS();
    public static String maPNafterclick;    
    public PanelPhieuNhap() {
        initComponents();
        initData();
        model1 = (DefaultTableModel) tb_pnhap.getModel();
        model2 = (DefaultTableModel) tb_ctpnhap.getModel();
        load();
        loadinCbox();
        cb_nv.setEnabled(false);
        cb_nsx.setEnabled(false);  
    }
    private void initData(){
        txt_mpn.setEnabled(false);
        date_ngay.setEnabled(false);
        txt_ttien.setEnabled(false);
        cb_nv.setEnabled(false);
        cb_nsx.setEnabled(false);
        bt_backpn.setVisible(false);
        pn_fromto.setVisible(false);        
    }
    public PhieuNhapDTO getfromText(){
        PhieuNhapDTO pn = new PhieuNhapDTO();
        pn.setMaPN(txt_mpn.getText().trim());                    
        pn.setMaNV((String)cb_nv.getSelectedItem());
        pn.setMaNSX((String)cb_nsx.getSelectedItem());
        pn.setNgayNhap(new SimpleDateFormat("yyyy-MM-dd").format(date_ngay.getDate()));
        pn.setThanhTien(Double.parseDouble(txt_ttien.getText().trim()));      
        return pn;
    }    
    public void load(){
       try{
           bus.docPn();
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, "Lỗi kết nối đến Database.");
           return;
       }
       Vector header = new Vector();
        header.add("Mã phiếu nhập");
        header.add("Mã nhân viên");
        header.add("Mã NCC");
        header.add("Ngày nhập");
        header.add("Thành tiền");      
        model1 = new DefaultTableModel(header,0){
            public boolean isCellEditable(int row, int column)
                {
                  return false;
                }
       };
       showOnTablePN(bus.list);
    }
    public Vector setVectorPN(PhieuNhapDTO pn){
            Vector head = new Vector();
            head.add(pn.getMaPN());
            head.add(pn.getMaNV());
            head.add(pn.getMaNSX());
            head.add(pn.getNgayNhap());
            head.add(pn.getThanhTien());          
            return head;
    }    
    public void showOnTablePN(ArrayList<PhieuNhapDTO> list){
        model1.setRowCount(0);
        for(PhieuNhapDTO pn:list){
           Vector data = setVectorPN(pn);
           model1.addRow(data);
       }
       tb_pnhap.setModel(model1);
    }
    public void setModelValuePN(PhieuNhapDTO pn, int i){
        model1.setValueAt(pn.getMaPN(),i,0);
        model1.setValueAt(pn.getMaNV(),i,1);
        model1.setValueAt(pn.getMaNSX(),i,2);
        model1.setValueAt(pn.getNgayNhap(),i,3);
        model1.setValueAt(pn.getThanhTien(),i,4);       
        tb_pnhap.setModel(model1);            
    }
    public void loadCTPN(String MaPN){
        try {
            busct.docCTPN();
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Lỗi đọc CTPN từ DataBase!!!");
            return;}
        Vector header = new Vector();
        header.add("Mã phiếu nhập");
        header.add("Mã sản phẩm");
        header.add("Đơn giá chi tiết");
        header.add("Số lượng");
        header.add("Thành tiền");
        model2 = new DefaultTableModel(header,0){
            public boolean isCellEditable(int row, int column)
                {
                  return false;
                }
       };
        showOnTableCTPN(busct.listctpn,MaPN);
    }
    private void showOnTableCTPN(ArrayList<ChiTietPhieuNhapDTO> list, String MaPN) {
        model2.setRowCount(0);
        for (ChiTietPhieuNhapDTO ct : list){
          if (ct.getMaPN().equals(MaPN)||MaPN == null){
            Vector data = setVectorCTPN(ct);
            model2.addRow(data);}
        }
        tb_ctpnhap.setModel(model2);
    }    
    private Vector setVectorCTPN(ChiTietPhieuNhapDTO ct) {
        Vector row = new Vector();
        row.add(ct.getMaPN());
        row.add(ct.getMaSP());
        row.add(ct.getDonGia());        
        row.add(ct.getSoLuong());
        row.add(ct.getThanhTien_CT());
        return row;
    }   
    public void loadinCbox(){
        Vector cbMaNv=  bus.loadcb_nv();
        this.cb_nv.setModel(new DefaultComboBoxModel<>(cbMaNv));
        Vector cbMaNxb = bus.loadcb_nsx();
        this.cb_nsx.setModel(new DefaultComboBoxModel<>(cbMaNxb));
    }
    public void auto_increaseMaPn(){
        String i = "";
        int a;
        if(bus.docPn().size() <=0) {
        	a = 0;
        }else {
        PhieuNhapDTO pn= bus.docPn().get(bus.docPn().size()-1);
        	a= Integer.parseInt(pn.getMaPN().substring(2,5));
        }
        a++;
        if(a<10){ i="PN"+"00"+a; }
        if(10<=a && a<=99) {  i ="PN"+"0"+a; }
        if(a>100){  i="PN"+a; }
        txt_mpn.setText(i);
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pn_all = new javax.swing.JPanel();
        pn_ttpn = new javax.swing.JPanel();
        lb_mpn = new javax.swing.JLabel();
        txt_mpn = new javax.swing.JTextField();
        lb_nv = new javax.swing.JLabel();
        lb_nsx = new javax.swing.JLabel();
        lb_ngay = new javax.swing.JLabel();
        lb_ttien = new javax.swing.JLabel();
        txt_ttien = new javax.swing.JTextField();
        date_ngay = new com.toedter.calendar.JDateChooser();
        cb_nv = new javax.swing.JComboBox<>();
        cb_nsx = new javax.swing.JComboBox<>();
        pn_dopn = new javax.swing.JPanel();
        bt_addpn = new javax.swing.JButton();
        bt_resetpn = new javax.swing.JButton();
        bt_changepn = new javax.swing.JButton();
        pn_findpn = new javax.swing.JPanel();
        cb_tknc = new javax.swing.JComboBox<>();
        txt_tknc1 = new javax.swing.JTextField();
        bt_find = new javax.swing.JButton();
        pn_fromto = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        date_from = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        date_to = new com.toedter.calendar.JDateChooser();
        bt_backpn = new javax.swing.JButton();
        txt_tknc2 = new javax.swing.JTextField();
        pn_phieunhap = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_pnhap = new javax.swing.JTable(){
            public boolean isCellEditable ( int row, int col)
            {
                return false;
            }
        };
        pn_chitietpn = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_ctpnhap = new javax.swing.JTable(){
            public boolean isCellEditable ( int row, int col)
            {
                return false;
            }
        };
        jPanel1 = new javax.swing.JPanel();
        cb_TimKiem = new javax.swing.JComboBox<>();
        txt_TimKiem = new javax.swing.JTextField();
        btn_TimKiem = new javax.swing.JButton();

        pn_all.setBackground(new java.awt.Color(204, 204, 255));

        pn_ttpn.setBackground(new java.awt.Color(255, 255, 255));
        pn_ttpn.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin phiếu nhập", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(255, 102, 102))); // NOI18N

        lb_mpn.setText("Mã phiếu nhập:");

        lb_nv.setText("Mã nhân viên:");

        lb_nsx.setText("Mã nhà sản xuất:");

        lb_ngay.setText("Ngày nhập:");

        lb_ttien.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lb_ttien.setText("Thành tiền:");

        date_ngay.setDateFormatString("yyyy-MM-dd");

        cb_nv.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cb_nsx.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout pn_ttpnLayout = new javax.swing.GroupLayout(pn_ttpn);
        pn_ttpn.setLayout(pn_ttpnLayout);
        pn_ttpnLayout.setHorizontalGroup(
            pn_ttpnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_ttpnLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_ttpnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_ttpnLayout.createSequentialGroup()
                        .addGroup(pn_ttpnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_ngay)
                            .addComponent(lb_ttien))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pn_ttpnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(date_ngay, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                            .addComponent(txt_ttien)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_ttpnLayout.createSequentialGroup()
                        .addComponent(lb_nv)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cb_nv, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(10, 10, 10)
                        .addComponent(lb_nsx)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cb_nsx, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_ttpnLayout.createSequentialGroup()
                        .addComponent(lb_mpn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_mpn, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pn_ttpnLayout.setVerticalGroup(
            pn_ttpnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_ttpnLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_ttpnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_mpn)
                    .addComponent(txt_mpn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pn_ttpnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_nv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pn_ttpnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cb_nv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lb_nsx)
                        .addComponent(cb_nsx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pn_ttpnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(date_ngay, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(lb_ngay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pn_ttpnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_ttien, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_ttien))
                .addContainerGap())
        );

        pn_dopn.setBackground(new java.awt.Color(255, 255, 204));
        pn_dopn.setBorder(javax.swing.BorderFactory.createTitledBorder("Thực hiện"));

        bt_addpn.setBackground(new java.awt.Color(204, 204, 204));
        bt_addpn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bt_addpn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/add.png"))); // NOI18N
        bt_addpn.setText("Thêm");
        bt_addpn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_addpnActionPerformed(evt);
            }
        });

        bt_resetpn.setBackground(new java.awt.Color(204, 204, 204));
        bt_resetpn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bt_resetpn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/reset.png"))); // NOI18N
        bt_resetpn.setText("Reset");
        bt_resetpn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_resetpnActionPerformed(evt);
            }
        });

        bt_changepn.setBackground(new java.awt.Color(204, 204, 204));
        bt_changepn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bt_changepn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/change.png"))); // NOI18N
        bt_changepn.setText("Sửa");
        bt_changepn.setMaximumSize(new java.awt.Dimension(65, 23));
        bt_changepn.setMinimumSize(new java.awt.Dimension(65, 23));
        bt_changepn.setPreferredSize(new java.awt.Dimension(65, 23));
        bt_changepn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_changepnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pn_dopnLayout = new javax.swing.GroupLayout(pn_dopn);
        pn_dopn.setLayout(pn_dopnLayout);
        pn_dopnLayout.setHorizontalGroup(
            pn_dopnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_dopnLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bt_changepn, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bt_addpn, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bt_resetpn, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
        );
        pn_dopnLayout.setVerticalGroup(
            pn_dopnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bt_changepn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(bt_resetpn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(bt_addpn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pn_findpn.setBackground(new java.awt.Color(204, 255, 204));
        pn_findpn.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm nâng cao"));

        cb_tknc.setBackground(new java.awt.Color(255, 255, 204));
        cb_tknc.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cb_tknc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Thành tiền", "Ngày nhập" }));
        cb_tknc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_tkncActionPerformed(evt);
            }
        });

        bt_find.setBackground(new java.awt.Color(204, 204, 204));
        bt_find.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bt_find.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/find.png"))); // NOI18N
        bt_find.setText("Tìm kiếm");
        bt_find.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_findActionPerformed(evt);
            }
        });

        pn_fromto.setBackground(new java.awt.Color(204, 255, 204));

        jLabel1.setText("Từ:");

        date_from.setDateFormatString("yyyy-MM-dd");

        jLabel2.setText("đến:");

        date_to.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout pn_fromtoLayout = new javax.swing.GroupLayout(pn_fromto);
        pn_fromto.setLayout(pn_fromtoLayout);
        pn_fromtoLayout.setHorizontalGroup(
            pn_fromtoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_fromtoLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(date_from, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(date_to, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                .addContainerGap())
        );
        pn_fromtoLayout.setVerticalGroup(
            pn_fromtoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_fromtoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_fromtoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_fromtoLayout.createSequentialGroup()
                        .addComponent(date_to, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_fromtoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(date_from, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6))
        );

        bt_backpn.setBackground(new java.awt.Color(204, 204, 204));
        bt_backpn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bt_backpn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/back.png"))); // NOI18N
        bt_backpn.setText("Trở về");
        bt_backpn.setMaximumSize(new java.awt.Dimension(65, 23));
        bt_backpn.setMinimumSize(new java.awt.Dimension(65, 23));
        bt_backpn.setPreferredSize(new java.awt.Dimension(65, 23));
        bt_backpn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_backpnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pn_findpnLayout = new javax.swing.GroupLayout(pn_findpn);
        pn_findpn.setLayout(pn_findpnLayout);
        pn_findpnLayout.setHorizontalGroup(
            pn_findpnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_findpnLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_findpnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_findpnLayout.createSequentialGroup()
                        .addComponent(cb_tknc, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_tknc1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_tknc2)
                        .addGap(3, 3, 3))
                    .addComponent(pn_fromto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(pn_findpnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_findpnLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(bt_backpn, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_findpnLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_find, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pn_findpnLayout.setVerticalGroup(
            pn_findpnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_findpnLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_findpnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pn_findpnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cb_tknc, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_tknc1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bt_backpn, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_tknc2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pn_findpnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pn_fromto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_find))
                .addContainerGap())
        );

        pn_phieunhap.setBackground(new java.awt.Color(255, 255, 255));
        pn_phieunhap.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Phiếu nhập", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 10), new java.awt.Color(255, 0, 0))); // NOI18N

        tb_pnhap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tb_pnhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_pnhapMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tb_pnhapMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tb_pnhap);

        javax.swing.GroupLayout pn_phieunhapLayout = new javax.swing.GroupLayout(pn_phieunhap);
        pn_phieunhap.setLayout(pn_phieunhapLayout);
        pn_phieunhapLayout.setHorizontalGroup(
            pn_phieunhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        pn_phieunhapLayout.setVerticalGroup(
            pn_phieunhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
        );

        pn_chitietpn.setBackground(new java.awt.Color(255, 255, 255));
        pn_chitietpn.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chi tiết", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 10), new java.awt.Color(0, 102, 102))); // NOI18N

        tb_ctpnhap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tb_ctpnhap);

        javax.swing.GroupLayout pn_chitietpnLayout = new javax.swing.GroupLayout(pn_chitietpn);
        pn_chitietpn.setLayout(pn_chitietpnLayout);
        pn_chitietpnLayout.setHorizontalGroup(
            pn_chitietpnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        pn_chitietpnLayout.setVerticalGroup(
            pn_chitietpnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 10), new java.awt.Color(255, 0, 0))); // NOI18N

        cb_TimKiem.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cb_TimKiem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã phiếu nhập", "Mã nhân viên", "Mã nhà sản xuất" }));

        btn_TimKiem.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_TimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/find.png"))); // NOI18N
        btn_TimKiem.setText("Tìm kiếm");
        btn_TimKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_TimKiemMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cb_TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_TimKiem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_TimKiem, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(btn_TimKiem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(cb_TimKiem, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        javax.swing.GroupLayout pn_allLayout = new javax.swing.GroupLayout(pn_all);
        pn_all.setLayout(pn_allLayout);
        pn_allLayout.setHorizontalGroup(
            pn_allLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_allLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_allLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pn_phieunhap, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_allLayout.createSequentialGroup()
                        .addGroup(pn_allLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pn_ttpn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pn_dopn, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pn_allLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pn_findpn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pn_chitietpn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        pn_allLayout.setVerticalGroup(
            pn_allLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_allLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_allLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pn_ttpn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pn_chitietpn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_allLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pn_allLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pn_dopn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pn_findpn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pn_phieunhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pn_all, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pn_all, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bt_addpnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_addpnActionPerformed
        if (bt_addpn.getText().toString().equals("Thêm")) {
            txt_mpn.setEnabled(true);
            txt_mpn.setEditable(false);
            date_ngay.setEnabled(true);
            txt_ttien.setEnabled(true);
            cb_nv.setEnabled(false);
            cb_nsx.setEnabled(true);
            txt_ttien.setEditable(false);
            bt_addpn.setText("Xác nhận");
            txt_mpn.setText("");
            cb_nv.setSelectedItem(Login.username);
            cb_nsx.setSelectedItem("");
            date_ngay.setDate(null);
            txt_ttien.setText("0");}
        else {
            if (txt_mpn.getText().length() != 0 && cb_nsx.getSelectedItem()!= null
                && cb_nv.getSelectedItem()!= null && txt_ttien.getText().length() != 0
                && date_ngay.getDate()!= null ) {
                bt_addpn.setText("Thêm");
            int k = JOptionPane.showConfirmDialog(null, "Xác nhận thêm", "Xác nhận", JOptionPane.YES_NO_CANCEL_OPTION);
            if (k==1)
            {
                initData();
                return;
            }
            if (k==2)
            {
                bt_addpnActionPerformed(evt);
                return;
            }                
                PhieuNhapDTO pn = getfromText();
                Vector head = setVectorPN(pn);
                int check = bus.themPn(pn);
                if(check == 1){
                    model1.addRow(head);
                    tb_pnhap.setModel(model1);
                    JOptionPane.showMessageDialog(null, "Thêm thành công");
                }else{
                    JOptionPane.showMessageDialog(null, "Mã đã tồn tại. Thêm thất bại");}
            }else{
                JOptionPane.showMessageDialog(null, "Bạn cần nhập đầy đủ thông tin vào bảng");}
        }
    auto_increaseMaPn();
    }//GEN-LAST:event_bt_addpnActionPerformed

    private void bt_resetpnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_resetpnActionPerformed
        txt_mpn.setText("");
        cb_nv.setSelectedIndex(0);
        cb_nsx.setSelectedIndex(0);
        date_ngay.setDate(null);
        txt_ttien.setText("0");
        txt_tknc1.setText("");
        txt_tknc2.setText("");
        txt_TimKiem.setText("");            
    }//GEN-LAST:event_bt_resetpnActionPerformed

    private void bt_backpnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_backpnActionPerformed
        load();
        bt_backpn.setVisible(false);
    }//GEN-LAST:event_bt_backpnActionPerformed

    private void bt_changepnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_changepnActionPerformed
        if (bt_changepn.getText().toString().equals("Sửa")) {
            txt_mpn.setEnabled(false);
            date_ngay.setEnabled(true);
            txt_ttien.setEnabled(true);
            cb_nv.setEnabled(false);
            cb_nsx.setEnabled(true);
            txt_ttien.setEditable(false);
            cb_nv.setSelectedItem(Login.username);
            bt_changepn.setText("Xác nhận");}
        else {
            if (cb_nsx.getSelectedItem()!= null & date_ngay.getDate()!= null
                && cb_nv.getSelectedItem()!= null && txt_ttien.getText().length() != 0) {
                bt_changepn.setText("Sửa");
                int i = tb_pnhap.getSelectedRow();
                if(i>=0){
            int k = JOptionPane.showConfirmDialog(null, "Xác nhận sửa", "Xác nhận", JOptionPane.YES_NO_CANCEL_OPTION);
            if (k==1)
            {
                initData();
                return;
            }
            if (k==2)
            {
                bt_changepnActionPerformed(evt);
                return;
            }                    
                    PhieuNhapDTO pn = getfromText();
                    int check = bus.suaPn(pn,i);
                    if(check == 1){
                        setModelValuePN(pn,i);
                        JOptionPane.showMessageDialog(null, "Sửa thành công");}
                }else{
                    JOptionPane.showMessageDialog(null, "Sửa thất bại");}
            }else{
                JOptionPane.showMessageDialog(null, "Bạn cần nhập đầy đủ thông tin vào bảng");}
        }
    }//GEN-LAST:event_bt_changepnActionPerformed

    private void bt_findActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_findActionPerformed
   if(cb_tknc.getSelectedIndex()==0){
      searchnangcao(String.valueOf(cb_tknc.getSelectedItem()) , txt_tknc1.getText().toLowerCase(), txt_tknc2.getText().toLowerCase()); }
     if(cb_tknc.getSelectedIndex()==1){
       try {
            searchngay(new SimpleDateFormat("yyyy-MM-dd").format(date_from.getDate()),new SimpleDateFormat("yyyy-MM-dd").format(date_to.getDate()));
           } catch (Exception ex) {
                  Logger.getLogger(PanelHoaDon.class.getName()).log(Level.SEVERE, null, ex); }
       } else{ JOptionPane.showMessageDialog(null, "Không có kết quả phù hợp");}
    }//GEN-LAST:event_bt_findActionPerformed

    private void tb_pnhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_pnhapMouseClicked
    int i = tb_pnhap.getSelectedRow();
     if(i>=0){
        txt_mpn.setText(tb_pnhap.getModel().getValueAt(i, 0).toString());
        cb_nv.setSelectedItem(tb_pnhap.getModel().getValueAt(i, 1).toString());
        cb_nsx.setSelectedItem(tb_pnhap.getModel().getValueAt(i, 2).toString());
        try {
             date_ngay.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(tb_pnhap.getModel().getValueAt(i,3)+""));
        } catch (ParseException ex) {ex.printStackTrace();}
        txt_ttien.setText(tb_pnhap.getModel().getValueAt(i, 4).toString());
        loadCTPN(txt_mpn.getText());
        }
    }//GEN-LAST:event_tb_pnhapMouseClicked

    private void btn_TimKiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_TimKiemMouseClicked
        String[] header = {"Mã phiếu nhập", "Mã nhân viên", "Mã NCC", "Ngày nhập", "Thành tiền"};
        DefaultTableModel modelsearch = new DefaultTableModel(header, 0);
        ArrayList<PhieuNhapDTO> pn;
        pn = bus.timkiem(String.valueOf(cb_TimKiem.getSelectedItem()), txt_TimKiem.getText().toLowerCase());
        if (!pn.isEmpty()){
            for (int i = 0; i < pn.size(); i++){
                Object[] row = {pn.get(i).getMaPN(), pn.get(i).getMaNV(), pn.get(i).getMaNSX(), pn.get(i).getNgayNhap(), pn.get(i).getThanhTien()};
                modelsearch.addRow(row);
            }
            tempsearch.addAll(arr);
            tb_pnhap.setModel(modelsearch);
            bt_backpn.setVisible(true);}
        else {
            JOptionPane.showMessageDialog(null, "Không có kết quả phù hợp");}        
    }//GEN-LAST:event_btn_TimKiemMouseClicked

    private void cb_tkncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_tkncActionPerformed
        if(cb_tknc.getSelectedIndex()==0){
            pn_fromto.setVisible(false);
            txt_tknc1.setEnabled(true);
            txt_tknc2.setEnabled(true);            
        }
        if(cb_tknc.getSelectedIndex()== 1){
            pn_fromto.setVisible(true);
            txt_tknc1.setEnabled(false);
            txt_tknc2.setEnabled(false);
        } 
    }//GEN-LAST:event_cb_tkncActionPerformed

    private void tb_pnhapMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_pnhapMousePressed
        if(evt.getClickCount()==2 && tb_pnhap.getSelectedRow()!=-1){
        maPNafterclick = txt_mpn.getText();
        this.removeAll();
        this.setLayout(new BorderLayout());
        this.add(new PanelChiTietPhieuNhap(maPNafterclick));
        this.validate();
        this.repaint();}
    }//GEN-LAST:event_tb_pnhapMousePressed
    public void searchngay(String from ,String to)throws Exception{
        model1.setRowCount(0);
        for(PhieuNhapDTO pn: bus.timTheoNgay(from,to)){
            model1.addRow(new Object[]{
            pn.getMaPN(), pn.getMaNV(), pn.getMaNSX(), pn.getNgayNhap(), pn.getThanhTien()
            });
        }
        tempsearch.addAll(arr);
        bt_backpn.setVisible(true);
      
    }
    public void searchnangcao(String key,String from,String to){
        for(PhieuNhapDTO pn:bus.timkiemHDnc(key,from,to)){
            model1.addRow(new Object[]{
            pn.getMaPN(), pn.getMaNV(), pn.getMaNSX(), pn.getNgayNhap(), pn.getThanhTien()
            });
            tempsearch.addAll(arr);
            bt_backpn.setVisible(true);
           }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_addpn;
    private javax.swing.JButton bt_backpn;
    private javax.swing.JButton bt_changepn;
    private javax.swing.JButton bt_find;
    private javax.swing.JButton bt_resetpn;
    private javax.swing.JButton btn_TimKiem;
    private javax.swing.JComboBox<String> cb_TimKiem;
    private javax.swing.JComboBox<String> cb_nsx;
    private javax.swing.JComboBox<String> cb_nv;
    private javax.swing.JComboBox<String> cb_tknc;
    private com.toedter.calendar.JDateChooser date_from;
    private com.toedter.calendar.JDateChooser date_ngay;
    private com.toedter.calendar.JDateChooser date_to;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lb_mpn;
    private javax.swing.JLabel lb_ngay;
    private javax.swing.JLabel lb_nsx;
    private javax.swing.JLabel lb_nv;
    private javax.swing.JLabel lb_ttien;
    private javax.swing.JPanel pn_all;
    private javax.swing.JPanel pn_chitietpn;
    private javax.swing.JPanel pn_dopn;
    private javax.swing.JPanel pn_findpn;
    private javax.swing.JPanel pn_fromto;
    private javax.swing.JPanel pn_phieunhap;
    private javax.swing.JPanel pn_ttpn;
    private javax.swing.JTable tb_ctpnhap;
    private javax.swing.JTable tb_pnhap;
    private javax.swing.JTextField txt_TimKiem;
    private javax.swing.JTextField txt_mpn;
    private javax.swing.JTextField txt_tknc1;
    private javax.swing.JTextField txt_tknc2;
    private javax.swing.JTextField txt_ttien;
    // End of variables declaration//GEN-END:variables
}


package GUI;

import BUS.ChiTietPhieuNhapBUS;
import BUS.ChiTietPhieuNhapBUS;
import BUS.PhieuNhapBUS;
import BUS.SanPhamCTBUS;
import DTO.ChiTietPhieuNhapDTO;
import DTO.PhieuNhapDTO;
import DTO.SanPhamDTO;
import static GUI.PanelPhieuNhap.maPNafterclick;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static untils.CheckData.checkNumber;


public class PanelChiTietPhieuNhap extends javax.swing.JPanel {
    DefaultTableModel model1 = new DefaultTableModel();
    DefaultTableModel model2 = new DefaultTableModel();
    ArrayList<ChiTietPhieuNhapDTO> tempsearch = new ArrayList<ChiTietPhieuNhapDTO>();
    ArrayList<ChiTietPhieuNhapDTO> arr = new ArrayList<ChiTietPhieuNhapDTO>();
    ChiTietPhieuNhapBUS bus = new ChiTietPhieuNhapBUS();
    SanPhamCTBUS bussp = new SanPhamCTBUS();
    PhieuNhapBUS buspn = new PhieuNhapBUS();
    public PanelChiTietPhieuNhap() {
        initComponents();
        model1 = (DefaultTableModel) tb_ctpn.getModel();
        model2 = (DefaultTableModel) tb_sanpham.getModel();        
        initData();
        load();
        loadSanPham(null);
        loadinCbox();
        bt_backctpn.setVisible(false);
    }
    
    public PanelChiTietPhieuNhap(String mapn) {
        initComponents();
        model1 = (DefaultTableModel) tb_ctpn.getModel();
        model2 = (DefaultTableModel) tb_sanpham.getModel();        
        initData();
        loadforclick(maPNafterclick);
        loadSanPham(null);
        loadinCbox();
        cb_pn.setSelectedItem(maPNafterclick);
        bt_backctpn.setVisible(false);
    }
    
    private void initData() {
        cb_pn.setEnabled(false);
        cb_sanpham.setEnabled(false);
        txt_soluong.setEnabled(false);
        txt_dongia.setEnabled(false);
        txt_ttien.setEnabled(false);
        bt_backctpn.setVisible(false);
    }   
    
    public void load() {
        ChiTietPhieuNhapBUS bus = new ChiTietPhieuNhapBUS();
        try{
            bus.docCTPN();
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Lỗi kết nối đến DataBase!!!");
            return;}
        Vector header = new Vector();
        header.add("Mã phiếu nhập");
        header.add("Mã sản phẩm");
        header.add("Đơn giá chi tiết");
        header.add("Số lượng");
        header.add("Thành tiền");
        model1 = new DefaultTableModel(header, 0){
            public boolean isCellEditTable(int row, int column){
                return false;}
        };
        showOnTableCTPN(bus.listctpn);   
    }
    
    public void loadforclick(String mapn) {
        ChiTietPhieuNhapBUS bus = new ChiTietPhieuNhapBUS();
        try{
            bus.docCTPN();
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Lỗi kết nối đến DataBase!!!");
            return;}
        Vector header;
        header = new Vector();
        header.add("Mã phiếu nhập");
        header.add("Mã sản phẩm");
        header.add("Đơn giá chi tiết");
        header.add("Số lượng");
        header.add("Thành tiền");
        model1 = new DefaultTableModel(header, 0){
            public boolean isCellEditTable(int row, int column){
                return false;}
        };
        showOnTableCTPNforclick(bus.listctpn,mapn);   
    }
    
    public void showOnTableCTPN(ArrayList<ChiTietPhieuNhapDTO> listctpn) {
        model1.setRowCount(0);
        for (ChiTietPhieuNhapDTO ctpn : listctpn){
            Vector data = setVectorCTPN(ctpn);
            model1.addRow(data);
        }
        tb_ctpn.setModel(model1);
    }

    public void showOnTableCTPNforclick(ArrayList<ChiTietPhieuNhapDTO> listctpn,String mapn) {
        model1.setRowCount(0);
        for (ChiTietPhieuNhapDTO ctpn : listctpn){
            if(ctpn.getMaPN().equals(mapn)){
            Vector data = setVectorCTPN(ctpn);
            model1.addRow(data);}
        }
        tb_ctpn.setModel(model1);
    }    
    
    public Vector setVectorCTPN(ChiTietPhieuNhapDTO ctpn) {
        Vector temp = new Vector();
        temp.add(ctpn.getMaPN());
        temp.add(ctpn.getMaSP());
        temp.add(ctpn.getDonGia());
        temp.add(ctpn.getSoLuong());
        temp.add(ctpn.getThanhTien_CT());
        return temp;
    }
    
    public ChiTietPhieuNhapDTO getText(){
        ChiTietPhieuNhapDTO ctpn = new ChiTietPhieuNhapDTO();
        ctpn.setMaPN((String)cb_pn.getSelectedItem());
        ctpn.setMaSP((String)cb_sanpham.getSelectedItem());
        ctpn.setDonGia(Double.parseDouble(txt_dongia.getText().trim()));
        ctpn.setSoLuong(Integer.parseInt(txt_soluong.getText().trim()));
        ctpn.setThanhTien_CT(Double.parseDouble(txt_ttien.getText().trim()));
        return ctpn;
    }
    
    public void setModelValueCTPN(ChiTietPhieuNhapDTO ctpn, int i){
        model1.setValueAt(ctpn.getMaPN(), i, 0);
        model1.setValueAt(ctpn.getMaSP(), i, 1);
        model1.setValueAt(ctpn.getDonGia(), i, 2);
        model1.setValueAt(ctpn.getSoLuong(), i, 3);
        model1.setValueAt(ctpn.getThanhTien_CT(), i, 4);
        tb_ctpn.setModel(model1);
    }
    
    public void loadSanPham(String masanpham){
        SanPhamCTBUS bussp = new SanPhamCTBUS();
        try {
            bussp.docSanphamforCT();
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Lỗi đọc sản phẩm trong CTPN từ DataBase!!!");
            return;
        }
        Vector header = new Vector();
        header.add("Mã sản phẩm");
        header.add("Tên sản phẩm");
        header.add("Đơn giá");
        header.add("Số lượng");
        model2 = new DefaultTableModel(header,0){
            public boolean isCellEditable(int row, int column)
                {
                  return false;
                }
       };
        showOnTableSP(bussp.list1,masanpham);
    }
    
    private void showOnTableSP(ArrayList<SanPhamDTO> list1, String masp) {
        model2.setRowCount(0);
        for (SanPhamDTO s : list1)
        {
            if (s.getMaSP().equals(masp)||masp == null)
            {
            Vector data = setVectorSP(s);
            model2.addRow(data);
            }
        }
        tb_sanpham.setModel(model2);
    }
    
    private Vector setVectorSP(SanPhamDTO s) {
        Vector row = new Vector();
        row.add(s.getMaSP());
        row.add(s.getTenSP());
        row.add(s.getDonGia());
        row.add(s.getSoLuong());
        return row;
    }
    
    public void loadinCbox(){
        Vector cbMaPn=bus.loadcb_pn();
        this.cb_pn.setModel(new DefaultComboBoxModel<>(cbMaPn));
        Vector cbMaSach=  bus.loadcb_sanpham();
        this.cb_sanpham.setModel(new DefaultComboBoxModel<>(cbMaSach));
    }
    
    public void showSanpham2(){
        for(SanPhamDTO s :bussp.docSanphamforCT()){
        model2.addRow(new Object[]{
            s.getMaSP(),s.getTenSP(),s.getDonGia(),s.getSoLuong()
        });
      }
    }
    
    public void reset(){
        txt_dongia.setText("");
        cb_pn.setSelectedIndex(0);
        cb_sanpham.setSelectedIndex(0);
        txt_ttien.setText("");
        txt_soluong.setText("");
        txt_TimKiem.setText("");
        txt_tknc1.setText("");
        txt_tknc2.setText("");
    }
    
    public void changeSL_afteradd(){
        int input = Integer.parseInt(txt_soluong.getText());
        int soluongsach = bussp.getSLb((String)cb_sanpham.getSelectedItem());
        int i=tb_sanpham.getSelectedRow();
        if(i>=0){
          SanPhamDTO s = new SanPhamDTO();
          int SLnew = soluongsach + input;
          if(bussp.changeSLb((String)cb_sanpham.getSelectedItem(),SLnew)==1){        
            s.setSoLuong(SLnew);
            bussp.list1.set(i,s);          
            model2.setValueAt(s.getSoLuong(), i, 3);
          }
        }
    } //tăng số lượng sản phẩm khi thêm chi tiết phiếu nhập
    
    public void changedSLinctpn(int input,int available){
        int soluongsach = bussp.getSLb((String)cb_sanpham.getSelectedItem());
        int change = Math.abs(input - available);        
        if(input > available){
        int i = tb_ctpn.getSelectedRow();
        if(i>=0){
         int SLnew = soluongsach+change;
         SanPhamDTO s = new SanPhamDTO();
          if(bussp.changeSLb((String)cb_sanpham.getSelectedItem(),SLnew)==1){
            s.setSoLuong(SLnew);
            model2.setRowCount(0);
            showSanpham2();  } 
           }
        }
        if(input < available){
        int i = tb_ctpn.getSelectedRow();
        if(i>=0){
         int SLnew = soluongsach-change;
         SanPhamDTO s = new SanPhamDTO();
          if(bussp.changeSLb((String)cb_sanpham.getSelectedItem(),SLnew)==1){
            s.setSoLuong(SLnew);
            model2.setRowCount(0);
            showSanpham2();  } 
           }
        }
    }//Tăng giảm số lượng sản phẩm sau khi sửa
    
    public void changelastThanhtien(){
        double thanhtiennew = bus.getThanhTienPnfromCTPN((String)cb_pn.getSelectedItem());
        
       buspn.changeThanhtien_afterdec((String)cb_pn.getSelectedItem(), thanhtiennew);

    }    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pn_all = new javax.swing.JPanel();
        pn_ctpn = new javax.swing.JPanel();
        lb_dongia = new javax.swing.JLabel();
        txt_dongia = new javax.swing.JTextField();
        lb_mpn = new javax.swing.JLabel();
        lb_sanpham = new javax.swing.JLabel();
        lb_ttien = new javax.swing.JLabel();
        txt_ttien = new javax.swing.JTextField();
        cb_pn = new javax.swing.JComboBox<>();
        cb_sanpham = new javax.swing.JComboBox<>();
        lb_soluong = new javax.swing.JLabel();
        txt_soluong = new javax.swing.JTextField();
        pn_doctpn = new javax.swing.JPanel();
        bt_addctpn = new javax.swing.JButton();
        bt_resetctpn = new javax.swing.JButton();
        bt_changectpn = new javax.swing.JButton();
        pn_table = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_ctpn = new javax.swing.JTable(){
            public boolean isCellEditable ( int row, int col)
            {
                return false;

            }};
            pn_sanpham = new javax.swing.JPanel();
            jScrollPane2 = new javax.swing.JScrollPane();
            tb_sanpham = new javax.swing.JTable(){
                public boolean isCellEditable ( int row, int col)
                {
                    return false;
                }
            };
            pn_find = new javax.swing.JPanel();
            cb_TimKiem = new javax.swing.JComboBox<>();
            txt_TimKiem = new javax.swing.JTextField();
            btn_TimKiem = new javax.swing.JButton();
            pn_tknc = new javax.swing.JPanel();
            cb_tknc = new javax.swing.JComboBox<>();
            btn_tknc = new javax.swing.JButton();
            bt_backctpn = new javax.swing.JButton();
            pn_fromto = new javax.swing.JPanel();
            jLabel1 = new javax.swing.JLabel();
            jLabel2 = new javax.swing.JLabel();
            txt_tknc1 = new javax.swing.JTextField();
            txt_tknc2 = new javax.swing.JTextField();
            jLabel3 = new javax.swing.JLabel();

            pn_all.setBackground(new java.awt.Color(0, 204, 204));

            pn_ctpn.setBackground(new java.awt.Color(255, 255, 255));
            pn_ctpn.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chi tiết phiếu nhập", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(255, 102, 102))); // NOI18N

            lb_dongia.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
            lb_dongia.setText("Đơn giá:");

            lb_mpn.setText("Mã phiếu nhập:");

            lb_sanpham.setText("Mã sản phẩm:");

            lb_ttien.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
            lb_ttien.setText("Thành tiền:");

            cb_pn.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

            cb_sanpham.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

            lb_soluong.setText("Số lượng:");

            txt_soluong.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyReleased(java.awt.event.KeyEvent evt) {
                    txt_soluongKeyReleased(evt);
                }
            });

            javax.swing.GroupLayout pn_ctpnLayout = new javax.swing.GroupLayout(pn_ctpn);
            pn_ctpn.setLayout(pn_ctpnLayout);
            pn_ctpnLayout.setHorizontalGroup(
                pn_ctpnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pn_ctpnLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(pn_ctpnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lb_mpn)
                        .addComponent(lb_soluong)
                        .addComponent(lb_ttien))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(pn_ctpnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pn_ctpnLayout.createSequentialGroup()
                            .addGroup(pn_ctpnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txt_soluong)
                                .addComponent(cb_pn, 0, 102, Short.MAX_VALUE))
                            .addGap(18, 18, 18)
                            .addGroup(pn_ctpnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lb_sanpham)
                                .addComponent(lb_dongia))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(pn_ctpnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cb_sanpham, 0, 131, Short.MAX_VALUE)
                                .addComponent(txt_dongia)))
                        .addComponent(txt_ttien))
                    .addContainerGap())
            );
            pn_ctpnLayout.setVerticalGroup(
                pn_ctpnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pn_ctpnLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(pn_ctpnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lb_mpn)
                        .addComponent(cb_pn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lb_sanpham)
                        .addComponent(cb_sanpham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(pn_ctpnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_dongia, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lb_dongia)
                        .addComponent(txt_soluong, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lb_soluong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                    .addGroup(pn_ctpnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lb_ttien)
                        .addComponent(txt_ttien, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(9, 9, 9))
            );

            pn_doctpn.setBackground(new java.awt.Color(204, 255, 204));
            pn_doctpn.setBorder(javax.swing.BorderFactory.createTitledBorder("Thực hiện"));

            bt_addctpn.setBackground(new java.awt.Color(204, 204, 204));
            bt_addctpn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
            bt_addctpn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/add.png"))); // NOI18N
            bt_addctpn.setText("Thêm");
            bt_addctpn.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    bt_addctpnActionPerformed(evt);
                }
            });

            bt_resetctpn.setBackground(new java.awt.Color(204, 204, 204));
            bt_resetctpn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
            bt_resetctpn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/reset.png"))); // NOI18N
            bt_resetctpn.setText("Reset");
            bt_resetctpn.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    bt_resetctpnActionPerformed(evt);
                }
            });

            bt_changectpn.setBackground(new java.awt.Color(204, 204, 204));
            bt_changectpn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
            bt_changectpn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/change.png"))); // NOI18N
            bt_changectpn.setText("Sửa");
            bt_changectpn.setMaximumSize(new java.awt.Dimension(65, 23));
            bt_changectpn.setMinimumSize(new java.awt.Dimension(65, 23));
            bt_changectpn.setPreferredSize(new java.awt.Dimension(65, 23));
            bt_changectpn.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    bt_changectpnActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout pn_doctpnLayout = new javax.swing.GroupLayout(pn_doctpn);
            pn_doctpn.setLayout(pn_doctpnLayout);
            pn_doctpnLayout.setHorizontalGroup(
                pn_doctpnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_doctpnLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(bt_addctpn, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(48, 48, 48)
                    .addComponent(bt_changectpn, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bt_resetctpn, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
            );
            pn_doctpnLayout.setVerticalGroup(
                pn_doctpnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pn_doctpnLayout.createSequentialGroup()
                    .addGroup(pn_doctpnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bt_addctpn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bt_changectpn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bt_resetctpn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(12, Short.MAX_VALUE))
            );

            pn_table.setBackground(new java.awt.Color(255, 255, 255));
            pn_table.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chi tiết", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 0, 0))); // NOI18N

            tb_ctpn.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                    {},
                    {},
                    {},
                    {}
                },
                new String [] {

                }
            ));
            tb_ctpn.setToolTipText("");
            tb_ctpn.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    tb_ctpnMouseClicked(evt);
                }
            });
            jScrollPane1.setViewportView(tb_ctpn);

            javax.swing.GroupLayout pn_tableLayout = new javax.swing.GroupLayout(pn_table);
            pn_table.setLayout(pn_tableLayout);
            pn_tableLayout.setHorizontalGroup(
                pn_tableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            );
            pn_tableLayout.setVerticalGroup(
                pn_tableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
            );

            pn_sanpham.setBackground(new java.awt.Color(255, 255, 255));
            pn_sanpham.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 102, 102))); // NOI18N

            tb_sanpham.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                    "Mã sản phẩm", "Tên sản phẩm", "Đơn giá", "Số lượng"
                }
            ));
            tb_sanpham.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    tb_sanphamMouseClicked(evt);
                }
            });
            jScrollPane2.setViewportView(tb_sanpham);

            javax.swing.GroupLayout pn_sanphamLayout = new javax.swing.GroupLayout(pn_sanpham);
            pn_sanpham.setLayout(pn_sanphamLayout);
            pn_sanphamLayout.setHorizontalGroup(
                pn_sanphamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            );
            pn_sanphamLayout.setVerticalGroup(
                pn_sanphamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            );

            pn_find.setBackground(new java.awt.Color(255, 255, 255));
            pn_find.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm"));

            cb_TimKiem.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
            cb_TimKiem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã phiếu nhập", "Mã sản phẩm" }));

            btn_TimKiem.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
            btn_TimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/find.png"))); // NOI18N
            btn_TimKiem.setText("Tìm kiếm");
            btn_TimKiem.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    btn_TimKiemMouseClicked(evt);
                }
            });

            javax.swing.GroupLayout pn_findLayout = new javax.swing.GroupLayout(pn_find);
            pn_find.setLayout(pn_findLayout);
            pn_findLayout.setHorizontalGroup(
                pn_findLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_findLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(cb_TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(txt_TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(btn_TimKiem)
                    .addContainerGap())
            );
            pn_findLayout.setVerticalGroup(
                pn_findLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pn_findLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(pn_findLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cb_TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );

            pn_tknc.setBackground(new java.awt.Color(255, 255, 204));
            pn_tknc.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm nâng cao"));

            cb_tknc.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
            cb_tknc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đơn giá", "Thành tiền" }));

            btn_tknc.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
            btn_tknc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/find.png"))); // NOI18N
            btn_tknc.setText("Tìm kiếm");
            btn_tknc.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    btn_tkncMouseClicked(evt);
                }
            });

            bt_backctpn.setBackground(new java.awt.Color(204, 204, 204));
            bt_backctpn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
            bt_backctpn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/back.png"))); // NOI18N
            bt_backctpn.setText("Back");
            bt_backctpn.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    bt_backctpnActionPerformed(evt);
                }
            });

            pn_fromto.setBackground(new java.awt.Color(255, 255, 204));

            jLabel1.setText("Từ:");

            jLabel2.setText("đến:");

            javax.swing.GroupLayout pn_fromtoLayout = new javax.swing.GroupLayout(pn_fromto);
            pn_fromto.setLayout(pn_fromtoLayout);
            pn_fromtoLayout.setHorizontalGroup(
                pn_fromtoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pn_fromtoLayout.createSequentialGroup()
                    .addGap(5, 5, 5)
                    .addComponent(jLabel1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(txt_tknc1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jLabel2)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(txt_tknc2, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                    .addContainerGap())
            );
            pn_fromtoLayout.setVerticalGroup(
                pn_fromtoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_fromtoLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pn_fromtoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(pn_fromtoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_tknc1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pn_fromtoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_tknc2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap())
            );

            jLabel3.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
            jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLabel3.setText("Tìm kiếm theo:");

            javax.swing.GroupLayout pn_tkncLayout = new javax.swing.GroupLayout(pn_tknc);
            pn_tknc.setLayout(pn_tkncLayout);
            pn_tkncLayout.setHorizontalGroup(
                pn_tkncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pn_tkncLayout.createSequentialGroup()
                    .addGroup(pn_tkncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(pn_fromto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(pn_tkncLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(cb_tknc, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(pn_tkncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(bt_backctpn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_tknc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap())
            );
            pn_tkncLayout.setVerticalGroup(
                pn_tkncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pn_tkncLayout.createSequentialGroup()
                    .addGroup(pn_tkncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bt_backctpn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cb_tknc)
                        .addComponent(jLabel3))
                    .addGroup(pn_tkncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pn_tkncLayout.createSequentialGroup()
                            .addGap(17, 17, 17)
                            .addComponent(btn_tknc))
                        .addGroup(pn_tkncLayout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(pn_fromto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap())
            );

            javax.swing.GroupLayout pn_allLayout = new javax.swing.GroupLayout(pn_all);
            pn_all.setLayout(pn_allLayout);
            pn_allLayout.setHorizontalGroup(
                pn_allLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pn_allLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(pn_allLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(pn_table, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pn_allLayout.createSequentialGroup()
                            .addGroup(pn_allLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(pn_sanpham, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(pn_ctpn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(pn_allLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(pn_find, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(pn_tknc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(pn_doctpn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addContainerGap())
            );
            pn_allLayout.setVerticalGroup(
                pn_allLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pn_allLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(pn_allLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pn_allLayout.createSequentialGroup()
                            .addComponent(pn_doctpn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(pn_find, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(pn_ctpn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(pn_allLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(pn_tknc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pn_sanpham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(pn_table, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addGroup(layout.createSequentialGroup()
                    .addComponent(pn_all, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
            );
        }// </editor-fold>//GEN-END:initComponents

    private void txt_soluongKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_soluongKeyReleased
        int soluongsach=bussp.getSLb((String)cb_sanpham.getSelectedItem());
        if(checkNumber(txt_soluong.getText())){
             try {
                  double thanhtien=(double)((Integer.parseInt(txt_soluong.getText()))*(Double.parseDouble(txt_dongia.getText())));
                  txt_ttien.setText(String.valueOf(thanhtien));
                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Không thể in thành tiền released"); }
        }  else{  JOptionPane.showMessageDialog(null, "Số lượng phải là sô"); }
    }//GEN-LAST:event_txt_soluongKeyReleased

    private void bt_addctpnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_addctpnActionPerformed
        if (bt_addctpn.getText().toString().equals("Thêm")) {
            txt_ttien.setEditable(false);
            txt_dongia.setEnabled(true);
            txt_ttien.setEnabled(true);
            txt_soluong.setEnabled(true);
            cb_pn.setEnabled(true);
            cb_sanpham.setEnabled(false);
            bt_addctpn.setText("Xác nhận");
            txt_dongia.setText("");
            cb_pn.setSelectedIndex(0);
            cb_sanpham.setSelectedIndex(0);
            txt_ttien.setText("");
            txt_soluong.setText("");
            cb_pn.setSelectedItem(maPNafterclick);}
        else {
            if (cb_pn.getSelectedItem()!= null && cb_sanpham.getSelectedItem()!= null
                && txt_dongia.getText().length() != 0 && txt_soluong.getText().length() != 0
                && cb_pn.getSelectedItem()!= null && txt_ttien.getText().length() != 0) {
                bt_addctpn.setText("Thêm");
                int k = JOptionPane.showConfirmDialog(null, "Xác nhận thêm", "Xác nhận", JOptionPane.YES_NO_CANCEL_OPTION);
                if (k==1)
                {
                    initData();
                    return;
                }
                if (k==2)
                {
                    bt_addctpnActionPerformed(evt);
                    return;
                }                
                ChiTietPhieuNhapDTO ctpn = getText();
                Vector head = setVectorCTPN(ctpn);
                try {
                    int check = bus.themCTPN(ctpn);
                    if(check == 1){
                        model1.addRow(head);
                        tb_ctpn.setModel(model1);
                        changeSL_afteradd();
                        changelastThanhtien();
                        JOptionPane.showMessageDialog(null, "Thêm thành công");
                    } else{
                        JOptionPane.showMessageDialog(null, "Mã đã tồn tại. Thêm thất bại");}
                } catch (Exception ex) {
                    ex.printStackTrace();}
            }else{
                JOptionPane.showMessageDialog(null, "Bạn cần nhập đầy đủ thông tin vào bảng");}
        }
    }//GEN-LAST:event_bt_addctpnActionPerformed

    private void bt_resetctpnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_resetctpnActionPerformed
        reset();
    }//GEN-LAST:event_bt_resetctpnActionPerformed

    private void bt_changectpnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_changectpnActionPerformed
        int SLct = bus.getSLct((String)cb_pn.getSelectedItem(),(String)cb_sanpham.getSelectedItem());
        int input = Integer.parseInt(txt_soluong.getText());
        if (bt_changectpn.getText().toString().equals("Sửa")) {
            txt_ttien.setEditable(false);
            cb_sanpham.setEnabled(false);
            txt_soluong.setEnabled(true);
            txt_dongia.setEnabled(true);
            txt_ttien.setEnabled(true);
            cb_sanpham.setEnabled(false);
            bt_changectpn.setText("Xác nhận");}
        else {
            if (cb_sanpham.getSelectedItem()!= null && txt_dongia.getText().length() != 0 
                && cb_pn.getSelectedItem()!= null && txt_soluong.getText().length() != 0
                && txt_ttien.getText().length() != 0) {
                bt_changectpn.setText("Sửa");
                int i = tb_ctpn.getSelectedRow();
                if(i>=0){
                    int k = JOptionPane.showConfirmDialog(null, "Xác nhận sửa", "Xác nhận", JOptionPane.YES_NO_CANCEL_OPTION);
                    if (k==1)
                    {
                        initData();
                        return;
                    }
                    if (k==2)
                    {
                        bt_changectpnActionPerformed(evt);
                        return;
                    }                    
                    ChiTietPhieuNhapDTO ctpn = getText();
                    int check = bus.suaCTPN(ctpn, i);
                    if(check == 1){
                        setModelValueCTPN(ctpn,i);
                        changeSL_afteradd();
                        changedSLinctpn(input, SLct);
                        changelastThanhtien();
                        JOptionPane.showMessageDialog(null, "Sửa thành công");}
                }else{
                    JOptionPane.showMessageDialog(null, "Sửa thất bại");}
            }else{
                JOptionPane.showMessageDialog(null, "Bạn cần nhập đầy đủ thông tin vào bảng");}
        }
    }//GEN-LAST:event_bt_changectpnActionPerformed

    private void tb_ctpnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_ctpnMouseClicked
        int i = tb_ctpn.getSelectedRow();
        if(i>=0){
            cb_pn.setSelectedItem(tb_ctpn.getModel().getValueAt(i, 0).toString());
            cb_sanpham.setSelectedItem(tb_ctpn.getModel().getValueAt(i, 1).toString());
            txt_dongia.setText(tb_ctpn.getModel().getValueAt(i, 2).toString());
            txt_soluong.setText(tb_ctpn.getModel().getValueAt(i, 3).toString());
            txt_ttien.setText(tb_ctpn.getModel().getValueAt(i, 4).toString());
            loadSanPham((String)cb_sanpham.getSelectedItem());
        }
    }//GEN-LAST:event_tb_ctpnMouseClicked

    private void tb_sanphamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_sanphamMouseClicked
        int i = tb_sanpham.getSelectedRow();
        if(i>=0){
            cb_sanpham.setSelectedItem(tb_sanpham.getModel().getValueAt(i,0).toString());
             txt_dongia.setText(tb_sanpham.getModel().getValueAt(i,2).toString());
        }
    }//GEN-LAST:event_tb_sanphamMouseClicked

    private void btn_TimKiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_TimKiemMouseClicked
        String[] header = {"Mã phiếu nhập","Mã sản phẩm","Đơn giá chi tiết","Số lượng","Thành tiền"};
        DefaultTableModel modelsearch = new DefaultTableModel(header , 0);
        ArrayList<ChiTietPhieuNhapDTO> ctpn;
        ctpn = bus.timkiem(String.valueOf(cb_TimKiem.getSelectedItem()), txt_TimKiem.getText().toLowerCase());
        if (!ctpn.isEmpty()){
            for (int i = 0; i < ctpn.size(); i++){
                Object[] row = {ctpn.get(i).getMaPN(), ctpn.get(i).getMaSP(), ctpn.get(i).getDonGia(),
                    ctpn.get(i).getSoLuong(), ctpn.get(i).getThanhTien_CT()};
                modelsearch.addRow(row);}
            tempsearch.addAll(arr);
            arr.clear();
            arr.addAll(ctpn);
            tb_ctpn.setModel(modelsearch);
            bt_backctpn.setVisible(true);}
        else {
            JOptionPane.showMessageDialog(null, "Không có kết quả phù hợp");}
    }//GEN-LAST:event_btn_TimKiemMouseClicked

    private void btn_tkncMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_tkncMouseClicked
        String[] header = {"Mã phiếu nhập","Mã sản phẩm","Đơn giá chi tiết","Số lượng","Thành tiền"};
        DefaultTableModel modelsearch = new DefaultTableModel(header , 0);
        ArrayList<ChiTietPhieuNhapDTO> ctpn;
        ctpn = bus.timkiemPNnc(String.valueOf(cb_tknc.getSelectedItem()),txt_tknc1.getText().toLowerCase(), txt_tknc2.getText().toLowerCase());
        if (!ctpn.isEmpty()){
            for (int i = 0; i < ctpn.size(); i++){
                Object[] row = {ctpn.get(i).getMaPN(), ctpn.get(i).getMaSP(), ctpn.get(i).getDonGia(),
                    ctpn.get(i).getSoLuong(), ctpn.get(i).getThanhTien_CT()};
                modelsearch.addRow(row);}
            tempsearch.addAll(arr);
            arr.clear();
            arr.addAll(ctpn);
            tb_ctpn.setModel(modelsearch);
            bt_backctpn.setVisible(true);}
        else{
            JOptionPane.showMessageDialog(null, "Không có kết quả phù hợp");}
    }//GEN-LAST:event_btn_tkncMouseClicked

    private void bt_backctpnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_backctpnActionPerformed
        arr.clear();
        arr.addAll(tempsearch);
        tempsearch.clear();
        tb_ctpn.setModel(model1);
        tb_sanpham.setModel(model2);
        bt_backctpn.setVisible(false);
    }//GEN-LAST:event_bt_backctpnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_addctpn;
    private javax.swing.JButton bt_backctpn;
    private javax.swing.JButton bt_changectpn;
    private javax.swing.JButton bt_resetctpn;
    private javax.swing.JButton btn_TimKiem;
    private javax.swing.JButton btn_tknc;
    private javax.swing.JComboBox<String> cb_TimKiem;
    private javax.swing.JComboBox<String> cb_pn;
    private javax.swing.JComboBox<String> cb_sanpham;
    private javax.swing.JComboBox<String> cb_tknc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lb_dongia;
    private javax.swing.JLabel lb_mpn;
    private javax.swing.JLabel lb_sanpham;
    private javax.swing.JLabel lb_soluong;
    private javax.swing.JLabel lb_ttien;
    private javax.swing.JPanel pn_all;
    private javax.swing.JPanel pn_ctpn;
    private javax.swing.JPanel pn_doctpn;
    private javax.swing.JPanel pn_find;
    private javax.swing.JPanel pn_fromto;
    private javax.swing.JPanel pn_sanpham;
    private javax.swing.JPanel pn_table;
    private javax.swing.JPanel pn_tknc;
    private javax.swing.JTable tb_ctpn;
    private javax.swing.JTable tb_sanpham;
    private javax.swing.JTextField txt_TimKiem;
    private javax.swing.JTextField txt_dongia;
    private javax.swing.JTextField txt_soluong;
    private javax.swing.JTextField txt_tknc1;
    private javax.swing.JTextField txt_tknc2;
    private javax.swing.JTextField txt_ttien;
    // End of variables declaration//GEN-END:variables
}

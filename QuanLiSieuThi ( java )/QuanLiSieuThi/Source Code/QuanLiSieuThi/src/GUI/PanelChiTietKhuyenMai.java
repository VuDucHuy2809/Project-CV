
package GUI;

import BUS.ChiTietKhuyenMaiBUS;
import BUS.KhuyenMaiBUS;
import BUS.SanPhamCTBUS;
import DTO.ChiTietKhuyenMaiDTO;
import DTO.KhuyenMaiDTO;
import DTO.SanPhamDTO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class PanelChiTietKhuyenMai extends javax.swing.JPanel {
    DefaultTableModel model1 = new DefaultTableModel();
    DefaultTableModel model2 = new DefaultTableModel();
    ArrayList<ChiTietKhuyenMaiDTO> tempserch = new ArrayList<>();
    ArrayList<ChiTietKhuyenMaiDTO> arr = new ArrayList<>();
    ChiTietKhuyenMaiBUS bus= new ChiTietKhuyenMaiBUS();
    SanPhamCTBUS bookbus = new SanPhamCTBUS();
    KhuyenMaiBUS buskm = new KhuyenMaiBUS();
    public PanelChiTietKhuyenMai() {
        initComponents();
        initData();
        load();
        loadSanpham(null);
        loadinCbox();
        btn_back.setVisible(false);
    }
    private void initData()
    {
        cb_MaSanPham.setEnabled(false);
        cb_maKM.setEnabled(false);
        txt_ptgg.setEnabled(false);
        btn_back.setVisible(false);
        cb_MaSanPham.setSelectedIndex(0);
        cb_maKM.setSelectedIndex(0);
        txt_ptgg.setText("");
        
    }
    public void load()
    {
        ChiTietKhuyenMaiBUS bus = new ChiTietKhuyenMaiBUS();
        try{
            bus.docCTKM();
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Lỗi kết nối đến Database.");
            return ;
        }
        Vector header;
        header = new Vector();
        header.add("Mã khuyến mãi");
        header.add("Mã sản phẩm");
        header.add("Phần trăm khuyến mãi");
        model1 = new DefaultTableModel(header, 0)
                {
                    public boolean isCellEditTable(int row, int column)
                {
                    return false;
                }
                };
        showOnTableCTKM(bus.list);
    }
    public void showOnTableCTKM(ArrayList<ChiTietKhuyenMaiDTO> list)
    {
        model1.setRowCount(0);
        for (ChiTietKhuyenMaiDTO ctkm : list)
        {
            Vector data = setVectorCTKM(ctkm);
            model1.addRow(data);
        }
        tbl_ctkm.setModel(model1);
    }
    public Vector setVectorCTKM(ChiTietKhuyenMaiDTO ctkm)
    {
        Vector temp = new Vector();
        temp.add(ctkm.getMaKM());
        temp.add(ctkm.getMaSP());
        temp.add(ctkm.getPhanTramGiamGia_CT());
        return temp;
    }
    public ChiTietKhuyenMaiDTO getText()
    {
        ChiTietKhuyenMaiDTO ctkm = new ChiTietKhuyenMaiDTO();
        ctkm.setMaKM(cb_maKM.getSelectedItem().toString());
        ctkm.setMaSP(cb_MaSanPham.getSelectedItem().toString());
        ctkm.setPhanTramGiamGia_CT(Double.parseDouble(txt_ptgg.getText().trim()));
        return ctkm;
    }
    public void setModelValueCTKM(ChiTietKhuyenMaiDTO ctkm, int i)
    {
        model1.setValueAt(ctkm.getMaKM(), i, 0);
        model1.setValueAt(ctkm.getMaSP(), i, 1);
        model1.setValueAt(ctkm.getPhanTramGiamGia_CT(), i, 2);
        tbl_ctkm.setModel(model1);
    }

        public void loadinCbox(){
        Vector cbMakm=bus.loadcb_MaKM();
        this.cb_maKM.setModel(new DefaultComboBoxModel<>(cbMakm));
        Vector cbMaSanpham=  bus.loadcb_MaSP();
        this.cb_MaSanPham.setModel(new DefaultComboBoxModel<>(cbMaSanpham));
    }
        
    public void loadSanpham(String masach){
        SanPhamCTBUS busbook = new SanPhamCTBUS();
        try {
            busbook.docSanphamforCT();
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Lỗi đọc sản phẩm trong CTHD từ DataBase!!!");
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
        showOnTableProduct(busbook.list1,masach);
    } 
    private void showOnTableProduct(ArrayList<SanPhamDTO> list1, String masanpham) {
        model2.setRowCount(0);
        for (SanPhamDTO s : list1)
        {
            if (s.getMaSP().equals(masanpham)||masanpham== null)
            {
            Vector data = setVectorBook(s);
            model2.addRow(data);
            }
        }
        tbl_sach.setModel(model2);
    }
    private Vector setVectorBook(SanPhamDTO s) {
        Vector row = new Vector();
        row.add(s.getMaSP());
        row.add(s.getTenSP());
        row.add(s.getDonGia());
        row.add(s.getSoLuong());
        return row;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pn_all = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_ptgg = new javax.swing.JTextField();
        cb_MaSanPham = new javax.swing.JComboBox<>();
        cb_maKM = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        btn_them = new javax.swing.JButton();
        btn_reset = new javax.swing.JButton();
        btn_sua = new javax.swing.JButton();
        btn_nhapfile = new javax.swing.JButton();
        btn_taofile = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        cb_tk = new javax.swing.JComboBox<>();
        txt_tk = new javax.swing.JTextField();
        btn_TimKiem = new javax.swing.JButton();
        btn_back = new javax.swing.JButton();
        pn_sanpham = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_sach = new javax.swing.JTable();
        pn_ctkm = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_ctkm = new javax.swing.JTable();

        pn_all.setBackground(new java.awt.Color(0, 204, 204));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chi tiết khuyến mãi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 51, 51))); // NOI18N

        jLabel1.setText("Mã khuyến mãi");

        jLabel2.setText("Mã sản phẩm:");

        jLabel3.setText("Phần trăm giảm giá:");

        txt_ptgg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_ptggKeyReleased(evt);
            }
        });

        cb_MaSanPham.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cb_MaSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_MaSanPhamActionPerformed(evt);
            }
        });

        cb_maKM.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cb_maKM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cb_maKMMouseClicked(evt);
            }
        });
        cb_maKM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_maKMActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_ptgg)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cb_maKM, 0, 155, Short.MAX_VALUE)
                            .addComponent(cb_MaSanPham, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cb_maKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cb_MaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_ptgg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thực hiện", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 51, 51))); // NOI18N

        btn_them.setBackground(new java.awt.Color(204, 204, 204));
        btn_them.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_them.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/add.png"))); // NOI18N
        btn_them.setText("Thêm");
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });

        btn_reset.setBackground(new java.awt.Color(204, 204, 204));
        btn_reset.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_reset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/reset.png"))); // NOI18N
        btn_reset.setText("Reset");
        btn_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetActionPerformed(evt);
            }
        });

        btn_sua.setBackground(new java.awt.Color(204, 204, 204));
        btn_sua.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_sua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/change.png"))); // NOI18N
        btn_sua.setText("Sửa");
        btn_sua.setMaximumSize(new java.awt.Dimension(65, 23));
        btn_sua.setMinimumSize(new java.awt.Dimension(65, 23));
        btn_sua.setPreferredSize(new java.awt.Dimension(65, 23));
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });

        btn_nhapfile.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_nhapfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/import.png"))); // NOI18N
        btn_nhapfile.setText("Nhập từ file");
        btn_nhapfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nhapfileActionPerformed(evt);
            }
        });

        btn_taofile.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_taofile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/export.png"))); // NOI18N
        btn_taofile.setText("Tạo file");
        btn_taofile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_taofileMouseClicked(evt);
            }
        });
        btn_taofile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_taofileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_them, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_sua, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addComponent(btn_reset, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_taofile, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_nhapfile))
                .addGap(22, 22, 22))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(btn_nhapfile)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_taofile, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btn_them, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_sua, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(btn_reset, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 204));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 51, 51))); // NOI18N

        cb_tk.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã khuyến mãi", "Mã sản phẩm" }));

        btn_TimKiem.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_TimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/find.png"))); // NOI18N
        btn_TimKiem.setText("Tìm kiếm");
        btn_TimKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_TimKiemMouseClicked(evt);
            }
        });

        btn_back.setBackground(new java.awt.Color(204, 204, 204));
        btn_back.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/back.png"))); // NOI18N
        btn_back.setText("Back");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(btn_TimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_back, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(cb_tk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txt_tk)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cb_tk, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(txt_tk))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_TimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_back, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pn_sanpham.setBackground(new java.awt.Color(255, 255, 255));

        tbl_sach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbl_sach);

        javax.swing.GroupLayout pn_sanphamLayout = new javax.swing.GroupLayout(pn_sanpham);
        pn_sanpham.setLayout(pn_sanphamLayout);
        pn_sanphamLayout.setHorizontalGroup(
            pn_sanphamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        pn_sanphamLayout.setVerticalGroup(
            pn_sanphamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        tbl_ctkm.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_ctkm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_ctkmMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_ctkm);

        javax.swing.GroupLayout pn_ctkmLayout = new javax.swing.GroupLayout(pn_ctkm);
        pn_ctkm.setLayout(pn_ctkmLayout);
        pn_ctkmLayout.setHorizontalGroup(
            pn_ctkmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
        );
        pn_ctkmLayout.setVerticalGroup(
            pn_ctkmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pn_allLayout = new javax.swing.GroupLayout(pn_all);
        pn_all.setLayout(pn_allLayout);
        pn_allLayout.setHorizontalGroup(
            pn_allLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_allLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_allLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pn_ctkm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_allLayout.createSequentialGroup()
                        .addGroup(pn_allLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pn_allLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pn_sanpham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        pn_allLayout.setVerticalGroup(
            pn_allLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_allLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_allLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_allLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pn_sanpham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pn_ctkm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pn_all, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pn_all, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        btn_back.setEnabled(true);
        txt_ptgg.setEnabled(true);
        ArrayList<KhuyenMaiDTO> lkm = buskm.docKM();
                   for(int i=0;i<= lkm.size()-1; i++)
                   {
                       if(cb_maKM.getSelectedItem().toString().equals(lkm.get(i).getMaKM()))
                       {
//                          NV System.out.println("đã dô");
                           String t = String.valueOf(lkm.get(i).getPhanTramGiamGia());
                           txt_ptgg.setText(t);
                       }
                   }
        if (btn_them.getText().toString().equals("Thêm"))
        {
            cb_MaSanPham.setEnabled(true);
            cb_maKM.setEnabled(true);
            txt_ptgg.setEnabled(true);
            btn_back.setVisible(true);
            
            //txt_ptgg.setText("");
            btn_them.setText("Xác nhận");
        }
        else
        {
           
            if (txt_ptgg.getText().length()!=0)
            {
                btn_them.setText("Thêm");
                int k = JOptionPane.showConfirmDialog(null, "Xác nhận thêm", "Xác nhận", JOptionPane.YES_NO_CANCEL_OPTION);
                if (k==1)
                {
                    initData();
                    return;
                }
                if (k==2)
                {
                    btn_themActionPerformed(evt);
                    return;
                }
                ChiTietKhuyenMaiDTO ct = getText();
                Vector header = setVectorCTKM(ct);
                int check = 0;
                try {
                    check = bus.themCTKM(ct);
                } catch (Exception e)
                {

                }
                if (check ==1 && k==0)
                {
                    JOptionPane.showMessageDialog(null, "Thêm thành công");
                    load();
                }
                else JOptionPane.showMessageDialog(null, "Thêm thất bại");

            } else JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin");
        }
    }//GEN-LAST:event_btn_themActionPerformed

    private void btn_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetActionPerformed
        initData();
        load();
        loadSanpham(null);
    }//GEN-LAST:event_btn_resetActionPerformed

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
        if (txt_ptgg.getText().length()==0)
        {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn hàng cần sửa");
            return;
        }
        if (btn_sua.getText().equals("Sửa"))
        {
            cb_MaSanPham.setEnabled(true);
            cb_maKM.setEnabled(true);
            txt_ptgg.setEnabled(true);
            btn_back.setVisible(true);
            btn_sua.setText("Xác nhận");
        }
        else
        {
            if (txt_ptgg.getText().length()!=0 && btn_sua.getText().equals("Xác nhận"))
            {
                btn_sua.setText("Sửa");
                int i = tbl_ctkm.getSelectedRow();
                if (i>=0)
                {
                    int k = JOptionPane.showConfirmDialog(null, "Xác nhận sửa", "Xác nhận", JOptionPane.YES_NO_CANCEL_OPTION);
                    if (k==1)
                    {
                        initData();
                        return;
                    }
                    if (k==2)
                    {
                        btn_suaActionPerformed(evt);
                        return;
                    }
                    ChiTietKhuyenMaiDTO km = getText();
                    int check = bus.suaCTKM(km);
                    {
                        if (check == 1 && k == 0)
                        {
                            JOptionPane.showMessageDialog(null, "Sửa thành công");
                            load();
                            initData();

                        }
                        else {
                            JOptionPane.showMessageDialog(null, "Sửa thất bại");
                        }
                    }
                }
            }else JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin");
        }
    }//GEN-LAST:event_btn_suaActionPerformed

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        initData();
        load();
        loadSanpham(null);
        btn_them.setText("Thêm");
        btn_sua.setText("Sửa");
        btn_back.setVisible(false);
    }//GEN-LAST:event_btn_backActionPerformed

    private void btn_nhapfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nhapfileActionPerformed
        JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        int r = j.showOpenDialog(null);
        String link = null;
        if (r == JFileChooser.APPROVE_OPTION)
        {
            link=j.getSelectedFile().getAbsoluteFile().toString();
        }
        try{
            FileInputStream excel = new FileInputStream(new File(link));
            Workbook wb = new XSSFWorkbook(excel);
            Sheet datatypeSheet = wb.getSheetAt(0);
            DataFormatter fmt = new DataFormatter();
            Iterator<Row> ite = datatypeSheet.iterator();
            Row firstrow = ite.next();
            Row serow = ite.next();
            Cell firstcell = firstrow.getCell(0);
            ArrayList<ChiTietKhuyenMaiDTO> list = new ArrayList<>();
            while(ite.hasNext())
            {
                Row thisrow = ite.next();
                ChiTietKhuyenMaiDTO ct = new ChiTietKhuyenMaiDTO();
                ct.setMaKM(thisrow.getCell(0).getStringCellValue());
                ct.setMaSP(thisrow.getCell(1).getStringCellValue());
                ct.setPhanTramGiamGia_CT(thisrow.getCell(2).getNumericCellValue());
                list.add(ct);
            }
            Vector header = new Vector();
            header.add("Mã khuyến mãi");
            header.add("Mã sản phẩm");
            header.add("Phần trăm giảm giá");
            DefaultTableModel modelf = new DefaultTableModel(header, 0);
            for (ChiTietKhuyenMaiDTO ct : list)
            {
                Vector data = new Vector();
                data = setVectorCTKM(ct);
                modelf.addRow(data);
            }
            tbl_ctkm.setModel(modelf);
            wb.close();
            ArrayList<ChiTietKhuyenMaiDTO> ctg = new ArrayList<>();
            ctg = bus.docCTKM();
            for (int i=0; i<list.size(); i++)
            {
                boolean fl = false;
                for (int k=0; k<ctg.size(); k++)
                {
                    if (list.get(i).getMaKM().equals(ctg.get(k).getMaKM()) && list.get(i).getMaSP().equals(ctg.get(k).getMaSP()))
                    {
                        fl=true;
                    }

                }
                if (fl == false) bus.themCTKM(list.get(i));

            }
            JOptionPane.showMessageDialog(null, "Nhập từ file thành công");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PanelChiTietKhuyenMai.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PanelChiTietKhuyenMai.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_nhapfileActionPerformed

    private void btn_taofileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_taofileMouseClicked
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sheet = wb.createSheet("CTKM");
        int rowNum=0;
        Row firsRow = sheet.createRow(rowNum++);
        Cell firstCell = firsRow.createCell(0);
        firstCell.setCellValue("Bảng chi tiết khuyến mãi");
        Row title = sheet.createRow(rowNum++);
        Cell title1 = title.createCell(0);
        title1.setCellValue("Mã khuyến mãi");
        Cell title2 = title.createCell(1);
        title2.setCellValue("Mã sản phẩm");
        Cell title3 = title.createCell(2);
        title3.setCellValue("Phần trăm giảm giá");
        ArrayList<ChiTietKhuyenMaiDTO> list = new ArrayList<>();
        list = bus.docCTKM();
        for (int i=0; i<list.size(); i++)
        {
            Row row = sheet.createRow(rowNum++);
            Cell cell1 = row.createCell(0);
            cell1.setCellValue(list.get(i).getMaKM());
            Cell cell2 = row.createCell(1);
            cell2.setCellValue(list.get(i).getMaSP());
            Cell cell3 = row.createCell(2);
            cell3.setCellValue(list.get(i).getPhanTramGiamGia_CT());

        }
        try
        {
            FileOutputStream output = new FileOutputStream("./Xuatfile/ctkm.xlsx");
            wb.write(output);
            wb.close();
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }

    }//GEN-LAST:event_btn_taofileMouseClicked

    private void btn_taofileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_taofileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_taofileActionPerformed

    private void btn_TimKiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_TimKiemMouseClicked
        String[] header = {"Mã khuyến mãi", "Mã sản phẩm", "Phần trăm giảm giá"};
        DefaultTableModel model = new DefaultTableModel(header, 0);
        ArrayList<ChiTietKhuyenMaiDTO> ct;
        ct = bus.timkiemCT(cb_tk.getSelectedItem().toString(), txt_tk.getText());
        if (ct.size()!=0)
        {
            for (int i=0; i<ct.size(); i++)
            {
                Vector row = setVectorCTKM(ct.get(i));
                model.addRow(row);
            }
            tempserch.addAll(arr);
            arr.clear();
            arr.addAll(ct);
            tbl_ctkm.setModel(model);
            btn_back.setVisible(true);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Không có kết quả phù hợp");
        }
    }//GEN-LAST:event_btn_TimKiemMouseClicked

    private void tbl_ctkmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_ctkmMouseClicked
        int i = tbl_ctkm.getSelectedRow();
        if (i>=0)
        {
            cb_MaSanPham.setSelectedItem(tbl_ctkm.getValueAt(i, 1).toString());
            cb_maKM.setSelectedItem(tbl_ctkm.getValueAt(i, 0).toString());
            txt_ptgg.setText(tbl_ctkm.getValueAt(i, 2).toString());
            String n;
            n = cb_MaSanPham.getSelectedItem().toString();
            System.out.print(n+"\n");
            loadSanpham(n);
        }
    }//GEN-LAST:event_tbl_ctkmMouseClicked

    private void txt_ptggKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_ptggKeyReleased
        String t = txt_ptgg.getText();
        double n ;
        try {
            n = Double.parseDouble(t);
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Vui lòng chỉ nhập số");
            java.awt.event.ActionEvent evt1 = null;
            if (btn_them.getText().equals("Xác nhận"))
            {
                btn_them.setText("Thêm");
                btn_themActionPerformed(evt1);
            } else {
                btn_sua.setText("Sửa");
                btn_suaActionPerformed(evt1);
            }
            txt_ptgg.setText("0");
        }
    }//GEN-LAST:event_txt_ptggKeyReleased

    private void cb_MaSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_MaSanPhamActionPerformed
            // TODO add your handling code here:
    }//GEN-LAST:event_cb_MaSanPhamActionPerformed

    private void cb_maKMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_maKMActionPerformed
          ArrayList<KhuyenMaiDTO> lkm = buskm.docKM();
                   for(int i=0;i<= lkm.size()-1; i++)
                   {
                       if(cb_maKM.getSelectedItem().toString().equals(lkm.get(i).getMaKM()))
                       {
                           //System.out.println("đã dô");
                           String t = String.valueOf(lkm.get(i).getPhanTramGiamGia());
                           txt_ptgg.setText(t);
                       }
                   }
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_maKMActionPerformed

    private void cb_maKMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cb_maKMMouseClicked
                   
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_maKMMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_TimKiem;
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_nhapfile;
    private javax.swing.JButton btn_reset;
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_taofile;
    private javax.swing.JButton btn_them;
    private javax.swing.JComboBox<String> cb_MaSanPham;
    private javax.swing.JComboBox<String> cb_maKM;
    private javax.swing.JComboBox<String> cb_tk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel pn_all;
    private javax.swing.JPanel pn_ctkm;
    private javax.swing.JPanel pn_sanpham;
    private javax.swing.JTable tbl_ctkm;
    private javax.swing.JTable tbl_sach;
    private javax.swing.JTextField txt_ptgg;
    private javax.swing.JTextField txt_tk;
    // End of variables declaration//GEN-END:variables
}

package GUI;

import BUS.ChiTietHoaDonBUS;
import BUS.HoaDonBUS;
import BUS.SanPhamCTBUS;
import BUS.KhuyenMaiBUS;
import DTO.ChiTietHoaDonDTO;
import DTO.HoaDonDTO;
import DTO.KhuyenMaiDTO;
import DTO.SanPhamDTO;
import static GUI.PanelHoaDon.maHDafterclick;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
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
import static untils.CheckData.checkNumber;

public class PanelChiTietHoaDon extends javax.swing.JPanel {

    DefaultTableModel model1 = new DefaultTableModel();
    DefaultTableModel model2 = new DefaultTableModel();
    ArrayList<ChiTietHoaDonDTO> tempsearch = new ArrayList<ChiTietHoaDonDTO>();
    ArrayList<ChiTietHoaDonDTO> arr = new ArrayList<ChiTietHoaDonDTO>();
    ChiTietHoaDonBUS bus = new ChiTietHoaDonBUS();
    SanPhamCTBUS busbook = new SanPhamCTBUS();
    HoaDonBUS bushd = new HoaDonBUS();
    KhuyenMaiBUS buskm = new KhuyenMaiBUS();
    private static double phantram = 0;

    public PanelChiTietHoaDon() {
        initComponents();
        model1 = (DefaultTableModel) tb_cthd.getModel();
        model2 = (DefaultTableModel) tb_sanpham.getModel();
        initData();
        load();
        loadSanpham(null);
        loadinCbox();
        bt_backcthd.setVisible(false);
    }

    public PanelChiTietHoaDon(String mahd) {
        initComponents();
        model1 = (DefaultTableModel) tb_cthd.getModel();
        model2 = (DefaultTableModel) tb_sanpham.getModel();
        initData();
        loadforclick(maHDafterclick);
        loadSanpham(null);
        loadinCbox();
        cb_hd.setSelectedItem(maHDafterclick);
        bt_backcthd.setVisible(false);
    }

    private void initData() {
        cb_hd.setEnabled(false);
        cb_sanpham.setEnabled(false);
        txt_soluong.setEnabled(false);
        txt_giamgia.setEnabled(false);
        txt_dongia.setEnabled(false);
        txt_ttien.setEnabled(false);
        bt_backcthd.setVisible(false);
    }

    public void load() {
        ChiTietHoaDonBUS bus = new ChiTietHoaDonBUS();
        try {
            bus.docCTHD();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi kết nối đến DataBase!!!");
            return;
        }
        Vector header;
        header = new Vector();
        header.add("Mã hóa đơn");
        header.add("Mã sản phẩm");
        header.add("Đơn giá chi tiết");
        header.add("Số lượng");
        header.add("Thành tiền");
        header.add("Tiền giảm giá");
        model1 = new DefaultTableModel(header, 0) {
            public boolean isCellEditTable(int row, int column) {
                return false;
            }
        };
        showOnTableCTHD(bus.listcthd);
    }

    public void loadforclick(String mahd) {
        ChiTietHoaDonBUS bus = new ChiTietHoaDonBUS();
        try {
            bus.docCTHD();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi kết nối đến DataBase!!!");
            return;
        }
        Vector header;
        header = new Vector();
        header.add("Mã hóa đơn");
        header.add("Mã sản phẩm");
        header.add("Đơn giá chi tiết");
        header.add("Số lượng");
        header.add("Thành tiền");
        header.add("Tiền giảm giá");
        model1 = new DefaultTableModel(header, 0) {
            public boolean isCellEditTable(int row, int column) {
                return false;
            }
        };
        showOnTableCTHDforclick(bus.listcthd, mahd);
    }

    public void showOnTableCTHD(ArrayList<ChiTietHoaDonDTO> listcthd) {
        for (ChiTietHoaDonDTO cthd : listcthd) {
            Vector data = setVectorCTHD(cthd);
            model1.addRow(data);
        }
        tb_cthd.setModel(model1);
    }

    public void showOnTableCTHDforclick(ArrayList<ChiTietHoaDonDTO> listcthd, String mahd) {
        for (ChiTietHoaDonDTO cthd : listcthd) {
            if (cthd.getMaHD().equals(mahd)) {
                Vector data = setVectorCTHD(cthd);
                model1.addRow(data);
            }
        }
        tb_cthd.setModel(model1);
    }

    public Vector setVectorCTHD(ChiTietHoaDonDTO cthd) {
        Vector temp = new Vector();
        temp.add(cthd.getMaHD());
        temp.add(cthd.getMaSP());
        temp.add(cthd.getDonGia());
        temp.add(cthd.getSoLuong());
        temp.add(cthd.getThanhTien());
        temp.add(cthd.getTienGiamGia_CT());
        return temp;
    }

    public ChiTietHoaDonDTO getText() {
        ChiTietHoaDonDTO cthd = new ChiTietHoaDonDTO();
        cthd.setMaHD((String) cb_hd.getSelectedItem());
        cthd.setMaSP((String) cb_sanpham.getSelectedItem());
        cthd.setDonGia(Double.parseDouble(txt_dongia.getText().trim()));
        cthd.setSoLuong(Integer.parseInt(txt_soluong.getText().trim()));
        cthd.setThanhTien(Double.parseDouble(txt_ttien.getText().trim()));
        cthd.setTienGiamGia_CT(Double.parseDouble(txt_giamgia.getText().trim()));
        return cthd;

    }

    public void setModelValueCTHD(ChiTietHoaDonDTO cthd, int i) {
        model1.setValueAt(cthd.getMaHD(), i, 0);
        model1.setValueAt(cthd.getMaSP(), i, 1);
        model1.setValueAt(cthd.getDonGia(), i, 2);
        model1.setValueAt(cthd.getSoLuong(), i, 3);
        model1.setValueAt(cthd.getThanhTien(), i, 4);
        model1.setValueAt(cthd.getTienGiamGia_CT(), i, 5);
        tb_cthd.setModel(model1);
    }

    public void loadSanpham(String MaSP) {
        SanPhamCTBUS busbook = new SanPhamCTBUS();
        try {
            busbook.docSanphamforCT();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi đọc sản phẩm trong CTHD từ DataBase!!!");
            return;
        }
        Vector header = new Vector();
        header.add("Mã sản phẩm");
        header.add("Tên sản phẩm");
        header.add("Đơn giá");
        header.add("Số lượng");
        model2 = new DefaultTableModel(header, 0) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        showOnTableBook(busbook.list1, MaSP);
    }

    private void showOnTableBook(ArrayList<SanPhamDTO> list1, String MaSP) {
        model2.setRowCount(0);
        for (SanPhamDTO s : list1) {
            if (s.getMaSP().equals(MaSP) || MaSP == null) {
                Vector data = setVectorBook(s);
                model2.addRow(data);
            }
        }
        tb_sanpham.setModel(model2);
    }

    private Vector setVectorBook(SanPhamDTO s) {
        Vector row = new Vector();
        row.add(s.getMaSP());
        row.add(s.getTenSP());
        row.add(s.getDonGia());
        row.add(s.getSoLuong());
        return row;
    }

    public void loadinCbox() {
        Vector cbMaHd = bus.loadcb_hd();
        this.cb_hd.setModel(new DefaultComboBoxModel<>(cbMaHd));
        Vector cbMaSP = bus.loadcb_sanpham();
        this.cb_sanpham.setModel(new DefaultComboBoxModel<>(cbMaSP));
    }

    public void showSanpham2() {
        for (SanPhamDTO s : busbook.docSanphamforCT()) {
            model2.addRow(new Object[]{
                s.getMaSP(), s.getTenSP(), s.getDonGia(), s.getSoLuong()
            });
        }
    }

    public void changeSL_afteradd(int input) {
        int soluongsach = busbook.getSLb((String) cb_sanpham.getSelectedItem());
        int i = tb_sanpham.getSelectedRow();
        if (i >= 0) {
            SanPhamDTO s = new SanPhamDTO();
            int SLnew = soluongsach - input;
            if (busbook.changeSLb((String) cb_sanpham.getSelectedItem(), SLnew) == 1) {
                s.setSoLuong(SLnew);
                busbook.list1.set(i, s);
                model2.setValueAt(s.getSoLuong(), i, 3);
                tb_sanpham.setModel(model2);
            }
        }
    } //giảm số lượng sản phẩm khi thêm chi tiết hóa đơn

    public void changedSLincthd(int input, int available) {
        int soluongsach = busbook.getSLb((String) cb_sanpham.getSelectedItem());
        int change = Math.abs(input - available);
        if (input > available) {
            int i = tb_cthd.getSelectedRow();
            if (i >= 0) {
                int SLnew = soluongsach - change;
                SanPhamDTO s = new SanPhamDTO();
                if (busbook.changeSLb((String) cb_sanpham.getSelectedItem(), SLnew) == 1) {
                    s.setSoLuong(SLnew);
                    model2.setRowCount(0);
                    showSanpham2();
                }
            }
        }
        if (input < available) {
            int i = tb_cthd.getSelectedRow();
            if (i >= 0) {
                int SLnew = soluongsach + change;
                SanPhamDTO s = new SanPhamDTO();
                if (busbook.changeSLb((String) cb_sanpham.getSelectedItem(), SLnew) == 1) {
                    s.setSoLuong(SLnew);
                    model2.setRowCount(0);
                    showSanpham2();
                }
            }
        }
    }//Tăng giảm số lượng sản phẩm sau khi sửa   

    public void changeTongtienHDfromCT() {
        double tongtienkho = bus.getTongtienfromCTHD((String) cb_hd.getSelectedItem());
        double tonggiamgiakho = bus.getTienGGHdfromCTHD((String) cb_hd.getSelectedItem());
        double thanhtien = tongtienkho - tonggiamgiakho;
        if (bushd.changeTongtienHDfromCT((String) cb_hd.getSelectedItem(), tongtienkho, thanhtien, tonggiamgiakho) == 1) {
            HoaDonDTO hd = new HoaDonDTO();
            hd.setTongtien(tongtienkho);
        }
    }// sửa thành tiền của hóa đơn sau khi sửa cthd

    public void changeTonggiamgiaHDfromCT() {
        double tonggiamgiakho = bus.getTienGGHdfromCTHD((String) cb_hd.getSelectedItem());
        if (bushd.changeTienGGHd_afterdone((String) cb_hd.getSelectedItem(), tonggiamgiakho) == 1) {
            HoaDonDTO hd = new HoaDonDTO();
            hd.setTienGiamGia(tonggiamgiakho);
        }
    }// sửa tổng giảm giá của hóa đơn sau khi tác động cthd

    public void changelastThanhtien() {
        double tonggiamgiakho = bushd.getTienGGHdfromHD((String) cb_hd.getSelectedItem());
        double tongtienkho = bushd.getTongtienfromHD((String) cb_hd.getSelectedItem());
        double thanhtiennew = tongtienkho - tonggiamgiakho;
        if (bushd.changeThanhtien_afterdec((String) cb_hd.getSelectedItem(), thanhtiennew) == 1) {
            HoaDonDTO hd = new HoaDonDTO();
            hd.setThanhTien(thanhtiennew);
        }
    }   // sửa thành tiền cuối cùng

    public void reset() {
        txt_dongia.setText("");
        cb_hd.setSelectedIndex(0);
        cb_sanpham.setSelectedIndex(0);
        txt_ttien.setText("");
        txt_soluong.setText("");
        txt_giamgia.setText("");
        txt_TimKiem.setText("");
        txt_tknc1.setText("");
        txt_tknc2.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pn_all = new javax.swing.JPanel();
        pn_cthd = new javax.swing.JPanel();
        lb_dongia = new javax.swing.JLabel();
        txt_dongia = new javax.swing.JTextField();
        lb_mhd = new javax.swing.JLabel();
        lb_sach = new javax.swing.JLabel();
        lb_ttien = new javax.swing.JLabel();
        txt_ttien = new javax.swing.JTextField();
        cb_hd = new javax.swing.JComboBox<>();
        cb_sanpham = new javax.swing.JComboBox<>();
        lb_soluong = new javax.swing.JLabel();
        txt_soluong = new javax.swing.JTextField();
        lb_giamgia = new javax.swing.JLabel();
        txt_giamgia = new javax.swing.JTextField();
        pn_docthd = new javax.swing.JPanel();
        bt_addcthd = new javax.swing.JButton();
        bt_resetcthd = new javax.swing.JButton();
        bt_changecthd = new javax.swing.JButton();
        btn_nhapfile = new javax.swing.JButton();
        btn_taofile = new javax.swing.JButton();
        pn_table = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_cthd = new javax.swing.JTable(){
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
            bt_backcthd = new javax.swing.JButton();
            pn_fromto = new javax.swing.JPanel();
            jLabel1 = new javax.swing.JLabel();
            jLabel2 = new javax.swing.JLabel();
            txt_tknc1 = new javax.swing.JTextField();
            txt_tknc2 = new javax.swing.JTextField();
            jLabel3 = new javax.swing.JLabel();

            pn_all.setBackground(new java.awt.Color(0, 204, 204));

            pn_cthd.setBackground(new java.awt.Color(255, 255, 255));
            pn_cthd.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chi tiết hóa đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(255, 102, 102))); // NOI18N

            lb_dongia.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
            lb_dongia.setText("Đơn giá:");

            lb_mhd.setText("Mã hóa đơn:");

            lb_sach.setText("Mã sản phẩm:");

            lb_ttien.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
            lb_ttien.setText("Thành tiền:");

            cb_hd.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
            cb_hd.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    cb_hdMouseClicked(evt);
                }
            });
            cb_hd.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    cb_hdActionPerformed(evt);
                }
            });

            cb_sanpham.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

            lb_soluong.setText("Số lượng:");

            txt_soluong.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    txt_soluongActionPerformed(evt);
                }
            });
            txt_soluong.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyReleased(java.awt.event.KeyEvent evt) {
                    txt_soluongKeyReleased(evt);
                }
            });

            lb_giamgia.setText("Tiền giảm giá:");

            javax.swing.GroupLayout pn_cthdLayout = new javax.swing.GroupLayout(pn_cthd);
            pn_cthd.setLayout(pn_cthdLayout);
            pn_cthdLayout.setHorizontalGroup(
                pn_cthdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pn_cthdLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(pn_cthdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pn_cthdLayout.createSequentialGroup()
                            .addGroup(pn_cthdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lb_mhd)
                                .addComponent(lb_soluong))
                            .addGroup(pn_cthdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(pn_cthdLayout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cb_hd, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_cthdLayout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                                    .addComponent(txt_soluong, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)))
                            .addGroup(pn_cthdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lb_giamgia)
                                .addComponent(lb_sach))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(pn_cthdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txt_giamgia)
                                .addComponent(cb_sanpham, 0, 108, Short.MAX_VALUE)))
                        .addGroup(pn_cthdLayout.createSequentialGroup()
                            .addGroup(pn_cthdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lb_ttien)
                                .addComponent(lb_dongia))
                            .addGap(18, 18, 18)
                            .addGroup(pn_cthdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txt_ttien)
                                .addComponent(txt_dongia))))
                    .addContainerGap())
            );
            pn_cthdLayout.setVerticalGroup(
                pn_cthdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pn_cthdLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(pn_cthdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lb_mhd)
                        .addComponent(cb_hd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lb_sach)
                        .addComponent(cb_sanpham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(9, 9, 9)
                    .addGroup(pn_cthdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lb_soluong)
                        .addComponent(txt_soluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lb_giamgia)
                        .addComponent(txt_giamgia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(pn_cthdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_dongia, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                        .addComponent(lb_dongia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(pn_cthdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_ttien, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lb_ttien)))
            );

            pn_docthd.setBackground(new java.awt.Color(204, 255, 204));
            pn_docthd.setBorder(javax.swing.BorderFactory.createTitledBorder("Thực hiện"));

            bt_addcthd.setBackground(new java.awt.Color(204, 204, 204));
            bt_addcthd.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
            bt_addcthd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/add.png"))); // NOI18N
            bt_addcthd.setText("Thêm");
            bt_addcthd.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    bt_addcthdActionPerformed(evt);
                }
            });

            bt_resetcthd.setBackground(new java.awt.Color(204, 204, 204));
            bt_resetcthd.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
            bt_resetcthd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/reset.png"))); // NOI18N
            bt_resetcthd.setText("Reset");
            bt_resetcthd.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    bt_resetcthdActionPerformed(evt);
                }
            });

            bt_changecthd.setBackground(new java.awt.Color(204, 204, 204));
            bt_changecthd.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
            bt_changecthd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/change.png"))); // NOI18N
            bt_changecthd.setText("Sửa");
            bt_changecthd.setMaximumSize(new java.awt.Dimension(65, 23));
            bt_changecthd.setMinimumSize(new java.awt.Dimension(65, 23));
            bt_changecthd.setPreferredSize(new java.awt.Dimension(65, 23));
            bt_changecthd.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    bt_changecthdActionPerformed(evt);
                }
            });

            btn_nhapfile.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
            btn_nhapfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/import.png"))); // NOI18N
            btn_nhapfile.setText("Nhập file");
            btn_nhapfile.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    btn_nhapfileMouseClicked(evt);
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

            javax.swing.GroupLayout pn_docthdLayout = new javax.swing.GroupLayout(pn_docthd);
            pn_docthd.setLayout(pn_docthdLayout);
            pn_docthdLayout.setHorizontalGroup(
                pn_docthdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_docthdLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(pn_docthdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(bt_addcthd, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bt_changecthd, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(48, 48, 48)
                    .addComponent(bt_resetcthd, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(43, 43, 43)
                    .addGroup(pn_docthdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btn_nhapfile, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                        .addComponent(btn_taofile, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE))
                    .addGap(23, 23, 23))
            );
            pn_docthdLayout.setVerticalGroup(
                pn_docthdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pn_docthdLayout.createSequentialGroup()
                    .addGroup(pn_docthdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bt_addcthd, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_nhapfile, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pn_docthdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bt_changecthd, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_taofile, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(pn_docthdLayout.createSequentialGroup()
                    .addGap(34, 34, 34)
                    .addComponent(bt_resetcthd, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(36, Short.MAX_VALUE))
            );

            pn_table.setBackground(new java.awt.Color(255, 255, 255));
            pn_table.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chi tiết", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 0, 0))); // NOI18N

            tb_cthd.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                    {},
                    {},
                    {},
                    {}
                },
                new String [] {

                }
            ));
            tb_cthd.setToolTipText("");
            tb_cthd.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    tb_cthdMouseClicked(evt);
                }
            });
            jScrollPane1.setViewportView(tb_cthd);

            javax.swing.GroupLayout pn_tableLayout = new javax.swing.GroupLayout(pn_table);
            pn_table.setLayout(pn_tableLayout);
            pn_tableLayout.setHorizontalGroup(
                pn_tableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            );
            pn_tableLayout.setVerticalGroup(
                pn_tableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)
            );
            pn_sanphamLayout.setVerticalGroup(
                pn_sanphamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
            );

            pn_find.setBackground(new java.awt.Color(255, 255, 255));
            pn_find.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm"));

            cb_TimKiem.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
            cb_TimKiem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã hóa đơn", "Mã sản phẩm", " " }));
            cb_TimKiem.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    cb_TimKiemActionPerformed(evt);
                }
            });

            btn_TimKiem.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
            btn_TimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/find.png"))); // NOI18N
            btn_TimKiem.setText("Tìm kiếm");
            btn_TimKiem.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    btn_TimKiemMouseClicked(evt);
                }
            });
            btn_TimKiem.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btn_TimKiemActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout pn_findLayout = new javax.swing.GroupLayout(pn_find);
            pn_find.setLayout(pn_findLayout);
            pn_findLayout.setHorizontalGroup(
                pn_findLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_findLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(cb_TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(txt_TimKiem)
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

            bt_backcthd.setBackground(new java.awt.Color(204, 204, 204));
            bt_backcthd.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
            bt_backcthd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/back.png"))); // NOI18N
            bt_backcthd.setText("Back");
            bt_backcthd.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    bt_backcthdActionPerformed(evt);
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
                        .addComponent(bt_backcthd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_tknc, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE))
                    .addContainerGap())
            );
            pn_tkncLayout.setVerticalGroup(
                pn_tkncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pn_tkncLayout.createSequentialGroup()
                    .addGroup(pn_tkncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bt_backcthd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cb_tknc)
                        .addComponent(jLabel3))
                    .addGroup(pn_tkncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(pn_tkncLayout.createSequentialGroup()
                            .addGap(17, 17, 17)
                            .addComponent(btn_tknc))
                        .addGroup(pn_tkncLayout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(pn_fromto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                            .addGroup(pn_allLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(pn_sanpham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(pn_cthd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(pn_allLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(pn_find, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(pn_tknc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(pn_docthd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addContainerGap())
            );
            pn_allLayout.setVerticalGroup(
                pn_allLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pn_allLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(pn_allLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(pn_allLayout.createSequentialGroup()
                            .addComponent(pn_docthd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(pn_find, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(pn_tknc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(pn_allLayout.createSequentialGroup()
                            .addComponent(pn_cthd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(7, 7, 7)
                            .addComponent(pn_sanpham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addComponent(pn_all, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
        }// </editor-fold>//GEN-END:initComponents

    private void bt_backcthdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_backcthdActionPerformed
        arr.clear();
        arr.addAll(tempsearch);
        tempsearch.clear();
        tb_cthd.setModel(model1);
        tb_sanpham.setModel(model2);
        bt_backcthd.setVisible(false);
        reset();
    }//GEN-LAST:event_bt_backcthdActionPerformed

    private void btn_tkncMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_tkncMouseClicked
        String[] header = {"Mã hóa đơn", "Mã sản phẩm", "Đơn giá chi tiết", "Số lượng", "Thành tiền", "Tiền giảm giá"};
        DefaultTableModel modelsearch = new DefaultTableModel(header, 0);
        ArrayList<ChiTietHoaDonDTO> cthd;
        cthd = bus.timkiemCTHDnc(String.valueOf(cb_tknc.getSelectedItem()), txt_tknc1.getText().toLowerCase(), txt_tknc2.getText().toLowerCase());
        if (!cthd.isEmpty()) {
            for (int i = 0; i < cthd.size(); i++) {
                Object[] row = {cthd.get(i).getMaHD(), cthd.get(i).getMaSP(), cthd.get(i).getDonGia(),
                    cthd.get(i).getSoLuong(), cthd.get(i).getThanhTien(), cthd.get(i).getTienGiamGia_CT()};
                modelsearch.addRow(row);
            }
            tempsearch.addAll(arr);
            arr.clear();
            arr.addAll(cthd);
            tb_cthd.setModel(modelsearch);
            bt_backcthd.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Không có kết quả phù hợp");
        }
    }//GEN-LAST:event_btn_tkncMouseClicked

    private void btn_TimKiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_TimKiemMouseClicked
        String[] header = {"Mã hóa đơn", "Mã sản phẩm", "Đơn giá chi tiết", "Số lượng", "Thành tiền", "Tiền giảm giá"};
        DefaultTableModel modelsearch = new DefaultTableModel(header, 0);
        ArrayList<ChiTietHoaDonDTO> cthd;
        cthd = bus.timKiemCTHD(String.valueOf(cb_TimKiem.getSelectedItem()), txt_TimKiem.getText().toLowerCase());
        if (!cthd.isEmpty()) {
            for (int i = 0; i < cthd.size(); i++) {
                Object[] row = {cthd.get(i).getMaHD(), cthd.get(i).getMaSP(), cthd.get(i).getDonGia(),
                    cthd.get(i).getSoLuong(), cthd.get(i).getThanhTien(), cthd.get(i).getTienGiamGia_CT()};
                modelsearch.addRow(row);
            }
            tempsearch.addAll(arr);
            arr.clear();
            arr.addAll(cthd);
            tb_cthd.setModel(modelsearch);
            bt_backcthd.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Không có kết quả phù hợp");
        }
    }//GEN-LAST:event_btn_TimKiemMouseClicked

    private void tb_cthdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_cthdMouseClicked
        int i = tb_cthd.getSelectedRow();
        if (i >= 0) {
            cb_hd.setSelectedItem(tb_cthd.getModel().getValueAt(i, 0).toString());
            cb_sanpham.setSelectedItem(tb_cthd.getModel().getValueAt(i, 1).toString());
            txt_dongia.setText(tb_cthd.getModel().getValueAt(i, 2).toString());
            txt_soluong.setText(tb_cthd.getModel().getValueAt(i, 3).toString());
            txt_ttien.setText(tb_cthd.getModel().getValueAt(i, 4).toString());
            txt_giamgia.setText(tb_cthd.getModel().getValueAt(i, 5).toString());
            loadSanpham((String) cb_sanpham.getSelectedItem());
        }
    }//GEN-LAST:event_tb_cthdMouseClicked

    private void bt_changecthdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_changecthdActionPerformed
        int SLct = bus.getSLct((String) cb_hd.getSelectedItem(), (String) cb_sanpham.getSelectedItem());
        int input = Integer.parseInt(txt_soluong.getText());
        if (bt_changecthd.getText().toString().equals("Sửa")) {
            txt_dongia.setEditable(false);
            txt_ttien.setEditable(false);
            txt_giamgia.setEditable(false);
            cb_sanpham.setEnabled(false);
            txt_soluong.setEnabled(true);
            txt_giamgia.setEnabled(true);
            txt_dongia.setEnabled(true);
            txt_ttien.setEnabled(true);
            cb_sanpham.setEnabled(false);
            bt_changecthd.setText("Xác nhận");
        } else {
            if (cb_sanpham.getSelectedItem() != null && txt_giamgia.getText().length() != 0
                    && txt_dongia.getText().length() != 0 && cb_hd.getSelectedItem() != null
                    && txt_ttien.getText().length() != 0 && txt_soluong.getText().length() != 0) {
                bt_changecthd.setText("Sửa");
                int k = JOptionPane.showConfirmDialog(null, "Xác nhận sửa", "Xác nhận", JOptionPane.YES_NO_CANCEL_OPTION);
                if (k == 1) {
                    initData();
                    return;
                }
                if (k == 2) {
                    bt_changecthdActionPerformed(evt);
                    return;
                }
                int i = tb_cthd.getSelectedRow();
                if (i >= 0) {
                    ChiTietHoaDonDTO cthd = getText();
                    int check = bus.suaCTHD(cthd, i);
                    if (check == 1) {
                        setModelValueCTHD(cthd, i);
                        changedSLincthd(input, SLct);
                        changeTongtienHDfromCT();
                        changeTonggiamgiaHDfromCT();
                        changelastThanhtien();
                        JOptionPane.showMessageDialog(null, "Sửa thành công");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Sửa thất bại");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Bạn cần nhập đầy đủ thông tin vào bảng");
            }
        }
    }//GEN-LAST:event_bt_changecthdActionPerformed

    private void bt_resetcthdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_resetcthdActionPerformed
        reset();
    }//GEN-LAST:event_bt_resetcthdActionPerformed

    private void bt_addcthdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_addcthdActionPerformed
        double thanhtien = bus.getTongtienfromCTHD((String) cb_hd.getSelectedItem());
        String input = txt_soluong.getText();
        if (bt_addcthd.getText().toString().equals("Thêm")) {
            txt_dongia.setEditable(false);
            txt_ttien.setEditable(false);
//        txt_giamgia.setEditable(false);            
            txt_dongia.setEnabled(true);
            txt_ttien.setEnabled(true);
            txt_soluong.setEnabled(true);
            txt_giamgia.setEnabled(true);
            cb_hd.setEnabled(true);
            cb_sanpham.setEnabled(false);
            bt_addcthd.setText("Xác nhận");
            // reset();
            cb_hd.setSelectedItem(maHDafterclick);
        } else {
            if (cb_hd.getSelectedItem() != null && cb_sanpham.getSelectedItem() != null
                    && txt_giamgia.getText().length() != 0 && txt_dongia.getText().length() != 0
                    && cb_hd.getSelectedItem() != null && txt_ttien.getText().length() != 0
                    && txt_soluong.getText().length() != 0) {
                bt_addcthd.setText("Thêm");
                int k = JOptionPane.showConfirmDialog(null, "Xác nhận thêm", "Xác nhận", JOptionPane.YES_NO_CANCEL_OPTION);
                if (k == 1) {
                    initData();
                    return;
                }
                if (k == 2) {
                    bt_addcthdActionPerformed(evt);
                    return;
                }
                ChiTietHoaDonDTO cthd = getText();
                Vector head = setVectorCTHD(cthd);
                try {
                    int check = bus.themCTHD(cthd);
                    if (check == 1) {
                        model1.addRow(head);
                        tb_cthd.setModel(model1);
                        changeSL_afteradd(Integer.parseInt(input));
                        changeTongtienHDfromCT();
                        changeTonggiamgiaHDfromCT();
                        changelastThanhtien();
                        JOptionPane.showMessageDialog(null, "Thêm thành công");
                    } else {
                        JOptionPane.showMessageDialog(null, "Mã đã tồn tại. Thêm thất bại");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Bạn cần nhập đầy đủ thông tin vào bảng");
            }
        }
    }//GEN-LAST:event_bt_addcthdActionPerformed

    private void tb_sanphamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_sanphamMouseClicked
        int i = tb_sanpham.getSelectedRow();
        if (i >= 0) {
            cb_sanpham.setSelectedItem(tb_sanpham.getModel().getValueAt(i, 0).toString());
            txt_dongia.setText(tb_sanpham.getModel().getValueAt(i, 2).toString());
            txt_soluong.setText("");
            txt_giamgia.setText("");
        }
    }//GEN-LAST:event_tb_sanphamMouseClicked

    private void txt_soluongKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_soluongKeyReleased
        int soluongsach = busbook.getSLb((String) cb_sanpham.getSelectedItem());
        String makmfromHD = bushd.getMaKmfromHD((String) cb_hd.getSelectedItem());
//    String cb_maKM = bushd.getMaKmfromHD(makmfromHD);
        ArrayList<KhuyenMaiDTO> lkm = buskm.docKM();
//    double phantramgiam = bus.getgiamgiaCTKM((String)cb_sanpham.getSelectedItem(),makmfromHD);
        if (checkNumber(txt_soluong.getText())) {
            int input = Integer.parseInt(txt_soluong.getText());
            if (input <= soluongsach) {
                try {
                    double thanhtien = (double) ((Integer.parseInt(txt_soluong.getText())) * (Double.parseDouble(txt_dongia.getText())));
                    double giamgia = (double) (thanhtien * phantram);
                    txt_ttien.setText(String.valueOf(thanhtien - giamgia));
                    txt_giamgia.setText(String.valueOf(giamgia));
                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Không thể in số lượng released");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Số lượng không đủ");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Số lượng phải là sô");
        }
    }//GEN-LAST:event_txt_soluongKeyReleased

    private void btn_nhapfileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_nhapfileMouseClicked
        JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        int r = j.showOpenDialog(null);
        String link = null;
        if (r == JFileChooser.APPROVE_OPTION) {
            link = j.getSelectedFile().getAbsoluteFile().toString();
        }
        try {
            FileInputStream excel = new FileInputStream(new File(link));
            Workbook wb = new XSSFWorkbook(excel);
            Sheet datatypeSheet = wb.getSheetAt(0);
            DataFormatter fmt = new DataFormatter();
            Iterator<Row> ite = datatypeSheet.iterator();
            Row firstrow = ite.next();
            Row serow = ite.next();
            Cell firstcell = firstrow.getCell(0);
            ArrayList<ChiTietHoaDonDTO> list = new ArrayList<>();
            while (ite.hasNext()) {
                Row thisrow = ite.next();
                ChiTietHoaDonDTO ct = new ChiTietHoaDonDTO();
                ct.setMaHD(thisrow.getCell(0).getStringCellValue());
                ct.setMaSP(thisrow.getCell(1).getStringCellValue());
                ct.setDonGia(thisrow.getCell(2).getNumericCellValue());
                ct.setSoLuong((int) thisrow.getCell(3).getNumericCellValue());
                ct.setThanhTien(thisrow.getCell(4).getNumericCellValue());
                ct.setTienGiamGia_CT(thisrow.getCell(5).getNumericCellValue());
            }
            ArrayList<ChiTietHoaDonDTO> ctg = new ArrayList<>();
            ctg = bus.docCTHD();
            for (ChiTietHoaDonDTO hd : list) {
                boolean fl = false;
                for (int k = 0; k < ctg.size(); k++) {
                    if (hd.getMaHD().equals(ctg.get(k).getMaHD()) && hd.getMaSP().equals(ctg.get(k).getMaSP())) {
                        fl = true;
                    }
                    if (fl = false) {
                        bus.themCTHD(hd);
                    }
                }
            }
            load();
            JOptionPane.showMessageDialog(null, "Đọc file thành công!");
            wb.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PanelChiTietHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PanelChiTietHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(PanelChiTietHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_nhapfileMouseClicked

    private void btn_taofileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_taofileMouseClicked
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sheet = wb.createSheet("CTHD");
        int rowNum = 0;
        Row firstRow = sheet.createRow(rowNum++);
        Cell firstCell = firstRow.createCell(0);
        firstCell.setCellValue("Bảng chi tiết hóa đơn");
        Row title = sheet.createRow(rowNum++);
        Cell title1 = title.createCell(0);
        title1.setCellValue("Mã hóa đơn");
        Cell title2 = title.createCell(1);
        title2.setCellValue("Mã sản phẩm");
        Cell title3 = title.createCell(2);
        title3.setCellValue("Đơn giá");
        Cell title4 = title.createCell(3);
        title4.setCellValue("Số lượng");
        Cell title5 = title.createCell(4);
        title5.setCellValue("Thành tiền");
        Cell title6 = title.createCell(5);
        title6.setCellValue("Tiền giảm giá");
        ArrayList<ChiTietHoaDonDTO> list = new ArrayList<>();
        list = bus.docCTHD();
        for (int i = 0; i < list.size(); i++) {
            Row row = sheet.createRow(rowNum++);
            Cell cell1 = row.createCell(0);
            cell1.setCellValue(list.get(i).getMaHD());
            Cell cell2 = row.createCell(1);
            cell2.setCellValue(list.get(i).getMaSP());
            Cell cell3 = row.createCell(2);
            cell3.setCellValue(list.get(i).getDonGia());
            Cell cell4 = row.createCell(3);
            cell4.setCellValue(list.get(i).getSoLuong());
            Cell cell5 = row.createCell(4);
            cell5.setCellValue(list.get(i).getThanhTien());
            Cell cell6 = row.createCell(5);
            cell6.setCellValue(list.get(i).getTienGiamGia_CT());
        }
        try {
            FileOutputStream output = new FileOutputStream("./Xuatfile/CTHD.xlsx");
            wb.write(output);
            JOptionPane.showMessageDialog(null, "Xuất file thành công!");
            wb.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_taofileMouseClicked

    private void cb_TimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_TimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_TimKiemActionPerformed

    private void btn_TimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_TimKiemActionPerformed

    private void cb_hdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cb_hdMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_hdMouseClicked

    private void txt_soluongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_soluongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_soluongActionPerformed

    private void cb_hdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_hdActionPerformed
        ArrayList<KhuyenMaiDTO> lkm = buskm.docKM();
        if (bushd.getMaKmfromHD((String) cb_hd.getSelectedItem()) != null) {
            String makm = bushd.getMaKmfromHD((String) cb_hd.getSelectedItem());
            for (int i = 0; i <= lkm.size() - 1; i++) {
                if (makm != null) {
                    if (makm.equals(lkm.get(i).getMaKM())) {
                        System.out.println("đã dô");
                        phantram = lkm.get(i).getPhanTramGiamGia();
                        System.out.println(phantram);
                        break;
                    }
                } else {
                    break;
                }
            }
        }

        txt_soluong.setText("");
        txt_giamgia.setText("");
    }//GEN-LAST:event_cb_hdActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_addcthd;
    private javax.swing.JButton bt_backcthd;
    private javax.swing.JButton bt_changecthd;
    private javax.swing.JButton bt_resetcthd;
    private javax.swing.JButton btn_TimKiem;
    private javax.swing.JButton btn_nhapfile;
    private javax.swing.JButton btn_taofile;
    private javax.swing.JButton btn_tknc;
    private javax.swing.JComboBox<String> cb_TimKiem;
    private javax.swing.JComboBox<String> cb_hd;
    private javax.swing.JComboBox<String> cb_sanpham;
    private javax.swing.JComboBox<String> cb_tknc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lb_dongia;
    private javax.swing.JLabel lb_giamgia;
    private javax.swing.JLabel lb_mhd;
    private javax.swing.JLabel lb_sach;
    private javax.swing.JLabel lb_soluong;
    private javax.swing.JLabel lb_ttien;
    private javax.swing.JPanel pn_all;
    private javax.swing.JPanel pn_cthd;
    private javax.swing.JPanel pn_docthd;
    private javax.swing.JPanel pn_find;
    private javax.swing.JPanel pn_fromto;
    private javax.swing.JPanel pn_sanpham;
    private javax.swing.JPanel pn_table;
    private javax.swing.JPanel pn_tknc;
    private javax.swing.JTable tb_cthd;
    private javax.swing.JTable tb_sanpham;
    private javax.swing.JTextField txt_TimKiem;
    private javax.swing.JTextField txt_dongia;
    private javax.swing.JTextField txt_giamgia;
    private javax.swing.JTextField txt_soluong;
    private javax.swing.JTextField txt_tknc1;
    private javax.swing.JTextField txt_tknc2;
    private javax.swing.JTextField txt_ttien;
    // End of variables declaration//GEN-END:variables
}

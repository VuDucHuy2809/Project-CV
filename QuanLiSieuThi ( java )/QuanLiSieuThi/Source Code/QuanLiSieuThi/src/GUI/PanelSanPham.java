package GUI;

import BUS.SanPhamBUS;
import DTO.LoaiSanPhamDTO;
import DTO.NhaSanXuatDTO;
import DTO.SanPhamDTO;
import DTO.NhaCungCapDTO;
import java.awt.BorderLayout;
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
import untils.CheckData;
import static untils.CheckData.checkNumber;

public class PanelSanPham extends javax.swing.JPanel {

    public static Object data[] = {"", "", ""};
    DefaultTableModel model = new DefaultTableModel();
    ArrayList<SanPhamDTO> tempsearch = new ArrayList<SanPhamDTO>();
    ArrayList<SanPhamDTO> arr = new ArrayList<SanPhamDTO>();
    SanPhamBUS bus = new SanPhamBUS();

    public PanelSanPham(Object inMa[]) {
        initComponents();
        initData();
        load();
        model = (DefaultTableModel) tb_SanPham.getModel();
        txt_tg.setText((String) inMa[0]);
        txt_nsx.setText((String) inMa[2]);
        txt_ml.setText((String) inMa[1]);
        txt_ms.setEnabled(true);
        txt_ts.setEnabled(true);
        txt_nam.setEnabled(true);
        txt_dg.setEnabled(true);
        txt_sl.setEnabled(true);
        bt_nsx.setVisible(true);
        bt_ncc.setVisible(true);
        bt_ml.setVisible(true);
        bt_adds.setText("Xác nhận");
        auto_increaseMaSanPham();
    }

    public PanelSanPham() {
        initComponents();
        initData();
        load();
        bt_ml.setVisible(false);
        bt_ncc.setVisible(false);
        bt_nsx.setVisible(false);
    }

    private void initData() {
        txt_ms.setEnabled(false);
        txt_tg.setEnabled(false);
        txt_nsx.setEnabled(false);
        txt_ml.setEnabled(false);
        txt_ts.setEnabled(false);
        txt_nam.setEnabled(false);
        txt_dg.setEnabled(false);
        txt_sl.setEnabled(false);
        bt_backs.setVisible(false);
    }

    public SanPhamDTO getText() {
        SanPhamDTO s = new SanPhamDTO();
        s.setMaSP(txt_ms.getText().trim());
        s.setMaNSX(txt_tg.getText().trim());
        s.setMaNCC(txt_nsx.getText().trim());
        s.setMaLoai(txt_ml.getText().trim());
        s.setTenSP(txt_ts.getText().trim());
        s.setHSD(txt_nam.getText().trim());
        s.setDonGia(Double.parseDouble(txt_dg.getText().trim()));
        s.setSoLuong(Integer.parseInt(txt_sl.getText().trim()));
        return s;
    }

    public void load() {
        SanPhamBUS bus = new SanPhamBUS();
        try {
            bus.docSanPham();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi kết nối đến Database.");
            return;
        }
        Vector header = new Vector();
        header.add("Mã sản phẩm");
        header.add("Mã nhà sản xuất");
        header.add("Mã NCC");
        header.add("Mã loại");
        header.add("Tên sản phẩm");
        header.add("Hạn sử dụng");
        header.add("Đơn giá");
        header.add("Số lượng");
        model = new DefaultTableModel(header, 0) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        showOnTable(bus.list);
    }

    public Vector setVector(SanPhamDTO s) {
        Vector head = new Vector();
        head.add(s.getMaSP());
        head.add(s.getMaNSX());
        head.add(s.getMaNCC());
        head.add(s.getMaLoai());
        head.add(s.getTenSP());
        head.add(s.getHSD() + "");
        head.add(s.getDonGia() + "");
        head.add(s.getSoLuong() + "");
        return head;
    }

    public void showOnTable(ArrayList<SanPhamDTO> list) {
        model.setRowCount(0);
        for (SanPhamDTO s : list) {
            Vector data = setVector(s);
            model.addRow(data);
        }
        tb_SanPham.setModel(model);
    }

    public void setModelValue(SanPhamDTO s, int i) {
        model.setValueAt(s.getMaSP(), i, 0);
        model.setValueAt(s.getMaNSX(), i, 1);
        model.setValueAt(s.getMaNSX(), i, 2);
        model.setValueAt(s.getMaLoai(), i, 3);
        model.setValueAt(s.getTenSP(), i, 4);
        model.setValueAt(s.getHSD(), i, 5);
        model.setValueAt(s.getDonGia(), i, 6);
        model.setValueAt(s.getSoLuong(), i, 7);
        tb_SanPham.setModel(model);
    }

    public void auto_increaseMaSanPham() {
        String i = null;
        int a;
        String b = "00";
        String c = "0";
        if (bus.docSanPham().size() <= 0) {
            a = 0;
          
        } else {
            SanPhamDTO s = bus.docSanPham().get(bus.docSanPham().size() - 1);
            a = Integer.parseInt(s.getMaSP().substring(7, 10));
        }
        a++;
        if(a<10){ i="SANPHAM"+b+a; }
        if(10<=a && a<=99) {  i ="SANPHAM"+c+a; }
        if(a>100){  i="SANPHAM"+a; }
        txt_ms.setText(i);
    }

    public static boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pn_tts = new javax.swing.JPanel();
        lb_ms = new javax.swing.JLabel();
        txt_ms = new javax.swing.JTextField();
        lb_ts = new javax.swing.JLabel();
        txt_ts = new javax.swing.JTextField();
        lb_ml = new javax.swing.JLabel();
        txt_ml = new javax.swing.JTextField();
        lb_nsx = new javax.swing.JLabel();
        txt_nsx = new javax.swing.JTextField();
        lb_tg = new javax.swing.JLabel();
        txt_tg = new javax.swing.JTextField();
        lb_nam = new javax.swing.JLabel();
        txt_nam = new javax.swing.JTextField();
        lb_dg = new javax.swing.JLabel();
        txt_dg = new javax.swing.JTextField();
        bt_ncc = new javax.swing.JButton();
        bt_ml = new javax.swing.JButton();
        bt_nsx = new javax.swing.JButton();
        lb_sl = new javax.swing.JLabel();
        txt_sl = new javax.swing.JTextField();
        pn_dos = new javax.swing.JPanel();
        bt_adds = new javax.swing.JButton();
        bt_resets = new javax.swing.JButton();
        bt_changes = new javax.swing.JButton();
        btn_nhap = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        pn_finds = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        txt_find = new javax.swing.JTextField();
        bt_find = new javax.swing.JButton();
        bt_backs = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_SanPham = new javax.swing.JTable(){
            public boolean isCellEditable ( int row, int col)
            {
                return false;
            }
        };

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        pn_tts.setBackground(new java.awt.Color(255, 255, 255));
        pn_tts.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(255, 102, 102))); // NOI18N

        lb_ms.setText("Mã sản phẩm:");

        lb_ts.setText("Tên sản phẩm:");

        lb_ml.setText("Mã loại:");

        lb_nsx.setText("Mã nhà cung cấp:");

        lb_tg.setText("Mã nhà sản xuất");

        lb_nam.setText("HSD");

        txt_nam.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_namKeyReleased(evt);
            }
        });

        lb_dg.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lb_dg.setText("Đơn giá:");

        txt_dg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_dgKeyReleased(evt);
            }
        });

        bt_ncc.setText("...");
        bt_ncc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_nccMouseClicked(evt);
            }
        });

        bt_ml.setText("...");
        bt_ml.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_mlMouseClicked(evt);
            }
        });

        bt_nsx.setText("...");
        bt_nsx.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_nsxMouseClicked(evt);
            }
        });
        bt_nsx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_nsxActionPerformed(evt);
            }
        });

        lb_sl.setText("Số lượng:");

        txt_sl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_slKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout pn_ttsLayout = new javax.swing.GroupLayout(pn_tts);
        pn_tts.setLayout(pn_ttsLayout);
        pn_ttsLayout.setHorizontalGroup(
            pn_ttsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_ttsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_ttsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_ts)
                    .addComponent(lb_ms)
                    .addComponent(lb_ml))
                .addGap(18, 18, 18)
                .addGroup(pn_ttsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_ml, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(txt_ms)
                    .addComponent(txt_ts))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bt_ml, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76)
                .addGroup(pn_ttsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_tg)
                    .addComponent(lb_nsx)
                    .addComponent(lb_nam))
                .addGap(18, 18, 18)
                .addGroup(pn_ttsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_ttsLayout.createSequentialGroup()
                        .addGroup(pn_ttsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_tg, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_nsx, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pn_ttsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bt_ncc, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt_nsx, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txt_nam, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pn_ttsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_dg, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lb_sl, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(pn_ttsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_sl, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_dg, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        pn_ttsLayout.setVerticalGroup(
            pn_ttsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_ttsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_ttsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_ms)
                    .addComponent(txt_ms, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_tg)
                    .addComponent(txt_tg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_nsx)
                    .addComponent(lb_sl)
                    .addComponent(txt_sl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pn_ttsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_nsx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_nsx)
                    .addComponent(bt_ncc)
                    .addComponent(txt_ts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_ts)
                    .addComponent(lb_dg)
                    .addComponent(txt_dg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pn_ttsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_ml)
                    .addComponent(txt_ml, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_nam)
                    .addComponent(txt_nam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_ml))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pn_dos.setBackground(new java.awt.Color(255, 255, 204));
        pn_dos.setBorder(javax.swing.BorderFactory.createTitledBorder("Thực hiện"));

        bt_adds.setBackground(new java.awt.Color(204, 204, 204));
        bt_adds.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bt_adds.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/add.png"))); // NOI18N
        bt_adds.setText("Thêm");
        bt_adds.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_addsActionPerformed(evt);
            }
        });

        bt_resets.setBackground(new java.awt.Color(204, 204, 204));
        bt_resets.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bt_resets.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/reset.png"))); // NOI18N
        bt_resets.setText("Reset");
        bt_resets.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_resetsActionPerformed(evt);
            }
        });

        bt_changes.setBackground(new java.awt.Color(204, 204, 204));
        bt_changes.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bt_changes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/change.png"))); // NOI18N
        bt_changes.setText("Sửa");
        bt_changes.setMaximumSize(new java.awt.Dimension(65, 23));
        bt_changes.setMinimumSize(new java.awt.Dimension(65, 23));
        bt_changes.setPreferredSize(new java.awt.Dimension(65, 23));
        bt_changes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_changesActionPerformed(evt);
            }
        });

        btn_nhap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/import.png"))); // NOI18N
        btn_nhap.setText("Nhập file");
        btn_nhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_nhapMouseClicked(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/export.png"))); // NOI18N
        jButton1.setText("Xuất file");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pn_dosLayout = new javax.swing.GroupLayout(pn_dos);
        pn_dos.setLayout(pn_dosLayout);
        pn_dosLayout.setHorizontalGroup(
            pn_dosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_dosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_dosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt_adds, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_changes, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(bt_resets, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addGroup(pn_dosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_nhap, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        pn_dosLayout.setVerticalGroup(
            pn_dosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_dosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_dosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_dosLayout.createSequentialGroup()
                        .addComponent(bt_adds, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_changes, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pn_dosLayout.createSequentialGroup()
                        .addComponent(btn_nhap)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))))
            .addGroup(pn_dosLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(bt_resets, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pn_finds.setBackground(new java.awt.Color(204, 255, 204));
        pn_finds.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm"));

        jComboBox1.setBackground(new java.awt.Color(255, 255, 204));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã sản phẩm", "Tên sản phẩm", "Mã loại", "Mã NCC", "Mã nsx" }));

        bt_find.setBackground(new java.awt.Color(204, 204, 204));
        bt_find.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bt_find.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/find.png"))); // NOI18N
        bt_find.setText("Tìm kiếm");
        bt_find.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_findActionPerformed(evt);
            }
        });

        bt_backs.setBackground(new java.awt.Color(204, 204, 204));
        bt_backs.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bt_backs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/back.png"))); // NOI18N
        bt_backs.setText("Trở về");
        bt_backs.setMaximumSize(new java.awt.Dimension(65, 23));
        bt_backs.setMinimumSize(new java.awt.Dimension(65, 23));
        bt_backs.setPreferredSize(new java.awt.Dimension(65, 23));
        bt_backs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_backsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pn_findsLayout = new javax.swing.GroupLayout(pn_finds);
        pn_finds.setLayout(pn_findsLayout);
        pn_findsLayout.setHorizontalGroup(
            pn_findsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_findsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pn_findsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pn_findsLayout.createSequentialGroup()
                        .addComponent(bt_find, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_backs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pn_findsLayout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txt_find, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pn_findsLayout.setVerticalGroup(
            pn_findsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_findsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_findsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_find, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pn_findsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt_find, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_backs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        tb_SanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tb_SanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_SanPhamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_SanPham);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pn_tts, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(pn_dos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pn_finds, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(pn_tts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pn_dos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pn_finds, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bt_resetsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_resetsActionPerformed
        txt_ms.setText("");
        txt_tg.setText("");
        txt_nsx.setText("");
        txt_ml.setText("");
        txt_ts.setText("");
        txt_nam.setText("0");
        txt_dg.setText("0");
        txt_sl.setText("0");
    }//GEN-LAST:event_bt_resetsActionPerformed

    private void bt_changesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_changesActionPerformed
        if (bt_changes.getText().toString().equals("Sửa")) {
            txt_ms.setEnabled(false);
            txt_ts.setEnabled(true);
            txt_nam.setEnabled(true);
            txt_dg.setEnabled(true);
            txt_sl.setEnabled(true);
            bt_nsx.setVisible(false);
            bt_ncc.setVisible(false);
            bt_ml.setVisible(false);
            bt_changes.setText("Xác nhận");
        } else {
            if (txt_ms.getText().length() != 0 && txt_ts.getText().length() != 0
                    && txt_tg.getText().length() != 0 && txt_nsx.getText().length() != 0
                    && txt_ml.getText().length() != 0 && txt_nam.getText().length() != 0
                    && txt_dg.getText().length() != 0 && txt_sl.getText().length() != 0) {
                bt_changes.setText("Sửa");
                int i = tb_SanPham.getSelectedRow();
                if (i >= 0) {
                    int k = JOptionPane.showConfirmDialog(null, "Xác nhận sửa", "Xác nhận", JOptionPane.YES_NO_CANCEL_OPTION);
                    if (k == 1) {
                        initData();
                        return;
                    }
                    if (k == 2) {
                        bt_changesActionPerformed(evt);
                        return;
                    }
                    SanPhamDTO s = getText();
                    int check = bus.suaSanPham(s, i);
                    if (check == 1) {
                        setModelValue(s, i);
                        JOptionPane.showMessageDialog(null, "Sửa thành công");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Sửa thất bại");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Bạn cần nhập đầy đủ thông tin vào bảng");
            }
        }

    }//GEN-LAST:event_bt_changesActionPerformed

    private void bt_findActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_findActionPerformed
        String[] header = {"Mã sản phẩm", "Mã nhà sản xuất", "Mã NCC", "Mã loại", "Tên sản phẩm", "HSD", "Đơn giá", "Số lượng"};
        DefaultTableModel modelsearch = new DefaultTableModel(header, 0);
        ArrayList<SanPhamDTO> s;
        s = bus.timkiemSanPham(String.valueOf(jComboBox1.getSelectedItem()), txt_find.getText().toLowerCase().trim());
        if (s.size() != 0) {
            for (int i = 0; i < s.size(); i++) {
                Object[] row = {s.get(i).getMaSP(), s.get(i).getMaNSX(), s.get(i).getMaNCC(), s.get(i).getMaLoai(), s.get(i).getTenSP(), s.get(i).getHSD(), s.get(i).getDonGia(), s.get(i).getSoLuong()
                };
                modelsearch.addRow(row);
            }
            tempsearch.addAll(arr);
            arr.clear();
            arr.addAll(s);

            tb_SanPham.setModel(modelsearch);
            bt_backs.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Không có kết quả phù hợp!");
        }
    }//GEN-LAST:event_bt_findActionPerformed

    private void tb_SanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_SanPhamMouseClicked
        int i = tb_SanPham.getSelectedRow();
        if (i >= 0) {
            txt_ms.setText(tb_SanPham.getModel().getValueAt(i, 0).toString());
            txt_tg.setText(tb_SanPham.getModel().getValueAt(i, 1).toString());
            txt_nsx.setText(tb_SanPham.getModel().getValueAt(i, 2).toString());
            txt_ml.setText(tb_SanPham.getModel().getValueAt(i, 3).toString());
            txt_ts.setText(tb_SanPham.getModel().getValueAt(i, 4).toString());
            txt_nam.setText(tb_SanPham.getModel().getValueAt(i, 5).toString());
            txt_dg.setText(tb_SanPham.getModel().getValueAt(i, 6).toString());
            txt_sl.setText(tb_SanPham.getModel().getValueAt(i, 7).toString());
        }
    }//GEN-LAST:event_tb_SanPhamMouseClicked

    private void bt_addsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_addsActionPerformed
        if (bt_adds.getText().toString().equals("Thêm")) {
            txt_ms.setEnabled(true);
            txt_ms.setEditable(false);
            txt_ts.setEnabled(true);
            txt_nam.setEnabled(true);
            txt_dg.setEnabled(true);
            txt_sl.setEnabled(true);
            bt_nsx.setVisible(true);
            bt_ncc.setVisible(true);
            bt_ml.setVisible(true);
            bt_adds.setText("Xác nhận");
            txt_tg.setText("");
            txt_nsx.setText("");
            txt_ml.setText("");
            txt_ts.setText("");
            txt_nam.setText("0");
            txt_dg.setText("0");
            txt_sl.setText("0");
        } else {
            if (txt_ms.getText().length() != 0 && txt_ts.getText().length() != 0
                    && txt_tg.getText().length() != 0 && txt_nsx.getText().length() != 0
                    && txt_ml.getText().length() != 0 && txt_nam.getText().length() != 0
                    && txt_dg.getText().length() != 0 && txt_sl.getText().length() != 0) {
                bt_adds.setText("Thêm");
                int k = JOptionPane.showConfirmDialog(null, "Xác nhận thêm", "Xác nhận", JOptionPane.YES_NO_CANCEL_OPTION);
                if (k == 1) {
                    initData();
                    return;
                }
                if (k == 2) {
                    bt_addsActionPerformed(evt);
                    return;
                }
                SanPhamDTO s = getText();
                Vector head = setVector(s);
                int check = bus.themSanPham(s);
                if (check == 1) {
                    model.addRow(head);
                    tb_SanPham.setModel(model);
                    JOptionPane.showMessageDialog(null, "Thêm thành công");
                } else {
                    JOptionPane.showMessageDialog(null, "Mã đã tồn tại. Thêm thất bại");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Bạn cần nhập đầy đủ thông tin vào bảng");
            }
        }
        auto_increaseMaSanPham();
    }//GEN-LAST:event_bt_addsActionPerformed

    private void bt_backsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_backsActionPerformed
        arr.clear();
        arr.addAll(tempsearch);
        tempsearch.clear();
        tb_SanPham.setModel(model);
        bt_backs.setVisible(false);
    }//GEN-LAST:event_bt_backsActionPerformed

    private void bt_nsxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_nsxMouseClicked
        this.removeAll();
        this.setLayout(new BorderLayout());
        this.add(new PanelNhaSanXuat());
        this.validate();
        this.repaint();
    }//GEN-LAST:event_bt_nsxMouseClicked

    private void bt_mlMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_mlMouseClicked
        this.removeAll();
        this.setLayout(new BorderLayout());
        this.add(new PanelLoaiSanPham());
        this.validate();
        this.repaint();
    }//GEN-LAST:event_bt_mlMouseClicked

    private void bt_nccMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_nccMouseClicked
        this.removeAll();
        this.setLayout(new BorderLayout());
        this.add(new PanelNhaCungCap());
        this.validate();
        this.repaint();
    }//GEN-LAST:event_bt_nccMouseClicked

    private void btn_nhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_nhapMouseClicked
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
            Cell firCell = firstrow.getCell(0);
            ArrayList<SanPhamDTO> list = new ArrayList<>();
            while (ite.hasNext()) {
                Row thisrow = ite.next();
                SanPhamDTO s = new SanPhamDTO();
                s.setMaSP(thisrow.getCell(0).getStringCellValue());
                s.setMaNSX(thisrow.getCell(1).getStringCellValue());
                s.setMaNCC(thisrow.getCell(2).getStringCellValue());
                s.setMaLoai(thisrow.getCell(3).getStringCellValue());
                s.setTenSP(thisrow.getCell(4).getStringCellValue());
                s.setHSD(thisrow.getCell(5).getStringCellValue());
                s.setDonGia(thisrow.getCell(6).getNumericCellValue());
                s.setSoLuong((int) thisrow.getCell(7).getNumericCellValue());
                list.add(s);
            }
            Vector header = new Vector();
            header.add("Mã sản phẩm");
            header.add("Mã nhà sản xuất");
            header.add("Mã NCC");
            header.add("Mã loại");
            header.add("Tên sản phẩm");
            header.add("HSD");
            header.add("Đơn giá");
            header.add("Số lượng");
            DefaultTableModel modelf = new DefaultTableModel(header, 0);
            for (SanPhamDTO s : list) {
                Vector data = new Vector();
                data = setVector(s);
                modelf.addRow(data);
            }
            tb_SanPham.setModel(modelf);
            wb.close();
            ArrayList<SanPhamDTO> sag = new ArrayList<>();
            sag = bus.docSanPham();
            for (SanPhamDTO s : list) {
                boolean fl = false;
                for (int k = 0; k < sag.size(); k++) {
                    if (s.getMaSP().equals(sag.get(k).getMaSP())) {
                        fl = true;
                    }
                }
                if (fl = false) {
                    bus.themSanPham(s);
                }
            }
            JOptionPane.showMessageDialog(null, "Nhập từ file thành công");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PanelSanPham.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PanelSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_nhapMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sheet = wb.createSheet();
        int rowNum = 0;
        Row firstRow = sheet.createRow(rowNum++);
        Cell firstCell = firstRow.createCell(0);
        firstCell.setCellValue("Bảng sản phẩm");
        Row title = sheet.createRow(rowNum++);
        Cell title1 = title.createCell(0);
        title1.setCellValue("Mã sản phẩm");
        Cell title2 = title.createCell(1);
        title2.setCellValue("Mã nhà sản xuất");
        Cell title3 = title.createCell(2);
        title3.setCellValue("Mã NCC");
        Cell title4 = title.createCell(3);
        title4.setCellValue("Mã loại");
        Cell title5 = title.createCell(4);
        title5.setCellValue("Tên sản phẩm");
        Cell title6 = title.createCell(5);
        title6.setCellValue("HSD");
        Cell title7 = title.createCell(6);
        title7.setCellValue("Đơn giá");
        Cell title8 = title.createCell(7);
        title8.setCellValue("Số lượng");
        ArrayList<SanPhamDTO> list = new ArrayList<>();
        list = bus.docSanPham();
        for (int i = 0; i < list.size(); i++) {
            Row row = sheet.createRow(rowNum++);
            Cell cell1 = row.createCell(0);
            cell1.setCellValue(list.get(i).getMaSP());
            Cell cell2 = row.createCell(1);
            cell1.setCellValue(list.get(i).getMaNSX());
            Cell cell3 = row.createCell(2);
            cell3.setCellValue(list.get(i).getMaNCC());
            Cell cell4 = row.createCell(3);
            cell4.setCellValue(list.get(i).getMaLoai());
            Cell cell5 = row.createCell(4);
            cell5.setCellValue(list.get(i).getTenSP());
            Cell cell6 = row.createCell(5);
            cell6.setCellValue(list.get(i).getHSD());
            Cell cell7 = row.createCell(6);
            cell7.setCellValue(list.get(i).getDonGia());
            Cell cell8 = row.createCell(7);
            cell8.setCellValue(list.get(i).getSoLuong());
        }
        try {
            FileOutputStream output = new FileOutputStream("./Xuatfile/Sanpham.xlsx");
            wb.write(output);
            wb.close();
            JOptionPane.showMessageDialog(null, "Xuất file thành công");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(PanelSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1MouseClicked

    private void txt_namKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_namKeyReleased
        if (!checkNumber(txt_nam.getText())) {
            JOptionPane.showMessageDialog(null, "Hạn sử dụng phải là số");
        }
    }//GEN-LAST:event_txt_namKeyReleased

    private void txt_slKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_slKeyReleased
        if (!checkNumber(txt_sl.getText())) {
            JOptionPane.showMessageDialog(null, "Vui lòng chỉ nhập số");
        }
    }//GEN-LAST:event_txt_slKeyReleased

    private void txt_dgKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dgKeyReleased
        if (!isDouble(txt_dg.getText())) {
            JOptionPane.showMessageDialog(null, "Đơn giá phải là số");
        }
    }//GEN-LAST:event_txt_dgKeyReleased

    private void bt_nsxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_nsxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_nsxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_adds;
    private javax.swing.JButton bt_backs;
    private javax.swing.JButton bt_changes;
    private javax.swing.JButton bt_find;
    private javax.swing.JButton bt_ml;
    private javax.swing.JButton bt_ncc;
    private javax.swing.JButton bt_nsx;
    private javax.swing.JButton bt_resets;
    private javax.swing.JButton btn_nhap;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_dg;
    private javax.swing.JLabel lb_ml;
    private javax.swing.JLabel lb_ms;
    private javax.swing.JLabel lb_nam;
    private javax.swing.JLabel lb_nsx;
    private javax.swing.JLabel lb_sl;
    private javax.swing.JLabel lb_tg;
    private javax.swing.JLabel lb_ts;
    private javax.swing.JPanel pn_dos;
    private javax.swing.JPanel pn_finds;
    private javax.swing.JPanel pn_tts;
    private javax.swing.JTable tb_SanPham;
    private javax.swing.JTextField txt_dg;
    private javax.swing.JTextField txt_find;
    private javax.swing.JTextField txt_ml;
    private javax.swing.JTextField txt_ms;
    private javax.swing.JTextField txt_nam;
    private javax.swing.JTextField txt_nsx;
    private javax.swing.JTextField txt_sl;
    public javax.swing.JTextField txt_tg;
    private javax.swing.JTextField txt_ts;
    // End of variables declaration//GEN-END:variables

}

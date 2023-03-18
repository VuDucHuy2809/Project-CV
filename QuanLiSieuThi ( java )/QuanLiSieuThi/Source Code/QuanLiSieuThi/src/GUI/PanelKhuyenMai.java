
package GUI;

import BUS.ChiTietKhuyenMaiBUS;
import BUS.KhuyenMaiBUS;
import DTO.KhuyenMaiDTO;
import DTO.ChiTietKhuyenMaiDTO;
import DTO.HoaDonDTO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

public class PanelKhuyenMai extends javax.swing.JPanel {
    DefaultTableModel model1 = new DefaultTableModel();
    DefaultTableModel model2 = new DefaultTableModel();
    ArrayList<KhuyenMaiDTO> tempsearch = new ArrayList<>();
    ArrayList<KhuyenMaiDTO> arr = new ArrayList<>();
    KhuyenMaiBUS  bus = new KhuyenMaiBUS();
    ChiTietKhuyenMaiBUS busct = new ChiTietKhuyenMaiBUS();
    SimpleDateFormat formatofDate;

    public PanelKhuyenMai() {
        initComponents();
        formatofDate = new SimpleDateFormat("yyyy-MM-dd");
        initData();
        load();
        loadCTKM(null);
        btn_backKM.setVisible(false);
    }
    public void initData()
    {
        txt_maKM.setEnabled(false);
        txt_loaiKM.setEnabled(false);
        date_bd.setEnabled(false);
        date_kt.setEnabled(false);
        txt_phantramKM.setEnabled(false);
        txt_tenKM.setEnabled(false);
        btn_backKM.setVisible(false);
    }
    public void load()
    {
        KhuyenMaiBUS kmbus = new KhuyenMaiBUS();
        try {
            kmbus.docKM();
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Lỗi khi đọc database");
            return;
        }
        Vector header;
        header = new Vector();
        header.add("Mã khuyến mãi");
        header.add("Tên khuyến mãi");
        header.add("Loại khuyến mãi");
        header.add("Ngày bắt đầu");
        header.add("Ngày kết thúc");
        header.add("Phần trăm giảm giá");
        model1 = new DefaultTableModel(header, 0){
            public boolean isCellEditTable(int row, int column)
                {
                    return false;
                }
        };
        showOnTableKM(kmbus.list);
                
    }
    public void showOnTableKM(ArrayList<KhuyenMaiDTO> list)
    {
        model1.setRowCount(0);
        for (KhuyenMaiDTO km : list)
        {
            Vector data = setVectorKM(km);
            model1.addRow(data);
        }
        tbl_km.setModel(model1);
    }
    public Vector setVectorKM(KhuyenMaiDTO km)
    {
        Vector temp = new Vector();
        temp.add(km.getMaKM());
        temp.add(km.getTenChuongTrinh());
        temp.add(km.getLoaiChuongTrinh());
        temp.add(km.getNgayBDKM());
        temp.add(km.getNgayKTKM());
        temp.add(km.getPhanTramGiamGia());
        return temp;
    }
    public KhuyenMaiDTO getText()
    {
        KhuyenMaiDTO temp = new KhuyenMaiDTO();
        temp.setMaKM(txt_maKM.getText().trim());
        temp.setTenChuongTrinh(txt_tenKM.getText().trim());
        temp.setLoaiChuongTrinh(txt_loaiKM.getText().trim());
        temp.setPhanTramGiamGia(Double.parseDouble(txt_phantramKM.getText().trim()));
        try {
            temp.setNgayBDKM(new SimpleDateFormat("yyyy-MM-dd").format(date_bd.getDate()));
            temp.setNgayKTKM(new SimpleDateFormat("yyyy-MM-dd").format(date_kt.getDate()));
        } catch (Exception e)
        {
            Logger.getLogger(PanelKhuyenMai.class.getName()).log(Level.SEVERE, null, e);
        }
        return temp;
    }
    public void setModelValueKM(KhuyenMaiDTO km, int i)
    {
        model1.setValueAt(km.getMaKM(), i, 0);
        model1.setValueAt(km.getTenChuongTrinh(), i, 1);
        model1.setValueAt(km.getLoaiChuongTrinh(), i, 2);
        model1.setValueAt(km.getNgayBDKM(), i, 3);
        model1.setValueAt(km.getNgayKTKM(), i, 4);
        model1.setValueAt(km.getPhanTramGiamGia(), i, 5);
        tbl_km.setModel(model1);
    }
    public void loadCTKM(String MaKM)
    {
        ChiTietKhuyenMaiBUS bus1 = new ChiTietKhuyenMaiBUS();
        try {
            bus1.docCTKM();
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Lỗi đọc CTKM từ database");
            return;
        }
        Vector header;
        header = new Vector();
        header.add("Mã khuyến mãi");
        header.add("Mã sản phẩm");
        header.add("Phần trăm giảm giá");
        model2 = new DefaultTableModel(header,0){
            public boolean isCellEditable(int row, int column)
                {
                  return false;
                }
       };
        showOnTable(bus1.list, MaKM);           
    }
    private void showOnTable(ArrayList<ChiTietKhuyenMaiDTO> list, String MaKM)
    {
        model2.setRowCount(0);
        for (ChiTietKhuyenMaiDTO ct: list)
        {
            if (ct.getMaKM().equals(MaKM)||MaKM == null)
            {
                Vector data = setVectorCTKM(ct);
                model2.addRow(data);
            }
        }
        tbl_ctkm.setModel(model2);
    }
    private Vector setVectorCTKM(ChiTietKhuyenMaiDTO ct)
    {
        Vector row = new Vector();
        row.add(ct.getMaKM());
        row.add(ct.getMaSP());
        row.add(ct.getPhanTramGiamGia_CT());
        return row;
    }
    
    public void searchngay(String from ,String to)throws Exception{
        model1.setRowCount(0);
       
        for(KhuyenMaiDTO km: bus.timkiemKMnc(from, to)){
            model1.addRow(new Object[]{
            km.getMaKM(), km.getTenChuongTrinh(), km.getLoaiChuongTrinh(), km.getNgayBDKM(), km.getNgayKTKM(), km.getPhanTramGiamGia()
            });
        }
        tempsearch.addAll(arr);
        btn_backKM.setVisible(true);
    }
    public int getMa()
    {
        ArrayList<KhuyenMaiDTO> arr = new ArrayList<>();
        arr=bus.docKM();
        return bus.docKM().size();
    }    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        pn_all = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_tenKM = new javax.swing.JTextField();
        txt_loaiKM = new javax.swing.JTextField();
        txt_phantramKM = new javax.swing.JTextField();
        date_bd = new com.toedter.calendar.JDateChooser();
        date_kt = new com.toedter.calendar.JDateChooser();
        txt_maKM = new javax.swing.JTextField();
        btn_resetKM = new javax.swing.JPanel();
        btn_editKM = new javax.swing.JButton();
        btn_addKM = new javax.swing.JButton();
        btn_reset = new javax.swing.JButton();
        btn_taofile = new javax.swing.JButton();
        btn_nhapfile = new javax.swing.JButton();
        btn_backKM = new javax.swing.JButton();
        pn_ctkm = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_ctkm = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        cb_timkiemKM = new javax.swing.JComboBox<>();
        txt_timkiem = new javax.swing.JTextField();
        btn_find = new javax.swing.JButton();
        pb_tknc = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        date_tkbd = new com.toedter.calendar.JDateChooser();
        date_tkkt = new com.toedter.calendar.JDateChooser();
        btn_find1 = new javax.swing.JButton();
        pn_km = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_km = new javax.swing.JTable();

        pn_all.setBackground(new java.awt.Color(0, 204, 204));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin khuyến mãi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(255, 102, 102))); // NOI18N

        jLabel1.setText("Mã khuyến mãi:");

        jLabel3.setText("Tên chương trình: ");

        jLabel4.setText("Loại chương trình: ");

        jLabel5.setText("Ngày bắt đầu: ");

        jLabel6.setText("Ngày kết thúc: ");

        jLabel7.setText("Phần trăm giảm giá:");

        txt_phantramKM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_phantramKMKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txt_maKM, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_phantramKM))
                            .addComponent(txt_tenKM)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(date_bd, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                        .addComponent(date_kt, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_loaiKM)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_phantramKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_maKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_tenKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_loaiKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(date_bd, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(date_kt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btn_resetKM.setBackground(new java.awt.Color(204, 255, 204));
        btn_resetKM.setBorder(javax.swing.BorderFactory.createTitledBorder("Thực hiện"));
        btn_resetKM.setPreferredSize(new java.awt.Dimension(395, 160));

        btn_editKM.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_editKM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/change.png"))); // NOI18N
        btn_editKM.setText("Sửa");
        btn_editKM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_editKMMouseClicked(evt);
            }
        });

        btn_addKM.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_addKM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/add.png"))); // NOI18N
        btn_addKM.setText("Thêm");
        btn_addKM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_addKMMouseClicked(evt);
            }
        });

        btn_reset.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_reset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/reset.png"))); // NOI18N
        btn_reset.setText("Reset");
        btn_reset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_resetMouseClicked(evt);
            }
        });

        btn_taofile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/export.png"))); // NOI18N
        btn_taofile.setText("Tạo file");
        btn_taofile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_taofileMouseClicked(evt);
            }
        });

        btn_nhapfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/import.png"))); // NOI18N
        btn_nhapfile.setText("Nhập từ file");
        btn_nhapfile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_nhapfileMouseClicked(evt);
            }
        });

        btn_backKM.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_backKM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/back.png"))); // NOI18N
        btn_backKM.setText("Back");
        btn_backKM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_backKMMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btn_resetKMLayout = new javax.swing.GroupLayout(btn_resetKM);
        btn_resetKM.setLayout(btn_resetKMLayout);
        btn_resetKMLayout.setHorizontalGroup(
            btn_resetKMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_resetKMLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(btn_resetKMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_addKM, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                    .addComponent(btn_reset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(btn_resetKMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_editKM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_backKM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(btn_resetKMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_nhapfile, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_taofile, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        btn_resetKMLayout.setVerticalGroup(
            btn_resetKMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_resetKMLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(btn_resetKMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_addKM, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_editKM, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_nhapfile, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(btn_resetKMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_taofile, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_backKM, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_reset, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
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
        jScrollPane3.setViewportView(tbl_ctkm);

        javax.swing.GroupLayout pn_ctkmLayout = new javax.swing.GroupLayout(pn_ctkm);
        pn_ctkm.setLayout(pn_ctkmLayout);
        pn_ctkmLayout.setHorizontalGroup(
            pn_ctkmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
        );
        pn_ctkmLayout.setVerticalGroup(
            pn_ctkmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(102, 51, 255))); // NOI18N

        cb_timkiemKM.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã khuyến mãi", "Tên Chương Trình", "Loại chương trình" }));

        btn_find.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_find.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/find.png"))); // NOI18N
        btn_find.setText("Tìm kiếm");
        btn_find.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_findMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cb_timkiemKM, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txt_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_find, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_find))
                    .addComponent(cb_timkiemKM, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_timkiem, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
        );

        pb_tknc.setBackground(new java.awt.Color(255, 255, 204));
        pb_tknc.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm nâng cao", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        jLabel2.setText("Ngày bắt đầu:");

        jLabel8.setText("Ngày kết thúc:");

        btn_find1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_find1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/find.png"))); // NOI18N
        btn_find1.setText("Tìm kiếm");
        btn_find1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_find1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pb_tkncLayout = new javax.swing.GroupLayout(pb_tknc);
        pb_tknc.setLayout(pb_tkncLayout);
        pb_tkncLayout.setHorizontalGroup(
            pb_tkncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pb_tkncLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pb_tkncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pb_tkncLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pb_tkncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(date_tkkt, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                            .addComponent(date_tkbd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_find1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pb_tkncLayout.setVerticalGroup(
            pb_tkncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pb_tkncLayout.createSequentialGroup()
                .addGroup(pb_tkncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pb_tkncLayout.createSequentialGroup()
                        .addGroup(pb_tkncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(date_tkbd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pb_tkncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(date_tkkt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pb_tkncLayout.createSequentialGroup()
                        .addComponent(btn_find1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tbl_km.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbl_km.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_kmMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_km);

        javax.swing.GroupLayout pn_kmLayout = new javax.swing.GroupLayout(pn_km);
        pn_km.setLayout(pn_kmLayout);
        pn_kmLayout.setHorizontalGroup(
            pn_kmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        pn_kmLayout.setVerticalGroup(
            pn_kmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pn_allLayout = new javax.swing.GroupLayout(pn_all);
        pn_all.setLayout(pn_allLayout);
        pn_allLayout.setHorizontalGroup(
            pn_allLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_allLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_allLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pn_km, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pn_allLayout.createSequentialGroup()
                        .addGroup(pn_allLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btn_resetKM, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pn_allLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pn_ctkm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pb_tknc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        pn_allLayout.setVerticalGroup(
            pn_allLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_allLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_allLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pn_allLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_resetKM, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pn_allLayout.createSequentialGroup()
                        .addComponent(pn_ctkm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pb_tknc, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pn_km, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(pn_all, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_editKMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_editKMMouseClicked
        if (txt_maKM.getText().length()==0)
        {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn hàng cần sửa.");
            return;
        }
        if (btn_editKM.getText().equals("Sửa"))
        {
            txt_maKM.setEnabled(false);
            txt_loaiKM.setEnabled(true);
            date_bd.setEnabled(true);
            date_kt.setEnabled(true);
            txt_phantramKM.setEnabled(true);
            txt_tenKM.setEnabled(true);
            btn_backKM.setVisible(true);
            btn_editKM.setText("Xác nhận");
        }
        else 
        {
            if (txt_loaiKM.getText().length() != 0 && txt_maKM.getText().length() != 0 && txt_phantramKM.getText().length() != 0 && txt_tenKM.getText().length() != 0 && date_bd.getDate() != null && date_kt.getDate() != null)
            {
               btn_editKM.setText("Sửa");
               int i = tbl_km.getSelectedRow();
               if (i>=0)
               {
                   int k = JOptionPane.showConfirmDialog(null, "Xác nhận sửa.","Xác nhận", JOptionPane.YES_NO_CANCEL_OPTION);
                   if (k==1)
                   {
                       initData();
                       return;
                   }
                   if (k==2)
                   {
                       btn_editKMMouseClicked(evt);
                       return;
                   }
                   KhuyenMaiDTO km = getText();
                   int check = bus.suaKM(km, i);
                   if (check == 1 && k==0)
                   {
                       JOptionPane.showMessageDialog(null, "Sửa thành công.");
                       load();
                       initData();
                   } 
                   else {
                       JOptionPane.showMessageDialog(null, "Sửa thất bại.");
                   }
               }
            } else {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin.");
            }
        }
    }//GEN-LAST:event_btn_editKMMouseClicked

    private void btn_addKMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addKMMouseClicked
        btn_backKM.setEnabled(true);
        if (btn_addKM.getText().toString().equals("Thêm"))
        {
            txt_maKM.setEnabled(false);
            txt_loaiKM.setEnabled(true);
            date_bd.setEnabled(true);
            date_kt.setEnabled(true);
            txt_phantramKM.setEnabled(true);
            txt_tenKM.setEnabled(true);
            btn_backKM.setVisible(true);
            int i = getMa();
            if (i < 10)
            {
                txt_maKM.setText("KM00"+i);
            }
            else {
                txt_maKM.setText("KM0"+i);
            }
            txt_loaiKM.setText("");
            txt_phantramKM.setText("");
            txt_tenKM.setText("");
            date_bd.setDate(null);
            date_kt.setDate(null);
            btn_addKM.setText("Xác nhận");
        }
        else 
        {
            if (txt_loaiKM.getText().length() != 0 && txt_maKM.getText().length() != 0 && txt_phantramKM.getText().length() != 0 && txt_tenKM.getText().length() != 0 && date_bd.getDate() != null && date_kt.getDate() != null)
            {
                btn_addKM.setText("Thêm");
                KhuyenMaiDTO km = getText();
                Vector head = setVectorKM(km);
                int check = 0;
                int k = JOptionPane.showConfirmDialog(null, "Xác nhận thêm.","Xác nhận.", JOptionPane.YES_NO_CANCEL_OPTION);
                if (k==1)
                {
                    initData();
                    return;
                }
                if (k==2)
                {
                    btn_addKMMouseClicked(evt);
                    return;
                }
                try {
                    check = bus.themKM(km);
                } catch (Exception ex) {
                    Logger.getLogger(PanelKhuyenMai.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                if (check == 1 && k == 0) 
                {
                    JOptionPane.showMessageDialog(null, "Thêm thành công.");
                    load();
                    initData();
                }
                else JOptionPane.showMessageDialog(null, "Thêm thất bại.");
            }
            else JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin.");
        }
    }//GEN-LAST:event_btn_addKMMouseClicked

    private void btn_resetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_resetMouseClicked
        initData();
        load();
        loadCTKM(null);
    }//GEN-LAST:event_btn_resetMouseClicked

    private void btn_taofileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_taofileMouseClicked
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("KhuyenMai");
        int rowNum=0;
        Row firstRow = sheet.createRow(rowNum++);
        Cell firstCell = firstRow.createCell(0);
        firstCell.setCellValue("Bảng khuyến mãi");
        Row title = sheet.createRow(rowNum++);

        Cell title1 = title.createCell(0);
        title1.setCellValue("Mã khuyến mãi");
        Cell title2 = title.createCell(1);
        title2.setCellValue("Tên chương trình");
        Cell title3 = title.createCell(2);
        title3.setCellValue("Loại chương trình");
        Cell title4 = title.createCell(3);
        title4.setCellValue("Ngày bắt đầu");
        Cell title5 = title.createCell(4);
        title5.setCellValue("Ngày kết thúc");
        Cell title6 = title.createCell(5);
        title6.setCellValue("Phần trăm giảm giá");
        ArrayList<KhuyenMaiDTO> list = new ArrayList<>();
        list = bus.docKM();
        for (int i = 0; i< list.size(); i++)
        {
            Row row = sheet.createRow(rowNum++);
            Cell cell1 = row.createCell(0);
            cell1.setCellValue(list.get(i).getMaKM());
            Cell cell2 = row.createCell(1);
            cell2.setCellValue(list.get(i).getTenChuongTrinh());
            Cell cell3 = row.createCell(2);
            cell3.setCellValue(list.get(i).getLoaiChuongTrinh());
            Cell cell4 = row.createCell(3);
            cell4.setCellValue(list.get(i).getNgayBDKM());
            Cell cell5 = row.createCell(4);
            cell5.setCellValue(list.get(i).getNgayKTKM());
            Cell cell6 = row.createCell(5);
            cell6.setCellValue(list.get(i).getPhanTramGiamGia());
        }
        try {
            FileOutputStream output = new FileOutputStream("./Xuatfile/khuyenmai.xlsx");
            workbook.write(output);
            workbook.close();
            JOptionPane.showMessageDialog(null, "Xuất thành công.");
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_taofileMouseClicked

    private void btn_nhapfileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_nhapfileMouseClicked
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
            ArrayList<KhuyenMaiDTO> list = new ArrayList<>();
            while (ite.hasNext())
            {
                Row thisrow = ite.next();
                KhuyenMaiDTO km = new KhuyenMaiDTO();
                km.setMaKM(thisrow.getCell(0).getStringCellValue());
                km.setTenChuongTrinh(thisrow.getCell(1).getStringCellValue());
                km.setLoaiChuongTrinh(thisrow.getCell(2).getStringCellValue());
                km.setPhanTramGiamGia(thisrow.getCell(5).getNumericCellValue());
                km.setNgayBDKM(thisrow.getCell(3).getStringCellValue());
                km.setNgayKTKM(thisrow.getCell(4).getStringCellValue());
                list.add(km);
            }
            Vector header = new Vector();
            header.add("Mã khuyến mãi");
            header.add("Tên khuyến mãi");
            header.add("Loại khuyến mãi");
            header.add("Ngày bắt đầu");
            header.add("Ngày kết thúc");
            header.add("Phần trăm giảm giá");
            DefaultTableModel modelf = new DefaultTableModel(header , 0);
            for (KhuyenMaiDTO km : list)
            {
                Vector data;
                data = new Vector();
                data = setVectorKM(km);
                modelf.addRow(data);
            }
            tbl_km.setModel(modelf);
            wb.close();
            ArrayList<KhuyenMaiDTO> kmg = new ArrayList<>();
            kmg = bus.docKM();
            for (KhuyenMaiDTO km : list)
            {
                boolean fl = false;
                for (int k=0; k<kmg.size(); k++)
                {
                    if (km.getMaKM().equals(kmg.get(k).getMaKM()))
                    fl = true;
                }
                if (fl = false) bus.themKM(km);
            }
               JOptionPane.showMessageDialog(null, "Nhập từ file thành công");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PanelKhuyenMai.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PanelKhuyenMai.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(PanelKhuyenMai.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btn_nhapfileMouseClicked

    private void btn_backKMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_backKMMouseClicked
        initData();
        load();
        loadCTKM(null);
        btn_addKM.setText("Thêm");
        btn_editKM.setText("Sửa");
        btn_backKM.setVisible(false);
    }//GEN-LAST:event_btn_backKMMouseClicked

    private void btn_findMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_findMouseClicked
        String[] header = {"Mã khuyến mãi","Tên Chương Trình","Loại chương trình", "Ngày bắt đầu", "Ngày kết thúc", "Phần trăm giảm giá"};
        DefaultTableModel modelsreach = new DefaultTableModel(header , 0);
        ArrayList<KhuyenMaiDTO> km;
        km = bus.timkiemKM(String.valueOf(cb_timkiemKM.getSelectedItem()), txt_timkiem.getText().toLowerCase());
        if (km.size() != 0)
        {
            for (int i = 0; i< km.size(); i++)
            {
                Vector row = setVectorKM(km.get(i));
                modelsreach.addRow(row);
            }
            tempsearch.addAll(arr);
            arr.clear();
            arr.addAll(km);
            tbl_km.setModel(modelsreach);
            btn_backKM.setVisible(true);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Không có kết quá phù hợp");
        }

    }//GEN-LAST:event_btn_findMouseClicked

    private void btn_find1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_find1MouseClicked
        try {
            searchngay(new SimpleDateFormat("yyyy-MM-dd").format(date_tkbd.getDate()),new SimpleDateFormat("yyyy-MM-dd").format(date_tkkt.getDate()));
        } catch (Exception ex) {
            Logger.getLogger(PanelHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_find1MouseClicked

    private void tbl_kmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_kmMouseClicked
        int i = tbl_km.getSelectedRow();
        if (i>=0)
        {
            txt_maKM.setText(tbl_km.getModel().getValueAt(i, 0).toString());
            txt_loaiKM.setText(tbl_km.getModel().getValueAt(i, 2).toString());
            txt_tenKM.setText(tbl_km.getModel().getValueAt(i, 1).toString());
            txt_phantramKM.setText(tbl_km.getModel().getValueAt(i, 5).toString());
            try{
                date_bd.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(tbl_km.getValueAt(i, 3)+""));
                date_kt.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(tbl_km.getValueAt(i, 4)+""));
            } catch (ParseException e)
            {
                Logger.getLogger(PanelKhuyenMai.class.getName()).log(Level.SEVERE, null, e);
            }
            loadCTKM(txt_maKM.getText());   
        }
    }//GEN-LAST:event_tbl_kmMouseClicked

    private void txt_phantramKMKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_phantramKMKeyReleased
        double n;
        String t = txt_phantramKM.getText();
        try {
            n = Double.parseDouble(t);
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Vui lòng chỉ nhập số");
            java.awt.event.MouseEvent evt1 = null;
            if (btn_addKM.getText().equals("Xác nhận"))
            {
                btn_addKM.setText("Thêm");
                btn_addKMMouseClicked(evt1);
            }
            else
            {
                btn_editKM.setText("Sửa");
                btn_editKMMouseClicked(evt1);
        }
            txt_phantramKM.setText("0");

        }
    }//GEN-LAST:event_txt_phantramKMKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_addKM;
    private javax.swing.JButton btn_backKM;
    private javax.swing.JButton btn_editKM;
    private javax.swing.JButton btn_find;
    private javax.swing.JButton btn_find1;
    private javax.swing.JButton btn_nhapfile;
    private javax.swing.JButton btn_reset;
    private javax.swing.JPanel btn_resetKM;
    private javax.swing.JButton btn_taofile;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cb_timkiemKM;
    private com.toedter.calendar.JDateChooser date_bd;
    private com.toedter.calendar.JDateChooser date_kt;
    private com.toedter.calendar.JDateChooser date_tkbd;
    private com.toedter.calendar.JDateChooser date_tkkt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel pb_tknc;
    private javax.swing.JPanel pn_all;
    private javax.swing.JPanel pn_ctkm;
    private javax.swing.JPanel pn_km;
    private javax.swing.JTable tbl_ctkm;
    private javax.swing.JTable tbl_km;
    private javax.swing.JTextField txt_loaiKM;
    private javax.swing.JTextField txt_maKM;
    private javax.swing.JTextField txt_phantramKM;
    private javax.swing.JTextField txt_tenKM;
    private javax.swing.JTextField txt_timkiem;
    // End of variables declaration//GEN-END:variables
}

package GUI;

import BUS.ChiTietHoaDonBUS;
import DTO.HoaDonDTO;
import BUS.HoaDonBUS;
import BUS.SanPhamBUS;
import DTO.ChiTietHoaDonDTO;
import DTO.KhuyenMaiDTO;
import static com.itextpdf.io.font.PdfEncodings.IDENTITY_H;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.IBlockElement;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import static com.itextpdf.text.xml.xmp.XmpWriter.UTF8;
import java.awt.BorderLayout;
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

public class PanelHoaDon extends javax.swing.JPanel {
    DefaultTableModel model1 = new DefaultTableModel();
    DefaultTableModel model2 = new DefaultTableModel();
    ArrayList<HoaDonDTO> tempsearch = new ArrayList<HoaDonDTO>();
    ArrayList<HoaDonDTO> arr = new ArrayList<HoaDonDTO>();
    HoaDonBUS bus = new HoaDonBUS();
    ChiTietHoaDonBUS bus1 = new ChiTietHoaDonBUS();
    SimpleDateFormat formatofDate;
    public static String maHDafterclick;

    public PanelHoaDon() {
        initComponents();
        model1 = (DefaultTableModel) tb_HoaDon.getModel();
        model2 = (DefaultTableModel) tb_cthd.getModel();        
        formatofDate = new SimpleDateFormat("yyyy-MM-dd");         
        initData();
        load();
        loadCTHD(null);
        loadinCbox();     
        btn_Back.setVisible(false);
    }
    private void initData() {
        txt_mhd.setEnabled(false);
        cb_kh.setEnabled(false);
        cb_km.setEnabled(false);
        cb_nv.setEnabled(false);
        date_ngay.setEnabled(false);
        txt_ttien.setEnabled(false);
        txt_tonggg.setEnabled(false);
        txt_tongtien.setEnabled(false);
        btn_Back.setVisible(false);
        pn_fromto.setVisible(false);
    }
    public void load() {
        HoaDonBUS hdbus = new HoaDonBUS();
        try{
            hdbus.docHD();
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Lỗi kết nối đến DataBase!!!");
            return;}
        Vector header;
        header = new Vector();
        header.add("Mã hóa đơn");
        header.add("Mã nhân viên");
        header.add("Mã khách hàng");
        header.add("Mã khuyến mãi");
        header.add("Ngày xuất");
        header.add("Tổng tiền");
        header.add("Tổng giảm giá");
        header.add("Thành tiền");
        model1 = new DefaultTableModel(header, 0){
            public boolean isCellEditTable(int row, int column){
                return false;}
        };
        showOnTableHD(hdbus.list);
    }
    public void showOnTableHD(ArrayList<HoaDonDTO> list) {
        model1.setRowCount(0);
        for (HoaDonDTO hd : list){
            Vector data = setVectorHD(hd);
            model1.addRow(data);
        }
        tb_HoaDon.setModel(model1);
    }
    public Vector setVectorHD(HoaDonDTO hd) {
        Vector temp = new Vector();
        temp.add(hd.getMaHD());
        temp.add(hd.getMaNV());
        temp.add(hd.getMaKH());
        temp.add(hd.getMaKM());
        temp.add(hd.getNgayXuat());
        temp.add(hd.getTongtien());        
        temp.add(hd.getTienGiamGia());
        temp.add(hd.getThanhTien());
        return temp;

    }
    public HoaDonDTO getText(){
        HoaDonDTO temp = new HoaDonDTO();
        temp.setMaHD(txt_mhd.getText().trim());
        temp.setMaNV((String)cb_nv.getSelectedItem());        
        temp.setMaKH((String)cb_kh.getSelectedItem());
        temp.setMaKM((String)cb_km.getSelectedItem());
        temp.setNgayXuat(new SimpleDateFormat("yyyy-MM-dd").format(date_ngay.getDate()));
        temp.setTongtien(Double.parseDouble(txt_tongtien.getText().trim()));        
        temp.setTienGiamGia(Double.parseDouble(txt_tonggg.getText().trim()));
        temp.setThanhTien(Double.parseDouble(txt_ttien.getText().trim()));        
        return temp; 
    }
    public void setModelValueHD(HoaDonDTO hd, int i){
        model1.setValueAt(hd.getMaHD(), i, 0);
        model1.setValueAt(hd.getMaNV(), i, 1);
        model1.setValueAt(hd.getMaKH(), i, 2);
        model1.setValueAt(hd.getMaKM(), i, 3);
        model1.setValueAt(hd.getNgayXuat(), i, 4);
        model1.setValueAt(hd.getTongtien(), i, 5);
        model1.setValueAt(hd.getTienGiamGia(), i, 6);
        model1.setValueAt(hd.getThanhTien(), i, 7);
        tb_HoaDon.setModel(model1);
    }
    public void loadCTHD(String MaHD){
        ChiTietHoaDonBUS bus1 = new ChiTietHoaDonBUS();
        try {
            bus1.docCTHD();
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Lỗi đọc CTHD từ DataBase!!!");
            return;}
        Vector header = new Vector();
        header.add("Mã hóa đơn");
        header.add("Mã sản phẩm");
        header.add("Đơn giá chi tiết");
        header.add("Số lượng");
        header.add("Thành tiền");
        header.add("Tiền giảm giá");
        model2 = new DefaultTableModel(header,0){
            public boolean isCellEditable(int row, int column)
                {
                  return false;
                }
       };
        showOnTableCTHD(bus1.listcthd,MaHD);
    }
    private void showOnTableCTHD(ArrayList<ChiTietHoaDonDTO> list, String MaHD) {
        model2.setRowCount(0);
        for (ChiTietHoaDonDTO ct : list){
          if (ct.getMaHD().equals(MaHD)||MaHD == null){
            Vector data = setVectorCTHD(ct);
            model2.addRow(data);}
        }
        tb_cthd.setModel(model2);
    }
    private Vector setVectorCTHD(ChiTietHoaDonDTO ct) {
        Vector row = new Vector();
        row.add(ct.getMaHD());
        row.add(ct.getMaSP());
        row.add(ct.getDonGia());        
        row.add(ct.getSoLuong());
        row.add(ct.getThanhTien());
        row.add(ct.getTienGiamGia_CT());
        return row;
    }
    public void loadinCbox(){
        Vector cbMaNv=  bus.loadcb_nv();
        this.cb_nv.setModel(new DefaultComboBoxModel<>(cbMaNv));
        Vector cbMaKh=  bus.loadcb_kh();
        this.cb_kh.setModel(new DefaultComboBoxModel<>(cbMaKh));        
        Vector cbMaKm = bus.loadcb_km();
        this.cb_km.setModel(new DefaultComboBoxModel<>(cbMaKm));
    }
    public void auto_increaseMaHd(){
        String i = null;
        HoaDonDTO hd= bus.docHD().get(bus.docHD().size()-1);
        String b="00";
        String c="0";
        int a= Integer.parseInt(hd.getMaHD().substring(2,5));
        a++;
        if(a<10){ i="HD"+b+a; }
        if(10<=a && a<=99) {  i ="HD"+c+a; }
        if(a>100){  i="HD"+a; }
        txt_mhd.setText(i);
    }  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pn_all = new javax.swing.JPanel();
        pn_tthd = new javax.swing.JPanel();
        lb_mhd = new javax.swing.JLabel();
        txt_mhd = new javax.swing.JTextField();
        lb_nv = new javax.swing.JLabel();
        lb_nsx = new javax.swing.JLabel();
        lb_ttien = new javax.swing.JLabel();
        txt_ttien = new javax.swing.JTextField();
        cb_nv = new javax.swing.JComboBox<>();
        cb_kh = new javax.swing.JComboBox<>();
        lb_km = new javax.swing.JLabel();
        cb_km = new javax.swing.JComboBox<>();
        ngay_xuat = new javax.swing.JLabel();
        date_ngay = new com.toedter.calendar.JDateChooser();
        lb_tonggg = new javax.swing.JLabel();
        txt_tonggg = new javax.swing.JTextField();
        lb_tongtien = new javax.swing.JLabel();
        txt_tongtien = new javax.swing.JTextField();
        pn_cthd = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_cthd = new javax.swing.JTable(){
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
        txt_tknc1 = new javax.swing.JTextField();
        txt_tknc2 = new javax.swing.JTextField();
        btn_tknc = new javax.swing.JButton();
        btn_Back = new javax.swing.JButton();
        pn_fromto = new javax.swing.JPanel();
        date_from = new com.toedter.calendar.JDateChooser();
        date_to = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pn_hd = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_HoaDon = new javax.swing.JTable(){
            public boolean isCellEditable ( int row, int col)
            {
                return false;
            }
        };
        jPanel1 = new javax.swing.JPanel();
        btn_themHD = new javax.swing.JButton();
        btn_suaHD = new javax.swing.JButton();
        btn_resetHD = new javax.swing.JButton();
        btn_xuatfile = new javax.swing.JButton();
        btn_docfile = new javax.swing.JButton();
        btn_xuathd = new javax.swing.JButton();

        pn_all.setBackground(new java.awt.Color(0, 204, 204));
        pn_all.setPreferredSize(new java.awt.Dimension(931, 680));

        pn_tthd.setBackground(new java.awt.Color(255, 255, 255));
        pn_tthd.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin hóa đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(255, 102, 102))); // NOI18N

        lb_mhd.setText("Mã hóa đơn:");

        lb_nv.setText("Mã nhân viên:");

        lb_nsx.setText("Mã khách hàng:");

        lb_ttien.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lb_ttien.setText("Thành tiền:");

        cb_nv.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cb_kh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lb_km.setText("Mã khuyến mãi:");

        cb_km.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        ngay_xuat.setText("Ngày xuất:");

        date_ngay.setDateFormatString("yyyy-MM-dd");

        lb_tonggg.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lb_tonggg.setText("Tổng giảm giá:");

        lb_tongtien.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lb_tongtien.setText("Tổng tiền:");

        javax.swing.GroupLayout pn_tthdLayout = new javax.swing.GroupLayout(pn_tthd);
        pn_tthd.setLayout(pn_tthdLayout);
        pn_tthdLayout.setHorizontalGroup(
            pn_tthdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_tthdLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_tthdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_tthdLayout.createSequentialGroup()
                        .addComponent(lb_km)
                        .addGap(10, 10, 10)
                        .addComponent(cb_km, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pn_tthdLayout.createSequentialGroup()
                        .addGroup(pn_tthdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pn_tthdLayout.createSequentialGroup()
                                .addGroup(pn_tthdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lb_nv)
                                    .addComponent(lb_mhd))
                                .addGroup(pn_tthdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pn_tthdLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(cb_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(pn_tthdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(pn_tthdLayout.createSequentialGroup()
                                                .addComponent(ngay_xuat)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(date_ngay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(pn_tthdLayout.createSequentialGroup()
                                                .addComponent(lb_nsx)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(cb_kh, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(pn_tthdLayout.createSequentialGroup()
                                        .addGap(17, 17, 17)
                                        .addComponent(txt_mhd))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_tthdLayout.createSequentialGroup()
                                .addGroup(pn_tthdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lb_tonggg)
                                    .addComponent(lb_tongtien)
                                    .addComponent(lb_ttien))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(pn_tthdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_tonggg, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                                    .addComponent(txt_tongtien)
                                    .addComponent(txt_ttien))))
                        .addContainerGap())))
        );
        pn_tthdLayout.setVerticalGroup(
            pn_tthdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_tthdLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_tthdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_mhd)
                    .addComponent(txt_mhd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pn_tthdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_nv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_nsx)
                    .addComponent(lb_nv)
                    .addComponent(cb_kh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pn_tthdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pn_tthdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lb_km)
                        .addComponent(cb_km, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ngay_xuat))
                    .addComponent(date_ngay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pn_tthdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_tongtien)
                    .addComponent(txt_tongtien))
                .addGroup(pn_tthdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pn_tthdLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_tonggg, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))
                    .addGroup(pn_tthdLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(lb_tonggg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_tthdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_ttien, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(lb_ttien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pn_cthd.setBackground(new java.awt.Color(255, 255, 255));
        pn_cthd.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chi tiết", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 102, 102))); // NOI18N

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
        jScrollPane2.setViewportView(tb_cthd);

        javax.swing.GroupLayout pn_cthdLayout = new javax.swing.GroupLayout(pn_cthd);
        pn_cthd.setLayout(pn_cthdLayout);
        pn_cthdLayout.setHorizontalGroup(
            pn_cthdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        pn_cthdLayout.setVerticalGroup(
            pn_cthdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        pn_find.setBackground(new java.awt.Color(255, 255, 255));
        pn_find.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm"));

        cb_TimKiem.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cb_TimKiem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã hóa đơn", "Mã khách hàng", "Mã nhân viên", "Mã khuyến mãi" }));

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
                .addComponent(cb_TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_TimKiem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_TimKiem)
                .addContainerGap())
        );
        pn_findLayout.setVerticalGroup(
            pn_findLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_findLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(cb_TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(txt_TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btn_TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pn_tknc.setBackground(new java.awt.Color(255, 255, 204));
        pn_tknc.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm nâng cao"));

        cb_tknc.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cb_tknc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tổng tiền", "Tiền giảm giá", "Ngày" }));
        cb_tknc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_tkncActionPerformed(evt);
            }
        });

        btn_tknc.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_tknc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/find.png"))); // NOI18N
        btn_tknc.setText("Tìm kiếm");
        btn_tknc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tkncActionPerformed(evt);
            }
        });

        btn_Back.setBackground(new java.awt.Color(204, 204, 204));
        btn_Back.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_Back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/back.png"))); // NOI18N
        btn_Back.setText("Back");
        btn_Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_BackActionPerformed(evt);
            }
        });

        pn_fromto.setBackground(new java.awt.Color(255, 255, 204));

        date_from.setDateFormatString("yyyy-MM-dd");

        date_to.setDateFormatString("yyyy-MM-dd");

        jLabel1.setText("Từ:");

        jLabel2.setText("đến:");

        javax.swing.GroupLayout pn_fromtoLayout = new javax.swing.GroupLayout(pn_fromto);
        pn_fromto.setLayout(pn_fromtoLayout);
        pn_fromtoLayout.setHorizontalGroup(
            pn_fromtoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_fromtoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(date_from, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(7, 7, 7)
                .addComponent(date_to, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                .addContainerGap())
        );
        pn_fromtoLayout.setVerticalGroup(
            pn_fromtoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_fromtoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pn_fromtoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(date_to, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(date_from, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout pn_tkncLayout = new javax.swing.GroupLayout(pn_tknc);
        pn_tknc.setLayout(pn_tkncLayout);
        pn_tkncLayout.setHorizontalGroup(
            pn_tkncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_tkncLayout.createSequentialGroup()
                .addGroup(pn_tkncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_tkncLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cb_tknc, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(txt_tknc1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_tknc2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pn_fromto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_tkncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_Back, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_tknc, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE))
                .addContainerGap())
        );
        pn_tkncLayout.setVerticalGroup(
            pn_tkncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_tkncLayout.createSequentialGroup()
                .addGroup(pn_tkncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_tknc1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_tknc2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Back, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cb_tknc))
                .addGroup(pn_tkncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_tkncLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(pn_fromto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pn_tkncLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btn_tknc)))
                .addContainerGap())
        );

        pn_hd.setBackground(new java.awt.Color(255, 255, 255));
        pn_hd.setBorder(javax.swing.BorderFactory.createTitledBorder("Hóa đơn"));

        tb_HoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tb_HoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_HoaDonMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tb_HoaDonMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tb_HoaDon);

        javax.swing.GroupLayout pn_hdLayout = new javax.swing.GroupLayout(pn_hd);
        pn_hd.setLayout(pn_hdLayout);
        pn_hdLayout.setHorizontalGroup(
            pn_hdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        pn_hdLayout.setVerticalGroup(
            pn_hdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Thực hiện"));

        btn_themHD.setBackground(new java.awt.Color(204, 204, 204));
        btn_themHD.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_themHD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/add.png"))); // NOI18N
        btn_themHD.setText("Thêm");
        btn_themHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themHDActionPerformed(evt);
            }
        });

        btn_suaHD.setBackground(new java.awt.Color(204, 204, 204));
        btn_suaHD.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_suaHD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/change.png"))); // NOI18N
        btn_suaHD.setText("Sửa");
        btn_suaHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaHDActionPerformed(evt);
            }
        });

        btn_resetHD.setBackground(new java.awt.Color(204, 204, 204));
        btn_resetHD.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_resetHD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/reset.png"))); // NOI18N
        btn_resetHD.setText("Reset");
        btn_resetHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_resetHDMouseClicked(evt);
            }
        });

        btn_xuatfile.setBackground(new java.awt.Color(204, 204, 204));
        btn_xuatfile.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_xuatfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/export.png"))); // NOI18N
        btn_xuatfile.setText("Xuất file");
        btn_xuatfile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_xuatfileMouseClicked(evt);
            }
        });

        btn_docfile.setBackground(new java.awt.Color(204, 204, 204));
        btn_docfile.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_docfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/import.png"))); // NOI18N
        btn_docfile.setText("Nhập file");
        btn_docfile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_docfileMouseClicked(evt);
            }
        });

        btn_xuathd.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_xuathd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/report.png"))); // NOI18N
        btn_xuathd.setText("Xuất  HD");
        btn_xuathd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_xuathdMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_themHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_xuatfile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_resetHD, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_docfile, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_xuathd, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                    .addComponent(btn_suaHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_themHD, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_suaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_resetHD, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_xuatfile)
                    .addComponent(btn_docfile, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_xuathd)))
        );

        javax.swing.GroupLayout pn_allLayout = new javax.swing.GroupLayout(pn_all);
        pn_all.setLayout(pn_allLayout);
        pn_allLayout.setHorizontalGroup(
            pn_allLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_allLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_allLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pn_hd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pn_allLayout.createSequentialGroup()
                        .addGroup(pn_allLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pn_tthd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pn_allLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pn_tknc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pn_find, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pn_cthd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        pn_allLayout.setVerticalGroup(
            pn_allLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_allLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_allLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pn_tthd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_allLayout.createSequentialGroup()
                        .addComponent(pn_cthd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pn_find, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_allLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pn_tknc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pn_hd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            .addComponent(pn_all, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_TimKiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_TimKiemMouseClicked
        String[] header = {"Mã hóa đơn", "Mã nhân viên", "Mã khách hàng", "Mã khuyến mãi", "Ngày xuất", "Tổng tiền", "Tổng giảm giá", "Thành tiền"};
        DefaultTableModel modelsearch = new DefaultTableModel(header , 0);
        ArrayList<HoaDonDTO> hd;
        hd = bus.timKiemHD(String.valueOf(cb_TimKiem.getSelectedItem()), txt_TimKiem.getText().toLowerCase());
        if (!hd.isEmpty()){
            for (int i = 0; i < hd.size(); i++){
                Object[] row = {hd.get(i).getMaHD(), hd.get(i).getMaNV(), hd.get(i).getMaKH(), hd.get(i).getMaKM(), hd.get(i).getNgayXuat(), hd.get(i).getTongtien(), hd.get(i).getTienGiamGia(), hd.get(i).getThanhTien()};
                modelsearch.addRow(row);
            }
            tempsearch.addAll(arr);
            tb_HoaDon.setModel(modelsearch);
            btn_Back.setVisible(true);}
        else {
            JOptionPane.showMessageDialog(null, "Không có kết quả phù hợp");}
    }//GEN-LAST:event_btn_TimKiemMouseClicked

    private void btn_BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BackActionPerformed
        load();
        reset();
        btn_Back.setVisible(false);
    }//GEN-LAST:event_btn_BackActionPerformed

    private void tb_HoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_HoaDonMouseClicked
        int i = tb_HoaDon.getSelectedRow();
        if (i >= 0){   
            txt_mhd.setText(tb_HoaDon.getModel().getValueAt(i, 0).toString());
            cb_nv.setSelectedItem(tb_HoaDon.getModel().getValueAt(i,1).toString());
            cb_kh.setSelectedItem(tb_HoaDon.getModel().getValueAt(i, 2).toString());
            cb_km.setSelectedItem(tb_HoaDon.getModel().getValueAt(i, 3).toString());
            try {
                date_ngay.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(tb_HoaDon.getModel().getValueAt(i, 4)+""));
            } catch (ParseException ex) {
                Logger.getLogger(PanelHoaDon.class.getName()).log(Level.SEVERE, null, ex);
            }
            txt_tongtien.setText(tb_HoaDon.getModel().getValueAt(i, 5).toString());
            txt_tonggg.setText(tb_HoaDon.getModel().getValueAt(i, 6).toString());
            txt_ttien.setText(tb_HoaDon.getModel().getValueAt(i, 7).toString());
            loadCTHD(txt_mhd.getText());
        }
    }//GEN-LAST:event_tb_HoaDonMouseClicked

    private void btn_themHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themHDActionPerformed
    if (btn_themHD.getText().toString().equals("Thêm")){
        txt_mhd.setEnabled(true);
        cb_kh.setEnabled(true);
        cb_nv.setEnabled(false);
        date_ngay.setEnabled(true);
        cb_km.setEnabled(true);
        txt_ttien.setEnabled(true);
        txt_tonggg.setEnabled(true);
        txt_tongtien.setEnabled(true);
        txt_ttien.setEditable(false);
        txt_tonggg.setEditable(false);
        txt_tongtien.setEditable(false);            
        btn_themHD.setText("Xác nhận");
        txt_mhd.setText("");
        cb_kh.setSelectedItem("");
        cb_nv.setSelectedItem(Login.username);
        date_ngay.setDate(null);
        cb_km.setSelectedItem("");
        txt_ttien.setText("0");
        txt_tonggg.setText("0");
        txt_tongtien.setText("0");}
    else {
        if (txt_mhd.getText().length()!= 0 && cb_kh.getSelectedItem()!=null 
            && cb_nv.getSelectedItem()!=null && date_ngay.getDate()!=null
            && cb_km.getSelectedItem()!=null && txt_ttien.getText().length()!= 0
            && txt_tonggg.getText().length()!= 0 &&  txt_tongtien.getText().length()!= 0){
            btn_themHD.setText("Thêm");
            int k = JOptionPane.showConfirmDialog(null, "Xác nhận thêm", "Xác nhận", JOptionPane.YES_NO_CANCEL_OPTION);
            if (k==1)
            {
                initData();
                return;
            }
            if (k==2)
            {
                btn_themHDActionPerformed(evt);
                return;
            }
            HoaDonDTO hd = getText();
            Vector head = setVectorHD(hd);
            int check = bus.themHD(hd);
            if (check == 1) {   
                model1.addRow(head);
                tb_HoaDon.setModel(model1);
                JOptionPane.showMessageDialog(null, "Thêm thành công");
            } else { JOptionPane.showMessageDialog(null, "Mã đã tồn tại");}
            } else { JOptionPane.showMessageDialog(null, "Bạn cần nhập đầy đủ thông tin");}
        }           
    auto_increaseMaHd();
    }//GEN-LAST:event_btn_themHDActionPerformed

    private void btn_suaHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaHDActionPerformed
        if (btn_suaHD.getText().equals("Sửa")){
            cb_kh.setEnabled(true);
            cb_nv.setEnabled(false);
            date_ngay.setEnabled(true);
            cb_km.setEnabled(true);
            txt_ttien.setEnabled(true);
            txt_tonggg.setEnabled(true);
            txt_tongtien.setEnabled(true);
            txt_ttien.setEditable(false);
            txt_tonggg.setEditable(false);
            txt_tongtien.setEditable(false);
            cb_nv.setSelectedItem(Login.username);                
            btn_suaHD.setText("Xác nhận");}
        else{
        if (cb_kh.getSelectedItem()!=null && cb_km.getSelectedItem()!=null
            && cb_nv.getSelectedItem()!=null && date_ngay.getDate()!=null){
                btn_suaHD.setText("Sửa");
                int i = tb_HoaDon.getSelectedRow();
                if (i>=0){
                    int k =JOptionPane.showConfirmDialog(null, "Xác nhận sửa", "Xác nhận", JOptionPane.YES_NO_CANCEL_OPTION);
                    if (k==1)
                    {
                        initData();
                        return;
                    }
                    if (k==2)
                    {
                        btn_suaHDActionPerformed(evt);
                        return;
                    }
                    HoaDonDTO hd = getText();
                    int check = bus.suaHD(hd, i);
                    if (check == 1) {
                        setModelValueHD(hd, i);
                        JOptionPane.showMessageDialog(null, "Sửa thành công!!!");}
                    else{
                        JOptionPane.showMessageDialog(null, "Sửa thất bại!!!");}
                }else{
                        JOptionPane.showMessageDialog(null, "Bạn cần nhập đầy đủ!!!");}
            }
        }
    }//GEN-LAST:event_btn_suaHDActionPerformed

    private void btn_resetHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_resetHDMouseClicked
        reset();
    }//GEN-LAST:event_btn_resetHDMouseClicked

    private void cb_tkncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_tkncActionPerformed
        if(cb_tknc.getSelectedIndex()==0 || cb_tknc.getSelectedIndex()== 1){
            pn_fromto.setVisible(false);
            txt_tknc1.setEnabled(true);
            txt_tknc2.setEnabled(true);            
        }
        if(cb_tknc.getSelectedIndex()== 2){
            pn_fromto.setVisible(true);
            txt_tknc1.setEnabled(false);
            txt_tknc2.setEnabled(false);
        }        
    }//GEN-LAST:event_cb_tkncActionPerformed

    private void btn_tkncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tkncActionPerformed
   if(cb_tknc.getSelectedIndex()==0 || cb_tknc.getSelectedIndex()== 1){
      searchnangcao(String.valueOf(cb_tknc.getSelectedItem()) , txt_tknc1.getText().toLowerCase(), txt_tknc2.getText().toLowerCase()); }
   if(cb_tknc.getSelectedIndex()==2){
       try {
            searchngay(new SimpleDateFormat("yyyy-MM-dd").format(date_from.getDate()),new SimpleDateFormat("yyyy-MM-dd").format(date_to.getDate()));
           } catch (Exception ex) {
                  Logger.getLogger(PanelHoaDon.class.getName()).log(Level.SEVERE, null, ex); }
       } else{ JOptionPane.showMessageDialog(null, "Không có kết quả phù hợp");}
    }//GEN-LAST:event_btn_tkncActionPerformed

    private void tb_HoaDonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_HoaDonMousePressed
        if(evt.getClickCount()==2 && tb_HoaDon.getSelectedRow()!=-1){
        maHDafterclick = txt_mhd.getText();
        this.removeAll();
        this.setLayout(new BorderLayout());
        this.add(new PanelChiTietHoaDon(maHDafterclick));
        this.validate();
        this.repaint();}
    }//GEN-LAST:event_tb_HoaDonMousePressed

    private void btn_xuatfileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_xuatfileMouseClicked
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sheet = wb.createSheet("HoaDon");
        int rowNum = 0;
        Row firstRow = sheet.createRow(rowNum++);
        Cell firsCell = firstRow.createCell(0);
        firsCell.setCellValue("Bảng hóa đơn");
        Row title = sheet.createRow(rowNum++);
        Cell title1 = title.createCell(0);
        title1.setCellValue("Mã hóa đơn");
        Cell title2 = title.createCell(1);
        title2.setCellValue("Mã nhân viên");
        Cell title3 = title.createCell(2);
        title3.setCellValue("Mã khách hàng");
        Cell title4 = title.createCell(3);
        title4.setCellValue("Mã khuyến mãi");
        Cell title5 = title.createCell(4);
        title5.setCellValue("Ngày xuất");
        Cell title6 = title.createCell(5);
        title6.setCellValue("Tổng tiền");
        Cell title7 = title.createCell(6);
        title7.setCellValue("Tiền giảm giá");
        Cell title8 = title.createCell(7);
        title8.setCellValue("Thành tiền");
        ArrayList<HoaDonDTO> list = new ArrayList<>();
        list=bus.docHD();
        for (int i = 0; i<list.size(); i++)
        {
            Row row = sheet.createRow(rowNum++);
            Cell cell1 = row.createCell(0);
            cell1.setCellValue(list.get(i).getMaHD());
            Cell cell2 = row.createCell(1);
            cell2.setCellValue(list.get(i).getMaNV());
            Cell cell3 = row.createCell(2);
            cell3.setCellValue(list.get(i).getMaKH());
            Cell cell4 = row.createCell(3);
            cell4.setCellValue(list.get(i).getMaKM());
            Cell cell5 = row.createCell(4);
            cell5.setCellValue(list.get(i).getNgayXuat());
            Cell cell6 = row.createCell(5);
            cell6.setCellValue(list.get(i).getTongtien());
            Cell cell7 = row.createCell(6);
            cell7.setCellValue(list.get(i).getTienGiamGia());
            Cell cell8 = row.createCell(7);
            cell8.setCellValue(list.get(i).getThanhTien());
        }
        try {
            FileOutputStream output = new FileOutputStream("./Xuatfile/Hoadon.xlsx");
            wb.write(output);
            wb.close();
            JOptionPane.showMessageDialog(null, "Xuất file thành công");
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_xuatfileMouseClicked

    private void btn_docfileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_docfileMouseClicked
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
            Cell firCell = firstrow.getCell(0);
            ArrayList<HoaDonDTO> list = new ArrayList<>();
            while (ite.hasNext())
            {
                Row thisrow = ite.next();
                HoaDonDTO hd = new HoaDonDTO();
                hd.setMaHD(thisrow.getCell(0).getStringCellValue());
                hd.setMaNV(thisrow.getCell(1).getStringCellValue());
                hd.setMaKH(thisrow.getCell(2).getStringCellValue());
                hd.setMaKM(thisrow.getCell(3).getStringCellValue());
                hd.setNgayXuat(thisrow.getCell(4).getStringCellValue());
                hd.setTongtien(thisrow.getCell(5).getNumericCellValue());
                hd.setTienGiamGia(thisrow.getCell(6).getNumericCellValue());
                hd.setThanhTien(thisrow.getCell(7).getNumericCellValue());
                list.add(hd);
            }
            Vector header;
            header = new Vector();
            header.add("Mã hóa đơn");
            header.add("Mã nhân viên");
            header.add("Mã khách hàng");
            header.add("Mã khuyến mãi");
            header.add("Ngày xuất");
            header.add("Tổng tiền");
            header.add("Tổng giảm giá");
            header.add("Thành tiền");
            DefaultTableModel modelf = new DefaultTableModel(header, 0);
            for (HoaDonDTO hd : list)
            {
                Vector data = new Vector();
                data = setVectorHD(hd);
                modelf.addRow(data);
            }
            tb_HoaDon.setModel(modelf);
            wb.close();
            ArrayList<HoaDonDTO> hdg = new ArrayList<>();
            hdg = bus.docHD();
            for (HoaDonDTO hd : list)
            {
                boolean fl = false;
                for (int k=0; k<hdg.size(); k++)
                {
                    if (hd.getMaHD().equals(hdg.get(k).getMaHD()))
                    fl = true;
                }
                if (fl = false) bus.themHD(hd);
            }
            JOptionPane.showMessageDialog(null, "Nhập từ file thành công");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PanelHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PanelHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_docfileMouseClicked

    private void btn_xuathdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_xuathdMouseClicked
        if (txt_tonggg.getText().length()==0)
        {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn hóa đơn cần in");
            return;
        }
        PdfWriter writer = null;
        try {
            writer = new PdfWriter("./Xuatfile/HoaDon.pdf");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PanelHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }

        PdfDocument pdfDoc = new PdfDocument(writer);
        pdfDoc.addNewPage();
        PdfFont font = null;
        try {
            font = PdfFontFactory.createFont("times.ttf", IDENTITY_H, true);
        } catch (IOException ex) {
            Logger.getLogger(PanelHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }

        Document doc = new Document(pdfDoc);
        String tittle = "BOOK  BILL";
        Paragraph title = new Paragraph(tittle);
        title.setFont(font);
        title.setFontSize(30);
        title.setTextAlignment(TextAlignment.CENTER);
        doc.add(title);
        //chèn ngày
        java.util.Date date=new java.util.Date();
        String timee = date.toString();
        Paragraph time = new Paragraph(timee);
        time.setTextAlignment(TextAlignment.RIGHT);
        doc.add(time);
        //Chèn mã hóa đơn
        String No = txt_mhd.getText();
        Paragraph dhd = new Paragraph("Bill No: "+No);
        dhd.setTextAlignment(TextAlignment.RIGHT);
        doc.add(dhd);
        ArrayList<ChiTietHoaDonDTO> list = new ArrayList<>();
        list = bus1.docCTHD();
        String HD = "Detailed price list";
        Paragraph HoaDon = new Paragraph(HD);
        float[] width = {40, 15, 15, 15, 15};
        Table  table = new Table(width);
        table.setWidthPercent(100);
        table.addCell("BookName");
        table.addCell("Unit price");
        table.addCell("Amount");
        table.addCell("Discount");
        table.addCell("Total");
        SanPhamBUS busS = new SanPhamBUS();
        double Tong = 0;

        for (ChiTietHoaDonDTO ct : list)
        {
            if (No.equals(ct.getMaHD()))
            {
                String str = null;
                try {
                    str = busS.getTenSP(ct.getMaSP());
                } catch (Exception ex) {
                    Logger.getLogger(PanelHoaDon.class.getName()).log(Level.SEVERE, null, ex);
                }
                Paragraph a = new Paragraph(str);
                a.setFont(font);
                table.addCell(a);
                str = Double.toString(ct.getDonGia());
                table.addCell(str);
                str = Integer.toString(ct.getSoLuong());
                table.addCell(str);
                str =Double.toString(ct.getTienGiamGia_CT());
                table.addCell(str);
                double tt = ct.getThanhTien() - ct.getTienGiamGia_CT();
                table.addCell(Double.toString(tt));
                Tong = Tong + tt;
            }
        }
        doc.add(HoaDon);
        doc.add(table);
        Paragraph TongTien = new Paragraph("Total: "+Tong+"đ");
        TongTien.setTextAlignment(TextAlignment.RIGHT);
        Paragraph CamOn = new Paragraph("Thanks for our purchase");
        CamOn.setTextAlignment(TextAlignment.CENTER);
        CamOn.setItalic();
        doc.add(TongTien);
        doc.add(CamOn);
        doc.close();
        JOptionPane.showMessageDialog(null, "Xuất hóa đơn thành công!");

    }//GEN-LAST:event_btn_xuathdMouseClicked

    public void searchngay(String from ,String to)throws Exception{
        model1.setRowCount(0);
        for(HoaDonDTO hd: bus.timtheoNgay(from,to)){
            model1.addRow(new Object[]{
            hd.getMaHD(),hd.getMaNV(),hd.getMaKH(),hd.getMaKM(),hd.getNgayXuat(),hd.getTongtien(),hd.getTienGiamGia(),hd.getThanhTien()
            });
        }
        tempsearch.addAll(arr);
        btn_Back.setVisible(true);
      
    }
    public void searchnangcao(String key,String from,String to){
        for(HoaDonDTO hd:bus.timkiemHDnc(key,from,to)){
            model1.addRow(new Object[]{
                 hd.getMaHD(),hd.getMaNV(),hd.getMaKH(),hd.getMaKM(),hd.getNgayXuat(),hd.getTongtien(),hd.getTienGiamGia(),hd.getThanhTien()
            });
            tempsearch.addAll(arr);
            btn_Back.setVisible(true);
           }
    }
    public void reset(){
        txt_mhd.setText("");
        cb_kh.setSelectedItem("");
        cb_km.setSelectedItem("");
        cb_nv.setSelectedItem("");
        date_ngay.setDate(null);
        txt_ttien.setText("");
        txt_tonggg.setText("");
        txt_tknc1.setText("");
        txt_tknc2.setText("");
        txt_TimKiem.setText("");
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Back;
    private javax.swing.JButton btn_TimKiem;
    private javax.swing.JButton btn_docfile;
    private javax.swing.JButton btn_resetHD;
    private javax.swing.JButton btn_suaHD;
    private javax.swing.JButton btn_themHD;
    private javax.swing.JButton btn_tknc;
    private javax.swing.JButton btn_xuatfile;
    private javax.swing.JButton btn_xuathd;
    private javax.swing.JComboBox<String> cb_TimKiem;
    private javax.swing.JComboBox<String> cb_kh;
    private javax.swing.JComboBox<String> cb_km;
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
    private javax.swing.JLabel lb_km;
    private javax.swing.JLabel lb_mhd;
    private javax.swing.JLabel lb_nsx;
    private javax.swing.JLabel lb_nv;
    private javax.swing.JLabel lb_tonggg;
    private javax.swing.JLabel lb_tongtien;
    private javax.swing.JLabel lb_ttien;
    private javax.swing.JLabel ngay_xuat;
    private javax.swing.JPanel pn_all;
    private javax.swing.JPanel pn_cthd;
    private javax.swing.JPanel pn_find;
    private javax.swing.JPanel pn_fromto;
    private javax.swing.JPanel pn_hd;
    private javax.swing.JPanel pn_tknc;
    private javax.swing.JPanel pn_tthd;
    private javax.swing.JTable tb_HoaDon;
    private javax.swing.JTable tb_cthd;
    private javax.swing.JTextField txt_TimKiem;
    private javax.swing.JTextField txt_mhd;
    private javax.swing.JTextField txt_tknc1;
    private javax.swing.JTextField txt_tknc2;
    private javax.swing.JTextField txt_tonggg;
    private javax.swing.JTextField txt_tongtien;
    private javax.swing.JTextField txt_ttien;
    // End of variables declaration//GEN-END:variables
}

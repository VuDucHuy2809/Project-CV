/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.QuanLy;

import BUS.GiayBUS;
import BUS.LoaiGiayBUS;
import BUS.NhaCungCapBUS;
import BUS.NhaSanXuatBUS;
import BUS.PhieuNhapBUS;
import ChucNangKhac.ChucNang;
import ChucNangKhac.tableFunc;
import DTO.ChiTietHoaDon;
import DTO.ChiTietPhieuNhap;
import DTO.Giay;
import DTO.LoaiGiay;
import DTO.NhaCungCap;
import DTO.NhaSanXuat;
import DTO.NhanVien;
import DTO.PhieuNhap;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class ThemPhieuNhap extends javax.swing.JFrame {

    ArrayList<Giay> dataGiay = new ArrayList<>();
    GiayBUS giaybus = new GiayBUS();
    NhaCungCapBUS nccbus = new NhaCungCapBUS();
    LoaiGiayBUS loaigiaybus = new LoaiGiayBUS();
    PhieuNhapBUS pnbus = new PhieuNhapBUS();
    NhanVien nhanvien = null;
    NhaSanXuatBUS nsxbus = new NhaSanXuatBUS();
    DefaultTableModel defaults = null;

    /**
     * Creates new form ThemPhieuNhap
     */
    public ThemPhieuNhap() {
        initComponents();
        initialization();
        performEvent();
    }

    public ThemPhieuNhap(NhanVien nv) {
        setNhanvien(nv);
        initComponents();
        initialization();
        performEvent();
    }

    public NhanVien getNhanvien() {
        return nhanvien;
    }

    public void setNhanvien(NhanVien nhanvien) {
        this.nhanvien = nhanvien;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        idReceipt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        addDetail = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        name = new javax.swing.JTextField();
        idSelect = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        addBill = new javax.swing.JButton();
        editBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        sumPrice = new javax.swing.JLabel();
        isEdit = new javax.swing.JCheckBox();
        addDetail1 = new javax.swing.JButton();
        isExist = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        nsx = new javax.swing.JComboBox<>();
        type = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        Size = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        color = new javax.swing.JTextField();
        size = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        number = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        price = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        supplier = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        idReceipt.setFont(new java.awt.Font("Times New Roman", 0, 30)); // NOI18N
        idReceipt.setEnabled(false);
        background.add(idReceipt, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, 414, -1));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 30)); // NOI18N
        jLabel1.setText("Mã Phiếu Nhập");
        background.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        table.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(table);

        background.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 710, 364));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 51));
        jLabel3.setText("Chi tiết Phiếu Nhập");
        background.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        addDetail.setBackground(new java.awt.Color(255, 255, 255));
        addDetail.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        addDetail.setForeground(new java.awt.Color(0, 153, 102));
        addDetail.setText("Hủy Bỏ");
        background.add(addDetail, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 600, 220, -1));

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        background.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 0, 10, 760));

        name.setFont(new java.awt.Font("Times New Roman", 0, 30)); // NOI18N
        background.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 140, 400, -1));

        idSelect.setFont(new java.awt.Font("Times New Roman", 0, 30)); // NOI18N
        background.add(idSelect, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 80, 400, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 30)); // NOI18N
        jLabel4.setText("Tên Giày");
        background.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 140, -1, -1));

        addBill.setBackground(new java.awt.Color(255, 255, 255));
        addBill.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        addBill.setForeground(new java.awt.Color(0, 153, 102));
        addBill.setText("Thêm Phiếu");
        background.add(addBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 690, -1, -1));

        editBtn.setBackground(new java.awt.Color(255, 255, 255));
        editBtn.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        editBtn.setForeground(new java.awt.Color(0, 153, 102));
        editBtn.setText("Sửa Chi Tiết");
        background.add(editBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 630, -1, -1));

        deleteBtn.setBackground(new java.awt.Color(255, 255, 255));
        deleteBtn.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        deleteBtn.setForeground(new java.awt.Color(0, 153, 102));
        deleteBtn.setText("Xóa Chi Tiết");
        background.add(deleteBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 630, -1, -1));

        sumPrice.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        sumPrice.setForeground(new java.awt.Color(255, 0, 51));
        sumPrice.setText("Tổng :0");
        background.add(sumPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 700, 440, 60));

        isEdit.setText("Sửa");
        isEdit.setEnabled(false);
        background.add(isEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1360, 40, -1, -1));

        addDetail1.setBackground(new java.awt.Color(255, 255, 255));
        addDetail1.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        addDetail1.setForeground(new java.awt.Color(0, 153, 102));
        addDetail1.setText("Cập nhật");
        background.add(addDetail1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 600, 220, -1));

        isExist.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        isExist.setText("Đã Tồn Tại");
        background.add(isExist, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 30, -1, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 30)); // NOI18N
        jLabel5.setText("Mã Giày");
        background.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 90, -1, -1));

        id.setFont(new java.awt.Font("Times New Roman", 0, 30)); // NOI18N
        background.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 80, 400, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel12.setText("Mã NSX :");
        background.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 200, -1, -1));

        nsx.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        background.add(nsx, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 200, 400, 40));

        type.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        background.add(type, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 260, 400, 40));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel10.setText("Mã Loại :");
        background.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 260, -1, -1));

        Size.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Size.setText("Size");
        background.add(Size, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 320, -1, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel13.setText("Màu Sắc");
        background.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 380, -1, -1));

        color.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        background.add(color, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 380, 400, -1));

        size.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        background.add(size, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 320, 400, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel16.setText("Số Lượng");
        background.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 450, -1, -1));

        number.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        background.add(number, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 450, 400, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel17.setText("Giá");
        background.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 510, -1, -1));

        price.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        background.add(price, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 510, 400, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 30)); // NOI18N
        jLabel2.setText("Nhà Cung Cấp");
        background.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        supplier.setFont(new java.awt.Font("Times New Roman", 0, 30)); // NOI18N
        background.add(supplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 80, 410, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, 1499, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(ThemPhieuNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThemPhieuNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThemPhieuNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThemPhieuNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThemPhieuNhap().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Size;
    private javax.swing.JButton addBill;
    private javax.swing.JButton addDetail;
    private javax.swing.JButton addDetail1;
    private javax.swing.JPanel background;
    private javax.swing.JTextField color;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton editBtn;
    private javax.swing.JTextField id;
    private javax.swing.JTextField idReceipt;
    private javax.swing.JComboBox<String> idSelect;
    private javax.swing.JCheckBox isEdit;
    private javax.swing.JCheckBox isExist;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField name;
    private javax.swing.JComboBox<String> nsx;
    private javax.swing.JTextField number;
    private javax.swing.JTextField price;
    private javax.swing.JTextField size;
    private javax.swing.JLabel sumPrice;
    private javax.swing.JComboBox<String> supplier;
    private javax.swing.JTable table;
    private javax.swing.JComboBox<String> type;
    // End of variables declaration//GEN-END:variables

    private void initialization() {
        setLocationRelativeTo(null);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        id.setVisible(true);
        idSelect.setVisible(false);
        idReceipt.setText(pnbus.createAutoId());

        initTable();
        loadTableData();
        loadCombobox();
    }

    private void performEvent() {
        isExist.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isExist.isSelected()) {
                    id.setVisible(false);
                    idSelect.setVisible(true);
                } else {
                    id.setVisible(true);
                    idSelect.setVisible(false);

                    reset();
                }
            }
        });

        idSelect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int select = idSelect.getSelectedIndex();
                if (select <= 0) {
                    reset();
                    return;
                }
                Giay g = giaybus.getGiayById(String.valueOf(idSelect.getSelectedItem()).substring(0, 7));
                displayValue(g);
            }
        });

        ActionListener ac = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (e.getActionCommand()) {
                    case "Xóa Chi Tiết": {
                        int row = table.getSelectedRow();
                        if (row < 0) {
                            JOptionPane.showMessageDialog(null, "Vui lòng chọn hàng để xóa");
                            return;
                        }
                        if (JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa ?", "Xác Nhận", 0) != 0) {
                            return;
                        }
                        String idG = String.valueOf(table.getValueAt(row, 0));
                        Giay g = giaybus.getGiayInAray(dataGiay, idG);
                        dataGiay = giaybus.deleteGiayInArray(dataGiay, g);
                        loadTableData();
                        break;
                    }
                    case "Sửa Chi Tiết": {
                        int row = table.getSelectedRow();
                        if (row < 0) {
                            JOptionPane.showMessageDialog(null, "Vui lòng chọn hàng để sửa");
                            return;
                        }
                        String idG = String.valueOf(table.getValueAt(row, 0));
                        Giay g = giaybus.getGiayInAray(dataGiay, idG);
                        displayValue(g);
                        isExist.setSelected(false);
                        idSelect.setVisible(false);
                        id.setVisible(true);
                        id.setEnabled(false);
                        name.setEnabled(true);
                        type.setEnabled(true);
                        nsx.setEnabled(true);
                        size.setEnabled(true);
                        color.setEnabled(true);
                        price.setEnabled(true);
                        isEdit.setSelected(true);

                        id.setText(idG);
                        break;
                    }
                    case "Thêm Phiếu": {
                        if (dataGiay.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Không thể thêm chi tiết rỗng");
                            return;
                        }
                        LocalDate ngayxuat = LocalDate.now();
                        String stafId = nhanvien.getMaNhanVien();

                        PhieuNhap pn = new PhieuNhap(
                                idReceipt.getText(),
                                stafId,
                                String.valueOf(supplier.getSelectedItem()).substring(0, 5),
                                ngayxuat
                        );

                        if (pnbus.addPieuNhap(pn) && giaybus.addGiayFromReceipt(dataGiay, pn.getMaPhieuNhap())) {
                            JOptionPane.showMessageDialog(null, "Thêm thành công");
                            idReceipt.setText(pnbus.createAutoId());
                            dataGiay = new ArrayList<>();
                            loadTableData();
                            reset();;
                            isExist.setSelected(false);
                            idSelect.setVisible(false);
                            id.setVisible(true);
                            id.setEnabled(false);
                            name.setEnabled(true);
                            type.setEnabled(true);
                            nsx.setEnabled(true);
                            size.setEnabled(true);
                            color.setEnabled(true);
                            price.setEnabled(true);
                            isEdit.setSelected(true);
                            return;
                        }
                        JOptionPane.showMessageDialog(null, "Không thể thêm");
                        break;
                    }
                    case "Hủy Bỏ": {
                        reset();
                        idSelect.setSelectedIndex(0);
                        isExist.setSelected(false);
                        isEdit.setSelected(false);
                        break;
                    }
                    case "Cập nhật": {
                        if (checkInput() == false) {
                            return;
                        }
                        if (isEdit.isSelected()) {
                            Giay g = new Giay(
                                    id.getText(),
                                    name.getText(),
                                    String.valueOf(nsx.getSelectedItem()).substring(0, 2),
                                    String.valueOf(type.getSelectedItem()).substring(0, 7),
                                    size.getText(),
                                    color.getText(),
                                    Integer.valueOf(price.getText()),
                                    giaybus.getStatusById(id.getText()),
                                    Integer.valueOf(number.getText())
                            );
                            dataGiay = giaybus.updateGiayInArray(dataGiay, g);
                            loadTableData();
                            isEdit.setSelected(false);
                            return;
                        }

                        Giay g = null;
                        if (isExist.isSelected()) {
                            g = new Giay(
                                    String.valueOf(idSelect.getSelectedItem()).substring(0, 7),
                                    name.getText(),
                                    String.valueOf(nsx.getSelectedItem()).substring(0, 2),
                                    String.valueOf(type.getSelectedItem()).substring(0, 7),
                                    size.getText(),
                                    color.getText(),
                                    giaybus.getPriceById(String.valueOf(idSelect.getSelectedItem()).substring(0, 7)),
                                    giaybus.getStatusById(String.valueOf(idSelect.getSelectedItem()).substring(0, 7)),
                                    Integer.valueOf(number.getText())
                            );
                        } else {
                            g = new Giay(
                                    id.getText(),
                                    name.getText(),
                                    String.valueOf(nsx.getSelectedItem()).substring(0, 2),
                                    String.valueOf(type.getSelectedItem()).substring(0, 7),
                                    size.getText(),
                                    color.getText(),
                                    Integer.valueOf(price.getText()),
                                    giaybus.getStatusById(id.getText()),
                                    Integer.valueOf(number.getText())
                            );
                        }

                        dataGiay = giaybus.addGiayIntoArray(dataGiay, g);
                        loadTableData();
                        break;
                    }
                }
            }
        };
        for (Component c : background.getComponents()) {
            if (c instanceof JButton) {
                ((JButton) c).addActionListener(ac);
                ((JButton) c).setActionCommand(((JButton) c).getActionCommand());
            }
        }
    }

    private void loadCombobox() {
        idSelect.addItem("[Lựa Chọn]");
        ArrayList<Giay> data = giaybus.getAllData();
        for (Giay g : data) {
            idSelect.addItem(g.getMaGiay() + "-" + g.getTenGiay());
        }

        ArrayList<LoaiGiay> dataLoaiGiay = loaigiaybus.getAllData();
        for (LoaiGiay loai : dataLoaiGiay) {
            type.addItem(loai.getMaLoai() + "-" + loai.getTenLoai());
        }

        ArrayList<NhaSanXuat> dataNSX = nsxbus.getAllData();
        for (NhaSanXuat nsx : dataNSX) {
            this.nsx.addItem(nsx.getMaNSX() + "-" + nsx.getTenNSX());
        }

        ArrayList<NhaCungCap> dataNcc = nccbus.getAllData();
        for (NhaCungCap ncc : dataNcc) {
            supplier.addItem(ncc.getMaNhaCungCap() + "-" + ncc.getTenNhaCungCap());
        }
    }

    private void initTable() {
        String[] header = {"Mã Giày", "Tên Giày", "Mã Loại", "Mã NSX", "Size", "Màu Sắc", "Số Lượng"};
        defaults = (DefaultTableModel) table.getModel();
        for (String s : header) {
            defaults.addColumn(s);
        }

        table.setRowHeight(25);
    }

    private void loadTableData() {
        tableFunc.removeAllTable(table);
        DefaultTableModel defaults = (DefaultTableModel) table.getModel();
        for (Giay g : dataGiay) {
            Object[] obj = {
                g.getMaGiay(),
                g.getTenGiay(),
                g.getMaLoai(),
                g.getMaNSX(),
                g.getSize(),
                g.getMauSac(),
                g.getSoLuong()
            };
            defaults.addRow(obj);
        }
        computePrice();
    }

    private void computePrice() {
        int sum = 0;
        for (Giay g : dataGiay) {
            sum += g.getSoLuong() * giaybus.getPriceById(g.getMaGiay());
        }
        sumPrice.setText("Tổng : " + ChucNang.convetNumberToMoney(String.valueOf(sum)) + " VNĐ");
    }

    private void reset() {
        name.setText("");
        type.setSelectedIndex(0);
        nsx.setSelectedIndex(0);
        size.setText("");
        color.setText("");
        number.setText("");
        price.setText("");

        name.setEnabled(true);
        type.setEnabled(true);
        nsx.setEnabled(true);
        size.setEnabled(true);
        color.setEnabled(true);
        price.setEnabled(true);
    }

    private void displayValue(Giay g) {
        name.setText(g.getTenGiay());
        type.setSelectedItem(g.getMaLoai() + "-" + loaigiaybus.getNameById(g.getMaLoai()));
        nsx.setSelectedItem(g.getMaNSX() + "-" + nsxbus.getNameById(g.getMaNSX()));
        size.setText(g.getSize());
        color.setText(g.getMauSac());
        price.setText(String.valueOf(giaybus.getPriceById(g.getMaGiay())));

        name.setEnabled(false);
        type.setEnabled(false);
        nsx.setEnabled(false);
        size.setEnabled(false);
        color.setEnabled(false);
        price.setEnabled(false);
    }

    public boolean checkInput() {
        if (isExist.isSelected()) {
            if (idSelect.getSelectedIndex() <= 0) {
                JOptionPane.showMessageDialog(null, "Bạn chưa chọn Sảm phẩm");
                return false;
            }
        } else {
            if (id.getText().compareTo("") == 0) {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập mã Sản phẩm");
                return false;
            }
            if (giaybus.isExistId(id.getText()) && isEdit.isSelected() == false) {
                JOptionPane.showMessageDialog(null, "Mã giày này đã tồn tại");
                return false;
            }
        }
        if (name.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Tên không được để trống");
            return false;
        }
        if (size.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Size không được để trống");
            return false;
        }
        try {
            if (Double.valueOf(size.getText()) < 0) {
                throw new Exception();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Size phải là số > 0");
            return false;
        }
        if (color.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Màu không được để trống");
            return false;
        }

        try {
            if (number.getText().compareTo("") == 0 || Integer.valueOf(number.getText()) <= 0) {
                throw new Exception();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Số lượng không hợp lệ");
            return false;
        }

        try {
            if (price.getText().compareTo("") == 0 || Integer.valueOf(price.getText()) < 1000) {
                throw new Exception();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Giá không hợp lệ  ( > 1000)");
            return false;
        }
        return true;
    }
}

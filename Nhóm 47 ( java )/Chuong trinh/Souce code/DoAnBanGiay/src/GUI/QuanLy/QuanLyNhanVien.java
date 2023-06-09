/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.QuanLy;

import BUS.NhanVienBUS;
import ChucNangKhac.ChucNang;
import ChucNangKhac.ReadExcel;
import ChucNangKhac.WriteExcel;
import ChucNangKhac.tableFunc;
import DTO.Giay;
import DTO.NhanVien;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class QuanLyNhanVien extends javax.swing.JPanel {
    DefaultTableModel defaults = null;
    NhanVienBUS nvbus = new NhanVienBUS();
    /**
     * Creates new form TrangChu
     */
    public QuanLyNhanVien() {
        initComponents();
        initialization();
        performEvent();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        searchInput = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(table);

        background.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 79, 960, 330));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 153, 102));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Icon/export_csv_48px.png"))); // NOI18N
        jButton2.setText("Xuất");
        background.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 420, 180, -1));

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 153, 102));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Icon/sync_60px.png"))); // NOI18N
        jButton3.setText("Làm mới");
        background.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 180, -1));

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton4.setForeground(new java.awt.Color(0, 153, 102));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Icon/edit_48px.png"))); // NOI18N
        jButton4.setText("Sửa");
        background.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 180, -1));

        searchInput.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        background.add(searchInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 20, 340, -1));

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton5.setForeground(new java.awt.Color(0, 153, 102));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Icon/plus_48px.png"))); // NOI18N
        jButton5.setText("Thêm");
        background.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 180, -1));

        jButton6.setBackground(new java.awt.Color(255, 255, 255));
        jButton6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton6.setForeground(new java.awt.Color(0, 153, 102));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Icon/import_csv_48px.png"))); // NOI18N
        jButton6.setText("Nhập");
        background.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 180, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, 1010, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField searchInput;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables

    private void initialization() {
       initTable();
       loadTableData();
       searchInput.setBackground(new Color(0,0,0,0));
        searchInput.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(53,167,156)));
    }

    private void performEvent() {
        ActionListener ac = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch(e.getActionCommand()){
                    case "Thêm":{
                        new ThemNhanVien().setVisible(true);
                        break;
                    }
                    case "Sửa":{
                        new SuaNhanVien().setVisible(true);
                        break;
                    }
                    case "Làm mới":{
                        loadTableData();
                        JOptionPane.showMessageDialog(null, "Đã hiển thì tất cả");
                        break;
                    }
                    case "Nhập":{
                        ReadExcel read = new ReadExcel();
                        read.readExcelStaff();
                        break;
                    }
                    case "Xuất":{
                        WriteExcel write = new WriteExcel();
                        write.WriteStaff();
                        break;
                    }
                }
            }
        };
        for(Component c : background.getComponents()){
            if(c instanceof JButton){
                ((JButton)c).addActionListener(ac);
                ((JButton)c).setActionCommand(((JButton)c).getActionCommand());
            }
        }
        
        searchInput.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                String input = ChucNang.convertTextToEnglish(searchInput.getText());
                ArrayList<NhanVien> data = nvbus.searchStaffByKey(input);
                loadTableData(data);
            }
        });
    }

    private void initTable() {
       String []header = {"Mã Nhân Viên","Tên Nhân Viên","Ngày Sinh","Địa Chỉ","SĐT","Tên Đăng Nhập","Mật Khẩu","Quyền","Trạng Thái"};
        defaults = (DefaultTableModel)table.getModel();
        
        for(String s : header){
            defaults.addColumn(s);
        }
        
        table.setRowHeight(25);
    }

    private void loadTableData() {
        tableFunc.removeAllTable(table);
        defaults = (DefaultTableModel)table.getModel();
        ArrayList<NhanVien> data = nvbus.getAllData();
        for(NhanVien nv : data){
            Object[] obj = {
              nv.getMaNhanVien(),
                nv.getTenNhanVien(),
                nv.getNgaySinh().toString(),
                nv.getDiaChi(),
                nv.getSDT(),
                nv.getUserName(),
                nv.getPassword(),
                nv.getQuyen(),
                nv.isTrangThai()
            };
            defaults.addRow(obj);
        }
    }
    
    private void loadTableData(ArrayList<NhanVien> data) {
        tableFunc.removeAllTable(table);
        defaults = (DefaultTableModel)table.getModel();
        
        for(NhanVien nv : data){
            Object[] obj = {
              nv.getMaNhanVien(),
                nv.getTenNhanVien(),
                nv.getNgaySinh().toString(),
                nv.getDiaChi(),
                nv.getSDT(),
                nv.getUserName(),
                nv.getPassword(),
                nv.getQuyen(),
                nv.isTrangThai()
            };
            defaults.addRow(obj);
        }
    }
}

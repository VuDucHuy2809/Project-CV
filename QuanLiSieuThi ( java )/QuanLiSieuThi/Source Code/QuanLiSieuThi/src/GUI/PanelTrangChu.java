
package GUI;

import BUS.HoaDonBUS;
import BUS.KhachHangBUS;
import BUS.KhuyenMaiBUS;
import BUS.NhanVienBUS;
import BUS.PhieuNhapBUS;
import BUS.SanPhamBUS;
import DTO.HoaDonDTO;
import DTO.KhachHangDTO;
import DTO.KhuyenMaiDTO;
import DTO.NhanVienDTO;
import DTO.PhieuNhapDTO;
import DTO.SanPhamDTO;
import java.util.ArrayList;

public class PanelTrangChu extends javax.swing.JPanel {

    public PanelTrangChu() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pn_all = new javax.swing.JPanel();
        tittle = new javax.swing.JPanel();
        lblTitleTC = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        pn_show = new javax.swing.JPanel();
        pnlSoLuongphieunhap = new javax.swing.JPanel();
        lb_phieunhap = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        pnlSoLuongsach = new javax.swing.JPanel();
        lb_sach = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        pnlSoLuongkhachhang = new javax.swing.JPanel();
        lb_khachhang = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        pnlSoLuonghoadon = new javax.swing.JPanel();
        lb_hoadon = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        pnlSoLuongnhanvien = new javax.swing.JPanel();
        lb_nhanvien = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        pnlSoLuongkhuyenmai = new javax.swing.JPanel();
        lb_khuyenmai = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        pn_all.setBackground(new java.awt.Color(204, 255, 204));

        tittle.setBackground(new java.awt.Color(238, 241, 245));

        lblTitleTC.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblTitleTC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/house.png"))); // NOI18N
        lblTitleTC.setText("Trang chủ");

        javax.swing.GroupLayout tittleLayout = new javax.swing.GroupLayout(tittle);
        tittle.setLayout(tittleLayout);
        tittleLayout.setHorizontalGroup(
            tittleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tittleLayout.createSequentialGroup()
                .addContainerGap(162, Short.MAX_VALUE)
                .addComponent(lblTitleTC, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(142, 142, 142))
        );
        tittleLayout.setVerticalGroup(
            tittleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tittleLayout.createSequentialGroup()
                .addComponent(lblTitleTC, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        pn_show.setBackground(new java.awt.Color(204, 255, 204));

        pnlSoLuongphieunhap.setBackground(new java.awt.Color(174, 168, 211));
        pnlSoLuongphieunhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlSoLuongphieunhapMouseClicked(evt);
            }
        });

        lb_phieunhap.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        lb_phieunhap.setText("Phiếu nhập");

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/bill2.png"))); // NOI18N

        javax.swing.GroupLayout pnlSoLuongphieunhapLayout = new javax.swing.GroupLayout(pnlSoLuongphieunhap);
        pnlSoLuongphieunhap.setLayout(pnlSoLuongphieunhapLayout);
        pnlSoLuongphieunhapLayout.setHorizontalGroup(
            pnlSoLuongphieunhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSoLuongphieunhapLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_phieunhap, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlSoLuongphieunhapLayout.setVerticalGroup(
            pnlSoLuongphieunhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSoLuongphieunhapLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSoLuongphieunhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlSoLuongphieunhapLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lb_phieunhap, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlSoLuongsach.setBackground(new java.awt.Color(255, 204, 204));
        pnlSoLuongsach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlSoLuongsachMouseClicked(evt);
            }
        });

        lb_sach.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        lb_sach.setText("Sản phẩm");

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/stand2.png"))); // NOI18N

        javax.swing.GroupLayout pnlSoLuongsachLayout = new javax.swing.GroupLayout(pnlSoLuongsach);
        pnlSoLuongsach.setLayout(pnlSoLuongsachLayout);
        pnlSoLuongsachLayout.setHorizontalGroup(
            pnlSoLuongsachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSoLuongsachLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_sach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlSoLuongsachLayout.setVerticalGroup(
            pnlSoLuongsachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSoLuongsachLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSoLuongsachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                    .addComponent(lb_sach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pnlSoLuongkhachhang.setBackground(new java.awt.Color(144, 198, 149));
        pnlSoLuongkhachhang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlSoLuongkhachhangMouseClicked(evt);
            }
        });

        lb_khachhang.setBackground(new java.awt.Color(255, 255, 255));
        lb_khachhang.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        lb_khachhang.setText("Khách hàng");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/khachhangtrangchu.png"))); // NOI18N

        javax.swing.GroupLayout pnlSoLuongkhachhangLayout = new javax.swing.GroupLayout(pnlSoLuongkhachhang);
        pnlSoLuongkhachhang.setLayout(pnlSoLuongkhachhangLayout);
        pnlSoLuongkhachhangLayout.setHorizontalGroup(
            pnlSoLuongkhachhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSoLuongkhachhangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_khachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlSoLuongkhachhangLayout.setVerticalGroup(
            pnlSoLuongkhachhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSoLuongkhachhangLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(pnlSoLuongkhachhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlSoLuongkhachhangLayout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(lb_khachhang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pnlSoLuonghoadon.setBackground(new java.awt.Color(204, 204, 204));
        pnlSoLuonghoadon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlSoLuonghoadonMouseClicked(evt);
            }
        });

        lb_hoadon.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        lb_hoadon.setText("Hóa đơn");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/hoadontrangchu.png"))); // NOI18N

        javax.swing.GroupLayout pnlSoLuonghoadonLayout = new javax.swing.GroupLayout(pnlSoLuonghoadon);
        pnlSoLuonghoadon.setLayout(pnlSoLuonghoadonLayout);
        pnlSoLuonghoadonLayout.setHorizontalGroup(
            pnlSoLuonghoadonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSoLuonghoadonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_hoadon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlSoLuonghoadonLayout.setVerticalGroup(
            pnlSoLuonghoadonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSoLuonghoadonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSoLuonghoadonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                    .addGroup(pnlSoLuonghoadonLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lb_hoadon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pnlSoLuongnhanvien.setBackground(new java.awt.Color(255, 204, 153));
        pnlSoLuongnhanvien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlSoLuongnhanvienMouseClicked(evt);
            }
        });

        lb_nhanvien.setBackground(new java.awt.Color(255, 255, 255));
        lb_nhanvien.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        lb_nhanvien.setText("Nhân viên");

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/nhanvientrangchu.png"))); // NOI18N

        javax.swing.GroupLayout pnlSoLuongnhanvienLayout = new javax.swing.GroupLayout(pnlSoLuongnhanvien);
        pnlSoLuongnhanvien.setLayout(pnlSoLuongnhanvienLayout);
        pnlSoLuongnhanvienLayout.setHorizontalGroup(
            pnlSoLuongnhanvienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSoLuongnhanvienLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_nhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlSoLuongnhanvienLayout.setVerticalGroup(
            pnlSoLuongnhanvienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSoLuongnhanvienLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSoLuongnhanvienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlSoLuongnhanvienLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lb_nhanvien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pnlSoLuongkhuyenmai.setBackground(new java.awt.Color(145, 180, 150));
        pnlSoLuongkhuyenmai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlSoLuongkhuyenmaiMouseClicked(evt);
            }
        });

        lb_khuyenmai.setBackground(new java.awt.Color(255, 255, 255));
        lb_khuyenmai.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        lb_khuyenmai.setText("Khuyến mãi");

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/khuyenmaitrangchu.png"))); // NOI18N

        javax.swing.GroupLayout pnlSoLuongkhuyenmaiLayout = new javax.swing.GroupLayout(pnlSoLuongkhuyenmai);
        pnlSoLuongkhuyenmai.setLayout(pnlSoLuongkhuyenmaiLayout);
        pnlSoLuongkhuyenmaiLayout.setHorizontalGroup(
            pnlSoLuongkhuyenmaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSoLuongkhuyenmaiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_khuyenmai, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlSoLuongkhuyenmaiLayout.setVerticalGroup(
            pnlSoLuongkhuyenmaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSoLuongkhuyenmaiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSoLuongkhuyenmaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlSoLuongkhuyenmaiLayout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(17, Short.MAX_VALUE))
                    .addGroup(pnlSoLuongkhuyenmaiLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lb_khuyenmai, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout pn_showLayout = new javax.swing.GroupLayout(pn_show);
        pn_show.setLayout(pn_showLayout);
        pn_showLayout.setHorizontalGroup(
            pn_showLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_showLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_showLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlSoLuongnhanvien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlSoLuongsach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(57, 57, 57)
                .addGroup(pn_showLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlSoLuongphieunhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlSoLuongkhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(pn_showLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlSoLuonghoadon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlSoLuongkhuyenmai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pn_showLayout.setVerticalGroup(
            pn_showLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_showLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(pn_showLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlSoLuongsach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlSoLuongphieunhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlSoLuonghoadon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(77, 77, 77)
                .addGroup(pn_showLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlSoLuongkhuyenmai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlSoLuongnhanvien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlSoLuongkhachhang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(118, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pn_allLayout = new javax.swing.GroupLayout(pn_all);
        pn_all.setLayout(pn_allLayout);
        pn_allLayout.setHorizontalGroup(
            pn_allLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(pn_show, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_allLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tittle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(280, 280, 280))
        );
        pn_allLayout.setVerticalGroup(
            pn_allLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_allLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(tittle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pn_show, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void pnlSoLuongsachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSoLuongsachMouseClicked
        SanPhamBUS sachbus = new SanPhamBUS();
        for(SanPhamDTO s: sachbus.docSanPham()){
        lb_sach.setText(sachbus.docSanPham().size()+"");}
    }//GEN-LAST:event_pnlSoLuongsachMouseClicked

    private void pnlSoLuongphieunhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSoLuongphieunhapMouseClicked
        PhieuNhapBUS buspn = new PhieuNhapBUS();
        for(PhieuNhapDTO pn: buspn.docPn()){
        lb_phieunhap.setText(buspn.docPn().size()+"");}
    }//GEN-LAST:event_pnlSoLuongphieunhapMouseClicked

    private void pnlSoLuongkhachhangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSoLuongkhachhangMouseClicked
        KhachHangBUS buskh = new KhachHangBUS();
        for(KhachHangDTO kh: buskh.docKh()){
        lb_khachhang.setText(buskh.docKh().size()+"");}
    }//GEN-LAST:event_pnlSoLuongkhachhangMouseClicked

    private void pnlSoLuonghoadonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSoLuonghoadonMouseClicked
        HoaDonBUS bushd = new HoaDonBUS();
        for(HoaDonDTO hd: bushd.docHD()){
        lb_hoadon.setText(bushd.docHD().size()+"");  }
    }//GEN-LAST:event_pnlSoLuonghoadonMouseClicked

    private void pnlSoLuongkhuyenmaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSoLuongkhuyenmaiMouseClicked
        KhuyenMaiBUS buskm = new KhuyenMaiBUS();
        for(KhuyenMaiDTO km: buskm.docKM()){
        lb_khuyenmai.setText(buskm.docKM().size()+"");}
    }//GEN-LAST:event_pnlSoLuongkhuyenmaiMouseClicked

    private void pnlSoLuongnhanvienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSoLuongnhanvienMouseClicked
        NhanVienBUS busnv = new NhanVienBUS();
        for(NhanVienDTO nv: busnv.docNv()){
        lb_nhanvien.setText(busnv.docNv().size()+"");}
    }//GEN-LAST:event_pnlSoLuongnhanvienMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lb_hoadon;
    private javax.swing.JLabel lb_khachhang;
    private javax.swing.JLabel lb_khuyenmai;
    private javax.swing.JLabel lb_nhanvien;
    private javax.swing.JLabel lb_phieunhap;
    private javax.swing.JLabel lb_sach;
    private javax.swing.JLabel lblTitleTC;
    private javax.swing.JPanel pn_all;
    private javax.swing.JPanel pn_show;
    private javax.swing.JPanel pnlSoLuonghoadon;
    private javax.swing.JPanel pnlSoLuongkhachhang;
    private javax.swing.JPanel pnlSoLuongkhuyenmai;
    private javax.swing.JPanel pnlSoLuongnhanvien;
    private javax.swing.JPanel pnlSoLuongphieunhap;
    private javax.swing.JPanel pnlSoLuongsach;
    private javax.swing.JPanel tittle;
    // End of variables declaration//GEN-END:variables
}

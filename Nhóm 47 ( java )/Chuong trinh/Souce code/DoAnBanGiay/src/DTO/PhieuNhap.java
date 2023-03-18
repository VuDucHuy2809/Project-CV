/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.time.LocalDate;


public class PhieuNhap {
    private String MaPhieuNhap,MaNhanVien,MaNhaCungCap;
    private LocalDate NgayNhap;

    public PhieuNhap(String MaPhieuNhap, String MaNhanVien, String MaNhaCungCap, LocalDate NgayNhap) {
        this.MaPhieuNhap = MaPhieuNhap;
        this.MaNhanVien = MaNhanVien;
        this.MaNhaCungCap = MaNhaCungCap;
        this.NgayNhap = NgayNhap;
    }

    public String getMaPhieuNhap() {
        return MaPhieuNhap;
    }

    public void setMaPhieuNhap(String MaPhieuNhap) {
        this.MaPhieuNhap = MaPhieuNhap;
    }

    public String getMaNhanVien() {
        return MaNhanVien;
    }

    public void setMaNhanVien(String MaNhanVien) {
        this.MaNhanVien = MaNhanVien;
    }

    public String getMaNhaCungCap() {
        return MaNhaCungCap;
    }

    public void setMaNhaCungCap(String MaNhaCungCap) {
        this.MaNhaCungCap = MaNhaCungCap;
    }

    public LocalDate getNgayNhap() {
        return NgayNhap;
    }

    public void setNgayNhap(LocalDate NgayNhap) {
        this.NgayNhap = NgayNhap;
    }

    @Override
    public String toString() {
        return "PhieuNhap{" + "MaPhieuNhap=" + MaPhieuNhap + ", MaNhanVien=" + MaNhanVien + ", MaNhaCungCap=" + MaNhaCungCap + ", NgayNhap=" + NgayNhap + '}';
    }
}

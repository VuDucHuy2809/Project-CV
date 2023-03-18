/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.time.LocalDate;


public class HoaDon {
    private String MaHoaDon,MaNhanVien;
    private LocalDate NgayXuat;

    public HoaDon(String MaHoaDon, String MaNhanVien, LocalDate NgayXuat) {
        this.MaHoaDon = MaHoaDon;
        this.MaNhanVien = MaNhanVien;
        this.NgayXuat = NgayXuat;
    }

    public String getMaHoaDon() {
        return MaHoaDon;
    }

    public void setMaHoaDon(String MaHoaDon) {
        this.MaHoaDon = MaHoaDon;
    }

    public String getMaNhanVien() {
        return MaNhanVien;
    }

    public void setMaNhanVien(String MaNhanVien) {
        this.MaNhanVien = MaNhanVien;
    }

    public LocalDate getNgayXuat() {
        return NgayXuat;
    }

    public void setNgayXuat(LocalDate NgayXuat) {
        this.NgayXuat = NgayXuat;
    }

    @Override
    public String toString() {
        return "HoaDon{" + "MaHoaDon=" + MaHoaDon + ", MaNhanVien=" + MaNhanVien + ", NgayXuat=" + NgayXuat + '}';
    }
    
    
    
}

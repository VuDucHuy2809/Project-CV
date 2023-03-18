/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.time.LocalDate;


public class NhanVien {
    private String MaNhanVien,TenNhanVien,DiaChi,SDT,UserName,Password,Quyen;
    private LocalDate NgaySinh;
    private boolean TrangThai;

    public NhanVien(String MaNhanVien, String TenNhanVien, LocalDate NgaySinh, String DiaChi, String SDT, String UserName, String Password, String Quyen,boolean tt) {
        this.MaNhanVien = MaNhanVien;
        this.TenNhanVien = TenNhanVien;
        this.DiaChi = DiaChi;
        this.SDT = SDT;
        this.UserName = UserName;
        this.Password = Password;
        this.Quyen = Quyen;
        this.NgaySinh = NgaySinh;
        this.TrangThai = tt;
    }

    public String getMaNhanVien() {
        return MaNhanVien;
    }

    public void setMaNhanVien(String MaNhanVien) {
        this.MaNhanVien = MaNhanVien;
    }

    public String getTenNhanVien() {
        return TenNhanVien;
    }

    public void setTenNhanVien(String TenNhanVien) {
        this.TenNhanVien = TenNhanVien;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getQuyen() {
        return Quyen;
    }

    public void setQuyen(String Quyen) {
        this.Quyen = Quyen;
    }

    public LocalDate getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(LocalDate NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public boolean isTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(boolean TrangThai) {
        this.TrangThai = TrangThai;
    }
    
    

    @Override
    public String toString() {
        return "NhanVien{" + "MaNhanVien=" + MaNhanVien + ", TenNhanVien=" + TenNhanVien + ", DiaChi=" + DiaChi + ", SDT=" + SDT + ", UserName=" + UserName + ", Password=" + Password + ", Quyen=" + Quyen + ", NgaySinh=" + NgaySinh + '}';
    }

    
    
}

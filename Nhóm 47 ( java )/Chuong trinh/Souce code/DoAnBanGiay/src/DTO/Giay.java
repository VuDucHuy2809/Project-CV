/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;


public class Giay {
    private String MaGiay,TenGiay,MaNSX,MaLoai,Size,MauSac;
    private int GiaThanh;
    private boolean TrangThai;
    private int SoLuong;
    
    public Giay(String MaGiay, String TenGiay, String MaNSX, String MaLoai, String Size, String MauSac, int GiaThanh,boolean tt) {
        this.MaGiay = MaGiay;
        this.TenGiay = TenGiay;
        this.MaNSX = MaNSX;
        this.MaLoai = MaLoai;
        this.Size = Size;
        this.MauSac = MauSac;
        this.GiaThanh = GiaThanh;
        this.TrangThai = tt;
    }

    public Giay(String MaGiay, String TenGiay, String MaNSX, String MaLoai, String Size, String MauSac, int GiaThanh,boolean tt,int sl) {
        this.MaGiay = MaGiay;
        this.TenGiay = TenGiay;
        this.MaNSX = MaNSX;
        this.MaLoai = MaLoai;
        this.Size = Size;
        this.MauSac = MauSac;
        this.GiaThanh = GiaThanh;
        this.TrangThai = tt;
        this.SoLuong = sl;
    }

    public String getMaGiay() {
        return MaGiay;
    }

    public void setMaGiay(String MaGiay) {
        this.MaGiay = MaGiay;
    }

    public String getTenGiay() {
        return TenGiay;
    }

    public void setTenGiay(String TenGiay) {
        this.TenGiay = TenGiay;
    }

    public String getMaNSX() {
        return MaNSX;
    }

    public void setMaNSX(String MaNSX) {
        this.MaNSX = MaNSX;
    }

    public String getMaLoai() {
        return MaLoai;
    }

    public void setMaLoai(String MaLoai) {
        this.MaLoai = MaLoai;
    }

    public String getSize() {
        return Size;
    }

    public void setSize(String Size) {
        this.Size = Size;
    }

    public String getMauSac() {
        return MauSac;
    }

    public void setMauSac(String MauSac) {
        this.MauSac = MauSac;
    }

    public int getGiaThanh() {
        return GiaThanh;
    }

    public void setGiaThanh(int GiaThanh) {
        this.GiaThanh = GiaThanh;
    }

    public boolean isTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(boolean TrangThai) {
        this.TrangThai = TrangThai;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }
    
    

    @Override
    public String toString() {
        return "Giay{" + "MaGiay=" + MaGiay + ", TenGiay=" + TenGiay + ", MaNSX=" + MaNSX + ", MaLoai=" + MaLoai + ", Size=" + Size + ", MauSac=" + MauSac + ", GiaThanh=" + GiaThanh + '}';
    }
}

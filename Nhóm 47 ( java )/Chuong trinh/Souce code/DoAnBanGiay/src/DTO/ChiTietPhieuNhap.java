/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;


public class ChiTietPhieuNhap {
    private String MaPhieuNhap,MaGiay;
    private int SoLuong;

    public ChiTietPhieuNhap(String MaPhieuNhap, String MaGiay, int SoLuong) {
        this.MaPhieuNhap = MaPhieuNhap;
        this.MaGiay = MaGiay;
        this.SoLuong = SoLuong;
    }

    public String getMaPhieuNhap() {
        return MaPhieuNhap;
    }

    public void setMaPhieuNhap(String MaPhieuNhap) {
        this.MaPhieuNhap = MaPhieuNhap;
    }

    public String getMaGiay() {
        return MaGiay;
    }

    public void setMaGiay(String MaGiay) {
        this.MaGiay = MaGiay;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    @Override
    public String toString() {
        return "ChiTietPhieuNhap{" + "MaPhieuNhap=" + MaPhieuNhap + ", MaGiay=" + MaGiay + ", SoLuong=" + SoLuong + '}';
    }

   
}

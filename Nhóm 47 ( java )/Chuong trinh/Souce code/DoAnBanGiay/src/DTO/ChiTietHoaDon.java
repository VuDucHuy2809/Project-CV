/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;


public class ChiTietHoaDon {
    private String MaHoaDon,MaGiay;
    private int SoLuong;

    public ChiTietHoaDon(String MaHoaDon, String MaGiay, int SoLuong) {
        this.MaHoaDon = MaHoaDon;
        this.MaGiay = MaGiay;
        this.SoLuong = SoLuong;
    }

    public String getMaHoaDon() {
        return MaHoaDon;
    }

    public void setMaHoaDon(String MaHoaDon) {
        this.MaHoaDon = MaHoaDon;
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
        return "ChiTietHoaDon{" + "MaHoaDon=" + MaHoaDon + ", MaGiay=" + MaGiay + ", SoLuong=" + SoLuong + '}';
    }

   
    
    
    
    
}

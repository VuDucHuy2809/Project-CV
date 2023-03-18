
package DTO;

import java.util.Date;

public class PhieuNhapDTO {
    private String maPN, maNV, maNSX;
    private String ngayNhap;
    private double thanhTien;
    public PhieuNhapDTO() {
        
    }

    public PhieuNhapDTO(String maPN, String maNV, String maNXB, String ngayNhap, double thanhTien) {
        this.maPN = maPN;
        this.maNV = maNV;
        this.maNSX = maNSX;
        this.ngayNhap = ngayNhap;
        this.thanhTien = thanhTien;
    }

    public String getMaPN() {
        return maPN;
    }

    public void setMaPN(String maPN) {
        this.maPN = maPN;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getMaNSX() {
        return maNSX;
    }

    public void setMaNSX(String maNSX) {
        this.maNSX = maNSX;
    } 
    
    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }
}

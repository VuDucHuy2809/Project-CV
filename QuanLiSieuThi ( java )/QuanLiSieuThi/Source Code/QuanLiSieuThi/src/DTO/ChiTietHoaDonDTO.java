
package DTO;

public class ChiTietHoaDonDTO {
    private String maHD, maSP;
    private double donGia, thanhTien, tienGiamGia_CT;
    private int soLuong;
     public ChiTietHoaDonDTO(){}

    public ChiTietHoaDonDTO(String maHD, String maSP, double donGia, double thanhTien, double tienGiamGia_CT, int soLuong) {
        this.maHD = maHD;
        this.maSP = maSP;
        this.donGia = donGia;
        this.thanhTien = thanhTien;
        this.tienGiamGia_CT = tienGiamGia_CT;
        this.soLuong = soLuong;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }

    public double getTienGiamGia_CT() {
        return tienGiamGia_CT;
    }

    public void setTienGiamGia_CT(double tienGiamGia_CT) {
        this.tienGiamGia_CT = tienGiamGia_CT;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

}

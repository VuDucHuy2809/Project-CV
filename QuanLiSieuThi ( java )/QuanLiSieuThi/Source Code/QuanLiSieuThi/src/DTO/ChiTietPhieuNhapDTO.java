
package DTO;


public class ChiTietPhieuNhapDTO {
    private String maPN, maSP;
    private double donGia, thanhTien_CT;
    private int soLuong;
    public ChiTietPhieuNhapDTO () {}

    public ChiTietPhieuNhapDTO(String maPN, String maSP, double donGia, double thanhTien_CT, int soLuong) {
        this.maPN = maPN;
        this.maSP = maSP;
        this.donGia = donGia;
        this.thanhTien_CT = thanhTien_CT;
        this.soLuong = soLuong;
    }

    public String getMaPN() {
        return maPN;
    }

    public void setMaPN(String maPN) {
        this.maPN = maPN;
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

    public double getThanhTien_CT() {
        return thanhTien_CT;
    }

    public void setThanhTien_CT(double thanhTien_CT) {
        this.thanhTien_CT = thanhTien_CT;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

}

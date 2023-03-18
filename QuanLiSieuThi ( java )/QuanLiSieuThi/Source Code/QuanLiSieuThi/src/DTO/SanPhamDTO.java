
package DTO;

public class SanPhamDTO {
    private String maSP, maNSX, maNCC, maLoai, tenSP, HSD;
    private int soLuong;
    private double donGia;
    public SanPhamDTO() {}

    public SanPhamDTO(String maSP, String maNSX, String maNCC, String maLoai, String tenSP, String HSD, double donGia, int soLuong) {
        this.maSP = maSP;
        this.maNSX = maNSX;
        this.maNCC = maNCC;
        this.maLoai = maLoai;
        this.tenSP = tenSP;
        this.HSD = HSD;
        this.donGia = donGia;
        this.soLuong = soLuong;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getMaNSX() {
        return maNSX;
    }

    public void setMaNSX(String maNSX) {
        this.maNSX = maNSX;
    }

    public String getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(String maNCC) {
        this.maNCC = maNCC;
    }

    public String getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(String maLoai) {
        this.maLoai = maLoai;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getHSD() {
        return HSD;
    }

    public void setHSD(String HSD) {
        this.HSD = HSD;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

}

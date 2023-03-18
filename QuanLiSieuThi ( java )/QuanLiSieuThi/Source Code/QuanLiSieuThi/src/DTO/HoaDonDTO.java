
package DTO;

import java.util.Date;

public class HoaDonDTO {
    private String maHD, maNV, maKH, maKM;
    private String ngayXuat;
    private double thanhTien, tienGiamGia, Tongtien;
    public HoaDonDTO() {
        
    }

    public HoaDonDTO(String maHD, String maNV, String maKH, String maKM, String ngayXuat, double thanhTien, double tienGiamGia, double tongtien) {
        this.maHD = maHD;
        this.maNV = maNV;
        this.maKH = maKH;
        this.maKM = maKM;
        this.ngayXuat = ngayXuat;
        this.thanhTien = thanhTien;
        this.tienGiamGia = tienGiamGia;
        this.Tongtien = tongtien;
    }

    public double getTongtien() {
        return Tongtien;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setTongtien(double Tongtien) {
        this.Tongtien = Tongtien;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getMaKM() {
        return maKM;
    }

    public void setMaKM(String maKM) {
        this.maKM = maKM;
    }

    public String getNgayXuat() {
        return ngayXuat;
    }

    public void setNgayXuat(String ngayXuat) {
        this.ngayXuat = ngayXuat;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }

    public double getTienGiamGia() {
        return tienGiamGia;
    }

    public void setTienGiamGia(double tienGiamGia) {
        this.tienGiamGia = tienGiamGia;
    }

}


package DTO;

public class NhanVienDTO {
    private String maNV, hoNV, tenNV, diaChiNV, chucVuNV;
    private double luong;
    public NhanVienDTO() {}
    public NhanVienDTO(String maNV, String hoNV, String tenNV, String ngaySinhNV, String diaChiNV, String chucVuNV,Double luong) {
        this.maNV = maNV;
        this.hoNV = hoNV;
        this.tenNV = tenNV;
        this.diaChiNV = diaChiNV;
        this.chucVuNV = chucVuNV;
        this.luong=luong;
    }

    public double getLuong() {
        return luong;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getHoNV() {
        return hoNV;
    }

    public void setHoNV(String hoNV) {
        this.hoNV = hoNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getDiaChiNV() {
        return diaChiNV;
    }

    public void setDiaChiNV(String diaChiNV) {
        this.diaChiNV = diaChiNV;
    }

    public String getChucVuNV() {
        return chucVuNV;
    }

    public void setChucVuNV(String chucVuNV) {
        this.chucVuNV = chucVuNV;
    }
    
}


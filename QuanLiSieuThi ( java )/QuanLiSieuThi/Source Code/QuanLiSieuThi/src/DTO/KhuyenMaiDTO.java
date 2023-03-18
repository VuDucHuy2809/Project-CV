
package DTO;



public class KhuyenMaiDTO {
    private String maKM, tenChuongTrinh, loaiChuongTrinh, dieuKienKM;
    private double phanTramGiamGia;
    private String ngayBDKM, ngayKTKM;
    public KhuyenMaiDTO (){
        
    }

    public KhuyenMaiDTO(String maKM, String tenChuongTrinh, String loaiChuongTrinh, String dieuKienKM, double phanTramGiamGia, String ngayBDKM, String ngayKTKM) {
        this.maKM = maKM;
        this.tenChuongTrinh = tenChuongTrinh;
        this.loaiChuongTrinh = loaiChuongTrinh;
        this.dieuKienKM = dieuKienKM;
        this.phanTramGiamGia = phanTramGiamGia;
        this.ngayBDKM = ngayBDKM;
        this.ngayKTKM = ngayKTKM;
    }

    public String getMaKM() {
        return maKM;
    }

    public void setMaKM(String maKM) {
        this.maKM = maKM;
    }

    public String getTenChuongTrinh() {
        return tenChuongTrinh;
    }

    public void setTenChuongTrinh(String tenChuongTrinh) {
        this.tenChuongTrinh = tenChuongTrinh;
    }

    public String getLoaiChuongTrinh() {
        return loaiChuongTrinh;
    }

    public void setLoaiChuongTrinh(String loaiChuongTrinh) {
        this.loaiChuongTrinh = loaiChuongTrinh;
    }

    public String getDieuKienKM() {
        return dieuKienKM;
    }

    public void setDieuKienKM(String dieuKienKM) {
        this.dieuKienKM = dieuKienKM;
    }

    public double getPhanTramGiamGia() {
        return phanTramGiamGia;
    }

    public void setPhanTramGiamGia(double phanTramGiamGia) {
        this.phanTramGiamGia = phanTramGiamGia;
    }

    public String getNgayBDKM() {
        return ngayBDKM;
    }

    public void setNgayBDKM(String ngayBDKM) {
        this.ngayBDKM = ngayBDKM;
    }

    public String getNgayKTKM() {
        return ngayKTKM;
    }

    public void setNgayKTKM(String ngayKTKM) {
        this.ngayKTKM = ngayKTKM;
    }

}

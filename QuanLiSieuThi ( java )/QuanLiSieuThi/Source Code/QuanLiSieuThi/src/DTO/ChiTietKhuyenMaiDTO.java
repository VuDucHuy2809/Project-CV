
package DTO;

public class ChiTietKhuyenMaiDTO {
    private String maKM, maSP;
    private double phanTramGiamGia_CT;
    public ChiTietKhuyenMaiDTO(){
        
    }

    public ChiTietKhuyenMaiDTO(String maKM, String maSP, double phanTramGiamGia_CT) {
        this.maKM = maKM;
        this.maSP = maSP;
        this.phanTramGiamGia_CT = phanTramGiamGia_CT;
    }

    public String getMaKM() {
        return maKM;
    }

    public void setMaKM(String maKM) {
        this.maKM = maKM;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public double getPhanTramGiamGia_CT() {
        return phanTramGiamGia_CT;
    }

    public void setPhanTramGiamGia_CT(double phanTramGiamGia_CT) {
        this.phanTramGiamGia_CT = phanTramGiamGia_CT;
    }

}

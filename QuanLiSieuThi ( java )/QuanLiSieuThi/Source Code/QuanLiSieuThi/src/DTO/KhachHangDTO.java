
package DTO;

public class KhachHangDTO {
    private String maKH, hoKH, tenKH, sDTKH, diaChiKH;
    public KhachHangDTO() {
    
}
    public KhachHangDTO(String maKH, String hoKH, String tenKH, String sDTKH, String diaChiKH) {
        this.maKH = maKH;
        this.hoKH = hoKH;        
        this.tenKH = tenKH;
        this.sDTKH = sDTKH;
        this.diaChiKH = diaChiKH;
        
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getsDTKH() {
        return sDTKH;
    }

    public void setsDTKH(String sDTKH) {
        this.sDTKH = sDTKH;
    }

    public String getDiaChiKH() {
        return diaChiKH;
    }

    public void setDiaChiKH(String diaChiKH) {
        this.diaChiKH = diaChiKH;
    }

    public String getHoKH() {
        return hoKH;
    }

    public void setHoKH(String hoKH) {
        this.hoKH = hoKH;
    }
    
}

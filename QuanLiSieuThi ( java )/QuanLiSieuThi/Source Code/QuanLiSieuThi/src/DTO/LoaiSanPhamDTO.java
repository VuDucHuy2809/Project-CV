
package DTO;

public class LoaiSanPhamDTO {
    private String maLoai, tenLoai;
    public LoaiSanPhamDTO (){
        
    }
    public LoaiSanPhamDTO(String maLoai, String tenLoai) {
        this.maLoai= maLoai;
        this.tenLoai = tenLoai;
        
    }

    public String getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(String maLoai) {
        this.maLoai = maLoai;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }
    
    
}
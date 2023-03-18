
package DTO;

public class NhaSanXuatDTO {
    private String maNSX, tenNSX, sdtNSX, dcNSX;
    public NhaSanXuatDTO() {
    
}
    public NhaSanXuatDTO(String maNSX, String tenNSX, String sdtNSX, String dcNSX) {
        this.maNSX = maNSX;        
        this.tenNSX = tenNSX;
        this.sdtNSX = sdtNSX;
        this.dcNSX = dcNSX;
        
    }

    public String getMaNSX() {
        return maNSX;
    }

    public void setMaNSX(String maNSX) {
        this.maNSX = maNSX;
    }

    public String getTenNSX() {
        return tenNSX;
    }

    public void setTenNSX(String tenNSX) {
        this.tenNSX = tenNSX;
    }

    public String getSdtNSX() {
        return sdtNSX;
    }

    public void setSdtNSX(String sdtNSX) {
        this.sdtNSX = sdtNSX;
    }

    public String getDcNSX() {
        return dcNSX;
    }

    public void setDcNSX(String dcNSX) {
        this.dcNSX = dcNSX;
    }


   
}

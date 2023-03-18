
package DTO;

public class NhaCungCapDTO {
    private String maNCC, tenNCC, sdtNCC, dcNCC;
    public NhaCungCapDTO() {
        
    }
    public NhaCungCapDTO(String maNCC, String tenNCC, String sdtNCC, String dcNCC) {
        this.maNCC = maNCC;
        this.tenNCC = tenNCC;
        this.sdtNCC = sdtNCC;
        this.dcNCC = dcNCC;
    }

    public String getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(String maNCC) {
        this.maNCC = maNCC;
    }

    public String getTenNCC() {
        return tenNCC;
    }

    public void setTenNCC(String tenNCC) {
        this.tenNCC = tenNCC;
    }

    public String getSdtNCC() {
        return sdtNCC;
    }

    public void setSdtNCC(String sdtNCC) {
        this.sdtNCC = sdtNCC;
    }

    public String getDcNCC() {
        return dcNCC;
    }

    public void setDcNCC(String dcNCC) {
        this.dcNCC = dcNCC;
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;


public class NhaSanXuat {
    private String MaNSX,TenNSX,QuocGia;

    public NhaSanXuat(String MaNSX, String TenNSX, String QuocGia) {
        this.MaNSX = MaNSX;
        this.TenNSX = TenNSX;
        this.QuocGia = QuocGia;
    }

    public String getMaNSX() {
        return MaNSX;
    }

    public void setMaNSX(String MaNSX) {
        this.MaNSX = MaNSX;
    }

    public String getTenNSX() {
        return TenNSX;
    }

    public void setTenNSX(String TenNSX) {
        this.TenNSX = TenNSX;
    }

    public String getQuocGia() {
        return QuocGia;
    }

    public void setQuocGia(String QuocGia) {
        this.QuocGia = QuocGia;
    }

    @Override
    public String toString() {
        return "NhaSanXuat{" + "MaNSX=" + MaNSX + ", TenNSX=" + TenNSX + ", QuocGia=" + QuocGia + '}';
    }    
}

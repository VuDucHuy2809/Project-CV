/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.ChiTietPhieuNhapDAO;
import DTO.ChiTietHoaDon;
import DTO.ChiTietPhieuNhap;
import java.util.ArrayList;


public class ChiTietPhieuNhapBUS {
    ChiTietPhieuNhapDAO ctpndao = new ChiTietPhieuNhapDAO();
    
    public ArrayList<ChiTietPhieuNhap> getAllData(){
        return ctpndao.getAllData();
    }

    public ArrayList<ChiTietPhieuNhap> getPNById(String id) {
        ArrayList<ChiTietPhieuNhap> data = getAllData();
        ArrayList<ChiTietPhieuNhap> result = new ArrayList<>();
        for(ChiTietPhieuNhap ct : data){
            if(ct.getMaPhieuNhap().compareTo(id) == 0){
                result.add(ct);
            }
        }
        return result;
    }
    
    
}

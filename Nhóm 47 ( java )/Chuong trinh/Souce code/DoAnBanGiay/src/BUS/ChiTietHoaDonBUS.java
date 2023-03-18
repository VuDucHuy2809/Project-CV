/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.ChiTietHoaDonDAO;
import DTO.ChiTietHoaDon;
import java.util.ArrayList;


public class ChiTietHoaDonBUS {
    ChiTietHoaDonDAO cthdddao = new ChiTietHoaDonDAO();
    GiayBUS giaybus = new GiayBUS();
    
    public ArrayList<ChiTietHoaDon> getAllData(){
        return cthdddao.getAllData();
    }

    public ArrayList<ChiTietHoaDon> addDetailIntoArray(ArrayList<ChiTietHoaDon> dataCTHD, String idGiay, int num) {
        for(ChiTietHoaDon ct : dataCTHD){
            if(ct.getMaGiay().compareTo(idGiay) == 0){
                ct.setSoLuong(ct.getSoLuong() + num);
                return dataCTHD;
            }
        }
        dataCTHD.add(new ChiTietHoaDon("0", idGiay, num));
        return dataCTHD;
    }

    public ArrayList<ChiTietHoaDon> deleteDetailById(ArrayList<ChiTietHoaDon> dataCTHD, String Id) {
        for(int i = 0;i < dataCTHD.size();i++){
            if(dataCTHD.get(i).getMaGiay().compareTo(Id) == 0){
                dataCTHD.remove(i);
                return dataCTHD;
            }
        }
        return dataCTHD;
    }

    public boolean addDetailIntoDB(ArrayList<ChiTietHoaDon> dataCTHD) {
         boolean OK = true;
         for(ChiTietHoaDon ct : dataCTHD){
             if(cthdddao.addDetail(ct) == false){
                 return false;
             }
             if(cthdddao.decreaseNumber(ct.getMaGiay(),giaybus.getNumberById(ct.getMaGiay()) - ct.getSoLuong()) == false){
                 return false;
             }
         }
         return true;
    }

    public ArrayList<ChiTietHoaDon> getDetailById(String id) {
        ArrayList<ChiTietHoaDon> data = getAllData();
        ArrayList<ChiTietHoaDon> result = new ArrayList<>();
        
        for(ChiTietHoaDon ct : data){
            if(ct.getMaHoaDon().compareTo(id) == 0){
                result.add(ct);
            }
        }
        return result;
    }

    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.PhieuNhapDAO;
import DTO.ChiTietPhieuNhap;
import DTO.PhieuNhap;
import java.util.ArrayList;


public class PhieuNhapBUS {
    PhieuNhapDAO pndao = new PhieuNhapDAO();
    ChiTietPhieuNhapBUS ctpnbus = new ChiTietPhieuNhapBUS();
    GiayBUS giaybus = new GiayBUS();
    public ArrayList<PhieuNhap> getAllData(){
        return pndao.getAllData();
    }
    
    public String createAutoId(){
        ArrayList<PhieuNhap> data = getAllData();
        if(data == null || data.isEmpty()){
            return "PN00001";
        }
        
        String oldId = data.get(data.size()-1).getMaPhieuNhap();
        String newNum = String.valueOf(Integer.valueOf(oldId.substring(2)) +1);
        while(newNum.length() < 5){
            newNum = '0' + newNum;
        }
        newNum = "PN" + newNum;
        return newNum;
    }
    

    public boolean addPieuNhap(PhieuNhap pn) {
        return pndao.addPhieuNhapDao(pn);
    }

    public PhieuNhap getPNById(String id) {
        ArrayList<PhieuNhap> data = getAllData();
        for(PhieuNhap pn : data){
            if(pn.getMaPhieuNhap().compareTo(id) == 0){
                return pn;
            }
        }
        return null;
    }
    
    //Thong ke theo thang
    public ArrayList<String []> getDataChar(){
        ArrayList<PhieuNhap> data = getAllData();
        ArrayList<String []> result = new ArrayList<>();
        
        int []arr = new int[12];
        for(PhieuNhap pn : data){
            int month = Integer.valueOf(pn.getNgayNhap().toString().substring(5,7));
            
            arr[month-1] += getSumMoney(pn.getMaPhieuNhap());
        }
        for(int i = 0;i < arr.length;i++){
            String str[] = new String[3];
            str[2] = String.valueOf(i+1);
            str[1] = "Phiếu Nhập";
            str[0] = String.valueOf(arr[i]);
            result.add(str);
        }
        return result;        
    }
    
    public int getSumMoney(String id){
        ArrayList<ChiTietPhieuNhap> dataCT = ctpnbus.getPNById(id);
        int sum = 0;
        for(ChiTietPhieuNhap ct : dataCT){
            sum += ct.getSoLuong()*giaybus.getPriceById(ct.getMaGiay());
        }
        return sum;
    }
}

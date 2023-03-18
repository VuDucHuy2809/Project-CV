/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.HoaDonDAO;
import DTO.ChiTietHoaDon;
import DTO.HoaDon;
import java.util.ArrayList;


public class HoaDonBUS {
    HoaDonDAO hddao = new HoaDonDAO();
    ChiTietHoaDonBUS cthdbus = new ChiTietHoaDonBUS();
    GiayBUS giaybus = new GiayBUS();
    public ArrayList<HoaDon> getAllData(){
        return hddao.getAllData();
    }
    
    public String createAutoBild(){
        ArrayList<HoaDon> data = getAllData();
        if(data == null || data.isEmpty()){
            return "HD00001";
        }
        String oldHd = data.get(data.size()-1).getMaHoaDon();
        String newNumber = String.valueOf(Integer.valueOf(oldHd.substring(2)) + 1);
        while(newNumber.length() < 5){
            newNumber = '0' + newNumber;
        }
        newNumber = "HD" + newNumber;
        return newNumber;
    }

    public boolean addBill(HoaDon hd) {
        return hddao.addBillDao(hd);
    }

    public HoaDon getBillById(String id) {
        ArrayList<HoaDon> data = getAllData();
        for(HoaDon hd : data){
            if(hd.getMaHoaDon().compareTo(id) == 0){
                return hd;
            }
        }
        return null;
    }
    
    //Thong ke theo thang
    public ArrayList<String []> getDataChar(){
        ArrayList<HoaDon> data = getAllData();
        ArrayList<String []> result = new ArrayList<>();
        
        int []arr = new int[12];
        for(HoaDon hd : data){
            int month = Integer.valueOf(hd.getNgayXuat().toString().substring(5,7));
            
            arr[month-1] += getSumMoney(hd.getMaHoaDon());
        }
        for(int i = 0;i < arr.length;i++){
            String str[] = new String[3];
            str[2] = String.valueOf(i+1);
            str[1] = "Hóa Đơn";
            str[0] = String.valueOf(arr[i]/1000000.0);
            result.add(str);
        }
        return result;        
    }
    
    public int getSumMoney(String id){
        ArrayList<ChiTietHoaDon> dataCT = cthdbus.getDetailById(id);
        int sum = 0;
        for(ChiTietHoaDon ct : dataCT){
            sum += ct.getSoLuong()*giaybus.getPriceById(ct.getMaGiay());
        }
        return sum;
    }
}

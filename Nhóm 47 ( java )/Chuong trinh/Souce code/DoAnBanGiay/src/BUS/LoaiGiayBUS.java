/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.LoaiGiayDAO;
import DTO.LoaiGiay;
import java.util.ArrayList;


public class LoaiGiayBUS {
    LoaiGiayDAO loaigiaydao = new LoaiGiayDAO();
    
    public ArrayList<LoaiGiay> getAllData(){
        return loaigiaydao.getAllData();
    }

    public String getNameById(String maLoai) {
        ArrayList<LoaiGiay> data = getAllData();
        for(LoaiGiay loai : data){
            if(loai.getMaLoai().compareTo(maLoai) == 0){
                return loai.getTenLoai();
            }
        }
        return "";
    }
}

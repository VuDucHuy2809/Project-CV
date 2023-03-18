/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.NhaCungCapDAO;
import DTO.NhaCungCap;
import java.util.ArrayList;


public class NhaCungCapBUS {
    NhaCungCapDAO nccdao =  new NhaCungCapDAO();
    
    public ArrayList<NhaCungCap> getAllData(){
        return nccdao.getAllData();
    }

    public String getNameById(String maNhaCungCap) {
        ArrayList<NhaCungCap> data = getAllData();
        for(NhaCungCap ncc : data){
            if(ncc.getMaNhaCungCap().compareTo(maNhaCungCap) == 0){
                return ncc.getTenNhaCungCap();
            }
        }
        return "";
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.NhaSanXuatDAO;
import DTO.NhaSanXuat;
import java.util.ArrayList;


public class NhaSanXuatBUS {
    NhaSanXuatDAO nsxdao = new NhaSanXuatDAO();
    public ArrayList<NhaSanXuat> getAllData(){
        return nsxdao.getAllData();
    }

    public String getNameById(String maNSX) {
        ArrayList<NhaSanXuat> data = getAllData();
        for(NhaSanXuat nsx : data){
            if(nsx.getMaNSX().compareTo(maNSX) == 0){
                return nsx.getTenNSX();
            }
        }
        return "";
    }
}

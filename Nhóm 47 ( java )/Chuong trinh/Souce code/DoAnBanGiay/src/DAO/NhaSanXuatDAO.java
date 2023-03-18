/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ConnectionDB;
import DTO.NhaSanXuat;
import java.sql.ResultSet;
import java.util.ArrayList;


public class NhaSanXuatDAO {
    ConnectionDB conn = new ConnectionDB();
    
    public ArrayList<NhaSanXuat> getAllData(){
        String qry = "select * from nhasanxuat";
        ResultSet rs = conn.sqlExcute(qry);
        ArrayList<NhaSanXuat> data = new ArrayList<>();
        try {
            while(rs.next()){
                data.add(new NhaSanXuat(rs.getString(1), rs.getString(2), rs.getString(3)));
            }
        } catch (Exception e) {}
        return data;
    }
}

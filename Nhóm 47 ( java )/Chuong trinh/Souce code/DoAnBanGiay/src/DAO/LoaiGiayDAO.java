/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ConnectionDB;
import DTO.LoaiGiay;
import java.sql.ResultSet;
import java.util.ArrayList;


public class LoaiGiayDAO {
    ConnectionDB conn = new ConnectionDB();
    
    public ArrayList<LoaiGiay> getAllData(){
        String qry = "select * from loaigiay";
        ResultSet rs = conn.sqlExcute(qry);
        ArrayList<LoaiGiay> data = new ArrayList<>();
        try {
            while(rs.next()){
                data.add(new LoaiGiay(rs.getString(1), rs.getString(2), rs.getString(3)));
            }
        } catch (Exception e) {}
        return data;
    }
}

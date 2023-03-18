/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ConnectionDB;
import DTO.NhaCungCap;
import java.sql.ResultSet;
import java.util.ArrayList;


public class NhaCungCapDAO {
    ConnectionDB conn = new ConnectionDB();
    
    public ArrayList<NhaCungCap> getAllData(){
        String qry = "select * from nhacungcap";
        ResultSet rs = conn.sqlExcute(qry);
        ArrayList<NhaCungCap> data = new ArrayList<>();
        try {
            while(rs.next()){
                data.add(new NhaCungCap(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)));
            }
        } catch (Exception e) {}
        return data;
    }
}

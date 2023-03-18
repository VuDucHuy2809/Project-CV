/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ConnectionDB;
import DTO.ChiTietHoaDon;
import java.sql.ResultSet;
import java.util.ArrayList;


public class ChiTietHoaDonDAO {
    ConnectionDB conn = new ConnectionDB();
    
    public ArrayList<ChiTietHoaDon> getAllData(){
        String qry = "select * from cthoadon";
        ResultSet rs = conn.sqlExcute(qry);
        ArrayList<ChiTietHoaDon> data = new ArrayList<>();
        try {
            while(rs.next()){
                data.add(new ChiTietHoaDon(rs.getString(1),rs.getString(2),rs.getInt(3)));
            }
        } catch (Exception e) {}
        return data;
    }

    public boolean addDetail(ChiTietHoaDon ct) {
        String qry = "INSERT INTO `cthoadon`(`MaHoaDon`, `MaGiay`, `SoLuong`) "
                + "VALUES ('"+ct.getMaHoaDon()+"','"+ct.getMaGiay()+"','"+ct.getSoLuong()+"');";
        return conn.sqlUpdate(qry);
    }

    public boolean decreaseNumber(String maGiay, int soLuong) {
        String qry = "UPDATE `giay` SET `SoLuong`="+soLuong+" WHERE `MaGiay` = '"+maGiay+"';";
        return conn.sqlUpdate(qry);
    }
}

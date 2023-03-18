/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ConnectionDB;
import DTO.Giay;
import java.sql.ResultSet;
import java.util.ArrayList;


public class GiayDAO {
    ConnectionDB conn = new ConnectionDB();
    
    public ArrayList<Giay> getAllData(){
        String qry = "select * from giay";
        ResultSet rs = conn.sqlExcute(qry);
        ArrayList<Giay> data = new ArrayList<>();
        try {
            while(rs.next()){
                data.add(new Giay(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getBoolean(8),rs.getInt(9)));
            }
        } catch (Exception e) {}
        return data;
    }

    public boolean updateDao(Giay g) {
        String qry = "UPDATE `giay` SET "
                + "`TenGiay`='"+g.getTenGiay()+"',"
                + "`MaNSX`='"+g.getMaNSX()+"',"
                + "`MaLoai`='"+g.getMaLoai()+"',"
                + "`Size`='" +g.getSize()+"',"
                + "`MauSac`='"+g.getMauSac()+"',"
                 + "`TrangThai`="+g.isTrangThai()+","
                + "`GiaThanh`="+g.getGiaThanh()
                +" WHERE `MaGiay` = '"+g.getMaGiay()+"';";
        return conn.sqlUpdate(qry);
    }

    public boolean updateNumber(String maGiay, int i) {
        String qry = "UPDATE `giay` SET `SoLuong`="+i+" WHERE `MaGiay` = '"+maGiay+"';";
        return conn.sqlUpdate(qry);
    }

    public boolean addGiay(Giay giay) {
        System.out.println(giay);
        String qry = "INSERT INTO `giay`(`MaGiay`, `TenGiay`, `MaNSX`, `MaLoai`, `Size`, `MauSac`, `GiaThanh`, `TrangThai`, `SoLuong`) "
                + "VALUES ('"
                +giay.getMaGiay()+"','"
                +giay.getTenGiay()+"','"
                +giay.getMaNSX()+"','"
                +giay.getMaLoai()+"','"
                +giay.getSize()+"','"
                +giay.getMauSac()+"',"
                +giay.getGiaThanh()
                +",true,"
                +giay.getSoLuong()
                +");";
        return conn.sqlUpdate(qry);
    }
}

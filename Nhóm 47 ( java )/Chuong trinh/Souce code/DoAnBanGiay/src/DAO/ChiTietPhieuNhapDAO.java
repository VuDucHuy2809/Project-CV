/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ChiTietPhieuNhap;
import DTO.ConnectionDB;
import java.sql.ResultSet;
import java.util.ArrayList;


public class ChiTietPhieuNhapDAO {
    ConnectionDB conn = new ConnectionDB();
    
    public ArrayList<ChiTietPhieuNhap> getAllData(){
        String qry = "select * from ctphieunhap";
        ResultSet rs = conn.sqlExcute(qry);
        ArrayList<ChiTietPhieuNhap> data = new ArrayList<>();
        try {
            while(rs.next()){
                data.add(new ChiTietPhieuNhap(rs.getString(1),rs.getString(2),rs.getInt(3)));
            }
        } catch (Exception e) {}
        return data;
    }

    public boolean addDetail(ChiTietPhieuNhap chiTietPhieuNhap) {
        String qry = "INSERT INTO `ctphieunhap`(`MaPhieuNhap`, `MaGiay`, `SoLuong`) "
                + "VALUES ('"
                +chiTietPhieuNhap.getMaPhieuNhap()+"','"
                +chiTietPhieuNhap.getMaGiay()+"',"
                +chiTietPhieuNhap.getSoLuong()
                +");";
        return conn.sqlUpdate(qry);
    }
}

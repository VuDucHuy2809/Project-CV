/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ConnectionDB;
import DTO.HoaDon;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;


public class HoaDonDAO {
    ConnectionDB conn = new ConnectionDB();
    
    public ArrayList<HoaDon> getAllData(){
        String qry = "select * from hoadon";
        ResultSet rs = conn.sqlExcute(qry);
        ArrayList<HoaDon> data = new ArrayList<>();
        try {
            while(rs.next()){
                data.add(new HoaDon(rs.getString(1), rs.getString(2), rs.getDate(3).toLocalDate()));
            }
        } catch (Exception e) {}
        return data;
    }

    public boolean addBillDao(HoaDon hd) {
        String qry  = "INSERT INTO `hoadon`(`MaHoaDon`, `MaNhanVien`, `NgayXuat`) "
                + "VALUES ('"
                +hd.getMaHoaDon()+"','"
                +hd.getMaNhanVien()+"','"
                +hd.getNgayXuat().toString()+"');";
        return conn.sqlUpdate(qry);
    }
}

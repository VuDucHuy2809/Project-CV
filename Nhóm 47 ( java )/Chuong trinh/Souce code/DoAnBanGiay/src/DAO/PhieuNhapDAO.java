/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ConnectionDB;
import DTO.PhieuNhap;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;


public class PhieuNhapDAO {
    ConnectionDB conn = new ConnectionDB();
    
    public ArrayList<PhieuNhap> getAllData(){
        String qry = "select * from phieunhap";
        ResultSet rs = conn.sqlExcute(qry);
        
        ArrayList<PhieuNhap> data = new ArrayList<>();
        try {
            while(rs.next()){
                data.add(new PhieuNhap(
                        rs.getString(1), 
                        rs.getString(2), 
                        rs.getString(3),
                        rs.getDate(4).toLocalDate()
                ));
            }
        } catch (Exception e) {e.printStackTrace();}
        return data;
    }

    public boolean addPhieuNhapDao(PhieuNhap pn) {
        String qry = "INSERT INTO `phieunhap`(`MaPhieuNhap`, `MaNhanVien`, `MaNhaCungCap`, `NgayNhap`) "
                + "VALUES ('"+pn.getMaPhieuNhap()+"','"+pn.getMaNhanVien()+"','"+pn.getMaNhaCungCap()+"','"+pn.getNgayNhap()+"');";
        return conn.sqlUpdate(qry);
    }
}

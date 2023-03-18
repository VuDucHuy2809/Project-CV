/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ConnectionDB;
import DTO.NhanVien;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;


public class NhanVienDAO {
    ConnectionDB conn = new ConnectionDB();
    
    public ArrayList<NhanVien> getAllData(){
        String qry = "select * from nhanvien";
        ResultSet rs = conn.sqlExcute(qry);
        ArrayList<NhanVien> data = new ArrayList<>();
        if(rs == null) return data;
        try {
            while(rs.next()){
                data.add(new NhanVien(
                        rs.getString(1), 
                        rs.getString(2), 
                        rs.getDate(3).toLocalDate(), 
                        rs.getString(4), 
                        rs.getString(5), 
                        rs.getString(6), 
                        rs.getString(7), 
                        rs.getString(8), 
                        rs.getBoolean(9)
                ));
            }
        } catch (Exception e) {
        e.printStackTrace();}
        return data;
    }
    
    public boolean addNhanVienDao(NhanVien nv) {
        String qry = "INSERT INTO `nhanvien`(`MaNhanVien`, `TenNhanVien`, `NgaySinh`, `DiaChi`, `SoDienThoai`, `UserName`, `MatKhau`, `Quyen`)"
                + " VALUES ('"
                +nv.getMaNhanVien()+"','"
                +nv.getTenNhanVien()+"','"
                +nv.getNgaySinh().toString()+"','"
                +nv.getDiaChi()+"','"
                +nv.getSDT()+"','"
                +nv.getUserName()+"','"
                +nv.getPassword()+"','"
                +nv.getQuyen()
                +"',true)";
        return conn.sqlUpdate(qry);
    }

    public boolean updateStaffDao(NhanVien nv) {
        String qry = "UPDATE `nhanvien` SET "
                + "`TenNhanVien`='"+nv.getTenNhanVien()+"',"
                + "`NgaySinh`='"+nv.getNgaySinh().toString()+"',"
                + "`DiaChi`='"+nv.getDiaChi()+"',"
                + "`SoDienThoai`='"+nv.getSDT()+"',"
                + "`UserName`='"+nv.getUserName()+"',"
                + "`MatKhau`='"+nv.getPassword()+"',"
                + "`Quyen`='"+nv.getQuyen()+"',"
                + "`TrangThai`="+nv.isTrangThai()
                +" WHERE `MaNhanVien` = '"+nv.getMaNhanVien()+"';";
        return conn.sqlUpdate(qry);
    }
}

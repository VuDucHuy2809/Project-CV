 
package DAO;

import BUS.ChiTietHoaDonBUS;
import DTO.ChiTietHoaDonDTO;
import DTO.HoaDonDTO;
import DTO.SanPhamDTO;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import untils.MyDataAccess;

public class ChiTietHoaDonDAO {
    MyDataAccess my = new MyDataAccess("localhost","root","", "qlst");
    public ChiTietHoaDonDAO(){}
    public ArrayList<ChiTietHoaDonDTO> docCTHD() throws Exception{
        ArrayList<ChiTietHoaDonDTO> list = new ArrayList<ChiTietHoaDonDTO>();
        try {
            String qry = "select * from cthd";
            ResultSet rs = my.executeQuery(qry);
            while (rs.next()){
                ChiTietHoaDonDTO ct = new ChiTietHoaDonDTO();
                ct.setMaHD(rs.getString(1));
                ct.setMaSP(rs.getString(2));
                ct.setDonGia(rs.getDouble(3));
                ct.setSoLuong(rs.getInt(4));
                ct.setThanhTien(rs.getDouble(5));
                ct.setTienGiamGia_CT(rs.getDouble(6));
                list.add(ct);}
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Lỗi đọc DataBase cthd");}
        finally{
            my.close();}
                return list;
        }
    public boolean isValidtoAdd(ChiTietHoaDonDTO cthd) throws Exception{
        ArrayList<ChiTietHoaDonDTO> arr = docCTHD();
        try{
            for (int i=0; i<arr.size(); i++){
                if (arr.get(i).getMaHD().equals(cthd.getMaHD()) && arr.get(i).getMaSP().equals(cthd.getMaSP())){
                    JOptionPane.showMessageDialog(null, "Chi tiết hóa đơn này đã tồn tại!!!");
                    return false;}
                else return true;}
        } catch(Exception e){
            return false;}
        return true;
    }
    public int themCTHD(ChiTietHoaDonDTO cthd) throws Exception{
        int res = 0;
        if (isValidtoAdd(cthd)){
        try {
            String qry = "INSERT INTO cthd VALUES(";
            qry = qry +"'"+cthd.getMaHD()+"'";
            qry = qry +",'"+cthd.getMaSP()+"'";
            qry = qry +",'"+cthd.getDonGia()+"'";
            qry = qry +",'"+cthd.getSoLuong()+"'";
            qry = qry +",'"+cthd.getThanhTien()+"'";
            qry = qry +",'"+cthd.getTienGiamGia_CT()+"')";
            res = my.executeUpdate(qry);}
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Lỗi khi thêm chi tiết hóa đơn");}
            return res;}
        return res;
    }
    public int SuaCTHD(ChiTietHoaDonDTO cthd){
        int res = 0;
        try{
            String qry ="UPDATE cthd SET ";
            qry = qry + "DonGiaCTHD='"+cthd.getDonGia()+"',";
            qry = qry + "SoLuong='"+cthd.getSoLuong()+"',";
            qry = qry + "ThanhTienCTHD='"+cthd.getThanhTien()+"',";
            qry = qry + "TienGGCTHD='"+cthd.getTienGiamGia_CT()+"'";
            qry = qry +" WHERE MaHd='"+cthd.getMaHD()+"' AND MaSP='"+cthd.getMaSP()+"'";
            res = my.executeUpdate(qry);}
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Lỗi khi sửa chi tiết hóa đơn!!!");}
                return res;
    }
    public Vector docMahd(){
        String qry="select * from hoadon";
        Vector cbMa= new Vector();
        try {
            ResultSet rs = my.executeQuery(qry);
            while(rs.next()){
                cbMa.add(rs.getString(1));}
        } catch (Exception ex) {
            ex.printStackTrace();}
        return cbMa;
    }
    public Vector docMaSP(){
        String qry="select * from sanpham";
        Vector cbMa= new Vector();
        try {
            ResultSet rs = my.executeQuery(qry);
            while(rs.next()){
                cbMa.add(rs.getString(1));}
        } catch (Exception ex) {
            ex.printStackTrace();}
        return cbMa;
    }         
    public int getSLct(String mahd,String MaSP){
       int soluongct = 0;
       try{
           String qry = "select * from cthd where MaHd='"+mahd+"' and MaSP='"+MaSP+"'";
           ResultSet rs = my.executeQuery(qry);
           while(rs.next()){
               soluongct = rs.getInt("SoLuong");
           }
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, "Lỗi lấy số lượng cthd");
       }    return soluongct;
    }   // lấy số lượng trong chi tiết hóa đơn
    public double getgiamgiaCTKM(String MaSP,String makm){
       double giamgiact = 0;
       try{
           String qry = "select * from ctkm where MaSP='"+MaSP+"' and MaKm ='"+makm+"'";
           ResultSet rs = my.executeQuery(qry);
           while(rs.next()){
               giamgiact = rs.getDouble("PhanTramGGCT");
           }
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, "Lỗi lấy phần trăm KM cthd");
       }       
       return giamgiact;
   }   // lấy phần trăm giảm giá của chi tiết khuyến mãi
   public double getTongtienfromCTHD(String mahd){
       double tongtien = 0;
       try{
           String qry = "select sum(ThanhTienCTHD) as TongTien from cthd where MaHd='"+mahd+"'";
           ResultSet rs = my.executeQuery(qry);
           while(rs.next()){
               tongtien = rs.getDouble("TongTien");
           }
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, "Lỗi lấy tổng thành tiền của cthd lên hóa đơn");
       }       
       return tongtien;
   }    // lấy tổng thành tiền cthd làm tổng tiền hóa đơn
   public double getTienGGHdfromCTHD(String mahd){
       double tiengghd = 0;
       try{
           String qry = "select sum(TienGGCTHD) as TienGGHd from cthd where MaHd='"+mahd+"'";
           ResultSet rs = my.executeQuery(qry);
           while(rs.next()){
               tiengghd = rs.getDouble("TienGGHd");
           }
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, "Lỗi lấy tổng tiền giảm cthd lên thành tiền hóa đơn");}       
       return tiengghd;       
   }    //lấy tổng tiền giảm từ cthd lên thành tiền hóa đơn
}


package DAO;

import DTO.PhieuNhapDTO;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import untils.MyDataAccess;

public class PhieuNhapDAO {
    MyDataAccess my = new MyDataAccess("localhost","root","","qlst");
    public PhieuNhapDAO(){}
    public ArrayList<PhieuNhapDTO> docPn() throws Exception{
        ArrayList<PhieuNhapDTO> list=new ArrayList<PhieuNhapDTO>();
        try {
            String qry="SELECT * FROM phieunhap";
            ResultSet rs = my.executeQuery(qry);
            while(rs.next()){
             PhieuNhapDTO pn=new PhieuNhapDTO();
             pn.setMaPN(rs.getString(1));
             pn.setMaNV(rs.getString(2));
             pn.setMaNSX(rs.getString(3));
             pn.setNgayNhap(rs.getString(4));
             pn.setThanhTien(rs.getDouble(5));
             list.add(pn);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Lỗi đọc Database");}
        finally{    
            my.close();
        }
        return list;
    }
    
    public boolean isValidtoAdd(PhieuNhapDTO pn){
       try{
           ArrayList<PhieuNhapDTO> arr = docPn();
           for (int i = 0; i < arr.size(); i++) {
               if(arr.get(i).getMaPN().equals(pn.getMaPN())){
                JOptionPane.showMessageDialog(null,"Mã phiếu nhập đã tồn tại");
                return false;}
               else return true;}
        }catch(Exception e){
            return true;
        }
    return true;        
    }
    
    public int themPn(PhieuNhapDTO pn){
        if(isValidtoAdd(pn)){
        int res = 0;
        try{
             String qry = "insert into phieunhap values(";
             qry = qry +"'"+pn.getMaPN()+"'";
             qry = qry +",'"+pn.getMaNV()+"'";
             qry = qry +",'"+pn.getMaNSX()+"'";
             qry = qry+",'"+pn.getNgayNhap()+"'";
             qry = qry+","+pn.getThanhTien()+")";
             res = my.executeUpdate(qry);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Lỗi thêm phiếu nhập Database");}
        return res;}
        return 0;
    }
    
    public int suaPn(PhieuNhapDTO pn){
        int res = 0;
        try{
            String qry = "update phieunhap set ";
            qry = qry + "MaNv='"+pn.getMaNV()+"',";
            qry = qry + "MaNxb='"+pn.getMaNSX()+"',";
            qry = qry + "NgayNhap='"+pn.getNgayNhap()+"',";
            qry = qry + "TongTienPn="+pn.getThanhTien();
            qry = qry +" where MaPn ='"+pn.getMaPN()+"'";
            res = my.executeUpdate(qry);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Lỗi sửa phiếu nhập Database");
        }
        return res;
    }
    
    public Vector docManv(){
        String qry="select * from nhanvien";
        Vector cbMa= new Vector();
        try {
            ResultSet rs = my.executeQuery(qry);
            while(rs.next()){
                cbMa.add(rs.getString(1));}
        } catch (Exception ex) {
            ex.printStackTrace();}
        return cbMa;
    }
    
    public Vector docManxb(){
        String qry="select * from ncc";
        Vector cbMa= new Vector();
        try {
            ResultSet rs = my.executeQuery(qry);
            while(rs.next()){
                cbMa.add(rs.getString(1));}
        } catch (Exception ex) {
            ex.printStackTrace();}
        return cbMa;
    }

    public double getThanhtienPnfromPN(String mapn){
       double thanhtien = 0;
       try{
           String qry = "select * from phieunhap where MaPn='"+mapn+"'";
           ResultSet rs = my.executeQuery(qry);
           while(rs.next()){
               thanhtien = rs.getDouble("ThanhTienPn");
           }
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, "Lỗi lấy thành tiền của phiếu nhập");
       }       
       return thanhtien;       
   }    // lấy thành tiền của phiếu nhập
   
    public int changeThanhtien_afterdec(String mapn,double thanhtien){
       int res = 0;
       try{
           String qry = "update phieunhap set ThanhTienPn='"+thanhtien+"' where MaPn='"+mapn+"'";
           res = my.executeUpdate(qry);
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, "Lỗi sửa thành tiền sau khi giảm của hóa đơn");
       }       
       return res;
   }    // sửa thành tiền sau khi giảm
   
}

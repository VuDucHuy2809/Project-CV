
package DAO;

import DTO.ChiTietPhieuNhapDTO;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import untils.MyDataAccess;

public class ChiTietPhieuNhapDAO {
    MyDataAccess my = new MyDataAccess("localhost","root","","qlst");
    public ChiTietPhieuNhapDAO(){}
    public ArrayList<ChiTietPhieuNhapDTO> docCTPN() throws Exception{
        ArrayList<ChiTietPhieuNhapDTO> list=new ArrayList<ChiTietPhieuNhapDTO>();
        try {
            String qry="select * from ctpn";
            ResultSet rs = my.executeQuery(qry);
            while(rs.next()){
             ChiTietPhieuNhapDTO ctpn=new ChiTietPhieuNhapDTO();
             ctpn.setMaPN(rs.getString(1));
             ctpn.setMaSP(rs.getString(2));
             ctpn.setDonGia(rs.getDouble(3));
             ctpn.setSoLuong(rs.getInt(4));
             ctpn.setThanhTien_CT(rs.getDouble(5));
             list.add(ctpn);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Lỗi đọc Database chi tiết phiếu nhập");}
        finally{    
            my.close();
        }
        return list;
    }
    public boolean isValidtoAdd(ChiTietPhieuNhapDTO ctpn) throws Exception{
        ArrayList<ChiTietPhieuNhapDTO> arr = docCTPN();
        try{
            for (int i=0; i<arr.size(); i++){
                if (arr.get(i).getMaPN().equals(ctpn.getMaPN()) && arr.get(i).getMaSP().equals(ctpn.getMaSP())){
                    JOptionPane.showMessageDialog(null, "Chi tiết phiếu nhập này đã tồn tại!!!");
                    return false;}
                else return true;}
        } catch(Exception e){
            return false;}
        return true;
    }
    public int themCTPn(ChiTietPhieuNhapDTO ctpn) throws Exception{
        int res = 0;
        if(isValidtoAdd(ctpn)){
        try{
                String qry = "insert into ctpn values(";
                qry = qry +"'"+ctpn.getMaPN()+"'";
                qry = qry +",'"+ctpn.getMaSP()+"'";
                qry = qry +","+ctpn.getDonGia();
                qry = qry+","+ctpn.getSoLuong();
                qry = qry+","+ctpn.getThanhTien_CT()+")";
                res = my.executeUpdate(qry);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Lỗi thêm chi tiết phiếu nhập Database");}
            return res;}
        return res;
        }
    public int suaCTPn(ChiTietPhieuNhapDTO ctpn){
        int res = 0;
        try{
            String qry = "update ctpn set ";
            qry = qry + "DonGiaPn="+ctpn.getDonGia()+",";
            qry = qry + "SoLuong="+ctpn.getSoLuong()+",";
            qry = qry + "ThanhTienCTPn="+ctpn.getThanhTien_CT();
            qry = qry +" where MaPn ='"+ctpn.getMaPN()+"' and MaSP='"+ctpn.getMaSP()+"'";
            res = my.executeUpdate(qry);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Lỗi sửa chi tiết phiếu nhập Database");
        }
        return res;
    }
    
    public Vector docMapn(){
        String qry="select * from phieunhap";
        Vector cbMa= new Vector();
        try {
            ResultSet rs = my.executeQuery(qry);
            while(rs.next()){
                cbMa.add(rs.getString(1));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return cbMa;
    }
   
    public Vector docMaSP(){
        String qry="select * from sanpham";
        Vector cbMa= new Vector();
        try {
            ResultSet rs = my.executeQuery(qry);
            while(rs.next()){
                cbMa.add(rs.getString(1));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return cbMa;
    } 
   
    public int getSLct(String mapn,String MaSP){
       int soluongct = 0;
       try{
           String qry = "select * from ctpn where MaPn='"+mapn+"' and MaSP='"+MaSP+"'";
           ResultSet rs = my.executeQuery(qry);
           while(rs.next()){
               soluongct = rs.getInt("SoLuong");
           }
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, "Lỗi lấy số lượng ctpn");
       }    return soluongct;
    }   // lấy số lượng trong chi tiết phiếu nhập  
    
    public double getThanhTienPnfromCTPN(String mapn){
       double thanhtienpn = 0;
       try{
           String qry = "select sum(ThanhTienCTPn) as ThanhTienPn from ctpn where MaPn='"+mapn+"'";
           ResultSet rs = my.executeQuery(qry);
           while(rs.next()){
               thanhtienpn = rs.getDouble("ThanhTienPn");
           }
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, "Lỗi lấy tổng thành tiền của ctpn lên phiếu nhập");
       }       
       return thanhtienpn;
   }    // lấy tổng thành tiền ctpn làm thành tiền phiếu nhập  
}

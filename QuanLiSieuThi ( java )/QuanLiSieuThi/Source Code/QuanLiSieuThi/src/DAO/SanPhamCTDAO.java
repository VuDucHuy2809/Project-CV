
package DAO;

import DTO.SanPhamDTO;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import untils.MyDataAccess;

public class SanPhamCTDAO {
    MyDataAccess my = new MyDataAccess("localhost","root","","qlst");
    public SanPhamCTDAO(){}
    public ArrayList<SanPhamDTO> docsanphamforCT() throws Exception{
        ArrayList<SanPhamDTO> list1 = new ArrayList<SanPhamDTO>();
        try {
            String qry = "select * from sanpham order by substr(MaSP,7,6)*1 ";
            ResultSet rs = my.executeQuery(qry);
            while (rs.next()){
                SanPhamDTO sanpham = new SanPhamDTO();
                sanpham.setMaSP(rs.getString("MaSP"));
                sanpham.setTenSP(rs.getString("TenSP"));
                sanpham.setDonGia(rs.getDouble("DonGia"));
                sanpham.setSoLuong(rs.getInt("SoLuong"));
                list1.add(sanpham);}
        } catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi đọc DataBase của sản phẩm chi tiết");}
        finally{
            my.close();}
                return list1;
    }

    public int changeSLb(int sl,String MaSP){
        int res = 0;
       try {
           String qry="UPDATE sanpham SET ";
           qry = qry + "SoLuong='"+sl+"'";
           qry = qry + " where MaSP='"+MaSP+"'";
           res = my.executeUpdate(qry);
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Lỗi sửa số lượng");
       }
       return res;
   }    //sửa số lượng sản phẩm
    
    public int getSLb(String MaSP){
        int soluongb = 0;
        try {
            String qry = "select * from sanpham where MaSP='"+MaSP+"'";
            ResultSet rs = my.executeQuery(qry); 
           while(rs.next()){
              soluongb = rs.getInt("SoLuong");
           }
       } catch (Exception e) {
           e.printStackTrace();
           JOptionPane.showMessageDialog(null, "Lỗi lấy số lượng sản phẩm");
       }
       return soluongb;
   }    // lấy số lượng sản phẩm
    
}


package DAO;
import untils.MyDataAccess;
import  DTO.HoaDonDTO;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.text.SimpleDateFormat;  
import java.util.Vector;
import javax.swing.JOptionPane;
public class HoaDonDAO {
    MyDataAccess my = new MyDataAccess("localhost","root","", "qlst");
    public HoaDonDAO(){}
    public ArrayList<HoaDonDTO> docHD() throws Exception{
        ArrayList<HoaDonDTO> list = new ArrayList<HoaDonDTO>();
        try{
            String qry = "select * from hoadon";
            ResultSet rs = my.executeQuery(qry); 
            while (rs.next()){
                HoaDonDTO hd = new HoaDonDTO();
                hd.setMaHD(rs.getString(1));
                hd.setMaNV(rs.getString(2));                
                hd.setMaKH(rs.getString(3));
                hd.setMaKM(rs.getString(4));
                hd.setNgayXuat(rs.getString(5));
                hd.setTongtien(rs.getDouble(6));
                hd.setTienGiamGia(rs.getDouble(7));
                hd.setThanhTien(rs.getDouble(8));
                list.add(hd);}
            }
        catch(Exception e){
               JOptionPane.showMessageDialog(null, "Lỗi đọc Database!!!");}
        finally{
            my.close();}
            return list;
    }
    
    public boolean kiemtratrung(HoaDonDTO hd){
       try{
           ArrayList<HoaDonDTO> arr = docHD();
           for (int i = 0; i < arr.size(); i++) {
               if(arr.get(i).getMaHD().equals(hd.getMaHD())){
                JOptionPane.showMessageDialog(null,"Mã hóa đơn đã tồn tại");
                return false;}
               else return true;}
        }catch(Exception e){
            return true;
        }
    return true;        
    }    
    
    public int themHD(HoaDonDTO hd){
        if (kiemtratrung(hd)){
            int res = 0;
            try {
                String qry = "INSERT INTO hoadon VALUES(";
                qry = qry + "'"+hd.getMaHD()+"'";
                qry = qry + ",'"+hd.getMaNV()+"'";
                qry = qry + ",'"+hd.getMaKH()+"'";
                qry = qry + ",'"+hd.getMaKM()+"'";
                qry = qry + ",'"+hd.getNgayXuat()+"'";
                qry = qry +",'"+hd.getTongtien()+"'";
                qry = qry +",'"+hd.getTienGiamGia()+"'";
                qry = qry + ",'"+hd.getThanhTien()+"')";
                res = my.executeUpdate(qry);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Lỗi thêm hóa đơn vào Database");
            }
        return res;
        }
        return 0;
    }
    
    public int suaHD(HoaDonDTO hd){
        int res = 0;
        try{
            String qry = "UPDATE hoadon SET ";
                qry = qry + "MaNv='"+hd.getMaNV()+"',";            
                qry = qry + "MaKh='"+hd.getMaKH()+"',";
                qry = qry + "MaKm='"+hd.getMaKM()+"',";
                qry = qry + "NgayXuat='"+hd.getNgayXuat()+"',";
                qry = qry + "TongTien='"+hd.getTongtien()+"',";                
                qry = qry + "TienGGHd='"+hd.getTienGiamGia()+"',";
                qry = qry + "ThanhTienHd='"+hd.getThanhTien()+"'";
                qry = qry + " WHERE MaHd='"+hd.getMaHD()+"'";
                res = my.executeUpdate(qry);} 
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Lỗi khi sửa hóa đơn trong DataBase!!!");}
            return res;
    }

   public Vector docManv(){
        String qry="select * from nhanvien";
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
   
   public Vector docMakh(){
        String qry="select * from khachhang";
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
   
   public Vector docMakm(){
        String qry="select * from khuyenmai";
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
      
   public double getTongtienfromHD(String mahd){
       double tongtien = 0;
       try{
           String qry = "select * from hoadon where MaHd='"+mahd+"'";
           ResultSet rs = my.executeQuery(qry);
           while(rs.next()){
               tongtien = rs.getDouble("TongTien");
           }
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, "Lỗi lấy tổng tiền của hóa đơn");
       }       
       return tongtien;       
   }    // lấy tổng tiền của hóa đơn
   
   public int changeThanhtien_afterdec(String mahd,double thanhtien){
       int res = 0;
       try{
           String qry = "update hoadon set ThanhTienHd='"+thanhtien+"' where MaHd='"+mahd+"'";
           res = my.executeUpdate(qry);
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, "Lỗi sửa thành tiền sau khi giảm của hóa đơn");
       }       
       return res;
   }    // sửa thành tiền sau khi giảm

   public int changeTienGGHd_afterdone(String mahd,double tongtiengiam){
       int res = 0;
       try{
           String qry = "update hoadon set TienGGHd='"+tongtiengiam+"' where MaHd='"+mahd+"'";
           res = my.executeUpdate(qry);
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, "Lỗi sửa thành tiền sau khi giảm của hóa đơn");
       }       
       return res;
   }    // sửa tổng tiền giảm giá cuối cùng của hóa đơn sau khi tác động từ cthd  
   
    public int changeTongtienHDfromCT(String mahd,double tongtien,double thanhtien,double giamgia){
       int res = 0;
       try{
           String qry =  "update hoadon set TongTien='"+tongtien+"',ThanhTienHd='"+thanhtien
                            +"',TienGGHd='"+giamgia+"' where MaHd='"+mahd+"'";
           res = my.executeUpdate(qry);
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, "Lỗi sửa tổng tiền của hóa đơn");
       }       
       return res;
   }//sửa tổng tiền hóa đơn khi tác động cthd
   
   public double getTienGGHdfromHD(String mahd){
       double tiengghd = 0;
       try{
           String qry = "select * from hoadon where MaHd='"+mahd+"'";
           ResultSet rs = my.executeQuery(qry);
           while(rs.next()){
               tiengghd = rs.getDouble("TienGGHd");
           }
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, "Lỗi lấy tổng tiền giảm của hóa đơn");}       
       return tiengghd;
   }    //lấy tổng tiền giảm trong hóa đơn

   public int changeMaKM(HoaDonDTO hd){
       int res = 0;
       try{
           String qry = "update hoadon set MaKm='"+hd.getMaKM()+"' where MaHd='"+hd.getMaHD()+"'";
           res = my.executeUpdate(qry);
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, "Lỗi sửa mã khuyến mãi");
       }       
       return res;       
   }    //sửa mã khuyến mãi
   
   public String getMaKmfromHD(String mahd){
       String makm = null;
       try{
           String qry = "select * from hoadon where hoadon.MaHd = '"+mahd+"'";
           ResultSet rs = my.executeQuery(qry);
           while(rs.next()){
               makm = rs.getString("MaKm");
           }
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, "Lỗi lấy mã khuyến mãi của hóa đơn");}       
       return makm;
   }    // lấy mã khuyến mãi của hóa đơn   
   
}

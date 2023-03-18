
package DAO;

import DTO.KhachHangDTO;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import untils.MyDataAccess;

public class KhachHangDAO {
    MyDataAccess my = new MyDataAccess("localhost","root","","qlst");
    public KhachHangDAO(){}
    public ArrayList<KhachHangDTO> docKh() throws Exception{
        ArrayList<KhachHangDTO> list = new ArrayList<KhachHangDTO>();
        try{
                String qry = "select * from khachhang";
                ResultSet rs = my.executeQuery(qry);
                while(rs.next()){
                    KhachHangDTO kh = new KhachHangDTO();
                    kh.setMaKH(rs.getString(1));
                    kh.setHoKH(rs.getString(2));
                    kh.setTenKH(rs.getString(3));
                    kh.setsDTKH(rs.getString(4));
                    kh.setDiaChiKH(rs.getString(5));
                    list.add(kh);
                }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Lỗi đọc Database");
        }
        finally{
            my.close();
        }
        return list;
    }

    public boolean isValidtoAdd(KhachHangDTO kh){
       try{
           ArrayList<KhachHangDTO> arr = docKh();
           for (int i = 0; i < arr.size(); i++) {
               if(arr.get(i).getMaKH().equals(kh.getMaKH())){
                JOptionPane.showMessageDialog(null,"Mã khách hàng đã tồn tại");
                return false;}
               else return true;}
        }catch(Exception e){
            return true;
        }
    return true;        
    }
    
    public int themKh(KhachHangDTO kh){
        if(isValidtoAdd(kh)){
        int res = 0;
        try{
                String qry = "insert into khachhang values(";
                qry=qry+"'"+kh.getMaKH()+"'";
                qry=qry+",'"+kh.getHoKH()+"'";
                qry=qry+",'"+kh.getTenKH()+"'";
                qry=qry+",'"+kh.getsDTKH()+"'";
                qry=qry+",'"+kh.getDiaChiKH()+"')";
                res = my.executeUpdate(qry);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Lỗi thêm khách hàng Database");
            }
        return res;
        }
        return 0;
    }
    public int suaKh(KhachHangDTO kh){
        int res = 0;
        try{
            String qry = "update khachhang set ";
            qry = qry + "HoKh='"+kh.getHoKH()+"',";
            qry = qry + "TenKh='"+kh.getTenKH()+"',";
            qry = qry + "Sdt='"+kh.getsDTKH()+"',";
            qry = qry + "DiaChiKh='"+kh.getDiaChiKH()+"'";
            qry = qry +" where MaKh ='"+kh.getMaKH()+"'";
            res = my.executeUpdate(qry);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Lỗi sửa khách hàng Database");
        }
        return res;
    }
}

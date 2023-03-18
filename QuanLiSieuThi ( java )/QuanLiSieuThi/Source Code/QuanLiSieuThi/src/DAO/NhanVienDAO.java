
package DAO;

import DTO.NhanVienDTO;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import untils.MyDataAccess;

public class NhanVienDAO {
    MyDataAccess my = new MyDataAccess("localhost","root","","qlst");
    public NhanVienDAO(){}
    public ArrayList<NhanVienDTO> docNv() throws Exception{
        ArrayList<NhanVienDTO> list=new ArrayList<NhanVienDTO>();
        try {
            String qry="SELECT * FROM nhanvien";
            ResultSet rs = my.executeQuery(qry);
            while(rs.next()){
             NhanVienDTO nv=new NhanVienDTO();
             nv.setMaNV(rs.getString(1));
             nv.setHoNV(rs.getString(2));
             nv.setTenNV(rs.getString(3));
             nv.setDiaChiNV(rs.getString(4));
             nv.setChucVuNV(rs.getString(5));
             nv.setLuong(rs.getDouble(6));
             list.add(nv);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Lỗi đọc Database");}
        finally{    
            my.close();
        }
        return list;
    }
    public boolean isValidtoAdd(NhanVienDTO nv){
       try{
           ArrayList<NhanVienDTO> arr = docNv();
           for (int i = 0; i < arr.size(); i++) {
               if(arr.get(i).getMaNV().equals(nv.getMaNV())){
                JOptionPane.showMessageDialog(null,"Mã nhân viên đã tồn tại");
                return false;}
               else return true;}
        }catch(Exception e){
            return true;
        }
    return true;        
    }
    
    public int themNv(NhanVienDTO nv){
        if(isValidtoAdd(nv)){
        int res = 0;
        try{
                String qry = "insert into nhanvien values(";
                qry = qry +"'"+nv.getMaNV()+"'";
                qry = qry +",'"+nv.getHoNV()+"'";
                qry = qry +",'"+nv.getTenNV()+"'";
                qry = qry+",'"+nv.getDiaChiNV()+"'";
                qry = qry+",'"+nv.getChucVuNV()+"'";
                qry = qry+","+nv.getLuong()+")";
                res = my.executeUpdate(qry);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Lỗi thêm nhân viên Database");
            }
        return res;
        }
        return 0;
    }
    public int suaNv(NhanVienDTO nv){
        int res = 0;
        try{
            String qry = "update nhanvien set ";
            qry = qry + "HoNv='"+nv.getHoNV()+"',";
            qry = qry + "TenNv='"+nv.getTenNV()+"',";
            qry = qry + "DiaChiNv='"+nv.getDiaChiNV()+"',";
            qry = qry + "ChucVu='"+nv.getChucVuNV()+"',";
            qry = qry + "Luong="+nv.getLuong();          
            qry = qry +" where MaNv ='"+nv.getMaNV()+"'";
            res = my.executeUpdate(qry);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Lỗi sửa nhân viên Database");
        }
        return res;
    }    
}

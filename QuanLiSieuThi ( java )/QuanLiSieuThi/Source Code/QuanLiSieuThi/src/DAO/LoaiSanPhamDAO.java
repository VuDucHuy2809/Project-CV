
package DAO;

import DTO.LoaiSanPhamDTO;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import untils.MyDataAccess;

public class LoaiSanPhamDAO {
    MyDataAccess my = new MyDataAccess("localhost","root","","qlst");
    public LoaiSanPhamDAO(){}
    public ArrayList<LoaiSanPhamDTO> docTl() throws Exception{
        ArrayList<LoaiSanPhamDTO> list = new ArrayList<LoaiSanPhamDTO>();
        try{
                String qry = "select * from loaisanpham order by substr(MaLoai,5,6)*1 asc";
                ResultSet rs = my.executeQuery(qry);
                while(rs.next()){
                    LoaiSanPhamDTO tl = new LoaiSanPhamDTO();
                    tl.setMaLoai(rs.getString(1));
                    tl.setTenLoai(rs.getString(2));
                    list.add(tl);
                }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Lỗi đọc Database");
        }
        finally{
            my.close();
        }
        return list;
    }

    public boolean isValidtoAdd(LoaiSanPhamDTO tl){
       try{
           ArrayList<LoaiSanPhamDTO> arr = docTl();
           for (int i = 0; i < arr.size(); i++) {
               if(arr.get(i).getMaLoai().equals(tl.getMaLoai())){
                JOptionPane.showMessageDialog(null,"Mã loại sản phẩm đã tồn tại");
                return false;}
               else return true;}
        }catch(Exception e){
            return true;
        }
           return true;        
    }

    public int themTl(LoaiSanPhamDTO tl){
        if(isValidtoAdd(tl)){
        int res = 0;
        try{
                String qry = "insert into loaisanpham values(";
                qry = qry +"'"+tl.getMaLoai()+"'";
                qry = qry +",'"+tl.getTenLoai()+"')";
                res = my.executeUpdate(qry);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Lỗi thêm loại sản phẩm Database");
            }
        return res;
        }
        return 0;
    }

    public int suaTl(LoaiSanPhamDTO tl){
        int res = 0;
        try{
            String qry = "update loaisanpham set ";
            qry = qry + "TenLoai='"+tl.getTenLoai()+"'";
            qry = qry +" where `loaisanpham`.`MaLoai` ='"+tl.getMaLoai()+"'";
            res = my.executeUpdate(qry);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Lỗi sửa loại sản phẩm Database");
        }
        return res;
    }    
}

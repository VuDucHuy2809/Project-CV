
package DAO;

import DTO.NhaSanXuatDTO;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import untils.MyDataAccess;

public class NhaSanXuatDAO {
    MyDataAccess my = new MyDataAccess("localhost","root","","qlst");
    public NhaSanXuatDAO(){}
    public ArrayList<NhaSanXuatDTO> docNSX() throws Exception{
        ArrayList<NhaSanXuatDTO> list = new ArrayList<NhaSanXuatDTO>();
        try{
                String qry = "select * from nhasx order by substr(MaNSX,3,6)*1 asc";
                ResultSet rs = my.executeQuery(qry);
                while(rs.next()){
                    NhaSanXuatDTO NSX = new NhaSanXuatDTO();
                    NSX.setMaNSX(rs.getString(1));
                    NSX.setTenNSX(rs.getString(2));
                    NSX.setSdtNSX(rs.getString(3));
                    NSX.setDcNSX(rs.getString(4));
                    list.add(NSX);
                }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Lỗi đọc Database");
        }
        finally{
            my.close();
        }
        return list;
    }

    public boolean isValidtoAdd(NhaSanXuatDTO NSX){
       try{
           ArrayList<NhaSanXuatDTO> arr = docNSX();
           for (int i = 0; i < arr.size(); i++) {
               if(arr.get(i).getMaNSX().equals(NSX.getMaNSX())){
                JOptionPane.showMessageDialog(null,"Mã nhà sản xuất đã tồn tại");
                return false;}
               else return true;}
        }catch(Exception e){
            return true;
        }
    return true;        
    }
    
    public int themNSX(NhaSanXuatDTO NSX){
        if(isValidtoAdd(NSX)){
        int res = 0;
        try{
                String qry = "insert into nhasx values(";
                qry = qry +"'"+NSX.getMaNSX()+"'";
                qry = qry+",'"+NSX.getTenNSX()+"'";
                qry = qry+",'"+NSX.getSdtNSX()+"'";
                qry = qry+",'"+NSX.getDcNSX()+"')";
                res = my.executeUpdate(qry);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Lỗi thêm nhà sản xuất từ Database");
            }
        return res;
        }
        return 0;
    }
    public int suaNSX(NhaSanXuatDTO NSX){
        int res = 0;
        try{
            String qry = "update nhasx set ";
            qry = qry + "TenNSX='"+NSX.getTenNSX()+"',";
            qry = qry + "Sdt='"+NSX.getSdtNSX()+"',";
            qry = qry + "DcNSX='"+NSX.getDcNSX()+"'";
            qry = qry +" where MaNSX ='"+NSX.getMaNSX()+"'";
            res = my.executeUpdate(qry);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Lỗi sửa nhà sản xuất từ Database");
        }
        return res;
    }
    public int xoaNSX(String ma){
        int res = 0;
        try{
            String qry = "delete from nhasx where MaNSX='"+ma+"'";
            res = my.executeUpdate(qry);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Lỗi xóa nhà sản xuất Database");
        }
        return res;
    }    
}

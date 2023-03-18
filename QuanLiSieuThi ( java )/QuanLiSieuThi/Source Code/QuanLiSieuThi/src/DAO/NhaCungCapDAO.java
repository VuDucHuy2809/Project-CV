
package DAO;

import DTO.NhaCungCapDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import untils.MyDataAccess;

public class NhaCungCapDAO {
    MyDataAccess my = new MyDataAccess("localhost","root","","qlst");
    public NhaCungCapDAO(){}
    public ArrayList<NhaCungCapDTO> docNCC() throws Exception{
        ArrayList<NhaCungCapDTO> list=new ArrayList<NhaCungCapDTO>();
        try {
            String qry="SELECT * FROM ncc order by substr(MaNCC,4,6)*1 asc";
            ResultSet rs = my.executeQuery(qry);
            while(rs.next()){
             NhaCungCapDTO NCC=new NhaCungCapDTO();
             NCC.setMaNCC(rs.getString(1));
             NCC.setTenNCC(rs.getString(2));
             NCC.setSdtNCC(rs.getString(3));
             NCC.setDcNCC(rs.getString(4));
             list.add(NCC);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Lỗi đọc Database");}
        finally{    
            my.close();
        }
        return list;
    }
    public boolean isValidtoAdd(NhaCungCapDTO NCC){
       try{
           ArrayList<NhaCungCapDTO> arr = docNCC();
           for (int i = 0; i < arr.size(); i++) {
               if(arr.get(i).getMaNCC().equals(NCC.getMaNCC())){
                JOptionPane.showMessageDialog(null,"Mã nhà cung cấp đã tồn tại");
                return false;}
               else return true;}
        }catch(Exception e){
            return true;
        }
    return true;        
    }
    
    public int themNCC(NhaCungCapDTO NCC){
        if(isValidtoAdd(NCC)){
        int res = 0;
        try{
                String qry = "insert into ncc values(";
                qry = qry +"'"+NCC.getMaNCC()+"'";
                qry = qry +",'"+NCC.getTenNCC()+"'";
                qry = qry+",'"+NCC.getSdtNCC()+"'";
                qry = qry+",'"+NCC.getDcNCC()+"')";
                res = my.executeUpdate(qry);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Lỗi thêm nhà cung cấp Database");
            }
        return res;
        }
        return 0;
    }
    public int suaNCC(NhaCungCapDTO NCC){
        int res = 0;
        try{
            String qry = "update ncc set ";
            qry = qry + "TenNCC='"+NCC.getTenNCC()+"',";
            qry = qry + "Sdt='"+NCC.getSdtNCC()+"',";
            qry = qry + "DcNCC='"+NCC.getDcNCC()+"'";
            qry = qry +" where MaNCC ='"+NCC.getMaNCC()+"'";
            res = my.executeUpdate(qry);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Lỗi sửa nhà cung cấp Database");
        }
        return res;
    }
}

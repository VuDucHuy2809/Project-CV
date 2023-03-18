
package DAO;

import DTO.SanPhamDTO;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import untils.MyDataAccess;

public class SanPhamDAO {
    MyDataAccess my = new MyDataAccess("localhost","root","","qlst");
    public SanPhamDAO(){}
    public ArrayList<SanPhamDTO> docSanPham() throws Exception{
        ArrayList<SanPhamDTO> list = new ArrayList<SanPhamDTO>();
        try{
                String qry = "select * from sanpham order by substr(MaSP,7,6)*1 ";
                ResultSet rs = my.executeQuery(qry);
                while(rs.next()){
                    SanPhamDTO s = new SanPhamDTO();
                    s.setMaSP(rs.getString(1));
                    s.setMaNSX(rs.getString(2));
                    s.setMaNCC(rs.getString(3));
                    s.setMaLoai(rs.getString(4));
                    s.setTenSP(rs.getString(5));
                    s.setHSD(rs.getString(6));
                    s.setDonGia(rs.getDouble(7));
                    s.setSoLuong(rs.getInt(8));                   
                    list.add(s);
                }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Lỗi đọc Database");
        }
        finally{
            my.close();
        }
        return list;
    }    
    
    public boolean isValidtoAdd(SanPhamDTO s){
       try{
           ArrayList<SanPhamDTO> arr = docSanPham();
           for (int i = 0; i < arr.size(); i++) {
               if(arr.get(i).getMaSP().equals(s.getMaSP())){
                JOptionPane.showMessageDialog(null,"Mã sản phẩm đã tồn tại");
                return false;}
               else return true;}
        }catch(Exception e){
            return true;
        }
    return true;        
    }
    
    public int themSanPham(SanPhamDTO s){
        if(isValidtoAdd(s)){
        int res = 0;
        try{
                String qry = "insert into sanpham values(";
                qry = qry +"'"+s.getMaSP()+"'";
                qry = qry +",'"+s.getMaNSX()+"'";
                qry = qry+",'"+s.getMaNCC()+"'";
                qry = qry+",'"+s.getMaLoai()+"'";
                qry = qry+",'"+s.getTenSP()+"'";
                qry = qry+","+s.getHSD();
                qry = qry+","+s.getDonGia();
                qry = qry+","+s.getSoLuong()+")";                
                res = my.executeUpdate(qry);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Lỗi thêm sản phẩm Database");
            }
        return res;
        }
        return 0;
    }
    public int suaSanPham(SanPhamDTO s){
        int res = 0;
        try{
            String qry = "update sanpham set ";
            qry = qry + "TenSP='"+s.getTenSP()+"',";            
            qry = qry + "HSD="+s.getHSD()+",";
            qry = qry + "DonGia="+s.getDonGia()+",";
            qry = qry + "SoLuong='"+s.getSoLuong()+"'";          
            qry = qry +" where MaSP ='"+s.getMaSP()+"' and MaNSX ='"+s.getMaNSX()+"'"
                      + " and MaNCC ='"+s.getMaNCC()+"' and MaLoai ='"+s.getMaLoai()+"'";
            res = my.executeUpdate(qry);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Lỗi sửa sản phẩm Database");
        }
        return res;
    }

}

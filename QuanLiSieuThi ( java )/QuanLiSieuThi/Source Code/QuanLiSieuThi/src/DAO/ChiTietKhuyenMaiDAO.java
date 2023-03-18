
package DAO;

import BUS.ChiTietHoaDonBUS;
import DTO.ChiTietKhuyenMaiDTO;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import untils.MyDataAccess;

public class ChiTietKhuyenMaiDAO {
    MyDataAccess my = new MyDataAccess("localhost", "root", "", "qlst");
    public ChiTietKhuyenMaiDAO(){}
    public ArrayList<ChiTietKhuyenMaiDTO> docCTKM() throws Exception {
        ArrayList<ChiTietKhuyenMaiDTO> list = new ArrayList<>();
        try{
            String qry = "select * from ctkm";
            ResultSet rs = my.executeQuery(qry);
            while (rs.next())
            {
                ChiTietKhuyenMaiDTO ct = new ChiTietKhuyenMaiDTO();
                ct.setMaKM(rs.getString(1));
                ct.setMaSP(rs.getString(2));
                ct.setPhanTramGiamGia_CT(rs.getDouble(3));
                list.add(ct);
            }
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Lỗi đọc database");
        }
        finally 
        {
            my.close();
        }
        return list;
    }
   public ArrayList<ChiTietKhuyenMaiDTO> docCTKMtheoMaKM(String MaKM) throws Exception {
        ArrayList<ChiTietKhuyenMaiDTO> list = new ArrayList<>();
        try{
            String qry = "select * from ctkm where MaKm='"+MaKM+"'";
            ResultSet rs = my.executeQuery(qry);
            while (rs.next())
            {
                ChiTietKhuyenMaiDTO ct = new ChiTietKhuyenMaiDTO();
                ct.setMaKM(rs.getString(1));
                ct.setMaSP(rs.getString(2));
                ct.setPhanTramGiamGia_CT(rs.getDouble(3));
            }
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Lỗi đọc database ctkm");
        }
        finally 
        {
            my.close();
        }
        return list;
    }
    public Vector docMaSP(){
        String qry="select * from sanpham";
        Vector cbMa= new Vector();
        try {
            ResultSet rs = my.executeQuery(qry);
            while(rs.next()){
                cbMa.add(rs.getString(1));}
        } catch (Exception ex) {
            System.out.println("DAO.ChiTietKhuyenMaiDAO.docMaSP()");
            ex.printStackTrace();}
        return cbMa;
    }
    public Vector docMaKM()
    {
        String qry="select * from khuyenmai";
        Vector cbMa = new Vector();
        try {
            ResultSet rs = my.executeQuery(qry);
            while (rs.next())
            {
                cbMa.add(rs.getString(1));
            }
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return cbMa;
    }
    public boolean isValidtoAdd(ChiTietKhuyenMaiDTO ct)
    {
        try{
            ArrayList <ChiTietKhuyenMaiDTO> arr = docCTKM();
            for (int i=1; i< arr.size(); i++)
            {
                if (arr.get(i).getMaKM().equals(ct) && arr.get(i).getMaSP().equals(ct))
                {
                    JOptionPane.showMessageDialog(null, "Chi tiết đã tồn tại");
                    return false;
                }
            }
        }catch (Exception e)
        {
            return true;
        }
        return true;
    }
    public int themCTKM(ChiTietKhuyenMaiDTO ct)
    {
        if (isValidtoAdd(ct))
        {
            int res =0;
            try{
                String qry ="insert into ctkm values('"+ct.getMaKM()+"','"+ct.getMaSP()+"','"+ct.getPhanTramGiamGia_CT()+"')";
                System.out.print(qry);
                res = my.executeUpdate(qry);
            } catch (Exception e)
            {
                JOptionPane.showMessageDialog(null, "Lỗi khi thêm chi tiết");
            }
            return res;
        }
        return 0;
    }
    public int suaCTKM(ChiTietKhuyenMaiDTO ct)
    {
        int res = 0;
        try{
            String qry = "update ctkm set PhanTramGGCT='"+ct.getPhanTramGiamGia_CT()+"' where MaKm='"+ct.getMaKM()+"' and MaSP='"+ct.getMaSP()+"'";
            res = my.executeUpdate(qry);
            System.out.print(qry);
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Lỗi khi sửa chi tiết");
        }
        return res;
    }
            
}

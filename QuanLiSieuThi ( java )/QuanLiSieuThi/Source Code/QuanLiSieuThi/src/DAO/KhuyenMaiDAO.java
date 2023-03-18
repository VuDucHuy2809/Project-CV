package DAO;

import DTO.KhuyenMaiDTO;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import untils.MyDataAccess;

public class KhuyenMaiDAO {

    MyDataAccess my = new MyDataAccess("localhost", "root", "", "qlst");

    public KhuyenMaiDAO() {
    }

    public ArrayList<KhuyenMaiDTO> docKM() throws Exception {
        ArrayList<KhuyenMaiDTO> list = new ArrayList<KhuyenMaiDTO>();
        try {
            String qry = "select * from khuyenmai";
            ResultSet rs = my.executeQuery(qry);
            while (rs.next()) {
                KhuyenMaiDTO km = new KhuyenMaiDTO();
                km.setMaKM(rs.getString(1));
                km.setLoaiChuongTrinh(rs.getString(3));
                km.setNgayBDKM(rs.getString(4));
                km.setNgayKTKM(rs.getString(5));
                km.setPhanTramGiamGia(rs.getDouble(6));
                km.setTenChuongTrinh(rs.getString(2));
                list.add(km);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi đọc database");
        } finally {
            my.close();
        }
        return list;
    }

    public boolean isValidtoAdd(KhuyenMaiDTO km) {
        try {
            ArrayList<KhuyenMaiDTO> arr = docKM();
            for (int i = 0; i < arr.size(); i++) {
                if (arr.get(i).getMaKM().equals(km.getMaKM())) {
                    JOptionPane.showMessageDialog(null, "Mã khuyến mãi đã tồn tại");
                    return false;
                } else {
                    return true;
                }
            }
        } catch (Exception e) {
            return true;
        }
        return true;
    }

    public int themKM(KhuyenMaiDTO km) {
        if (isValidtoAdd(km)) {
            int res = 0;
            try {
                String qry = "insert into khuyenmai values ('" + km.getMaKM() + "','" + km.getTenChuongTrinh() + "','" + km.getLoaiChuongTrinh() + "','" + km.getNgayBDKM() + "','" + km.getNgayKTKM() + "'," + km.getPhanTramGiamGia() + ")";
                res = my.executeUpdate(qry);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Lỗi khi thêm khuyến mãi");
            }
            return res;
        }
        return 0;
    }

    public int suaKM(KhuyenMaiDTO km) {
        int res = 0;
        try {
            String qry = "update khuyenmai set TenCT='" + km.getTenChuongTrinh() + "', LoaiCT='" + km.getLoaiChuongTrinh() + "', NgayBDKM='" + km.getNgayBDKM() + "', NgayKTKM='" + km.getNgayKTKM() + "', PhanTramGG=" + km.getPhanTramGiamGia() + " where MaKm='" + km.getMaKM() + "'";
            res = my.executeUpdate(qry);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi khi sửa khuyến mãi!");
        }
        return res;
    }
}

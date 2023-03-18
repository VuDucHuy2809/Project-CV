package BUS;

import DAO.ChiTietHoaDonDAO;
import DTO.ChiTietHoaDonDTO;
import DTO.SanPhamDTO;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import javax.swing.JOptionPane;

public class ChiTietHoaDonBUS {

    public static ArrayList<ChiTietHoaDonDTO> listcthd;

    public ChiTietHoaDonBUS() {
    }

    public ArrayList<ChiTietHoaDonDTO> docCTHD() {
        ChiTietHoaDonDAO data = new ChiTietHoaDonDAO();
        try {
            listcthd = new ArrayList<>();
            listcthd = data.docCTHD();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listcthd;
    }

    public int themCTHD(ChiTietHoaDonDTO ct) throws Exception {
        ChiTietHoaDonDAO data = new ChiTietHoaDonDAO();
        int check = data.themCTHD(ct);
        if (check == 1) {
            listcthd.add(ct);
        }
        return check;
    }

    public int suaCTHD(ChiTietHoaDonDTO ct, int i) {
        ChiTietHoaDonDAO data = new ChiTietHoaDonDAO();
        int check = data.SuaCTHD(ct);
        if (check == 1) {
            listcthd.set(i, ct);
        }
        return check;
    }

    public Vector loadcb_hd() {
        ChiTietHoaDonDAO data = new ChiTietHoaDonDAO();
        Vector cbMa = data.docMahd();
        return cbMa;
    }

    public Vector loadcb_sanpham() {
        ChiTietHoaDonDAO data = new ChiTietHoaDonDAO();
        Vector cbMa = data.docMaSP();
        return cbMa;
    }

    public ArrayList<ChiTietHoaDonDTO> timKiemCTHD(String key, String query) {
        ArrayList<ChiTietHoaDonDTO> temp = new ArrayList<>();
        ChiTietHoaDonDAO data = new ChiTietHoaDonDAO();
        try {
            ArrayList<ChiTietHoaDonDTO> hd = data.docCTHD();
            if (key.equals("Mã hóa đơn")) {
                for (int i = 0; i < hd.size(); i++) {
                    if (hd.get(i).getMaHD().toLowerCase().equals(query)) {
                        temp.add(hd.get(i));
                    }
                }
                return temp;
            }
            if (key.equals("Mã sản phẩm")) {
                for (int i = 0; i < hd.size(); i++) {
                    if (hd.get(i).getMaSP().toLowerCase().equals(query)) {
                        temp.add(hd.get(i));
                    }
                }
                return temp;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<ChiTietHoaDonDTO> timkiemCTHDnc(String key, String value1, String value2) {
        ArrayList<ChiTietHoaDonDTO> temp = new ArrayList<>();
        ChiTietHoaDonDAO data = new ChiTietHoaDonDAO();
        try {
            ArrayList<ChiTietHoaDonDTO> hd = data.docCTHD();
            if (key.equals("Đơn giá")) {
                for (int i = 0; i < hd.size(); i++) {
                    if ((Double.parseDouble(value2) >= hd.get(i).getDonGia() && value1.equals(""))
                            || (Double.parseDouble(value1) <= hd.get(i).getDonGia() && Double.parseDouble(value2) >= hd.get(i).getDonGia())
                            || (Double.parseDouble(value1) <= hd.get(i).getDonGia() && value2.equals(""))) {
                        temp.add(hd.get(i));
                    }
                }
            }
            if (key.equals("Thành tiền")) {
                for (int i = 0; i < hd.size(); i++) {
                    if ((Double.parseDouble(value2) >= hd.get(i).getThanhTien() && value1.equals(""))
                            || (Double.parseDouble(value1) <= hd.get(i).getThanhTien() && Double.parseDouble(value2) >= hd.get(i).getThanhTien())
                            || (Double.parseDouble(value1) <= hd.get(i).getThanhTien() && value2.equals(""))) {
                        temp.add(hd.get(i));
                    }
                }
                return temp;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return temp;
    }

    public int getSLct(String mahd, String MaSP) {
        ChiTietHoaDonDAO data = new ChiTietHoaDonDAO();
        int check = data.getSLct(mahd, MaSP);
        return check;
    }

    public double getgiamgiaCTKM(String MaSP, String makm) {
        ChiTietHoaDonDAO data = new ChiTietHoaDonDAO();
        double check = data.getgiamgiaCTKM(MaSP, makm);
        return check;
    }

    public double getTienGGHdfromCTHD(String mahd) {
        ChiTietHoaDonDAO data = new ChiTietHoaDonDAO();
        double tiengiamgia2 = data.getTienGGHdfromCTHD(mahd);
        return tiengiamgia2;
    }

    public double getTongtienfromCTHD(String mahd) {
        ChiTietHoaDonDAO data = new ChiTietHoaDonDAO();
        double tongtien = data.getTongtienfromCTHD(mahd);
        return tongtien;
    }
}

package BUS;

import DAO.HoaDonDAO;
import DTO.HoaDonDTO;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import javax.swing.JOptionPane;

public class HoaDonBUS {
    public static ArrayList<HoaDonDTO> list;
    public HoaDonBUS() {}
    public ArrayList<HoaDonDTO> docHD() {
        HoaDonDAO data = new HoaDonDAO();
        try {
                list = new ArrayList<HoaDonDTO>();
                list = data.docHD();
        } catch (Exception e) {
            e.printStackTrace();}
        return list;
    }

    public int themHD(HoaDonDTO hd) {
        HoaDonDAO data = new HoaDonDAO();
        int check = data.themHD(hd);
        if (check == 1) {
            list.add(hd);}
        return check;
    }

    public int suaHD(HoaDonDTO hd, int i) {
        HoaDonDAO data = new HoaDonDAO();
        int check = data.suaHD(hd);
        if (check == 1) {
            list.set(i, hd);}
        return check;
    }

    public ArrayList<HoaDonDTO> timKiemHD(String key, String query) {
        ArrayList<HoaDonDTO> temp = new ArrayList<>();
        HoaDonDAO data = new HoaDonDAO();
        try {
            ArrayList<HoaDonDTO> hd = data.docHD();
            if (key.equals("Mã hóa đơn")) {
                for (int i = 0; i < hd.size(); i++) {
                    if (hd.get(i).getMaHD().toLowerCase().equals(query)) {
                        temp.add(hd.get(i));}
                }
                return temp;
            }
            if (key.equals("Mã nhân viên")) {
                for (int i = 0; i < hd.size(); i++) {
                    if (hd.get(i).getMaNV().toLowerCase().equals(query)) {
                        temp.add(hd.get(i));}
                }
                return temp;
            }
            if (key.equals("Mã khách hàng")) {
                for (int i = 0; i < hd.size(); i++) {
                    if (hd.get(i).getMaKH().toLowerCase().equals(query)) {
                        temp.add(hd.get(i));}
                }
                return temp;
            }
            if (key.equals("Mã khuyến mãi")) {
                for (int i = 0; i < hd.size(); i++) {
                    if (hd.get(i).getMaKM().toLowerCase().equals(query)) {
                        temp.add(hd.get(i));}
                }
                return temp;
            }
        } catch (Exception e) {
            e.printStackTrace();}
        return null;
    }
    public ArrayList<HoaDonDTO> timkiemHDnc(String key, String value1, String value2)  {
        ArrayList<HoaDonDTO> temp = new ArrayList<>();
        HoaDonDAO data = new HoaDonDAO();
        try {
            ArrayList<HoaDonDTO> hd = data.docHD();
            if (key.equals("Tổng tiền")) {
                for (int i = 0; i<hd.size(); i++){
                    if ((Double.parseDouble(value2)>=hd.get(i).getTongtien() && value1.equals(""))
                            || (Double.parseDouble(value1) <= hd.get(i).getTongtien() && Double.parseDouble(value2) >= hd.get(i).getTongtien())
                            || (Double.parseDouble(value1)<=hd.get(i).getTongtien() && value2.equals(""))){
                    temp.add(hd.get(i));}
                }
            }
            if (key.equals("Tiền giảm giá")) {
                for (int i = 0; i < hd.size(); i++) {
                if ((Double.parseDouble(value2)>=hd.get(i).getTienGiamGia()&& value1.equals(""))
                        || (Double.parseDouble(value1) <= hd.get(i).getTienGiamGia()&& Double.parseDouble(value2) >= hd.get(i).getTienGiamGia())
                        || (Double.parseDouble(value1)<=hd.get(i).getTienGiamGia()&& value2.equals(""))){
                        temp.add(hd.get(i));}
                    }
                return temp;
           }
        }catch (Exception e){
            e.printStackTrace();}
        return temp;
    }
    public Date FormatofDate(String str) throws ParseException{
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        format.setLenient(true);
        Date date = format.parse(str);
        return date;
    }    
    public ArrayList<HoaDonDTO> timtheoNgay(String from,String to){
        ArrayList<HoaDonDTO> arr = new ArrayList<HoaDonDTO>();
        try{
            for(HoaDonDTO hd: docHD()){
                if(FormatofDate(hd.getNgayXuat()).compareTo(FormatofDate(from))>= 0 
                        && FormatofDate(hd.getNgayXuat()).compareTo(FormatofDate(to))<=0)
                    arr.add(hd);
            }
        }catch(Exception e){
            e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Không thể tìm được ngày");}
        return arr;
    }
    public Vector loadcb_nv(){
        HoaDonDAO data= new HoaDonDAO();
        Vector cbMa= data.docManv();
        return cbMa;
    }
    public Vector loadcb_kh(){
        HoaDonDAO data= new HoaDonDAO();
        Vector cbMa= data.docMakh();
        return cbMa;
    }
    public Vector loadcb_km(){
        HoaDonDAO data= new HoaDonDAO();
        Vector cbMa= data.docMakm();
        return cbMa;
    }
   public double getTongtienfromHD(String mahd){
        HoaDonDAO data = new HoaDonDAO();
        double tongtien = data.getTongtienfromHD(mahd);
        return tongtien;     
    }
   public int changeThanhtien_afterdec(String mahd,double thanhtien){
        HoaDonDAO data = new HoaDonDAO();
        int check = data.changeThanhtien_afterdec(mahd,thanhtien);
        return check;    
   }
   public double getTienGGHdfromHD(String mahd){
        HoaDonDAO data = new HoaDonDAO();
        double tiengiamgia1 = data.getTienGGHdfromHD(mahd);
        return tiengiamgia1;      
   }
   public int changeMaKM(HoaDonDTO hd){
        HoaDonDAO data = new HoaDonDAO();
        int check = data.changeMaKM(hd);
        return check;    
   }
   public int changeTienGGHd_afterdone(String mahd,double tongtiengiam){
        HoaDonDAO data = new HoaDonDAO();
        int check = data.changeTienGGHd_afterdone(mahd,tongtiengiam);
        return check;    
   }
    public int changeTongtienHDfromCT(String mahd,double tongtien,double thanhtien,double giamgia){
        HoaDonDAO data = new HoaDonDAO();
        int check = data.changeTongtienHDfromCT(mahd,tongtien,thanhtien,giamgia);
        return check;     
    }   
    public String getMaKmfromHD(String mahd){
        HoaDonDAO data = new HoaDonDAO();
        String makm = data.getMaKmfromHD(mahd);
        return makm;
    }
    
}

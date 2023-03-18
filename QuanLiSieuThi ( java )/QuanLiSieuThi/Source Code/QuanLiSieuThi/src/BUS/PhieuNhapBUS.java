
package BUS;

import DAO.PhieuNhapDAO;
import DTO.PhieuNhapDTO;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import javax.swing.JOptionPane;

public class PhieuNhapBUS {
    public static ArrayList<PhieuNhapDTO> list;    
    public PhieuNhapBUS(){}
    public ArrayList<PhieuNhapDTO> docPn(){
        PhieuNhapDAO data = new PhieuNhapDAO();
        try{
            list = new ArrayList<PhieuNhapDTO>();
            list = data.docPn();
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public int themPn(PhieuNhapDTO pn){
        PhieuNhapDAO data = new PhieuNhapDAO();
        int check = data.themPn(pn);
        if(check==1)
            list.add(pn);
        return check;
    }
    public int suaPn(PhieuNhapDTO pn,int i){
        PhieuNhapDAO data = new PhieuNhapDAO();
        int check = data.suaPn(pn);
        if(check ==1)
            list.set(i,pn);
        return check;
    }
    public Date FormatofDate(String str) throws ParseException{
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        format.setLenient(true);
        Date date = format.parse(str);
        return date;
    }    
    public ArrayList<PhieuNhapDTO> timkiemHDnc(String key, String value1, String value2)  {
        ArrayList<PhieuNhapDTO> temp = new ArrayList<>();
        PhieuNhapDAO data = new PhieuNhapDAO();
        try {
            ArrayList<PhieuNhapDTO> pn = data.docPn();
            if (key.equals("Thành tiền")) {
                for (int i = 0; i<pn.size(); i++){
                    if ((Double.parseDouble(value2)>=pn.get(i).getThanhTien() && value1.equals(""))
                            || (Double.parseDouble(value1) <= pn.get(i).getThanhTien() && Double.parseDouble(value2) >= pn.get(i).getThanhTien())
                            || (Double.parseDouble(value1)<=pn.get(i).getThanhTien() && value2.equals(""))){
                    temp.add(pn.get(i));}
                }
            }
        }catch (Exception e){
            e.printStackTrace();}
        return temp;
    }
    public ArrayList<PhieuNhapDTO> timTheoNgay(String from,String to){
        ArrayList<PhieuNhapDTO> arr = new ArrayList<PhieuNhapDTO>();
        try{
            for(PhieuNhapDTO pn: docPn()){
                if(FormatofDate(pn.getNgayNhap()).compareTo(FormatofDate(from))>= 0 
                        && FormatofDate(pn.getNgayNhap()).compareTo(FormatofDate(to))<=0)
                    arr.add(pn);
            }
        }catch(Exception e){
            e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Không thể tìm được ngày");}
        return arr;
    }
    public ArrayList<PhieuNhapDTO> timkiem(String key, String query) {
        ArrayList<PhieuNhapDTO> temp = new ArrayList<>();
        PhieuNhapDAO data = new PhieuNhapDAO();
        try{
        ArrayList<PhieuNhapDTO> pn = data.docPn();
        if (key.equals("Mã phiếu nhập")) {
            for (int i = 0; i < pn.size(); i++) {
                if (pn.get(i).getMaPN().toLowerCase().equals(query)) {
                    temp.add(pn.get(i));
                }

            }
            return temp;
        }
        if (key.equals("Mã nhân viên")) {
            for (int i = 0; i < pn.size(); i++) {
                if (pn.get(i).getMaNV().toLowerCase().equals(query)) {
                    temp.add(pn.get(i));
                }

            }
            return temp;
        }
        if (key.equals("Mã nhà sản xuất")) {
            for (int i = 0; i < pn.size(); i++) {
                if (pn.get(i).getMaNSX().toLowerCase().equals(query)) {
                    temp.add(pn.get(i));
                }
            }
            return temp;}
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public Vector loadcb_nv(){
        PhieuNhapDAO data= new PhieuNhapDAO();
        Vector cbMa= data.docManv();
        return cbMa;
    }
    public Vector loadcb_nsx(){
        PhieuNhapDAO data= new PhieuNhapDAO();
        Vector cbMa= data.docManxb();
        return cbMa;
    }
    public double getThanhtienPnfromPN(String mapn){ 
        PhieuNhapDAO data= new PhieuNhapDAO(); 
        double thanhtien = data.getThanhtienPnfromPN(mapn);
        return thanhtien;
    }   
    public int changeThanhtien_afterdec(String mapn,double thanhtien){
        PhieuNhapDAO data= new PhieuNhapDAO(); 
        int check = data.changeThanhtien_afterdec(mapn, thanhtien);
        return check;
    }
}

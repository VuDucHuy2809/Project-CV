
package BUS;

import DAO.ChiTietPhieuNhapDAO;
import DTO.ChiTietPhieuNhapDTO;
import java.util.ArrayList;
import java.util.Vector;

public class ChiTietPhieuNhapBUS {
    public static ArrayList<ChiTietPhieuNhapDTO> listctpn;
    public ChiTietPhieuNhapBUS(){}
    public ArrayList<ChiTietPhieuNhapDTO> docCTPN(){
        ChiTietPhieuNhapDAO data = new ChiTietPhieuNhapDAO();
        try{
            listctpn = new ArrayList<>();
            listctpn = data.docCTPN();
        }catch (Exception e){
            e.printStackTrace();}
        return listctpn;
    }
    public int themCTPN(ChiTietPhieuNhapDTO ctpn) throws Exception{
        ChiTietPhieuNhapDAO data = new ChiTietPhieuNhapDAO();
        int check = data.themCTPn(ctpn);
        if(check==1)
            listctpn.add(ctpn);
        return check;
    }
    public int suaCTPN(ChiTietPhieuNhapDTO ctpn,int i){
        ChiTietPhieuNhapDAO data = new ChiTietPhieuNhapDAO();
        int check = data.suaCTPn(ctpn);
        if(check ==1)
            listctpn.set(i,ctpn);
        return check;
    }
    public ArrayList<ChiTietPhieuNhapDTO> timkiemPNnc(String key, String value1, String value2)  {
        ArrayList<ChiTietPhieuNhapDTO> temp = new ArrayList<>();
        ChiTietPhieuNhapDAO data = new ChiTietPhieuNhapDAO();
        try {
            ArrayList<ChiTietPhieuNhapDTO> ctpn = data.docCTPN();
            if (key.equals("Đơn giá")) {
                for (int i = 0; i< ctpn.size(); i++){
                    if ((Double.parseDouble(value2)>= ctpn.get(i).getDonGia() && value1.equals(""))
                        || (Double.parseDouble(value1) <= ctpn.get(i).getDonGia() 
                        && Double.parseDouble(value2) >= ctpn.get(i).getDonGia())
                        || (Double.parseDouble(value1) <= ctpn.get(i).getDonGia() && value2.equals(""))){
                    temp.add(ctpn.get(i));}
                }
            }            
            if (key.equals("Thành tiền")) {
                for (int i = 0; i< ctpn.size(); i++){
                    if ((Double.parseDouble(value2)>= ctpn.get(i).getThanhTien_CT() && value1.equals(""))
                            || (Double.parseDouble(value1) <= ctpn.get(i).getThanhTien_CT()
                            && Double.parseDouble(value2) >= ctpn.get(i).getThanhTien_CT())
                            || (Double.parseDouble(value1)<= ctpn.get(i).getThanhTien_CT() && value2.equals(""))){
                    temp.add(ctpn.get(i));}
                }
            }
        }catch (Exception e){
            e.printStackTrace();}
        return temp;
    }
    
    public ArrayList<ChiTietPhieuNhapDTO> timkiem(String key, String query) {
        ArrayList<ChiTietPhieuNhapDTO> temp = new ArrayList<>();
        ChiTietPhieuNhapDAO data = new ChiTietPhieuNhapDAO();
        try{
        ArrayList<ChiTietPhieuNhapDTO> ctpn = data.docCTPN();
        if (key.equals("Mã phiếu nhập")) {
            for (int i = 0; i < ctpn.size(); i++) {
                if (ctpn.get(i).getMaPN().toLowerCase().equals(query)) {
                    temp.add(ctpn.get(i));
                }
            }
            return temp;}
        if (key.equals("Mã sản phẩm")) {
            for (int i = 0; i < ctpn.size(); i++) {
                if (ctpn.get(i).getMaSP().toLowerCase().equals(query)) {
                    temp.add(ctpn.get(i));
                }

            }
            return temp;}
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public Vector loadcb_pn(){
        ChiTietPhieuNhapDAO data = new ChiTietPhieuNhapDAO();
        Vector cbMa= data.docMapn();
        return cbMa;
    }
    public Vector loadcb_sanpham(){
        ChiTietPhieuNhapDAO data = new ChiTietPhieuNhapDAO();
        Vector cbMa= data.docMaSP();
        return cbMa;
    }
    public int getSLct(String mapn,String MaSP){
        ChiTietPhieuNhapDAO data = new ChiTietPhieuNhapDAO();
        int check = data.getSLct(mapn, MaSP);
        return check;
    }
    public double getThanhTienPnfromCTPN(String mapn){
        ChiTietPhieuNhapDAO data = new ChiTietPhieuNhapDAO();        
        double thanhtienpn = data.getThanhTienPnfromCTPN(mapn);
        return thanhtienpn;
    }
    
}

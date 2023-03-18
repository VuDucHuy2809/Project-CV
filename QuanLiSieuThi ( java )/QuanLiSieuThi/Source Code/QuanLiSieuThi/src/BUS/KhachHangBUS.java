
package BUS;

import DAO.KhachHangDAO;
import DTO.KhachHangDTO;
import java.util.ArrayList;

public class KhachHangBUS {
    public static ArrayList<KhachHangDTO> list;    
    public KhachHangBUS(){}
    public ArrayList<KhachHangDTO> docKh(){
        KhachHangDAO data = new KhachHangDAO();
        try{
            list = new ArrayList<KhachHangDTO>();
            list = data.docKh();
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public int themKh(KhachHangDTO kh){
        KhachHangDAO data = new KhachHangDAO();
        int check = data.themKh(kh);
        if(check==1)
            list.add(kh);
        return check;
    }
    public int suaKh(KhachHangDTO kh,int i){
        KhachHangDAO data = new KhachHangDAO();
        int check = data.suaKh(kh);
        if(check ==1)
            list.set(i,kh);
        return check;
    }
    public ArrayList<KhachHangDTO> timkiemtongquan(String tim){
        ArrayList<KhachHangDTO> find = new ArrayList<>();
        for(KhachHangDTO kh: list){
            if (  kh.getMaKH().trim().toLowerCase().contains(tim.trim().toLowerCase())
               || kh.getHoKH().trim().toLowerCase().contains(tim.trim().toLowerCase())
               || kh.getTenKH().trim().toLowerCase().contains(tim.trim().toLowerCase())
               || kh.getsDTKH().trim().toLowerCase().contains(tim.trim().toLowerCase())
               || kh.getDiaChiKH().trim().toLowerCase().contains(tim.trim().toLowerCase()))
                find.add(kh);
        }
        return find; 
    }    
}

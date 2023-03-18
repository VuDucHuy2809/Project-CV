
package BUS;

import DAO.LoaiSanPhamDAO;
import DTO.LoaiSanPhamDTO;
import java.util.ArrayList;

public class LoaiSanPhamBUS {
    public static ArrayList<LoaiSanPhamDTO> list;    
    public LoaiSanPhamBUS(){}
    public ArrayList<LoaiSanPhamDTO> docTl(){
        LoaiSanPhamDAO data = new LoaiSanPhamDAO();
        try{
            list = new ArrayList<LoaiSanPhamDTO>();
            list = data.docTl();
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public int themTl(LoaiSanPhamDTO tl){
        LoaiSanPhamDAO data = new LoaiSanPhamDAO();
        int check = data.themTl(tl);
        if(check==1)
            list.add(tl);
        return check;
    }
    public int suaTl(LoaiSanPhamDTO tl,int i){
        LoaiSanPhamDAO data = new LoaiSanPhamDAO();
        int check = data.suaTl(tl);
        if(check ==1)
            list.set(i,tl);
        return check;
    }

    public static ArrayList<LoaiSanPhamDTO> timkiemTl(String key, String query) {
        ArrayList<LoaiSanPhamDTO> temp = new ArrayList<>();
        LoaiSanPhamDAO data = new LoaiSanPhamDAO();
        try{
        ArrayList<LoaiSanPhamDTO> tl = data.docTl();
        if (key.equals("Mã loại")) {
            for (int i = 0; i < tl.size(); i++) {
                if (tl.get(i).getMaLoai().toLowerCase().equals(query)) {
                    temp.add(tl.get(i));
                }

            }
            return temp;
        }
        if (key.equals("Tên loại")) {
            for (int i = 0; i < tl.size(); i++) {
                if (tl.get(i).getTenLoai().toLowerCase().equals(query)) {
                    temp.add(tl.get(i));
                }

            }
            return temp;
        }      
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;

    }        
}

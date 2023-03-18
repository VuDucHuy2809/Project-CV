
package BUS;

import DAO.NhaSanXuatDAO;
import DTO.NhaSanXuatDTO;
import java.util.ArrayList;

public class NhaSanXuatBUS {
    public static ArrayList<NhaSanXuatDTO> list;    
    public NhaSanXuatBUS(){}
    public ArrayList<NhaSanXuatDTO> docNSX(){
        NhaSanXuatDAO data = new NhaSanXuatDAO();
        try{
            list = new ArrayList<NhaSanXuatDTO>();
            list = data.docNSX();
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public int themNSX(NhaSanXuatDTO NSX){
        NhaSanXuatDAO data = new NhaSanXuatDAO();
        int check = data.themNSX(NSX);
        if(check==1)
            list.add(NSX);
        return check;
    }
    public int suaNSX(NhaSanXuatDTO NSX,int i){
        NhaSanXuatDAO data = new NhaSanXuatDAO();
        int check = data.suaNSX(NSX);
        if(check ==1)
            list.set(i,NSX);
        return check;
    }
    public int xoaNSX(int i){
        NhaSanXuatDAO data = new NhaSanXuatDAO();
        NhaSanXuatDTO NSX = new NhaSanXuatDTO();
        NSX = list.get(i);
        int check = data.xoaNSX(NSX.getMaNSX());
        if(check == 1)
            list.remove(i);
        return check;
    }
    public static ArrayList<NhaSanXuatDTO> timkiemNSX(String key, String query) {
        ArrayList<NhaSanXuatDTO> temp = new ArrayList<>();
        NhaSanXuatDAO data = new NhaSanXuatDAO();
        try{
        ArrayList<NhaSanXuatDTO> NSX = data.docNSX();
        if (key.equals("Mã nhà sản xuất")) {
            for (int i = 0; i < NSX.size(); i++) {
                if (NSX.get(i).getMaNSX().toLowerCase().equals(query)) {
                    temp.add(NSX.get(i));
                }

            }
            return temp;
        }
        if (key.equals("Tên nhà sản xuất")) {
            for (int i = 0; i < NSX.size(); i++) {
                if (NSX.get(i).getTenNSX().toLowerCase().contains(query)) {
                    temp.add(NSX.get(i));
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

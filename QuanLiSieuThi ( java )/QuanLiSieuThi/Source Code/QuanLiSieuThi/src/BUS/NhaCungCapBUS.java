
package BUS;

import DAO.NhaCungCapDAO;
import DTO.NhaCungCapDTO;
import java.util.ArrayList;

public class NhaCungCapBUS {
    public static ArrayList<NhaCungCapDTO> list;    
    public NhaCungCapBUS(){}
    public ArrayList<NhaCungCapDTO> docNcc(){
        NhaCungCapDAO data = new NhaCungCapDAO();
        try{
            list = new ArrayList<NhaCungCapDTO>();
            list = data.docNCC();
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public int themNcc(NhaCungCapDTO ncc){
        NhaCungCapDAO data = new NhaCungCapDAO();
        int check = data.themNCC(ncc);
        if(check==1)
            list.add(ncc);
        return check;
    }
    public int suaNcc(NhaCungCapDTO ncc,int i){
        NhaCungCapDAO data = new NhaCungCapDAO();
        int check = data.suaNCC(ncc);
        if(check ==1)
            list.set(i,ncc);
        return check;
    }

    public static ArrayList<NhaCungCapDTO> timkiemNcc(String key, String query) {
        ArrayList<NhaCungCapDTO> temp = new ArrayList<>();
        NhaCungCapDAO data = new NhaCungCapDAO();
        try{
        ArrayList<NhaCungCapDTO> NCC = data.docNCC();
        if (key.equals("Mã nhà cung cấp")) {
            for (int i = 0; i < NCC.size(); i++) {
                if (NCC.get(i).getMaNCC().toLowerCase().equals(query)) {
                    temp.add(NCC.get(i));
                }

            }
            return temp;
        }
        if (key.equals("Tên nhà cung cấp")) {
            for (int i = 0; i < NCC.size(); i++) {
                if (NCC.get(i).getTenNCC().toLowerCase().equals(query)) {
                    temp.add(NCC.get(i));
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

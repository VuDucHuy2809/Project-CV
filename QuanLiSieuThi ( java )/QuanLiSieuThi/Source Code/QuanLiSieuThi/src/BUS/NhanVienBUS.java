
package BUS;

import DAO.NhanVienDAO;
import DTO.NhanVienDTO;
import java.util.ArrayList;

public class NhanVienBUS {
    public static ArrayList<NhanVienDTO> list;    
    public NhanVienBUS(){}
    public ArrayList<NhanVienDTO> docNv(){
        NhanVienDAO data = new NhanVienDAO();
        try{
            list = new ArrayList<NhanVienDTO>();
            list = data.docNv();
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public int themNv(NhanVienDTO nv){
        NhanVienDAO data = new NhanVienDAO();
        int check = data.themNv(nv);
        if(check==1)
            list.add(nv);
        return check;
    }
    public int suaNv(NhanVienDTO nv,int i){
        NhanVienDAO data = new NhanVienDAO();
        int check = data.suaNv(nv);
        if(check ==1)
            list.set(i,nv);
        return check;
    }    
}

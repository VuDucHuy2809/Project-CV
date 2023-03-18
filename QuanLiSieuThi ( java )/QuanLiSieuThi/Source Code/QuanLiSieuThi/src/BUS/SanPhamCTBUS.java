
package BUS;

import DAO.SanPhamCTDAO;
import DTO.SanPhamDTO;
import java.util.ArrayList;

public class SanPhamCTBUS {
    public static ArrayList<SanPhamDTO> list1;
    public SanPhamCTBUS(){}
    public ArrayList<SanPhamDTO> docSanphamforCT(){
        SanPhamCTDAO data = new SanPhamCTDAO();
        try{
            list1 = new ArrayList<SanPhamDTO>();
            list1 = data.docsanphamforCT();        
        }catch(Exception e){
            e.printStackTrace();
        }
        return list1;
    }
    public int getSLb(String masanpham) {
        SanPhamCTDAO data = new SanPhamCTDAO();
        int check = data.getSLb(masanpham);
        return check;
    }
    public int changeSLb(String masanpham ,int sl) {
        SanPhamCTDAO data = new SanPhamCTDAO();
        int check = data.changeSLb(sl,masanpham);
        return check;
    }    
}

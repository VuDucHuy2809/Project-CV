    
package BUS;

import DAO.ChiTietKhuyenMaiDAO;
import DTO.ChiTietKhuyenMaiDTO;
import com.itextpdf.text.pdf.ArabicLigaturizer;
import java.util.ArrayList;
import java.util.Vector;

public class ChiTietKhuyenMaiBUS {
    public static ArrayList<ChiTietKhuyenMaiDTO> list;
    public ChiTietKhuyenMaiBUS(){}
    public ArrayList<ChiTietKhuyenMaiDTO> docCTKM()
    {
        ChiTietKhuyenMaiDAO data = new ChiTietKhuyenMaiDAO();
        try {
                list = new ArrayList<ChiTietKhuyenMaiDTO>();
                list = data.docCTKM();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return list;
    }
    public ArrayList<ChiTietKhuyenMaiDTO> docCTKMtheoMaKM(String MaKM)
    {
        ChiTietKhuyenMaiDAO data = new ChiTietKhuyenMaiDAO();
        try {
            if (list == null)
            {
                list = new ArrayList<ChiTietKhuyenMaiDTO>();
                list = data.docCTKMtheoMaKM(MaKM);
            } 
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return list;
    }
        public Vector loadcb_MaKM(){
        ChiTietKhuyenMaiDAO data = new ChiTietKhuyenMaiDAO();
        Vector cbMa= data.docMaKM();
        return cbMa;
    }
    public Vector loadcb_MaSP(){
        ChiTietKhuyenMaiDAO data = new ChiTietKhuyenMaiDAO();
        Vector cbMa= data.docMaSP();
        return cbMa;
    }

    public int themCTKM(ChiTietKhuyenMaiDTO ct) {
        ChiTietKhuyenMaiDAO data = new ChiTietKhuyenMaiDAO();
        int check = data.themCTKM(ct);
        if (check == 1)
        {
            //
        }
        return check;
    }
    public int suaCTKM(ChiTietKhuyenMaiDTO ct)
    {
        ChiTietKhuyenMaiDAO data = new ChiTietKhuyenMaiDAO();
        int check = data.suaCTKM(ct);
        if (check == 1)
        {
            //
        }
        return check;
    }
    public ArrayList<ChiTietKhuyenMaiDTO> timkiemCT(String key, String query)
    {
        ArrayList<ChiTietKhuyenMaiDTO> temp = new ArrayList<>();
        ChiTietKhuyenMaiDAO data = new ChiTietKhuyenMaiDAO();
        try{
            ArrayList<ChiTietKhuyenMaiDTO> ct = data.docCTKM();
            if (key.equals("Mã khuyến mãi"))
            {
                for (int i=0; i<ct.size(); i++)
                {
                    if (ct.get(i).getMaKM().contains(query))
                    {
                        temp.add(ct.get(i));
                    }
                }
                return temp;
            }
            if (key.equals("Mã sản phẩm"))
            {
                for (int i=0; i<ct.size(); i++)
                {
                    if (ct.get(i).getMaKM().contains(query))
                    {
                        temp.add(ct.get(i));
                    }
                }
                return temp;
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
}

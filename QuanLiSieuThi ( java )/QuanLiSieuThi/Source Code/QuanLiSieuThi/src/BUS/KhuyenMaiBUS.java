
package BUS;

import DAO.KhuyenMaiDAO;
import DTO.KhuyenMaiDTO;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class KhuyenMaiBUS {
    public static ArrayList<KhuyenMaiDTO> list;
    public KhuyenMaiBUS(){}
    public ArrayList<KhuyenMaiDTO> docKM(){
        KhuyenMaiDAO data = new KhuyenMaiDAO();
        try {
                list = new ArrayList<KhuyenMaiDTO>();
                list = data.docKM();
        }catch (Exception e)
                    {
                    e.printStackTrace();
                    }
        return list;
    }
    public int themKM(KhuyenMaiDTO km) throws Exception
    {
        KhuyenMaiDAO data = new KhuyenMaiDAO();
        int check = data.themKM(km);
        return check;
    }
    public int suaKM(KhuyenMaiDTO km, int i)
    {
        KhuyenMaiDAO data = new KhuyenMaiDAO();
        int check = data.suaKM(km);
        return check;
    }
    public ArrayList<KhuyenMaiDTO> timkiemKM(String key, String query)
    {
        ArrayList<KhuyenMaiDTO> temp = new ArrayList<>();
        KhuyenMaiDAO data = new KhuyenMaiDAO();
        try{
            ArrayList<KhuyenMaiDTO> km = data.docKM();
            if (key.equals("Mã khuyến mãi"))
            {
                for (int i = 0; i < km.size(); i++)
                {
                    if (km.get(i).getMaKM().toLowerCase().contains(query))
                    {
                        temp.add(km.get(i));
                    }
                }
                return temp;
            }
             if (key.equals("Tên Chương Trình"))
            {
                for (int i = 0; i < km.size(); i++)
                {
                    if (km.get(i).getTenChuongTrinh().toLowerCase().contains(query))
                    {
                        temp.add(km.get(i));
                    }
                }
                return temp;
            }
              if (key.equals("Loại chương trình"))
            {
                for (int i = 0; i < km.size(); i++)
                {
                    if (km.get(i).getLoaiChuongTrinh().toLowerCase().contains(query))
                    {
                        temp.add(km.get(i));
                    
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
    public Date FormatofDate(String str) throws ParseException{
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        format.setLenient(true);
        Date date = format.parse(str);
        return date;
    } 
    
    public ArrayList<KhuyenMaiDTO> timkiemKMnc(String value1, String value2)
    {
        ArrayList<KhuyenMaiDTO> arr = new ArrayList<>();
        try{
            for(KhuyenMaiDTO km: docKM()){
                if((FormatofDate(km.getNgayBDKM()).compareTo(FormatofDate(value1))>= 0 
                        && FormatofDate(km.getNgayKTKM()).compareTo(FormatofDate(value2))<=0)
                        || (value1 == null && FormatofDate(km.getNgayKTKM()).compareTo(FormatofDate(value2))<=0)
                        || (value2 == null && FormatofDate(km.getNgayKTKM()).compareTo(FormatofDate(value1))>=0))
                    arr.add(km);
            }
        }catch(Exception e){
            e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Không thể tìm được ngày");}
        return arr;
     }
}


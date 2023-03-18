
package BUS;

import DAO.LoginDAO;
import DTO.LoginDTO;
import DTO.NhanVienDTO;
import java.util.ArrayList;

public class LoginBUS {
    public static ArrayList<LoginDTO> list;
    public static ArrayList<NhanVienDTO> listnv;     
    public LoginBUS(){}
    public ArrayList<LoginDTO> docLogin(){
        LoginDAO data = new LoginDAO();
        try{
            list = new ArrayList<LoginDTO>();
            list = data.docLogin();}
        catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
    
    public String docChucvu(String manv){
        LoginDAO data = new LoginDAO();
        try{
            listnv = new ArrayList<NhanVienDTO>();
            listnv = data.docChucvu(manv);
        }catch(Exception e){
            e.printStackTrace();
        }
        return listnv.get(0).getChucVuNV();
    }

    public boolean kiemtradangnhap(String manv,String password){
    for(LoginDTO lg : docLogin()){
        if(lg.getMaNV().trim().toLowerCase().equals(manv.trim().toLowerCase())){
            if(lg.getPassWord().trim().toLowerCase().equals(password.trim().toLowerCase()))
                    return true;}
                }
            return false;}

    public int kiemtraquanly(String MaNV)
    {
        ArrayList<NhanVienDTO> list = new ArrayList<>();
        NhanVienBUS buslg = new NhanVienBUS();
        list=buslg.docNv();
        for (NhanVienDTO nv : list){
            if (nv.getMaNV().toLowerCase().trim().equals(MaNV.toLowerCase())){
                if (nv.getChucVuNV().toLowerCase().equals("Quản lý".toLowerCase())) 
                    return 1;
                else return 0;}
        }
        return 0;
    }
    public int doiMK(String MaNV, String Pass)
    {
        LoginDAO data = new LoginDAO();
        int check = data.doiMK(MaNV, Pass);
        return check;
    }
    public String getMK(String MaNV) throws Exception
    {
        ArrayList<LoginDTO> list = new ArrayList<>();
        LoginDAO data = new LoginDAO();
        list = data.docLogin();
        for (LoginDTO lg : list)
        {
            if (lg.getMaNV().toLowerCase().trim().equals(MaNV.toLowerCase().trim()))
            {
                return lg.getPassWord();
            }
        }
        return "0";
    }
    
    public boolean kiemTraMK(String MaNV, String Pass) throws Exception
    {
       String mk = getMK(MaNV);
       if (mk.toLowerCase().trim().equals(Pass.toLowerCase().trim()))
           return true;
       return false;     
    }
}

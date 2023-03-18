/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import ChucNangKhac.ChucNang;
import DAO.NhanVienDAO;
import DTO.NhanVien;
import java.util.ArrayList;


public class NhanVienBUS {

    NhanVienDAO nvdao = new NhanVienDAO();

    public ArrayList<NhanVien> getAllData() {
        return nvdao.getAllData();
    }

    public boolean isExistAccount(String user, String pass) {
        ArrayList<NhanVien> data = getAllData();
        for (NhanVien nv : data) {
            if (nv.getUserName().compareTo(user) == 0 && nv.getPassword().compareTo(pass) == 0) {
                return true;
            }
        }
        return false;
    }

    public NhanVien getStaffByUser(String user) {
        ArrayList<NhanVien> data = getAllData();
        for (NhanVien nv : data) {
            if (nv.getUserName().compareTo(user) == 0) {
                return nv;
            }
        }
        return null;
    }

    public NhanVien getStaffById(String user) {
        ArrayList<NhanVien> data = getAllData();
        for (NhanVien nv : data) {
            if (nv.getMaNhanVien().compareTo(user) == 0) {
                return nv;
            }
        }
        return null;
    }

    public boolean isExistId(String text) {
        ArrayList<NhanVien> data = getAllData();
        for (NhanVien nv : data) {
            if (nv.getMaNhanVien().compareTo(text) == 0) {
                return true;
            }
        }
        return false;
    }

    public boolean addNhanVien(NhanVien nv) {
        return nvdao.addNhanVienDao(nv);
    }

    public boolean isExistUser(String text) {
        ArrayList<NhanVien> data = getAllData();
        for (NhanVien nv : data) {
            if (nv.getUserName().compareTo(text) == 0) {
                return true;
            }
        }
        return false;
    }

    public boolean updateStaff(NhanVien nv) {
        return nvdao.updateStaffDao(nv);
    }

    public ArrayList<NhanVien> searchStaffByKey(String input) {
        ArrayList<NhanVien> data = getAllData();
        ArrayList<NhanVien> result = new ArrayList<>();
        for (NhanVien nv : data) {
            if (ChucNang.convertTextToEnglish(nv.getMaNhanVien()).contains(input)) {
                result.add(nv);
                continue;
            }
            if (ChucNang.convertTextToEnglish(nv.getTenNhanVien()).contains(input)) {
                result.add(nv);
                continue;
            }
            if (ChucNang.convertTextToEnglish(nv.getNgaySinh().toString()).contains(input)) {
                result.add(nv);
                continue;
            }
            if (ChucNang.convertTextToEnglish(nv.getDiaChi()).contains(input)) {
                result.add(nv);
                continue;
            }
            if (ChucNang.convertTextToEnglish(nv.getSDT()).contains(input)) {
                result.add(nv);
                continue;
            }
            if (ChucNang.convertTextToEnglish(nv.getQuyen()).contains(input)) {
                result.add(nv);
                continue;
            }
            if (ChucNang.convertTextToEnglish(nv.getUserName()).contains(input)) {
                result.add(nv);
                continue;
            }
            if (ChucNang.convertTextToEnglish(nv.getPassword()).contains(input)) {
                result.add(nv);
                continue;
            }
            if (String.valueOf(nv.isTrangThai()).toLowerCase().equals(input)) {
                result.add(nv);
                continue;
            }
        }
        return result;
    }

    public String getNameById(String maNhanVien) {
        ArrayList<NhanVien> data = getAllData();
        for (NhanVien nv : data) {
            if (nv.getMaNhanVien().compareTo(maNhanVien) == 0) {
                return nv.getTenNhanVien();
            }
        }
        return "";
    }

    public ArrayList<String[]> getDataChar() {
        ArrayList<String[]> result = new ArrayList<>();
        ArrayList<NhanVien> data = getAllData();

        for (NhanVien nv : data) {
            String year = nv.getNgaySinh().toString().substring(0, 4);
            if (isExistYearInArray(result, year)) {
                for (String[] s : result) {
                    if (s[2].compareTo(year) == 0) {
                        s[0] = String.valueOf(Integer.valueOf(s[0]) + 1);
                        break;
                    }
                }
            }
            else{
                String str[] = {"1","Năm",year};
                result.add(str);
            }
        }
        return result;
    }

    private boolean isExistYearInArray(ArrayList<String[]> data, String year) {
        for(String [] s : data){
            if(s[2].compareTo(year) == 0) return true;
        }
        return false;
    }
}

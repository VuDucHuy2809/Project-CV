/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import ChucNangKhac.ChucNang;
import DAO.ChiTietPhieuNhapDAO;
import DAO.GiayDAO;
import DTO.ChiTietPhieuNhap;
import DTO.Giay;
import java.util.ArrayList;


public class GiayBUS {

    GiayDAO giaydao = new GiayDAO();
    ChiTietPhieuNhapDAO ctpndao = new ChiTietPhieuNhapDAO();

    public ArrayList<Giay> getAllData() {
        return giaydao.getAllData();
    }

    public Giay getGiayById(String id) {
        ArrayList<Giay> data = getAllData();
        for (Giay g : data) {
            if (g.getMaGiay().compareTo(id) == 0) {
                return g;
            }
        }
        return null;
    }

    public boolean update(Giay g) {
        return giaydao.updateDao(g);
    }

    public ArrayList<Giay> searchGiayByKey(String input) {
        ArrayList<Giay> data = getAllData();
        ArrayList<Giay> result = new ArrayList<>();
        for (Giay g : data) {
            if (ChucNang.convertTextToEnglish(g.getMaGiay()).contains(input)) {
                result.add(g);
                continue;
            }
            if (ChucNang.convertTextToEnglish(g.getTenGiay()).contains(input)) {
                result.add(g);
                continue;
            }
            if (ChucNang.convertTextToEnglish(g.getMaNSX()).contains(input)) {
                result.add(g);
                continue;
            }
            if (ChucNang.convertTextToEnglish(g.getMaLoai()).contains(input)) {
                result.add(g);
                continue;
            }
            if (ChucNang.convertTextToEnglish(g.getSize()).contains(input)) {
                result.add(g);
                continue;
            }
            if (ChucNang.convertTextToEnglish(g.getMauSac()).contains(input)) {
                result.add(g);
                continue;
            }
            if (ChucNang.convertTextToEnglish(String.valueOf(g.getGiaThanh())).contains(input)) {
                result.add(g);
                continue;
            }
        }
        return result;
    }

    public int getNumberById(String idGiay) {
        ArrayList<Giay> data = getAllData();
        for (Giay g : data) {
            if (g.getMaGiay().compareTo(idGiay) == 0) {
                return g.getSoLuong();
            }
        }
        return 0;
    }

    public String getNameById(String idGiay) {
        ArrayList<Giay> data = getAllData();
        for (Giay g : data) {
            if (g.getMaGiay().compareTo(idGiay) == 0) {
                return g.getTenGiay();
            }
        }
        return "";
    }

    public int getPriceById(String id) {
        ArrayList<Giay> data = getAllData();
        for (Giay g : data) {
            if (g.getMaGiay().compareTo(id) == 0) {
                return g.getGiaThanh();
            }
        }
        return 0;
    }

    public boolean isExistId(String text) {
        ArrayList<Giay> data = getAllData();
        for (Giay g : data) {
            if (g.getMaGiay().compareTo(text) == 0) {
                return true;
            }
        }
        return false;
    }

    public boolean getStatusById(String substring) {
        ArrayList<Giay> data = getAllData();
        for (Giay g : data) {
            if (g.getMaGiay().compareTo(substring) == 0) {
                return g.isTrangThai();
            }
        }
        return false;
    }

    public ArrayList<Giay> addGiayIntoArray(ArrayList<Giay> dataGiay, Giay g) {
        for (Giay giay : dataGiay) {
            if (giay.getMaGiay().compareTo(g.getMaGiay()) == 0) {
                giay.setSoLuong(giay.getSoLuong() + g.getSoLuong());
                return dataGiay;
            }
        }
        dataGiay.add(g);
        return dataGiay;
    }

    public Giay getGiayInAray(ArrayList<Giay> dataGiay, String idG) {
        for (Giay giay : dataGiay) {
            if (giay.getMaGiay().compareTo(idG) == 0) {
                return giay;
            }
        }
        return null;
    }

    public ArrayList<Giay> updateGiayInArray(ArrayList<Giay> dataGiay, Giay g) {
        for (Giay giay : dataGiay) {
            if (giay.getMaGiay().compareTo(g.getMaGiay()) == 0) {
                giay.setTenGiay(g.getTenGiay());
                giay.setMaLoai(g.getMaLoai());
                giay.setMaNSX(g.getMaNSX());
                giay.setMauSac(g.getMauSac());
                giay.setSize(g.getSize());
                giay.setSoLuong(g.getSoLuong());
                return dataGiay;
            }
        }
        return dataGiay;
    }

    public ArrayList<Giay> deleteGiayInArray(ArrayList<Giay> dataGiay, Giay g) {
        for (int i = 0; i < dataGiay.size(); i++) {
            if (dataGiay.get(i).getMaGiay().compareTo(g.getMaGiay()) == 0) {
                dataGiay.remove(i);
                return dataGiay;
            }
        }
        return dataGiay;
    }

    public boolean addGiayFromReceipt(ArrayList<Giay> dataGiay, String maPhieuNhap) {
        //Them CTPN
        for (Giay giay : dataGiay) {
            if (isExistId(giay.getMaGiay()) && ctpndao.addDetail(new ChiTietPhieuNhap(maPhieuNhap, giay.getMaGiay(), giay.getSoLuong())) == false) {
                return false;
            }
            //Cong sl vao kho
            //Neu chua ton tai
            if (isExistId(giay.getMaGiay())) {
                if (giaydao.updateNumber(giay.getMaGiay(), getNumberById(giay.getMaGiay()) + giay.getSoLuong()) == false) {
                    return false;
                }

            }
            else{
                if(giaydao.addGiay(giay) == false){
                    return false;
                }
            }
        }
        return true;
    }

    public ArrayList<String[]> getDataChar() {
        ArrayList<Giay> data = getAllData();
        ArrayList<String []> result = new ArrayList<>();
        
        for(Giay g : data){
            String []str = {
                g.getTenGiay(),
                String.valueOf(g.getSoLuong())
            };
            result.add(str);
        }
        return result;
    }
}

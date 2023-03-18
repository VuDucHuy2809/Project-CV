/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChucNangKhac;

import BUS.NhanVienBUS;
import DTO.NhanVien;
import com.mysql.cj.result.Row;
import java.awt.FileDialog;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import javafx.util.converter.LocalDateStringConverter;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadExcel {

    FileDialog fd = new FileDialog(new JFrame(), "Đọc excel", FileDialog.LOAD);
    final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    NhanVienBUS nvbus = new NhanVienBUS();

    private String getFile() {
        fd.setFile("*.xls");
        fd.setVisible(true);
        String url = fd.getDirectory() + fd.getFile();
        if (url.equals("nullnull")) {
            return null;
        }
        return url;
    }
    
    public void readExcelStaff(){
        int countadd = 0;
        int countOverride = 0;
        int countCancel = 0;
        int countError = 0;
        ArrayList<NhanVien> data = nvbus.getAllData();
        ArrayList<NhanVien> readExcel = new ArrayList<>();
        
        fd.setTitle("Nhập dữ liệu nhân viên từ excel");
        String url = getFile();
        if (url == null) {
            return;
        }
        FileInputStream inputStream = null;
        try {
            Workbook workbook = WorkbookFactory.create(new File(url));
            Iterator<Sheet> sheetIterator = workbook.sheetIterator();
            Sheet sheet = workbook.getSheetAt(0);
            DataFormatter dataFormatter = new DataFormatter();

            Iterator<org.apache.poi.ss.usermodel.Row> rowIterator = sheet.rowIterator();
            rowIterator.next();
            
            //Doc thong tin 1 nhân viên
            while(rowIterator.hasNext()){
                Object []obj = new Object[10];
                int index = 0;
                org.apache.poi.ss.usermodel.Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                while(cellIterator.hasNext()){
                    Cell cell = cellIterator.next();
                    String value = dataFormatter.formatCellValue(cell);
                    obj[index++] = value;
                }
                
                //Ghi du lieu vao mot khuyenmai
                try {
                    NhanVien nv = new NhanVien(
                            String.valueOf(obj[0]),
                            String.valueOf(obj[1]),
                            LocalDate.parse(String.valueOf(obj[2]), DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                            String.valueOf(obj[3]),
                            String.valueOf(obj[4]),
                            String.valueOf(obj[5]),
                            String.valueOf(obj[6]),
                            String.valueOf(obj[7]),
                            Boolean.valueOf(String.valueOf(obj[8]))
                    );
                    
                    if(nvbus.isExistId(nv.getMaNhanVien()) == false){
                        countadd++;
                        boolean OK = nvbus.addNhanVien(nv);
                        continue;
                    }
                    if(JOptionPane.showConfirmDialog(null,"Nhân Viên đã tồn tại. Bạn có muốn ghi đè không ?" + nv,"",0) == 0){
                        countOverride++;
                        nvbus.updateStaff(nv);
                        continue;
                    }
                    countCancel++;
                            
                    
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Không thể đọc hàng này");
                    countError++;
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Không thể đọc từ file");
            e.printStackTrace();
        }
        String dialog = "Đã thêm mới " + countadd;
        dialog += "\nĐã ghi đè " + countOverride;
        dialog += "\nĐã bỏ qua " + countCancel;
        dialog += "\nLỗi " + countError;
        JOptionPane.showMessageDialog(null, dialog);
    }
}

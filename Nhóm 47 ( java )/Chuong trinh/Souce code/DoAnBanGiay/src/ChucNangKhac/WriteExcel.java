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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.tools.Diagnostic;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;


public class WriteExcel {

    FileDialog fd = new FileDialog(new JFrame(), "Xuất excel", FileDialog.SAVE);

    NhanVienBUS nvbus = new NhanVienBUS();

    private String getFile() {
        fd.setFile("untitled.xls");
        fd.setVisible(true);
        String url = fd.getDirectory() + fd.getFile();
        if (url.equals("null")) {
            return null;
        }
        return url;
    }

    public void WriteStaff() {
        fd.setTitle("Xuất dữ liệu nhà cung cấp ra excel");
        String url = getFile();

        if (url == null) {
            return;
        }

        FileOutputStream outFile = null;
        try {
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("Nhà cung cấp");

            ArrayList<NhanVien> data = nvbus.getAllData();
            int rowNum = 0;
            HSSFRow row = sheet.createRow(rowNum);

            row.createCell(0, CellType.STRING).setCellValue("Mã Nhân Viên");
            row.createCell(1, CellType.STRING).setCellValue("Tên Nhân Viên");
            row.createCell(2, CellType.STRING).setCellValue("Ngày Sinh");
            row.createCell(3, CellType.STRING).setCellValue("Địa Chỉ");
            row.createCell(4, CellType.STRING).setCellValue("SĐT");
            row.createCell(5, CellType.STRING).setCellValue("UserName");
            row.createCell(6, CellType.STRING).setCellValue("Mật Khẩu");
            row.createCell(7, CellType.STRING).setCellValue("Quyền");
            row.createCell(8, CellType.BOOLEAN).setCellValue("Trạng Thái");

            for (NhanVien nv : data) {
                rowNum++;
                row = sheet.createRow(rowNum);
                row.createCell(0, CellType.STRING).setCellValue(nv.getMaNhanVien());
                row.createCell(1, CellType.STRING).setCellValue(nv.getTenNhanVien());
                row.createCell(2, CellType.STRING).setCellValue(nv.getNgaySinh().toString());
                row.createCell(3, CellType.STRING).setCellValue(nv.getDiaChi());
                row.createCell(4, CellType.STRING).setCellValue(nv.getSDT());
                row.createCell(5, CellType.STRING).setCellValue(nv.getUserName());
                row.createCell(6, CellType.STRING).setCellValue(nv.getPassword());
                row.createCell(7, CellType.STRING).setCellValue(nv.getQuyen());
                row.createCell(8, CellType.BOOLEAN).setCellValue(nv.isTrangThai());
            }

            for (int i = 0; i < rowNum; i++) {
                sheet.autoSizeColumn(i);
            }

            File file = new File(url);
            file.getParentFile().mkdirs();
            outFile = new FileOutputStream(file);
            workbook.write(outFile);
            JOptionPane.showMessageDialog(null, "Ghi file thành công: " + file.getAbsolutePath());

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try {
            if (outFile != null) {
                outFile.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

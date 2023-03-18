/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class ConnectionDB {
    private static String URL = "jdbc:mysql://localhost:3306/quanlibangiay?zeroDateTimeBehavior=convertToNull";
    private static String USER = "root";
    private static String PASS = "";
    
    static Connection conn = null;
    static Statement stm = null;
    static ResultSet rs = null;
        
    public static void closeConnection(){
        try {
            if(conn != null){
                conn.close();
            }
            if(stm != null){
                stm.close();
            }
        } catch (Exception e) {
            System.out.println("Không thể đóng kết nối : " + e);
        }
    }
    
    
    public ResultSet sqlExcute(String qry){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL,USER,PASS);
            stm = conn.createStatement();
            rs = stm.executeQuery(qry);
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Không thể kết nối đến server");
        }
        closeConnection();
        return null;
    }
    
    public Boolean sqlUpdate(String qry) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL,USER,PASS);
            stm = conn.createStatement();
            int Result = stm.executeUpdate(qry);
            if(Result == 0) throw new Exception();
        } catch (Exception e) {
            e.printStackTrace();
            closeConnection();
            return false;
        }
        closeConnection();
        return true;
    }
}

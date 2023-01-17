/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scan_manifest.controller;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import scan_manifest.model.LogModel;

/**
 *
 * @author Ratino
 */
public class LogController {
    protected Connection koneksi, koneksi2, koneksi3, koneksi4, koneksi5, koneksi6;
    protected Statement stmt, stmt1, stmt2, stmt3, stmt4, stmt5;
    private LogModel log;
    
    
    public void setConnection() throws SQLException{
        koneksi = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/db_scan_manifest?autoReconnect=true&failOverReadonly=true&maxReconnects=1000", "root", "");
        stmt =  (Statement) koneksi.createStatement();
    }
    
    public void LogController() throws SQLException{
        setConnection();
    }
    
    public void createTable(){
        log = new LogModel(stmt);
        log.createTable(stmt);
    }
    
    public void insertToDatabase(String url){
        
        log = new LogModel(stmt);
        log.insertToDatabase(stmt, url);
//        try {
//            stmt.executeUpdate("LOAD DATA INFILE '"+url+"; INTO TABLE ");
//        } catch (SQLException ex) {
//            Logger.getLogger(LogController.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
    
    public void selectTable(String barcode){
        log = new LogModel(stmt);
        log.selectTableBarcode(stmt, barcode);
    }
    
    
}



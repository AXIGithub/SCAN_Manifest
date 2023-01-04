/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scan_manifest.model;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ratino
 */
public class LogModel extends Connector{
    
    protected Connection koneksi;
    protected Statement stmt;
    
    private ArrayList<String>customer            = new ArrayList<String>(10);
    private ArrayList<Integer>noUrut            = new ArrayList<Integer>(10);
    private ArrayList<Integer>seqAmp            = new ArrayList<Integer>(10);
    
    
    
    public LogModel(Statement stmt){
        this.stmt = stmt;
    }
    
    public void createTable(Statement stmt){
        try {
            stmt.executeUpdate("DROP TABLE IF EXISTS t_manifest");
            stmt.executeUpdate("CREATE TABLE t_manifest (id INT PRIMARY KEY, customer VARCHAR(20) NOT NULL, no INT NOT NULL, "+
                    "seq_amp INT NOT NULL, nopolis INT NOT NULL, barcode_manifest VARCHAR(50) NOT NULLENGINE = MYISAM");
            
        } catch (SQLException ex) {
            Logger.getLogger(LogModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void insertToDatabase(Statement stmt, String url){
        try {
            stmt.executeUpdate("LOAD DATA INFILE '"+url+"' INTO TABLE t_manifest (customer, no, seq_amp, nopolis, barcode_manifest)");
        } catch (SQLException ex) {
            System.out.println("Error Load Data Infile " + url);
            System.out.println(ex.getStackTrace());
            Logger.getLogger(LogModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void selectTableBarcode(Statement stmt, String barcode){
        try {
            ResultSet hasilQuery = null;
            hasilQuery = stmt.executeQuery("SELECT * FROM t_manifest WHERE barcode_manifest '"+barcode+"'");
            
            while(hasilQuery.next()){
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(LogModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

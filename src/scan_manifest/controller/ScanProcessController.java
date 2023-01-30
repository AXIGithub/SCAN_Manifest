/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scan_manifest.controller;

import com.mysql.jdbc.Statement;
import scan_manifest.model.LogModel;

/**
 *
 * @author Ratino
 */
public class ScanProcessController {
    
    protected Statement stmt;
    private LogModel log;
    
    
    
    public void scanProcessManifest(String dirInput, String barcode, String logFile){
        
        log = new LogModel(stmt);
        log.selectTableBarcode(stmt, barcode);
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scan_manifest;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Ratino
 */
public class SCAN_manifest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            // MainFrame mainfream = new MainFrame();
            new MainFrame().setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(SCAN_manifest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}

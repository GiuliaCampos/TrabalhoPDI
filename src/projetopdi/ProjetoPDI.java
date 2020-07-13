/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetopdi;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
import projetopdi.ui.IUPrincipal;

/**
 *
 * @author Giulia
 */
public class ProjetoPDI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        IUPrincipal principal = new IUPrincipal();
        //principal.setSize(1500, 1000);
        principal.setVisible(true);
        principal.setTitle("Trabalho de PDI");
        principal.toFront();
        
        
    }
    
}

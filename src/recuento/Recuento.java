/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recuento;

import Interfaces.Principal;
import javax.swing.JFrame;

/**
 *
 * @author PORTATIL
 */
public class Recuento {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Principal pr= new Principal();
        pr.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        pr.setTitle("Principal");
        pr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pr.setLocationRelativeTo(null);
        pr.setVisible(true);
    
        
    }
    
}

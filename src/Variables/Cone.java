/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Variables;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author PORTATIL
 */
public class Cone {
    
    public Connection conectar() {
        Connection con = null;
        
        try {
            Class.forName("org.h2.Driver");
            con = DriverManager.getConnection("jdbc:h2:file:C:\\Users"
                    + "\\PORTATIL\\Documents\\NetBeansProjects\\Recuento"
                    + "\\src\\Data\\recuento","Miguel","");
//            System.out.print();
        } catch (Exception ex) {
            System.out.print(ex);
        }
        
        return con;
        
    }
    
}

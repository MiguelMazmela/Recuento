/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.text.SimpleDateFormat;
import java.util.Date;



/**
 *
 * @author migue
 */
public class pordia {
   private Date fecha;
   private double h_t;
   private double h;
   private double res;
   private boolean cambia;

    public pordia(Date fecha, double h_t, double h, double res, boolean cambia) {
        this.fecha = fecha;
        this.h_t = h_t;
        this.h = h;
        this.res = res;
        this.cambia = cambia;
    }

    public pordia() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "pordia{" + "fecha=" + fecha + ", h_t=" + h_t + ", h=" + h + ", res=" + res + ", cambia=" + cambia + '}';
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getH_t() {
        return h_t;
    }

    public void setH_t(double h_t) {
        this.h_t = h_t;
    }

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
    }

    public double getRes() {
        return res;
    }

    public void setRes(double res) {
        this.res = res;
    }

    public boolean isCambia() {
        return cambia;
    }

    public void setCambia(boolean cambia) {
        this.cambia = cambia;
    }
    
    public String fechaconformato(String formato){
        SimpleDateFormat formatter = new SimpleDateFormat(formato);
        String fechatxt = formatter.format(fecha);
        return fechatxt;
    }
    
    
   
    
}

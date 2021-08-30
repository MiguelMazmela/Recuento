/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;


import Clases.pordia;
import Variables.Var;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author migue
 */
public class Transferir extends javax.swing.JInternalFrame {

    private final Var wv;

    /**
     * Creates new form Transferir
     *
     * @param tr
     */
    public Transferir(Var tr) {
        initComponents();
        this.wv = tr;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lienzo = new javax.swing.JTextPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setClosable(true);

        jScrollPane1.setViewportView(lienzo);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Validar Fechas  :");

        jButton1.setText("Transferir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Limpiar Lienzo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 374, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 631, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Connection co = wv.getCon();
        String sql_t = "select dfecha_doc, sum(nvalor_venta) "
                + "from historia_t "
                + "GROUP BY EXTRACT(day FROM dfecha_doc)";
//         pordia matpordia[];BETWEEN %2020-03-01% and %2020-03-10% GROUP BY EXTRACT(day FROM `dfecha_doc`) 
        String res = "";
//        Date fech;
        boolean entro = false;
//        int diastotalesp = 0;

        try {
            Statement stmt = wv.conectar().createStatement();
            Statement stmt_t = wv.conectar().createStatement();
            ResultSet rs_t = stmt_t.executeQuery(sql_t);
            PreparedStatement stt1=wv.conectar().prepareStatement("SELECT Min(dfecha_doc) FROM historia_t");
            ResultSet rsf = stt1.executeQuery();
            PreparedStatement stt2=wv.conectar().prepareStatement("SELECT Max(dfecha_doc) FROM historia_t");
           
            ResultSet rsff = stt2.executeQuery();
            rsf.next();
            rsff.next();
            String fec = rsf.getNString(1);
            String ff = rsff.getNString(1);
            String sql = "select dfecha_doc, sum(nvalor_venta) from historia WHERE dfecha_documento BETWEEN '"+fec+"' and '"+ff+"' GROUP BY EXTRACT(day FROM dfecha_doc)";
            ResultSet rs = stmt.executeQuery(sql);
            
            String año = fec.substring(0, 4);
            String mes = fec.substring(1, 3);
            int mm = Integer.parseInt(mes);
            int dd = wv.diasDelMes(mm, Integer.parseInt(año));
            int diastotales = wv.diasEntreDosFechas(fec, ff) + 1;
//            diastotalesp=diastotales;
            pordia matpordia[] = new pordia[diastotales];
            java.util.Date finicio = null;
            SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
            try {

                finicio = formatoDelTexto.parse(fec);

            } catch (ParseException ex) {
            }
            for (int a = 0; a < diastotales; a++) {
                pordia po = new pordia();
                java.util.Date diahoy = wv.sumar_dias(finicio, a);
                matpordia[a] = po;
                matpordia[a].setFecha(diahoy);
            }
            dd = 0;
            while (rs.next()) {
                String fdata = rs.getString(1);
                do {
                    String fmat = matpordia[dd].fechaconformato("yyyy-MM-dd");
//                    System.out.print(fmat + "  ");compra.fechaCompra BETWEEN '%" + p_fecha_Desde + "%' AND '%" + p_fecha_Hasta + "%'";
//                    System.out.println(fdata);
                    if (fdata.equalsIgnoreCase(fmat)) {
//                        System.out.println("entro");
                        entro = true;
                        matpordia[dd].setH(rs.getDouble(2));
                        dd++;

                    } else {
                        dd++;
                    }
                } while (!entro);
                entro = false;
            }
            dd = 0;
            while (rs_t.next()) {
                String fdata = rs_t.getString(1);
                do {
                    String fmat = matpordia[dd].fechaconformato("yyyy-MM-dd");
//                    System.out.print(fmat + "  ");
//                    System.out.println(fdata);
                    if (fdata.equalsIgnoreCase(fmat)) {
                        System.out.println(dd);
                        entro = true;
                        matpordia[dd].setH_t(rs_t.getDouble(2));
                        dd++;

                    } else {
                        dd++;
                    }
                } while (!entro);
                entro = false;
            }

            for (int a = 0; a < diastotales; a++) {
                matpordia[a].setRes(matpordia[a].getH() - matpordia[a].getH_t());
                if (matpordia[a].getRes() == 0) {
                    matpordia[a].setCambia(false);
                } else {
                    matpordia[a].setCambia(true);
                    wv.actualiza(matpordia[a].getFecha());
                }
                res = res + matpordia[a].fechaconformato("dd/MM/yyyy") + "  " + matpordia[a].getH() + "\t  " + matpordia[a].getH_t() + "\t "
                        + matpordia[a].getRes() + "\t" + matpordia[a].isCambia() + "\n";

            }

            for (int a = 0; a < diastotales; a++) {
//                matpordia[a].setRes(matpordia[a].getH() - matpordia[a].getH_t());
                if (matpordia[a].isCambia()) {
                    System.out.println("Actualizando :" + matpordia[a].fechaconformato("dd/MM/yyyy"));
                    wv.actualiza(matpordia[a].getFecha());
                }

            }
//            PreparedStatement prest = co.prepareStatement("DELETE FROM `historia_t`");
//            prest.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Transferir.class.getName()).log(Level.SEVERE, null, ex);
        }
        lienzo.setText(res);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        lienzo.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane lienzo;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Variables.Var;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author miguel
 */
public class Carga_chess extends javax.swing.JInternalFrame {

    private final Var v;

    /**
     * Creates new form Carga_chess
     *
     * @param v
     */
    public Carga_chess(Var v) {
        initComponents();
        this.v = v;
        carga_todo();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jScrollPane1.setViewportView(jTextPane1);

        jButton1.setText("Limpiar");

        jButton2.setText("Cargar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(427, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        lee_pantalla();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables

    private void carga_todo() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    private void lee_pantalla() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Date fecha = v.getFecha_operacion();
        String memoria = jTextPane1.getText();
        String filas[] = memoria.split("\\n");
        int tf = filas.length;
        java.sql.Date fechaSQL = new java.sql.Date(fecha.getTime());
        String sql = "insert into sistema_fecha values (?,?,?,?,?,?,?,?,?,?,"//10
                + "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,"//25
                + "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,"//25
                + "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,"//25
                + "?,?,?,?,?,?,?,?,?,?,?,?)";//12
        try {
            PreparedStatement ps = v.getCon().prepareStatement(sql);
            for (int z = 0; z < tf; z++) {
                String columnas[] = filas[z].split("\\t");
                int a = 0;
                ps.setString(1, "");
                ps.setString(2, "");
                ps.setString(3, columnas[0]);
                ps.setString(4, columnas[1]);
                for (a = 5; a < 9; a++) {
                    ps.setString(a, "");
                }
                for (a = 9; a < 18; a++) {
                    ps.setDouble(a, 0.0);
                }
                for (a = 18; a < 42; a++) {
                    ps.setString(a, "");
                }
                for (a = 42; a < 84; a++) {
                    ps.setDouble(a, 0.0);
                }
                for (a = 84; a < 95; a++) {
                    ps.setString(a, "");
                }

                ps.setString(95, columnas[3]);
                ps.setString(96, columnas[5]);
                ps.setDate(97, fechaSQL);

                ps.executeUpdate();

            }
            JOptionPane loadingService = new JOptionPane("Connecting to service. Please wait.");
            loadingService.setVisible(true);
            v.tranfiere_factores(v.txtSqlFecha(fechaSQL));
            
            jTextPane1.setText("Proceso concluido......");
            loadingService.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(Carga_chess.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}

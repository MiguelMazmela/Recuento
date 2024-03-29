/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Variables.Var;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author PORTATIL
 */
public class Cierre_diario extends javax.swing.JInternalFrame {

    private final Var v;

    /**
     * Creates new form Cierre_diario
     *
     * @param v
     */
    public Cierre_diario(Var v) {
        initComponents();
        this.v = v;
        inicio();
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
        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jPanel1.setBackground(new java.awt.Color(0, 204, 0));

        jButton1.setBackground(new java.awt.Color(0, 0, 204));
        jButton1.setText("Cerrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Fecha de recuento");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("fecha de cierre");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Proveedor");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Fecha de Vencimiento desde :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 8, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        cierre();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
//        Carga_lineas();
        if (jComboBox1.getSelectedItem() == null) {

        } else {
            Carga_lineas();
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    private void inicio() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        carga_datos();
        jDateChooser1.setDate(new Date());
        jDateChooser2.setDate(new Date());

    }

    private void carga_datos() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        jComboBox1.removeAllItems();
//        jComboBox2.removeAllItems();
        String sql = "select DISTINCT Fecha_recuento from Recuento_fechas";
        try {
            PreparedStatement ps = v.getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                jComboBox1.addItem(rs.getNString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Borrar_por_fecha.class.getName()).log(Level.SEVERE, null, ex);
        }
        Carga_lineas();
        v.setFecha_recuento_selecionada(jComboBox1.getSelectedItem().toString());
        v.setLina_seleccionada(jComboBox2.getSelectedItem().toString());
        v.setFiltro_carga_tabla("");

    }

    private void Carga_lineas() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String selecion;
        jComboBox2.removeAllItems();
        try {

            selecion = jComboBox1.getSelectedItem().toString();

            String sql1 = "select DISTINCT Cprov_Nom nvarchar from sistema_fecha WHERE Fecha_recuento = '" + selecion + "'";
            PreparedStatement ps3 = v.getCon().prepareStatement(sql1);
            ResultSet rs3 = ps3.executeQuery();

            while (rs3.next()) {
                jComboBox2.addItem(rs3.getNString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Borrar_por_fecha.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void cierre() {
        String ssqll = "select distinct FECHA_DE_CIERRE from cierres where FECHA_DE_CIERRE=? and FECHA_DE_RECUENTO=?";

        double venta = 0.0;
        double saldo = 0.0;
        int secuencia = 0;
        boolean esMenor = false;
        SimpleDateFormat formatodeltexto = new SimpleDateFormat("yyyy-MM-dd");
        String fecha = formatodeltexto.format(jDateChooser1.getDate());
        String IniFechaVencimiento = formatodeltexto.format(jDateChooser2.getDate());
        String sql = "SELECT CART_ID, sum(NCANTIDAD_CONSUMO ) "
                + "FROM HISTORIA "
                + "where DFECHA_DOC ='" + fecha + "' "
                + "and cproveedor like '%" + jComboBox2.getSelectedItem().toString() + "%'"
                + "group by CART_ID";
        if (!ifExists(ssqll, fecha, jComboBox1.getSelectedItem().toString())) {
            try {
                PreparedStatement ps = v.conectar().prepareStatement(sql);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    if (!esMenor) {
                        venta = rs.getDouble(2);

                    }
                    String cod = rs.getNString("CART_ID");
                    String sqls = "SELECT secuencia,CART_ID , CART_NOM,  CART_NOM, TOTAL, SALDO, COMPLETO "
                            + "FROM RECUENTO_FECHAS "
                            + "where FECHA_RECUENTO ='" + jComboBox1.getSelectedItem().toString() + "' "
                            + "and CART_ID ='" + cod + "' "
                            + "and FECHA_DE_VENCIMIENTO>'" + IniFechaVencimiento + "' and not completo "
                            + "order by FECHA_DE_VENCIMIENTO ";

                    PreparedStatement pss = v.conectar().prepareStatement(sqls);

                    ResultSet rss = pss.executeQuery();
                    while (rss.next()) {
                        secuencia = rss.getInt("secuencia");
                        saldo = rss.getDouble("SALDO");
                        if (cod.contains("M0800234")) {
                            System.out.println("inicio venta=" + venta + " saldo=" + saldo);

                        }
//                    if(esMenor){
//                        venta=venta+saldo;
//                    }
                        saldo = saldo - venta;

                        if (saldo < 0.0) {
                            esMenor = true;
                            String sSQL = "UPDATE RECUENTO_FECHAS SET "
                                    + "SALDO=?,COMPLETO=?"
                                    + " WHERE Secuencia=? and Fecha_recuento='" + jComboBox1.getSelectedItem().toString() + "'";

                            PreparedStatement ps2 = v.conectar().prepareStatement(sSQL);
                            ps2.setDouble(1, 0.0);
                            ps2.setBoolean(2, true);
                            ps2.setInt(3, secuencia);
                            ps2.executeUpdate();
                            venta = venta + saldo;
                            System.out.println(cod + " es menor=" + esMenor + " ventas=" + venta + " saldo=" + saldo);
//                        break;
                        } else {
                            esMenor = false;
                            String sSQL = "UPDATE RECUENTO_FECHAS SET "
                                    + "SALDO=?,COMPLETO=?"
                                    + " WHERE Secuencia=? and Fecha_recuento='" + jComboBox1.getSelectedItem().toString() + "'";

                            PreparedStatement ps2 = v.conectar().prepareStatement(sSQL);
                            ps2.setDouble(1, saldo);
                            ps2.setBoolean(2, false);
                            ps2.setInt(3, secuencia);
                            ps2.executeUpdate();

                            if (cod.contains("M0800234")) {
                                System.out.println(cod + " es menor=" + esMenor + " ventas=" + venta + " saldo=" + saldo);
                            }
                            saldo = 0.0;
                            break;
                        }

                    }

                }
                String sqlg = "INSERT INTO CIERRES (PROVEEDOR,FECHA_DE_CIERRE,FECHA_DE_RECUENTO) "
                        + "values ('" + jComboBox2.getSelectedItem().toString() + "', '" + fecha + "','" + jComboBox1.getSelectedItem().toString() + "')";
                PreparedStatement ps3 = v.conectar().prepareStatement(sqlg);
                ps3.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(Cierre_diario.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "el dia ya esta cerrado\n"
                    + "Inténtelo nuevamente.", "Error en la operación",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public boolean ifExists(String sSQL, String fecha, String fecha1) {
        PreparedStatement ps;
        boolean rpta=true;
        try {
            ps = v.conectar().prepareStatement(sSQL);
            ps.setString(1, fecha);
            ps.setString(2, fecha1);
            ResultSet rs = ps.executeQuery();
            rpta= rs.next();

        } catch (SQLException ex) {
            Logger.getLogger(Cierre_diario.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rpta;
    }
}

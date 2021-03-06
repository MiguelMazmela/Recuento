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
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author PORTATIL
 */
public class StockALaFecha extends javax.swing.JInternalFrame {

    private final Var v;

    /**
     * Creates new form StockALaFecha
     *
     * @param v
     */
    public StockALaFecha(Var v) {
        initComponents();
        this.v = v;
        inicia();

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
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jMonthChooser1 = new com.toedter.calendar.JMonthChooser();
        jLabel3 = new javax.swing.JLabel();
        jYearChooser1 = new com.toedter.calendar.JYearChooser();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel2.setBackground(new java.awt.Color(51, 255, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Proveedor  :");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Fecha de recuento ");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel3.setText("Vencimiento a partir de :");

        jButton1.setText("Calcula");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jMonthChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jYearChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jYearChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jMonthChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
        if (jComboBox2.getSelectedItem() == null) {

        } else {
            Carga_lineas();
        }
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        v.setFecha_recuento_selecionada(jComboBox2.getSelectedItem().toString());
        v.setLina_seleccionada(jComboBox1.getSelectedItem().toString());
        v.setFiltro_carga_tabla("");
        carga_tabla_lista();


    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private com.toedter.calendar.JMonthChooser jMonthChooser1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private com.toedter.calendar.JYearChooser jYearChooser1;
    // End of variables declaration//GEN-END:variables

    private void carga_cabeceras() {
        String[] colu = {"CODIGO", "DESCRIPCION", "UNID.SISTEMA", "VENTAS U.S", "TOTAL U.S", "TOTAL CAJAS", "TOTAL DISPLAYS","FECHA PROX"};
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setColumnIdentifiers(colu);

        v.borratabla(modelo);

        DefaultTableCellRenderer tcr;
        TableColumnModel columnModel = jTable1.getColumnModel();
        columnModel.getColumn(1).setPreferredWidth(230);
        columnModel.getColumn(2).setPreferredWidth(80);
        columnModel.getColumn(3).setPreferredWidth(60);
        columnModel.getColumn(4).setPreferredWidth(60);
        columnModel.getColumn(5).setPreferredWidth(60);
        columnModel.getColumn(6).setPreferredWidth(60);
//        columnModel.getColumn(7).setPreferredWidth(75);

        columnModel.getColumn(0).setPreferredWidth(80);
//        columnModel.getColumn(7).setPreferredWidth(60);
//        columnModel.getColumn(8).setPreferredWidth(90);
//        columnModel.getColumn(9).setPreferredWidth(90);
//        columnModel.getColumn(10).setPreferredWidth(90);
//        columnModel.getColumn(11).setPreferredWidth(90);
//        columnModel.getColumn(12).setPreferredWidth(90);
//        columnModel.getColumn(13).setPreferredWidth(90);

        tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.RIGHT); //CENTER o LEFT
        jTable1.getColumnModel().getColumn(2).setCellRenderer(tcr);
        
        jTable1.getColumnModel().getColumn(3).setCellRenderer(tcr);
        jTable1.getColumnModel().getColumn(4).setCellRenderer(tcr);
        jTable1.getColumnModel().getColumn(5).setCellRenderer(tcr);
        jTable1.getColumnModel().getColumn(6).setCellRenderer(tcr);
//        jTable1.getColumnModel().getColumn(8).setCellRenderer(tcr);
        jTable1.setModel(modelo);

    }

    private void inicia() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        carga_cabeceras();
        carga_mandos();
        carga_tabla();

    }

    private void carga_mandos() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        String sql = "";
        DecimalFormat formatea = v.MyFormatter();
        jComboBox1.removeAllItems();
        jComboBox2.removeAllItems();
        try {

            String sql = "select DISTINCT Fecha_recuento from sistema_fecha";
            PreparedStatement ps = v.getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                jComboBox2.addItem(rs.getNString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Borrar_por_fecha.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void Carga_lineas() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String selecion = "";
        jComboBox1.removeAllItems();
        try {

            selecion = jComboBox2.getSelectedItem().toString();

            String sql1 = "select DISTINCT Cprov_Nom nvarchar from sistema_fecha WHERE Fecha_recuento = '" + selecion + "'";
            PreparedStatement ps3 = v.getCon().prepareStatement(sql1);
            ResultSet rs3 = ps3.executeQuery();
            while (rs3.next()) {
                jComboBox1.addItem(rs3.getNString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Borrar_por_fecha.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void carga_tabla() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        v.setFecha_recuento_selecionada(jComboBox2.getSelectedItem().toString());
        v.setLina_seleccionada(jComboBox1.getSelectedItem().toString());
        v.setFiltro_carga_tabla("");
        carga_tabla_lista();

    }

    private void carga_tabla_lista() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        DecimalFormat formatea = v.MyFormatter();
        carga_ventas();
        String sql = "select Cart_Id,Cart_Nom,Nc_Alma10,Nc_Alma11,Nc_Alma4,Nc_Alma5,Nc_Alma6 "
                + "from sistema_fecha "
                + "WHERE Fecha_recuento='" + v.getFecha_recuento_selecionada() + ""
                + "' and Cprov_Nom='" + v.getLina_seleccionada() + "'"
                + " AND Cart_Nom like '%" + v.getFiltro_carga_tabla() + "%'";

//        jLabel7.setText(v.getLina_seleccionada());
//        jLabel9.setText(v.getFecha_recuento_selecionada());
        try {
            PreparedStatement ps = v.getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            DefaultTableModel modelo;
            modelo = (DefaultTableModel) jTable1.getModel();
            v.borratabla(modelo);
            int colu = 7;
            Object[] fila = new Object[colu]; // Hay tres columnas en la tabla
//            DecimalFormat formatea = var.MyFormatter();
            while (rs.next()) {
                fila[0] = rs.getString("Cart_Id");
                fila[1] = rs.getString("Cart_Nom");
                fila[2] = formatea.format(rs.getDouble("Nc_Alma4"));
                fila[3] = formatea.format(rs.getDouble("Nc_Alma5"));
                fila[4] = formatea.format(rs.getDouble("Nc_Alma6"));
                fila[5] = formatea.format(rs.getDouble("Nc_Alma10"));
                fila[6] = formatea.format(rs.getDouble("Nc_Alma11"));
                
                modelo.addRow(fila);
            }
            jTable1.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(Borrar_por_fecha.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sqls = "SELECT SUM(NPREC_CONSUMO*NC_ALMA),SUM(NPREC_CONSUMO*NC_ALMA1) "
                + "FROM SISTEMA_FECHA  "
                + "where fecha_recuento='" + v.getFecha_recuento_selecionada().trim() + "' and  cprov_nom = '" + v.getLina_seleccionada().trim() + "'";
        try {
            PreparedStatement psr = v.conectar().prepareStatement(sqls);
            ResultSet rsr = psr.executeQuery();
            while (rsr.next()) {
                v.setTotalXlinea(rsr.getDouble(1));
                v.setTotal_contado(rsr.getDouble(2));
                v.setTotal_diferencia(v.getTotalXlinea() - v.getTotal_contado());
            }
        } catch (SQLException ex) {
            Logger.getLogger(Recuento_con_fechas.class.getName()).log(Level.SEVERE, null, ex);

        }

        sqls = "SELECT sum (total*nprec_consumo) "
                + "FROM RECUENTO_FECHAS  "
                + "where FECHA_DE_VENCIMIENTO >= '" + v.getFecha_recuento_selecionada().trim() + "' "
                + "and FECHA_RECUENTO='" + v.getFecha_recuento_selecionada().trim() + "' "
                + "and cprov_nom = '" + v.getLina_seleccionada().trim() + "'";

        try {
            PreparedStatement psr = v.conectar().prepareStatement(sqls);
            ResultSet rsr = psr.executeQuery();
            while (rsr.next()) {
                v.setTotal_vencido(rsr.getDouble(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Recuento_con_fechas.class.getName()).log(Level.SEVERE, null, ex);
        }

//        jTextField5.setText(String.valueOf(formatea.format(var.getTotalXlinea())));
//        jTextField6.setText(String.valueOf(formatea.format(var.getTotal_contado())));
//        jTextField7.setText(String.valueOf(formatea.format(var.getTotal_diferencia())));
//        jTextField9.setText(String.valueOf(formatea.format(var.getTotal_vencido())));
//
//        carga_tabla_cuenta();
    }

    private void carga_ventas() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

String mes=""+jMonthChooser1.getMonth();
if(mes.trim().length()==1){
    mes="0"+mes;
}
String fvenci=""+jYearChooser1.getYear()+"-"+mes+"-01";
String fec="SELECT max(DFECHA_DOC) FROM HISTORIA";  // BUSCA LA FECHA MAS ACUAL
        try {
            PreparedStatement ps=v.conectar().prepareStatement(fec);
            ResultSet rs=ps.executeQuery();
            rs.next();
            fec=rs.getNString(1);
        } catch (SQLException ex) {
            Logger.getLogger(StockALaFecha.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        String psql="SELECT CART_ID ,CART_NOM,SUM(TOTAL) "//CALCULA EL STOCK INICIAL DENTRO DEL RANGO DE VENCIMIENTO
                + "FROM RECUENTO_FECHAS "// Y LO INGRESA EN EL 4
                + "WHERE FECHA_DE_VENCIMIENTO>'"+fvenci+"' GROUP BY CART_ID";
        try {
            PreparedStatement pps=v.conectar().prepareStatement(psql);
            ResultSet prs=pps.executeQuery();
            while(prs.next()){
              String sSQL = "UPDATE sistema_fecha SET "
                        + "Nc_Alma4=?,Nc_Alma5=?"
                        + " WHERE Cart_Id=? and Fecha_recuento='" + v.getFecha_recuento_selecionada() + "'";   
            
            PreparedStatement ps2=v.conectar().prepareStatement(sSQL);
            Double suma=prs.getDouble(3);
            String codigo=prs.getNString(1);
            Double saldo=0.0;
                ps2.setDouble(1, suma);
                ps2.setDouble(2, saldo);
                ps2.setString(3, codigo);
                ps2.executeUpdate();  // ACA
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(StockALaFecha.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    
    String sql="select substring(CPROVEEDOR,17,length(cproveedor)-17) ,"
            + "SUBSTRING( articulo,1, LOCATE ('-', articulo)-1), sum(ncantidad_consumo) "
            + "from historia "
            + "where DFECHA_DOC   BETWEEN '" + v.getFecha_recuento_selecionada().trim() + "' and '"+fec+"' "
            + "and substring(CPROVEEDOR,17,length(cproveedor)-16)= '" + v.getLina_seleccionada().trim() + "' group by articulo ";
        try {  //CALCULA LAS VENTAS EN EL PERIODO ENTRE RECUENTO Y HOY Y LO PONE EN EL 5
            PreparedStatement ps = v.conectar().prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
            String sSQL = "UPDATE sistema_fecha SET "
                        + "Nc_Alma5=?,Nc_Alma6=?"
                        + " WHERE Cart_Id=? and Fecha_recuento='" + v.getFecha_recuento_selecionada() + "'";   
            
            PreparedStatement ps2=v.conectar().prepareStatement(sSQL);// en el 5 estan las ventas
            Double suma=rs.getDouble(3);
            String codigo=rs.getNString(2);
            Double saldo=0.0;
                ps2.setDouble(1, suma);
                ps2.setDouble(2, saldo);
                ps2.setString(3, codigo);
                ps2.executeUpdate();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(StockALaFecha.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        String sqldif="SELECT CART_ID ,CART_NOM,SUM(TOTAL)  "
                + "FROM RECUENTO_FECHAS "//CALCULA LA SUMAA DE PRODUCTOS QUE ESTAN POR VENCER DESDE EL DIA DE RECUENTO HASTA LA FECHA SOLICITADA
                + "WHERE FECHA_RECUENTO ='" + v.getFecha_recuento_selecionada() + "' "
                + "and  CPROV_NOM ='" + v.getLina_seleccionada().trim() + "'  "
                + "and FECHA_DE_VENCIMIENTO between '" + v.getFecha_recuento_selecionada() + "' and '"+fvenci+"' GROUP BY CART_ID";
        try { // Y LO PONE EN EL 7, EN EL 8 PONE LA DIFERENCIA ENTRE LAS VENYAS (5) Y EL 7, SI NEGATIVO =0,
            PreparedStatement psdif = v.conectar().prepareStatement(sqldif);
            ResultSet rsdif=psdif.executeQuery();
            while(rsdif.next()){
            String sSQL = "UPDATE sistema_fecha SET "
                        + "Nc_Alma7=?,Nc_Alma8=?"
                        + " WHERE Cart_Id=? and Fecha_recuento='" + v.getFecha_recuento_selecionada() + "'";   
            
            PreparedStatement ps2=v.conectar().prepareStatement(sSQL);
            Double suma=rsdif.getDouble(3);
            String codigo=rsdif.getNString("CART_ID");
//            Double almacen=rsdif.getDouble(2);
            Double saldo=0.00;//almacen-suma; esto lo pone en la 7 la suma del periodo
                ps2.setDouble(1, suma);
                ps2.setDouble(2, saldo);
                ps2.setString(3, codigo);
                ps2.executeUpdate();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(StockALaFecha.class.getName()).log(Level.SEVERE, null, ex);
        }
        sql="SELECT CART_ID  ,NC_ALMA5 ,NC_ALMA7 "//EN EL 8 PONE LA DIFERENCIA ENTRE LAS VENYAS (5) Y EL 7, SI NEGATIVO =0,
                + "FROM SISTEMA_FECHA "
                + "where FECHA_RECUENTO ='" + v.getFecha_recuento_selecionada() + "' "
                + "and CPROV_NOM ='" + v.getLina_seleccionada().trim() + "'";
        try {
            PreparedStatement ps = v.conectar().prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
            String sSQL = "UPDATE sistema_fecha SET "
                        + "Nc_Alma7=?,Nc_Alma8=?"
                        + " WHERE Cart_Id=? and Fecha_recuento='" + v.getFecha_recuento_selecionada() + "'";   
            
            PreparedStatement ps2=v.conectar().prepareStatement(sSQL);
            Double suma=rs.getDouble(3);
            String codigo=rs.getNString(1);
            Double almacen=rs.getDouble(2);
            Double saldo=almacen-suma;
            if(saldo<0){
                saldo=0.0;
            }
                ps2.setDouble(1, suma);
                ps2.setDouble(2, saldo);
                ps2.setString(3, codigo);
                ps2.executeUpdate();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(StockALaFecha.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        
        sql="SELECT CART_ID  ,NC_ALMA4 ,NC_ALMA8 "
                + "FROM SISTEMA_FECHA "
                + "where FECHA_RECUENTO ='" + v.getFecha_recuento_selecionada() + "' "
                + "and CPROV_NOM ='" + v.getLina_seleccionada().trim() + "'";
        try {
            PreparedStatement ps = v.conectar().prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
            String sSQL = "UPDATE sistema_fecha SET "
                        + "Nc_Alma5=?,Nc_Alma6=?"
                        + " WHERE Cart_Id=? and Fecha_recuento='" + v.getFecha_recuento_selecionada() + "'";   
            
            PreparedStatement ps2=v.conectar().prepareStatement(sSQL);
            Double suma=rs.getDouble(3);
            String codigo=rs.getNString(1);
            Double almacen=rs.getDouble(2);
            Double saldo=almacen-suma;
            if(saldo<0){
                saldo=0.0;}
                ps2.setDouble(1, suma);
                ps2.setDouble(2, saldo);
                ps2.setString(3, codigo);
                ps2.executeUpdate();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(StockALaFecha.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        sql="SELECT CART_ID  ,NC_ALMA6 ,NFACTOR_DE_CONSUMO,NFACTOR_DE_VENTA "
                + "FROM SISTEMA_FECHA "
                + "where FECHA_RECUENTO ='" + v.getFecha_recuento_selecionada() + "' "
                + "and CPROV_NOM ='" + v.getLina_seleccionada().trim() + "'";
        try {
            PreparedStatement ps = v.conectar().prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
            String sSQL = "UPDATE sistema_fecha SET "
                        + "Nc_Alma10=?,Nc_Alma11=?,Nc_Alma12=?"
                        + " WHERE Cart_Id=? and Fecha_recuento='" + v.getFecha_recuento_selecionada() + "'";   
            
            PreparedStatement ps2=v.conectar().prepareStatement(sSQL);
            int fc=rs.getInt(3);
            String codigo=rs.getNString(1);
            int almacen=rs.getInt(2);
//            int display=almacen%fc;
            int cajas=almacen/fc;
            Double almacend=rs.getDouble(2);
            double cal1=(almacend/fc)-cajas;
            int display=(int) (cal1*rs.getInt(4));
            
            
            ps2.setInt(1, cajas);
                ps2.setInt(2, display);
                ps2.setInt(3, 0);
                ps2.setString(4, codigo);
                ps2.executeUpdate();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(StockALaFecha.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

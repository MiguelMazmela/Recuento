/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Variables;

import Clases.pordia;
import Interfaces.Configuracion_factores;
import Interfaces.CreditosXClientes;
import Interfaces.StockALaFecha;
import java.io.File;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PORTATIL
 */
public final class Var {

    private Connection con;
    private String CreaTablaSistema;
    private String CreaTablaCreditos;
    private String CreaRecuento;
    private String Crea_tabla_comprobantes;
    private String C_Cart_Id;
    private String C_Cart_Nom;
    private Double c_Nfactor_De_Venta;
    private Double c_Nfactor_De_Consumo;
    private Double c_Nfactor_A_Reporte;
    private Double c_Nultimo_Soles;
    private Double c_Nprec_Consumo;
    private Double c_Nc_Alma;
    private Double c_cajas;
    private Double c_displays;
    private Double c_unidades;
    private Double c_total;
    private Double C_total_general;
    private Date C_Fecha_de_vencimiento;
    private String C_lote;
    private Date C_Fecha_recuento;
    private String T_Fecha_de_vencimiento;
    private String c_Cprov_Id;
    private String c_Cprov_Nom;
    private Double totalXlinea;
    private Double total_contado;
    private Double total_diferencia;
    private int itemSel;
    private ArrayList<String> codigos = new ArrayList<>();
    private boolean uni;
    private java.util.Date fecha = new java.util.Date();
    private java.sql.Date fechaSQL = new java.sql.Date(fecha.getTime());
    private String fecha_recuento_selecionada;
    private String Producto_seleccionado;
    private String Lina_seleccionada;
    private boolean actualizo;
    private int secuencia;
    private String HISTORIA_T;
    private String HISTORIA;
    private String PERSONAL;
    private final Calendar cal = Calendar.getInstance();
    private String CreaTablaSistema_fecha;
    private String CreaRecuento_fechas;
    private final String CreaTablaFactores;
    private String filtro_carga_tabla;
    private Double total_no_vencido;
    private Double total_vencido;
    private final String LINEA;
    private final String CARGO;
    private final String CENTRO_DE_COSTO;
    private Boolean editando;
    private String codediper;
    private String P_cod;
    private String P_nombre;
    private String P_Apellido_p;
    private String P_Apellido_m;
    private String P_linea;
    private String P_CARGO;
    private String P_CENTRO_DE_COSTO;
    private String P_DNI;
    private String P_DIRECCION;
    private Date P_FEC_NAC;
    private Date P_FEC_ING;
    private Date P_FEC_ALT;
    private Date P_FEC_baja;
    private Boolean P_PLANILLA;
    private Double P_Sueldo;
    private int P_HIJOS;
    private java.util.Date Fecha_operacion;
    private final String creaTablaComplemento;
    private Date Hoy;
    private Boolean confecha;
    private final String sql_consulta_temporal;
    private Double valor_igv;
    private Boolean Conceros;
    private String op_seleccionada;
    private String sSistemaOperativo;
//    private String currentDir;

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public String getCreaTablaSistema() {
        return CreaTablaSistema;
    }

    public void setCreaTablaSistema(String CreaTablaSistema) {
        this.CreaTablaSistema = CreaTablaSistema;
    }

    public Connection conectar() {
        Connection coco = null;
        this.sSistemaOperativo = System.getProperty("os.name");
        System.out.println(sSistemaOperativo);

        String sFichero = "recuento";
        String sDirectorio = "src" + File.separator + "Data";

        String sPath = getCurrentDir()+File.separator + sDirectorio + File.separator + sFichero;
        System.out.println(sPath);

        try {

            Class.forName("org.h2.Driver");
//            coco = DriverManager.getConnection("jdbc:h2:file:C:\\Users"
//                    + "\\PORTATIL\\Documents\\NetBeansProjects\\Recuento"
//                    + "\\src\\Data\\recuento", "Miguel", "");
            coco = DriverManager.getConnection("jdbc:h2:file:" + sPath, "Miguel", "");

//            System.out.print();
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.print(ex);
        }

        return coco;

    }

    public Var() {
        this.Conceros = true;
        this.Fecha_operacion = new java.util.Date();
        this.codediper = "";
        this.editando = false;
        this.total_vencido = 0.0;
        this.total_no_vencido = 0.0;
        this.total_diferencia = 0.0;
        this.total_contado = 0.0;
        this.totalXlinea = 0.0;
        this.con = conectar();
        this.confecha = true;
//        this.Hoy=new Date();
//        fechaSQL = new java.sql.Date(fecha.getTime());
        
        cal.setTime(fecha);
        
        this.op_seleccionada = "VENCIDOS";
        this.CreaTablaSistema = "Create table sistema("
                + "Cprov_Id nvarchar (8),"
                + "Cprov_Nom nvarchar (50),"
                + "Cart_Id nvarchar (8),"
                + "Cart_Nom nvarchar (100),"
                + "Um_Compra nvarchar (3),"
                + "Um_Venta nvarchar (11),"
                + "Um_Consumo nvarchar (11),"
                + "Um_Reporte nvarchar (11),"
                + "Nfactor_De_Venta numeric(18,4),"
                + "Nfactor_De_Consumo numeric(18,4),"
                + "Nfactor_A_Reporte numeric(18,4),"
                + "Narticulos_Peso numeric(18,4),"
                + "Npromedio_Soles numeric(18,4),"
                + "Nultimo_Soles numeric(18,4),"
                + "Nprec_Compra numeric(18,4),"
                + "Nprec_Venta numeric(18,4),"
                + "Nprec_Consumo numeric(18,4),"
                + "Cfamilia nvarchar (11),"
                + "Cdfamili nvarchar (11),"
                + "Cagr_Art nvarchar (11),"
                + "Cdes_Agr nvarchar (11),"
                + "Cc_Alma1 nvarchar (11),"
                + "Cc_Alma2 nvarchar (11),"
                + "Cc_Alma3 nvarchar (11),"
                + "Cc_Alma4 nvarchar (11),"
                + "Cc_Alma5 nvarchar (11),"
                + "Cc_Alma6 nvarchar (11),"
                + "Cc_Alma7 nvarchar (11),"
                + "Cc_Alma8 nvarchar (11),"
                + "Cc_Alma9 nvarchar (11),"
                + "Cc_Alma10 nvarchar (11),"
                + "Cc_Alma11 nvarchar (11),"
                + "Cc_Alma12 nvarchar (11),"
                + "Cc_Alma13 nvarchar (11),"
                + "Cc_Alma14 nvarchar (11),"
                + "Cc_Alma15 nvarchar (11),"
                + "Cc_Alma16 nvarchar (11),"
                + "Cc_Alma17 nvarchar (11),"
                + "Cc_Alma18 nvarchar (11),"
                + "Cc_Alma19 nvarchar (11),"
                + "Cc_Alma20 nvarchar (11),"
                + "Nc_Alma numeric(18,4),"
                + "Nc_Alma1 numeric(18,4),"
                + "Nc_Alma2 numeric(18,4),"
                + "Nc_Alma3 numeric(18,4),"
                + "Nc_Alma4 numeric(18,4),"
                + "Nc_Alma5 numeric(18,4),"
                + "Nc_Alma6 numeric(18,4),"
                + "Nc_Alma7 numeric(18,4),"
                + "Nc_Alma8 numeric(18,4),"
                + "Nc_Alma9 numeric(18,4),"
                + "Nc_Alma10 numeric(18,4),"
                + "Nc_Alma11 numeric(18,4),"
                + "Nc_Alma12 numeric(18,4),"
                + "Nc_Alma13 numeric(18,4),"
                + "Nc_Alma14 numeric(18,4),"
                + "Nc_Alma15 numeric(18,4),"
                + "Nc_Alma16 numeric(18,4),"
                + "Nc_Alma17 numeric(18,4),"
                + "Nc_Alma18 numeric(18,4),"
                + "Nc_Alma19 numeric(18,4),"
                + "Nc_Alma20 numeric(18,4),"
                + "Xc_Alma numeric(18,4),"
                + "Xc_Alma1 numeric(18,4),"
                + "Xc_Alma2 numeric(18,4),"
                + "Xc_Alma3 numeric(18,4),"
                + "Xc_Alma4 numeric(18,4),"
                + "Xc_Alma5 numeric(18,4),"
                + "Xc_Alma6 numeric(18,4),"
                + "Xc_Alma7 numeric(18,4),"
                + "Xc_Alma8 numeric(18,4),"
                + "Xc_Alma9 numeric(18,4),"
                + "Xc_Alma10 numeric(18,4),"
                + "Xc_Alma11 numeric(18,4),"
                + "Xc_Alma12 numeric(18,4),"
                + "Xc_Alma13 numeric(18,4),"
                + "Xc_Alma14 numeric(18,4),"
                + "Xc_Alma15 numeric(18,4),"
                + "Xc_Alma16 numeric(18,4),"
                + "Xc_Alma17 numeric(18,4),"
                + "Xc_Alma18 numeric(18,4),"
                + "Xc_Alma19 numeric(18,4),"
                + "Xc_Alma20 numeric(18,4),"
                + "Cnro_Serie nvarchar (11),"
                + "Cestado nvarchar (11),"
                + "Grupo nvarchar (11),"
                + "Ccategoria_1 nvarchar (50),"
                + "Ccategoria_2 nvarchar (50),"
                + "Ccategoria_3 nvarchar (50),"
                + "Ccategoria_4 nvarchar (50),"
                + "Ccategoria_5 nvarchar (50),"
                + "Cdescripcion_Cat_1 nvarchar (50),"
                + "Cdescripcion_Cat_2 nvarchar (50),"
                + "Cdescripcion_Cat_3 nvarchar (50),"
                + "Cdescripcion_Cat_4 nvarchar (50),"
                + "Cdescripcion_Cat_5 nvarchar (50),"
                + "Fecha_recuento date)";

        this.CreaTablaCreditos = "Create table creditos("
                + "cid_vend nvarchar (100),"//0
                + "nid_cia nvarchar (10),"//1
                + "cid_ofi nvarchar (10),"//2
                + "cvencido nvarchar (30),"//3
                + "ctipo_doc nvarchar (2),"//4
                + "cserie nvarchar (5),"//5
                + "cnumero nvarchar (20),"//6
                + "cmoneda nvarchar (10),"//7
                + "nporcent decimal (10,5),"//8
                + "cforma_pago_id nvarchar (40),"//9
                + "cgrp_dscto_clie nvarchar (10),"//10
                + "dfecha_documento Date,"//11
                + "dfecha_vencimiento Date,"//12
                + "cid_clie nvarchar (100),"//13
                + "ruc nvarchar (11),"//14
                + "dni nvarchar (8),"//15
                + "mdirec_clie nvarchar (100),"//16
                + "cubigeo nvarchar (50),"//17
                + "cruta nvarchar (25),"//18
                + "ndias_atraso nvarchar (6),"//19
                + "ccanal nvarchar (30),"//20
                + "cproveedor nvarchar (50),"//21
                + "cvend_padre nvarchar (100),"//22
                + "catencion nvarchar (50),"//23
                + "ctelefono nvarchar (15),"//24
                + "limite_credito_dolares decimal (14,4),"//25
                + "relacionado nvarchar (2),"//26
                + "transportista_id nvarchar (20),"//27
                + "transportista_nom nvarchar (50),"//28
                + "nimporte_neto decimal (14,4),"//29
                + "nmonto decimal (14,4),"//30
                + "dia_de_operacion date )";//31

        this.creaTablaComplemento = "CREATE TABLE IF NOT EXISTS extencion("
                + "cnumero nvarchar (20),"
                + "Responsable nvarchar(200),"
                + "fecha_pago Date,"
                + "comentario nvarchar(500),"
                + "desc boolean,"
                + "fecha_desc date,"
                + "comentario_desc nvarchar(500))";

        this.CreaTablaSistema_fecha = "Create table sistema_fecha("
                + "Cprov_Id nvarchar (8),"
                + "Cprov_Nom nvarchar (50),"
                + "Cart_Id nvarchar (8),"
                + "Cart_Nom nvarchar (100),"
                + "Um_Compra nvarchar (3),"
                + "Um_Venta nvarchar (11),"
                + "Um_Consumo nvarchar (11),"
                + "Um_Reporte nvarchar (11),"
                + "Nfactor_De_Venta numeric(18,4),"
                + "Nfactor_De_Consumo numeric(18,4),"
                + "Nfactor_A_Reporte numeric(18,4),"
                + "Narticulos_Peso numeric(18,4),"
                + "Npromedio_Soles numeric(18,4),"
                + "Nultimo_Soles numeric(18,4),"
                + "Nprec_Compra numeric(18,4),"
                + "Nprec_Venta numeric(18,4),"
                + "Nprec_Consumo numeric(18,4),"
                + "Cfamilia nvarchar (11),"
                + "Cdfamili nvarchar (11),"
                + "Cagr_Art nvarchar (11),"
                + "Cdes_Agr nvarchar (11),"
                + "Cc_Alma1 nvarchar (11),"
                + "Cc_Alma2 nvarchar (11),"
                + "Cc_Alma3 nvarchar (11),"
                + "Cc_Alma4 nvarchar (11),"
                + "Cc_Alma5 nvarchar (11),"
                + "Cc_Alma6 nvarchar (11),"
                + "Cc_Alma7 nvarchar (11),"
                + "Cc_Alma8 nvarchar (11),"
                + "Cc_Alma9 nvarchar (11),"
                + "Cc_Alma10 nvarchar (11),"
                + "Cc_Alma11 nvarchar (11),"
                + "Cc_Alma12 nvarchar (11),"
                + "Cc_Alma13 nvarchar (11),"
                + "Cc_Alma14 nvarchar (11),"
                + "Cc_Alma15 nvarchar (11),"
                + "Cc_Alma16 nvarchar (11),"
                + "Cc_Alma17 nvarchar (11),"
                + "Cc_Alma18 nvarchar (11),"
                + "Cc_Alma19 nvarchar (11),"
                + "Cc_Alma20 nvarchar (11),"
                + "Nc_Alma numeric(18,4),"
                + "Nc_Alma1 numeric(18,4),"
                + "Nc_Alma2 numeric(18,4),"
                + "Nc_Alma3 numeric(18,4),"
                + "Nc_Alma4 numeric(18,4),"
                + "Nc_Alma5 numeric(18,4),"
                + "Nc_Alma6 numeric(18,4),"
                + "Nc_Alma7 numeric(18,4),"
                + "Nc_Alma8 numeric(18,4),"
                + "Nc_Alma9 numeric(18,4),"
                + "Nc_Alma10 numeric(18,4),"
                + "Nc_Alma11 numeric(18,4),"
                + "Nc_Alma12 numeric(18,4),"
                + "Nc_Alma13 numeric(18,4),"
                + "Nc_Alma14 numeric(18,4),"
                + "Nc_Alma15 numeric(18,4),"
                + "Nc_Alma16 numeric(18,4),"
                + "Nc_Alma17 numeric(18,4),"
                + "Nc_Alma18 numeric(18,4),"
                + "Nc_Alma19 numeric(18,4),"
                + "Nc_Alma20 numeric(18,4),"
                + "Xc_Alma numeric(18,4),"
                + "Xc_Alma1 numeric(18,4),"
                + "Xc_Alma2 numeric(18,4),"
                + "Xc_Alma3 numeric(18,4),"
                + "Xc_Alma4 numeric(18,4),"
                + "Xc_Alma5 numeric(18,4),"
                + "Xc_Alma6 numeric(18,4),"
                + "Xc_Alma7 numeric(18,4),"
                + "Xc_Alma8 numeric(18,4),"
                + "Xc_Alma9 numeric(18,4),"
                + "Xc_Alma10 numeric(18,4),"
                + "Xc_Alma11 numeric(18,4),"
                + "Xc_Alma12 numeric(18,4),"
                + "Xc_Alma13 numeric(18,4),"
                + "Xc_Alma14 numeric(18,4),"
                + "Xc_Alma15 numeric(18,4),"
                + "Xc_Alma16 numeric(18,4),"
                + "Xc_Alma17 numeric(18,4),"
                + "Xc_Alma18 numeric(18,4),"
                + "Xc_Alma19 numeric(18,4),"
                + "Xc_Alma20 numeric(18,4),"
                + "Cnro_Serie nvarchar (11),"
                + "Cestado nvarchar (11),"
                + "Grupo nvarchar (11),"
                + "Ccategoria_1 nvarchar (50),"
                + "Ccategoria_2 nvarchar (50),"
                + "Ccategoria_3 nvarchar (50),"
                + "Ccategoria_4 nvarchar (50),"
                + "Ccategoria_5 nvarchar (50),"
                + "Cdescripcion_Cat_1 nvarchar (50),"
                + "Cdescripcion_Cat_2 nvarchar (50),"
                + "Cdescripcion_Cat_3 nvarchar (50),"
                + "Cdescripcion_Cat_4 nvarchar (50),"
                + "Cdescripcion_Cat_5 nvarchar (50),"
                + "Fecha_recuento date)";

        CreaRecuento = "Create table Recuento("
                + "Secuencia int,"
                + "Cart_Id nvarchar (8),"
                + "Cart_Nom nvarchar(100), "
                + "Nfactor_De_Venta numeric(18,4), "
                + "Nfactor_De_Consumo numeric(18,4), "
                + "Nfactor_A_Reporte numeric(18,4), "
                + "Nultimo_Soles numeric(18,4), "
                + "Nprec_Consumo numeric(18,4), "
                + "Nc_Alma numeric(18,4),"
                + "cajas numeric(18,0),"
                + "displays numeric(18,0),"
                + "unidades numeric(18,0),"
                + "total numeric(18,4),"
                + "total_general numeric(18,4),"
                + "Fecha_de_vencimiento date,"
                + "Fecha_recuento date,"
                + "Cprov_Id nvarchar (8),"
                + "Cprov_Nom nvarchar (50))";

        CreaRecuento_fechas = "Create table Recuento_fechas("
                + "Secuencia int,"
                + "Cart_Id nvarchar (8),"
                + "Cart_Nom nvarchar(100), "
                + "Nfactor_De_Venta numeric(18,4), "
                + "Nfactor_De_Consumo numeric(18,4), "
                + "Nfactor_A_Reporte numeric(18,4), "
                + "Nultimo_Soles numeric(18,4), "
                + "Nprec_Consumo numeric(18,4), "
                + "Nc_Alma numeric(18,4),"
                + "cajas numeric(18,0),"
                + "displays numeric(18,0),"
                + "unidades numeric(18,0),"
                + "total numeric(18,4),"
                + "total_general numeric(18,4),"
                + "Fecha_de_vencimiento date,"
                + "Fecha_recuento date,"
                + "Fecha_vencimiento date,"
                + "Lote nvarchar(50),"
                + "Cprov_Id nvarchar (8),"
                + "Cprov_Nom nvarchar (50),"
                + "Saldo numeric(18,4))";

        HISTORIA_T = "CREATE TABLE IF NOT EXISTS Historia_t("
                + "cnumero_documento_item char(3), "//0
                + "dfecha_doc DATE, "//1
                + "dfecha_documento DATE, "//2
                + "ruc char(11), "//3
                + "dni char(8), "//4
                + "observaciones char(50), "//5
                + "df_ref DATE, "//6
                + "dfecha_ref DATE, "//7
                + "cantidad_umr decimal(13,4), "//8
                + "devuelto_umr decimal(13,4), "
                + "nimporte_total_a  decimal(12,4), "
                + "nimporte_total_dolar_a  decimal(12,4), "
                + "ngratuito_soles_a DECIMAL(12,4), "
                + "ngratuito_dolares_a DECIMAL(12,4), "
                + "devuelto_s DECIMAL(12,4), "
                + "canasta VARCHAR(100), "//15
                + "promocion VARCHAR(100), "
                + "nvalor_venta DECIMAL(12,4), "
                + "nigv DECIMAL(12,4), "
                + "lbonificado DECIMAL(12,4), "
                + "ctipo_documento_id CHAR(15), "//20
                + "nid_cia VARCHAR(1), "
                + "cid_ofi VARCHAR(2), "
                + "cliente VARCHAR(100), "
                + "nombre_vendedor VARCHAR(30), "
                + "vendedor_origen VARCHAR(30), "//25
                + "articulo VARCHAR(80), "
                + "cserie_documento VARCHAR(4), "
                + "cnumero_documento VARCHAR(15), "
                + "cgrupo_descuento VARCHAR(30), "
                + "cperiodo VARCHAR(10), "
                + "referencia VARCHAR(16), "
                + "lgratuito VARCHAR(2), "
                + "ckits VARCHAR(60), "
                + "cdescuento VARCHAR(12), "
                + "cforma_pago_desc VARCHAR(20), "
                + "calmacen_id VARCHAR(3), "
                + "ccanal VARCHAR(20), "
                + "ctipo_negocio VARCHAR(50), "
                + "cdias_visita VARCHAR(20), "
                + "cruta_despacho VARCHAR(20), "
                + "cid_lista VARCHAR(6), "
                + "cproveedor VARCHAR(80), "//42
                + "cvend_padre VARCHAR(30), "
                + "ctransportista VARCHAR(60), "
                + "cubigeo VARCHAR(40), "
                + "lpreventa VARCHAR(50), "
                + "opbd VARCHAR(10), "
                + "lrelet VARCHAR(2), "
                + "codigo_ean VARCHAR(10), "
                + "carticulos_ubicacion_principal VARCHAR(30), "//50
                + "clie_ref1 VARCHAR(30), "
                + "clie_ref2 VARCHAR(30), "
                + "clie_ref3 VARCHAR(30), "
                + "clie_ref4 VARCHAR(30), "
                + "clie_ref5 VARCHAR(30), "
                + "ccategoria1_desc VARCHAR(30), "
                + "ccategoria2_desc VARCHAR(30), "
                + "ccategoria3_desc VARCHAR(30), "
                + "ccategoria4_desc VARCHAR(30), "
                + "ccategoria5_desc VARCHAR(30), "//60
                + "ncantidad_pedido decimal(13,4), "
                + "npeso_detalle decimal(13,4), "
                + "nimporte_descuento decimal(13,4), "
                + "nporc_descuento decimal(13,4), "
                + "ncantidad_consumo decimal(13,4), "
                + "ncantidad_compra decimal(13,4), "
                + "nimp_recargo_detalle decimal(13,4), "
                + "devuelto decimal(13,4), "
                + "cunidad_de_medida_compra VARCHAR(30), "
                + "cunidad_de_medida_consumo VARCHAR(30), "
                + "cunidad_de_medida_venta  VARCHAR(30), "
                + "relacionado VARCHAR(30), "
                + "Cart_Id VARCHAR(20))";

        HISTORIA = "CREATE TABLE IF NOT EXISTS Historia("
                + "cnumero_documento_item char(3), "//0
                + "dfecha_doc DATE, "//1
                + "dfecha_documento DATE, "//2
                + "ruc char(11), "//3
                + "dni char(8), "//4
                + "observaciones char(50), "//5
                + "df_ref DATE, "//6
                + "dfecha_ref DATE, "//7
                + "cantidad_umr decimal(13,4), "
                + "devuelto_umr decimal(13,4), "
                + "nimporte_total_a  decimal(12,4), "//10
                + "nimporte_total_dolar_a  decimal(12,4), "
                + "ngratuito_soles_a DECIMAL(12,4), "
                + "ngratuito_dolares_a DECIMAL(12,4), "
                + "devuelto_s DECIMAL(12,4), "
                + "canasta VARCHAR(100), "
                + "promocion VARCHAR(100), "
                + "nvalor_venta DECIMAL(12,4), "
                + "nigv DECIMAL(12,4), "
                + "lbonificado DECIMAL(12,4), "
                + "ctipo_documento_id CHAR(15), "//20
                + "nid_cia VARCHAR(1), "
                + "cid_ofi VARCHAR(2), "
                + "cliente VARCHAR(100), "//23
                + "nombre_vendedor VARCHAR(30), "
                + "vendedor_origen VARCHAR(30), "
                + "articulo VARCHAR(80), "//26
                + "cserie_documento VARCHAR(4), "
                + "cnumero_documento VARCHAR(15), "//28
                + "cgrupo_descuento VARCHAR(30), "//29
                + "cperiodo VARCHAR(10), "//30
                + "referencia VARCHAR(16), "
                + "lgratuito VARCHAR(2), "
                + "ckits VARCHAR(60), "
                + "cdescuento VARCHAR(12), "
                + "cforma_pago_desc VARCHAR(20), "
                + "calmacen_id VARCHAR(3), "
                + "ccanal VARCHAR(20), "
                + "ctipo_negocio VARCHAR(50), "
                + "cdias_visita VARCHAR(20), "
                + "cruta_despacho VARCHAR(20), "
                + "cid_lista VARCHAR(6), "
                + "cproveedor VARCHAR(80), "//42
                + "cvend_padre VARCHAR(30), "
                + "ctransportista VARCHAR(60), "
                + "cubigeo VARCHAR(40), "
                + "lpreventa VARCHAR(50), "
                + "opbd VARCHAR(10), "
                + "lrelet VARCHAR(2), "
                + "codigo_ean VARCHAR(10), "
                + "carticulos_ubicacion_principal VARCHAR(30), "
                + "clie_ref1 VARCHAR(30), "
                + "clie_ref2 VARCHAR(30), "
                + "clie_ref3 VARCHAR(30), "
                + "clie_ref4 VARCHAR(30), "
                + "clie_ref5 VARCHAR(30), "
                + "ccategoria1_desc VARCHAR(30), "
                + "ccategoria2_desc VARCHAR(30), "
                + "ccategoria3_desc VARCHAR(30), "
                + "ccategoria4_desc VARCHAR(30), "
                + "ccategoria5_desc VARCHAR(30), "//60
                + "ncantidad_pedido decimal(13,4), "
                + "npeso_detalle decimal(13,4), "
                + "nimporte_descuento decimal(13,4), "
                + "nporc_descuento decimal(13,4), "
                + "ncantidad_consumo decimal(13,4), "
                + "ncantidad_compra decimal(13,4), "
                + "nimp_recargo_detalle decimal(13,4), "
                + "devuelto decimal(13,4), "
                + "cunidad_de_medida_compra VARCHAR(30), "
                + "cunidad_de_medida_consumo VARCHAR(30), "
                + "cunidad_de_medida_venta  VARCHAR(30), "
                + "relacionado VARCHAR(30), "
                + "linea VARCHAR(20))";

        PERSONAL = "CREATE TABLE IF NOT EXISTS PERSONAL("
                + "COD char(11)not null,"
                + "NOMBRE char(20),"
                + "Apellido_p char(30), "
                + "Apellido_m char(30),"
                + "LINEA CHAR(20),"
                + "CARGO CHAR(30), "
                + "CENTRO_DE_COSTO CHAR(30),"
                + "DNI CHAR(8) NOT NULL, "
                + "DIRECCION CHAR(100),"
                + "FEC_NAC DATE, "
                + "FEC_ING DATE, "
                + "FEC_ALT DATE,"
                + "FEC_baja DATE,"
                + "PLANILLA BOOLEAN,"
                + "Sueldo decimal(12,2), "
                + "HIJOS INTEGER, PRIMARY KEY (DNI)) ";

        LINEA = "CREATE TABLE IF NOT EXISTS LINEA("
                + "COD char(11),"
                + "NOMBRE char(20))";

        CARGO = "CREATE TABLE IF NOT EXISTS CARGO("
                + "COD char(11),"
                + "NOMBRE char(20))";

        CENTRO_DE_COSTO = "CREATE TABLE IF NOT EXISTS CENTRO_DE_COSTO("
                + "COD char(11),"
                + "NOMBRE char(20))";
        this.Crea_tabla_comprobantes = "CREATE TABLE IF NOT EXISTS comprobantes ("
                + "Nombre TEXT NOT NULL UNIQUE, "
                + "Descripcion TEXT, "
                + "PRIMARY KEY(Nombre))";

        this.CreaTablaFactores = "Create table IF NOT EXISTS factores("
                + "Cprov_Id nvarchar (8),"
                + "Cprov_Nom nvarchar (50),"
                + "Cart_Id nvarchar (8),"
                + "Cart_Nom nvarchar (100),"
                + "Nfactor_De_Venta numeric(18,4),"
                + "Nfactor_De_Consumo numeric(18,4),"
                + "Nfactor_A_Reporte numeric(18,4))";

        this.sql_consulta_temporal = "insert into temporal "
                + "(CPROV_ID ,CPROV_NOM ,"
                + "CART_ID ,"
                + "CART_NOM ,"
                + "NFACTOR_DE_VENTA ,"
                + "NFACTOR_DE_CONSUMO ,"
                + "NFACTOR_A_REPORTE ,"
                + "NULTIMO_SOLES ,"
                + "NPREC_CONSUMO ,"
                + "CAJAS ,"
                + "DISPLAYS ,"
                + "UNIDADES ,"
                + "TOTAL ,"
                + "FECHA_DE_VENCIMIENTO ,"
                + "FECHA_RECUENTO ,"
                + "LOTE ) SELECT "
                + "CPROV_ID, "
                + "CPROV_NOM,"
                + "CART_ID ,"
                + "CART_NOM ,"
                + "NFACTOR_DE_VENTA ,"
                + "NFACTOR_DE_CONSUMO ,"
                + "NFACTOR_A_REPORTE ,"
                + "NULTIMO_SOLES ,"
                + "NPREC_CONSUMO ,"
                + "CAJAS ,"
                + "DISPLAYS ,"
                + "UNIDADES ,"
                + "TOTAL ,"
                + "FECHA_DE_VENCIMIENTO ,"
                + "FECHA_RECUENTO ,"
                + "LOTE   "
                + "FROM RECUENTO_FECHAS ";
//                + "where CPROV_NOM ='NESTLE PERU S.A.' and FECHA_RECUENTO ='2021-09-09'";

    }

    public int diasDelMes(int mes, int año) {
        switch (mes) {
            case 1:  // Enero
            case 3:  // Marzo
            case 5:  // Mayo
            case 7:  // Julio
            case 8:  // Agosto
            case 10:  // Octubre
            case 12: // Diciembre
                return 31;
            case 4:  // Abril
            case 6:  // Junio
            case 9:  // Septiembre
            case 11: // Noviembre
                return 30;
            case 2:  // Febrero
                if (((año % 100 == 0) && (año % 400 == 0))
                        || ((año % 100 != 0) && (año % 4 == 0))) {
                    return 29;  // Año Bisiesto
                } else {
                    return 28;
                }
            default:
                throw new java.lang.IllegalArgumentException(
                        "El mes debe estar entre 1 y 12");
        }
    }

    public int diasEntreDosFechas(String f1, String f2) {
        int dias = 0;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        java.util.Date fechaInicial;
        try {
            fechaInicial = dateFormat.parse(f1);
            java.util.Date fechaFinal = dateFormat.parse(f2);

            dias = (int) ((fechaFinal.getTime() - fechaInicial.getTime()) / 86400000);

        } catch (ParseException ex) {
            Logger.getLogger(pordia.class.getName()).log(Level.SEVERE, null, ex);
        }

        return dias;
    }

    public java.util.Date sumar_dias(java.util.Date fecha, int Dias) {

        Calendar calendario = Calendar.getInstance();
        calendario.setTime(fecha);
        calendario.add(Calendar.DATE, Dias);
        return calendario.getTime();

    }

    public java.sql.Date convert(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }

    public boolean actualiza(java.util.Date fecha) {
        boolean todobien = false;
        java.sql.Date fesql = convert(fecha);
        String Ssql = "DELETE FROM historia "
                + "WHERE dfecha_doc = ?";
//                            + "WHERE dfecha_doc = ?";
        String sqle = "INSERT INTO historia SELECT * "
                + "FROM historia_t WHERE dfecha_doc = ?";
//                            matpordia[a].fechaconformato("yyyyMMdd"); //Aca escribimos la condicion

        try {
            PreparedStatement prest = con.prepareStatement(Ssql);
            prest.setDate(1, fesql);
            prest.executeUpdate();
            PreparedStatement prestc = con.prepareStatement(sqle);
            prestc.setDate(1, fesql);
            prestc.executeUpdate();
            todobien = true;

        } catch (SQLException ex) {
            Logger.getLogger(Var.class.getName()).log(Level.SEVERE, null, ex);
        }

        return todobien;
    }

    /**
     * ****************************************************
     * conbierte un texto aaaa-MM-dd en una fecha sql
     *
     * @param fe
     * @return retorna formato de fecha sql
     */
    public java.sql.Date fecFormatoDate(String fe) {

        try {
            SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd", new Locale("es", "ES"));
            java.sql.Date fecFormatoDate = new java.sql.Date(sdf.parse(fe).getTime());

            System.out.println("Fecha con el formato java.sql.Date: " + fecFormatoDate);
            return fecFormatoDate;
        } catch (ParseException ex) {
            System.out.println("Error al obtener el formato de la fecha/hora: " + ex.getMessage());
        }
        return null;
    }

    public String getCreaTablaCreditos() {
        return CreaTablaCreditos;
    }

    public void setCreaTablaCreditos(String CreaTablaCreditos) {
        this.CreaTablaCreditos = CreaTablaCreditos;
    }

    public String getCreaRecuento() {
        return CreaRecuento;
    }

    public void setCreaRecuento(String CreaRecuento) {
        this.CreaRecuento = CreaRecuento;
    }

    public String getC_Cart_Id() {
        return C_Cart_Id;
    }

    public void setC_Cart_Id(String C_Cart_Id) {
        this.C_Cart_Id = C_Cart_Id;
    }

    public String getC_Cart_Nom() {
        return C_Cart_Nom;
    }

    public void setC_Cart_Nom(String C_Cart_Nom) {
        this.C_Cart_Nom = C_Cart_Nom;
    }

    public Double getC_Nfactor_De_Venta() {
        return c_Nfactor_De_Venta;
    }

    public void setC_Nfactor_De_Venta(Double c_Nfactor_De_Venta) {
        this.c_Nfactor_De_Venta = c_Nfactor_De_Venta;
    }

    public Double getC_Nfactor_De_Consumo() {
        return c_Nfactor_De_Consumo;
    }

    public void setC_Nfactor_De_Consumo(Double c_Nfactor_De_Consumo) {
        this.c_Nfactor_De_Consumo = c_Nfactor_De_Consumo;
    }

    public Double getC_Nfactor_A_Reporte() {
        return c_Nfactor_A_Reporte;
    }

    public void setC_Nfactor_A_Reporte(Double c_Nfactor_A_Reporte) {
        this.c_Nfactor_A_Reporte = c_Nfactor_A_Reporte;
    }

    public Double getC_Nultimo_Soles() {
        return c_Nultimo_Soles;
    }

    public void setC_Nultimo_Soles(Double c_Nultimo_Soles) {
        this.c_Nultimo_Soles = c_Nultimo_Soles;
    }

    public Double getC_Nprec_Consumo() {
        return c_Nprec_Consumo;
    }

    public void setC_Nprec_Consumo(Double c_Nprec_Consumo) {
        this.c_Nprec_Consumo = c_Nprec_Consumo;
    }

    public Double getC_Nc_Alma() {
        return c_Nc_Alma;
    }

    public void setC_Nc_Alma(Double c_Nc_Alma) {
        this.c_Nc_Alma = c_Nc_Alma;
    }

    public Double getC_cajas() {
        return c_cajas;
    }

    public void setC_cajas(Double c_cajas) {
        this.c_cajas = c_cajas;
    }

    public Double getC_displays() {
        return c_displays;
    }

    public void setC_displays(Double c_displays) {
        this.c_displays = c_displays;
    }

    public Double getC_unidades() {
        return c_unidades;
    }

    public void setC_unidades(Double c_unidades) {
        this.c_unidades = c_unidades;
    }

    public Double getC_total() {
        return c_total;
    }

    public void setC_total(Double c_total) {
        this.c_total = c_total;
    }

    public Date getC_Fecha_de_vencimiento() {
        return C_Fecha_de_vencimiento;
    }

    public void setC_Fecha_de_vencimiento(Date C_Fecha_de_vencimiento) {
        this.C_Fecha_de_vencimiento = C_Fecha_de_vencimiento;
    }

    public Date getC_Fecha_recuento() {
        return C_Fecha_recuento;
    }

    public void setC_Fecha_recuento(Date C_Fecha_recuento) {
        this.C_Fecha_recuento = C_Fecha_recuento;
    }

    public int getItemSel() {
        return itemSel;
    }

    public void setItemSel(int itemSel) {
        this.itemSel = itemSel;
    }

    public ArrayList<String> getCodigos() {
        return codigos;
    }

    public void setCodigos(ArrayList<String> codigos) {
        this.codigos = codigos;
    }

    public boolean isUni() {
        return uni;
    }

    public void setUni(boolean uni) {
        this.uni = uni;
    }

    public Double getC_total_general() {
        return C_total_general;
    }

    public void setC_total_general(Double C_total_general) {
        this.C_total_general = C_total_general;
    }

    public java.util.Date getFecha() {
        return fecha;
    }

    public void setFecha(java.util.Date fecha) {
        this.fecha = fecha;
    }

    public java.sql.Date getFechaSQL() {
        return fechaSQL;
    }

    public void setFechaSQL(java.sql.Date fechaSQL) {
        this.fechaSQL = fechaSQL;
    }

    public boolean isActualizo() {
        return actualizo;
    }

    public void setActualizo(boolean actualizo) {
        this.actualizo = actualizo;
    }

    public String getFecha_recuento_selecionada() {
        return fecha_recuento_selecionada;
    }

    public void setFecha_recuento_selecionada(String fecha_recuento_selecionada) {
        this.fecha_recuento_selecionada = fecha_recuento_selecionada;
    }

    public String getProducto_seleccionado() {
        return Producto_seleccionado;
    }

    public void setProducto_seleccionado(String Producto_seleccionado) {
        this.Producto_seleccionado = Producto_seleccionado;
    }

    public String getLina_seleccionada() {
        return Lina_seleccionada;
    }

    public void setLina_seleccionada(String Lina_seleccionada) {
        this.Lina_seleccionada = Lina_seleccionada;
    }

    public String getC_Cprov_Id() {
        return c_Cprov_Id;
    }

    public void setC_Cprov_Id(String c_Cprov_Id) {
        this.c_Cprov_Id = c_Cprov_Id;
    }

    public String getC_Cprov_Nom() {
        return c_Cprov_Nom;
    }

    public void setC_Cprov_Nom(String c_Cprov_Nom) {
        this.c_Cprov_Nom = c_Cprov_Nom;
    }

    public int getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(int secuencia) {
        this.secuencia = secuencia;
    }

    public String getHISTORIA_T() {
        return HISTORIA_T;
    }

    public void setHISTORIA_T(String HISTORIA_T) {
        this.HISTORIA_T = HISTORIA_T;
    }

    public String getHISTORIA() {
        return HISTORIA;
    }

    public void setHISTORIA(String HISTORIA) {
        this.HISTORIA = HISTORIA;
    }

    public String getPERSONAL() {
        return PERSONAL;
    }

    public void setPERSONAL(String PERSONAL) {
        this.PERSONAL = PERSONAL;
    }

    public java.sql.Date textodate(String fecha) {

        java.sql.Date lafecha = null;
        java.util.Date fechau;

        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");

        try {

            fechau = formatoDelTexto.parse(fecha);
            lafecha = new java.sql.Date(fechau.getTime());
        } catch (ParseException ex) {
            Logger.getLogger(Var.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lafecha;
    }

    public String mesNumeroANombre(int mes) {
        String nmes = "";

        switch (mes) {
            case 1:
                nmes = "ENERO";
                break;

            case 2:
                nmes = "FEBRERO";
                break;

            case 3:
                nmes = "MARZO";
                break;

            case 4:
                nmes = "ABRIL";
                break;

            case 5:
                nmes = "MAYO";
                break;

            case 6:
                nmes = "JUNIO";
                break;

            case 7:
                nmes = "JULIO";
                break;

            case 8:
                nmes = "AGOSTO";
                break;

            case 9:
                nmes = "SETIEMBRE";
                break;

            case 10:
                nmes = "OCTUBRE";
                break;

            case 11:
                nmes = "NOVIEMBRE";
                break;

            case 12:
                nmes = "DICIEMBRE";
                break;

            default:
                nmes = "ERROR";

        }

        return nmes;
    }

    public DecimalFormat MyFormatter() {

        DecimalFormat df;

        df = new DecimalFormat("#,###,##0.00");
        DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.ENGLISH);
        otherSymbols.setDecimalSeparator('.');
        otherSymbols.setGroupingSeparator(',');
        df.setDecimalFormatSymbols(otherSymbols);
        return df;

    }

    public void borratabla(DefaultTableModel modelo) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        int a = modelo.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            modelo.removeRow(i);
        }

    }

    public Calendar getCal() {
        return cal;
    }

    public String getCreaTablaSistema_fecha() {
        return CreaTablaSistema_fecha;
    }

    public void setCreaTablaSistema_fecha(String CreaTablaSistema_fecha) {
        this.CreaTablaSistema_fecha = CreaTablaSistema_fecha;
    }

    public String getCreaRecuento_fechas() {
        return CreaRecuento_fechas;
    }

    public void setCreaRecuento_fechas(String CreaRecuento_fechas) {
        this.CreaRecuento_fechas = CreaRecuento_fechas;
    }

    public String getC_lote() {
        return C_lote;
    }

    public void setC_lote(String C_lote) {
        this.C_lote = C_lote;
    }

    public String getT_Fecha_de_vencimiento() {
        return T_Fecha_de_vencimiento;
    }

    public void setT_Fecha_de_vencimiento(String T_Fecha_de_vencimiento) {
        this.T_Fecha_de_vencimiento = T_Fecha_de_vencimiento;
    }

    public String carga_ultima_fecha_Texto() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String fech = "";
        String sql = "Select DISTINCT dia_de_operacion from creditos WHERE dia_de_operacion= ( SELECT MAX(dia_de_operacion)  FROM creditos) ";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                fech = rs.getNString("dia_de_operacion");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CreditosXClientes.class.getName()).log(Level.SEVERE, null, ex);
        }

//     jTextField1.setText(fech);
        return fech;
    }

    public java.sql.Date FechaUtilSql(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }

    public java.util.Date FechaSqlUtil(java.sql.Date uDate) {
        java.util.Date sDate = new java.util.Date(uDate.getTime());
        return sDate;
    }

    public long days(Date start, Date end) {
//Ignore argument check 
        Calendar c1 = Calendar.getInstance();
        c1.setTime(start);
        int w1 = c1.get(Calendar.DAY_OF_WEEK);
        c1.add(Calendar.DAY_OF_WEEK, -w1);
        Calendar c2 = Calendar.getInstance();
        c2.setTime(end);
        int w2 = c2.get(Calendar.DAY_OF_WEEK);
        c2.add(Calendar.DAY_OF_WEEK, -w2); //end Saturday to start Saturday 
        long days = (c2.getTimeInMillis() - c1.getTimeInMillis()) / (1000 * 60 * 60 * 24);
        long daysWithoutWeekendDays = days - (days * 1 / 7);
// Adjust w1 or w2 to 0 since we only want a count of *weekdays* 
// to add onto our daysWithout WeekendDays 
        if (w1 == Calendar.SUNDAY) {
            w1 = Calendar.MONDAY;
        }
        if (w2 == Calendar.SUNDAY) {
            w2 = Calendar.MONDAY;
        }
        return daysWithoutWeekendDays - w1 + w2;
    }

    public int diasHabiles(Calendar fechaInicial, Calendar fechaFinal) {
        fechaInicial.add(Calendar.DATE, 1);
        int diffDays = 0;
        boolean diaHabil = false;

        //mientras la fecha inicial sea menor o igual que la fecha final se cuentan los dias
        while (!(fechaInicial.equals(fechaFinal))) {

            //si el dia de la semana de la fecha minima es diferente de sabado o domingo
            if (fechaInicial.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) { // && fechaInicial.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY){ //&& !fechaNoLaborablecalendar.equals(date)) {
                //se aumentan los dias de diferencia entre min y max
                diaHabil = false;
            } else {
                diaHabil = true;
//                break;
            }
            if (diaHabil == true) {
                diffDays++;
            }
            //se suma 1 dia para hacer la validacion del siguiente dia.
            System.out.println("dia =" + fechaInicial.get(Calendar.DATE));
            System.out.println("Mes =" + fechaInicial.get(Calendar.MONTH));
            System.out.println("Año=" + fechaInicial.get(Calendar.YEAR));
            System.out.println("Dia de semana=" + fechaInicial.get(Calendar.DAY_OF_WEEK));
            System.out.println("Dias Habiles=" + diffDays);

            fechaInicial.add(Calendar.DATE, 1);
            if (diffDays > 35) {
                diffDays = 0;
                break;
            }
        }

        return diffDays + 1;
    }

    public java.util.Date ultimo_dia(java.util.Date fecha) {
        java.util.Date udiaf = null;
        java.sql.Date udt;
        Calendar feca = Calendar.getInstance();
        feca.setTime(fecha);
        int mes = feca.get(Calendar.MONTH) + 1;
        int año = feca.get(Calendar.YEAR);
        int dia = diasDelMes(mes, año);
        String fete = año + "-" + mes + "-" + dia;
        udt = textodate(fete);

        udiaf = FechaSqlUtil(udt);

        return udiaf;
    }

    public String getCreaTablaFactores() {
        return CreaTablaFactores;
    }

    public DecimalFormat MyFormatter_entero() {

        DecimalFormat df;

        df = new DecimalFormat("#,###,##0");
        DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.ENGLISH);
        otherSymbols.setDecimalSeparator('.');
        otherSymbols.setGroupingSeparator(',');
        df.setDecimalFormatSymbols(otherSymbols);
        return df;

    }

    public String GetFechaVentasActual() {
        String fec = "SELECT max(DFECHA_DOC) FROM HISTORIA";  // BUSCA LA FECHA MAS ACUAL
        try {
            PreparedStatement ps = this.conectar().prepareStatement(fec);
            ResultSet rs = ps.executeQuery();
            rs.next();
            fec = rs.getNString(1);
        } catch (SQLException ex) {
            Logger.getLogger(StockALaFecha.class.getName()).log(Level.SEVERE, null, ex);

        }
        return fec;
    }

    public void pon_cajas_y_displays() {
        String sql = "SELECT CART_ID  ,NC_ALMA6 ,NFACTOR_DE_CONSUMO,NFACTOR_DE_VENTA "
                + "FROM SISTEMA_FECHA "
                + "where FECHA_RECUENTO ='" + this.getFecha_recuento_selecionada() + "' "
                + "and CPROV_NOM ='" + this.getLina_seleccionada().trim() + "'";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String sSQL = "UPDATE sistema_fecha SET "
                        + "Nc_Alma10=?,Nc_Alma11=?,Nc_Alma12=?"
                        + " WHERE Cart_Id=? and Fecha_recuento='" + this.getFecha_recuento_selecionada() + "'";

                PreparedStatement ps2 = this.conectar().prepareStatement(sSQL);
                int fc = rs.getInt(3);
                String codigo = rs.getNString(1);
                int almacen = rs.getInt(2);
//            int display=almacen%fc;
                int cajas = almacen / fc;
                Double almacend = rs.getDouble(2);
                double cal1 = (almacend / fc) - cajas;
                int display = (int) (cal1 * rs.getInt(4));

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

    public String getFiltro_carga_tabla() {
        return filtro_carga_tabla;
    }

    public void setFiltro_carga_tabla(String filtro_carga_tabla) {
        this.filtro_carga_tabla = filtro_carga_tabla;
    }

    public Double getTotalXlinea() {
        return totalXlinea;
    }

    public void setTotalXlinea(Double totalXlinea) {
        this.totalXlinea = totalXlinea;
    }

    public Double getTotal_contado() {
        return total_contado;
    }

    public void setTotal_contado(Double total_contado) {
        this.total_contado = total_contado;
    }

    public Double getTotal_diferencia() {
        return total_diferencia;
    }

    public void setTotal_diferencia(Double total_diferencia) {
        this.total_diferencia = total_diferencia;
    }

    public Double getTotal_no_vencido() {
        return total_no_vencido;
    }

    public void setTotal_no_vencido(Double total_no_vencido) {
        this.total_no_vencido = total_no_vencido;
    }

    public Double getTotal_vencido() {
        return total_vencido;
    }

    public void setTotal_vencido(Double total_vencido) {
        this.total_vencido = total_vencido;
    }

    public String getLINEA() {
        return LINEA;
    }

    public String getCARGO() {
        return CARGO;
    }

    public String getCENTRO_DE_COSTO() {
        return CENTRO_DE_COSTO;
    }

    public Boolean getEditando() {
        return editando;
    }

    public void setEditando(Boolean editando) {
        this.editando = editando;
    }

    public String getCodediper() {
        return codediper;
    }

    public void setCodediper(String codediper) {
        this.codediper = codediper;
    }

    public String getP_cod() {
        return P_cod;
    }

    public void setP_cod(String P_cod) {
        this.P_cod = P_cod;
    }

    public String getP_nombre() {
        return P_nombre;
    }

    public void setP_nombre(String P_nombre) {
        this.P_nombre = P_nombre;
    }

    public String getP_Apellido_p() {
        return P_Apellido_p;
    }

    public void setP_Apellido_p(String P_Apellido_p) {
        this.P_Apellido_p = P_Apellido_p;
    }

    public String getP_Apellido_m() {
        return P_Apellido_m;
    }

    public void setP_Apellido_m(String P_Apellido_m) {
        this.P_Apellido_m = P_Apellido_m;
    }

    public String getP_linea() {
        return P_linea;
    }

    public void setP_linea(String P_linea) {
        this.P_linea = P_linea;
    }

    public String getP_CARGO() {
        return P_CARGO;
    }

    public void setP_CARGO(String P_CARGO) {
        this.P_CARGO = P_CARGO;
    }

    public String getP_CENTRO_DE_COSTO() {
        return P_CENTRO_DE_COSTO;
    }

    public void setP_CENTRO_DE_COSTO(String P_CENTRO_DE_COSTO) {
        this.P_CENTRO_DE_COSTO = P_CENTRO_DE_COSTO;
    }

    public String getP_DNI() {
        return P_DNI;
    }

    public void setP_DNI(String P_DNI) {
        this.P_DNI = P_DNI;
    }

    public String getP_DIRECCION() {
        return P_DIRECCION;
    }

    public void setP_DIRECCION(String P_DIRECCION) {
        this.P_DIRECCION = P_DIRECCION;
    }

    public Date getP_FEC_NAC() {
        return P_FEC_NAC;
    }

    public void setP_FEC_NAC(Date P_FEC_NAC) {
        this.P_FEC_NAC = P_FEC_NAC;
    }

    public Date getP_FEC_ING() {
        return P_FEC_ING;
    }

    public void setP_FEC_ING(Date P_FEC_ING) {
        this.P_FEC_ING = P_FEC_ING;
    }

    public Date getP_FEC_ALT() {
        return P_FEC_ALT;
    }

    public void setP_FEC_ALT(Date P_FEC_ALT) {
        this.P_FEC_ALT = P_FEC_ALT;
    }

    public Date getP_FEC_baja() {
        return P_FEC_baja;
    }

    public void setP_FEC_baja(Date P_FEC_baja) {
        this.P_FEC_baja = P_FEC_baja;
    }

    public Boolean getP_PLANILLA() {
        return P_PLANILLA;
    }

    public void setP_PLANILLA(Boolean P_PLANILLA) {
        this.P_PLANILLA = P_PLANILLA;
    }

    public Double getP_Sueldo() {
        return P_Sueldo;
    }

    public void setP_Sueldo(Double P_Sueldo) {
        this.P_Sueldo = P_Sueldo;
    }

    public int getP_HIJOS() {
        return P_HIJOS;
    }

    public void setP_HIJOS(int P_HIJOS) {
        this.P_HIJOS = P_HIJOS;
    }

    public java.util.Date getFecha_operacion() {
        return Fecha_operacion;
    }

    public void setFecha_operacion(java.util.Date Fecha_operacion) {
        this.Fecha_operacion = Fecha_operacion;
    }

    public String getCreaTablaComplemento() {
        return creaTablaComplemento;
    }

    public Date getHoy() {
        return Hoy;
    }

    public void setHoy(Date Hoy) {
        this.Hoy = Hoy;
    }

    public String getCrea_tabla_comprobantes() {
        return Crea_tabla_comprobantes;
    }

    public void setCrea_tabla_comprobantes(String Crea_tabla_comprobantes) {
        this.Crea_tabla_comprobantes = Crea_tabla_comprobantes;
    }

    public Boolean getConfecha() {
        return confecha;
    }

    public void setConfecha(Boolean confecha) {
        this.confecha = confecha;
    }

    public String getSql_consulta_temporal(String prov,
            String f_recuento,
            String f_inicio,
            String f_final) {

        String tem = this.sql_consulta_temporal + "where CPROV_NOM ='" + prov + "' and "
                + "FECHA_RECUENTO ='" + f_recuento + "'and "
                + "FECHA_DE_VENCIMIENTO BETWEEN '" + f_inicio + "' and '" + f_final + "' ";

        return tem;
    }

//    public void setSql_consulta_temporal(String sql_consulta_temporal) {
//        this.sql_consulta_temporal = sql_consulta_temporal;
//    }
    public Double getValor_igv() {
        return valor_igv;
    }

    public void setValor_igv(Double valor_igv) {
        this.valor_igv = valor_igv;
    }

    public Boolean getConceros() {
        return Conceros;
    }

    public void setConceros(Boolean Conceros) {
        this.Conceros = Conceros;
    }

    public String getOp_seleccionada() {
        return op_seleccionada;
    }

    public void setOp_seleccionada(String op_seleccionada) {
        this.op_seleccionada = op_seleccionada;
    }

    public String getsSistemaOperativo() {
        return sSistemaOperativo;
    }

    public void setsSistemaOperativo(String sSistemaOperativo) {
        this.sSistemaOperativo = sSistemaOperativo;
    }

    public String getCurrentDir() {
        File currentDirFile = new File(".");
        String helper = currentDirFile.getAbsolutePath();
        String dir ="";
//        System.out.print(helper);
        dir = helper.substring(0, helper.length() - 2); //this line may need a try-catch
        return dir;
    }
    
    public String txtSqlFecha(java.util.Date fecha){
        String txt;
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		        
		txt = dateFormat.format(fecha);
        
        
        return txt;
    }
    
    public int tranfiere_factores(String txt_fecha_sql){
        int error=0;
    String ssq = "SELECT CPROV_ID,CPROV_NOM,Cart_Id,Nfactor_De_Venta,Nfactor_De_Consumo,Nfactor_A_Reporte FROM FACTORES";
        String sql;
        try {
            PreparedStatement psc = this.conectar().prepareStatement(ssq);
            ResultSet rsc = psc.executeQuery();
            while (rsc.next()) {
                 sql="UPDATE sistema_fecha SET CPROV_ID=?,CPROV_NOM=?,Nfactor_De_Venta = ?,Nfactor_De_Consumo=?,Nfactor_A_Reporte=? "
                        + "WHERE  Cart_Id =? and Fecha_recuento=?";
                PreparedStatement ps = this.conectar().prepareStatement(sql);
                ps.setString(1, rsc.getNString("CPROV_ID"));
                ps.setString(2, rsc.getNString("CPROV_NOM"));
                ps.setString(3, rsc.getNString("Nfactor_De_Venta"));
                ps.setString(4, rsc.getNString("Nfactor_De_Consumo"));
                ps.setString(5, rsc.getNString("Nfactor_A_Reporte"));
                ps.setString(6, rsc.getNString("Cart_Id"));
                ps.setString(7, txt_fecha_sql);
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Configuracion_factores.class.getName()).log(Level.SEVERE, null, ex);
            error=1;
        }    
        
     return error;   
    }
    
    public void carga_totales_chess(String txt_fecha_sql){
        String ssq = "select Cart_Id,Nfactor_De_Venta,CDESCRIPCION_CAT_4,CDESCRIPCION_CAT_5  FROM sistema_fecha and Fecha_recuento=?";
        String sql;
        try {
            PreparedStatement ps = this.conectar().prepareStatement(ssq);
            ps.setString(1, txt_fecha_sql);
            ResultSet rsc = ps.executeQuery();
            while (rsc.next()) {
                 sql="UPDATE sistema_fecha SET NC_ALMA =?"
                        + "WHERE  Cart_Id =? and Fecha_recuento=?";
                PreparedStatement ps1  = this.conectar().prepareStatement(sql);
                ps1.setDouble(1, (rsc.getDouble("CDESCRIPCION_CAT_4")*rsc.getDouble("Nfactor_De_Venta"))+rsc.getDouble("CDESCRIPCION_CAT_5"));
                ps1.setString(2, rsc.getString("Cart_Id"));
                ps1.setString(3, txt_fecha_sql);
                
                ps1.executeUpdate();
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Var.class.getName()).log(Level.SEVERE, null, ex);
        }
   
        
        
    }

}

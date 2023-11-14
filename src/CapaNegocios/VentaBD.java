/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaNegocios;

import CapaConexion.Conexion;
import CapaDatos.Venta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author saucedo
 */
public class VentaBD {

    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sql;

    public int registrarVenta(Venta v) {
        int idventa = 0;

        sql = "INSERT INTO venta(idventa,vFecha,vHora,vDocumento,vCorrelativo,vTipoPago,vFormaPago,vEstado,vMoneda,vSubTotal,vIgv,vTotalPagar,vPagoCon,vVuelto,cliRuc_Dni,uDni,tienda) "
                + "VALUES (NULL,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            cn = mysql.conectar();
            PreparedStatement pst = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pst.setString(1, v.getvFecha());
            pst.setString(2, v.getvHora());
            pst.setString(3, v.getvDocumento());
            pst.setString(4, v.getvCorrelativo());
            pst.setString(5, v.getvTipoPago());
            pst.setString(6, v.getvFormaPago());
            pst.setString(7, v.getvEstado());
            pst.setString(8, v.getvMoneda());
            pst.setDouble(9, v.getvSubTotal());
            pst.setInt(10, v.getvIgv());
            pst.setDouble(11, v.getvTotalPagar());
            pst.setDouble(12, v.getvPagoCon());
            pst.setDouble(13, v.getvVuelto());
            pst.setString(14, v.getCliRuc_Dni());
            pst.setString(15, v.getuDni());
            pst.setString(16, v.getTienda());

            pst.executeUpdate();
            ResultSet resultado = (ResultSet) pst.getGeneratedKeys();
            if (resultado.next()) {
                idventa = resultado.getInt(1);
            }
            pst.close();
            cn.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Problemas al registrar venta....", JOptionPane.ERROR_MESSAGE);

            return -1;
        }
        return idventa;
    }

    public DefaultTableModel buscarVentaAnular(String correlativo, String documento, String fecha, String tienda) {
        DefaultTableModel modelo = null;
        String[] titulos = {"idventa", "vFecha", "vHora", "vDocumento", "vCorrelativo", "vTipoPago", "vFormaPago", "vEstado", "vMoneda", "vSubTotal", "vIgv", "vTotalPagar",
            "vPagoCon", "vVuelto", "cliRuc_Dni", "cliDatos", "uDni", "tienda"};

        String[] registros = new String[18];
        modelo = new DefaultTableModel(null, titulos);

        sql = "SELECT idventa,vFecha,vHora,vDocumento,vCorrelativo,vTipoPago,vFormaPago,vEstado,vMoneda,vSubTotal,vIgv,vTotalPagar,vPagoCon,vVuelto,v.cliRuc_Dni,cliDatos,"
                + "uDni,tienda FROM venta AS v "
                + "INNER JOIN cliente AS c ON v.cliRuc_Dni=c.cliRuc_Dni "
                + "WHERE vCorrelativo=? AND vDocumento=? AND vFecha=? AND tienda=?";
        try {
            cn = mysql.conectar();
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, correlativo);
            pst.setString(2, documento);
            pst.setString(3, fecha);
            pst.setString(4, tienda);

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {

                registros[0] = rs.getString("idventa");
                registros[1] = rs.getString("vFecha");
                registros[2] = rs.getString("vHora");
                registros[3] = rs.getString("vDocumento");
                registros[4] = rs.getString("vCorrelativo");
                registros[5] = rs.getString("vTipoPago");
                registros[6] = rs.getString("vFormaPago");
                registros[7] = rs.getString("vEstado");
                registros[8] = rs.getString("vMoneda");
                registros[9] = rs.getString("vSubTotal");
                registros[10] = rs.getString("vIgv");
                registros[11] = rs.getString("vTotalPagar");
                registros[12] = rs.getString("vPagoCon");
                registros[13] = rs.getString("vVuelto");
                registros[14] = rs.getString("cliRuc_Dni");
                registros[15] = rs.getString("cliDatos");
                registros[16] = rs.getString("uDni");
                registros[17] = rs.getString("tienda");

                modelo.addRow(registros);

            }

            pst.close();
            cn.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Error al buscar venta variosBD ....", JOptionPane.ERROR_MESSAGE);

            return null;
        }
        return modelo;
    }

    public boolean ActualizarEstadoVenta(Venta v) {
        boolean rpta = false;
        sql = "UPDATE venta SET vEstado=? WHERE idventa=?";
        try {
            cn = mysql.conectar();
            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setString(1, v.getvEstado());
            pst.setInt(2, v.getIdventas());

            rpta = pst.executeUpdate() == 1 ? true : false;

            pst.close();
            cn.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
            return rpta;
        }
        return rpta;
    }

    public DefaultTableModel reportarVentaVarios(String fechaInicio, String fechaFinal, String tipoPago, String estado, String tienda) {
        DefaultTableModel modelo = null;
        String[] titulos = {"idventa", "vFecha", "vHora", "vDocumento", "vCorrelativo", "vTipoPago", "vFormaPago", "vEstado", "vMoneda", "vSubTotal", "vIgv", "vTotalPagar",
            "vPagoCon", "vVuelto", "cliRuc_Dni", "cliDatos", "uDni", "tienda"};

        String[] registros = new String[18];
        modelo = new DefaultTableModel(null, titulos);

        sql = "SELECT idventa,vFecha,vHora,vDocumento,vCorrelativo,vTipoPago,vFormaPago,vEstado,vMoneda,vSubTotal,vIgv,vTotalPagar,vPagoCon,vVuelto,v.cliRuc_Dni,cliDatos,"
                + "uDni,tienda FROM venta AS v "
                + "INNER JOIN cliente AS c ON v.cliRuc_Dni=c.cliRuc_Dni "
                + "WHERE (vFecha BETWEEN ? AND ?) AND vTipoPago=? AND vEstado=? AND tienda=?";
        try {
            cn = mysql.conectar();
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, fechaInicio);
            pst.setString(2, fechaFinal);
            pst.setString(3, tipoPago);
            pst.setString(4, estado);
            pst.setString(5, tienda);

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {

                registros[0] = rs.getString("idventa");
                registros[1] = rs.getString("vFecha");
                registros[2] = rs.getString("vHora");
                registros[3] = rs.getString("vDocumento");
                registros[4] = rs.getString("vCorrelativo");
                registros[5] = rs.getString("vTipoPago");
                registros[6] = rs.getString("vFormaPago");
                registros[7] = rs.getString("vEstado");
                registros[8] = rs.getString("vMoneda");
                registros[9] = rs.getString("vSubTotal");
                registros[10] = rs.getString("vIgv");
                registros[11] = rs.getString("vTotalPagar");
                registros[12] = rs.getString("vPagoCon");
                registros[13] = rs.getString("vVuelto");
                registros[14] = rs.getString("cliRuc_Dni");
                registros[15] = rs.getString("cliDatos");
                registros[16] = rs.getString("uDni");
                registros[17] = rs.getString("tienda");

                modelo.addRow(registros);

            }

            pst.close();
            cn.close();

            return modelo;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Error al reportar venta variosBD ....", JOptionPane.ERROR_MESSAGE);

            return null;
        }
    }

    public DefaultTableModel reportarVentaDocumentos(String fechaInicio, String fechaFinal, String documento, String estado, String tienda) {
        DefaultTableModel modelo = null;
        String[] titulos = {"idventa", "vFecha", "vHora", "vDocumento", "vCorrelativo", "vTipoPago", "vFormaPago", "vEstado", "vMoneda", "vSubTotal", "vIgv", "vTotalPagar",
            "vPagoCon", "vVuelto", "cliRuc_Dni", "cliDatos", "uDni", "tienda"};

        String[] registros = new String[18];
        modelo = new DefaultTableModel(null, titulos);

        sql = "SELECT idventa,vFecha,vHora,vDocumento,vCorrelativo,vTipoPago,vFormaPago,vEstado,vMoneda,vSubTotal,vIgv,vTotalPagar,vPagoCon,vVuelto,v.cliRuc_Dni,cliDatos,"
                + "uDni,tienda FROM venta AS v "
                + "INNER JOIN cliente AS c ON v.cliRuc_Dni=c.cliRuc_Dni "
                + "WHERE (vFecha BETWEEN ? AND ?) AND vDocumento=? AND vEstado=? AND tienda=?";
        try {
            cn = mysql.conectar();
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, fechaInicio);
            pst.setString(2, fechaFinal);
            pst.setString(3, documento);
            pst.setString(4, estado);
            pst.setString(5, tienda);

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {

                registros[0] = rs.getString("idventa");
                registros[1] = rs.getString("vFecha");
                registros[2] = rs.getString("vHora");
                registros[3] = rs.getString("vDocumento");
                registros[4] = rs.getString("vCorrelativo");
                registros[5] = rs.getString("vTipoPago");
                registros[6] = rs.getString("vFormaPago");
                registros[7] = rs.getString("vEstado");
                registros[8] = rs.getString("vMoneda");
                registros[9] = rs.getString("vSubTotal");
                registros[10] = rs.getString("vIgv");
                registros[11] = rs.getString("vTotalPagar");
                registros[12] = rs.getString("vPagoCon");
                registros[13] = rs.getString("vVuelto");
                registros[14] = rs.getString("cliRuc_Dni");
                registros[15] = rs.getString("cliDatos");
                registros[16] = rs.getString("uDni");
                registros[17] = rs.getString("tienda");

                modelo.addRow(registros);

            }

            pst.close();
            cn.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Error al reportar venta variosBD ....", JOptionPane.ERROR_MESSAGE);

            return null;
        }
        return modelo;
    }

    public DefaultTableModel reportarVentaCliente(String cliente, String tienda) {
        DefaultTableModel modelo = null;
        String[] titulos = {"idventa", "vFecha", "vHora", "vDocumento", "vCorrelativo", "vTipoPago", "vFormaPago", "vEstado", "vMoneda", "vSubTotal", "vIgv", "vTotalPagar",
            "vPagoCon", "vVuelto", "cliRuc_Dni", "cliDatos", "uDni", "tienda"};

        String[] registros = new String[18];
        modelo = new DefaultTableModel(null, titulos);

        sql = "SELECT idventa,vFecha,vHora,vDocumento,vCorrelativo,vTipoPago,vFormaPago,vEstado,vMoneda,vSubTotal,vIgv,vTotalPagar,vPagoCon,vVuelto,v.cliRuc_Dni,cliDatos,"
                + "uDni,tienda FROM venta AS v "
                + "INNER JOIN cliente AS c ON v.cliRuc_Dni=c.cliRuc_Dni "
                + "WHERE cliDatos LIKE ? AND tienda=? LIMIT 0,50";
        try {
            cn = mysql.conectar();
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, "%" + cliente + "%");
            pst.setString(2, tienda);

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {

                registros[0] = rs.getString("idventa");
                registros[1] = rs.getString("vFecha");
                registros[2] = rs.getString("vHora");
                registros[3] = rs.getString("vDocumento");
                registros[4] = rs.getString("vCorrelativo");
                registros[5] = rs.getString("vTipoPago");
                registros[6] = rs.getString("vFormaPago");
                registros[7] = rs.getString("vEstado");
                registros[8] = rs.getString("vMoneda");
                registros[9] = rs.getString("vSubTotal");
                registros[10] = rs.getString("vIgv");
                registros[11] = rs.getString("vTotalPagar");
                registros[12] = rs.getString("vPagoCon");
                registros[13] = rs.getString("vVuelto");
                registros[14] = rs.getString("cliRuc_Dni");
                registros[15] = rs.getString("cliDatos");
                registros[16] = rs.getString("uDni");
                registros[17] = rs.getString("tienda");

                modelo.addRow(registros);

            }

            pst.close();
            cn.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Error al reportar venta variosBD ....", JOptionPane.ERROR_MESSAGE);

            return null;
        }
        return modelo;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaNegocios;

import CapaConexion.Conexion;
import CapaDatos.DetalleVenta;
import CapaDatos.Deuda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Saucedo
 */
public class DeudaBD {
     private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sql;
    boolean rpta = false;

    public boolean registrarDeuda(Deuda d) {
      
        sql = "INSERT INTO  deuda(iddeuda,cliRuc_Dni,totalDeuda,saldo,fechaApertura,fechaCierre,estado,tienda)VALUES (0,?,?,?,?,?,?,?)";
        try {
            cn = mysql.conectar();
            PreparedStatement pst = cn.prepareStatement(sql);
            
            pst.setString(1, d.getCliRuc_Dni());
            pst.setDouble(2, d.getTotalDeuda());
            pst.setDouble(3, d.getSaldo());
            pst.setString(4, d.getFechaApertura());
            pst.setString(5, d.getFechaCierre());
            pst.setString(6, d.getEstado());
            pst.setString(7, d.getTienda());
            
            

            rpta = pst.executeUpdate() == 1 ? true : false;
            pst.close();
            cn.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Problemas al registrar ....", JOptionPane.ERROR_MESSAGE);

            return false;
        }
        return true;
    
    }
    public boolean actualizarDeuda(Deuda d) {
        boolean rpta = false;

        sql = "UPDATE deuda SET totalDeuda=?,saldo=?,fechacierre=?,estado=? WHERE iddeuda=?";
        try {
            cn = mysql.conectar();
            PreparedStatement pst = cn.prepareStatement(sql);
            
            pst.setDouble(1, d.getTotalDeuda());
            pst.setDouble(2, d.getSaldo());
            pst.setString(3, d.getFechaCierre());
            pst.setString(4, d.getEstado());
            pst.setInt(5, d.getIddeuda());
           
            rpta = pst.executeUpdate() == 1 ? true : false;
            pst.close();
            cn.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Problemas al actualizar ....", JOptionPane.ERROR_MESSAGE);

            return rpta;
        }
        return rpta;
    }
    
     public DefaultTableModel buscarDeuda(String cliRucDni,String estado, String tienda) {

        DefaultTableModel modelo;
        String[] titulos = {"ID", "CLIENTE", "TOTAL_DEUDA", "SALDO", "FECHA_APERTURA", "FEHA_CIERRE", "ESTADO", "TIENDA"};
        String[] registros = new String[8];
        modelo = new DefaultTableModel(null, titulos);
        sql = "SELECT iddeuda,cliDatos,totalDeuda,saldo,fechaApertura,fechaCierre,estado,tienda FROM deuda AS d "
                + "INNER JOIN cliente AS c ON d.cliRuc_Dni=c.cliRuc_Dni "
                + "WHERE d.cliRuc_Dni=? AND estado=?, AND tienda=?";

        try {
            cn = mysql.conectar();
        
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, cliRucDni);
            pst.setString(2, estado);
            pst.setString(3, tienda);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                registros[0] = rs.getString("iddeuda");
                registros[1] = rs.getString("cliDatos");
                registros[2] = rs.getString("totalDeuda");
                registros[3] = rs.getString("saldo");
                registros[4] = rs.getString("fechaApertura");
                registros[5] = rs.getString("fechaCierre");
                registros[6] = rs.getString("estado");
                registros[7] = rs.getString("tienda");
               
                modelo.addRow(registros);
            }
            pst.close();
            cn.close();

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e, "Error al buscar deuda....", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return modelo;
     }
     public DefaultTableModel reportarDeuda(String tienda) {

        DefaultTableModel modelo;
        String[] titulos = {"ID", "RUC_DNI", "CLIENTE", "TOTAL_DEUDA", "SALDO", "FECHA_APERTURA", "FECHA_CIERRE", "ESTADO","TIENDA"};
        String[] registros = new String[9];
        modelo = new DefaultTableModel(null, titulos);
        sql = "SELECT iddeuda,c.cliRuc_Dni AS dni_ruc,cliDatos,totalDeuda,saldo,fechaApertura,fechaCierre,estado,tienda FROM deuda AS d "
                + "INNER JOIN cliente AS c ON d.cliRuc_Dni=c.cliRuc_Dni "
                + "WHERE tienda=?";

        try {
            cn = mysql.conectar();
        
            PreparedStatement pst = cn.prepareStatement(sql);
           
            pst.setString(1, tienda);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                registros[0] = rs.getString("iddeuda");
                registros[1] = rs.getString("dni_ruc");
                registros[2] = rs.getString("cliDatos");
                registros[3] = rs.getString("totalDeuda");
                registros[4] = rs.getString("saldo");
                registros[5] = rs.getString("fechaApertura");
                registros[6] = rs.getString("fechaCierre");
                registros[7] = rs.getString("estado");
                registros[8] = rs.getString("tienda");
               
                modelo.addRow(registros);
            }
            pst.close();
            cn.close();

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e, "Error al reportar deuda....", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return modelo;
     }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaNegocios;

import CapaConexion.Conexion;
import CapaDatos.DetalleCompra;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Saucedo
 */
public class DetalleCompraBD {

    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sql;

    public boolean registrarDetalleCompra(DetalleCompra d) {
        sql = "INSERT INTO detallecompra(idcompra,pSerie,dcCantidad,dcPrecio,dcImporte,dcLote,dcPresentacion) VALUES(?,?,?,?,?,?,?)";

        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, d.getIdcompra());
            pst.setString(2, d.getpSerie());
            pst.setDouble(3, d.getDcCantidad());
            pst.setDouble(4, d.getDcPrecio());
            pst.setDouble(5, d.getDcImporte());
            pst.setString(6, d.getDcLote());
            pst.setString(7, d.getDcPresentacion());

            pst.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Problemas al registrar detalle de CompraBD....", JOptionPane.ERROR_MESSAGE);

            return false;
        }
        return true;
    }

    public DefaultTableModel buscarDetalleCompra(int idcompra) {

        DefaultTableModel modelo;
        String[] titulos = {"ID ", "SERIE", "PRODUCTO", "CANTIDAD", "PRECIO", "IMPORTE", "LOTE", "PRESENTACION"};
        String[] registros = new String[8];
        modelo = new DefaultTableModel(null, titulos);
        sql = "SELECT idcompra,dc.pSerie,pDescripcion,dcCantidad,dcPrecio,dcImporte,dcLote,dcPresentacion FROM detallecompra AS dc "
                + "INNER JOIN producto AS p ON dc.pSerie=p.pSerie "
                + "WHERE idcompra=?";

        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, idcompra);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                registros[0] = rs.getString("idcompra");
                registros[1] = rs.getString("pSerie");
                registros[2] = rs.getString("pDescripcion");
                registros[3] = rs.getString("dcCantidad");
                registros[4] = rs.getString("dcPrecio");
                registros[5] = rs.getString("dcImporte");
                registros[6] = rs.getString("dcLote");
                registros[7] = rs.getString("dcPresentacion");
                

                modelo.addRow(registros);
            }
            pst.close();
            cn.close();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e, "Error al buscar detalle compraBD....", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        return modelo;

    }
     public boolean eliminarDetalleCompra(int idcompra) {
        boolean rpta = false;
    
        sql = "DELETE FROM detallecompra WHERE idcompra=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, idcompra);
            

            rpta = pst.executeUpdate() == 1 ? true:false;

            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Problemas al eliminar detalle de la compra BD....", JOptionPane.ERROR_MESSAGE);
           

            return rpta;
        }
        return rpta;
    }
}

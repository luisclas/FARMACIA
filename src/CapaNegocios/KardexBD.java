/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaNegocios;

import CapaConexion.Conexion;
import CapaDatos.Compra;
import CapaDatos.Kardex;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Saucedo
 */
public class KardexBD {

    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sql;

    public boolean registrarKardex(Kardex k) {
        boolean rpta = false;

        sql = "INSERT INTO kardex(idkardex,fecha,hora,tipoOperacion,kDescripcion,pSerie,lote,presentacion,kCantidad,kPrecio,kImporte,tienda,idventa) "
                + "VALUES (0,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            cn = mysql.conectar();
            PreparedStatement pst = cn.prepareStatement(sql);
            
            pst.setString(1, k.getFecha());
            pst.setString(2, k.getHora());
            pst.setString(3, k.getTipoOperacion());
            pst.setString(4, k.getkDescripcion());
            pst.setString(5, k.getpSerie());
            pst.setString(6, k.getLote());
            pst.setString(7, k.getPresentacion());
            pst.setDouble(8, k.getkCantidad());
            pst.setDouble(9, k.getkPrecio());
            pst.setDouble(10, k.getkImporte());
            pst.setString(11, k.getTienda());
            pst.setInt(12, k.getIdventa());

            rpta = pst.executeUpdate() == 1 ? true : false;
            pst.close();
            cn.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Problemas al registrar IdKardexBD....", JOptionPane.ERROR_MESSAGE);

            return rpta;
        }
        return rpta;
    }

}

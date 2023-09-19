/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaNegocios;

import CapaConexion.Conexion;
import CapaDatos.Usuario;
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
public class UsuarioBD {

    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sql;

    public DefaultTableModel reportarUsuarios() {

        DefaultTableModel tabla_temporal;
        String[] titulos = {"DNI", "NOMBRES", "APELLIDOS", "DIRECCION", "CLAVE", "CELULAR", "TIPO_USUARIO", "TIENDA"};
        String[] registros = new String[8];
        tabla_temporal = new DefaultTableModel(null, titulos);
        sql = "SELECT uDni,uNombre,uApellidos,uDireccion,uClave,uCelular,tuNombre,tienda FROM usuario AS u "
                + "INNER JOIN tipousuario AS tp ON u.idtipousuario=tp.idtipousuario";

        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                registros[0] = rs.getString("uDni");
                registros[1] = rs.getString("uNombre");
                registros[2] = rs.getString("uApellidos");
                registros[3] = rs.getString("uDireccion");
                registros[4] = rs.getString("uClave");
                registros[5] = rs.getString("uCelular");
                registros[6] = rs.getString("tuNombre");
                registros[7] = rs.getString("tienda");

                tabla_temporal.addRow(registros);
            }
            return tabla_temporal;
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e, "Error al reportar usuario BD....", JOptionPane.ERROR_MESSAGE);
            return null;
        }

    }

    public boolean registrarUsuarios(Usuario u) {
        boolean rpta = false;
        sql = "INSERT INTO usuario(uDni,uNombre,uApellidos,uDireccion,uClave,uCelular,idtipousuario,tienda) VALUES (?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, u.getuDni());
            pst.setString(2, u.getuNombre());
            pst.setString(3, u.getuApellidos());
            pst.setString(4, u.getuDireccion());
            pst.setString(5, u.getuClave());
            pst.setString(6, u.getuCelular());
            pst.setInt(7, u.getuTipo());
            pst.setString(8, u.getTienda());

            rpta = pst.executeUpdate() == 1 ? true : false;
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e, "Problemas al registrar usuario BD", JOptionPane.ERROR_MESSAGE);
            return rpta;
        }
        return rpta;
    }

    public boolean modificarUsuario(Usuario u) {
        boolean rpta = false;
        sql = "UPDATE usuario SET uNombre=?,uApellidos=?,uDireccion=?,uClave=?,uCelular=?,idtipousuario=?,tienda=? WHERE uDni=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setString(1, u.getuNombre());
            pst.setString(2, u.getuApellidos());
            pst.setString(3, u.getuDireccion());
            pst.setString(4, u.getuClave());
            pst.setString(5, u.getuCelular());
            pst.setInt(6, u.getuTipo());
            pst.setString(7, u.getTienda());
            pst.setString(8, u.getuDni());

            rpta = pst.executeUpdate() == 1 ? true : false;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return rpta;
        }
        return rpta;
    }

    public boolean eliminarUsuario(String dni) {
        boolean rpta = false;

        try {
            sql = " DELETE FROM usuario WHERE uDni=?";
            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setString(1, dni);

            rpta = pst.executeUpdate() == 1 ? true : false;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Problemas al eliminar un usuario BD", JOptionPane.ERROR_MESSAGE);
            return rpta;
        }
        return rpta;
    }

    public DefaultTableModel buscarUsuarioXdni(String dni) {

        DefaultTableModel tabla_temporal;
        String[] titulos = {"DNI", "NOMBRES", "APELLIDOS", "DIRECCION", "CLAVE", "CELULAR", "TIPO_USUARIO", "TIENDA"};
        String[] registros = new String[8];
        tabla_temporal = new DefaultTableModel(null, titulos);
        sql = "SELECT uDni,uNombre,uApellidos,uDireccion,uClave,uCelular,tuNombre,tienda FROM usuario AS u "
                + "INNER JOIN tipousuario AS tp ON u.idtipousuario=tp.idtipousuario "
                + "WHERE uDni=?";

        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, dni);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                registros[0] = rs.getString("uDni");
                registros[1] = rs.getString("uNombre");
                registros[2] = rs.getString("uApellidos");
                registros[3] = rs.getString("uDireccion");
                registros[4] = rs.getString("uClave");
                registros[5] = rs.getString("uCelular");
                registros[6] = rs.getString("tuNombre");
                registros[7] = rs.getString("tienda");

                tabla_temporal.addRow(registros);
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e, "Error al buscar usuario BD....", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return tabla_temporal;

    }
    public DefaultTableModel buscarUsuario(String apellidos){
    DefaultTableModel tabla_temporal;
    String [] titulos = {"DNI", "NOMBRES", "APELLIDOS", "DIRECCION","CLAVE", "CELULAR", "TIPO_USUARIO", "TIENDA"};
    String [] registro = new String [8];
    tabla_temporal = new DefaultTableModel(null, titulos);
    
    sql= "SELECT uDni,uNombre,uApellidos,uDireccion,uClave,uCelular,tuNombre,tienda FROM usuario AS u "
            + "INNER JOIN tipousuario AS tp ON u.idtipousuario=tp.idtipousuario "
            + "WHERE uApellidos LIKE  '%" + apellidos + "%' OR uNombre LIKE '%" + apellidos + "%'";
    
    try {
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            registro [0] = rs.getString("uDni");
            registro [1] = rs.getString("uNombre");
            registro [2] = rs.getString("uApellidos");
            registro [3] = rs.getString("uDireccion");
            registro[4] = rs.getString("uClave");
            registro [5] = rs.getString("uCelular");
            registro [6] = rs.getString("tuNombre");
            registro [7] = rs.getString("tienda");
            
         tabla_temporal.addRow(registro);
            
        }
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e, "ERROR AL BUSCAR APELLIDOS....", JOptionPane.ERROR_MESSAGE);
        return null;
    
    }
    return tabla_temporal;
}
   
}

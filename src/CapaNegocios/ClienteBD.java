/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaNegocios;

import CapaConexion.Conexion;
import CapaDatos.Categoria;
import CapaDatos.Cliente;
import CapaDatos.Composicion;
import CapaDatos.DetalleCaja;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Saucedo
 */
public class ClienteBD {

    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sql;

    public List<Cliente> reportarCliente() {

        List<Cliente> lista = new ArrayList<>();

        sql = "SELECT cliRuc_Dni,cliDatos,cliDireccion,cliCelular,cliCorreo FROM cliente";
        try {
            cn = mysql.conectar();
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                Cliente oCliente = new Cliente();

                oCliente.setCliRuc_Dni(rs.getString(1));
                oCliente.setCliDatos(rs.getString(2));
                oCliente.setCliDireccion(rs.getString(3));
                oCliente.setCliCelular(rs.getString(4));
                oCliente.setCliCorreo(rs.getString(5));

                lista.add(oCliente);
            }
            pst.close();
            cn.close();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e, "Error al reportar cliente BD....", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return lista;
    }
     public boolean registrarCliente(Cliente c) {
        boolean rpta = false;
    
        sql = "INSERT INTO cliente(cliRuc_Dni,cliDatos,cliDireccion,cliCelular,cliCorreo) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, c.getCliRuc_Dni());
            pst.setString(2, c.getCliDatos());
            pst.setString(3, c.getCliDireccion());
            pst.setString(4, c.getCliCelular());
            pst.setString(5, c.getCliCorreo());

            rpta = pst.executeUpdate() == 1 ? true:false;
            
            pst.close();
            cn.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Problemas al registrar Cliente....", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();

            return rpta;
        }
        return rpta;
    }
      public List<Cliente> buscarClienteXdni(String dni) {

        List<Cliente> lista = new ArrayList<>();

        sql = "SELECT cliRuc_Dni,cliDatos,cliDireccion,cliCelular,cliCorreo FROM cliente WHERE cliRuc_Dni=?";
        try {
            cn = mysql.conectar();
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, dni);
           ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                Cliente oCliente = new Cliente();

                oCliente.setCliRuc_Dni(rs.getString(1));
                oCliente.setCliDatos(rs.getString(2));
                oCliente.setCliDireccion(rs.getString(3));
                oCliente.setCliCelular(rs.getString(4));
                oCliente.setCliCorreo(rs.getString(5));
                
                lista.add(oCliente);

            }
            pst.close();
            cn.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al buscar categoria....", JOptionPane.ERROR_MESSAGE);
            return null;

        }
        return lista;
      
      }
      public boolean ModificarCliente(Cliente c) {
        boolean rpta = false;
    
        sql = "UPDATE cliente SET cliDatos=?,cliDireccion=?,cliCelular=?,cliCorreo=? WHERE cliRuc_Dni=?";
        try {
            cn = mysql.conectar();
        
            PreparedStatement pst = cn.prepareStatement(sql);
            
            pst.setString(1, c.getCliDatos());
            pst.setString(2, c.getCliDireccion());
            pst.setString(3, c.getCliCelular());
            pst.setString(4, c.getCliCorreo());
            pst.setString(5, c.getCliRuc_Dni());

            rpta = pst.executeUpdate() == 1 ? true:false;
            
            pst.close();
            cn.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
           
            return rpta;
        }
        return rpta;
}
      public boolean EliminarCliente(String dni_ruc) {
        boolean rpta = false;
    
        
        try {
            cn = mysql.conectar();
            sql = "DELETE FROM cliente WHERE cliRuc_Dni=?";
            PreparedStatement pst = cn.prepareStatement(sql);
            
            pst.setString(1,dni_ruc);
            
            rpta = pst.executeUpdate() == 1 ? true:false;
            
            pst.close();
            cn.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e,"Problemas al eliminar un cliente BD....",JOptionPane.ERROR_MESSAGE);
           
            return rpta;
        }
        return rpta;
      }
}
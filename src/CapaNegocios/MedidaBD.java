/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaNegocios;

import CapaConexion.Conexion;
import CapaDatos.Medida;
import CapaDatos.TipoUsuario;
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
public class MedidaBD {

    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sql;

    public DefaultTableModel reportarMedida() {
        DefaultTableModel modelo;
        String[] titulos = {"ID", "PRESENTACION","EQUIVALENCIA"};
        String[] registros = new String[3];
        modelo = new DefaultTableModel(null, titulos);
        sql = "SELECT idmedida,mPresentacion,mEquivalencia FROM medida";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                registros[0] = rs.getString("idmedida");
                registros[1] = rs.getString("mPresentacion");
                registros[2] = rs.getString("mEquivalencia");
                

                modelo.addRow(registros);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Error al reportar medida...", JOptionPane.ERROR_MESSAGE);
            return null;

        }
        return modelo;
    }
    public boolean registrarMedida(Medida m) {
        sql = "INSERT INTO medida(idmedida,mPresentacion,mEquivalencia) VALUES(0,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, m.getPrePresentacion());
            pst.setString(2, m.getPreEquivalencia());

            pst.executeUpdate();

            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Problemas al registrar medida ....", JOptionPane.ERROR_MESSAGE);

            return false;
        }
        return true;
    }
     public boolean modificarMedida(Medida m) {
        sql = "UPDATE medida SET mPresentacion=?,mEquivalencia=? WHERE idmedida=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, m.getPrePresentacion());
            pst.setString(2, m.getPreEquivalencia());
            pst.setInt(3, m.getIdmedida());

            pst.executeUpdate();

            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Problemas al modificar medida ....", JOptionPane.ERROR_MESSAGE);

            return false;
        }
        return true;
    }
      public boolean eliminarmedida(int codigo) {
        sql = "DELETE FROM medida WHERE idmedida=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1,codigo);
           
           

            pst.executeUpdate();

            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Problemas al eliminar medida ....", JOptionPane.ERROR_MESSAGE);

            return false;
        }
        return true;
    }
}

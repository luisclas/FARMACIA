/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaNegocios;

import CapaConexion.Conexion;
import CapaDatos.Asistencia;
import CapaDatos.Categoria;
import CapaDatos.Correlativo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Saucedo
 */
public class CorrelativoBD {

    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sql;

    public List<Correlativo> reportarCorrelativo(String tienda) {

        List<Correlativo> lista = new ArrayList<>();

        sql = "SELECT idcorrelativo,coSerie,coNumeracion,coDocumento,tienda FROM correlativo WHERE tienda=?";
        try {
            cn = mysql.conectar();
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, tienda);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                Correlativo oCorrelativo = new Correlativo();

                oCorrelativo.setCoCodigo(rs.getInt(1));
                oCorrelativo.setCoSerie(rs.getString(2));
                oCorrelativo.setCoNumeracion(rs.getString(3));
                oCorrelativo.setCoDocumento(rs.getString(4));
                oCorrelativo.setTienda(rs.getString(5));

                lista.add(oCorrelativo);

            }
            pst.close();
            cn.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al reportar correlativo....", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return null;

        }
        return lista;
    }

    public boolean registrarCorrelativo(Correlativo co) {
        boolean rpta = false;
        sql = "INSERT INTO correlativo(idcorrelativo,coSerie,coNumeracion,coDocumento,tienda) VALUES(0,?,?,?,?)";

        try {
            cn = mysql.conectar();
            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setString(1, co.getCoSerie());
            pst.setString(2, co.getCoNumeracion());
            pst.setString(3, co.getCoDocumento());
            pst.setString(4, co.getTienda());

            rpta = pst.executeUpdate() == 1 ? true : false;

            pst.close();
            cn.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Problemas al registrar .....", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return rpta;
        }
        return rpta;

    }

    public boolean modificarCorrelativo(Correlativo c) {
        boolean rpta = false;
        sql = "UPDATE correlativo SET coSerie=? , coNumeracion=? , coDocumento=? WHERE idcorrelativo=?";
        try {
            cn = mysql.conectar();
            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setString(1, c.getCoSerie());
            pst.setString(2, c.getCoNumeracion());
            pst.setString(3, c.getCoDocumento());
            pst.setInt(4, c.getCoCodigo());

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

    public boolean eliminarCorrelativo(int idcorrelativo) {
        boolean rpta = false;

        sql = "DELETE FROM correlativo WHERE idcorrelativo=?";
        try {
            cn = mysql.conectar();
            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setInt(1, idcorrelativo);

            rpta = pst.executeUpdate() == 1 ? true : false;

            pst.close();
            cn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Problemas al eliminar....", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();

            return rpta;
        }
        return rpta;
    }

    public List<Correlativo> sacarNumeracion(String documento, String tienda) {

        List<Correlativo> lista = new ArrayList<>();

        sql = "SELECT idcorrelativo,coSerie,coNumeracion,coDocumento FROM correlativo WHERE coDocumento=? AND tienda=?";
        try {
            cn = mysql.conectar();
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, documento);
            pst.setString(2, tienda);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                Correlativo oCorrelativo = new Correlativo();

                oCorrelativo.setCoSerie(rs.getString(2));
                oCorrelativo.setCoNumeracion(rs.getString(3));
                oCorrelativo.setCoDocumento(rs.getString(4));

                lista.add(oCorrelativo);

            }
            pst.close();
            cn.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al sacar correlativo....", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();

        }
        return lista;
    }

    public boolean actualizarCorrelativo(Correlativo c) {
        boolean rpta = false;

        sql = "UPDATE correlativo SET coNumeracion=? WHERE coDocumento=? AND tienda=?";
        try {
            cn = mysql.conectar();
            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setString(1, c.getCoNumeracion());
            pst.setString(2, c.getCoDocumento());
            pst.setString(3, c.getTienda());

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
}
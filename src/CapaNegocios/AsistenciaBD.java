/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaNegocios;

import CapaConexion.Conexion;
import CapaDatos.Asistencia;
import CapaDatos.Usuario;
import com.mysql.cj.jdbc.result.ResultSetInternalMethods;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Saucedo
 */
public class AsistenciaBD {
    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sql;
    
     public List<Asistencia> BuscarAsistenciaUsuario(String uDni, String tienda, String fecha) {

        List<Asistencia> lista = new ArrayList<>();

        sql = "SELECT idasistencias,aFechaE,aHoraE,aHoraS,uDni,aTurno,aEstado,aTienda FROM asistencias "
                + "WHERE uDni=? AND aTienda=? AND aFechaE=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, uDni);
            pst.setString(2, tienda);
            pst.setString(3, fecha);
            
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {
                
                Asistencia oAsistencia = new Asistencia();
                
                oAsistencia.setIdasistencias(rs.getInt(1));
                oAsistencia.setaFechaE(rs.getString(2));
                oAsistencia.setaHoraE(rs.getString(3));
                oAsistencia.setaHoraS(rs.getString(4));
                oAsistencia.setuDni(rs.getString(5));
                oAsistencia.setaTurno(rs.getString(6));
                oAsistencia.setaEstado(rs.getString(7));
                oAsistencia.setTienda(rs.getString(8));
                
                lista.add(oAsistencia);
                
                
            }
            

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null,e,"Error al buscar asistencia....", JOptionPane.ERROR_MESSAGE);
            return null;
            
        }
        return lista;
   
}
     
     public int registrarAsistencia(Asistencia a) {
        int idasistencia = 0;
        sql = "INSERT INTO asistencias(idasistencias,aFechaE,aHoraE,aHoraS,uDni,aTurno,aEstado,aTienda) "
                + "VALUES(0,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

            pst.setString(1, a.getaFechaE());
            pst.setString(2, a.getaHoraE());
            pst.setString(3, a.getaHoraS());
            pst.setString(4, a.getuDni());
            pst.setString(5, a.getaTurno());
            pst.setString(6, a.getaEstado());
            pst.setString(7, a.getTienda());
            
            pst.executeUpdate();
            ResultSet resultado = (ResultSet) pst.getGeneratedKeys();
            
            if (resultado.next()) {
                idasistencia = resultado.getInt(1);
            
                
            }
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e,"Problemas al registrar AsistenciaBD.....",JOptionPane.ERROR_MESSAGE);
            return -1;
        }
        return idasistencia;
     }
      public boolean actualizarAsistencia(Asistencia a) {
        boolean rpta = false;
        sql = "UPDATE asistencias SET aHoraS=?, aEstado=? WHERE idasistencias=?";

        try {
            cn = mysql.conectar();
            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setString(1,a.getaHoraS());
            pst.setString(2,a.getaEstado());
            pst.setInt(3,a.getIdasistencias());
          
            rpta = pst.executeUpdate() == 1 ? true : false;

            pst.close();
            cn.close();
            
             return rpta;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al actualizar.....", JOptionPane.ERROR_MESSAGE);
            return rpta;
        }
       
    }
    
}

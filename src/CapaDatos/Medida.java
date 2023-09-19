/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaDatos;

/**
 *
 * @author Saucedo
 */
public class Medida {
    
    private int idmedida;
    private String prePresentacion;
    private String preEquivalencia;

    public Medida() {
    }

    public Medida(int idmedida, String prePresentacion, String preEquivalencia) {
        this.idmedida = idmedida;
        this.prePresentacion = prePresentacion;
        this.preEquivalencia = preEquivalencia;
    }

    public int getIdmedida() {
        return idmedida;
    }

    public void setIdmedida(int idmedida) {
        this.idmedida = idmedida;
    }

    public String getPrePresentacion() {
        return prePresentacion;
    }

    public void setPrePresentacion(String prePresentacion) {
        this.prePresentacion = prePresentacion;
    }

    public String getPreEquivalencia() {
        return preEquivalencia;
    }

    public void setPreEquivalencia(String preEquivalencia) {
        this.preEquivalencia = preEquivalencia;
    }

    
    
    
    
}

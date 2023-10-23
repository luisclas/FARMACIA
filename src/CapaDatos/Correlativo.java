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
public class Correlativo {
    private int coCodigo;
    private String coSerie;
    private String coNumeracion;
    private String coDocumento;
    private String tienda;

    public Correlativo() {
    }

    public int getCoCodigo() {
        return coCodigo;
    }

    public void setCoCodigo(int coCodigo) {
        this.coCodigo = coCodigo;
    }

    public String getCoSerie() {
        return coSerie;
    }

    public void setCoSerie(String coSerie) {
        this.coSerie = coSerie;
    }

    public String getCoNumeracion() {
        return coNumeracion;
    }

    public void setCoNumeracion(String coNumeracion) {
        this.coNumeracion = coNumeracion;
    }

    public String getCoDocumento() {
        return coDocumento;
    }

    public void setCoDocumento(String coDocumento) {
        this.coDocumento = coDocumento;
    }

    public String getTienda() {
        return tienda;
    }

    public void setTienda(String tienda) {
        this.tienda = tienda;
    }

}

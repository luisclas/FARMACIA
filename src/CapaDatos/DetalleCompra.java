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
public class DetalleCompra {
    
    private int idcompra;
    private String pSerie;
    private double dcCantidad;
    private double dcPrecio;
    private double dcImporte;
    private String dcLote;
    private String dcPresentacion;

    public DetalleCompra() {
    }

    public int getIdcompra() {
        return idcompra;
    }

    public void setIdcompra(int idcompra) {
        this.idcompra = idcompra;
    }

    public String getpSerie() {
        return pSerie;
    }

    public void setpSerie(String pSerie) {
        this.pSerie = pSerie;
    }

    public double getDcCantidad() {
        return dcCantidad;
    }

    public void setDcCantidad(double dcCantidad) {
        this.dcCantidad = dcCantidad;
    }

    public double getDcPrecio() {
        return dcPrecio;
    }

    public void setDcPrecio(double dcPrecio) {
        this.dcPrecio = dcPrecio;
    }

    public double getDcImporte() {
        return dcImporte;
    }

    public void setDcImporte(double dcImporte) {
        this.dcImporte = dcImporte;
    }

    public String getDcLote() {
        return dcLote;
    }

    public void setDcLote(String dcLote) {
        this.dcLote = dcLote;
    }

    public String getDcPresentacion() {
        return dcPresentacion;
    }

    public void setDcPresentacion(String dcPresentacion) {
        this.dcPresentacion = dcPresentacion;
    }
    
    
}

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
public class Kardex {

    private int idkardex;
    private String fecha;
    private String hora;
    private String tipoOperacion;
    private String kDescripcion;
    private String pSerie;
    private String lote;
    private String presentacion;
    private double kCantidad;
    private double kPrecio;
    private double kImporte;
    private String tienda;
    private int idventa;

    public Kardex() {
    }

    public int getIdkardex() {
        return idkardex;
    }

    public void setIdkardex(int idkardex) {
        this.idkardex = idkardex;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public String getkDescripcion() {
        return kDescripcion;
    }

    public void setkDescripcion(String kDescripcion) {
        this.kDescripcion = kDescripcion;
    }

    public String getpSerie() {
        return pSerie;
    }

    public void setpSerie(String pSerie) {
        this.pSerie = pSerie;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public double getkCantidad() {
        return kCantidad;
    }

    public void setkCantidad(double kCantidad) {
        this.kCantidad = kCantidad;
    }

    public double getkPrecio() {
        return kPrecio;
    }

    public void setkPrecio(double kPrecio) {
        this.kPrecio = kPrecio;
    }

    public double getkImporte() {
        return kImporte;
    }

    public void setkImporte(double kImporte) {
        this.kImporte = kImporte;
    }

    public String getTienda() {
        return tienda;
    }

    public void setTienda(String tienda) {
        this.tienda = tienda;
    }

    public int getIdventa() {
        return idventa;
    }

    public void setIdventa(int idventa) {
        this.idventa = idventa;
    }
    

}

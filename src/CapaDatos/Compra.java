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
public class Compra {
    private int idcompra;
    private String coFecha;
    private String coTipoDoc;
    private String coNroDoc;
    private String coTipoPago;
    private String coFormaPago;
    private String coMoneda;
    private double coSubTotal;
    private double coFlete;
    private double coIgv;
    private double coTotal;
    private String provRuc;
    private String uDni;
    private String tienda;

    public Compra() {
    }

    public int getIdcompra() {
        return idcompra;
    }

    public void setIdcompra(int idcompra) {
        this.idcompra = idcompra;
    }

    public String getCoFecha() {
        return coFecha;
    }

    public void setCoFecha(String coFecha) {
        this.coFecha = coFecha;
    }

    public String getCoTipoDoc() {
        return coTipoDoc;
    }

    public void setCoTipoDoc(String coTipoDoc) {
        this.coTipoDoc = coTipoDoc;
    }

    public String getCoNroDoc() {
        return coNroDoc;
    }

    public void setCoNroDoc(String coNroDoc) {
        this.coNroDoc = coNroDoc;
    }

    public String getCoTipoPago() {
        return coTipoPago;
    }

    public void setCoTipoPago(String coTipoPago) {
        this.coTipoPago = coTipoPago;
    }

    public String getCoFormaPago() {
        return coFormaPago;
    }

    public void setCoFormaPago(String coFormaPago) {
        this.coFormaPago = coFormaPago;
    }

    public String getCoMoneda() {
        return coMoneda;
    }

    public void setCoMoneda(String coMoneda) {
        this.coMoneda = coMoneda;
    }

    public double getCoSubTotal() {
        return coSubTotal;
    }

    public void setCoSubTotal(double coSubTotal) {
        this.coSubTotal = coSubTotal;
    }

    public double getCoFlete() {
        return coFlete;
    }

    public void setCoFlete(double coFlete) {
        this.coFlete = coFlete;
    }

    public double getCoIgv() {
        return coIgv;
    }

    public void setCoIgv(double coIgv) {
        this.coIgv = coIgv;
    }

    public double getCoTotal() {
        return coTotal;
    }

    public void setCoTotal(double coTotal) {
        this.coTotal = coTotal;
    }

    public String getProvRuc() {
        return provRuc;
    }

    public void setProvRuc(String provRuc) {
        this.provRuc = provRuc;
    }

    public String getuDni() {
        return uDni;
    }

    public void setuDni(String uDni) {
        this.uDni = uDni;
    }

    public String getTienda() {
        return tienda;
    }

    public void setTienda(String tienda) {
        this.tienda = tienda;
    }
    
    
    
}

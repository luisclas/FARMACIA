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
public class Caja {
    
    private int idcaja;
    private String caFecha;
    private String hora;
    private double total_ingreso;
    private double total_egreso;
    private double saldo_final;
    private String nroCaja;
    private String caEstado;
    private String uDni;
    private String tienda;

    public Caja() {
    }

    public int getIdcaja() {
        return idcaja;
    }

    public void setIdcaja(int idcaja) {
        this.idcaja = idcaja;
    }

    public String getCaFecha() {
        return caFecha;
    }

    public void setCaFecha(String caFecha) {
        this.caFecha = caFecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public double getTotal_ingreso() {
        return total_ingreso;
    }

    public void setTotal_ingreso(double total_ingreso) {
        this.total_ingreso = total_ingreso;
    }

    public double getTotal_egreso() {
        return total_egreso;
    }

    public void setTotal_egreso(double total_egreso) {
        this.total_egreso = total_egreso;
    }

    public double getSaldo_final() {
        return saldo_final;
    }

    public void setSaldo_final(double saldo_final) {
        this.saldo_final = saldo_final;
    }

    public String getNroCaja() {
        return nroCaja;
    }

    public void setNroCaja(String nroCaja) {
        this.nroCaja = nroCaja;
    }

    public String getCaEstado() {
        return caEstado;
    }

    public void setCaEstado(String caEstado) {
        this.caEstado = caEstado;
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

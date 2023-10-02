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
public class DetalleCuentasBancarias {
    
    private int idcuentas;
    private String banco;
    private String cuenta;
    private String nroCuenta;
    private String provRuc;

    public DetalleCuentasBancarias() {
    }

    public int getIdcuentas() {
        return idcuentas;
    }

    public void setIdcuentas(int idcuentas) {
        this.idcuentas = idcuentas;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getNroCuenta() {
        return nroCuenta;
    }

    public void setNroCuenta(String nroCuenta) {
        this.nroCuenta = nroCuenta;
    }

    public String getProvRuc() {
        return provRuc;
    }

    public void setProvRuc(String provRuc) {
        this.provRuc = provRuc;
    }
   
    
}

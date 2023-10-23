/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaPresentacion;

import CapaDatos.Asistencia;
import CapaDatos.Caja;
import CapaDatos.DetalleCaja;
import CapaDatos.Turno;
import CapaNegocios.AsistenciaBD;
import CapaNegocios.CajaBD;
import CapaNegocios.DetalleCajaBD;
import CapaNegocios.TurnoBD;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Saucedo
 */
public class Caja_IU extends javax.swing.JInternalFrame {

    double total_ingreso = 0.0;
    double total_egresos = 0.0;
    double saldo_hoy = 0.0;
    double saldo_anterior = 0.0;
    String tienda;
    String dni_usuario;
    String am_pm;
    int nueva_hora;
    String hh_mm_ss;
    double total_caja_hoy;

    /**
     * Creates new form Caja_IU
     */
    public Caja_IU() {
        initComponents();
        sacarFecha();
        sacarHora();
        sacarTotalIngresos();
        sacarTotalEgresos();
        mostrarSaldoHoy();
        saldoAnterior();
    }

    private void exito(String mensaje) {
        JOptionPane.showConfirmDialog(this, mensaje, "MENSAJE", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
    }

    private void error(String mensaje) {
        JOptionPane.showConfirmDialog(this, mensaje, "ERROR", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
    }

    private void advertencia(String mensaje) {
        JOptionPane.showConfirmDialog(this, mensaje, "ADVERTENCIA", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE);
    }

    private void sacarHora() {

        Calendar calendario = Calendar.getInstance();

        int hora = calendario.get(Calendar.HOUR_OF_DAY);
        int minutos = calendario.get(Calendar.MINUTE);
        int segundos = calendario.get(Calendar.SECOND);

        hh_mm_ss = hora + ":" + minutos + ":" + segundos;

        txtHora.setText(hh_mm_ss);
    }

    private void sacarFecha() {
        Calendar calendario = Calendar.getInstance();

        int dia = calendario.get(Calendar.DAY_OF_MONTH);
        int mes = calendario.get(Calendar.MONTH) + 1;
        int anio = calendario.get(Calendar.YEAR);

        String fecha = anio + "-" + mes + "-" + dia;

        txtFecha.setText(fecha);
    }

    private void sacarTotalIngresos() {
        DefaultTableModel tabla_temporal;
        DetalleCajaBD oDetalleCajaBD = new DetalleCajaBD();
        tienda = Login_IU.tienda;
        dni_usuario = Login_IU.dni_publico;
        tabla_temporal = oDetalleCajaBD.mostrarTotalDetalleDineroXtipo("INGRESO", "ABIERTO", tienda, dni_usuario, "CAJA NRO 1");
        if (tabla_temporal.getValueAt(0, 0) != null) {
            txtTotalIngresos.setText("S/." + tabla_temporal.getValueAt(0, 0));
            total_ingreso = Double.parseDouble(tabla_temporal.getValueAt(0, 0).toString());

        } else {
            total_ingreso = 0.00;
            txtTotalIngresos.setText("S/." + total_ingreso);
        }
    }

    private void sacarTotalEgresos() {
        DefaultTableModel tabla_temporal;
        DetalleCajaBD oDetalleCajaBD = new DetalleCajaBD();
        tienda = Login_IU.tienda;
        dni_usuario = Login_IU.dni_publico;
        tabla_temporal = oDetalleCajaBD.mostrarTotalDetalleDineroXtipo("EGRESO", "ABIERTO", tienda, dni_usuario, "CAJA NRO 1");
        if (tabla_temporal.getValueAt(0, 0) != null) {
            txtTotalEgresos.setText("S/." + tabla_temporal.getValueAt(0, 0));
            total_egresos = Double.parseDouble(tabla_temporal.getValueAt(0, 0).toString());

        } else {
            total_egresos = 0.00;
            txtTotalEgresos.setText("S/." + total_egresos);
        }
    }

    private void mostrarSaldoHoy() {
        saldo_hoy = total_ingreso - total_egresos;
        txtSaldoHoy.setText("S/." + saldo_hoy);

    }

    private void saldoAnterior() {
        CajaBD oCajaBD = new CajaBD();
        List<Caja> lista_saldo_anterior = oCajaBD.obtenerSaldoAnterior();

        if (lista_saldo_anterior.size() > 0) {
            lblSaldoAnterior.setText("SALDO ANTERIOR S/." + lista_saldo_anterior.get(0).getSaldo_final());
            saldo_anterior = lista_saldo_anterior.get(0).getSaldo_final();

            total_caja_hoy = saldo_anterior + saldo_hoy;
            lblTotalCaja.setText("S/." + total_caja_hoy);

        } else {
            saldo_anterior = 0.00;
            lblSaldoAnterior.setText("SALDO ANTERIOR S/." + saldo_anterior);
            total_caja_hoy = saldo_anterior + saldo_hoy;
            lblTotalCaja.setText("S/." + total_caja_hoy);
        }
    }
        
        private void cerrar_caja(){
            Caja oCaja = new Caja();
            CajaBD oCajaBD = new CajaBD();
            dni_usuario = Login_IU.dni_publico;
            oCaja.setCaFecha(txtFecha.getText());
            oCaja.setHora(txtHora.getText());
            oCaja.setTotal_ingreso(total_ingreso);
            oCaja.setTotal_egreso(total_egresos);
            oCaja.setSaldo_final(total_caja_hoy);
            oCaja.setNroCaja("CAJA NRO 1");
            oCaja.setCaEstado("CERRADO");
            oCaja.setuDni(dni_usuario);
            oCaja.setTienda(tienda);
            
            boolean rpta = oCajaBD.registrarCaja(oCaja);
            if (rpta) {
                exito("Se cerro la caja con exito....");
            } else {
                error("Tienes problemas para cerrar la caja...");
            }
        }
        public void cerrar_detalle_caja(){
            DetalleCajaBD oDetalleCajaBD = new DetalleCajaBD();
            oDetalleCajaBD.actualizarEstado("CERRADO",Login_IU.dni_publico,Login_IU.tienda,"CAJA NRO 1");
        }
        public void control_asistencia_salida(){
            Asistencia oAsistencia = new Asistencia();
            AsistenciaBD oAsistenciaBD = new AsistenciaBD();
            
            oAsistencia.setaHoraS(txtHora.getText());
            oAsistencia.setaEstado("CERRADO");
            oAsistencia.setIdasistencias(Login_IU.idasistencia);
            oAsistenciaBD.actualizarAsistencia(oAsistencia);
            
            

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblSaldoAnterior = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtTotalIngresos = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTotalEgresos = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtSaldoHoy = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtHora = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        lblTotalCaja = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JButton();
        btnCerrarCaja = new javax.swing.JButton();
        chkCerrarAntes = new javax.swing.JCheckBox();

        setBackground(new java.awt.Color(204, 255, 255));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("CAJA");

        lblSaldoAnterior.setBackground(new java.awt.Color(0, 204, 204));
        lblSaldoAnterior.setFont(new java.awt.Font("Calibri", 0, 48)); // NOI18N
        lblSaldoAnterior.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSaldoAnterior.setText("SALDO ANTERIOR S/. 0,00");
        lblSaldoAnterior.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("TOTAL DE INGRESOS");

        txtTotalIngresos.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtTotalIngresos.setForeground(new java.awt.Color(0, 51, 204));
        txtTotalIngresos.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        txtTotalIngresos.setText("0,00");
        txtTotalIngresos.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("TOTAL DE EGRESOS");

        txtTotalEgresos.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtTotalEgresos.setForeground(new java.awt.Color(204, 0, 0));
        txtTotalEgresos.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        txtTotalEgresos.setText("0,00");
        txtTotalEgresos.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 0, 204));
        jLabel4.setText("SALDO DE HOY");

        txtSaldoHoy.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        txtSaldoHoy.setForeground(new java.awt.Color(102, 0, 102));
        txtSaldoHoy.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSaldoHoy.setText("S/. 0,00");
        txtSaldoHoy.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("FECHA");

        txtFecha.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("HORA");

        txtHora.setEnabled(false);

        jTextField6.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jTextField6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField6.setText("SALDO DE HOY + SALDO ANTERIOR");
        jTextField6.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField6.setEnabled(false);

        lblTotalCaja.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        lblTotalCaja.setForeground(new java.awt.Color(0, 0, 204));
        lblTotalCaja.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTotalCaja.setText("S/. 0,00");
        lblTotalCaja.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnActualizar.setBackground(new java.awt.Color(255, 255, 255));
        btnActualizar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(51, 0, 204));
        btnActualizar.setText("ACTUALIZAR");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnCerrarCaja.setBackground(new java.awt.Color(153, 153, 153));
        btnCerrarCaja.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnCerrarCaja.setText("CERRAR CAJA");
        btnCerrarCaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarCajaActionPerformed(evt);
            }
        });

        chkCerrarAntes.setText("CERRA ANTES DE LA HORA");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblSaldoAnterior, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2)
                                .addComponent(txtTotalIngresos, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addComponent(txtTotalEgresos))
                            .addComponent(jLabel4)
                            .addComponent(txtSaldoHoy, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(63, 63, 63)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCerrarCaja, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblTotalCaja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField6))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(chkCerrarAntes)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSaldoAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTotalIngresos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 2, Short.MAX_VALUE))
                    .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCerrarCaja, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtTotalEgresos, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSaldoHoy, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(lblTotalCaja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(chkCerrarAntes)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        sacarTotalIngresos();
        sacarTotalEgresos();

        mostrarSaldoHoy();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnCerrarCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarCajaActionPerformed
        // TODO add your handling code here:
        try {
            int aviso = JOptionPane.showConfirmDialog(rootPane, "Estas seguro(a) de cerrar la caja...");
            if (aviso == 0) {
                if (chkCerrarAntes.isSelected()) {
                    cerrar_caja();
                    cerrar_detalle_caja();
                    control_asistencia_salida();
                    System.exit(0);
                } else {
                    TurnoBD oTurnoBD = new TurnoBD();
                    List<Turno> lista_turno = oTurnoBD.verificarHorario(txtHora.getText(), Login_IU.dni_publico);

                    if (lista_turno.size() == 0) {
                        cerrar_caja();
                        cerrar_detalle_caja();
                        control_asistencia_salida();
                        System.exit(0);
                    } else {
                        advertencia("Todavia no puedes cerrar la caja, no se cumple tu horario de salida");
                    }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnCerrarCajaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnCerrarCaja;
    private javax.swing.JCheckBox chkCerrarAntes;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JLabel lblSaldoAnterior;
    private javax.swing.JLabel lblTotalCaja;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtHora;
    private javax.swing.JTextField txtSaldoHoy;
    private javax.swing.JTextField txtTotalEgresos;
    private javax.swing.JTextField txtTotalIngresos;
    // End of variables declaration//GEN-END:variables
}

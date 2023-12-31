/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaPresentacion;

import CapaDatos.Correlativo;
import CapaDatos.DetalleCaja;
import CapaNegocios.AjustarColumnasJTable;
import CapaNegocios.ColorearColumnasJTable;
import CapaNegocios.CorrelativoBD;
import CapaNegocios.DetalleCajaBD;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Saucedo
 */
public class Ingresos_IU extends javax.swing.JInternalFrame {

    String documento = "";
    String serie = "";
    String numeracion_actual = "";
    String nueva_numeracion = "";
    String tienda;
    String uDni;

    /**
     * Creates new form Ingresos_IU
     */
    public Ingresos_IU() {
        initComponents();
        sacarHora();
        sacarFecha();
        sacarNro();
        reportar();
        calcularTotal();

        ColorearColumnasJTable col5 = new ColorearColumnasJTable(5, Color.YELLOW);

        ColorearColumnasJTable col7 = new ColorearColumnasJTable(7, Color.PINK);

        tabla_reportes_ingreso.getColumnModel().getColumn(5).setCellRenderer(col5);
        tabla_reportes_ingreso.getColumnModel().getColumn(7).setCellRenderer(col7);
    }

    private void limpiar() {
        txtDetalleIngreso.setText("");
        txtMonto.setText("");

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

    private void limpiar_tabla_formulario() {
        DefaultTableModel tabla_temporal_ingreso = (DefaultTableModel) tabla_reportes_ingreso.getModel();
        tabla_temporal_ingreso.setRowCount(0);
    }

    private void sacarHora() {

        Calendar calendario = Calendar.getInstance();

        int hora = calendario.get(Calendar.HOUR_OF_DAY);
        int minutos = calendario.get(Calendar.MINUTE);
        int segundos = calendario.get(Calendar.SECOND);

        String tiempo = hora + ":" + minutos + ":" + segundos;

        txtHora.setText(tiempo);
    }

    private void sacarFecha() {
        Calendar calendario = Calendar.getInstance();

        int dia = calendario.get(Calendar.DAY_OF_MONTH);
        int mes = calendario.get(Calendar.MONTH) + 1;
        int anio = calendario.get(Calendar.YEAR);

        String fecha = anio + "-" + mes + "-" + dia;

        txtFechaIngreso.setText(fecha);
    }

    private void sacarNro() {
        CorrelativoBD oCorrelativoBD = new CorrelativoBD();

        documento = "INGRESO";
        tienda = Login_IU.tienda;

        List<Correlativo> lista_correlativo = oCorrelativoBD.sacarNumeracion(documento, tienda);
        serie = lista_correlativo.get(0).getCoSerie();
        numeracion_actual = lista_correlativo.get(0).getCoNumeracion();
        int antiguoNro = Integer.valueOf(numeracion_actual) + 1;
        nueva_numeracion = correlativo(antiguoNro);
        txtCorrelativo.setText(serie + "-" + nueva_numeracion);

    }

    private String correlativo(int antiguoNro) {

        String nuevoNro;
        String codTemporal = String.valueOf(antiguoNro);
        if (codTemporal.length() == 1) {
            nuevoNro = "00000" + antiguoNro;

        } else if (codTemporal.length() == 2) {
            nuevoNro = "0000" + antiguoNro;
        } else if (codTemporal.length() == 3) {
            nuevoNro = "000" + antiguoNro;

        } else if (codTemporal.length() == 4) {
            nuevoNro = "00" + antiguoNro;
        } else if (codTemporal.length() == 5) {
            nuevoNro = "0" + antiguoNro;
        } else {
            nuevoNro = "" + antiguoNro;
        }
        return nuevoNro;

    }

    private void calcularTotal() {
        DefaultTableModel tabla_temporal_compras = (DefaultTableModel) tabla_reportes_ingreso.getModel();
        int cantTabla = tabla_temporal_compras.getRowCount();
        double total = 0;

        for (int i = 0; i < cantTabla; i++) {
            total = total + (Double) tabla_temporal_compras.getValueAt(i, 6);

            txtTotal.setText("" + total);

        }
    }

    private void reportar() {

        limpiar_tabla_formulario();

        DetalleCajaBD oDetalleCajaBD = new DetalleCajaBD();

        DefaultTableModel tabla_temporal = (DefaultTableModel) this.tabla_reportes_ingreso.getModel();
        String correlativo = txtBuscarCorrelativo.getText().trim();
        String fecha = txtFechaIngreso.getText();
        tienda = Login_IU.tienda;
        String opcion = "INGRESO";
        uDni = Login_IU.dni_publico;

        List<DetalleCaja> lista_detalle = oDetalleCajaBD.buscarDetalleCajaUsuario(uDni, fecha, tienda, opcion);
        int cant = lista_detalle.size();
        for (int i = 0; i < cant; i++) {
            int idcategoria = lista_detalle.get(i).getIddetallecaja();
            String hora = lista_detalle.get(i).getDcHora();
            correlativo = lista_detalle.get(i).getDcCorrelativo();
            String motivo = lista_detalle.get(i).getDcMotivo();
            double monto = lista_detalle.get(i).getDcMonto();
            String estado = lista_detalle.get(i).getDcEstado();

            Object[] data = {idcategoria, fecha, hora, correlativo, opcion, motivo, monto, estado};
            tabla_temporal.addRow(data);

        }

        tabla_reportes_ingreso.setModel(tabla_temporal);
        AjustarColumnasJTable.ajustarAnchoColumnas(tabla_reportes_ingreso);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

    }

    private void actualizar_correlativo(String documento) {
        Correlativo oCorrelativo = new Correlativo();
        CorrelativoBD oCorrelativoBD = new CorrelativoBD();

        tienda = Login_IU.tienda;
        oCorrelativo.setCoNumeracion(nueva_numeracion);
        oCorrelativo.setCoDocumento(documento);
        oCorrelativo.setTienda(tienda);
        oCorrelativoBD.actualizarCorrelativo(oCorrelativo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtFechaIngreso = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cmbNroCaja = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtDetalleIngreso = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtMonto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCorrelativo = new javax.swing.JTextField();
        txtHora = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtBuscarCorrelativo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_reportes_ingreso = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnRegistrar = new javax.swing.JButton();
        btnAnular = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        txtTotal = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 255, 255));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("INGRESOS");

        jLabel1.setText("FECHA DEL INGRESO");

        txtFechaIngreso.setEnabled(false);

        jLabel2.setText("NRO DE CAJA");

        cmbNroCaja.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CAJA NRO 1" }));
        cmbNroCaja.setEnabled(false);

        jLabel5.setText("DETALLE DEL INGRESO");

        txtDetalleIngreso.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDetalleIngresoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDetalleIngresoFocusLost(evt);
            }
        });
        txtDetalleIngreso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDetalleIngresoKeyPressed(evt);
            }
        });

        jLabel6.setText("MONTO S/.");

        txtMonto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtMontoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMontoFocusLost(evt);
            }
        });
        txtMonto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMontoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMontoKeyTyped(evt);
            }
        });

        jLabel3.setText("CORRELATIVO");

        txtCorrelativo.setEnabled(false);

        txtHora.setEnabled(false);

        jLabel4.setText("HORA");

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar Documento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(102, 0, 204))); // NOI18N

        jLabel7.setText("CORRELATIVO");

        txtBuscarCorrelativo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarCorrelativoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarCorrelativoKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtBuscarCorrelativo, javax.swing.GroupLayout.PREFERRED_SIZE, 1090, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtBuscarCorrelativo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        tabla_reportes_ingreso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "FECHA", "HORA", "CORRELATIVO", "OPCION", "MOTIVO", "MONTO", "ESTADO"
            }
        ));
        jScrollPane1.setViewportView(tabla_reportes_ingreso);

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Imagenes/disk.png"))); // NOI18N
        btnRegistrar.setText("REGISTRAR");
        btnRegistrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRegistrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnAnular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Imagenes/page_delete.png"))); // NOI18N
        btnAnular.setText("ANULAR");
        btnAnular.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAnular.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAnular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnularActionPerformed(evt);
            }
        });

        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Imagenes/cross.png"))); // NOI18N
        btnCerrar.setText("CERRAR");
        btnCerrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCerrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnRegistrar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btnAnular, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCerrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRegistrar)
                .addGap(18, 18, 18)
                .addComponent(btnAnular)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 454, Short.MAX_VALUE)
                .addComponent(btnCerrar)
                .addContainerGap())
        );

        txtTotal.setEnabled(false);

        jLabel8.setText("TOTAL S/.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtFechaIngreso)
                            .addComponent(cmbNroCaja, 0, 290, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCorrelativo)
                            .addComponent(txtHora, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDetalleIngreso)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtFechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(txtCorrelativo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cmbNroCaja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtDetalleIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarCorrelativoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarCorrelativoKeyReleased
        // TODO add your handling code here:
        limpiar_tabla_formulario();

        DetalleCajaBD oDetalleCajaBD = new DetalleCajaBD();

        DefaultTableModel tabla_temporal = (DefaultTableModel) this.tabla_reportes_ingreso.getModel();

        String correlativo = txtBuscarCorrelativo.getText().trim();
        String fecha = txtFechaIngreso.getText();
        tienda = Login_IU.tienda;
        String opcion = "INGRESO";

        List<DetalleCaja> lista_detalle = oDetalleCajaBD.buscarDetalleCajaCorrelativo(correlativo, fecha, tienda, opcion);

        for (int i = 0; i < lista_detalle.size(); i++) {
            int idcategoria = lista_detalle.get(i).getIddetallecaja();
            String hora = lista_detalle.get(i).getDcHora();
            correlativo = lista_detalle.get(i).getDcCorrelativo();
            String motivo = lista_detalle.get(i).getDcMotivo();
            double monto = lista_detalle.get(i).getDcMonto();
            String estado = lista_detalle.get(i).getDcEstado();

            Object[] data = {idcategoria, fecha, hora, correlativo, opcion, motivo, monto, estado};
            tabla_temporal.addRow(data);

        }

        tabla_reportes_ingreso.setModel(tabla_temporal);
    }//GEN-LAST:event_txtBuscarCorrelativoKeyReleased

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // TODO add your handling code here:

        if (txtDetalleIngreso.getText().length() > 0) {
            if (txtMonto.getText().length() > 0) {

                DetalleCaja oDetalleCaja = new DetalleCaja();
                DetalleCajaBD oDetalleCajaBD = new DetalleCajaBD();

                uDni = Login_IU.dni_publico;
                tienda = Login_IU.tienda;

                oDetalleCaja.setDcFecha(txtFechaIngreso.getText());
                oDetalleCaja.setDcHora(txtHora.getText());
                oDetalleCaja.setDcCaja(cmbNroCaja.getSelectedItem().toString());
                oDetalleCaja.setOpcion("INGRESO");
                oDetalleCaja.setDcCorrelativo(txtCorrelativo.getText());
                oDetalleCaja.setDcMotivo(txtDetalleIngreso.getText().toUpperCase());
                oDetalleCaja.setDcMonto(Double.parseDouble(txtMonto.getText()));
                oDetalleCaja.setDcEstado("ABIERTO");
                oDetalleCaja.setuDni(uDni);
                oDetalleCaja.setTienda(tienda);

                boolean rpta = oDetalleCajaBD.registrarDetalleCaja(oDetalleCaja);
                if (rpta) {
                    exito("Se registro con exito");
                    actualizar_correlativo("INGRESO");
                    sacarNro();
                    reportar();
                    calcularTotal();
                    limpiar();

                } else {
                    error("Tienes problemas al registrar");
                }
            } else {
                advertencia("Debes de ingresar un monto");
                txtMonto.requestFocus();
            }
        } else {
            advertencia("Debe ingresar un motivo");
            txtDetalleIngreso.requestFocus();
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnAnularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnularActionPerformed
        // TODO add your handling code here:
        int fila_seleccionada = tabla_reportes_ingreso.getSelectedRow();
        if (fila_seleccionada >= 0) {
            int aviso = JOptionPane.showConfirmDialog(rootPane, "Estas seguro de eliminar");
            if (aviso == 0) {
                int iddetallecaja = Integer.parseInt(tabla_reportes_ingreso.getValueAt(fila_seleccionada, 0).toString());
                String estado = "ANULADO";
                DetalleCajaBD oDetalleCajaBD = new DetalleCajaBD();

                boolean rpta = oDetalleCajaBD.anularDocumento(iddetallecaja, estado);
                if (rpta) {
                    exito("Se anulo con exito");
                    reportar();
                } else {
                    error("Tienes problemas al anular");
                }

            }
        } else {
            advertencia("Tienes que seleccionar una fila para poder ANULAR...");
        }
    }//GEN-LAST:event_btnAnularActionPerformed

    private void txtDetalleIngresoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDetalleIngresoFocusGained
        // TODO add your handling code here:
        txtDetalleIngreso.setBackground(Color.yellow);
    }//GEN-LAST:event_txtDetalleIngresoFocusGained

    private void txtDetalleIngresoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDetalleIngresoFocusLost
        // TODO add your handling code here:
        txtDetalleIngreso.setBackground(Color.white);
    }//GEN-LAST:event_txtDetalleIngresoFocusLost

    private void txtMontoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMontoFocusGained
        // TODO add your handling code here:
        txtMonto.setBackground(Color.yellow);
    }//GEN-LAST:event_txtMontoFocusGained

    private void txtMontoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMontoFocusLost
        // TODO add your handling code here:
        txtMonto.setBackground(Color.white);
    }//GEN-LAST:event_txtMontoFocusLost

    private void txtMontoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMontoKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == '.')) {
            evt.consume();

        }
    }//GEN-LAST:event_txtMontoKeyTyped

    private void txtDetalleIngresoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDetalleIngresoKeyPressed
        // TODO add your handling code here:
        if (evt.getExtendedKeyCode() == KeyEvent.VK_ENTER) {
            txtMonto.requestFocus();
        }
    }//GEN-LAST:event_txtDetalleIngresoKeyPressed

    private void txtMontoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMontoKeyPressed
        // TODO add your handling code here:
        if (evt.getExtendedKeyCode() == KeyEvent.VK_ENTER) {
            btnRegistrar.requestFocus();
            btnRegistrar.doClick();
        }
    }//GEN-LAST:event_txtMontoKeyPressed

    private void txtBuscarCorrelativoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarCorrelativoKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == '-')) {
            evt.consume();

        }
    }//GEN-LAST:event_txtBuscarCorrelativoKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnular;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cmbNroCaja;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla_reportes_ingreso;
    private javax.swing.JTextField txtBuscarCorrelativo;
    private javax.swing.JTextField txtCorrelativo;
    private javax.swing.JTextField txtDetalleIngreso;
    private javax.swing.JTextField txtFechaIngreso;
    private javax.swing.JTextField txtHora;
    private javax.swing.JTextField txtMonto;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}

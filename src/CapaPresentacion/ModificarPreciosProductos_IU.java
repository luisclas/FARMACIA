/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaPresentacion;

import CapaDatos.EntradaProducto;
import CapaNegocios.EntradaProductoBD;
import java.awt.Color;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Saucedo
 */
public class ModificarPreciosProductos_IU extends javax.swing.JInternalFrame {

    DefaultTableModel tabla_temporal;
    int fila_seleccionada;

    /**
     * Creates new form ModificarPreciosProductos_IU
     */
    public ModificarPreciosProductos_IU() {
        initComponents();
    }

    private void limpiar() {
        txtId.setText("");
        txtSerie.setText("");
        txtProducto.setText("");
        txtLote.setText("");
        txtFechaVcto.setText("");
        txtPresentacion.setText("");
        txtEquivalencia.setText("");
        txtStockPresentacion.setText("");
        txtStockEquivalencia.setText("");
        txtPrecioCompraPresentacion.setText("");
        txtPrecioCompraEquivalencia.setText("");
        txtMargenPresentacion.setText("");
        txtMargenEquivalencia.setText("");
        txtPrecioVentaPresentacion.setText("");
        txtPrecioVentaEquivalencia.setText("");

    }

    private void limpiar_tabla_formulario_producto() {
        DefaultTableModel tabla_reporte_productos_temporal = (DefaultTableModel) tabla_reportes_productos.getModel();
        tabla_reporte_productos_temporal.setRowCount(0);
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField4 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtBuscarProductos = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_reportes_productos = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtSerie = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtProducto = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtLote = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtFechaVcto = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        txtPresentacion = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtEquivalencia = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtStockPresentacion = new javax.swing.JTextField();
        txtStockEquivalencia = new javax.swing.JTextField();
        txtPrecioCompraPresentacion = new javax.swing.JTextField();
        txtPrecioCompraEquivalencia = new javax.swing.JTextField();
        txtMargenPresentacion = new javax.swing.JTextField();
        txtMargenEquivalencia = new javax.swing.JTextField();
        txtPrecioVentaPresentacion = new javax.swing.JTextField();
        txtPrecioVentaEquivalencia = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();

        jTextField4.setText("jTextField4");

        setBackground(new java.awt.Color(204, 255, 255));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("MODIFICAR PRECIOS DE PRODUCTOS");

        jLabel1.setText("PRODUCTO");

        txtBuscarProductos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtBuscarProductosFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBuscarProductosFocusLost(evt);
            }
        });
        txtBuscarProductos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarProductosKeyPressed(evt);
            }
        });

        tabla_reportes_productos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "SERIE", "PRODUCTO", "LOTE", "FECHA VCTO", "TIENDA"
            }
        ));
        tabla_reportes_productos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabla_reportes_productosMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_reportes_productos);
        if (tabla_reportes_productos.getColumnModel().getColumnCount() > 0) {
            tabla_reportes_productos.getColumnModel().getColumn(2).setPreferredWidth(350);
        }

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Producto a Modificar los Precios", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        jLabel2.setText("ID");

        txtId.setEnabled(false);

        jLabel3.setText("SERIE");

        txtSerie.setEnabled(false);

        jLabel4.setText("PRODUCTO");

        txtProducto.setEnabled(false);

        jLabel5.setText("LOTE");

        txtLote.setEnabled(false);

        jLabel6.setText("FECHA VCTO");

        txtFechaVcto.setEnabled(false);

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        jLabel7.setText("PRESENTACION");

        txtPresentacion.setEnabled(false);

        jLabel8.setText("EQUIVALENCIA");

        txtEquivalencia.setEnabled(false);

        jLabel9.setText("MEDIDA");

        txtStockPresentacion.setEnabled(false);

        txtStockEquivalencia.setEnabled(false);

        txtPrecioCompraPresentacion.setEnabled(false);

        txtPrecioCompraEquivalencia.setEnabled(false);

        txtMargenPresentacion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtMargenPresentacionFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMargenPresentacionFocusLost(evt);
            }
        });
        txtMargenPresentacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMargenPresentacionKeyReleased(evt);
            }
        });

        txtMargenEquivalencia.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtMargenEquivalenciaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMargenEquivalenciaFocusLost(evt);
            }
        });
        txtMargenEquivalencia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMargenEquivalenciaKeyReleased(evt);
            }
        });

        txtPrecioVentaPresentacion.setEnabled(false);

        txtPrecioVentaEquivalencia.setEnabled(false);

        jLabel10.setText("STOCK");

        jLabel11.setText("PRECIO COMPRA");

        jLabel12.setText("MARGEN");

        jLabel13.setText("PRECIO VENTA");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtLote, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtFechaVcto, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(txtEquivalencia))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(txtPresentacion, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtStockPresentacion)
                                .addComponent(txtStockEquivalencia, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE))
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtPrecioCompraPresentacion)
                                .addComponent(txtPrecioCompraEquivalencia, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE))
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtMargenPresentacion)
                                .addComponent(txtMargenEquivalencia, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtPrecioVentaPresentacion)
                                .addComponent(txtPrecioVentaEquivalencia, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtLote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtFechaVcto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtPresentacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtStockPresentacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecioCompraPresentacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMargenPresentacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecioVentaPresentacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtEquivalencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtStockEquivalencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecioCompraEquivalencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMargenEquivalencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecioVentaEquivalencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Imagenes/lapiz.png"))); // NOI18N
        btnModificar.setText("MODIFICAR");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Imagenes/cerrar.png"))); // NOI18N
        btnCerrar.setText("CERRAR");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBuscarProductos))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCerrar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtBuscarProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModificar)
                    .addComponent(btnCerrar))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarProductosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarProductosKeyPressed
        // TODO add your handling code here:
        limpiar_tabla_formulario_producto();

        String producto = txtBuscarProductos.getText();

        if (txtBuscarProductos.getText().length() > 2) {

            DefaultTableModel tabla_reporte_producto_temporal = (DefaultTableModel) tabla_reportes_productos.getModel();
            EntradaProductoBD oEntradaProductoBD = new EntradaProductoBD();

            tabla_temporal = oEntradaProductoBD.buscarProductoxdescripcion(producto);

            int cant = tabla_temporal.getRowCount();
            for (int i = 0; i < cant; i++) {
                String id = tabla_temporal.getValueAt(i, 0).toString();
                String serie = tabla_temporal.getValueAt(i, 3).toString();
                String descripcion = tabla_temporal.getValueAt(i, 4).toString();
                String lote = tabla_temporal.getValueAt(i, 2).toString();
                String fecha_vcto = tabla_temporal.getValueAt(i, 11).toString();
                String tienda = tabla_temporal.getValueAt(i, 23).toString();

                Object[] data = {id, serie, descripcion, lote, fecha_vcto, tienda};
                tabla_reporte_producto_temporal.addRow(data);

            }
        }


    }//GEN-LAST:event_txtBuscarProductosKeyPressed

    private void tabla_reportes_productosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_reportes_productosMousePressed
        // TODO add your handling code here:

        fila_seleccionada = tabla_reportes_productos.getSelectedRow();

        txtId.setText("" + tabla_reportes_productos.getValueAt(fila_seleccionada, 0));
        txtLote.setText("" + tabla_temporal.getValueAt(fila_seleccionada, 2));
        txtSerie.setText("" + tabla_temporal.getValueAt(fila_seleccionada, 3));
        txtProducto.setText("" + tabla_temporal.getValueAt(fila_seleccionada, 4));
        txtFechaVcto.setText("" + tabla_temporal.getValueAt(fila_seleccionada, 11));
        txtPresentacion.setText("" + tabla_temporal.getValueAt(fila_seleccionada, 9));
        txtEquivalencia.setText("" + tabla_temporal.getValueAt(fila_seleccionada, 10));
        txtStockPresentacion.setText("" + tabla_temporal.getValueAt(fila_seleccionada, 12));
        txtStockEquivalencia.setText("" + tabla_temporal.getValueAt(fila_seleccionada, 13));
        txtPrecioCompraPresentacion.setText("" + tabla_temporal.getValueAt(fila_seleccionada, 14));
        txtPrecioCompraEquivalencia.setText("" + tabla_temporal.getValueAt(fila_seleccionada, 15));

        txtPrecioVentaPresentacion.setText("" + tabla_temporal.getValueAt(fila_seleccionada, 18));
        txtPrecioVentaEquivalencia.setText("" + tabla_temporal.getValueAt(fila_seleccionada, 20));

        String presentacion = txtPresentacion.getText();
        String equivalencia = txtEquivalencia.getText();

        if (presentacion.equals(equivalencia)) {

            txtMargenPresentacion.setEnabled(false);
            txtMargenPresentacion.setText("0");
            txtMargenEquivalencia.setText("" + tabla_temporal.getValueAt(fila_seleccionada, 17));

        } else {

            txtMargenPresentacion.setEnabled(true);
            txtMargenPresentacion.setText("" + tabla_temporal.getValueAt(fila_seleccionada, 16));
            txtMargenEquivalencia.setText("" + tabla_temporal.getValueAt(fila_seleccionada, 17));
        }
    }//GEN-LAST:event_tabla_reportes_productosMousePressed

    private void txtMargenPresentacionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMargenPresentacionKeyReleased
        // TODO add your handling code here:
        try {
            DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.ENGLISH);
            DecimalFormat df = new DecimalFormat("#.#", symbols);

            double precio_compra_presentacion = Double.parseDouble(txtPrecioCompraPresentacion.getText().trim());

            double margen = Double.parseDouble(txtMargenPresentacion.getText().trim());

            double ganancia_presentacion = precio_compra_presentacion * (margen / 100);

            double precio_venta_presentacion = precio_compra_presentacion + ganancia_presentacion;

            double redondeado_presentacion = Math.round(precio_venta_presentacion);

            txtPrecioVentaPresentacion.setText("" + df.format(redondeado_presentacion));

        } catch (Exception e) {
        }
    }//GEN-LAST:event_txtMargenPresentacionKeyReleased

    private void txtMargenEquivalenciaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMargenEquivalenciaKeyReleased
        // TODO add your handling code here:
        try {
            DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.ENGLISH);
            DecimalFormat df = new DecimalFormat("#.#", symbols);

            double precio_compra_equivalencia = Double.parseDouble(txtPrecioCompraEquivalencia.getText().trim());

            double margen = Double.parseDouble(txtMargenEquivalencia.getText().trim());

            double ganancia_equivalencia = precio_compra_equivalencia * (margen / 100);

            double precio_venta_equivalencia = precio_compra_equivalencia + ganancia_equivalencia;

            String redondeado_equivalencia = df.format(precio_venta_equivalencia);

            txtPrecioVentaEquivalencia.setText(redondeado_equivalencia);

        } catch (Exception e) {
        }
    }//GEN-LAST:event_txtMargenEquivalenciaKeyReleased

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        try {
            int aviso = JOptionPane.showConfirmDialog(rootPane, "Estas a punto de modifcar los precios de ventas de " + txtProducto.getText());

            if (aviso == 0) {

                int margenPresentacion = Integer.parseInt(txtMargenPresentacion.getText());
                int margenEquivalencia = Integer.parseInt(txtMargenEquivalencia.getText());
                double precioVentaPresentacion = Double.parseDouble(txtPrecioVentaPresentacion.getText());
                double precioVentaEquivalencia = Double.parseDouble(txtPrecioVentaEquivalencia.getText());
                int identrada_producto = Integer.parseInt(txtId.getText());

                if (txtMargenPresentacion.getText().length() > 0) {
                    if (txtMargenEquivalencia.getText().length() > 0) {

                        EntradaProducto oEntradaProducto = new EntradaProducto();
                        EntradaProductoBD oEntradaProductoBD = new EntradaProductoBD();

                        oEntradaProducto.setMargenGananciaPresentacion(margenPresentacion);
                        oEntradaProducto.setMargenGananciaEquivalencia(margenEquivalencia);
                        oEntradaProducto.setPrecioVentaPresentacionMayor(precioVentaPresentacion);
                        oEntradaProducto.setPrecioVentaEquivalenciaMayor(precioVentaEquivalencia);
                        oEntradaProducto.setIdep(identrada_producto);

                        boolean rpta = oEntradaProductoBD.modificarPrecioProducto(oEntradaProducto);
                        if (rpta) {
                            exito("Se modifico los precios de ventas correctamente....");
                            limpiar();
                        } else {
                            error("Tienes problemas al modificar los precios....");
                        }
                    } else {
                        advertencia("No debe de estar vacio..");
                        txtMargenEquivalencia.requestFocus();
                    }
                } else {
                    advertencia("No debe de estar vacio..");
                    txtMargenPresentacion.requestFocus();
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void txtBuscarProductosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscarProductosFocusGained
        // TODO add your handling code here:
        txtBuscarProductos.setBackground(Color.yellow);
    }//GEN-LAST:event_txtBuscarProductosFocusGained

    private void txtBuscarProductosFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscarProductosFocusLost
        // TODO add your handling code here:
        txtBuscarProductos.setBackground(Color.white);
    }//GEN-LAST:event_txtBuscarProductosFocusLost

    private void txtMargenPresentacionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMargenPresentacionFocusGained
        // TODO add your handling code here:
        txtMargenPresentacion.setBackground(Color.yellow);
    }//GEN-LAST:event_txtMargenPresentacionFocusGained

    private void txtMargenPresentacionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMargenPresentacionFocusLost
        // TODO add your handling code here:
        txtMargenPresentacion.setBackground(Color.white);
    }//GEN-LAST:event_txtMargenPresentacionFocusLost

    private void txtMargenEquivalenciaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMargenEquivalenciaFocusGained
        // TODO add your handling code here:
        txtMargenEquivalencia.setBackground(Color.yellow);
    }//GEN-LAST:event_txtMargenEquivalenciaFocusGained

    private void txtMargenEquivalenciaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMargenEquivalenciaFocusLost
        // TODO add your handling code here:
        txtMargenEquivalencia.setBackground(Color.white);
    }//GEN-LAST:event_txtMargenEquivalenciaFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTable tabla_reportes_productos;
    private javax.swing.JTextField txtBuscarProductos;
    private javax.swing.JTextField txtEquivalencia;
    private javax.swing.JTextField txtFechaVcto;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtLote;
    private javax.swing.JTextField txtMargenEquivalencia;
    private javax.swing.JTextField txtMargenPresentacion;
    private javax.swing.JTextField txtPrecioCompraEquivalencia;
    private javax.swing.JTextField txtPrecioCompraPresentacion;
    private javax.swing.JTextField txtPrecioVentaEquivalencia;
    private javax.swing.JTextField txtPrecioVentaPresentacion;
    private javax.swing.JTextField txtPresentacion;
    private javax.swing.JTextField txtProducto;
    private javax.swing.JTextField txtSerie;
    private javax.swing.JTextField txtStockEquivalencia;
    private javax.swing.JTextField txtStockPresentacion;
    // End of variables declaration//GEN-END:variables
}

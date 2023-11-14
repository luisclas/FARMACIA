/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaPresentacion;

import CapaDatos.Producto;
import CapaNegocios.AjustarColumnasJTable;
import CapaNegocios.EntradaProductoBD;
import static CapaPresentacion.Venta_IU.tabla_ventas;
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
public class Pedidos_IU extends javax.swing.JInternalFrame {

    public static DefaultTableModel tabla_temporal;
    DefaultTableModel tabla_temporal_venta = (DefaultTableModel) Venta_IU.tabla_ventas.getModel();
    public static int fila_seleccionada;
    String medida_seleccionada;
    double precio_seleccionada;

    /**
     * Creates new form Pedidos_IU
     */
    public Pedidos_IU() {
        initComponents();
        bgPresentacion.clearSelection();
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

    private void limpiar_tabla_formulario_pedido() {
        DefaultTableModel tabla_temporal_Pedidos = (DefaultTableModel) tabla_pedidos.getModel();
        tabla_temporal_Pedidos.setRowCount(0);
    }

    private void limpiar_tabla_formulario_pedido_alternativo() {
        DefaultTableModel tabla_temporal_Pedidos_alternativos = (DefaultTableModel) tabla_pedidos_alternativos.getModel();
        tabla_temporal_Pedidos_alternativos.setRowCount(0);
    }

    private void limpiar_precios() {
        txtPrecioVentaPresentacion.setText("");
        txtPrecioVentaEquivalencia.setText("");
        bgPresentacion.clearSelection();
        txtStockEquivalencia.setText("");
        txtStockPresentacion.setText("");
        rbPresentacion.setSelected(false);
        rbEquivalencia.setSelected(false);
        rbPresentacion.setText("");
        rbEquivalencia.setText("");
        medida_seleccionada = "";
        precio_seleccionada = 0.0;

    }

    public void enviar(String medida) {
        fila_seleccionada = tabla_pedidos.getSelectedRow();
        int idep = Integer.parseInt(tabla_pedidos.getValueAt(fila_seleccionada, 5).toString());
        String serie = tabla_pedidos.getValueAt(fila_seleccionada, 0).toString();
        String producto = tabla_pedidos.getValueAt(fila_seleccionada, 1).toString();
        String lote = tabla_temporal.getValueAt(fila_seleccionada, 2).toString();
        int cant = Integer.parseInt(txtCantidad.getText().trim());
        double precio = precio_seleccionada;
        double importe = cant * precio;
        Object[] data = {serie, producto, medida, cant, precio, importe, lote, idep};
        tabla_temporal_venta.addRow(data);
        Venta_IU.tabla_ventas.setModel(tabla_temporal_venta);
        calcularTotal();
        txtCantidad.setText("");
        txtProducto.setText("");
        txtProducto.requestFocus();
        limpiar_tabla_formulario_pedido();

    }

    private void calcularTotal() {
        int maxPedidos = tabla_temporal_venta.getRowCount();
        double total = 0;
        for (int i = 0; i < maxPedidos; i++) {
            total = total + (Double) tabla_temporal_venta.getValueAt(i, 5);

        }
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.ENGLISH);
        DecimalFormat df = new DecimalFormat("#.#", symbols);

        String df_total = df.format(total);
        Venta_IU.txtSubTotal.setText("" + df_total);
        Venta_IU.txtTotalPagar.setText("" + df_total);
    }

    private void producto_alternativo() {

        limpiar_tabla_formulario_pedido_alternativo();
        DefaultTableModel tabla_temporal_pedidos_alternativos = (DefaultTableModel) tabla_pedidos_alternativos.getModel();

        EntradaProductoBD oProductoBD = new EntradaProductoBD();
        String serie = tabla_pedidos.getValueAt(fila_seleccionada, 0).toString();
        DefaultTableModel tabla_temporal_alternativos;
        tabla_temporal_alternativos = oProductoBD.buscarProductoAlternativos(serie);
        int cant = tabla_temporal_alternativos.getRowCount();
        for (int i = 0; i < cant; i++) {
            serie = tabla_temporal_alternativos.getValueAt(i, 0).toString();
            String descripcion = tabla_temporal_alternativos.getValueAt(i, 1).toString();
            String presentacion = tabla_temporal_alternativos.getValueAt(i, 2).toString();
            String fecha_vcto = tabla_temporal_alternativos.getValueAt(i, 3).toString();

            Object[] data_alternativos = {serie, descripcion, presentacion, fecha_vcto};
            tabla_temporal_pedidos_alternativos.addRow(data_alternativos);

        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgPresentacion = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        txtProducto = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_pedidos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtCondicion = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla_pedidos_alternativos = new javax.swing.JTable();
        btnComposicion = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblPresentacion = new javax.swing.JLabel();
        lblEquivalencia = new javax.swing.JLabel();
        txtStockPresentacion = new javax.swing.JTextField();
        txtStockEquivalencia = new javax.swing.JTextField();
        txtPrecioVentaEquivalencia = new javax.swing.JTextField();
        txtPrecioVentaPresentacion = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        panelPedido = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        btnEnviar = new javax.swing.JButton();
        rbPresentacion = new javax.swing.JRadioButton();
        rbEquivalencia = new javax.swing.JRadioButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("BUSCAR PRODUCTOS");

        jLabel1.setText("PRODUCTO");

        txtProducto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtProductoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtProductoFocusLost(evt);
            }
        });
        txtProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtProductoKeyReleased(evt);
            }
        });

        tabla_pedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "PRODUCTO", "PRESENTACION", "FECHA_VCTO", "LABORATORIO", "ID"
            }
        ));
        tabla_pedidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabla_pedidosMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_pedidos);
        if (tabla_pedidos.getColumnModel().getColumnCount() > 0) {
            tabla_pedidos.getColumnModel().getColumn(1).setPreferredWidth(350);
        }

        jLabel2.setText("CONDICION");

        txtCondicion.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("PRODUCTOS DE LA MISMA COMPOSICION...");

        tabla_pedidos_alternativos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "PRODUCTO", "PRESENTACION", "FECHA_VCTO"
            }
        ));
        jScrollPane2.setViewportView(tabla_pedidos_alternativos);
        if (tabla_pedidos_alternativos.getColumnModel().getColumnCount() > 0) {
            tabla_pedidos_alternativos.getColumnModel().getColumn(1).setPreferredWidth(350);
        }

        btnComposicion.setBackground(new java.awt.Color(255, 255, 255));
        btnComposicion.setText("VER COMPOSICION");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("MEDIDA");

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        lblPresentacion.setText("CAJA");

        lblEquivalencia.setText("UNIDADES");

        txtStockPresentacion.setEnabled(false);

        txtStockEquivalencia.setEnabled(false);

        txtPrecioVentaEquivalencia.setEnabled(false);

        txtPrecioVentaPresentacion.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 0, 204));
        jLabel7.setText("PRECIO VENTA");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblEquivalencia)
                                    .addComponent(lblPresentacion))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtStockPresentacion)
                                    .addComponent(txtStockEquivalencia, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPrecioVentaEquivalencia)
                                    .addComponent(txtPrecioVentaPresentacion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7)
                                .addGap(58, 58, 58)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPresentacion)
                    .addComponent(txtStockPresentacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecioVentaPresentacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEquivalencia)
                    .addComponent(txtStockEquivalencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecioVentaEquivalencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelPedido.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(153, 0, 153));
        jLabel8.setText("PRESENTACION");

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("CANT");

        btnEnviar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Imagenes/add.png"))); // NOI18N
        btnEnviar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEnviar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        bgPresentacion.add(rbPresentacion);
        rbPresentacion.setText("....");
        rbPresentacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbPresentacionMouseClicked(evt);
            }
        });
        rbPresentacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbPresentacionActionPerformed(evt);
            }
        });

        bgPresentacion.add(rbEquivalencia);
        rbEquivalencia.setText("...");
        rbEquivalencia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbEquivalenciaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelPedidoLayout = new javax.swing.GroupLayout(panelPedido);
        panelPedido.setLayout(panelPedidoLayout);
        panelPedidoLayout.setHorizontalGroup(
            panelPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPedidoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addGroup(panelPedidoLayout.createSequentialGroup()
                        .addGroup(panelPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addGroup(panelPedidoLayout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnEnviar))
                            .addGroup(panelPedidoLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(rbPresentacion)
                                .addGap(122, 122, 122)
                                .addComponent(rbEquivalencia)))
                        .addGap(0, 146, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelPedidoLayout.setVerticalGroup(
            panelPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPedidoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbPresentacion)
                    .addComponent(rbEquivalencia))
                .addGap(18, 18, 18)
                .addGroup(panelPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEnviar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(213, 213, 213))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1080, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtProducto))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCondicion, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3)
                            .addComponent(jScrollPane2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnComposicion)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txtCondicion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnComposicion)))
                .addGap(57, 57, 57))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabla_pedidosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_pedidosMousePressed
        // TODO add your handling code here:

        limpiar_precios();
        fila_seleccionada = tabla_pedidos.getSelectedRow();
        producto_alternativo();
        txtStockPresentacion.setText(tabla_temporal.getValueAt(fila_seleccionada, 12).toString());
        txtStockEquivalencia.setText(tabla_temporal.getValueAt(fila_seleccionada, 13).toString());
        txtPrecioVentaPresentacion.setText(tabla_temporal.getValueAt(fila_seleccionada, 18).toString());
        txtPrecioVentaEquivalencia.setText(tabla_temporal.getValueAt(fila_seleccionada, 20).toString());
        lblPresentacion.setText(tabla_temporal.getValueAt(fila_seleccionada, 9).toString());
        lblEquivalencia.setText(tabla_temporal.getValueAt(fila_seleccionada, 10).toString());

        txtCondicion.setText(tabla_temporal.getValueAt(fila_seleccionada, 5).toString());

        String presentacion = tabla_temporal.getValueAt(fila_seleccionada, 9).toString();
        String equivalencia = tabla_temporal.getValueAt(fila_seleccionada, 10).toString();

        if (presentacion.equals(equivalencia)) {
            precio_seleccionada = Double.parseDouble(tabla_temporal.getValueAt(fila_seleccionada, 20).toString());
            lblPresentacion.setVisible(false);
            txtStockPresentacion.setVisible(false);
            txtPrecioVentaPresentacion.setVisible(false);

            rbPresentacion.setText(presentacion);
            rbEquivalencia.setText(equivalencia);
            rbEquivalencia.setSelected(true);
            rbPresentacion.setVisible(true);

        } else {
            precio_seleccionada = Double.parseDouble(tabla_temporal.getValueAt(fila_seleccionada, 18).toString());
            lblPresentacion.setVisible(true);
            txtStockPresentacion.setVisible(true);
            txtPrecioVentaPresentacion.setVisible(true);
            rbPresentacion.setText(presentacion);
            rbEquivalencia.setText(equivalencia);
            rbEquivalencia.setVisible(true);
            rbPresentacion.setVisible(true);
        }
        panelPedido.setVisible(true);

    }//GEN-LAST:event_tabla_pedidosMousePressed

    private void txtProductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProductoKeyReleased
        // TODO add your handling code here:
        try {
            limpiar_tabla_formulario_pedido();
            limpiar_tabla_formulario_pedido_alternativo();
            limpiar_precios();

            DefaultTableModel tabla_temporal_pedidos = (DefaultTableModel) tabla_pedidos.getModel();

            String producto = txtProducto.getText();
            EntradaProductoBD oProductoBD = new EntradaProductoBD();

            if (txtProducto.getText().length() > 2) {

                tabla_temporal = oProductoBD.buscarProductoxdescripcion(producto);
                int cant = tabla_temporal.getRowCount();
                for (int i = 0; i < cant; i++) {

                    String serie = tabla_temporal.getValueAt(i, 3).toString();
                    String descripcion = tabla_temporal.getValueAt(i, 4).toString();
                    String presentacion = tabla_temporal.getValueAt(i, 9).toString();
                    String fecha_vcto = tabla_temporal.getValueAt(i, 11).toString();
                    String marca = tabla_temporal.getValueAt(i, 7).toString();
                    String codigo = tabla_temporal.getValueAt(i, 0).toString();

                    medida_seleccionada = presentacion;

                    Object[] data = {serie, descripcion, presentacion, fecha_vcto, marca, codigo};
                    tabla_temporal_pedidos.addRow(data);

                    AjustarColumnasJTable.ajustarAnchoColumnas(tabla_pedidos);
                }

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_txtProductoKeyReleased

    private void rbPresentacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbPresentacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbPresentacionActionPerformed

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        // TODO add your handling code here:

        try {
            if (!txtCantidad.getText().equals("0")) {
                if (txtCantidad.getText().length() > 0) {
                    if (rbPresentacion.isSelected() || rbEquivalencia.isSelected()) {

                        int cantPedido = Integer.parseInt(txtCantidad.getText().trim());
                        double quedaPresentacion = 0.0;
                        double quedaEquivalencia = 0;

                        if (rbPresentacion.isSelected()) {
                            medida_seleccionada = rbPresentacion.getText();
                            double cantStockPresentacion = Double.parseDouble(tabla_temporal.getValueAt(fila_seleccionada, 12).toString());
                            quedaPresentacion = cantStockPresentacion - cantPedido;
                            double ref = Integer.parseInt(tabla_temporal.getValueAt(fila_seleccionada, 22).toString());

                            quedaEquivalencia = quedaPresentacion * ref;

                            if (quedaPresentacion >= 0 || quedaEquivalencia >= 0) {
                                enviar(medida_seleccionada);
                                limpiar_precios();

                            } else {
                                JOptionPane.showMessageDialog(null, "No hay la cantidad que solicita....");
                            }
                        } else {
                            medida_seleccionada = rbEquivalencia.getText();
                            int cantStockEquivalencia = Integer.parseInt(tabla_temporal.getValueAt(fila_seleccionada, 13).toString());
                            quedaEquivalencia = cantStockEquivalencia - cantPedido;
                        
                        if (quedaEquivalencia > -1) {

                            enviar(medida_seleccionada);
                            limpiar_precios();

                        } else {
                            JOptionPane.showMessageDialog(null, "No hay cantidad que solicita....");
                        }
                        }

                    } else {
                        advertencia("Debe seleccionar una presentacion");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Ingrese una cantidad correcta...");
                    txtCantidad.requestFocus();

                }
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese un numero mayor a cero...");
                txtCantidad.requestFocus();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnEnviarActionPerformed

    private void rbPresentacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbPresentacionMouseClicked
        // TODO add your handling code here:
        txtCantidad.setText("");
        txtCantidad.requestFocus();
        medida_seleccionada = tabla_temporal.getValueAt(fila_seleccionada, 9).toString();
        precio_seleccionada = Double.parseDouble(tabla_temporal.getValueAt(fila_seleccionada, 18).toString());
    }//GEN-LAST:event_rbPresentacionMouseClicked

    private void rbEquivalenciaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbEquivalenciaMouseClicked
        // TODO add your handling code here:
        txtCantidad.setText("");
        txtCantidad.requestFocus();
        medida_seleccionada = tabla_temporal.getValueAt(fila_seleccionada, 10).toString();
        precio_seleccionada = Double.parseDouble(tabla_temporal.getValueAt(fila_seleccionada, 20).toString());

    }//GEN-LAST:event_rbEquivalenciaMouseClicked

    private void txtProductoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtProductoFocusGained
        // TODO add your handling code here:
        txtProducto.setBackground(Color.yellow);
    }//GEN-LAST:event_txtProductoFocusGained

    private void txtProductoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtProductoFocusLost
        // TODO add your handling code here:
        txtProducto.setBackground(Color.white);
    }//GEN-LAST:event_txtProductoFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgPresentacion;
    private javax.swing.JButton btnComposicion;
    private javax.swing.JButton btnEnviar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblEquivalencia;
    private javax.swing.JLabel lblPresentacion;
    private javax.swing.JPanel panelPedido;
    private javax.swing.JRadioButton rbEquivalencia;
    private javax.swing.JRadioButton rbPresentacion;
    public static javax.swing.JTable tabla_pedidos;
    private javax.swing.JTable tabla_pedidos_alternativos;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCondicion;
    private javax.swing.JTextField txtPrecioVentaEquivalencia;
    private javax.swing.JTextField txtPrecioVentaPresentacion;
    private javax.swing.JTextField txtProducto;
    private javax.swing.JTextField txtStockEquivalencia;
    private javax.swing.JTextField txtStockPresentacion;
    // End of variables declaration//GEN-END:variables
}

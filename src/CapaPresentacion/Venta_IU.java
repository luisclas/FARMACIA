/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaPresentacion;

import CapaConexion.Conexion;
import CapaDatos.Cliente;
import CapaDatos.Correlativo;
import CapaDatos.DetalleCaja;
import CapaDatos.DetalleVenta;
import CapaDatos.EntradaProducto;
import CapaDatos.Kardex;
import CapaDatos.Venta;
import CapaNegocios.VentaBD;
import CapaNegocios.ClienteBD;
import CapaNegocios.CorrelativoBD;
import CapaNegocios.DetalleCajaBD;
import CapaNegocios.DetalleVentaBD;
import CapaNegocios.DeudaBD;
import CapaNegocios.EntradaProductoBD;
import CapaNegocios.KardexBD;
import static CapaPresentacion.MENU_IU.escritorio;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.io.InputStream;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author saucedo
 */
public class Venta_IU extends javax.swing.JInternalFrame {

    DefaultTableModel tabla_temporal_entradaproducto;
    String nueva_numeracon = "";
    String documento = "";
    DefaultTableModel tabla_temporal_venta;
    String serie = "";
    String tienda;

    /**
     * Creates new form Venta_IU
     */
    public Venta_IU() {
        initComponents();
        sacarFecha();
        sacarHora();
        sacarNro();
    }

    private void limpiar_tabla_formulario() {
        DefaultTableModel tabla_temporal_compras = (DefaultTableModel) tabla_ventas.getModel();
        tabla_temporal_compras.setRowCount(0);
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

    private void sacarFecha() {
        Calendar calendario = Calendar.getInstance();

        int dia = calendario.get(Calendar.DAY_OF_MONTH);
        int mes = calendario.get(Calendar.MONTH) + 1;
        int anio = calendario.get(Calendar.YEAR);
        String fecha = anio + "-" + mes + "-" + dia;
        txtFecha.setText(fecha);
    }

    private void sacarHora() {
        Calendar calendario = Calendar.getInstance();
        int hora = calendario.get(Calendar.HOUR_OF_DAY);
        int minutos = calendario.get(Calendar.MINUTE);
        int segundos = calendario.get(Calendar.SECOND);

        String tiempo = hora + ":" + minutos + ":" + segundos;
        txtHora.setText(tiempo);
    }

    private void sacarNro() {
        CorrelativoBD oCorrelativoBD = new CorrelativoBD();
        if (cmbTipoDocumento.getSelectedItem().equals("BOLETA")) {
            documento = cmbTipoDocumento.getSelectedItem().toString();
            List<Correlativo> listaCorrelativos = oCorrelativoBD.sacarNumeracion(documento, "PRINCIPAL");

            serie = listaCorrelativos.get(0).getCoSerie();
            String numeracion = listaCorrelativos.get(0).getCoNumeracion();
            int antiguoNro = Integer.valueOf(numeracion) + 1;
            nueva_numeracon = correlativo(antiguoNro);
            txtCorrelativo.setText(serie + "-" + nueva_numeracon);
        }
        if (cmbTipoDocumento.getSelectedItem().equals("FACTURA")) {
            documento = cmbTipoDocumento.getSelectedItem().toString();
            List<Correlativo> listaCorrelativos = oCorrelativoBD.sacarNumeracion(documento, "PRINCIPAL");

            serie = listaCorrelativos.get(0).getCoSerie();
            String numeracion = listaCorrelativos.get(0).getCoNumeracion();
            int antiguoNro = Integer.valueOf(numeracion) + 1;
            nueva_numeracon = correlativo(antiguoNro);
            txtCorrelativo.setText(serie + "-" + nueva_numeracon);
        }
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

    private void limpiarVenta() {
        txtCliente.setText("ANONIMO");
        txtDniRuc.setText("00000000");
        txtSubTotal.setText("0.0");
        txtPagoCon.setText("");
        txtVuelto.setText("");
        txtProducto.setText("");
        limpiar_tabla_formulario();
        sacarNro();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtDniRuc = new javax.swing.JTextField();
        txtCliente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnBuscarCliente = new javax.swing.JButton();
        btnRegistrarCliente = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cmbTipoPago = new javax.swing.JComboBox<>();
        cmbEstado = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cmbTipoDocumento = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtCorrelativo = new javax.swing.JTextField();
        txtFecha = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtHora = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cmbFormapago = new javax.swing.JComboBox<>();
        cmbMoneda = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtProducto = new javax.swing.JTextField();
        btnQuitar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_ventas = new javax.swing.JTable();
        btnCerrar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtVuelto = new javax.swing.JTextField();
        txtPagoCon = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtSubTotal = new javax.swing.JTextField();
        txtIgv = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtTotalPagar = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();

        setBackground(new java.awt.Color(204, 255, 255));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("VENTAS");

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("RUC / DNI");

        txtDniRuc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDniRucFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDniRucFocusLost(evt);
            }
        });
        txtDniRuc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDniRucKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDniRucKeyTyped(evt);
            }
        });

        txtCliente.setEnabled(false);

        jLabel2.setText("CLIENTE");

        btnBuscarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Imagenes/buscar_proveedor.png"))); // NOI18N
        btnBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienteActionPerformed(evt);
            }
        });

        btnRegistrarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Imagenes/status_online.png"))); // NOI18N
        btnRegistrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDniRuc, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(184, 184, 184)
                        .addComponent(btnRegistrarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtDniRuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistrarCliente)
                    .addComponent(btnBuscarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setText("TIPO DE PAGO");

        cmbTipoPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CONTADO", "CREDITO" }));

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ATENDIDO", "PENDIENTE" }));

        jLabel4.setText("ESTADO");

        jLabel5.setText("TIPO DE DOCUMENTO");

        cmbTipoDocumento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BOLETA", "FACTURA" }));

        jLabel6.setText("CORRELATIVO");

        txtCorrelativo.setEnabled(false);

        txtFecha.setEnabled(false);

        jLabel7.setText("FECHA");

        txtHora.setEnabled(false);

        jLabel8.setText("HORA");

        jLabel9.setText("FORMA PAGO");

        cmbFormapago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "EFECTIVO", "TARJETA", "TRANSFERENCIA", "CHEQUE" }));

        cmbMoneda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SOLES" }));

        jLabel10.setText("SOLES");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmbTipoPago, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmbTipoDocumento, 0, 122, Short.MAX_VALUE)
                    .addComponent(txtCorrelativo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel10)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmbFormapago, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbMoneda, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel9)
                                .addComponent(cmbFormapago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(cmbTipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel10)
                                .addComponent(cmbMoneda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8)
                                .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(txtCorrelativo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cmbTipoPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel11.setText("PRODUCTO");

        txtProducto.setEnabled(false);

        btnQuitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Imagenes/eliminar2.png"))); // NOI18N
        btnQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarActionPerformed(evt);
            }
        });

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Imagenes/keyboard.png"))); // NOI18N
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        tabla_ventas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "PRODUCTO", "PRESENTACION", "CANTIDAD", "PRECIO", "IMPORTE", "LOTE", "ID"
            }
        ));
        jScrollPane1.setViewportView(tabla_ventas);

        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Imagenes/cross.png"))); // NOI18N
        btnCerrar.setText("CERRAR");
        btnCerrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCerrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Imagenes/coins.png"))); // NOI18N
        btnRegistrar.setText("GUARDAR");
        btnRegistrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRegistrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Calibri", 1, 21)); // NOI18N
        jLabel14.setText("PAGO CON S/.");

        jLabel15.setFont(new java.awt.Font("Calibri", 1, 21)); // NOI18N
        jLabel15.setText("VUELTO S/.");

        txtVuelto.setEnabled(false);

        txtPagoCon.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPagoConFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPagoConFocusLost(evt);
            }
        });
        txtPagoCon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPagoConKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPagoConKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPagoConKeyTyped(evt);
            }
        });

        jLabel17.setText("SUBTOTAL S/.");

        txtSubTotal.setEnabled(false);
        txtSubTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSubTotalActionPerformed(evt);
            }
        });

        txtIgv.setText("0");
        txtIgv.setEnabled(false);
        txtIgv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIgvActionPerformed(evt);
            }
        });

        jLabel19.setText("TOTAL A PAGAR S/.");

        txtTotalPagar.setEnabled(false);
        txtTotalPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalPagarActionPerformed(evt);
            }
        });

        jCheckBox1.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setText("IGV");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtProducto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnQuitar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPagoCon, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtVuelto, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(jCheckBox1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIgv, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTotalPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnQuitar)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel14)
                                    .addGap(29, 29, 29)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtPagoCon, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtVuelto, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIgv, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTotalPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19))))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed
    private int buscarDeudaCliente() {
        DeudaBD oDeudaBD = new DeudaBD();
        DefaultTableModel tabla_temporal;
        tabla_temporal = oDeudaBD.buscarDeuda(txtDniRuc.getText(), "ABIERTO", Login_IU.tienda);
        int cant = tabla_temporal.getRowCount();
        return cant;
    }

    private int registrarVenta() {
        Venta oVenta = new Venta();
        //METODOS
        VentaBD oVentaBD = new VentaBD();
        documento = cmbTipoDocumento.getSelectedItem().toString();
        oVenta.setvFecha(txtFecha.getText());
        oVenta.setvHora(txtHora.getText());
        oVenta.setvDocumento(documento);
        oVenta.setvCorrelativo(txtCorrelativo.getText());
        oVenta.setvTipoPago(cmbTipoPago.getSelectedItem().toString());
        oVenta.setvFormaPago(cmbFormapago.getSelectedItem().toString());
        oVenta.setvEstado(cmbEstado.getSelectedItem().toString());
        oVenta.setvMoneda(cmbMoneda.getSelectedItem().toString());
        oVenta.setvSubTotal(Double.parseDouble(txtSubTotal.getText()));
        oVenta.setvIgv(Integer.parseInt(txtIgv.getText()));
        oVenta.setvTotalPagar(Double.parseDouble(txtTotalPagar.getText()));
        oVenta.setvPagoCon(Double.parseDouble(txtPagoCon.getText()));
        oVenta.setvVuelto(Double.parseDouble(txtVuelto.getText()));
        oVenta.setuDni(Login_IU.dni_publico);
        oVenta.setCliRuc_Dni(txtDniRuc.getText());
        oVenta.setTienda(Login_IU.tienda);

        int idVenta = oVentaBD.registrarVenta(oVenta);
        return idVenta;
    }

    private void registrarDetallePedidos(int idventa) {
        DefaultTableModel tabla_temporal_ventas = (DefaultTableModel) tabla_ventas.getModel();
        int cantPedidos = tabla_temporal_ventas.getRowCount();
        DetalleVenta oDetalle = new DetalleVenta();
        DetalleVentaBD oDetalleBD = new DetalleVentaBD();
        EntradaProducto oEP = new EntradaProducto();
        EntradaProductoBD oEPBD = new EntradaProductoBD();
        Kardex oKardex = new Kardex();
        KardexBD oKardexBD = new KardexBD();
        for (int i = 0; i < cantPedidos; i++) {
            serie = tabla_temporal_ventas.getValueAt(i, 0).toString();
            int cant = Integer.parseInt(tabla_temporal_ventas.getValueAt(i, 3).toString());
            String medida = tabla_temporal_ventas.getValueAt(i, 2).toString();
            double precio = Double.parseDouble(tabla_temporal_ventas.getValueAt(i, 4).toString());
            double importe = Double.parseDouble(tabla_temporal_ventas.getValueAt(i, 5).toString());
            String lote = tabla_temporal_ventas.getValueAt(i, 6).toString();
            int idep = Integer.parseInt(tabla_temporal_ventas.getValueAt(i, 7).toString());
            oDetalle.setpSerie(serie);
            oDetalle.setCant(cant);
            oDetalle.setMedida(medida);
            oDetalle.setPrecio(precio);
            oDetalle.setDescuento(0);
            oDetalle.setImporte(importe);
            oDetalle.setIdventa(idventa);
            oDetalle.setIdep(idep);

            boolean rpta = oDetalleBD.registrarVenta(oDetalle);
            String producto = tabla_temporal_ventas.getValueAt(i, 1).toString();
            oKardex.setFecha(txtFecha.getText());
            oKardex.setHora(txtHora.getText());
            oKardex.setTipoOperacion("SALIDA");
            oKardex.setkDescripcion("VENTA " + producto + " " + documento + ":" + txtCorrelativo.getText());
            oKardex.setpSerie(serie);
            oKardex.setLote(lote);
            oKardex.setPresentacion(medida);
            oKardex.setkCantidad(cant);
            oKardex.setkPrecio(precio);
            oKardex.setkImporte(importe);
            oKardex.setTienda(Login_IU.tienda);
            oKardex.setIdventa(idventa);
            oKardexBD.registrarKardex(oKardex);
            tabla_temporal_entradaproducto = oEPBD.buscarProductoXid(idep);
            String presentacion = tabla_temporal_entradaproducto.getValueAt(0, 9).toString();
            String equivalencia = tabla_temporal_entradaproducto.getValueAt(0, 10).toString();

            if (presentacion.equals(equivalencia)) {
                int cantPedido = Integer.parseInt(tabla_temporal_ventas.getValueAt(i, 3).toString());
                int stockUnidadesBD = Integer.parseInt(tabla_temporal_entradaproducto.getValueAt(0, 13).toString());
                double quedaEquivalencia = stockUnidadesBD - cantPedido;
                oEP.setStockPresentacion(0);
                oEP.setStockEquivalencia((int) quedaEquivalencia);
                oEP.setIdep(idep);
                oEPBD.actualizarStockProducto(oEP);
            } else {
                String medidaEscogidaVenta = tabla_temporal_ventas.getValueAt(i, 2).toString();
                if (presentacion.equals(medidaEscogidaVenta)) {
                    int cantPedido = Integer.parseInt(tabla_temporal_ventas.getValueAt(i, 3).toString());
                    double stockPresentacionBD = Double.parseDouble(tabla_temporal_entradaproducto.getValueAt(0, 12).toString());
                    double quedaPresentacion = stockPresentacionBD - cantPedido;
                    double ref = Double.parseDouble(tabla_temporal_entradaproducto.getValueAt(0, 21).toString());
                    double quedaEquivalencia = (quedaPresentacion * ref);

                    oEP.setStockPresentacion(quedaPresentacion);
                    oEP.setStockEquivalencia((int) quedaEquivalencia);
                    oEP.setIdep(idep);
                } else {
                    int cantPedido = Integer.parseInt(tabla_temporal_ventas.getValueAt(i, 3).toString());
                    double stockUnidadesBD = Double.parseDouble(tabla_temporal_entradaproducto.getValueAt(0, 13).toString());
                    double quedaEquivalencia = stockUnidadesBD - cantPedido;
                    double ref = Double.parseDouble(tabla_temporal_entradaproducto.getValueAt(0, 21).toString());
                    double stockQuedaPresentacion = (quedaEquivalencia / ref);

                    oEP.setStockPresentacion(stockQuedaPresentacion);
                    oEP.setStockEquivalencia((int) quedaEquivalencia);
                    oEP.setIdep(idep);
                }

                oEPBD.actualizarStockProducto(oEP);
            }

        }
    }

    private void actualizarCorrelativo(String documento) {
        Correlativo oCorrelativo = new Correlativo();
        CorrelativoBD oCorrelativoBD = new CorrelativoBD();
        oCorrelativo.setCoNumeracion(nueva_numeracon);
        oCorrelativo.setCoDocumento(documento);
        oCorrelativo.setTienda(Login_IU.tienda);
        oCorrelativoBD.actualizarCorrelativo(oCorrelativo);

    }

    private void detalleCaja(int idventa) {
        DetalleCaja oDetalleCaja = new DetalleCaja();
        DetalleCajaBD oDetalleCajaBD = new DetalleCajaBD();
        oDetalleCaja.setDcFecha(txtFecha.getText());
        oDetalleCaja.setDcHora(txtHora.getText());
        oDetalleCaja.setDcCaja("CAJA NRO 1");
        oDetalleCaja.setOpcion("INGRESO");
        oDetalleCaja.setDcCorrelativo("");
        oDetalleCaja.setDcMotivo("VENTA DE PRODUCTOS CON " + documento + ": " + txtCorrelativo.getText());
        oDetalleCaja.setDcMonto(Double.parseDouble(txtTotalPagar.getText()));
        oDetalleCaja.setDcEstado("ABIERTO");
        oDetalleCaja.setuDni(Login_IU.dni_publico);
        oDetalleCaja.setTienda(Login_IU.tienda);
        oDetalleCaja.setIdventa(idventa);
        oDetalleCajaBD.registrarDetalleCaja(oDetalleCaja);
    }
    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // TODO add your handling code here:

        try {
            int cant = tabla_ventas.getRowCount();
            if (txtDniRuc.getText().length() > 0) {
                if (cant > 0) {
                    if (txtPagoCon.getText().length() > 0) {

                        if (cmbTipoPago.getSelectedItem().equals("CREDITO")) {
                            int valor = buscarDeudaCliente();
                            if (valor > 0) {

                            } else {
                                exito("No puede vender al credito, porque no tiene una cuenta aperturada");
                            }
                        } else {
                            int idventa = registrarVenta();
                            if (idventa > -1) {
                                registrarDetallePedidos(idventa);
                                actualizarCorrelativo(documento);
                                detalleCaja(idventa);
                                imprimirDocumento(idventa);
                                sacarNro();
                                limpiarVenta();
                            } else {
                                error("No se pudo realizar la venta");
                            }
                        }
                    } else {
                        advertencia("Ingrese el dinero que va a pagar");
                        txtPagoCon.requestFocus();
                    }

                } else {
                    advertencia("No hay productos para realizar la venta");
                }
            } else {
                advertencia("Falta el cliente");
                txtDniRuc.requestFocus();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Problemas", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed
    private void imprimirDocumento(int idventa) {
        try {
            Conexion mysql = new Conexion();
            Connection cn = mysql.conectar();

            JasperReport reporte = null;
            InputStream reportStream;

            String ruta = "/CapaPresentacion/Reportes/Imprimir_Comprobante.jasper";
            String logo = "/CapaPresentacion/Imagenes/logo.jpeg";

            Map parametro = new HashMap();
            parametro.clear();
            parametro.put("cliente", txtCliente.getText());
            parametro.put("dni_ruc", txtDniRuc.getText());
            parametro.put("comprobante", cmbTipoDocumento.getSelectedItem());
            parametro.put("correlativo", txtCorrelativo.getText());
            parametro.put("tienda", Login_IU.tienda);
            parametro.put("fecha", txtFecha.getText());
            parametro.put("hora", txtHora.getText());
            parametro.put("tipo_pago", cmbTipoPago.getSelectedItem());
            parametro.put("sub_total", txtSubTotal.getText());
            parametro.put("igv", txtIgv.getText());
            parametro.put("total", txtTotalPagar.getText());
            parametro.put("pago_con", txtPagoCon.getText());
            parametro.put("vuelto", txtVuelto.getText());
            parametro.put("usuario", Login_IU.usuario);
            parametro.put("id_venta", idventa);
            parametro.put("logo", this.getClass().getResourceAsStream(logo));
            
            
            reportStream = Venta_IU.class.getResourceAsStream(ruta);
            reporte = (JasperReport) JRLoader.loadObject(reportStream);

            JasperPrint jprint = JasperFillManager.fillReport(reporte, parametro, cn);
            JasperViewer jvmostrar = new JasperViewer(jprint, false);

            jvmostrar.setTitle("IMPRIMIR DOCUMENTO");
            jvmostrar.setVisible(true);
            jvmostrar.setExtendedState(6);
            jvmostrar.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            JasperPrintManager.printReport(jprint, true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void txtPagoConFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPagoConFocusGained
        // TODO add your handling code here:
        txtPagoCon.setBackground(Color.yellow);
    }//GEN-LAST:event_txtPagoConFocusGained

    private void txtPagoConFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPagoConFocusLost
        // TODO add your handling code here:
        txtPagoCon.setBackground(Color.white);
    }//GEN-LAST:event_txtPagoConFocusLost

    private void txtPagoConKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPagoConKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnRegistrar.requestFocus();
            btnRegistrar.doClick();
        }
    }//GEN-LAST:event_txtPagoConKeyPressed

    private void txtPagoConKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPagoConKeyReleased
        // TODO add your handling code here:
        try {
            double totalPagar = Double.parseDouble(txtTotalPagar.getText());
            double pagaCon = Double.parseDouble(txtPagoCon.getText());
            double vuelto = pagaCon - totalPagar;
            txtVuelto.setText("" + vuelto);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_txtPagoConKeyReleased

    private void txtPagoConKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPagoConKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtPagoConKeyTyped

    private void txtSubTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSubTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSubTotalActionPerformed

    private void txtIgvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIgvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIgvActionPerformed

    private void txtTotalPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalPagarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalPagarActionPerformed

    private void btnRegistrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarClienteActionPerformed
        // TODO add your handling code here:
        Cliente_IU frame = new Cliente_IU();
        escritorio.add(frame);
        Dimension a = escritorio.getSize();
        Dimension b = frame.getSize();
        frame.setLocation((a.width - b.width) / 2, (a.height - b.height) / 2);
        frame.show();
    }//GEN-LAST:event_btnRegistrarClienteActionPerformed

    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed
        // TODO add your handling code here:
        if (txtDniRuc.getText().length() > 0) {
            String dni = txtDniRuc.getText().trim();
            ClienteBD oClinteBD = new ClienteBD();

            List<Cliente> lista_cliente = new ArrayList<>();
            lista_cliente = oClinteBD.buscarClienteXdni(dni);

            if (lista_cliente.size() > 0) {
                String cliente = lista_cliente.get(0).getCliDatos();
                txtCliente.setText(cliente);
            } else {
                JOptionPane.showMessageDialog(this, "No se encontro al cliente");
                txtDniRuc.requestFocus();
                txtDniRuc.setText("");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Ingrese un dni o ruc");
            txtDniRuc.requestFocus();
        }
    }//GEN-LAST:event_btnBuscarClienteActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        Pedidos_IU frame = new Pedidos_IU();
        escritorio.add(frame);
        Dimension a = escritorio.getSize();
        Dimension b = frame.getSize();
        frame.setLocation((a.width - b.width) / 2, (a.height - b.height) / 2);
        frame.show();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnQuitarActionPerformed

    private void txtDniRucFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDniRucFocusGained
        // TODO add your handling code here:
        txtDniRuc.setBackground(Color.yellow);
    }//GEN-LAST:event_txtDniRucFocusGained

    private void txtDniRucFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDniRucFocusLost
        // TODO add your handling code here:
        txtDniRuc.setBackground(Color.white);
    }//GEN-LAST:event_txtDniRucFocusLost

    private void txtDniRucKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniRucKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnBuscar.requestFocus();
            btnBuscarCliente.doClick();
        }
    }//GEN-LAST:event_txtDniRucKeyPressed

    private void txtDniRucKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniRucKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) || txtDniRuc.getText().length() >= 8) {
            evt.consume();
        }
    }//GEN-LAST:event_txtDniRucKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscarCliente;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnQuitar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnRegistrarCliente;
    private javax.swing.JComboBox<String> cmbEstado;
    private javax.swing.JComboBox<String> cmbFormapago;
    private javax.swing.JComboBox<String> cmbMoneda;
    private javax.swing.JComboBox<String> cmbTipoDocumento;
    private javax.swing.JComboBox<String> cmbTipoPago;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tabla_ventas;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtCorrelativo;
    private javax.swing.JTextField txtDniRuc;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtHora;
    private javax.swing.JTextField txtIgv;
    private javax.swing.JTextField txtPagoCon;
    private javax.swing.JTextField txtProducto;
    public static javax.swing.JTextField txtSubTotal;
    public static javax.swing.JTextField txtTotalPagar;
    private javax.swing.JTextField txtVuelto;
    // End of variables declaration//GEN-END:variables
}

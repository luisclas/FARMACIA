/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaPresentacion;

import CapaDatos.Categoria;
import CapaDatos.Correlativo;
import CapaNegocios.AjustarColumnasJTable;
import CapaNegocios.CategoriaBD;
import CapaNegocios.CorrelativoBD;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Saucedo
 */
public class Correlativo_IU extends javax.swing.JInternalFrame {

    /**
     * Creates new form Correlativo_IU
     */
    public Correlativo_IU() {
        initComponents();
        reportar();
    }

    public void limpiar() {
        txtCodigo.setText("");
        txtDocumento.setText("");
        txtSerie.setText("");
        txtNumeracion.setText("");

    }

    private void limpiar_tabla_formulario() {
        DefaultTableModel tabla_temporal_correlativo = (DefaultTableModel) tabla_reportes_correlativos.getModel();
        tabla_temporal_correlativo.setRowCount(0);

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

    private void reportar() {

        try {
            setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
            limpiar_tabla_formulario();

            DefaultTableModel tabla_temporal_correlativo = (DefaultTableModel) this.tabla_reportes_correlativos.getModel();

            CorrelativoBD oCorrelativoBD = new CorrelativoBD();
            String tienda = Login_IU.tienda;
            List<Correlativo> lista_correlativo = oCorrelativoBD.reportarCorrelativo(tienda);

            int cant = lista_correlativo.size();

            for (int i = 0; i < cant; i++) {
                int idcorrelativo = lista_correlativo.get(i).getCoCodigo();
                String serie = lista_correlativo.get(i).getCoSerie();
                String numeracion = lista_correlativo.get(i).getCoNumeracion();
                String documento = lista_correlativo.get(i).getCoDocumento();
                tienda = lista_correlativo.get(i).getTienda();

                Object[] data = {idcorrelativo, serie, numeracion, documento, tienda};
                tabla_temporal_correlativo.addRow(data);

            }

            tabla_reportes_correlativos.setModel(tabla_temporal_correlativo);
            setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            
            tabla_reportes_correlativos.setModel(tabla_temporal_correlativo);
            AjustarColumnasJTable.ajustarAnchoColumnas(tabla_reportes_correlativos);
            setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        } catch (Exception ex) {
            setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            ex.printStackTrace();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_reportes_correlativos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtSerie = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNumeracion = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDocumento = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cmbTienda = new javax.swing.JComboBox<>();
        btnModificar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 255, 255));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("CORRELATIVO");

        tabla_reportes_correlativos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "SERIE", "NUMERACION", "DOCUMENTO", "TIENDA"
            }
        ));
        tabla_reportes_correlativos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabla_reportes_correlativosMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_reportes_correlativos);
        if (tabla_reportes_correlativos.getColumnModel().getColumnCount() > 0) {
            tabla_reportes_correlativos.getColumnModel().getColumn(3).setPreferredWidth(350);
            tabla_reportes_correlativos.getColumnModel().getColumn(4).setResizable(false);
        }

        jLabel1.setText("CODIGO");

        txtCodigo.setEnabled(false);

        jLabel2.setText("SERIE");

        txtSerie.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSerieFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSerieFocusLost(evt);
            }
        });
        txtSerie.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSerieKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSerieKeyTyped(evt);
            }
        });

        jLabel3.setText("NUMERACION");

        txtNumeracion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNumeracionFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNumeracionFocusLost(evt);
            }
        });
        txtNumeracion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNumeracionKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumeracionKeyTyped(evt);
            }
        });

        jLabel4.setText("DOCUMENTO");

        txtDocumento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDocumentoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDocumentoFocusLost(evt);
            }
        });
        txtDocumento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDocumentoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDocumentoKeyTyped(evt);
            }
        });

        jLabel5.setText("TIENDA");

        cmbTienda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PRINCIPAL" }));
        cmbTienda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmbTiendaKeyPressed(evt);
            }
        });

        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Imagenes/report_edit.png"))); // NOI18N
        btnModificar.setText("MODIFICAR");
        btnModificar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnModificar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Imagenes/cross.png"))); // NOI18N
        btnCerrar.setText("CERRAR");
        btnCerrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCerrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Imagenes/disk.png"))); // NOI18N
        btnRegistrar.setText("REGISTRAR");
        btnRegistrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRegistrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Imagenes/bin_empty.png"))); // NOI18N
        btnEliminar.setText("ELIMINAR");
        btnEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 771, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSerie)
                    .addComponent(txtNumeracion)
                    .addComponent(txtDocumento)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRegistrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(288, 288, 288)
                                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnModificar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEliminar)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(cmbTienda, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNumeracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbTienda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRegistrar)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnModificar, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnCerrar, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.Alignment.TRAILING)))))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // TODO add your handling code here:
        if (txtSerie.getText().length() > 0) {
            if (txtNumeracion.getText().length() > 0) {
                if (txtDocumento.getText().length() > 0) {

                    Correlativo oCorrelativo = new Correlativo();
                    CorrelativoBD oCorrelativoBD = new CorrelativoBD();

                    oCorrelativo.setCoSerie(txtSerie.getText().trim());
                    oCorrelativo.setCoNumeracion(txtNumeracion.getText().trim());
                    oCorrelativo.setCoDocumento(txtDocumento.getText().toUpperCase().trim());
                    oCorrelativo.setTienda(cmbTienda.getSelectedItem().toString());

                    boolean rpta = oCorrelativoBD.registrarCorrelativo(oCorrelativo);
                    if (rpta) {
                        exito("Se registro con exito");
                        reportar();
                        limpiar();

                    } else {
                        error("Tienes problemas al registrar");
                    }
                } else {
                    advertencia("Ingrese documento");
                    txtSerie.requestFocus();
                }
            } else {
                advertencia("Ingrese la numeracion");
                txtSerie.requestFocus();
            }

        } else {
            advertencia("Ingrese la serie...");
            txtSerie.requestFocus();
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void tabla_reportes_correlativosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_reportes_correlativosMousePressed
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {

            int fila_seleccionada = tabla_reportes_correlativos.getSelectedRow();

            txtCodigo.setText(tabla_reportes_correlativos.getValueAt(fila_seleccionada, 0).toString());
            txtSerie.setText(tabla_reportes_correlativos.getValueAt(fila_seleccionada, 1).toString());
            txtNumeracion.setText(tabla_reportes_correlativos.getValueAt(fila_seleccionada, 2).toString());
            txtDocumento.setText(tabla_reportes_correlativos.getValueAt(fila_seleccionada, 3).toString());
            cmbTienda.setSelectedItem(tabla_reportes_correlativos.getValueAt(fila_seleccionada, 4).toString());

        }
    }//GEN-LAST:event_tabla_reportes_correlativosMousePressed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        if (txtCodigo.getText().length() > 0) {
            if (txtSerie.getText().length() > 0) {
                if (txtNumeracion.getText().length() > 0) {
                    if (txtDocumento.getText().length() > 0) {

                        Correlativo oCorrelativo = new Correlativo();
                        CorrelativoBD oCorrelativoBD = new CorrelativoBD();

                        oCorrelativo.setCoCodigo(Integer.parseInt(txtCodigo.getText().trim()));
                        oCorrelativo.setCoSerie(txtSerie.getText().trim());
                        oCorrelativo.setCoNumeracion(txtNumeracion.getText().trim());
                        oCorrelativo.setCoDocumento(txtDocumento.getText().toUpperCase().trim());

                        boolean rpta = oCorrelativoBD.modificarCorrelativo(oCorrelativo);
                        if (rpta) {
                            exito("Se modifico con exito");
                            reportar();
                            limpiar();

                        } else {
                            error("Tienes problemas al modificar");
                        }
                    } else {
                        advertencia("Ingrese documento");
                        txtSerie.requestFocus();
                    }
                } else {
                    advertencia("Ingrese la numeracion");
                    txtSerie.requestFocus();
                }

            } else {
                advertencia("Ingrese la serie...");
                txtSerie.requestFocus();
            }

        } else {
            advertencia("Falta el codigo para modificar...");
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        try {

            if (txtCodigo.getText().length() > 0) {
                int aviso = JOptionPane.showConfirmDialog(rootPane, "Estas seguro de eliminar");
                if (aviso == 0) {

                    int codigo = Integer.parseInt(txtCodigo.getText());
                    
                    CorrelativoBD oCorrelativoBD = new CorrelativoBD();
                    
                    boolean rpta = oCorrelativoBD.eliminarCorrelativo(codigo);
                    if (rpta) {
                        exito("Se elimino con exito");
                        reportar();
                        limpiar();
                    } else {
                        error("Tienes problemas al eliminar");
                    }
                }
            } else {
                advertencia("Se necesita el codif¡go para modificar....");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtSerieFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSerieFocusGained
        // TODO add your handling code here:
        txtSerie.setBackground(Color.yellow);
    }//GEN-LAST:event_txtSerieFocusGained

    private void txtSerieFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSerieFocusLost
        // TODO add your handling code here:
        txtSerie.setBackground(Color.white);
    }//GEN-LAST:event_txtSerieFocusLost

    private void txtNumeracionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNumeracionFocusGained
        // TODO add your handling code here:
        txtNumeracion.setBackground(Color.yellow);
    }//GEN-LAST:event_txtNumeracionFocusGained

    private void txtNumeracionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNumeracionFocusLost
        // TODO add your handling code here:
        txtNumeracion.setBackground(Color.white);
    }//GEN-LAST:event_txtNumeracionFocusLost

    private void txtDocumentoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDocumentoFocusGained
        // TODO add your handling code here:
        txtDocumento.setBackground(Color.yellow);
    }//GEN-LAST:event_txtDocumentoFocusGained

    private void txtDocumentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDocumentoFocusLost
        // TODO add your handling code here:
        txtDocumento.setBackground(Color.white);
    }//GEN-LAST:event_txtDocumentoFocusLost

    private void txtSerieKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSerieKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) || txtSerie.getText().length() >= 4) {
            evt.consume();
        }
    }//GEN-LAST:event_txtSerieKeyTyped

    private void txtNumeracionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumeracionKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) || txtNumeracion.getText().length() >= 6) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNumeracionKeyTyped

    private void txtSerieKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSerieKeyPressed
        // TODO add your handling code here:
         if (evt.getExtendedKeyCode() == KeyEvent.VK_ENTER) {
            txtNumeracion.requestFocus();
        }
    }//GEN-LAST:event_txtSerieKeyPressed

    private void txtNumeracionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumeracionKeyPressed
        // TODO add your handling code here:
         if (evt.getExtendedKeyCode() == KeyEvent.VK_ENTER) {
            txtDocumento.requestFocus();
        }
    }//GEN-LAST:event_txtNumeracionKeyPressed

    private void txtDocumentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDocumentoKeyPressed
        // TODO add your handling code here:
         if (evt.getExtendedKeyCode() == KeyEvent.VK_ENTER) {
            cmbTienda.requestFocus();
        }
    }//GEN-LAST:event_txtDocumentoKeyPressed

    private void cmbTiendaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbTiendaKeyPressed
        // TODO add your handling code here:
         if (evt.getExtendedKeyCode() == KeyEvent.VK_ENTER) {
            btnRegistrar.requestFocus();
            btnRegistrar.doClick();
        }
    }//GEN-LAST:event_cmbTiendaKeyPressed

    private void txtDocumentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDocumentoKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtDocumentoKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cmbTienda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla_reportes_correlativos;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDocumento;
    private javax.swing.JTextField txtNumeracion;
    private javax.swing.JTextField txtSerie;
    // End of variables declaration//GEN-END:variables
}

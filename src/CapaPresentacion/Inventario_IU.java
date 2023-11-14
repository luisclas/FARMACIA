/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaPresentacion;

import CapaConexion.Conexion;
import CapaNegocios.AjustarColumnasJTable;
import CapaNegocios.ColorearColumnasJTable;
import CapaNegocios.EntradaProductoBD;
import java.awt.Color;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Saucedo
 */
public class Inventario_IU extends javax.swing.JInternalFrame {

    /**
     * Creates new form Inventario_IU
     */
    public Inventario_IU() {
        initComponents();
        reportar();
        
        ColorearColumnasJTable col5= new ColorearColumnasJTable(5, Color.YELLOW);
        
        ColorearColumnasJTable col7= new ColorearColumnasJTable(7, Color.PINK);
        
        tabla_reporte_inventario.getColumnModel().getColumn(5).setCellRenderer(col5);
        tabla_reporte_inventario.getColumnModel().getColumn(7).setCellRenderer(col7);
    }

    private void limpiar_tabla_formulario() {
        DefaultTableModel tabla_temporal_inventario = (DefaultTableModel) tabla_reporte_inventario.getModel();
        tabla_temporal_inventario.setRowCount(0);
    }

    private void reportar() {
        setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        limpiar_tabla_formulario();
        DefaultTableModel tabla_temporal_inventario = (DefaultTableModel) tabla_reporte_inventario.getModel();
        DefaultTableModel tabla_temporal;
        EntradaProductoBD oEntradaProductoBD = new EntradaProductoBD();
        tabla_temporal = oEntradaProductoBD.inventario();
        int cant_producto = tabla_temporal.getRowCount();
        String medida_final;
        String stock_final;
        double precio_compra_final = 0;
        double dinero_vendiendo_mayor = 0;
        double dinero_vendiendo_unidades = 0;
        double dinero_venta_medida = 0;
        double dinero_invertido = 0;

        for (int i = 0; i < cant_producto; i++) {
            int idep = Integer.parseInt(tabla_temporal.getValueAt(i, 0).toString());
            String presentacion = tabla_temporal.getValueAt(i, 4).toString();
            String equivalencia = tabla_temporal.getValueAt(i, 5).toString();

            if (presentacion.equals(equivalencia)) {
                medida_final = equivalencia;
                precio_compra_final = Double.parseDouble(tabla_temporal.getValueAt(i, 13).toString());
                stock_final = tabla_temporal.getValueAt(i, 11).toString();
                dinero_venta_medida = Double.parseDouble(tabla_temporal.getValueAt(i, 15).toString());

            } else {
                medida_final = presentacion;
                precio_compra_final = Double.parseDouble(tabla_temporal.getValueAt(i, 12).toString());
                stock_final = tabla_temporal.getValueAt(i, 10).toString();
                dinero_venta_medida = Double.parseDouble(tabla_temporal.getValueAt(i, 14).toString());
            }
            dinero_vendiendo_mayor += Double.parseDouble(tabla_temporal.getValueAt(i, 14).toString());
            dinero_vendiendo_unidades += Double.parseDouble(tabla_temporal.getValueAt(i, 15).toString());
            
            dinero_invertido = dinero_invertido + precio_compra_final;
            
            String ingreso = tabla_temporal.getValueAt(i, 1).toString();
            String serie = tabla_temporal.getValueAt(i, 2).toString();
            String producto = tabla_temporal.getValueAt(i, 3).toString();
            String marca = tabla_temporal.getValueAt(i, 6).toString();
            String categoria = tabla_temporal.getValueAt(i, 7).toString();
            String lote = tabla_temporal.getValueAt(i, 8).toString();
            String fecha_vcto = tabla_temporal.getValueAt(i, 9).toString();
            String tienda = tabla_temporal.getValueAt(i, 16).toString();
            
            Object[] data = {idep,ingreso,serie,producto,medida_final,marca,categoria,lote,fecha_vcto,stock_final,precio_compra_final,dinero_venta_medida,tienda};
            tabla_temporal_inventario.addRow(data);    
            
             int cant = tabla_temporal.getRowCount();
            txtCantidad.setText("" + cant);
            
            tabla_reporte_inventario.setModel(tabla_temporal);
            AjustarColumnasJTable.ajustarAnchoColumnas(tabla_reporte_inventario);
            setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        }
        
        BigDecimal numero = new BigDecimal(dinero_invertido);
        BigDecimal dineroCompras = numero.setScale(2, RoundingMode.DOWN);
        
        
        BigDecimal numero1 = new BigDecimal(dinero_vendiendo_mayor);
        BigDecimal dineroGananciaMayor = numero1.setScale(1, RoundingMode.DOWN);
        
        
        BigDecimal numero2 = new BigDecimal(dinero_vendiendo_unidades);
        BigDecimal dineroGananciaMenor = numero2.setScale(1, RoundingMode.DOWN);
        
        txtCantidad.setText("" + cant_producto);
        txtDineroInvertido.setText("" + dineroCompras);
        txtVendiendoMayor.setText("" + dineroGananciaMayor);
        txtVendiendoMenor.setText("" + dineroGananciaMenor);
        
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        
    
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
        tabla_reporte_inventario = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtDineroInvertido = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        btnImprimir = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtVendiendoMenor = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtVendiendoMayor = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 255, 255));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("INVENTARIO DE PRODUCTOS");

        tabla_reporte_inventario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "INGRESO", "SERIE", "PRODUCTO", "MEDIDA", "MARCA", "CATEGORIA", "LOTE", "FECHA VCTO", "STOCK", "PRECIO COMPRA", "PRECIO VENTA", "TIENDA"
            }
        ));
        jScrollPane1.setViewportView(tabla_reporte_inventario);
        if (tabla_reporte_inventario.getColumnModel().getColumnCount() > 0) {
            tabla_reporte_inventario.getColumnModel().getColumn(3).setPreferredWidth(400);
            tabla_reporte_inventario.getColumnModel().getColumn(12).setResizable(false);
        }

        jLabel1.setText("DINERO INVERTIDO");

        txtDineroInvertido.setEnabled(false);

        jLabel2.setText("CANT.PRODUCTOS");

        txtCantidad.setEnabled(false);

        btnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Imagenes/impresora2.png"))); // NOI18N
        btnImprimir.setText("IMPRIMIR");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        jLabel3.setText("DINERO VENDIENDO X MENOR");

        txtVendiendoMenor.setEnabled(false);

        jLabel4.setText("DINERO VENDIENDO X MAYOR");

        txtVendiendoMayor.setEnabled(false);

        jLabel5.setBackground(new java.awt.Color(204, 0, 0));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 0, 51));
        jLabel5.setText("+ Solo muestra los productos que tienen en stock");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDineroInvertido, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(280, 280, 280)
                        .addComponent(btnImprimir)
                        .addGap(274, 274, 274)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtVendiendoMenor, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtVendiendoMayor, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtDineroInvertido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnImprimir)
                        .addComponent(jLabel3)
                        .addComponent(txtVendiendoMenor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(txtVendiendoMayor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        // TODO add your handling code here:
         try {
            Conexion msyql=new Conexion();
            Connection cn=msyql.conectar();
            
            JasperReport reporte=null;
            
            String ruta = "src/CapaPresentacion/Reportes/Reporte_Inventario_Producto.jasper";
            reporte = (JasperReport) JRLoader.loadObjectFromFile(ruta);
            
            JasperPrint jprint = JasperFillManager.fillReport(reporte, null, cn);
            JasperViewer jvmostrar=new JasperViewer(jprint,false);
            
            jvmostrar.setTitle("REPORTE DE INVENTARIO PRODUCTO");
            jvmostrar.setVisible(true);
            jvmostrar.setExtendedState(6);
            
            jvmostrar.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnImprimirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnImprimir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla_reporte_inventario;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtDineroInvertido;
    private javax.swing.JTextField txtVendiendoMayor;
    private javax.swing.JTextField txtVendiendoMenor;
    // End of variables declaration//GEN-END:variables
}

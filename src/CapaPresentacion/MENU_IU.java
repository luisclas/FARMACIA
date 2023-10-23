/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaPresentacion;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Saucedo
 */
public class MENU_IU extends javax.swing.JFrame {

    /**
     * Creates new form MENU_IU
     */
    public MENU_IU() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        btnProductos = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnCompras = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btnIngresos = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        btnEgresos = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        btnVentas = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        btnCaja = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JToolBar.Separator();
        btnCerrar = new javax.swing.JButton();
        escritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        menu_mantenimiento = new javax.swing.JMenu();
        Menu_item_TipoUsuario = new javax.swing.JMenuItem();
        Menu_item_Usuario = new javax.swing.JMenuItem();
        Menu_item_Turno = new javax.swing.JMenuItem();
        Menu_item_LABORATORIO = new javax.swing.JMenuItem();
        Menu_item_Categoria = new javax.swing.JMenuItem();
        Menu_item_medida = new javax.swing.JMenuItem();
        Menu_item_producto = new javax.swing.JMenuItem();
        Menu_item_Composicion = new javax.swing.JMenuItem();
        Menu_item_Proveedor = new javax.swing.JMenuItem();
        Menu_item_cuentas_bancarias = new javax.swing.JMenuItem();
        Menu_item_correlativo = new javax.swing.JMenuItem();
        menu_compras = new javax.swing.JMenu();
        Menu_item_compras = new javax.swing.JMenuItem();
        Menu_item_compras_varios = new javax.swing.JMenuItem();
        menu_inventario = new javax.swing.JMenu();
        menu_item_entrada_productos = new javax.swing.JMenuItem();
        menu_item_inventario = new javax.swing.JMenuItem();
        menu_item_modificar_precio_productos = new javax.swing.JMenuItem();
        menu_ventas = new javax.swing.JMenu();
        menu_caja = new javax.swing.JMenu();
        menu_item_egresos = new javax.swing.JMenuItem();
        menu_item_ingreso = new javax.swing.JMenuItem();
        menu_item_cerrar_caja = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(6);

        jToolBar1.setBackground(new java.awt.Color(204, 255, 204));
        jToolBar1.setRollover(true);

        btnProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Imagenes/box.png"))); // NOI18N
        btnProductos.setEnabled(false);
        btnProductos.setFocusable(false);
        btnProductos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnProductos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductosActionPerformed(evt);
            }
        });
        jToolBar1.add(btnProductos);
        jToolBar1.add(jSeparator1);

        btnCompras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Imagenes/compra.png"))); // NOI18N
        btnCompras.setEnabled(false);
        btnCompras.setFocusable(false);
        btnCompras.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCompras.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprasActionPerformed(evt);
            }
        });
        jToolBar1.add(btnCompras);
        jToolBar1.add(jSeparator2);

        btnIngresos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Imagenes/ingresos.png"))); // NOI18N
        btnIngresos.setEnabled(false);
        jToolBar1.add(btnIngresos);
        jToolBar1.add(jSeparator3);

        btnEgresos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Imagenes/egresos.png"))); // NOI18N
        btnEgresos.setEnabled(false);
        btnEgresos.setFocusable(false);
        btnEgresos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEgresos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnEgresos);
        jToolBar1.add(jSeparator4);

        btnVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Imagenes/venta1.png"))); // NOI18N
        btnVentas.setEnabled(false);
        btnVentas.setFocusable(false);
        btnVentas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnVentas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnVentas);
        jToolBar1.add(jSeparator5);

        btnCaja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Imagenes/caja_1.png"))); // NOI18N
        btnCaja.setEnabled(false);
        btnCaja.setFocusable(false);
        btnCaja.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCaja.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnCaja);
        jToolBar1.add(jSeparator6);

        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Imagenes/cerrar2.png"))); // NOI18N
        btnCerrar.setFocusable(false);
        btnCerrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCerrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnCerrar);

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1152, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 672, Short.MAX_VALUE)
        );

        jMenuBar1.setEnabled(false);

        menu_mantenimiento.setText("MANTENIMIENTO");
        menu_mantenimiento.setEnabled(false);
        menu_mantenimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_mantenimientoActionPerformed(evt);
            }
        });

        Menu_item_TipoUsuario.setText("Tipo_Usuario");
        Menu_item_TipoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Menu_item_TipoUsuarioActionPerformed(evt);
            }
        });
        menu_mantenimiento.add(Menu_item_TipoUsuario);

        Menu_item_Usuario.setText("Usuario");
        Menu_item_Usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Menu_item_UsuarioActionPerformed(evt);
            }
        });
        menu_mantenimiento.add(Menu_item_Usuario);

        Menu_item_Turno.setText("Turno");
        Menu_item_Turno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Menu_item_TurnoActionPerformed(evt);
            }
        });
        menu_mantenimiento.add(Menu_item_Turno);

        Menu_item_LABORATORIO.setText("Laboratorio");
        Menu_item_LABORATORIO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Menu_item_LABORATORIOActionPerformed(evt);
            }
        });
        menu_mantenimiento.add(Menu_item_LABORATORIO);

        Menu_item_Categoria.setText("Categoria");
        Menu_item_Categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Menu_item_CategoriaActionPerformed(evt);
            }
        });
        menu_mantenimiento.add(Menu_item_Categoria);

        Menu_item_medida.setText("Medida");
        Menu_item_medida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Menu_item_medidaActionPerformed(evt);
            }
        });
        menu_mantenimiento.add(Menu_item_medida);

        Menu_item_producto.setText("Producto");
        Menu_item_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Menu_item_productoActionPerformed(evt);
            }
        });
        menu_mantenimiento.add(Menu_item_producto);

        Menu_item_Composicion.setText("Composicion");
        Menu_item_Composicion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Menu_item_ComposicionActionPerformed(evt);
            }
        });
        menu_mantenimiento.add(Menu_item_Composicion);

        Menu_item_Proveedor.setText("Proveedor");
        Menu_item_Proveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Menu_item_ProveedorActionPerformed(evt);
            }
        });
        menu_mantenimiento.add(Menu_item_Proveedor);

        Menu_item_cuentas_bancarias.setText("Cuentas Bancarias");
        Menu_item_cuentas_bancarias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Menu_item_cuentas_bancariasActionPerformed(evt);
            }
        });
        menu_mantenimiento.add(Menu_item_cuentas_bancarias);

        Menu_item_correlativo.setText("Correlativo");
        Menu_item_correlativo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Menu_item_correlativoActionPerformed(evt);
            }
        });
        menu_mantenimiento.add(Menu_item_correlativo);

        jMenuBar1.add(menu_mantenimiento);

        menu_compras.setText("COMPRAS");
        menu_compras.setEnabled(false);

        Menu_item_compras.setText("Realizar Compras");
        Menu_item_compras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Menu_item_comprasActionPerformed(evt);
            }
        });
        menu_compras.add(Menu_item_compras);

        Menu_item_compras_varios.setText("Reporte de Compras Varios");
        Menu_item_compras_varios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Menu_item_compras_variosActionPerformed(evt);
            }
        });
        menu_compras.add(Menu_item_compras_varios);

        jMenuBar1.add(menu_compras);

        menu_inventario.setText("INVENTARIO");
        menu_inventario.setEnabled(false);

        menu_item_entrada_productos.setText("Entradas de Productos");
        menu_item_entrada_productos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_item_entrada_productosActionPerformed(evt);
            }
        });
        menu_inventario.add(menu_item_entrada_productos);

        menu_item_inventario.setText("Dinero en Inventario");
        menu_item_inventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_item_inventarioActionPerformed(evt);
            }
        });
        menu_inventario.add(menu_item_inventario);

        menu_item_modificar_precio_productos.setText("Modificar Precio de Productos");
        menu_item_modificar_precio_productos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_item_modificar_precio_productosActionPerformed(evt);
            }
        });
        menu_inventario.add(menu_item_modificar_precio_productos);

        jMenuBar1.add(menu_inventario);

        menu_ventas.setText("VENTAS");
        menu_ventas.setEnabled(false);
        jMenuBar1.add(menu_ventas);

        menu_caja.setText("CAJA");
        menu_caja.setEnabled(false);

        menu_item_egresos.setText("Egreso");
        menu_item_egresos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_item_egresosActionPerformed(evt);
            }
        });
        menu_caja.add(menu_item_egresos);

        menu_item_ingreso.setText("Ingreso");
        menu_item_ingreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_item_ingresoActionPerformed(evt);
            }
        });
        menu_caja.add(menu_item_ingreso);

        menu_item_cerrar_caja.setText("Ver Caja");
        menu_item_cerrar_caja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_item_cerrar_cajaActionPerformed(evt);
            }
        });
        menu_caja.add(menu_item_cerrar_caja);

        jMenuBar1.add(menu_caja);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(escritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(escritorio))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void Menu_item_TipoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Menu_item_TipoUsuarioActionPerformed
        // TODO add your handling code here:
        TipoUsuario_IU frame = new TipoUsuario_IU();
        escritorio.add(frame);
        Dimension desktopSize = escritorio.getSize();
        Dimension FrameSize = frame.getSize();
        frame.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);

        frame.show();
    }//GEN-LAST:event_Menu_item_TipoUsuarioActionPerformed

    private void Menu_item_UsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Menu_item_UsuarioActionPerformed
        // TODO add your handling code here:
        Usuario_IU frame = new Usuario_IU();
        escritorio.add(frame);
        Dimension desktopSize = escritorio.getSize();
        Dimension FrameSize = frame.getSize();
        frame.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);

        frame.show();
    }//GEN-LAST:event_Menu_item_UsuarioActionPerformed

    private void Menu_item_TurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Menu_item_TurnoActionPerformed
        // TODO add your handling code here:
        Turno_IU frame = new Turno_IU();
        escritorio.add(frame);
        Dimension desktopSize = escritorio.getSize();
        Dimension FrameSize = frame.getSize();
        frame.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);

        frame.show();
    }//GEN-LAST:event_Menu_item_TurnoActionPerformed

    private void Menu_item_LABORATORIOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Menu_item_LABORATORIOActionPerformed
        // TODO add your handling code here:
        Marca_IU frame = new Marca_IU();
        escritorio.add(frame);
        Dimension desktopSize = escritorio.getSize();
        Dimension FrameSize = frame.getSize();
        frame.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);

        frame.show();
    }//GEN-LAST:event_Menu_item_LABORATORIOActionPerformed

    private void Menu_item_CategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Menu_item_CategoriaActionPerformed
        // TODO add your handling code here:
        Categoria_IU frame = new Categoria_IU();
        escritorio.add(frame);
        Dimension desktopSize = escritorio.getSize();
        Dimension FrameSize = frame.getSize();
        frame.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);

        frame.show();
    }//GEN-LAST:event_Menu_item_CategoriaActionPerformed

    private void menu_mantenimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_mantenimientoActionPerformed
        // TODO add your handling code here:
        Proveedor_IU frame = new Proveedor_IU();
        escritorio.add(frame);
        Dimension desktopSize = escritorio.getSize();
        Dimension FrameSize = frame.getSize();
        frame.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);

        frame.show();
    }//GEN-LAST:event_menu_mantenimientoActionPerformed

    private void Menu_item_medidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Menu_item_medidaActionPerformed
        // TODO add your handling code here:
        Medida_IU frame = new Medida_IU();
        escritorio.add(frame);
        Dimension desktopSize = escritorio.getSize();
        Dimension FrameSize = frame.getSize();
        frame.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);

        frame.show();
    }//GEN-LAST:event_Menu_item_medidaActionPerformed

    private void Menu_item_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Menu_item_productoActionPerformed
        // TODO add your handling code here:
        Producto_IU frame = new Producto_IU();
        escritorio.add(frame);
        Dimension desktopSize = escritorio.getSize();
        Dimension FrameSize = frame.getSize();
        frame.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);

        frame.show();

    }//GEN-LAST:event_Menu_item_productoActionPerformed

    private void Menu_item_ComposicionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Menu_item_ComposicionActionPerformed
        // TODO add your handling code here:
        Composicion_IU frame = new Composicion_IU();
        escritorio.add(frame);
        Dimension desktopSize = escritorio.getSize();
        Dimension FrameSize = frame.getSize();
        frame.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);

        frame.show();
    }//GEN-LAST:event_Menu_item_ComposicionActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        // TODO add your handling code here:
        int respuesta = JOptionPane.showConfirmDialog(null, "Estas seguro de salir?", "confirma", JOptionPane.YES_NO_OPTION);
        if (JOptionPane.OK_OPTION == respuesta) {
            System.exit(0);
        }

    }//GEN-LAST:event_btnCerrarActionPerformed

    private void Menu_item_cuentas_bancariasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Menu_item_cuentas_bancariasActionPerformed
        // TODO add your handling code here:
        CuentasBancariasProveedor_IU frame = new CuentasBancariasProveedor_IU();
        escritorio.add(frame);
        Dimension desktopSize = escritorio.getSize();
        Dimension FrameSize = frame.getSize();
        frame.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);

        frame.show();
    }//GEN-LAST:event_Menu_item_cuentas_bancariasActionPerformed

    private void Menu_item_comprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Menu_item_comprasActionPerformed
        // TODO add your handling code here:
        Compras_IU frame = new Compras_IU();
        escritorio.add(frame);
        Dimension desktopSize = escritorio.getSize();
        Dimension FrameSize = frame.getSize();
        frame.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);

        frame.show();
    }//GEN-LAST:event_Menu_item_comprasActionPerformed

    private void Menu_item_ProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Menu_item_ProveedorActionPerformed
        // TODO add your handling code here:
        Proveedor_IU frame = new Proveedor_IU();
        escritorio.add(frame);
        Dimension desktopSize = escritorio.getSize();
        Dimension FrameSize = frame.getSize();
        frame.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);

        frame.show();
    }//GEN-LAST:event_Menu_item_ProveedorActionPerformed

    private void Menu_item_compras_variosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Menu_item_compras_variosActionPerformed
        // TODO add your handling code here:
        ReporteComprasVarios_IU frame = new ReporteComprasVarios_IU();
        escritorio.add(frame);
        Dimension desktopSize = escritorio.getSize();
        Dimension FrameSize = frame.getSize();
        frame.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);

        frame.show();
    }//GEN-LAST:event_Menu_item_compras_variosActionPerformed

    private void btnProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductosActionPerformed
        // TODO add your handling code here:
        Producto_IU frame = new Producto_IU();
        escritorio.add(frame);
        Dimension desktopSize = escritorio.getSize();
        Dimension FrameSize = frame.getSize();
        frame.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);

        frame.show();
    }//GEN-LAST:event_btnProductosActionPerformed

    private void btnComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprasActionPerformed
        // TODO add your handling code here:
        Compras_IU frame = new Compras_IU();
        escritorio.add(frame);
        Dimension desktopSize = escritorio.getSize();
        Dimension FrameSize = frame.getSize();
        frame.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);

        frame.show();

    }//GEN-LAST:event_btnComprasActionPerformed

    private void menu_item_entrada_productosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_item_entrada_productosActionPerformed
        // TODO add your handling code here:
        EntradaProductos_IU frame = new EntradaProductos_IU();
        escritorio.add(frame);
        Dimension desktopSize = escritorio.getSize();
        Dimension FrameSize = frame.getSize();
        frame.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);

        frame.show();
    }//GEN-LAST:event_menu_item_entrada_productosActionPerformed

    private void menu_item_inventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_item_inventarioActionPerformed
        // TODO add your handling code here:
        Inventario_IU frame = new Inventario_IU();
        escritorio.add(frame);
        Dimension desktopSize = escritorio.getSize();
        Dimension FrameSize = frame.getSize();
        frame.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);

        frame.show();
    }//GEN-LAST:event_menu_item_inventarioActionPerformed

    private void menu_item_modificar_precio_productosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_item_modificar_precio_productosActionPerformed
        // TODO add your handling code here:
        ModificarPreciosProductos_IU frame = new ModificarPreciosProductos_IU();
        escritorio.add(frame);
        Dimension desktopSize = escritorio.getSize();
        Dimension FrameSize = frame.getSize();
        frame.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);

        frame.show();

    }//GEN-LAST:event_menu_item_modificar_precio_productosActionPerformed

    private void Menu_item_correlativoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Menu_item_correlativoActionPerformed
        // TODO add your handling code here:
        Correlativo_IU frame = new Correlativo_IU();
        escritorio.add(frame);
        Dimension desktopSize = escritorio.getSize();
        Dimension FrameSize = frame.getSize();
        frame.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);

        frame.show();

    }//GEN-LAST:event_Menu_item_correlativoActionPerformed

    private void menu_item_egresosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_item_egresosActionPerformed
        // TODO add your handling code here:
        Egresos_IU frame = new Egresos_IU();
        escritorio.add(frame);
        Dimension desktopSize = escritorio.getSize();
        Dimension FrameSize = frame.getSize();
        frame.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);

        frame.show();
    }//GEN-LAST:event_menu_item_egresosActionPerformed

    private void menu_item_ingresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_item_ingresoActionPerformed
        // TODO add your handling code here:
        Ingresos_IU frame = new Ingresos_IU();
        escritorio.add(frame);
        Dimension desktopSize = escritorio.getSize();
        Dimension FrameSize = frame.getSize();
        frame.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);

        frame.show();
    }//GEN-LAST:event_menu_item_ingresoActionPerformed

    private void menu_item_cerrar_cajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_item_cerrar_cajaActionPerformed
        // TODO add your handling code here:
        Caja_IU frame = new Caja_IU();
        escritorio.add(frame);
        Dimension desktopSize = escritorio.getSize();
        Dimension FrameSize = frame.getSize();
        frame.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);

        frame.show();
    }//GEN-LAST:event_menu_item_cerrar_cajaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MENU_IU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MENU_IU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MENU_IU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MENU_IU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MENU_IU().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Menu_item_Categoria;
    private javax.swing.JMenuItem Menu_item_Composicion;
    private javax.swing.JMenuItem Menu_item_LABORATORIO;
    private javax.swing.JMenuItem Menu_item_Proveedor;
    private javax.swing.JMenuItem Menu_item_TipoUsuario;
    private javax.swing.JMenuItem Menu_item_Turno;
    private javax.swing.JMenuItem Menu_item_Usuario;
    private javax.swing.JMenuItem Menu_item_compras;
    private javax.swing.JMenuItem Menu_item_compras_varios;
    private javax.swing.JMenuItem Menu_item_correlativo;
    private javax.swing.JMenuItem Menu_item_cuentas_bancarias;
    private javax.swing.JMenuItem Menu_item_medida;
    private javax.swing.JMenuItem Menu_item_producto;
    public javax.swing.JButton btnCaja;
    public javax.swing.JButton btnCerrar;
    public javax.swing.JButton btnCompras;
    public javax.swing.JButton btnEgresos;
    public javax.swing.JButton btnIngresos;
    public javax.swing.JButton btnProductos;
    public javax.swing.JButton btnVentas;
    public static javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JToolBar jToolBar1;
    public javax.swing.JMenu menu_caja;
    public javax.swing.JMenu menu_compras;
    public javax.swing.JMenu menu_inventario;
    private javax.swing.JMenuItem menu_item_cerrar_caja;
    private javax.swing.JMenuItem menu_item_egresos;
    private javax.swing.JMenuItem menu_item_entrada_productos;
    private javax.swing.JMenuItem menu_item_ingreso;
    private javax.swing.JMenuItem menu_item_inventario;
    private javax.swing.JMenuItem menu_item_modificar_precio_productos;
    public static javax.swing.JMenu menu_mantenimiento;
    public javax.swing.JMenu menu_ventas;
    // End of variables declaration//GEN-END:variables
}

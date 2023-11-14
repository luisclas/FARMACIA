/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaNegocios;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Saucedo
 */
public class ColorearColumnasJTable extends DefaultTableCellRenderer {

    private int columna;
    private Color color_fondo;

    public ColorearColumnasJTable(int columna, Color color_fondo) {
        this.columna = columna;
        this.color_fondo = color_fondo;
    }

    @Override

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        Component c = super.getTableCellRendererComponent(table, value, hasFocus, hasFocus, row, column);

        if (column == columna) {
            c.setBackground(color_fondo);

        } else {
            c.setBackground(table.getBackground());
        }
        return c;
    }

}

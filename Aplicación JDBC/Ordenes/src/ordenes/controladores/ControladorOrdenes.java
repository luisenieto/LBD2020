/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordenes.controladores;

import interfaces.IControladorOrdenes;
import items.modelos.ModeloTablaDetalles;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import ordenes.modelos.ModeloTablaOrdenes;
import ordenes.modelos.Orden;
import ordenes.vistas.VentanaOrdenes;

public class ControladorOrdenes implements IControladorOrdenes {
    private VentanaOrdenes ventana;
        
    /**
     * Constructor
     * Muestra la ventana de personas de forma modal
     * @param ventanaPadre ventana padre (VentanaPrincipal en este caso)
     */
    public ControladorOrdenes(Frame ventanaPadre) {
        this.ventana = new VentanaOrdenes(this, ventanaPadre);
        this.ventana.setTitle(TITULO);
        this.ventana.setLocationRelativeTo(null);        
        ModeloTablaOrdenes mto = new ModeloTablaOrdenes();
        JTable tablaOrdenes = this.ventana.verTablaOrdenes();
        tablaOrdenes.setModel(mto);
        this.agregarListener(tablaOrdenes, mto);   
        if (mto.getRowCount() > 0)
            tablaOrdenes.setRowSelectionInterval(0, 0); 
        this.ventana.setVisible(true);
    }
    
    /**
     * Agrega un listener a la tabla para detectar cuando se cambie de fila
     * Cuando se cambia de fila (de orden) se refrezca la tabla detalles con el detalle de la nueva orden
     * @param tablaOrdenes tabla a la que se agrega el listener
     * @param mto modelo de la tabla 
     */
    private void agregarListener(JTable tablaOrdenes, ModeloTablaOrdenes mto) {        
        tablaOrdenes.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            JTable tablaDetalle = ventana.verTablaDetalle();
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int fila = tablaOrdenes.getSelectedRow();
                    if (fila != -1) {
                        Orden orden = mto.verOrden(fila);
                        ModeloTablaDetalles mte = new ModeloTablaDetalles(orden);
                        tablaDetalle.setModel(mte);
                    }
                }
            }
        });
    }                     
    
    @Override
    public void btnVolverClic(ActionEvent evt) {
        this.ventana.dispose();
    }

    @Override
    public void btnBuscarClic(ActionEvent evt) {
        ModeloTablaOrdenes mto;
        
        Integer anio;
        if (!this.ventana.verTxtAnio().getText().trim().isBlank())
            anio = Integer.parseInt(this.ventana.verTxtAnio().getText().trim());
        else
            anio = null;
        if (anio == null)            
            mto = new ModeloTablaOrdenes();
        else
            mto = new ModeloTablaOrdenes(anio);
        
        JTable tablaOrdenes = this.ventana.verTablaOrdenes();
        tablaOrdenes.setModel(mto);
        if (mto.getRowCount() > 0)
            tablaOrdenes.setRowSelectionInterval(0, 0);
    }

    @Override
    public void txtAnioPresionarTecla(KeyEvent evt) {
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) { //sólo se aceptan los dígitos del 0-9, Enter, Del y Backspace
            switch(c) {
                case KeyEvent.VK_ENTER: 
                    this.btnBuscarClic(null); //no importa el evento en este caso
                    break;
                case KeyEvent.VK_BACK_SPACE:    
                case KeyEvent.VK_DELETE:
                    break;
                default:
                    evt.consume(); //consume el evento para que no sea procesado por la fuente
            }
        }        
    }    
}

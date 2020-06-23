/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empleados.controladores;

import empleados.modelos.Empleado;
import empleados.modelos.GestorEmpleados;
import empleados.modelos.ModeloTablaEmpleados;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import javax.swing.JTable;
import empleados.vistas.VentanaEmpleados;
import interfaces.IControladorAMEmpleado;
import interfaces.IControladorEmpleados;
import interfaces.IGestorEmpleados;
import javax.swing.JOptionPane;

public class ControladorEmpleados implements IControladorEmpleados {
    private VentanaEmpleados ventana;

    /**
     * Constructor
     * Muestra la ventana de personas de forma modal
     * @param ventanaPadre ventana padre (VentanaPrincipal en este caso)
     */
    public ControladorEmpleados(Frame ventanaPadre) {
        this.ventana = new VentanaEmpleados(this, ventanaPadre);
        this.ventana.setTitle(TITULO);
        this.ventana.setLocationRelativeTo(null);        
        this.ventana.setVisible(true);
    }                           
                         
    @Override
    public void btnNuevoClic(ActionEvent evt) {
        IControladorAMEmpleado controlador = new ControladorAMEmpleado(this.ventana);
    }
                               
                        
    @Override
    public void btnModificarClic(ActionEvent evt) {
        JTable tablaEmpleados = this.ventana.verTablaEmpleados();
        int filaSeleccionada = tablaEmpleados.getSelectedRow(); 
        if (filaSeleccionada != -1) { //hay una fila seleccionada
            ModeloTablaEmpleados modelo = (ModeloTablaEmpleados)tablaEmpleados.getModel();
            Empleado empleado = modelo.verEmpleado(filaSeleccionada);            
            IControladorAMEmpleado controlador = new ControladorAMEmpleado(this.ventana, empleado);
        }
    }
                                                           
    @Override
    public void btnBorrarClic(ActionEvent evt) {
        JTable tablaEmpleados = this.ventana.verTablaEmpleados();
        int filaSeleccionada = tablaEmpleados.getSelectedRow(); 
        if (filaSeleccionada != -1) { //hay una fila seleccionada
            int opcion = JOptionPane.showOptionDialog(null, CONFIRMACION, TITULO, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] {"Sí", "No"}, this);       
            if (opcion == JOptionPane.YES_OPTION) { //se quiere borrar el empleado                
                ModeloTablaEmpleados modelo = (ModeloTablaEmpleados)tablaEmpleados.getModel();
                Empleado empleado = modelo.verEmpleado(filaSeleccionada);                
                IGestorEmpleados ge = GestorEmpleados.instanciar();
                String resultado = ge.borrarEmpleado(empleado.verIdEmpleado());
                if (!resultado.equals(IGestorEmpleados.EXITO_BORRAR)) //no se pudo borrar el empleado
                    JOptionPane.showOptionDialog(null, resultado, TITULO, JOptionPane.ERROR_MESSAGE, JOptionPane.ERROR_MESSAGE, null, new Object[] {"Aceptar"}, this);                       
            }
        }
    }
                                                           
    @Override
    public void btnVolverClic(ActionEvent evt) {
        this.ventana.dispose();
    }
                          
    @Override
    public void btnBuscarClic(ActionEvent evt) {
        ModeloTablaEmpleados mte;
        
        String idEmpleado = this.ventana.verTxtIdentificador().getText().trim();
        if (idEmpleado.isEmpty())            
            mte = new ModeloTablaEmpleados();
        else
            mte = new ModeloTablaEmpleados(idEmpleado);
        this.configurarTabla(mte);        
    }
                                           
    @Override
    public void ventanaObtenerFoco(WindowEvent evt) {
        this.configurarTabla(new ModeloTablaEmpleados()); 
    }    
    
    /**
     * Configura la tabla de empleados asignándole un modelo y seleccionando la primera fila (si hay filas)
     * @param mtp modelo para la tabla de empleados
     */
    private void configurarTabla(ModeloTablaEmpleados mte) {
        JTable tablaEmpleados = this.ventana.verTablaEmpleados();
        tablaEmpleados.setModel(mte);
                
        if (mte.getRowCount() > 0) //si hay filas, se selecciona la primera
            tablaEmpleados.setRowSelectionInterval(0, 0);                           
        this.ventana.verBtnBorrar().setEnabled(mte.getRowCount() > 0);
        this.ventana.verBtnModificar().setEnabled(mte.getRowCount() > 0);  
    }    
    
              
    @Override
    public void txtIDEmpleadoPresionarTecla(KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
            this.btnBuscarClic(null); // no importa el evento
    }
             
}

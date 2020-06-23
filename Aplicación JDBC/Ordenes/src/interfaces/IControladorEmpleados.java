/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

public interface IControladorEmpleados {
    public static final String TITULO = "Empleados";
    public static final String CONFIRMACION = "¿Desea borrar el empleado especificado?";    

        
    /**
     * Acción a ejecutar cuando se selecciona el botón Nuevo
     * @param evt evento
     */                        
    public void btnNuevoClic(ActionEvent evt);    
    
    /**
     * Acción a ejecutar cuando se selecciona el botón Modificar
     * @param evt evento
     */                        
    public void btnModificarClic(ActionEvent evt);
    
    /**
     * Acción a ejecutar cuando se selecciona el botón Borrar 
     * @param evt evento
     */                        
    public void btnBorrarClic(ActionEvent evt);          
    
    /**
     * Acción a ejecutar cuando se selecciona el botón Volver
     * @param evt evento
     */                        
    public void btnVolverClic(ActionEvent evt);    
    
    /**
     * Acción a ejecutar cuando se selecciona el botón Buscar
     * @param evt evento
     */                        
    public void btnBuscarClic(ActionEvent evt);    
        
    /**
     * Acción a ejecutar cuando la ventana obtenga el foco
     * @param evt evento
     */
    public void ventanaObtenerFoco(WindowEvent evt);
    
    /**
     * Acción a ejecutar cuando se presiona una tecla en el campo txtIDEmpleado
     * @param evt evento
     */    
    public void txtIDEmpleadoPresionarTecla(KeyEvent evt);         
}

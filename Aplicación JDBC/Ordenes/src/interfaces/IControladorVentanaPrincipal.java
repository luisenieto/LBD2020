/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;


public interface IControladorVentanaPrincipal {
    public static final String CONFIRMACION = "¿Desea terminar la sesión?";
    public static final String TITULO = "Ordenes";        

    /**
     * Acción a ejecutar cuando se selecciona el botón Empleados
     * @param evt evento
     */                        
    public void btnEmpleadosClic(ActionEvent evt);

    /**
     * Acción a ejecutar cuando se selecciona el botón Ordenes
     * @param evt evento
     */                        
    public void btnOrdenesClic(ActionEvent evt);     
    
    /**
     * Acción a ejecutar cuando se cierra la ventana
     * @param evt evento
     */                            
    public void ventanaAlCerrar(WindowEvent evt);
}

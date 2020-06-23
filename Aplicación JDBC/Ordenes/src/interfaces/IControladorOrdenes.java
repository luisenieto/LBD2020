/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

public interface IControladorOrdenes {
    public static final String TITULO = "Ordenes";

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
     * Acción a ejecutar cuando se presiona una tecla en el campo txtAnio
     * @param evt evento
     */    
    public void txtAnioPresionarTecla(KeyEvent evt);         
}

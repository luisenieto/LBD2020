/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public interface IControladorVentanaLogin {    
        
    /**
     * Acción a ejecutar cuando se selecciona el botón Aceptar
     * @param evt evento
     */                        
    public void btnAceptarClic(ActionEvent evt);

    /**
     * Acción a ejecutar cuando se selecciona el botón Cancelar
     * @param evt evento
     */                        
    public void btnCancelarClic(ActionEvent evt);
    
    /**
     * Acción a ejecutar cuando se presiona una tecla en el campo txtUsuario
     * @param evt evento
     */
    public void txtUsuarioPresionarTecla(KeyEvent evt);  
    
    /**
     * Acción a ejecutar cuando se presiona una tecla en el campo passClave
     * @param evt evento
     */
    public void passClavePresionarTecla(KeyEvent evt); 
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public interface IControladorAMEmpleado {
    public static final String TITULO_NUEVO = "Nuevo empleado"; 
    public static final String TITULO_MODIFICAR = "Modificar empleado"; 
    
    /**
     * Acción a ejecutar cuando se selecciona el botón Abrir
     * @param evt evento
     */                        
    public void btnAbrirClic(ActionEvent evt);
    
    /**
     * Acción a ejecutar cuando se selecciona el botón Guardar
     * @param evt evento
     */                        
    public void btnGuardarClic(ActionEvent evt);

    /**
     * Acción a ejecutar cuando se selecciona el botón Cancelar
     * @param evt evento
     */                        
    public void btnCancelarClic(ActionEvent evt);
    
    /**
     * Acción a ejecutar cuando se presiona una tecla en el campo txtIdentificador
     * @param evt evento
     */
    public void txtIdentificadorPresionarTecla(KeyEvent evt);
    
    /**
     * Acción a ejecutar cuando se presiona una tecla en el campo txtApellidos
     * @param evt evento
     */
    public void txtApellidoPresionarTecla(KeyEvent evt);
    
    /**
     * Acción a ejecutar cuando se presiona una tecla en el campo txtNombres
     * @param evt evento
     */
    public void txtNombrePresionarTecla(KeyEvent evt);
    
    /**
     * Acción a ejecutar cuando se presiona una tecla en el campo txtTitulo
     * @param evt evento
     */
    public void txtTituloPresionarTecla(KeyEvent evt); 
    
    /**
     * Acción a ejecutar cuando se presiona una tecla en el campo txtTituloCortesia
     * @param evt evento
     */
    public void txtTituloCortesiaPresionarTecla(KeyEvent evt); 
    
    /**
     * Acción a ejecutar cuando se presiona una tecla en el campo txtDireccion
     * @param evt evento
     */
    public void txtDireccionPresionarTecla(KeyEvent evt);  
    
    /**
     * Acción a ejecutar cuando se presiona una tecla en el campo txtCiudad
     * @param evt evento
     */
    public void txtCiudadPresionarTecla(KeyEvent evt); 
    
    /**
     * Acción a ejecutar cuando se presiona una tecla en el campo txtRegion
     * @param evt evento
     */
    public void txtRegionPresionarTecla(KeyEvent evt); 
    
    /**
     * Acción a ejecutar cuando se presiona una tecla en el campo txtCodigoPostal
     * @param evt evento
     */
    public void txtCodigoPostalPresionarTecla(KeyEvent evt); 
    
    /**
     * Acción a ejecutar cuando se presiona una tecla en el campo txtPais
     * @param evt evento
     */
    public void txtPaisPresionarTecla(KeyEvent evt); 
    
    /**
     * Acción a ejecutar cuando se presiona una tecla en el campo txtTelefono
     * @param evt evento
     */
    public void txtTelefonoPresionarTecla(KeyEvent evt); 
    
    /**
     * Acción a ejecutar cuando se presiona una tecla en el campo txtExtension
     * @param evt evento
     */
    public void txtExtensionPresionarTecla(KeyEvent evt); 
    
    /**
     * Acción a ejecutar cuando se presiona una tecla en el campo txtFotos
     * @param evt evento
     */
    public void txtFotosPresionarTecla(KeyEvent evt); 
    
    /**
     * Acción a ejecutar cuando se presiona una tecla en el campo txtNotas
     * @param evt evento
     */
    public void txtNotasPresionarTecla(KeyEvent evt); 
}

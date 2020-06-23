/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal.controladores;

import empleados.controladores.ControladorEmpleados;
import interfaces.IControladorEmpleados;
import principal.vistas.VentanaPrincipal;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import conexion.modelos.GestorConexion;
import interfaces.IControladorOrdenes;
import interfaces.IControladorVentanaPrincipal;
import java.awt.event.WindowEvent;
import javax.swing.WindowConstants;
import ordenes.controladores.ControladorOrdenes;
import interfaces.IGestorConexion;
import java.sql.SQLException;

public class ControladorVentanaPrincipal implements IControladorVentanaPrincipal {
    private VentanaPrincipal ventana;

    /**
     * Constructor
     * Muestra la ventana principal
     */
    public ControladorVentanaPrincipal() {        
        this.ventana = new VentanaPrincipal(this);
        this.ventana.setLocationRelativeTo(null);
        this.ventana.setTitle(TITULO);
        this.ventana.setVisible(true);           
    }

    @Override
    public void btnEmpleadosClic(ActionEvent evt) {
        IControladorEmpleados controlador = new ControladorEmpleados(this.ventana);
    }

    @Override
    public void btnOrdenesClic(ActionEvent evt) {
        IControladorOrdenes controlador = new ControladorOrdenes(this.ventana);
    }
                    
    @Override
    public void ventanaAlCerrar(WindowEvent evt) {
        int opcion = JOptionPane.showOptionDialog(null, CONFIRMACION, TITULO, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] {"Sí", "No"}, this);       
        if (opcion == JOptionPane.YES_OPTION) {
            this.ventana.dispose();      
            IGestorConexion gc = GestorConexion.instanciar();
            try {
                gc.cerrarConexion();
            }
            catch(SQLException | NullPointerException e) {
                
            }
        } 
        else
            this.ventana.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
    }        
}

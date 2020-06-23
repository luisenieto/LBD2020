/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal.controladores;

import conexion.modelos.GestorConexion;
import java.sql.DriverManager;
import interfaces.IControladorVentanaLogin;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.Driver;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import principal.vistas.VentanaLogin;
import interfaces.IControladorVentanaPrincipal;
import javax.swing.UIManager;
import interfaces.IGestorConexion;

public class ControladorVentanaLogin implements IControladorVentanaLogin {
    private VentanaLogin ventana;

    /**
     * Constructor
     * Muestra la ventana de login
     */
    public ControladorVentanaLogin() {
        this.ventana = new VentanaLogin(this);
        this.ventana.setTitle(IControladorVentanaPrincipal.TITULO);
        this.ventana.setLocationRelativeTo(null); 
        this.ventana.setVisible(true);
    }

    @Override
    public void btnAceptarClic(ActionEvent evt) {
        if (!this.registrarDriver("com.mysql.jdbc.Driver")) { //método Class.forName()
            JOptionPane.showMessageDialog(null, GestorConexion.ERROR_DRIVER, IControladorVentanaPrincipal.TITULO, JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }        
//        if (!this.registrarDriver()) { //método DriverManager.registerDriver()
//            JOptionPane.showMessageDialog(null, GestorConexiones.ERROR_DRIVER, TITULO, JOptionPane.ERROR_MESSAGE);
//            System.exit(0);
//        } 
        
        String usuario = this.ventana.verTxtUsuario().getText().trim();
        String clave = new String(this.ventana.verPassClave().getPassword());
        
        IGestorConexion gc = GestorConexion.abrirConexion(usuario, clave);
        if (gc != null) {
            IControladorVentanaPrincipal controlador = new ControladorVentanaPrincipal();
        }
        else
            JOptionPane.showOptionDialog(null, IGestorConexion.ABRIR_CONEXION_ERROR, IControladorVentanaPrincipal.TITULO, JOptionPane.ERROR_MESSAGE, JOptionPane.ERROR_MESSAGE, null, new Object[] {"Aceptar"}, this);       
    }
    
    /**
     * Registra el driver empleando el método Class.forName()
     * @param clase cadena con la clase del driver
     * @return boolean  - true si se puede registrar el driver, false en caso contrario
     */
    private boolean registrarDriver(String clase) {
        try {
            Class.forName(clase);
            return true;
        }
        catch(ClassNotFoundException e) {
            return false;
        }
    }
    
    /**
     * Registra el driver empleando el método DriverManager.registerDriver()
     * @return boolean  - true si se puede registrar el driver, false en caso contrario
     */
    private boolean registrarDriver() {
        try {
            Driver driver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(driver);
            return true;
        }
        catch(SQLException e) {
            return false;
        }
    }        

    @Override
    public void btnCancelarClic(ActionEvent evt) {
        this.ventana.dispose();
        System.exit(0);
    }

    @Override
    public void txtUsuarioPresionarTecla(KeyEvent evt) {
        char c = evt.getKeyChar();
        if (c == KeyEvent.VK_ENTER)
            this.btnAceptarClic(null); //no importa el evento en este caso
    }

    @Override
    public void passClavePresionarTecla(KeyEvent evt) {
        if (evt.getKeyChar() == KeyEvent.VK_ENTER)
            this.btnAceptarClic(null); //no importa el evento en este caso
    }
    
    public static void main(String[] args) {
        asignarLookAndFeel("Nimbus");
        IControladorVentanaLogin controlador = new ControladorVentanaLogin();        
    }
    
    /**
     * Asigna el look and feel especificado a la ventana
     * @param laf cadena con el nombre del look and feel
     */
    public static void asignarLookAndFeel(String laf) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if (laf.equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                }
            }
        } catch (Exception e) {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } 
            catch (Exception e2) {
                System.exit(0);
            }
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion.modelos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import interfaces.IGestorConexion;

public class GestorConexion implements IGestorConexion {
    private static GestorConexion gestor = null;
    private Connection connection = null; 
    
    public static final String SERVIDOR = "localhost";
    public static final String PUERTO = "3306";
    public static final String URL = "jdbc:mysql://";
    public static final String BD = "LBD2020";

    /**
     * Constructor
     */
    private GestorConexion(String usuario, String clave) throws SQLException {
        this.connection = DriverManager.getConnection(URL + SERVIDOR + ":" + PUERTO + "/" + BD + "?useSSL=false&allowPublicKeyRetrieval=true", usuario, clave);                 
        //Si no se especifica la opción useSSL=false, aparece una advertencia diciendo
        //que no se recomienda establecer una conexión SSL sin la verificación de identidad del servidor
        //Si no se especifica la opción allowPublicKeyRetrieval=true, aparece una excepción diciendo
        //que no está permitida la recuperación de la clave pública
    }
            
    /**
     * Método estático que permite crear una única instancia de GestorConexiones y abrir una conexión
     * @param usuario usuario a validar
     * @param clave clave del usuario
     * @return GestorConexiones
    */                                                            
    public static GestorConexion abrirConexion(String usuario, String clave) {
        if (gestor == null) {
            try {
                gestor = new GestorConexion(usuario, clave);            
            }
            catch(SQLException e) {
                gestor = null;
            }
        }
        return gestor;
    }
    
    /**
     * Método estático que devuelve una instancia de GestorConexiones (si está abierta la conexión)
     * Si no está abierta la conexión devuelve null
     * @return GestorConexiones
    */                                                            
    public static GestorConexion instanciar() {
        return gestor;       
    }

    @Override
    public Statement createStatement() throws SQLException {
        if (this.connection != null)
            return this.connection.createStatement();
        else
            throw new SQLException();
    }

    @Override
    public PreparedStatement prepareStatement(String cadena) throws SQLException {
        if (this.connection != null)
            return this.connection.prepareStatement(cadena);
        else
            throw new SQLException();
    }

    @Override
    public CallableStatement prepareCall(String cadena) throws SQLException {
        if (this.connection != null)
            return this.connection.prepareCall(cadena);
        else
            throw new SQLException();
    }

    @Override
    public void cerrarConexion() throws SQLException {
        if(this.connection != null) {            
            this.connection.close(); 
            this.connection = null;
            
        }        
    }    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public interface IGestorConexion {
    public static final String ERROR_DRIVER = "No se encontró la clase para el driver de MySQL";
    public static final String ABRIR_CONEXION_ERROR = "Error al abrir la conexión. Revisar: \n* que esté levantado el servicio\n* que sean correctos el usuario y clave especificados"; 
    
    public static final String ERROR_CONEXION = "Se perdió la conexión con el servidor/BD"; 
        
    /**
     * Intenta crear un objeto del tipo Statement
     * @return Statement  - objeto del tipo Statement
     * @throws SQLException si no existe una conexión
     */
    public Statement createStatement() throws SQLException;
    
    /**
     * Intenta crear un objeto del tipo PreparedStatement
     * @param cadena cadena con la consulta para crear el objeto 
     * @return PreparedStatement  - objeto del tipo PreparedStatement
     * @throws SQLException si no existe una conexión
     */    
    public PreparedStatement prepareStatement(String cadena) throws SQLException;
    
    /**
     * Intenta crear un objeto del tipo CallableStatement
     * @param cadena cadena con la consulta para crear el objeto 
     * @return CallableStatement  - objeto del tipo CallableStatement
     * @throws SQLException si no existe una conexión
     */        
    public CallableStatement prepareCall(String cadena) throws SQLException;
    
    /**
     * Cierra la conexión
     * @throws SQLException
     */
    public abstract void cerrarConexion() throws SQLException;
}

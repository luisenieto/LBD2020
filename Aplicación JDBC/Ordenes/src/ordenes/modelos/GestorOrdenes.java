/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordenes.modelos;

import clientes.modelos.Cliente;
import java.sql.CallableStatement;
import conexion.modelos.GestorConexion;
import empleados.modelos.Empleado;
import interfaces.IGestorOrdenes;
import java.util.List;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import interfaces.IGestorConexion;

public class GestorOrdenes implements IGestorOrdenes {
    private static GestorOrdenes gestor;

    /**
     * Constructor
     */
    private GestorOrdenes() {
    }    
    
    /**
     * Método estático que permite crear una única instancia de GestorOrdenes
     * @return GestorOrdenes
    */                                                            
    public static GestorOrdenes instanciar() {
        if (gestor == null) 
            gestor = new GestorOrdenes();            
        return gestor;
    }

    @Override
    public List<Orden> verOrdenes() {
        List<Orden> ordenes = new ArrayList<>();
        IGestorConexion gc = GestorConexion.instanciar();
        try {
            String cadena = "{CALL VerOrdenes()}";
            CallableStatement stmt = gc.prepareCall(cadena);                
            ResultSet rs = stmt.executeQuery();
            return this.leerResultSet(rs);
        }
        catch(SQLException | NullPointerException e) {
            return ordenes;  
        }              
    }
    
    /**
     * Recorre el ResultSet especificado y devuelve una lista con todas las órdenes
     * @param rs ResultSet
     * @return List<Orden>  - lista de órdenes
     */
    private List<Orden> leerResultSet(ResultSet rs) {
        List<Orden> ordenes = new ArrayList<>();
        try {
            while (rs.next()) {
                Integer idOrden = rs.getInt("IDOrden");
                
                String idCliente = rs.getString("IDCliente");
                String compania = rs.getString("Compania");
                String nombreCliente = rs.getString("NombreCliente");
                Cliente cliente = new Cliente(idCliente, compania, nombreCliente);
                
                Integer idEmpleado = rs.getInt("IDEmpleado");
                String apellido = rs.getString("Apellido");
                String nombre = rs.getString("NombreEmpleado");          
                Empleado empleado = new Empleado(idEmpleado, apellido, nombre);
                
                LocalDate fecha = null;
                if (rs.getDate("Fecha") != null)
                    fecha = Instant.ofEpochMilli(rs.getDate("Fecha").getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
                LocalDate fechaRequerida = null;
                if (rs.getDate("FechaRequerida") != null)
                    fechaRequerida = Instant.ofEpochMilli(rs.getDate("FechaRequerida").getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
                LocalDate fechaEnviada = null;
                if (rs.getDate("FechaEnviada") != null)
                    fechaEnviada = Instant.ofEpochMilli(rs.getDate("FechaEnviada").getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
                Integer enviadoPor = rs.getInt("EnviadoPor");
                if (rs.wasNull())
                    enviadoPor = null;
                Float carga = rs.getFloat("Carga");
                if (rs.wasNull())
                    carga = null;
                String nombreDespachante = rs.getString("NombreDespachante");
                String direccionDespachante = rs.getString("DireccionDespachante");
                String ciudadDespachante = rs.getString("CiudadDespachante");
                String regionDespachante = rs.getString("RegionDespachante");
                String codigoPostalDespachante = rs.getString("CodigoPostalDespachante");
                String paisDespachante = rs.getString("PaisDespachante");
                
                Orden orden = new Orden(idOrden, cliente, empleado, fecha, fechaRequerida, fechaEnviada, enviadoPor, carga, nombreDespachante, direccionDespachante, ciudadDespachante, regionDespachante, codigoPostalDespachante, paisDespachante);
                ordenes.add(orden);
            }
            rs.close();  
        }
        catch(SQLException e) {
                
        }
        return ordenes;
    }

    @Override
    public List<Orden> buscarOrdenes(Integer anio) {
        List<Orden> ordenes = new ArrayList<>();
        IGestorConexion gc = GestorConexion.instanciar();        
        try {
            String cadena = "{CALL BuscarOrdenes(?)}";
            CallableStatement stmt = gc.prepareCall(cadena);                
            if (anio != null)
                stmt.setInt(1, anio);
            else
                stmt.setObject(1, anio);
            ResultSet rs = stmt.executeQuery();
            return this.leerResultSet(rs);
        }
        catch(SQLException | NullPointerException e) {
            return ordenes;   
        }             
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empleados.modelos;

import interfaces.IGestorEmpleados;
import java.sql.CallableStatement;
import java.util.List;
import java.util.ArrayList;
import conexion.modelos.GestorConexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import interfaces.IGestorConexion;


public class GestorEmpleados implements IGestorEmpleados { 
    private static GestorEmpleados gestor;

    /**
     * Constructor
     */
    private GestorEmpleados() {
    }    
    
    /**
     * Método estático que permite crear una única instancia de GestorEmpleados
     * @return GestorEmpleados
    */                                                            
    public static GestorEmpleados instanciar() {
        if (gestor == null) 
            gestor = new GestorEmpleados();            
        return gestor;
    }
        
    @Override
    public List<Empleado> verEmpleados() {
//        return this.verEmpleados_Statement();
//        return this.verEmpleados_PreparedStatement();
        return this.verEmpleados_CallableStatement();
    }
    
    /**
     * Obtiene una lista con todos los empleados ordenados por apellido y nombre
     * Para obtener esta lista emplea un objeto del tipo Statement
     * @return List<Empleado>  - lista con todos los empleados ordenados por apellido y nombre
     */
    private List<Empleado> verEmpleados_Statement() {
        List<Empleado> empleados = new ArrayList<>();
        IGestorConexion gc = GestorConexion.instanciar();
        try {
            Statement stmt = gc.createStatement();
            String cadena = "SELECT IDEmpleado, Apellido, Nombre, Titulo, TituloDeCortesia, ";
            cadena += "FechaNacimiento, FechaContratacion, Direccion, Ciudad, Region, CodigoPostal, ";
            cadena += "Pais, Telefono, Extension, Notas, ReportaA, Foto ";
            cadena += "FROM Empleados ";
            cadena += "ORDER BY 2, 3;";
            ResultSet rs = stmt.executeQuery(cadena);
            return this.leerResultSet(rs);
        }
        catch(SQLException | NullPointerException e) {
            return new ArrayList<>();
        }
    }
    
    /**
     * Obtiene una lista con todos los empleados ordenados por apellido y nombre
     * Para obtener esta lista emplea un objeto del tipo PreparedStatement 
     * @return List<Empleado>  - lista con todos los empleados ordenados por apellido y nombre
     */    
    private List<Empleado> verEmpleados_PreparedStatement() {
        List<Empleado> empleados = new ArrayList<>();
        IGestorConexion gc = GestorConexion.instanciar();
        try {
            String cadena = "SELECT IDEmpleado, Apellido, Nombre, Titulo, TituloDeCortesia, ";
            cadena += "FechaNacimiento, FechaContratacion, Direccion, Ciudad, Region, CodigoPostal, ";
            cadena += "Pais, Telefono, Extension, Notas, ReportaA, Foto ";
            cadena += "FROM Empleados ";
            cadena += "ORDER BY 2, 3;";
            PreparedStatement stmt = gc.prepareStatement(cadena);                
            ResultSet rs = stmt.executeQuery(cadena);
            return this.leerResultSet(rs);
        }
        catch(SQLException | NullPointerException e) {
            return new ArrayList<>();
        }
    }    
    
    /**
     * Obtiene una lista con todos los empleados ordenados por apellido y nombre
     * Para obtener esta lista emplea un objeto del tipo CallableStatement (sin llamar a un procedimiento almacenado)
     * @return List<Empleado>  - lista con todos los empleados ordenados por apellido y nombre
     */        
    private List<Empleado> verEmpleados_CallableStatement() {
        List<Empleado> empleados = new ArrayList<>();
        IGestorConexion gc = GestorConexion.instanciar();
        try {
            String cadena = "SELECT IDEmpleado, Apellido, Nombre, Titulo, TituloDeCortesia, ";
            cadena += "FechaNacimiento, FechaContratacion, Direccion, Ciudad, Region, CodigoPostal, ";
            cadena += "Pais, Telefono, Extension, Notas, ReportaA, Foto ";
            cadena += "FROM Empleados ";
            cadena += "ORDER BY 2, 3;";
            CallableStatement stmt = gc.prepareCall(cadena);                
            ResultSet rs = stmt.executeQuery(cadena);
            return this.leerResultSet(rs);
        }
        catch(SQLException | NullPointerException e) {
            return new ArrayList<>();
        }
    }        
    
    /**
     * Recorre el ResultSet especificado y devuelve una lista con los empleados del mismo
     * @param rs ResultSet
     * @return List<Empleado>  - lista de empleados
     */
    private List<Empleado> leerResultSet(ResultSet rs) {
        List<Empleado> empleados = new ArrayList<>();
        try {
            while (rs.next()) {
                Integer idEmpleado = rs.getInt("IDEmpleado");
                String apellido = rs.getString("Apellido");
                String nombre = rs.getString("Nombre");
                String titulo = rs.getString("Titulo");
                String tituloDeCortesia = rs.getString("TituloDeCortesia");
                LocalDate fechaNacimiento = null;
                if (rs.getDate("FechaNacimiento") != null)
                    fechaNacimiento = Instant.ofEpochMilli(rs.getDate("FechaNacimiento").getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
                LocalDate fechaContratacion = null;
                if (rs.getDate("FechaContratacion") != null)
                    fechaContratacion = Instant.ofEpochMilli(rs.getDate("FechaContratacion").getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
                String direccion = rs.getString("Direccion");
                String ciudad = rs.getString("Ciudad");
                String region = rs.getString("Region");
                String codigoPostal = rs.getString("CodigoPostal");
                String pais = rs.getString("Pais");
                String telefono = rs.getString("Telefono");
                String extension = rs.getString("Extension");
                String notas = rs.getString("Notas");
                Integer reportaA = rs.getInt("ReportaA");
                if (rs.wasNull())
                    reportaA = null;
                String foto = rs.getString("Foto");
                Empleado empleado = new Empleado(idEmpleado, apellido, nombre, titulo, tituloDeCortesia, fechaNacimiento, fechaContratacion, direccion, ciudad, region, codigoPostal, pais, telefono, extension, notas, reportaA, foto);
                empleados.add(empleado);
            }
            rs.close();  
        }
        catch(SQLException e) {            
        }
        return empleados;
    }

    @Override
    public Empleado buscarEmpleado(String idEmpleado) {
//        return this.buscarEmpleado_Statement(idEmpleado);
//        return this.buscarEmpleado_PreparedStatement(idEmpleado);
        return this.buscarEmpleado_CallableStatement(idEmpleado);
    }
    
    /**
     * Busca el empleado correspondiente al identificador especificado
     * Para buscar el empleado emplea un objeto del tipo Statement (problemas de SQL Injection)
     * Si no encuentra un empleado, devuelve null
     * @param idEmpleado identificador del empleado
     * @return Empleado  - objeto Empleado correspondiente al identificador especificado
     */
    private Empleado buscarEmpleado_Statement(String idEmpleado) {
        IGestorConexion gc = GestorConexion.instanciar();
        try {
            Statement stmt = gc.createStatement();
            String cadena = "SELECT IDEmpleado, Apellido, Nombre, Titulo, TituloDeCortesia, ";
            cadena += "FechaNacimiento, FechaContratacion, Direccion, Ciudad, Region, CodigoPostal, ";
            cadena += "Pais, Telefono, Extension, Notas, ReportaA, Foto ";
            cadena += "FROM Empleados ";
            cadena += "WHERE IDEmpleado = " + idEmpleado;
            ResultSet rs = stmt.executeQuery(cadena);
            return this.armarEmpleado(rs);
        }
        catch(SQLException | NullPointerException e) {
            return null;
        }
    }
    
    /**
     * Busca el empleado correspondiente al identificador especificado
     * Para buscar el empleado emplea un objeto del tipo PreparedStatement (emplea consultas parametrizadas y resuelve problemas de SQL Injection)
     * Si no encuentra un empleado, devuelve null
     * @param idEmpleado identificador del empleado
     * @return Empleado  - objeto Empleado correspondiente al identificador especificado
     */    
    private Empleado buscarEmpleado_PreparedStatement(String idEmpleado) {
        IGestorConexion gc = GestorConexion.instanciar();
        try {
            String cadena = "SELECT IDEmpleado, Apellido, Nombre, Titulo, TituloDeCortesia, ";
            cadena += "FechaNacimiento, FechaContratacion, Direccion, Ciudad, Region, CodigoPostal, ";
            cadena += "Pais, Telefono, Extension, Notas, ReportaA, Foto ";
            cadena += "FROM Empleados ";
            cadena += "WHERE IDEmpleado = ?";

            PreparedStatement prepstmt = gc.prepareStatement(cadena);
            prepstmt.setString(1, idEmpleado);

            ResultSet rs = prepstmt.executeQuery();
            return this.armarEmpleado(rs);
        }
        catch(SQLException | NullPointerException e) {
            return null;
        }
    }
    
    /**
     * Busca el empleado correspondiente al identificador especificado
     * Para buscar el empleado emplea un objeto del tipo CallableStatement (emplea procedimientos almacenados y resuelve problemas de SQL Injection)
     * Si no encuentra un empleado, devuelve null
     * @param idEmpleado identificador del empleado
     * @return Empleado  - objeto Empleado correspondiente al identificador especificado
     */    
    private Empleado buscarEmpleado_CallableStatement(String idEmpleado) {
        IGestorConexion gc = GestorConexion.instanciar();
        try {
            String cadena = "{CALL BuscarEmpleado(?)}";

            CallableStatement calstmt = gc.prepareCall(cadena);
            calstmt.setString(1, idEmpleado);

            ResultSet rs = calstmt.executeQuery();
            return this.armarEmpleado(rs);
        }
        catch(SQLException | NullPointerException e) {
            return null;
        }
    }    
    
    /**
     * Recorre el ResultSet especificado y devuelve el empleado con los datos del mismo
     * @param rs ResultSet
     * @return Empleado  - objeto Empleado
     */
    private Empleado armarEmpleado(ResultSet rs) {
        Empleado empleado = null;
        try {
            while (rs.next()) { //sólo debería haber una sola fila, o ninguna
                Integer idEmpleado = rs.getInt("IDEmpleado");
                String apellido = rs.getString("Apellido");
                String nombre = rs.getString("Nombre");
                String titulo = rs.getString("Titulo");
                String tituloDeCortesia = rs.getString("TituloDeCortesia");
                LocalDate fechaNacimiento = null;
                if (rs.getDate("FechaNacimiento") != null)
                    fechaNacimiento = Instant.ofEpochMilli(rs.getDate("FechaNacimiento").getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
                LocalDate fechaContratacion = null;
                if (rs.getDate("FechaContratacion") != null)
                    fechaNacimiento = Instant.ofEpochMilli(rs.getDate("FechaContratacion").getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
                String direccion = rs.getString("Direccion");
                String ciudad = rs.getString("Ciudad");
                String region = rs.getString("Region");
                String codigoPostal = rs.getString("CodigoPostal");
                String pais = rs.getString("Pais");
                String telefono = rs.getString("Telefono");
                String extension = rs.getString("Extension");
                String notas = rs.getString("Notas");
                Integer reportaA = rs.getInt("ReportaA");
                String foto = rs.getString("Foto");
                empleado = new Empleado(idEmpleado, apellido, nombre, titulo, tituloDeCortesia, fechaNacimiento, fechaContratacion, direccion, ciudad, region, codigoPostal, pais, telefono, extension, notas, reportaA, foto);
            }
            rs.close();  
        }
        catch(SQLException e) {
                
        }
        return empleado;
    }    

    @Override
    public String borrarEmpleado(int idEmpleado) {
        IGestorConexion gc = GestorConexion.instanciar();
        try {
            String cadena = "{CALL BorrarEmpleado(?, ?)}";

            CallableStatement calstmt = gc.prepareCall(cadena);
            calstmt.setInt(1, idEmpleado);
            calstmt.registerOutParameter(2, java.sql.Types.VARCHAR);        
            calstmt.executeUpdate();
            return calstmt.getString(2);
        }
        catch(SQLException | NullPointerException e) {
            return GestorConexion.ERROR_CONEXION;
        }
    }

    @Override
    public String nuevoEmpleado(Integer idEmpleado, String apellido, String nombre, String titulo, String tituloDeCortesia, LocalDate fechaNacimiento, LocalDate fechaContratacion, String direccion, String ciudad, String region, String codigoPostal, String pais, String telefono, String extension, String notas, Integer reportaA, String foto) {
        IGestorConexion gc = GestorConexion.instanciar();
        try {
            String cadena = "{CALL NuevoEmpleado(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";

            CallableStatement calstmt = gc.prepareCall(cadena);
            if (idEmpleado != null)
                calstmt.setInt(1, idEmpleado);
            else
                calstmt.setObject(1, idEmpleado);
            calstmt.setString(2, apellido);
            calstmt.setString(3, nombre);
            calstmt.setString(4, titulo);
            calstmt.setString(5, tituloDeCortesia);  
            if (fechaNacimiento != null) 
                calstmt.setDate(6, java.sql.Date.valueOf(fechaNacimiento));
            else
                calstmt.setDate(6, null);
            if (fechaContratacion != null)
                calstmt.setDate(7, java.sql.Date.valueOf(fechaContratacion));
            else
                calstmt.setDate(7, null);
            calstmt.setString(8, direccion);
            calstmt.setString(9, ciudad);
            calstmt.setString(10, region);
            calstmt.setString(11, codigoPostal);
            calstmt.setString(12, pais);
            calstmt.setString(13, telefono);
            calstmt.setString(14, extension);
            calstmt.setString(15, notas);
            if (reportaA != null)
                calstmt.setInt(16, reportaA);
            else
                calstmt.setObject(16, reportaA);
            calstmt.setString(17, foto);

            calstmt.registerOutParameter(18, java.sql.Types.VARCHAR);        
            calstmt.executeUpdate();
            return calstmt.getString(18);
        }
        catch(SQLException | NullPointerException e) {
            return GestorConexion.ERROR_CONEXION;
        }
    }

    @Override
    public String modificarEmpleado(Integer idEmpleado, String apellido, String nombre, String titulo, String tituloDeCortesia, LocalDate fechaNacimiento, LocalDate fechaContratacion, String direccion, String ciudad, String region, String codigoPostal, String pais, String telefono, String extension, String notas, Integer reportaA, String foto) {
        IGestorConexion gc = GestorConexion.instanciar();
        try {
            String cadena = "{CALL ModificarEmpleado(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";

            CallableStatement calstmt = gc.prepareCall(cadena);
            if (idEmpleado != null)
                calstmt.setInt(1, idEmpleado);
            else
                calstmt.setObject(1, idEmpleado);
            calstmt.setString(2, apellido);
            calstmt.setString(3, nombre);
            calstmt.setString(4, titulo);
            calstmt.setString(5, tituloDeCortesia);  
            if (fechaNacimiento != null) 
                calstmt.setDate(6, java.sql.Date.valueOf(fechaNacimiento));
            else
                calstmt.setDate(6, null);
            if (fechaContratacion != null)
                calstmt.setDate(7, java.sql.Date.valueOf(fechaContratacion));
            else
                calstmt.setDate(7, null);
            calstmt.setString(8, direccion);
            calstmt.setString(9, ciudad);
            calstmt.setString(10, region);
            calstmt.setString(11, codigoPostal);
            calstmt.setString(12, pais);
            calstmt.setString(13, telefono);
            calstmt.setString(14, extension);
            calstmt.setString(15, notas);
            if (reportaA != null)
                calstmt.setInt(16, reportaA);
            else
                calstmt.setObject(16, reportaA);
            calstmt.setString(17, foto);

            calstmt.registerOutParameter(18, java.sql.Types.VARCHAR);        
            calstmt.executeUpdate();
            return calstmt.getString(18);
        }
        catch(SQLException | NullPointerException e) {
            return GestorConexion.ERROR_CONEXION;
        }
    }
}

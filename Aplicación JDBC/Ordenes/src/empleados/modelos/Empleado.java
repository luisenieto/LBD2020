/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empleados.modelos;

import java.time.LocalDate;

public class Empleado {
    private int idEmpleado;
    private String apellido;
    private String nombre;
    private String titulo;
    private String tituloDeCortesia;
    private LocalDate fechaNacimiento;
    private LocalDate fechaContratacion;
    private String direccion;
    private String ciudad;
    private String region;
    private String codigoPostal;
    private String pais;
    private String telefono;
    private String extension;
    private String notas;
    private Integer reportaA;
    private String foto;

    /**
     * Constructor
     * @param idEmpleado identificador del empleado
     * @param apellido apellido del empleado
     * @param nombre nombre del empleado
     * @param titulo título del empleado
     * @param tituloDeCortesia título de cortesía del empleado
     * @param fechaNacimiento fecha de nacimiento del empleado
     * @param fechaContratacion fecha de contratación del empleado
     * @param direccion dirección del empleado
     * @param ciudad ciudad del empleado
     * @param region región del empleado
     * @param codigoPostal código postal del empleado
     * @param pais país del empleado
     * @param telefono teléfono del empleado
     * @param extension extensión del empleado
     * @param notas notas del empleado
     * @param reportaA a quién reporta el empleado (su jefe)
     * @param foto foto cadena con la ruta de la foto del empleado
     */
    public Empleado(int idEmpleado, String apellido, String nombre, String titulo, String tituloDeCortesia, LocalDate fechaNacimiento, LocalDate fechaContratacion, String direccion, String ciudad, String region, String codigoPostal, String pais, String telefono, String extension, String notas, Integer reportaA, String foto) {
        this.idEmpleado = idEmpleado;
        this.apellido = apellido;
        this.nombre = nombre;
        this.titulo = titulo;
        this.tituloDeCortesia = tituloDeCortesia;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaContratacion = fechaContratacion;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.region = region;
        this.codigoPostal = codigoPostal;
        this.pais = pais;
        this.telefono = telefono;
        this.extension = extension;
        this.notas = notas;
        this.reportaA = reportaA;
        this.foto = foto;
    }
    
    /**
     * Constructor (sirve para los combos, donde sólo hacen falta el apellido y nombre del empleado)
     * @param idEmpleado
     * @param apellido
     * @param nombre 
     */
    public Empleado (int idEmpleado, String apellido, String nombre) {
        this(idEmpleado, apellido, nombre, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
    }

    /**
     * Devuelve el identificador del empleado
     * @return int  - entero con el identificador del empleado
     */        
    public int verIdEmpleado() {
        return this.idEmpleado;
    }

    /**
     * Devuelve el apellido del empleado
     * @return String  - cadena con el apellido del empleado
     */    
    public String verApellido() {
        return this.apellido;
    }

    /**
     * Devuelve el nombre del empleado
     * @return String  - cadena con el nombre del empleado
     */    
    public String verNombre() {
        return this.nombre;
    }

    /**
     * Devuelve el título del empleado
     * @return String  - cadena con el título del empleado
     */    
    public String verTitulo() {
        return this.titulo;
    }

    /**
     * Devuelve el título de cortesía del empleado
     * @return String  - cadena con el título de cortesía del empleado
     */    
    public String verTituloDeCortesia() {
        return this.tituloDeCortesia;
    }

    /**
     * Devuelve la fecha de nacimiento del empleado
     * @return LocalDate  - fecha de nacimiento del empleado
     */    
    public LocalDate verFechaNacimiento() {
        return this.fechaNacimiento;
    }

    /**
     * Devuelve la fecha de contratación del empleado
     * @return LocalDate  - fecha de contratación del empleado
     */    
    public LocalDate verFechaContratacion() {
        return this.fechaContratacion;
    }

    /**
     * Devuelve la dirección del empleado
     * @return String  - cadena con la dirección del empleado
     */    
    public String verDireccion() {
        return this.direccion;
    }

    /**
     * Devuelve la ciudad del empleado
     * @return String  - cadena con la ciudad del empleado
     */    
    public String verCiudad() {
        return this.ciudad;
    }

    /**
     * Devuelve la región del empleado
     * @return String  - cadena con la región del empleado
     */    
    public String verRegion() {
        return this.region;
    }

    /**
     * Devuelve el código postal del empleado
     * @return String  - cadena con el código postal del empleado
     */    
    public String verCodigoPostal() {
        return this.codigoPostal;
    }

    /**
     * Devuelve el país del empleado
     * @return String  - cadena con el país del empleado
     */    
    public String verPais() {
        return this.pais;
    }

    /**
     * Devuelve el teléfono del empleado
     * @return String  - cadena con el teléfono del empleado
     */    
    public String verTelefono() {
        return this.telefono;
    }

    /**
     * Devuelve la extensión del empleado
     * @return String  - cadena con la extensión del empleado
     */    
    public String verExtension() {
        return this.extension;
    }

    /**
     * Devuelve las notas del empleado
     * @return String  - cadena con las notas del empleado
     */    
    public String verNotas() {
        return this.notas;
    }

    /**
     * Devuelve el identificador del empleado a quien reporta este (el jefe)
     * @return Integer  - identificador del empleado a quien reporta este (el jefe)
     */    
    public Integer verReportaA() {
        return this.reportaA;
    }

    /**
     * Devuelve la cadena con la ruta de la foto del empleado
     * @return String  - cadena con la ruta de la foto del empleado
     */    
    public String verFoto() {
        return this.foto;
    }    

    /**
     * Devuelve la transformación de un objeto Empleado en cadena (se usa en los combos)
     * @return String  - cadena con la representación de un empleado
     */    
    @Override
    public String toString() {
        return this.apellido + ", " + this.nombre;
    }
   
}

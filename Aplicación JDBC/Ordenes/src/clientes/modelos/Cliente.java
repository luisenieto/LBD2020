/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientes.modelos;

public class Cliente {
    private String idCliente;
    private String compania;
    private String nombre;
    private String titulo;
    private String direccion;
    private String ciudad;
    private String region;
    private String codigoPostal;
    private String pais;
    private String telefono;
    private String fax;

    /**
     * Constructor
     * @param idCliente identificador del cliente
     * @param compania compañía del cliente
     * @param nombre nombre del cliente
     * @param titulo título del cliente
     * @param direccion dirección del cliente
     * @param ciudad ciudad del cliente
     * @param region región del cliente
     * @param codigoPostal código postal del cliente
     * @param pais país del cliente
     * @param telefono teléfono del cliente
     * @param fax fax del cliente
     */
    public Cliente(String idCliente, String compania, String nombre, String titulo, String direccion, String ciudad, String region, String codigoPostal, String pais, String telefono, String fax) {
        this.idCliente = idCliente;
        this.compania = compania;
        this.nombre = nombre;
        this.titulo = titulo;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.region = region;
        this.codigoPostal = codigoPostal;
        this.pais = pais;
        this.telefono = telefono;
        this.fax = fax;
    }
    
    /**
     * Constructor (sirve para los combos, donde sólo hacen falta la compañía y el nombre del cliente)
     * @param idCliente
     * @param compania
     * @param nombre 
     */
    public Cliente(String idCliente, String compania, String nombre) {
        this(idCliente, compania, nombre, null, null, null, null, null, null, null, null);
    }

    /**
     * Devuelve el identificador del cliente
     * @return String  - cadena con el identificador del cliente
     */
    public String verIdCliente() {
        return this.idCliente;
    }

    /**
     * Devuelve el identificador del cliente
     * @return String  - cadena con el identificador del cliente
     */
    public String verCompania() {
        return this.compania;
    }

    /**
     * Devuelve el identificador del cliente
     * @return String  - cadena con el identificador del cliente
     */    
    public String verNombre() {
        return nombre;
    }

    /**
     * Devuelve el título del cliente
     * @return String  - cadena con el título del cliente
     */    
    public String verTitulo() {
        return this.titulo;
    }

    /**
     * Devuelve la dirección del cliente
     * @return String  - cadena con la dirección del cliente
     */    
    public String verDireccion() {
        return this.direccion;
    }

    /**
     * Devuelve la ciudad del cliente
     * @return String  - cadena con la ciudad del cliente
     */    
    public String verCiudad() {
        return this.ciudad;
    }

    /**
     * Devuelve la región del cliente
     * @return String  - cadena con la región del cliente
     */    
    public String verRegion() {
        return this.region;
    }

    /**
     * Devuelve el código postal del cliente
     * @return String  - cadena con el código postal del cliente
     */    
    public String verCodigoPostal() {
        return this.codigoPostal;
    }

    /**
     * Devuelve el país del cliente
     * @return String  - cadena con el país del cliente
     */    
    public String verPais() {
        return this.pais;
    }

    /**
     * Devuelve el teléfono del cliente
     * @return String  - cadena con el teléfono del cliente
     */    
    public String getTelefono() {
        return this.telefono;
    }

    /**
     * Devuelve el fax del cliente
     * @return String  - cadena con el fax del cliente
     */    
    public String getFax() {
        return this.fax;
    }

    /**
     * Devuelve la transformación de un objeto Cliente en cadena (se usa en los combos)
     * @return String  - cadena con la representación de un cliente
     */
    @Override
    public String toString() {
        return this.compania + " (" + this.nombre + ")";
    }        
}

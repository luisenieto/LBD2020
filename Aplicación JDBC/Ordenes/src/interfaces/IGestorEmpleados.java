/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import empleados.modelos.Empleado;
import java.time.LocalDate;
import java.util.List;

public interface IGestorEmpleados {
    public static final String EXITO_BORRAR = "Empleado borrado con éxito";
    public static final String EXITO_CREAR = "Empleado creado con éxito";
    public static final String EXITO_MODIFICAR = "Empleado modificado con éxito";
    
    /**
     * Debuelve todos los empleados ordenados por apellido y nombre
     * @return List<Empleado>  - lista de empleados ordenada por apellido y nombre
     */
    public List<Empleado> verEmpleados();
    
    /**
     * Busca si existe un empleado con el idEmpleado especificado 
     * @param idEmpleado idEmpleado del empleado
     * @return Empleado  - empleado correspondiente al idEmpleado especificado, o null si no existe
    */
    public Empleado buscarEmpleado(String idEmpleado);
    
    /**
     * Borra el empleado especificado siempre y cuando exista y se pueda
     * No se puede borrar un empleado si el mismo tiene órdenes
     * @param idEmpleado idEmpleado del empleado
     * @return String  - cadena con el resultado de la operación
    */
    public String borrarEmpleado(int idEmpleado);
    
    /**
     * Crear un nuevo empleado siempre y cuando no exista otro con el mismo identificador y se pueda
     * Un empleado debe tener apellido y nombre
     * Puede no reportar a nadie (ser jefe) o a otro empleado
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
     * @param extension extensión del teléfono del empleado
     * @param notas notas del empleado
     * @param reportaA identificador del empleado a quien se reporta
     * @param foto ruta con la foto del empleado
     * @return String  - cadena con el resultado de la operación
     */
    public String nuevoEmpleado(Integer idEmpleado, String apellido, String nombre, String titulo, String tituloDeCortesia, LocalDate fechaNacimiento, LocalDate fechaContratacion, String direccion, String ciudad, String region, String codigoPostal, String pais, String telefono, String extension, String notas, Integer reportaA, String foto);
    
    /**
     * Modifica un empleado siempre y cuando exista y se pueda
     * Un empleado debe tener apellido y nombre
     * Puede no reportar a nadie (ser jefe) o a otro empleado
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
     * @param extension extensión del teléfono del empleado
     * @param notas notas del empleado
     * @param reportaA identificador del empleado a quien se reporta
     * @param foto ruta con la foto del empleado
     * @return String  - cadena con el resultado de la operación
     */
    public String modificarEmpleado(Integer idEmpleado, String apellido, String nombre, String titulo, String tituloDeCortesia, LocalDate fechaNacimiento, LocalDate fechaContratacion, String direccion, String ciudad, String region, String codigoPostal, String pais, String telefono, String extension, String notas, Integer reportaA, String foto);
}

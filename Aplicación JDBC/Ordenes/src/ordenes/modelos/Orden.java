/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordenes.modelos;

import clientes.modelos.Cliente;
import conexion.modelos.GestorConexion;
import empleados.modelos.Empleado;
import items.modelos.Detalle;
import items.modelos.Item;
import java.time.LocalDate;
import java.util.List;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import interfaces.IGestorConexion;

public class Orden {
    private int idOrden;
    private Cliente cliente;
    private Empleado empleado;
    private LocalDate fecha;
    private LocalDate fechaRequerida;
    private LocalDate fechaEnviada;
    private int enviadoPor;
    private float carga;
    private String nombreDespachante;
    private String direccionDespachante;
    private String ciudadDespachante;
    private String regionDespachante;
    private String codigoPostalDespachante;
    private String paisDespachante;

    /**
     * Constructor
     * @param idOrden identificador de la orden
     * @param cliente cliente a quien está hecha la orden
     * @param empleado empleado que hizo la orden
     * @param fecha fecha en que se hizo la orden
     * @param fechaRequerida fecha requerida para entregar la orden
     * @param fechaEnviada fecha en la que se envió la orden
     * @param enviadoPor identificador de la persona que envió la orden
     * @param carga peso 
     * @param nombreDespachante nombre del despachante
     * @param direccionDespachante dirección del despachante
     * @param ciudadDespachante ciudad del despachante
     * @param regionDespachante región del despachante
     * @param codigoPostalDespachante código postal del despachante
     * @param paisDespachante país del despachante
     */
    public Orden(int idOrden, Cliente cliente, Empleado empleado, LocalDate fecha, LocalDate fechaRequerida, LocalDate fechaEnviada, int enviadoPor, float carga, String nombreDespachante, String direccionDespachante, String ciudadDespachante, String regionDespachante, String codigoPostalDespachante, String paisDespachante) {
        this.idOrden = idOrden;
        this.cliente = cliente;
        this.empleado = empleado;
        this.fecha = fecha;
        this.fechaRequerida = fechaRequerida;
        this.fechaEnviada = fechaEnviada;
        this.enviadoPor = enviadoPor;
        this.carga = carga;
        this.nombreDespachante = nombreDespachante;
        this.direccionDespachante = direccionDespachante;
        this.ciudadDespachante = ciudadDespachante;
        this.regionDespachante = regionDespachante;
        this.codigoPostalDespachante = codigoPostalDespachante;
        this.paisDespachante = paisDespachante;
    }

    /**
     * Devuelve el identificador de la orden
     * @return int  - identificador de la orden
     */
    public int verIdOrden() {
        return this.idOrden;
    }

    /**
     * Devuelve el cliente de la orden
     * @return Cliente  - cliente de la orden
     */
    public Cliente verCliente() {
        return this.cliente;
    }

    /**
     * Devuelve el empleado de la orden
     * @return Empleado  - empleado de la orden
     */    
    public Empleado verEmpleado() {
        return this.empleado;
    }

    /**
     * Devuelve la fecha de la orden
     * @return LocalDate  - fecha de la orden
     */
    public LocalDate verFecha() {
        return this.fecha;
    }

    /**
     * Devuelve la fecha en que se requiere la orden
     * @return LocalDate  - fecha en que se requiere la orden
     */
    public LocalDate verFechaRequerida() {
        return this.fechaRequerida;
    }

    /**
     * Devuelve la fecha en que se envió la orden
     * @return LocalDate  - fecha en que se envió la orden
     */
    public LocalDate verFechaEnviada() {
        return this.fechaEnviada;
    }

    /**
     * Devuelve el identificador de quien envió la orden
     * @return int  - identificador de quien envió la orden
     */
    public int verEnviadoPor() {
        return this.enviadoPor;
    }

    /**
     * Devuelve el peso de la orden
     * @return float  - peso de la orden
     */
    public float verCarga() {
        return this.carga;
    }

    /**
     * Devuelve el nombre del despachante de la orden
     * @return String  - nombre del despachante de la orden
     */
    public String verNombreDespachante() {
        return this.nombreDespachante;
    }

    /**
     * Devuelve la dirección del despachante de la orden
     * @return String  - dirección del despachante de la orden
     */
    public String verDireccionDespachante() {
        return this.direccionDespachante;
    }

    /**
     * Devuelve la ciudad del despachante de la orden
     * @return String  - ciudad del despachante de la orden
     */
    public String verCiudadDespachante() {
        return this.ciudadDespachante;
    }

    /**
     * Devuelve la región del despachante de la orden
     * @return String  - región del despachante de la orden
     */
    public String verRegionDespachante() {
        return this.regionDespachante;
    }

    /**
     * Devuelve el código postal del despachante de la orden
     * @return String  - código postal del despachante de la orden
     */
    public String verCodigoPostalDespachante() {
        return this.codigoPostalDespachante;
    }

    /**
     * Devuelve el país del despachante de la orden
     * @return String  - país del despachante de la orden
     */
    public String verPaisDespachante() {
        return this.paisDespachante;
    }
    
    /**
     * Muestra el detalle de la orden
     * @return List<Detalle>  - lista con el detalle de la orden
     */
    public List<Detalle> verDetalle() {
        List<Detalle> detalles = new ArrayList<>();
        IGestorConexion gc = GestorConexion.instanciar();
        try {
            String cadena = "{CALL VerDetalle(?)}";
            CallableStatement stmt = gc.prepareCall(cadena);  
            stmt.setInt(1, this.idOrden);
            ResultSet rs = stmt.executeQuery();
            return this.leerResultSet(rs);
        }
        catch(SQLException | NullPointerException e) {
            return detalles;  
        }        
    }
    
    
    /**
     * Recorre el ResultSet especificado y devuelve una lista con todo el detalle de la orden
     * @param rs ResultSet
     * @return List<Detalle>  - lista con el detalle de una orden
     */
    private List<Detalle> leerResultSet(ResultSet rs) {
        List<Detalle> detalles = new ArrayList<>();
        try {
            while (rs.next()) {
                Integer idItem = rs.getInt("IDItem");                
                String nombre = rs.getString("Nombre");
                Integer idProveedor = rs.getInt("IDProveedor");
                Integer idCategoria = rs.getInt("IDCategoria");
                String cantidadPorUnidad = rs.getString("CantidadPorUnidad");
                Float precioUnitario = rs.getFloat("PrecioUnitario");
                Integer unidadesEnStock = rs.getInt("UnidadesEnStock");
                Integer unidadesAOrdenar = rs.getInt("UnidadesAOrdenar");
                Integer nivelReordenamiento = rs.getInt("NivelReordenamiento");
                Integer discontinuado = rs.getInt("Discontinuado");
                Item item = new Item(idItem, nombre, idProveedor, idCategoria, cantidadPorUnidad, precioUnitario, unidadesEnStock, unidadesAOrdenar, nivelReordenamiento, discontinuado);
                
                Float precio = rs.getFloat("Precio");
                Integer cantidad = rs.getInt("Cantidad");
                Float descuento = rs.getFloat("Descuento");
                
                Detalle detalle = new Detalle(item, precio, cantidad, descuento);
                detalles.add(detalle);
            }
            rs.close();  
        }
        catch(SQLException e) {
                
        }
        return detalles;
    }
}

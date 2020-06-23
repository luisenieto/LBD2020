/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordenes.modelos;

import auxiliares.ManejoDeFechas;
import interfaces.IGestorOrdenes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * Clase para mostrar las órdenes en una tabla
 */
public class ModeloTablaOrdenes extends AbstractTableModel {
    public static final String COLUMNA_FECHA = "Fecha"; 
    public static final String COLUMNA_CLIENTE = "Cliente";
    public static final String COLUMNA_DESPACHANTE = "Despachante";
    public static final String COLUMNA_CARGA = "Carga";
    public static final String COLUMNA_EMPLEADO = "Empleado";
    //constantes para los nombres de las columnas 
    
    private List<Orden> ordenes = new ArrayList<>();
    //los datos los saca de GestorOrdenes
    
    private List<String> nombresColumnas = Arrays.asList(new String[] {COLUMNA_FECHA, COLUMNA_CLIENTE, COLUMNA_DESPACHANTE, COLUMNA_CARGA, COLUMNA_EMPLEADO});       
    //colección para guardar los nombres de las columnas
    
    private IGestorOrdenes go = GestorOrdenes.instanciar();          
    
    /**
    * Constructor
    */                                                        
    public ModeloTablaOrdenes() {
        this.ordenes = go.verOrdenes();
    }
    
    /**
    * Constructor (para las órdenes de un año en particular)
    * @param anio año a filtrar
    */                                                        
    public ModeloTablaOrdenes(Integer anio) {
        this.ordenes = go.buscarOrdenes(anio);
    }
        
    /**
    * Obtiene el valor de la celda especificada
    * @param fila fila de la celda
    * @param columna columna de la celda
    * @return Object  - valor de la celda
    */                        
    @Override
    public Object getValueAt(int fila, int columna) {
        Orden orden = this.ordenes.get(fila);
        switch (columna) {
            case 0: return ManejoDeFechas.transformarLocalDateEnCadena(orden.verFecha());
            case 1: return orden.verCliente().toString();
            case 2: return orden.verNombreDespachante();
            case 3: return Float.toString(orden.verCarga());
            case 4: return orden.verEmpleado().toString();
            default: return ManejoDeFechas.transformarLocalDateEnCadena(orden.verFecha());
        }
    }
    
    /**
    * Obtiene la cantidad de columnas de la tabla
    * @return int  - cantidad de columnas de la tabla
    */                            
    @Override
    public int getColumnCount() { 
        return this.nombresColumnas.size();
    }

    /**
    * Obtiene la cantidad de filas de la tabla
    * @return int  - cantidad de filas de la tabla
    */                        
    @Override
    public int getRowCount() { 
        return this.ordenes.size();
    }

    /**
    * Obtiene el nombre de una columna
    * @param columna columna sobre la que se quiere obtener el nombre
    * @return String  - nombre de la columna especificada
    */                        
    @Override
    public String getColumnName(int columna) {
        return this.nombresColumnas.get(columna);
    }
    
    /**
    * Devuelve la Orden correspondiente a la fila especificada dentro de la tabla
    * Si se especifica una fila inválida devuelve null
    * @param fila fila dentro de la tabla
    * @return Orden  - objeto Orden correspondiente a la fila que se especifica
    * @see Orden
    */        
    public Orden verOrden(int fila) {
        try {
            return this.ordenes.get(fila);
        }
        catch(IndexOutOfBoundsException e) {
            return null;
        }
    }    
}

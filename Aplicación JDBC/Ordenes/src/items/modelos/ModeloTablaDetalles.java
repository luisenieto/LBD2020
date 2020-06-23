/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package items.modelos;

import ordenes.modelos.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * Clase para mostrar el detalle de una orden en una tabla
 */
public class ModeloTablaDetalles extends AbstractTableModel {
    public static final String COLUMNA_ITEM = "Item"; 
    public static final String COLUMNA_PRECIO = "Precio";
    public static final String COLUMNA_CANTIDAD = "Cantidad";
    public static final String COLUMNA_DESCUENTO = "Descuento";
    //constantes para los nombres de las columnas 
    
    private List<Detalle> detalles = new ArrayList<>();
    //los datos los saca de la orden
    
    private List<String> nombresColumnas = Arrays.asList(new String[] {COLUMNA_ITEM, COLUMNA_PRECIO, COLUMNA_CANTIDAD, COLUMNA_DESCUENTO});       
    //colección para guardar los nombres de las columnas
    
    
    /**
    * Constructor
    */                                                        
    public ModeloTablaDetalles(Orden orden) {
        this.detalles = orden.verDetalle();
    }
        
        
    /**
    * Obtiene el valor de la celda especificada
    * @param fila fila de la celda
    * @param columna columna de la celda
    * @return Object  - valor de la celda
    */                        
    @Override
    public Object getValueAt(int fila, int columna) {
        Detalle detalle = this.detalles.get(fila);
        switch (columna) {
            case 0: return detalle.verItem().verNombre();
            case 1: return detalle.verPrecio();
            case 2: return detalle.verCantidad();
            case 3: return detalle.verDescuento();
            default: return detalle.verItem().verNombre();
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
        return this.detalles.size();
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
}

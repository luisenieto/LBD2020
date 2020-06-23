/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empleados.modelos;

import auxiliares.ManejoDeFechas;
import interfaces.IGestorEmpleados;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * Clase para mostrar los empleados en una tabla
 */
public class ModeloTablaEmpleados extends AbstractTableModel {
    public static final String COLUMNA_APELLIDO = "Apellido";    
    public static final String COLUMNA_NOMBRE = "Nombre";
    public static final String COLUMNA_TITULO = "Título";
    public static final String COLUMNA_FECHA_NACIMIENTO = "Fec. Nacimiento";
    //constantes para los nombres de las columnas 
    
    private List<Empleado> empleados = new ArrayList<>();
    //los datos los saca de GestorEmpleados
    
    private List<String> nombresColumnas = Arrays.asList(new String[] {COLUMNA_APELLIDO, COLUMNA_NOMBRE, COLUMNA_TITULO, COLUMNA_FECHA_NACIMIENTO});       
    //colección para guardar los nombres de las columnas
    
    private IGestorEmpleados ge = GestorEmpleados.instanciar(); 
    
    /**
    * Constructor
    * @param idEmpleado idEmpleado para filtrar la búsqueda de empleados
    */                                                        
    public ModeloTablaEmpleados(String idEmpleado) {
        Empleado empleado = ge.buscarEmpleado(idEmpleado);
        if (empleado != null)
            this.empleados.add(empleado);
    }    
    
    /**
    * Constructor (todos los empleados)
    */                                                        
    public ModeloTablaEmpleados() {
        this.empleados = ge.verEmpleados();
    }
        
    /**
    * Obtiene el valor de la celda especificada
    * @param fila fila de la celda
    * @param columna columna de la celda
    * @return Object  - valor de la celda
    */                        
    @Override
    public Object getValueAt(int fila, int columna) {
        Empleado empleado = this.empleados.get(fila);
        switch (columna) {
            case 0: return empleado.verApellido();
            case 1: return empleado.verNombre();
            case 2: return empleado.verTitulo();
            case 3: return ManejoDeFechas.transformarLocalDateEnCadena(empleado.verFechaNacimiento());
            default: return empleado.verApellido();
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
        return this.empleados.size();
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
    * Devuelve el Empleado correspondiente a la fila especificada dentro de la tabla
    * Si se especifica una fila inválida devuelve null
    * @param fila fila dentro de la tabla
    * @return Empleado  - objeto Empleado correspondiente a la fila que se especifica
    * @see Empleado
    */        
    public Empleado verEmpleado(int fila) {
        try {
            return this.empleados.get(fila);
        }
        catch(IndexOutOfBoundsException e) {
            return null;
        }
    }    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empleados.modelos;

import interfaces.IGestorEmpleados;
import javax.swing.DefaultComboBoxModel;

/**
 * Clase para mostrar los empleados en un combo
 */
public class ModeloComboEmpleados extends DefaultComboBoxModel {
    
    /**
     * Constructor
     */
    public ModeloComboEmpleados() {
        IGestorEmpleados ge = GestorEmpleados.instanciar();
        for (Empleado empleado : ge.verEmpleados()) {
            this.addElement(empleado); 
        }
    }

    /**
     * Devuelve el empleado seleccionado
     * @return Empleado  - empleado seleccionado
     */
    public Empleado obtenerEmpleado() { 
        return (Empleado)this.getSelectedItem();
    }
        
    /**
     * Selecciona el Empleado especificado
     * @param idEmpleado identificador del empleado
     */
    public void seleccionarEmpleado(Integer idEmpleado) {
        if (idEmpleado != null) {
            for(int i = 0; i < this.getSize(); i++) {
                Empleado empleado = (Empleado)this.getElementAt(i);
                if (empleado.verIdEmpleado() == idEmpleado) {
                    this.setSelectedItem(empleado);
                    break;
                }
            }
        }
    }        
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import ordenes.modelos.Orden;

public interface IGestorOrdenes {
    
    /**
     * Debuelve todas las órdenes ordenadas por fecha descendentemente
     * @return List<Orden>  - lista de órdenes ordenada por fecha descendentemente
     */
    public List<Orden> verOrdenes();
    
    /**
     * Busca las órdenes donde el año de la fecha coincida con el especificado 
     * Si el año es null devuelve todas las órdenes
     * @param anio año de la fecha
     * @return List<Orden>  - lista de órdenes donde el año de la fecha coincide con el especificado
    */
    public List<Orden> buscarOrdenes(Integer anio);    
}

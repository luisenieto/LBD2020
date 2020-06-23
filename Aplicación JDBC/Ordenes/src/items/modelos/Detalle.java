/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package items.modelos;

public class Detalle {
    private Item item;
    private float precio;
    private int cantidad;
    private float descuento;

    /**
     * Constructor
     * @param item ítem que se ordenó
     * @param precio precio unitario del ítem
     * @param cantidad cantidad ordenada del ítem
     * @param descuento descuento realizado
     */
    public Detalle(Item item, float precio, int cantidad, float descuento) {
        this.item = item;
        this.precio = precio;
        this.cantidad = cantidad;
        this.descuento = descuento;
    }

    /**
     * Devuelve el ítem ordenado
     * @return Item  - ítem ordenado
     */
    public Item verItem() {
        return this.item;
    }

    /**
     * Devuelve el precio del ítem ordenado
     * @return float  - precio del ítem ordenado
     */
    public float verPrecio() {
        return this.precio;
    }

    /**
     * Devuelve la cantidad del ítem ordenado
     * @return int  - cantidad del ítem ordenado
     */
    public int verCantidad() {
        return this.cantidad;
    }

    /**
     * Devuelve el descuento realizado al ítem en la orden
     * @return float  - descuento realizado al ítem en la orden
     */
    public float verDescuento() {
        return this.descuento;
    }
    
    
}

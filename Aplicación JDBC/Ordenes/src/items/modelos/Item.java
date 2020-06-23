/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package items.modelos;

public class Item {
    private int idItem;
    private String nombre;
    private int idProveedor;
    private int idCategoria;
    private String cantidadPorUnidad;
    private float precioUnitario;
    private int unidadesEnStock;
    private int unidadesAOrdenar;
    private int nivelReordenamiento;
    private int discontinuado;

    /**
     * Constructor
     * @param idItem identificador del ítem
     * @param nombre nombre del ítem
     * @param idProveedor identificador del proveedor del ítem
     * @param idCategoria identificador de la categoría  del ítem
     * @param cantidadPorUnidad cantidad por unidad del ítem
     * @param precioUnitario precio unitario del ítem
     * @param unidadesEnStock cantidad de unidades en stock del ítem
     * @param unidadesAOrdenar cantidad de unidades a ordenar del ítem
     * @param nivelReordenamiento nivel de reordenamiento del ítem
     * @param discontinuado indica si el ítem está discontinuado o no
     */
    public Item(int idItem, String nombre, int idProveedor, int idCategoria, String cantidadPorUnidad, float precioUnitario, int unidadesEnStock, int unidadesAOrdenar, int nivelReordenamiento, int discontinuado) {
        this.idItem = idItem;
        this.nombre = nombre;
        this.idProveedor = idProveedor;
        this.idCategoria = idCategoria;
        this.cantidadPorUnidad = cantidadPorUnidad;
        this.precioUnitario = precioUnitario;
        this.unidadesEnStock = unidadesEnStock;
        this.unidadesAOrdenar = unidadesAOrdenar;
        this.nivelReordenamiento = nivelReordenamiento;
        this.discontinuado = discontinuado;
    }

    /**
     * Devuelve el identificador del ítem
     * @return int  - número identificador del ítem
     */
    public int verIdItem() {
        return this.idItem;
    }

    /**
     * Devuelve el nombre del ítem
     * @return String  - cadena con el nombre del ítem
     */
    public String verNombre() {
        return this.nombre;
    }

    /**
     * Devuelve el identificador del proveedor del ítem
     * @return int  - número identificador del proveedor del ítem
     */    
    public int verIdProveedor() {
        return this.idProveedor;
    }

    /**
     * Devuelve el identificador de la categoría del ítem
     * @return int  - número identificador de la categoría del ítem
     */
    public int verIdCategoria() {
        return this.idCategoria;
    }

    /**
     * Devuelve la cantidad por unidad del ítem
     * @return String  - cadena con la cantidad por unidad del ítem
     */    
    public String verCantidadPorUnidad() {
        return this.cantidadPorUnidad;
    }

    /**
     * Devuelve el precio unitario del ítem
     * @return float  - precio unitario del ítem
     */
    public float verPrecioUnitario() {
        return this.precioUnitario;
    }

    /**
     * Devuelve las unidades en stock del ítem
     * @return int  - unidades en stock del ítem
     */
    public int verUnidadesEnStock() {
        return this.unidadesEnStock;
    }

    /**
     * Devuelve las unidades a ordenar del ítem
     * @return int  - cantidad de unidades a ordenar del ítem
     */
    public int verUnidadesAOrdenar() {
        return this.unidadesAOrdenar;
    }

    /**
     * Devuelve el nivel de reordenamiento del ítem
     * @return int  - nivel de reordenamiento del ítem
     */
    public int verNivelReordenamiento() {
        return this.nivelReordenamiento;
    }

    /**
     * Devuelve un valor indicando si el ítem está discontinuado o no
     * @return int  - valor que indica si el ítem está discontinuado o no
     */
    public int verDiscontinuado() {
        return this.discontinuado;
    }
    
    
}

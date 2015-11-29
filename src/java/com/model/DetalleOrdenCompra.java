
package com.model;

public class DetalleOrdenCompra {
    private int cantidad;
    private double precioUnitario,precioItem;
    private String unidadMedida;
    private OrdenCompra ordenCompra;
    private Material material;

    public DetalleOrdenCompra() {
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public double getPrecioItem() {
        return precioItem;
    }

    public void setPrecioItem(double precioItem) {
        this.precioItem = precioItem;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public OrdenCompra getOrdenCompra() {
        return ordenCompra;
    }

    public void setOrdenCompra(OrdenCompra ordenCompra) {
        this.ordenCompra = ordenCompra;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }
    
        
            
    
}

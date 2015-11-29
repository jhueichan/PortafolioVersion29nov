
package com.model;

public class DetallePedido {
   private int cantidad;
   private double precioUnitario,precioTotal;
   private Material material;
   private SolicitudPedido solPedido;

    public DetallePedido() {
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

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public SolicitudPedido getSolPedido() {
        return solPedido;
    }

    public void setSolPedido(SolicitudPedido solPedido) {
        this.solPedido = solPedido;
    }
   
}


package com.model;

import java.sql.Date;


public class SolicitudPedido {
    
    private int numeroSol;
    private Date fechaEntrega;
    private Proyecto proyecto;
    private Empleado empleado;

    public SolicitudPedido() {
    }

    public int getNumeroSol() {
        return numeroSol;
    }

    public void setNumeroSol(int numeroSol) {
        this.numeroSol = numeroSol;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    
    
    
    
}

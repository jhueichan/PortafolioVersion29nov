package com.model;
import java.sql.Date;

public class Proyecto {
    
private int id;
private String nombre,ubicacion,descripcion;
private Date fecha_inicio, fecha_termino;
private Empleado ingeniero_originador,jefe_proyecto;

     public Proyecto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_termino() {
        return fecha_termino;
    }

    public void setFecha_termino(Date fecha_termino) {
        this.fecha_termino = fecha_termino;
    }

    public Empleado getIngeniero_originador() {
        return ingeniero_originador;
    }

    public void setIngeniero_originador(Empleado ingeniero_originador) {
        this.ingeniero_originador = ingeniero_originador;
    }

    public Empleado getJefe_proyecto() {
        return jefe_proyecto;
    }

    public void setJefe_proyecto(Empleado jefe_proyecto) {
        this.jefe_proyecto = jefe_proyecto;
    }

   
    
   
}


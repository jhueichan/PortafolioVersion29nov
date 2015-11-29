package com.action;

import com.dao.DaoProyecto;
import com.model.Empleado;
import com.model.Proyecto;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

public class ProyectosAction {

    private DaoProyecto dao = new DaoProyecto();
    private List<Proyecto> records;
    private String result;
    private String message;
    private Proyecto record;

    private int id;
    private String nombre, ubicacion, descripcion;
    private Date fecha_inicio, fecha_termino;
    private Empleado ingeniero_originador, jefe_proyecto;

    private ValueStack val;

    public String execute() throws Exception {
        val = ActionContext.getContext().getValueStack();
        dao.eliminar(codigoProyecto);
        val.push(record);
        return ActionSupport.SUCCESS;
    }

    public String list() {
        try {
            // Fetch Data from Proyecto Table
            records = dao.listar();
            result = "OK";
        } catch (Exception e) {
            result = "ERROR";
            message = e.getMessage();
            System.err.println(e.getMessage());
        }
        return Action.SUCCESS;
    }

    public String create() throws IOException {
        record = new Proyecto();

        //record.setCodigo(codigo);
        record.setId(this.codigoProyecto);
        record.setNombre(this.nombre);
        record.setUbicacion(this.ubicacion);
        record.setDescripcion(this.descripcion);
        record.setIngeniero_originador(this.ingeniero_originador);
        record.setJefe_proyecto(this.jefe_proyecto);
        record.setFecha_inicio(this.fecha_inicio);
        record.setFecha_termino(this.fecha_termino);
        try {
            // Create new record
            dao.ingresar(record);
            result = "OK";

        } catch (Exception e) {
            result = "ERROR";
            message = e.getMessage();
            System.err.println(e.getMessage());
        }
        return Action.SUCCESS;
    }

    public String update() throws IOException {
        Proyecto proyecto = new Proyecto();

        proyecto.setId(this.codigoProyecto);
        proyecto.setDescripcion(descripcion);
        proyecto.setUbicacion(ubicacion);
        proyecto.setFecha_inicio(fecha_inicio);
        proyecto.setFecha_termino(fecha_termino);
        proyecto.setIngeniero_originador(ingeniero_originador);
        proyecto.setJefe_proyecto(jefe_proyecto);
        
        try {
            // Update existing record
            dao.actualizar(proyecto);
            result = "OK";
        } catch (Exception e) {
            result = "ERROR";
            message = e.getMessage();
            System.err.println(e.getMessage());
        }
        return Action.SUCCESS;
    }

    public String delete() throws IOException {
        // Delete record
        try {
            dao.eliminar(this.codigoProyecto);
            result = "OK";
        } catch (Exception e) {
            result = "ERROR";
            message = e.getMessage();
            System.err.println(e.getMessage());
        }
        return Action.SUCCESS;
    }
    private int codigoProyecto;

    public Proyecto buscaProyecto() throws IOException {
        try {
            record = dao.buscarPorID(codigoProyecto);
            result = "OK";
        } catch (Exception e) {
            result = "ERROR";
            message = e.getMessage();
            System.err.println(e.getMessage());
        }
//          System.out.println("articulo:  " + record.getArticulo());
//          System.out.println("codigo:  " + record.getCodigo());
//          System.out.println("marca:  " + record.getMarca());
//          System.out.println("medida:  " + record.getU_medida());

        return record;
    }

}

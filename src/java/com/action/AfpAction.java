
package com.action;

import com.dao.DaoAfp;
import com.model.Afp;
import com.opensymphony.xwork2.Action;
import java.io.IOException;
import java.util.List;


public class AfpAction {
        private  DaoAfp dao= new DaoAfp();
        private Afp record;      
	private List<Afp> records;
	private String result;
	private String message;	
        private int id;	
        private int porcentaje;	
	private String nombre;
        
    
    public String list() throws IOException {
		try {
			// Fetch Data from Afp Table
                        records= dao.listar();
			result = "OK";
		} catch (Exception e) {
			result = "ERROR";
			message = e.getMessage();
			System.err.println(e.getMessage());
		}
		return Action.SUCCESS;	
	}
    public String create() throws IOException {
		record = new Afp();
               
		record.setId(id);
		record.setNombre(nombre);
                
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
		Afp ciudad = new Afp();
                
                 ciudad.setId(id);
		 ciudad.setNombre(nombre);
		
		try {
			// Update existing record
			dao.actualizar(ciudad);
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
			dao.eliminar(id);
			result = "OK";
		} catch (Exception e) {
			result = "ERROR";
			message = e.getMessage();
			System.err.println(e.getMessage());
		}
		return Action.SUCCESS;
	}


    public DaoAfp getDao() {
        return dao;
    }

    public void setDao(DaoAfp dao) {
        this.dao = dao;
    }

    public Afp getRecord() {
        return record;
    }

    public void setRecord(Afp record) {
        this.record = record;
    }

    public List<Afp> getRecords() {
        return records;
    }

    public void setRecords(List<Afp> records) {
        this.records = records;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
}

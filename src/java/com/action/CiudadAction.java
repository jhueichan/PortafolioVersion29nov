
package com.action;

import com.dao.DaoCiudad;
import com.model.Ciudad;
import com.opensymphony.xwork2.Action;
import java.io.IOException;
import java.util.List;


public class CiudadAction {
        private DaoCiudad dao = new DaoCiudad();
        private List<Ciudad> records;        
	private String result;
	private String message;
        private Ciudad record;
        
	private int id;	
	private String nombre;
                
          public String list() {
		try {
			// Fetch Data from Student Table
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
		record = new Ciudad();
               
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
		Ciudad ciudad = new Ciudad();
                
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

        
  // AQUI TODOS LOS GET Y SET   
        
    public DaoCiudad getDao() {
        return dao;
    }

    public void setDao(DaoCiudad dao) {
        this.dao = dao;
    }

    public List<Ciudad> getRecords() {
        return records;
    }

    public void setRecords(List<Ciudad> records) {
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
                
                
                
                
                
}

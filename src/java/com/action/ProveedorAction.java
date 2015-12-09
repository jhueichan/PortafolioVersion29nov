/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.action;

import com.dao.DaoProveedor;
import com.model.Proveedor;
import com.opensymphony.xwork2.Action;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author christian
 */
public class ProveedorAction {
    
    private String rut,razon_social,direccion,contacto,telefono,email,website, ciudad,activo,formaPago;

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    private String result;
    private String message;	
    private Proveedor record;
    private List <Proveedor> records;
    private DaoProveedor daoProveedor = new DaoProveedor();
    
     public String list() throws IOException {
		try {
			// Fetch Data from Afp Table
                        records= daoProveedor.listar();
			result = "OK";
		} catch (Exception e) {
			result = "ERROR";
			message = e.getMessage();
			System.err.println(e.getMessage());
		}
		return Action.SUCCESS;	
	}
    public String create() throws IOException {
		record = new Proveedor();
               
		record.setRut(rut);
		record.setRazon_social(razon_social);
                record.setDireccion(direccion);
                record.setContacto(contacto);
                record.setCiudad(ciudad);
                record.setTelefono(telefono);
                record.setEmail(email);
                record.setWebsite(website);
                record.setActivo(activo);
                record.setFormaPago(formaPago);
                
           		try {
			// Create new record
			daoProveedor.ingresar(record);
			result = "OK";

		} catch (Exception e) {
			result = "ERROR";
			message = e.getMessage();
			System.err.println(e.getMessage());
		}
		return Action.SUCCESS;
    }

	public String update() throws IOException {
		record = new Proveedor();
               
		record.setRut(rut);
		record.setRazon_social(razon_social);
                record.setDireccion(direccion);
                record.setContacto(contacto);
                record.setTelefono(telefono);
                record.setTelefono(telefono);
                record.setEmail(email);
                record.setWebsite(website);
                record.setActivo(activo);
                record.setFormaPago(formaPago);
		
		try {
			// Update existing record
			daoProveedor.actualizar(record);
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
			daoProveedor.eliminar(rut);
			result = "OK";
		} catch (Exception e) {
			result = "ERROR";
			message = e.getMessage();
			System.err.println(e.getMessage());
		}
		return Action.SUCCESS;
	}
        

      public  String  buscaProveedorPorCodigo() throws java.io.IOException {
      try {
                       
             System.out.println("recurso de la jsp:  " + rut);
             record = daoProveedor.buscarPorID(rut);
			result = "OK";
		} catch (Exception e) {
			result = "ERROR";
			message = e.getMessage();
			System.err.println(e.getMessage());
		}     
         
		return Action.SUCCESS;
      }


    

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public Proveedor getRecord() {
        return record;
    }

    public void setRecord(Proveedor record) {
        this.record = record;
    }

    public List<Proveedor> getRecords() {
        return records;
    }

    public void setRecords(List<Proveedor> records) {
        this.records = records;
    }

    public DaoProveedor getDaoProveedor() {
        return daoProveedor;
    }

    public void setDaoProveedor(DaoProveedor daoProveedor) {
        this.daoProveedor = daoProveedor;
    }
    
    
    
    
}

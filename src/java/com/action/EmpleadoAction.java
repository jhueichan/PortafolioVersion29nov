package com.action;

import com.dao.DaoAfp;
import com.dao.DaoCiudad;
import java.io.IOException;
import java.util.List;

import com.dao.DaoEmpleado;
import com.dao.DaoEstadoCivil;
import com.dao.DaoNacionalidad;
import com.dao.DaoPrevision;
import com.dao.DaoProfesion;
import com.dao.DaoRol;
import com.model.Afp;
import com.model.Ciudad;
import com.model.Empleado;
import com.model.EstadoCivil;
import com.model.Nacionalidad;
import com.model.Prevision;
import com.model.Profesion;
import com.model.Rol;
import com.opensymphony.xwork2.Action;
import java.sql.Date;

public class EmpleadoAction {

    private DaoEmpleado dao = new DaoEmpleado();

    private List<Empleado> records;
    private List<Ciudad> ciudades;
     
    private String result;
    private String message;
    private Empleado record;

     private String rut;
     private String nombres;
     private String apellidos;
     private String direccion;
     private Date fechaNac;
     private String cargasFam;
     private String telefono;
     private String email;
     private String password;     
     // claves foraneas  
  private int idEmp;
  DaoEmpleado daoEmp=  new DaoEmpleado();
    private int idCiud;
   DaoCiudad daoCiudad = new DaoCiudad();
    private int idNac;
  DaoNacionalidad daoNacionalidad = new DaoNacionalidad();
    private int idEst;
   DaoEstadoCivil daoEstadoCivil = new DaoEstadoCivil();
    private int idAfp;
   DaoAfp daoAfp = new DaoAfp();
    private int idPre;
   DaoPrevision daoPrevision = new DaoPrevision();
    private int idProf;
  DaoProfesion daoProfesion = new DaoProfesion();
    private int idRol;
  DaoRol daoRol = new DaoRol();

	public String list() {
		try {
			// Fetch Data from Empleado Table
			records = dao.listar();
                        ciudades = daoCiudad.listar();
			result = "OK";
		} catch (Exception e) {
			result = "ERROR";
			message = e.getMessage();
			System.err.println(e.getMessage());
		}
		return Action.SUCCESS;
	}

	public String create() throws IOException {
	try {  
                record.setRut(this.rut);
                record.setNombres(this.nombres);
                record.setApellidos(this.apellidos);
                record.setDireccion(this.direccion);   
                Ciudad  ciudad = daoCiudad.buscarPorID(idCiud);                
                record.setCiudad(ciudad);
                Nacionalidad nacionalidad= daoNacionalidad.buscarPorID(idNac);
                record.setNacionalidad(nacionalidad);                  
                Date fexNac= new Date(1981, 10, 10);
                record.setFechaNac(fexNac);                  
                EstadoCivil estado=daoEstadoCivil.buscarPorID(idEst);
                record.setEstadoCivil(estado);                
                record.setCargasFam(this.cargasFam);
                Afp afp= daoAfp.buscarPorID(idAfp);
                record.setAfp(afp);
                Prevision prevision=daoPrevision.buscarPorID(idPre);
                record.setPrevision(prevision);                
                record.setTelefono(this.telefono);
                record.setEmail(this.email);
                Profesion  profesion= daoProfesion.buscarPorID(idProf);
                record.setProfesion(profesion);
                Rol rol= daoRol.buscarPorID(idRol);
                record.setRol(rol);                
                record.setPassword(this.password);  
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
        try {
                record.setRut(this.rut);
                record.setNombres(this.nombres);
                record.setApellidos(this.apellidos);
                record.setDireccion(this.direccion);   
                Ciudad  ciudad = daoCiudad.buscarPorID(idCiud);                
                record.setCiudad(ciudad);
                Nacionalidad nacionalidad= daoNacionalidad.buscarPorID(idNac);
                record.setNacionalidad(nacionalidad);                  
                Date fexNac= new Date(1981, 10, 10);
                record.setFechaNac(fexNac);                  
                EstadoCivil estado=daoEstadoCivil.buscarPorID(idEst);
                record.setEstadoCivil(estado);                
                record.setCargasFam(this.cargasFam);
                Afp afp= daoAfp.buscarPorID(idAfp);
                record.setAfp(afp);
                Prevision prevision=daoPrevision.buscarPorID(idPre);
                record.setPrevision(prevision);                
                record.setTelefono(this.telefono);
                record.setEmail(this.email);
                Profesion  profesion= daoProfesion.buscarPorID(idProf);
                record.setProfesion(profesion);
                Rol rol= daoRol.buscarPorID(idRol);
                record.setRol(rol);                
                record.setPassword(this.password); 
			// Update existing record
			dao.actualizar(record);
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
			dao.eliminar(this.rut);
			result = "OK";
		} catch (Exception e) {
			result = "ERROR";
			message = e.getMessage();
			System.err.println(e.getMessage());
		}
		return Action.SUCCESS;
	}

}
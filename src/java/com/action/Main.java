
package com.action;
import java.sql.Date;
import com.dao.DaoAfp;
import com.dao.DaoCiudad;
import com.dao.DaoEmpleado;
import com.dao.DaoEstadoCivil;
import com.dao.DaoFormaPago;
import com.dao.DaoNacionalidad;
import com.dao.DaoPrevision;
import com.dao.DaoProfesion;
import com.dao.DaoProveedor;
import com.dao.DaoRol;
import com.model.Afp;
import com.model.Ciudad;
import com.model.Empleado;
import com.model.EstadoCivil;
import com.model.FormaPago;
import com.model.Nacionalidad;
import com.model.Prevision;
import com.model.Profesion;
import com.model.Proveedor;
import com.model.Rol;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        
        
    DaoEmpleado daoEmp=  new DaoEmpleado();
    DaoCiudad daoCiudad = new DaoCiudad();
    DaoNacionalidad daoNacionalidad = new DaoNacionalidad();
    DaoEstadoCivil daoEstadoCivil = new DaoEstadoCivil();
    DaoAfp daoAfp = new DaoAfp();
    DaoPrevision daoPrevision = new DaoPrevision();
    DaoProfesion daoProfesion = new DaoProfesion();
    DaoRol daoRol = new DaoRol();
    
    
    
    
    
         Empleado empleado = new Empleado();                
                empleado.setRut("17234983");
                empleado.setNombres("juan alberto");
                empleado.setApellidos("lopez carrasco");
                empleado.setDireccion("14 norte 3451");              
               
                Ciudad  ciudad = daoCiudad.buscarPorID(2);                
                empleado.setCiudad(ciudad);
                Nacionalidad nacionalidad= daoNacionalidad.buscarPorID(1);
                empleado.setNacionalidad(nacionalidad);  
                
                Date fexNac= new Date(1981, 10, 10);
                empleado.setFechaNac(fexNac);  
                
                EstadoCivil estado=daoEstadoCivil.buscarPorID(1);
                empleado.setEstadoCivil(estado);
                
                empleado.setCargasFam("1");
                Afp afp= daoAfp.buscarPorID(1);
                empleado.setAfp(afp);
                Prevision prevision=daoPrevision.buscarPorID(1);
                empleado.setPrevision(prevision);                
                empleado.setTelefono("0323503293");
                empleado.setEmail("juan9822@gmail.com");
                Profesion  profesion= daoProfesion.buscarPorID(1);
                empleado.setProfesion(profesion);
                Rol rol= daoRol.buscarPorID(1);
                empleado.setRol(rol);                
                empleado.setPassword("paswd");        
        
        daoEmp.ingresar(empleado);
        


        
        
    }
    
}


package com.service;

import com.jdbc.DataAccessObject;
import com.model.Empleado;
import java.sql.Connection;
import java.util.List;

public interface EmpleadoInterface {
        
    public static Connection dbConnection= DataAccessObject.getConnection();    
    public boolean eliminar(String  rut) throws Exception;
    public List listar() throws Exception;
    public boolean ingresar(Empleado obj) throws Exception;   
    public boolean actualizar(Empleado obj) throws Exception;
    public Empleado buscarPorID(String rut) throws Exception;
    
}

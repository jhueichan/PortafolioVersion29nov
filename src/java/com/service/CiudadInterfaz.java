
package com.service;

import com.jdbc.DataAccessObject;
import com.model.Ciudad;
import java.sql.Connection;
import java.util.List;

public interface CiudadInterfaz {    
    
    public static Connection dbConnection= DataAccessObject.getConnection();   
    
    public boolean eliminar(int id) throws Exception;
    public List listar() throws Exception;
    public boolean ingresar(Ciudad obj) throws Exception;   
    public boolean actualizar(Ciudad obj) throws Exception;
    public Ciudad buscarPorID(int id) throws Exception;
    
}


package com.service;

import com.jdbc.DataAccessObject;
import com.model.Afp;
import java.sql.Connection;
import java.util.List;


public interface AfpInterfaz {
    
    public static Connection dbConnection= DataAccessObject.getConnection();  
    public boolean eliminar(int id) throws Exception;
    public List listar() throws Exception;
    public boolean ingresar(Afp obj) throws Exception;   
    public boolean actualizar(Afp obj) throws Exception;
    public Afp buscarPorID(int id) throws Exception;
    
}

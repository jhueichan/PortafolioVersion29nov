
package com.service;

import com.jdbc.DataAccessObject;
import com.model.Cliente;
import java.sql.Connection;
import java.util.List;

public interface ClienteInterface {    
    
    public static Connection dbConnection= DataAccessObject.getConnection();   
    
    public boolean eliminar(String id) throws Exception;
    public List listar() throws Exception;
    public boolean ingresar(Cliente obj) throws Exception;   
    public boolean actualizar(Cliente obj) throws Exception;
    public Cliente buscarPorID(String id) throws Exception;
    
}

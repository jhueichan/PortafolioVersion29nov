
package com.service;

import com.jdbc.DataAccessObject;
import com.model.OrdenCompra;
import java.sql.Connection;
import java.util.List;

public interface OrdenCompraInterface {    
    
    public static Connection dbConnection= DataAccessObject.getConnection();   
    
    public boolean eliminar(int id) throws Exception;
    public List listar() throws Exception;
    public boolean ingresar(OrdenCompra obj) throws Exception;   
    public boolean actualizar(OrdenCompra obj) throws Exception;
    public OrdenCompra buscarPorID(int id) throws Exception;
    
}

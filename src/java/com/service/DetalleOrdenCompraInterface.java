
package com.service;

import com.jdbc.DataAccessObject;
import com.model.DetalleOrdenCompra;
import java.sql.Connection;
import java.util.List;

public interface DetalleOrdenCompraInterface {    
    
    public static Connection dbConnection= DataAccessObject.getConnection();   
    
    public boolean eliminar(int id) throws Exception;
    public List listar() throws Exception;
    public boolean ingresar(DetalleOrdenCompra obj) throws Exception;   
    public boolean actualizar(DetalleOrdenCompra obj) throws Exception;
    public DetalleOrdenCompra buscarPorID(int id) throws Exception;
    
}

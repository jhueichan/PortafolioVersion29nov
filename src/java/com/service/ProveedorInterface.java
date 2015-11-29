
package com.service;
import com.jdbc.DataAccessObject;
import com.model.Proveedor;
import java.sql.Connection;
import java.util.List;
public interface ProveedorInterface {     
    public static Connection dbConnection= DataAccessObject.getConnection();    
    public boolean eliminar(String id) throws Exception;
    public List listar() throws Exception;
    public boolean ingresar(Proveedor obj) throws Exception;   
    public boolean actualizar(Proveedor obj) throws Exception;
    public Proveedor buscarPorID(String id) throws Exception;      
}

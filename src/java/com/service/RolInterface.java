
package com.service;
import com.jdbc.DataAccessObject;
import com.model.Rol;
import java.sql.Connection;
import java.util.List;
public interface RolInterface {     
    public static Connection dbConnection= DataAccessObject.getConnection();    
    public boolean eliminar(int id) throws Exception;
    public List listar() throws Exception;
    public boolean ingresar(Rol obj) throws Exception;   
    public boolean actualizar(Rol obj) throws Exception;
    public Rol buscarPorID(int id) throws Exception;      
}

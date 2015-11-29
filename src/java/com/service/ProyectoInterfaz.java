
package com.service;

import com.jdbc.DataAccessObject;
import com.model.Proyecto;
import java.sql.Connection;
import java.util.List;

public interface ProyectoInterfaz {    
    
    public static Connection dbConnection= DataAccessObject.getConnection();   
    
    public boolean eliminar(int id) throws Exception;
    public List listar() throws Exception;
    public boolean ingresar(Proyecto obj) throws Exception;   
    public boolean actualizar(Proyecto obj) throws Exception;
    public Proyecto buscarPorID(int id) throws Exception;
    
}

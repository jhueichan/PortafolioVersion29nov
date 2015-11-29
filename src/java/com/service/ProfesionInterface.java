
package com.service;

import com.jdbc.DataAccessObject;
import com.model.Profesion;
import java.sql.Connection;
import java.util.List;

public interface ProfesionInterface {
    
    public static Connection dbConnection= DataAccessObject.getConnection();    
    public boolean eliminar(int id) throws Exception;
    public List listar() throws Exception;
    public boolean ingresar(Profesion obj) throws Exception;   
    public boolean actualizar(Profesion obj) throws Exception;
    public Profesion buscarPorID(int id) throws Exception;  
    
}

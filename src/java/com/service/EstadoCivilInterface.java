
package com.service;

import com.jdbc.DataAccessObject;
import com.model.EstadoCivil;
import java.sql.Connection;
import java.util.List;

public interface EstadoCivilInterface {
        
    public static Connection dbConnection= DataAccessObject.getConnection();    
    public boolean eliminar(int id) throws Exception;
    public List listar() throws Exception;
    public boolean ingresar(EstadoCivil obj) throws Exception;   
    public boolean actualizar(EstadoCivil obj) throws Exception;
    public EstadoCivil buscarPorID(int id) throws Exception;
    
}

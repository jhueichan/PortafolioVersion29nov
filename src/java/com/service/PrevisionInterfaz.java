
package com.service;

import com.jdbc.DataAccessObject;
import com.model.Prevision;
import java.sql.Connection;
import java.util.List;


public interface PrevisionInterfaz {
       
    public static Connection dbConnection= DataAccessObject.getConnection();    
    public boolean eliminar(int id) throws Exception;
    public List listar() throws Exception;
    public boolean ingresar(Prevision obj) throws Exception;   
    public boolean actualizar(Prevision obj) throws Exception;
    public Prevision buscarPorID(int id) throws Exception;
}

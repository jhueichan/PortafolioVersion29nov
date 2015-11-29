
package com.service;

import com.jdbc.DataAccessObject;
import com.model.Pagina;
import java.sql.Connection;
import java.util.List;


public interface PaginaInterface {
   public static Connection dbConnection= DataAccessObject.getConnection();    
    public boolean eliminar(int id) throws Exception;
    public List listar() throws Exception;
    public boolean ingresar(Pagina obj) throws Exception;   
    public boolean actualizar(Pagina obj) throws Exception;
    public Pagina buscarPorID(int id) throws Exception;  
}

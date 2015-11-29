
package com.service;

import com.jdbc.DataAccessObject;
import com.model.Nacionalidad;
import java.sql.Connection;
import java.util.List;

public interface InterfaceNacionalidad {
    public static Connection dbConnection= DataAccessObject.getConnection();    
    public boolean eliminar(int id) throws Exception;
    public List listar() throws Exception;
    public boolean ingresar(Nacionalidad obj) throws Exception;   
    public boolean actualizar(Nacionalidad obj) throws Exception;
    public Nacionalidad buscarPorID(int id) throws Exception;
}
 

package com.service;

import com.jdbc.DataAccessObject;
import com.model.FormaPago;
import java.sql.Connection;
import java.util.List;

public interface FormaPagoInterface {
     public static Connection dbConnection= DataAccessObject.getConnection();    
    public boolean eliminar(int id) throws Exception;
    public List listar() throws Exception;
    public boolean ingresar(FormaPago obj) throws Exception;   
    public boolean actualizar(FormaPago obj) throws Exception;
    public FormaPago buscarPorID(int id) throws Exception;
}

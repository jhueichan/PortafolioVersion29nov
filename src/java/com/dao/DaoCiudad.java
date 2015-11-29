
package com.dao;

import com.model.Ciudad;
import com.service.CiudadInterfaz;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoCiudad implements CiudadInterfaz {
    PreparedStatement pStmt;  
    
    public DaoCiudad() {      
    }

    @Override
    public boolean eliminar(int id) throws Exception {
      String deleteQuery = "DELETE FROM CIUDAD WHERE ID = ?";
	try {
		pStmt = dbConnection.prepareStatement(deleteQuery);
		pStmt.setInt(1, id);
		pStmt.executeUpdate();
                return true;   
	} catch (SQLException e) {
		System.err.println(e.getMessage());
                return false;   
	}
        
    }

    @Override
    public List listar() throws Exception {
     List<Ciudad> ciudades = new ArrayList<Ciudad>();        
	String query = "SELECT * FROM CIUDAD";
	try {
		Statement stmt = dbConnection.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			Ciudad ciudad = new Ciudad();
			ciudad.setId(rs.getInt(1));
			ciudad.setNombre(rs.getString(2));                        
			ciudades.add(ciudad);	
                }
	} catch (SQLException e) {
		System.err.println(e.getMessage());
	}
	return ciudades;
    }

    @Override
    public boolean ingresar(Ciudad obj) throws Exception {
       String insertQuery = "INSERT INTO CIUDAD VALUES (CIUDAD_SEQ.NextVal,?)";
       try {
        	pStmt = dbConnection.prepareStatement(insertQuery);             
		pStmt.setString(1, obj.getNombre());		              
        	pStmt.executeUpdate();
            return true;      
	} catch (SQLException e) {
		System.err.println(e.getMessage());   
           return false;
	}         
     }

    @Override
    public boolean actualizar(Ciudad obj) throws Exception {
      String updateQuery = "UPDATE CIUDAD SET NOMBRE = ? WHERE ID  = ?";
	try {
		pStmt = dbConnection.prepareStatement(updateQuery);		
		pStmt.setString(1, obj.getNombre());
		pStmt.setInt(2, obj.getId());
		pStmt.executeUpdate();
                     return true;
	} catch (SQLException e) {
		System.err.println(e.getMessage());
                return false;
	}
    }

    @Override
    public  Ciudad buscarPorID(int id) throws Exception {
     Ciudad ciudad=new Ciudad();
     String query = "SELECT * FROM CIUDAD WHERE ID = ?";   
      try {
                  pStmt = dbConnection.prepareStatement(query);            
		  pStmt.setInt(1,id);	
                  ResultSet rs = pStmt.executeQuery();                 
		while (rs.next()) {
			 ciudad.setId(rs.getInt(1));
			 ciudad.setNombre(rs.getString(2));						 	
		}
	} catch (SQLException e) {
		System.err.println(e.getMessage());
	}   
        return  ciudad;   
    }


}

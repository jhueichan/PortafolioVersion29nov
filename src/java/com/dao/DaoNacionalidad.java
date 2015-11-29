
package com.dao;

import com.model.Nacionalidad;
import com.service.InterfaceNacionalidad;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoNacionalidad implements InterfaceNacionalidad{
        PreparedStatement pStmt;  

    public DaoNacionalidad() {
    }

    @Override
    public boolean eliminar(int id) throws Exception {
       String deleteQuery = "DELETE FROM NACIONALIDAD WHERE ID = ?";
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
     List<Nacionalidad> nacionalidades = new ArrayList<Nacionalidad>();        
	String query = "SELECT * FROM NACIONALIDAD";
	try {
		Statement stmt = dbConnection.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			Nacionalidad nacionalidad = new Nacionalidad();
			nacionalidad.setId(rs.getInt(1));
			nacionalidad.setPais(rs.getString(2));
                        nacionalidad.setNacionalidad(rs.getString(3));
			nacionalidades.add(nacionalidad);		}
	} catch (SQLException e) {
		System.err.println(e.getMessage());
	}
	return nacionalidades;
    }

    @Override
    public boolean ingresar(Nacionalidad obj) throws Exception {
     String insertQuery = "INSERT INTO NACIONALIDAD VALUES (NACIONALIDAD_SEQ.NextVal,?,?)";
       try {
        	pStmt = dbConnection.prepareStatement(insertQuery);             
		pStmt.setString(1, obj.getPais());
                pStmt.setString(2, obj.getNacionalidad());
        	pStmt.executeUpdate();
            return true;      
	} catch (SQLException e) {
		System.err.println(e.getMessage());   
           return false;
	} 
    }

    @Override
    public boolean actualizar(Nacionalidad obj) throws Exception {
    
    String updateQuery = "UPDATE NACIONALIDAD SET PAIS = ? , NACIONALIDAD = ? WHERE ID  = ?";
	try {
		pStmt = dbConnection.prepareStatement(updateQuery);		
		pStmt.setString(1, obj.getPais());
		pStmt.setString(2, obj.getNacionalidad());
                pStmt.setInt(3, obj.getId());
		pStmt.executeUpdate();
                     return true;
	} catch (SQLException e) {
		System.err.println(e.getMessage());
                return false;
	}    
 }

    @Override
    public Nacionalidad buscarPorID(int id) throws Exception {
      Nacionalidad nacionalidad=new Nacionalidad();
     String query = "SELECT * FROM NACIONALIDAD WHERE ID = ?";   
      try {
                  pStmt = dbConnection.prepareStatement(query);            
		  pStmt.setInt(1,id);	
                  ResultSet rs = pStmt.executeQuery();                 
		while (rs.next()) {
			 nacionalidad.setId(rs.getInt(1));
			 nacionalidad.setPais(rs.getString(2));
                         nacionalidad.setNacionalidad(rs.getString(3));	
		}
	} catch (SQLException e) {
		System.err.println(e.getMessage());
	}   
        return  nacionalidad;   
    }
        
        
        
}

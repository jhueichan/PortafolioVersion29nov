
package com.dao;


import com.model.EstadoCivil;
import com.service.EstadoCivilInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoEstadoCivil implements EstadoCivilInterface {
    PreparedStatement pStmt; 
    public DaoEstadoCivil() {
    }

    @Override
    public boolean eliminar(int id) throws Exception {
         String deleteQuery = "DELETE FROM ESTADO_CIVIL WHERE ID = ?";
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
           List<EstadoCivil> estados = new ArrayList<EstadoCivil>();        
	String query = "SELECT * FROM ESTADO_CIVIL";
	try {
		Statement stmt = dbConnection.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			EstadoCivil estadoCivil = new EstadoCivil();
			estadoCivil.setId(rs.getInt(1));
			estadoCivil.setNombre(rs.getString(2));
                        
			estados.add(estadoCivil);		}
	} catch (SQLException e) {
		System.err.println(e.getMessage());
	}
	return estados;  
    }

    @Override
    public boolean ingresar(EstadoCivil obj) throws Exception {
        String insertQuery = "INSERT INTO ESTADO_CIVIL VALUES (ECIVIL_SEQ.NextVal,?)";
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
    public boolean actualizar(EstadoCivil obj) throws Exception {
        String updateQuery = "UPDATE ESTADO_CIVIL SET NOMBRE = ? WHERE ID  = ?";
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
    public EstadoCivil buscarPorID(int id) throws Exception {
        EstadoCivil est=new EstadoCivil();
     String query = "SELECT * FROM ESTADO_CIVIL WHERE ID = ?";   
      try {
                  pStmt = dbConnection.prepareStatement(query);            
		  pStmt.setInt(1,id);	
                  ResultSet rs = pStmt.executeQuery();                 
		while (rs.next()) {
			 est.setId(rs.getInt(1));
			 est.setNombre(rs.getString(2));						 	
		}
	} catch (SQLException e) {
		System.err.println(e.getMessage());
	}   
        return  est;    
    }
    
    
}

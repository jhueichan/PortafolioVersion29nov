
package com.dao;
import com.model.Profesion;
import com.service.ProfesionInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class DaoProfesion implements  ProfesionInterface {
   PreparedStatement pStmt;   

    public DaoProfesion() {
    }

    @Override
    public boolean eliminar(int id) throws Exception {
    String deleteQuery = "DELETE FROM PROFESION WHERE ID = ?";
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
      List<Profesion> profesiones = new ArrayList<Profesion>();        
	String query = "SELECT * FROM PROFESION";
	try {
		Statement stmt = dbConnection.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			Profesion profesion = new Profesion();
			profesion.setId(rs.getInt(1));
			profesion.setProfesion(rs.getString(2));                        
			profesiones.add(profesion);		}
	} catch (SQLException e) {
		System.err.println(e.getMessage());
	}
	return profesiones; }

    @Override
    public boolean ingresar(Profesion obj) throws Exception {
     String insertQuery = "INSERT INTO PROFESION VALUES (PROFESION_SEQ.NextVal,?)";
       try {
        	pStmt = dbConnection.prepareStatement(insertQuery);             
		pStmt.setString(1, obj.getProfesion());		              
        	pStmt.executeUpdate();
            return true;      
	} catch (SQLException e) {
		System.err.println(e.getMessage());   
           return false;
	}      
    }

    @Override
    public boolean actualizar(Profesion obj) throws Exception {
     String updateQuery = "UPDATE PROFESION SET PROFESION = ? WHERE ID  = ?";
	try {
		pStmt = dbConnection.prepareStatement(updateQuery);		
		pStmt.setString(1, obj.getProfesion());
		pStmt.setInt(2, obj.getId());
		pStmt.executeUpdate();
                 return true;
	} catch (SQLException e) {
		System.err.println(e.getMessage());
                return false;
	}     }

    @Override
    public Profesion buscarPorID(int id) throws Exception {
          Profesion profesion=new Profesion();
     String query = "SELECT * FROM PROFESION WHERE ID = ?";   
      try {
                  pStmt = dbConnection.prepareStatement(query);            
		  pStmt.setInt(1,id);	
                  ResultSet rs = pStmt.executeQuery();                 
		while (rs.next()) {
			 profesion.setId(rs.getInt(1));
			 profesion.setProfesion(rs.getString(2));						 	
		}
	} catch (SQLException e) {
		System.err.println(e.getMessage());
	}   
        return  profesion;  
    }
    
    
    
    
    
    
}

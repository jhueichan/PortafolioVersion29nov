
package com.dao;

import com.model.Prevision;
import com.service.PrevisionInterfaz;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoPrevision implements PrevisionInterfaz{
    PreparedStatement pStmt;  
    public DaoPrevision() {
    }
  
    @Override
    public boolean eliminar(int id) throws Exception {
    String deleteQuery = "DELETE FROM PREVISION WHERE ID = ?";
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
         List<Prevision> previsiones = new ArrayList<Prevision>();        
	String query = "SELECT * FROM PREVISION";
	try {
		Statement stmt = dbConnection.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			Prevision prevision = new Prevision();                        
			prevision.setId(rs.getInt(1));
			prevision.setPrevision(rs.getString(2));
                        prevision.setPorcentaje(rs.getDouble(3));
			previsiones.add(prevision);		}
	} catch (SQLException e) {
		System.err.println(e.getMessage());
	}
	return previsiones;
    }

    @Override
    public boolean ingresar(Prevision obj) throws Exception {
     
        String insertQuery = "INSERT INTO PREVISION VALUES (PREVISION_SEQ.NextVal,?,?)";
       try {
        	pStmt = dbConnection.prepareStatement(insertQuery);             
		pStmt.setString(1, obj.getPrevision());
                pStmt.setDouble(2, obj.getPorcentaje());           	
        	pStmt.executeUpdate();
                   return true; 
	} catch (SQLException e) {
		System.err.println(e.getMessage());   
                return  false;
	}          
    }

    @Override
    public boolean actualizar(Prevision obj) throws Exception {
     String updateQuery = "UPDATE PREVISION SET PREVISION = ?,PORCENTAJE = ?  WHERE ID  = ?";
	try {
		pStmt = dbConnection.prepareStatement(updateQuery);		
		pStmt.setString(1, obj.getPrevision());
                pStmt.setDouble(2, obj.getPorcentaje());
		pStmt.setInt(3, obj.getId());
		pStmt.executeUpdate();
                return  true;
	} catch (SQLException e) {
		System.err.println(e.getMessage());
                return  false;
	}    
    }

    @Override
    public Prevision buscarPorID(int id) throws Exception {     
      Prevision prevision=new Prevision();
      String query = "SELECT * FROM PREVISION WHERE ID = ?";   
      try {
                  pStmt = dbConnection.prepareStatement(query);            
		  pStmt.setInt(1,id);	
                  ResultSet rs = pStmt.executeQuery();                 
		while (rs.next()) {
			 prevision.setId(rs.getInt(1));
			 prevision.setPrevision(rs.getString(2));
                         prevision.setPorcentaje(rs.getDouble(3));
		}
	} catch (SQLException e) {
		System.err.println(e.getMessage());
	}   
        return  prevision; 
    }
      
    
}

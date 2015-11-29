
package com.dao;


import com.model.Afp;
import com.service.AfpInterfaz;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoAfp implements AfpInterfaz {
    PreparedStatement pStmt;   
    
    public DaoAfp() {
     
    }

    @Override
    public boolean eliminar(int id) throws Exception {
     String deleteQuery = "DELETE FROM AFP WHERE ID = ?";
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
     List<Afp> apfs = new ArrayList<Afp>();        
      	String query = "SELECT * FROM AFP";
	try {
		Statement stmt = dbConnection.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
                     Afp afp = new Afp();  
                     afp.setId(rs.getInt(1));
                     afp.setNombre(rs.getString(2));
                     afp.setPorcentaje(rs.getDouble(3));            
                     apfs.add(afp);
		}
	} catch (SQLException e) {
		System.err.println(e.getMessage());
	}
	return apfs ;
    }

    @Override
    public boolean ingresar(Afp obj) throws Exception {
      
       String insertQuery = "INSERT INTO AFP VALUES (AFP_SEQ.NextVal,?,?)";
       try {
        	pStmt = dbConnection.prepareStatement(insertQuery);             
		pStmt.setString(1, obj.getNombre());
		pStmt.setDouble(2, obj.getPorcentaje());		              
        	pStmt.executeUpdate();
                return true;
	} catch (SQLException e) {
		System.err.println(e.getMessage());             
                 return false;  
        }               
     }

    @Override
    public boolean actualizar(Afp obj) throws Exception {

      String updateQuery = "UPDATE AFP SET AFP = ?, " +
			   "PORCENTAJE = ? WHERE ID = ?";
	try {
		pStmt = dbConnection.prepareStatement(updateQuery);		
		pStmt.setString(1, obj.getNombre());
		pStmt.setDouble(2, obj.getPorcentaje());
		pStmt.setInt(3, obj.getId());		
		pStmt.executeUpdate();
                   return true;
	} catch (SQLException e) {
		System.err.println(e.getMessage());
                 return false;
	}           
     
     
    }

    @Override
    public Afp buscarPorID(int id) throws Exception {
     Afp afp=new Afp();
     String query = "SELECT * FROM AFP WHERE ID = ?";   
      try {
                  pStmt = dbConnection.prepareStatement(query);            
		  pStmt.setInt(1,id);	
                  ResultSet rs = pStmt.executeQuery();                 
		while (rs.next()) {
			 afp.setId(rs.getInt(1));
			 afp.setNombre(rs.getString(2));
			 afp.setPorcentaje(rs.getDouble(3));			 	
		}
	} catch (SQLException e) {
		System.err.println(e.getMessage());
	}   
        return  afp;
    }


}


package com.dao;

import com.service.PaginaInterface;
import com.model.Pagina;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoPagina  implements PaginaInterface{
      PreparedStatement pStmt;  

    public DaoPagina() {
    }

    @Override
    public boolean eliminar(int id) throws Exception {
    String deleteQuery = "DELETE FROM PAGINA WHERE IDPAGINA = ?";
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
    List<Pagina> PaginaS = new ArrayList<Pagina>();        
	String query = "SELECT * FROM PAGINA";
	try {
		Statement stmt = dbConnection.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			Pagina pagina = new Pagina();
			pagina.setIdPagina(rs.getInt(1));
			pagina.setTitulo(rs.getString(2));
                        pagina.setUrl_(rs.getString(3));
			PaginaS.add(pagina);		}
	} catch (SQLException e) {
		System.err.println(e.getMessage());
	}
	return PaginaS; }

    @Override
    public boolean ingresar(Pagina obj) throws Exception {
   String insertQuery = "INSERT INTO PAGINA VALUES (PAGINA_SEQ.NextVal,?,?)";
       try {
        	pStmt = dbConnection.prepareStatement(insertQuery);             
		pStmt.setString(1, obj.getTitulo());
                pStmt.setString(2, obj.getUrl_());	
        	pStmt.executeUpdate();
            return true;      
	} catch (SQLException e) {
		System.err.println(e.getMessage());   
           return false;
	}     }

    @Override
    public boolean actualizar(Pagina obj) throws Exception {
    String updateQuery = "UPDATE PAGINA SET TITULO = ?, URL_ = ?  WHERE IDPAGINA  = ?";
	try {
		pStmt = dbConnection.prepareStatement(updateQuery);		
		pStmt.setString(1, obj.getTitulo());
		pStmt.setString(2, obj.getUrl_());
                pStmt.setInt(3, obj.getIdPagina());
		pStmt.executeUpdate();
                return true;
	} catch (SQLException e) {
		System.err.println(e.getMessage());
                return false;
	}    
  }

    @Override
    public Pagina buscarPorID(int id) throws Exception {
      Pagina pagina=new Pagina();
      String query = "SELECT * FROM PAGINA WHERE IDPAGINA = ?";   
      try {
                  pStmt = dbConnection.prepareStatement(query);            
		  pStmt.setInt(1,id);	
                  ResultSet rs = pStmt.executeQuery();                 
		while (rs.next()) {
			pagina.setIdPagina(rs.getInt(1));
			pagina.setTitulo(rs.getString(2));
                        pagina.setUrl_(rs.getString(3));				 	
		}
	} catch (SQLException e) {
		System.err.println(e.getMessage());
	}   
        return  pagina;  
    }
      
}

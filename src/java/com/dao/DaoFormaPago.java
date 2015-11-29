/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.FormaPago;
import com.service.FormaPagoInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoFormaPago implements FormaPagoInterface{
    PreparedStatement pStmt; 
    
    public DaoFormaPago() {
        
    }

    @Override
    public boolean eliminar(int id) throws Exception {
       String deleteQuery = "DELETE FROM FORMA_PAGO WHERE ID = ?";
	try {
		pStmt = dbConnection.prepareStatement(deleteQuery);
		pStmt.setInt(1, id);
		pStmt.executeUpdate();
                 return true;   
	} catch (SQLException e) {
		System.err.println(e.getMessage());
                return false;   
	}  }

    @Override
    public List listar() throws Exception {
       List<FormaPago> formas = new ArrayList<FormaPago>();        
	String query = "SELECT * FROM FORMA_PAGO";
	try {
		Statement stmt = dbConnection.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			FormaPago forma = new FormaPago();
			forma.setId(rs.getInt(1));
			forma.setFormaPago(rs.getString(2));                        
			formas.add(forma);		}
	} catch (SQLException e) {
		System.err.println(e.getMessage());
	}
	return formas; }

    @Override
    public boolean ingresar(FormaPago obj) throws Exception {
       String insertQuery = "INSERT INTO FORMA_PAGO VALUES (FORMA_PAGO_SEQ.NextVal,?)";
       try {
        	pStmt = dbConnection.prepareStatement(insertQuery);             
		pStmt.setString(1, obj.getFormaPago());		              
        	pStmt.executeUpdate();
            return true;      
	} catch (SQLException e) {
		System.err.println(e.getMessage());   
           return false;
	}      
    }

    @Override
    public boolean actualizar(FormaPago obj) throws Exception {
      String updateQuery = "UPDATE FORMA_PAGO SET FORMA_PAGO = ? WHERE ID  = ?";
	try {
		pStmt = dbConnection.prepareStatement(updateQuery);		
		pStmt.setString(1, obj.getFormaPago());
		pStmt.setInt(2, obj.getId());
		pStmt.executeUpdate();
                     return true;
	} catch (SQLException e) {
		System.err.println(e.getMessage());
                return false;
	}  
    }

    @Override
    public FormaPago buscarPorID(int id) throws Exception {
      FormaPago forma=new FormaPago();
     String query = "SELECT * FROM FORMA_PAGO WHERE ID = ?";   
      try {
                  pStmt = dbConnection.prepareStatement(query);            
		  pStmt.setInt(1,id);	
                  ResultSet rs = pStmt.executeQuery();                 
		while (rs.next()) {
			 forma.setId(rs.getInt(1));
			 forma.setFormaPago(rs.getString(2));						 	
		}
	} catch (SQLException e) {
		System.err.println(e.getMessage());
	}   
        return  forma;     
    }
    
    
    
    
    
}

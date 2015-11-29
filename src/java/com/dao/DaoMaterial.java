package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.DataAccessObject;
import com.model.Material;
import java.sql.CallableStatement;

public class DaoMaterial {

private Connection dbConnection;
private PreparedStatement pStmt;
private CallableStatement cst;


public DaoMaterial() {
	dbConnection = DataAccessObject.getConnection();
}

public void addMateriales(Material material) {
	String insertQuery = "INSERT INTO MATERIALES(CODIGO, ARTICULO, " +
			"U_MEDIDA, MARCA) VALUES (INCREMENTO_MATERIALES_SEQ.NextVal,?,?,?)";
	try {
		pStmt = dbConnection.prepareStatement(insertQuery);             
		pStmt.setString(1, material.getArticulo());
		pStmt.setString(2, material.getU_medida());
		pStmt.setString(3, material.getMarca());
		pStmt.executeUpdate();
	} catch (SQLException e) {
		System.err.println(e.getMessage());
	}
}

public void deleteMateriales(int codigo) {
	String deleteQuery = "DELETE FROM MATERIALES WHERE CODIGO = ?";
	try {
		pStmt = dbConnection.prepareStatement(deleteQuery);
		pStmt.setInt(1, codigo);
		pStmt.executeUpdate();
	} catch (SQLException e) {
		System.err.println(e.getMessage());
	}
}

public void updateMateriales(Material material)  {
	String updateQuery = "UPDATE MATERIALES SET ARTICULO = ?, " +
			"U_MEDIDA = ?, MARCA = ? WHERE CODIGO = ?";
	try {
		pStmt = dbConnection.prepareStatement(updateQuery);		
		pStmt.setString(1, material.getArticulo());
		pStmt.setString(2, material.getU_medida());
		pStmt.setString(3, material.getMarca());
		pStmt.setInt(4, material.getCodigo());
		pStmt.executeUpdate();

	} catch (SQLException e) {
		System.err.println(e.getMessage());
	}
}

public List<Material> getAllMateriales() {
	List<Material> materials = new ArrayList<Material>();

	String query = "SELECT * FROM MATERIALES ORDER BY CODIGO";
	try {
		Statement stmt = dbConnection.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			Material material = new Material();

			material.setCodigo(rs.getInt("CODIGO"));
			material.setArticulo(rs.getString("ARTICULO"));
			material.setU_medida(rs.getString("U_MEDIDA"));
			material.setMarca(rs.getString("MARCA"));
			materials.add(material);
		}
	} catch (SQLException e) {
		System.err.println(e.getMessage());
	}
	return materials;
}

public  int count(){
		int count = 0;		
		try {
                    String query = "SELECT COUNT(*) FROM MATERIALES";
		    Statement stmt = dbConnection.createStatement();           
	            ResultSet rs = stmt.executeQuery(query);
	    	    while (rs.next()){
	              count = rs.getInt(1);
    	             }
	    	    rs.close();

		} catch ( SQLException e) {
               System.out.println("SQLException getConnection -> Se genero la siguiente Excepcion : " + e.getMessage() );
                }	
		return count;
}



public List<Material> find(int from, int to, String sord, String sdix ) {
   //sdix indica la columna por la cual es ordenada la consulta
   //sord indica el orden 'ascendente' o descendente 
            List<Material> materiales = new ArrayList<Material>();
		
		String sql = "SELECT * FROM MATERIAL "; 
		String order = " ORDER BY ";
		String limit = " LIMIT ?,?"; // Propio de MySQL
		//http://dev.mysql.com/doc/refman/5.1/en/select.html
		
		
		// Armar la sentencia SQL 
		if ( ( sdix != null )  && ( !sdix.equals(""))) {
			sql = sql + order + sdix + " " + sord + limit;
		} else {
			sql = sql + limit;
		}
		
		System.out.println("SQL ---> " + sql );
		
		try {                
                          pStmt = dbConnection.prepareStatement(sql);
                          pStmt.setInt(1,from);
	                  pStmt.setInt(1,to);   		
	    		  ResultSet rs = pStmt.executeQuery();
                          
	    		while (rs.next()){
	    			Material  material= new Material();
	    			//setea los atributos 
                        material.setCodigo(rs.getInt("CODIGO"));
			material.setArticulo(rs.getString("ARTICULO"));
			material.setU_medida(rs.getString("U_MEDIDA"));
			material.setMarca(rs.getString("MARCA"));
			materiales.add(material);
                                
                                //agrego el objeto a la lista 
	    			materiales.add(material);
	    	    }
	            rs.close();
	            
	        } catch ( SQLException e) {
	            System.out.println("SQLException getConnection -> Se genero la siguiente Excepcion : " + e.getMessage() );
	        } 
		
		return materiales;
	}



        public List<Material> find(int from, int to, String condicion, String sord,String sdix) {
		// TODO Auto-generated method stub
		return null;
	}
        
   
        public Material buscaMatPorCodigo(int cod){
        Material material= new Material();        
          String query = "SELECT * FROM MATERIALES WHERE CODIGO = ?";   
         //String query  = "call buscaMaterialPorCodigo(?);";	
         try {
                  pStmt = dbConnection.prepareStatement(query);            
		  pStmt.setInt(1,cod);	
                  ResultSet rs = pStmt.executeQuery();                 
		while (rs.next()) {
			material.setCodigo(rs.getInt(1));
			material.setArticulo(rs.getString(2));
			material.setU_medida(rs.getString(3));
			material.setMarca(rs.getString(4));	
		}
	} catch (SQLException e) {
		System.err.println(e.getMessage());
	}   
        return material;
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
}

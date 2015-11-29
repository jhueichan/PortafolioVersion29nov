
package com.dao;
import com.model.Ciudad;
import com.model.FormaPago;
import com.model.Proveedor;
import com.service.ProveedorInterface;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class DaoProveedor implements ProveedorInterface{
    PreparedStatement pStmt;  
    DaoCiudad daoCiud= new DaoCiudad();
    DaoFormaPago daoFormaPag = new DaoFormaPago(); 
    public DaoProveedor() {
    }

    @Override
    public boolean eliminar(String rut) throws Exception {
       String deleteQuery = "DELETE FROM PROVEEDOR WHERE RUT = ?";
	try {
		pStmt = dbConnection.prepareStatement(deleteQuery);
		pStmt.setString(1, rut);
		pStmt.executeUpdate();
                 return true;   
	} catch (SQLException e) {
		System.err.println(e.getMessage());
                return false;   
	}   }

    @Override
    public List listar() throws Exception {
    List<Proveedor> proveedores = new ArrayList<Proveedor>();        
	String query = "SELECT * FROM PROVEEDOR";
	try {
		Statement stmt = dbConnection.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			Proveedor proveedor = new Proveedor();
			proveedor.setRut(rs.getString(1));
			proveedor.setRazon_social(rs.getString(2));
                        proveedor.setDireccion(rs.getString(3));
                        Ciudad ciud= daoCiud.buscarPorID(rs.getInt(4));                        
                        proveedor.setCiudad(ciud);                        
                        proveedor.setContacto(rs.getString(5));
                        proveedor.setTelefono(rs.getString(6));
                        proveedor.setEmail(rs.getString(7));
                        proveedor.setWebsite(rs.getString(8));                        
                        proveedor.setActivo(rs.getString(9));
                        FormaPago forma = daoFormaPag.buscarPorID(rs.getInt(10));
                        proveedor.setFormaPago(forma); 
			proveedores.add(proveedor);	
                }
	} catch (SQLException e) {
		System.err.println(e.getMessage());
	}
	return proveedores; }

    @Override
    public boolean ingresar(Proveedor obj) throws Exception {
       String insertQuery = "CALL INSERTAR_PROVEEDOR(?,?,?,?,?,?,?,?,?,?);";
       CallableStatement cstm=null;
       try { 
           cstm = dbConnection.prepareCall(insertQuery);
           cstm.setString(1, obj.getRut());
           cstm.setString(2, obj.getRazon_social());
           cstm.setString(3, obj.getDireccion());
           cstm.setInt(4, obj.getCiudad().getId());
           cstm.setString(5, obj.getContacto());
           cstm.setString(6, obj.getTelefono());
           cstm.setString(7, obj.getEmail());
           cstm.setString(8, obj.getWebsite());
           cstm.setString(9, obj.getActivo());
           cstm.setInt(10, ((FormaPago)obj.getFormaPago()).getId());
           cstm.execute();            
            return true;      
	} catch (SQLException e) {
		System.err.println(e.getMessage());   
           return false;
	}      
    }

    @Override
    public boolean actualizar(Proveedor obj) throws Exception {
     
        
        String updateQuery = "CALL actualizar_proveedor(?,?,?,?,?,?,?,?,?,?);";
        CallableStatement cstm=null;
	try {           
           cstm = dbConnection.prepareCall(updateQuery); 
           cstm.setString(1, obj.getRut());
           cstm.setString(2, obj.getRazon_social());
           cstm.setString(3, obj.getDireccion());
           cstm.setInt(4, obj.getCiudad().getId());
           cstm.setString(5, obj.getContacto());
           cstm.setString(6, obj.getTelefono());
           cstm.setString(7, obj.getEmail());
           cstm.setString(8, obj.getWebsite());
           cstm.setString(9, obj.getActivo());
           cstm.setInt(10, obj.getFormaPago().getId());        
           cstm.execute();          
                     return true;
	} catch (SQLException e) {
		System.err.println(e.getMessage());
                return false;
	}    
   }

@Override
    public Proveedor buscarPorID(String id) throws Exception {
      Proveedor proveedor=new Proveedor();
     String query = "SELECT * FROM PROVEEDOR WHERE RUT = ?";   
      try {
                  pStmt = dbConnection.prepareStatement(query);            
		  pStmt.setString(1,id);	
                  ResultSet rs = pStmt.executeQuery();                 
		while (rs.next()) {
			proveedor.setRut(rs.getString(1));
			proveedor.setRazon_social(rs.getString(2));
                        proveedor.setDireccion(rs.getString(3));
                        Ciudad ciud= daoCiud.buscarPorID(rs.getInt(4));                        
                        proveedor.setCiudad(ciud);                        
                        proveedor.setContacto(rs.getString(5));
                        proveedor.setTelefono(rs.getString(6));
                        proveedor.setEmail(rs.getString(7));
                        proveedor.setWebsite(rs.getString(8));                        
                        proveedor.setActivo(rs.getString(9));
                        FormaPago forma = daoFormaPag.buscarPorID(rs.getInt(10));
                        proveedor.setFormaPago(forma); 				 	
		}
	} catch (SQLException e) {
		System.err.println(e.getMessage());
	}   
        return  proveedor;      
    }
    
    
    
    
}

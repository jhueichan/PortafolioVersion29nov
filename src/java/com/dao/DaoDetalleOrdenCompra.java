
package com.dao;

import com.model.Empleado;
import com.model.DetalleOrdenCompra;
import com.model.Material;
import com.model.OrdenCompra;
import com.model.Proveedor;
import com.service.DetalleOrdenCompraInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoDetalleOrdenCompra implements DetalleOrdenCompraInterface {
    PreparedStatement pStmt;  
    DaoOrdenCompra daoOrdCom;
    DaoMaterial daoMat;
    
    public DaoDetalleOrdenCompra() {      
    }

    @Override
    public boolean eliminar(int ordenComp,int mat) throws Exception {
      String deleteQuery = "DELETE FROM MATER_OC "
              + "       WHERE ORDEN_COMPRA_NORDEN = ? "
              + "       AND  MATERIALES_CODIGO = ? ";
	try {
		pStmt = dbConnection.prepareStatement(deleteQuery);
		pStmt.setInt(1 , ordenComp);
                pStmt.setInt(2 , mat);
		pStmt.executeUpdate();
                return true;   
	} catch (SQLException e) {
		System.err.println(e.getMessage());
                return false;   
	}
        
    }

    @Override
    public List listar() throws Exception {
     List<DetalleOrdenCompra> ordenes = new ArrayList<DetalleOrdenCompra>();        
	String query = "SELECT * FROM MATER_OC";
	try {
		Statement stmt = dbConnection.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			DetalleOrdenCompra orden = new DetalleOrdenCompra();
                        
                        OrdenCompra ordeComp = daoOrdCom.buscarPorID(rs.getInt(1)); 
                        orden.setOrdenCompra(ordeComp);
                        Material mat=daoMat.buscaMatPorCodigo(rs.getInt(2));
                        orden.setMaterial(mat);
                        orden.setCantidad(rs.getInt(3));
                        orden.setUnidadMedida(rs.getString(4));
                        orden.setPrecioUnitario(rs.getDouble(5));
                        orden.setPrecioItem(rs.getDouble(6)); 
                        
			ordenes.add(orden);	
                }
	} catch (SQLException e) {
		System.err.println(e.getMessage());
	}
	return ordenes;
    }

    @Override
    public boolean ingresar(DetalleOrdenCompra obj) throws Exception {
       String insertQuery = "INSERT INTO MATER_OC VALUES (?,?,?,?,?,?)";
       try {
        	pStmt = dbConnection.prepareStatement(insertQuery); 
                
		pStmt.setInt(1, obj.getOrdenCompra().getNumero_orden());
                pStmt.setInt(2, obj.getMaterial().getCodigo());
                pStmt.setInt(3, obj.getCantidad());
                pStmt.setString(4, obj.getUnidadMedida());
                pStmt.setDouble(5,obj.getPrecioUnitario());
                pStmt.setDouble(6,obj.getPrecioItem());
                
                pStmt.executeUpdate();
            return true;      
	} catch (SQLException e) {
		System.err.println(e.getMessage());   
           return false;
	}         
     }

    @Override
    public boolean actualizar(DetalleOrdenCompra obj) throws Exception {
      String updateQuery = "UPDATE ORDEN_COMPRA SET  "
              +             "CANTIDAD = ?, U_MEDIDA = ? "
              +             "PRECIO_UNIT = ?, PRECIO_ITEM = ?  "              
              + "WHERE ORDEN_COMPRA_NORDEN = ? AND  MATERIALES_CODIGO = ? ";
	try {
		pStmt = dbConnection.prepareStatement(updateQuery);
                 pStmt.setInt(1, obj.getCantidad());
                pStmt.setString(2, obj.getUnidadMedida());
                  pStmt.setDouble(3,obj.getPrecioUnitario());
                 pStmt.setDouble(4,obj.getPrecioItem());                   
		pStmt.setInt(7, obj.getOrdenCompra().getNumero_orden());
                pStmt.setInt(8, obj.getMaterial().getCodigo());  
              
        
		pStmt.executeUpdate();
                     return true;
	} catch (SQLException e) {
		System.err.println(e.getMessage());
                return false;
	}
    }

    @Override
    public  DetalleOrdenCompra buscarPorID(int id) throws Exception {
     DetalleOrdenCompra orden=new DetalleOrdenCompra();
     String query = "SELECT * FROM MATER_OC"
                    + " WHERE ORDEN_COMPRA_NORDEN = ?"
                     + " AND  MATERIALES_CODIGO = ?";   
      try {
                  pStmt = dbConnection.prepareStatement(query);            
		  pStmt.setInt(1,id);	
                  ResultSet rs = pStmt.executeQuery();                 
		while (rs.next()) {
		        OrdenCompra ordeComp = daoOrdCom.buscarPorID(rs.getInt(1)); 
                        orden.setOrdenCompra(ordeComp);
                        Material mat=daoMat.buscaMatPorCodigo(rs.getInt(2));
                        orden.setMaterial(mat);
                        orden.setCantidad(rs.getInt(3));
                        orden.setUnidadMedida(rs.getString(4));
                        orden.setPrecioUnitario(rs.getDouble(5));
                        orden.setPrecioItem(rs.getDouble(6)); 	
                        
		}
	} catch (SQLException e) {
		System.err.println(e.getMessage());
	}   
        return  orden;   
    }


}

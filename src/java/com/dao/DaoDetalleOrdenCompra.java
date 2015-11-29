
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
    public boolean eliminar(int id) throws Exception {
      String deleteQuery = "DELETE FROM MATER_OC WHERE ORDEN_COMPRA_NORDEN = ?";
	try {
		pStmt = dbConnection.prepareStatement(deleteQuery);
		pStmt.setInt(1 , id);
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
                        Empleado empleado = daoEmpleado.buscarPorID(rs.getString(2));
			orden.setEmpleado(empleado);
                        Proveedor prov = daoProveedor.buscarPorID(rs.getString(3));
			orden.setProvedor(prov);  
                        orden.setFechaEntrega(rs.getDate(4));
                        orden.setLugarEntrega(rs.getString(5));
			ordenes.add(orden);	
                }
	} catch (SQLException e) {
		System.err.println(e.getMessage());
	}
	return ordenes;
    }

    @Override
    public boolean ingresar(DetalleOrdenCompra obj) throws Exception {
       String insertQuery = "INSERT INTO ORDEN_COMPRA VALUES (OCOMPRA_SEQ.NextVal,?,?,?,?)";
       try {
        	pStmt = dbConnection.prepareStatement(insertQuery);             
		pStmt.setString(1, obj.getEmpleado().getRut());
                pStmt.setString(2, obj.getProvedor().getRut());
                pStmt.setDate(3, obj.getFechaEntrega());
                pStmt.setString(4, obj.getLugarEntrega());
        	pStmt.executeUpdate();
            return true;      
	} catch (SQLException e) {
		System.err.println(e.getMessage());   
           return false;
	}         
     }

    @Override
    public boolean actualizar(DetalleOrdenCompra obj) throws Exception {
      String updateQuery = "UPDATE ORDEN_COMPRA SET EMPLEADO_RUT = ? PROVEEDOR_RUT = ?"
              +             "FECHA_ENTREGA = ?,LUGAR_ENTREGA = ?  WHERE NORDEN = ?";
	try {
		pStmt = dbConnection.prepareStatement(updateQuery);
                
		pStmt.setString(1, obj.getEmpleado().getRut());
                pStmt.setString(2, obj.getProvedor().getRut());
                pStmt.setDate(3, obj.getFechaEntrega());
                pStmt.setString(4, obj.getLugarEntrega());                
               pStmt.setString(5, obj.getLugarEntrega());
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
     String query = "SELECT * FROM ORDEN_COMPRA WHERE NORDEN = ?";   
      try {
                  pStmt = dbConnection.prepareStatement(query);            
		  pStmt.setInt(1,id);	
                  ResultSet rs = pStmt.executeQuery();                 
		while (rs.next()) {
			 orden.setNumero_orden(rs.getInt(1));
                        Empleado empleado = daoEmpleado.buscarPorID(rs.getString(2));
			orden.setEmpleado(empleado);
                        Proveedor prov = daoProveedor.buscarPorID(rs.getString(3));
			orden.setProvedor(prov);  
                        orden.setFechaEntrega(rs.getDate(4));
                        orden.setLugarEntrega(rs.getString(5));	
                        
		}
	} catch (SQLException e) {
		System.err.println(e.getMessage());
	}   
        return  orden;   
    }


}

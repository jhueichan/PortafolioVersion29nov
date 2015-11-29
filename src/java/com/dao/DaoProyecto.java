
package com.dao;
import com.model.Empleado;
import com.model.Proyecto;
import com.service.ProyectoInterfaz;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DaoProyecto implements ProyectoInterfaz{
 DaoEmpleado daoEmpleado;
 PreparedStatement pStmt;  
public DaoProyecto() {        
   }

    @Override
    public boolean eliminar(int id) throws Exception {
        String deleteQuery = "DELETE FROM PROYECTO WHERE ID = ?";
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
       List<Proyecto> proyectos = new ArrayList<Proyecto>();
      	String query = "SELECT * FROM PROYECTO ORDER BY ID";
	try {
		Statement stmt = dbConnection.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
                    Empleado emp1 = new Empleado();
                    Empleado emp2 = new Empleado();                    
	            Proyecto proyecto = new Proyecto();
                    
                    proyecto.setId(rs.getInt(1));
                    proyecto.setUbicacion(rs.getString(2));
                    proyecto.setDescripcion(rs.getString(3));
                    proyecto.setFecha_inicio(rs.getDate(4));
                    proyecto.setFecha_termino(rs.getDate(5));
                    emp1=daoEmpleado.buscarPorID(rs.getString(6));
                    proyecto.setIngeniero_originador(emp1);
                    emp2=daoEmpleado.buscarPorID(rs.getString(7));
                    proyecto.setJefe_proyecto(emp2);
                    proyecto.setNombre(rs.getString(8));
		}
	} catch (SQLException e) {
		System.err.println(e.getMessage());
	}
	return proyectos;   
    }

    @Override
    public boolean ingresar(Proyecto proyecto) throws Exception {
     
        String insertQuery = "INSERT INTO PROYECTO VALUES (PROYECTO_SEQ,?,?,?,?,?,?,?)";
       try {
             	pStmt = dbConnection.prepareStatement(insertQuery);
                
		pStmt.setString(1, proyecto.getUbicacion());
		pStmt.setString(2, proyecto.getDescripcion());
		pStmt.setDate(3, proyecto.getFecha_inicio());
                pStmt.setDate(4, proyecto.getFecha_termino()); 
                pStmt.setString(5, proyecto.getIngeniero_originador().getRut());                
                pStmt.setString(6, proyecto.getJefe_proyecto().getRut());
                pStmt.setString(7, proyecto.getNombre());                
        	pStmt.executeUpdate();
                return true;
	} catch (SQLException e) {
		System.err.println(e.getMessage());               
	}         
       return true;
    }

    @Override
    public boolean actualizar(Proyecto obj) throws Exception {
       Proyecto proyecto=(Proyecto)obj;
      String updateQuery = "UPDATE PROYECTO SET UBICACION = ?, " +
			   "DESCRIPCION = ?, FECHA_INICIO = ?, "+
                            "FECHA_TERMINO = ?, INGENIERO_ORIGINADOR = ?, "+
                           "JEFE_PROYECTO = ?, NOMBRE = ? "+ 
                           " WHERE ID = ?";
	try {
		pStmt = dbConnection.prepareStatement(updateQuery);		
		pStmt.setString(1, proyecto.getUbicacion());
		pStmt.setString(2, proyecto.getDescripcion());
		pStmt.setDate(3, proyecto.getFecha_inicio());
		pStmt.setDate(4, proyecto.getFecha_termino());
                pStmt.setString(5, proyecto.getIngeniero_originador().getRut());
		pStmt.setString(6, proyecto.getJefe_proyecto().getRut());
		pStmt.setString(7, proyecto.getNombre());
		pStmt.setInt(8, proyecto.getId());
		pStmt.executeUpdate();
                return true;
	} catch (SQLException e) {
		System.err.println(e.getMessage());
                return false;
	}           
    }

    @Override
    public Proyecto buscarPorID(int id) throws Exception {
      Proyecto proyecto=new Proyecto();
     String query = "SELECT * FROM PROYECTO WHERE ID = ?";   
      try {
                  pStmt = dbConnection.prepareStatement(query);            
		  pStmt.setInt(1,id);	
                  ResultSet rs = pStmt.executeQuery();                 
		while (rs.next()) {                    
                    Empleado emp1 = new Empleado();
                    Empleado emp2 = new Empleado();                  
                    proyecto.setId(rs.getInt(1));
                    proyecto.setUbicacion(rs.getString(2));
                    proyecto.setDescripcion(rs.getString(3));
                    proyecto.setFecha_inicio(rs.getDate(4));
                    proyecto.setFecha_termino(rs.getDate(5));
                    emp1=daoEmpleado.buscarPorID(rs.getString(6));
                    proyecto.setIngeniero_originador(emp1);
                    emp2=daoEmpleado.buscarPorID(rs.getString(7));
                    proyecto.setJefe_proyecto(emp2);
                    proyecto.setNombre(rs.getString(8));
		}
	} catch (SQLException e) {
		System.err.println(e.getMessage());
	}   
        return  proyecto;   
    }
    
}

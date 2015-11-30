/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.action;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author christian
 */
public class IngresoAction extends ActionSupport{
 
private String email_usuario;
private String clave;

    public String getEmail_usuario() {
        return email_usuario;
    }

    public void setEmail_usuario(String email_usuario) {
        this.email_usuario = email_usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
 
    
    public String validar() throws SQLException, ClassNotFoundException{
        String ir = ERROR;
        boolean status=false; 
       //Class.forName("oracle.jdbc.driver.OracleDriver");
       Class.forName("oracle.jdbc.driver.OracleDriver");
   Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","PORTAFOLIO","1234");  
     
   PreparedStatement ps=con.prepareStatement("select * from usuario where email_usuario=? and clave=?");  
   ps.setString(1,email_usuario);  
   ps.setString(2,clave);  
   ResultSet rs=ps.executeQuery();  
   status=rs.next();  
        if (status) {
            ir = SUCCESS;
        }
        return ir;
    }
}

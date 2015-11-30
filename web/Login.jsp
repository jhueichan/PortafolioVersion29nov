<%-- 
    Document   : index
    Created on : 26-nov-2015, 2:14:29
    Author     : christian vera 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login con oracle</h1>
        
        <s:form action="login" >
            <s:textfield name="email_usuario" label="Ingrese Usuario" />
            <s:password name="clave" label="Ingrese contraseña"/>
            <s:submit value="Ingresar"/>
        </s:form>
    </body>
</html>

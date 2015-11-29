<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>           
        <%@include file="header.txt" %>
        <%@include file="footer.txt" %>
        <sj:head jqueryui="true" jquerytheme="start"/> 
        <meta charset=UTF-8">
        <title>Gestion de Empleados</title>
    </head>
    <body>
         <div id="wrapper">
            <%@include file="menu.jspf" %>
            <div id="page-wrapper">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-12">
                    
                        <sj:tabbedpanel id="tabs" cssClass="list">
                                <sj:tab id="tabIngresarEmpleados_" target="tabIngresarEmpleados" label="lista de Empleados" />
                                                             
                                <div id="tabIngresarEmpleados">                          
                                    <s:form action="ingresarMaterial" theme="bootstrap" label="Ingrese los datos" >
                                        <s:textfield
                                            label="Rut"
                                            name="rut"/>
                                        <s:textfield
                                            label="Nombres"
                                            name="nombres"/>
                                       <s:textfield
                                            label="Apellidos"
                                            name="apellidos"/>
                                         <s:textfield
                                            label="Direccion"
                                            name="direccion"/>  
                                         <s:select
                                            label="Seleccione Ciudad"
                                            list="ciudades"
                                            name="idCiudad"
                                            emptyOption="true"
                                            headerKey="None"
                                            headerValue="Ninguno"/>    
                                       
                                         
                                         
                                         
                                         
                                         
                                         
                                         
                                         
                                         
                                        <br>
                                        <s:submit value="Grabar datos" cssClass="btn btn-primary"/>
                                    </s:form>                         
                               </div>
                               </sj:tabbedpanel>              
                         
                        </div>

                    </div><!-- /.row -->  
                </div> <!-- /.container-fluid -->
            </div> <!-- /#page-wrapper -->
        </div>  <!-- /#wrapper -->
 
    </body>
</html>

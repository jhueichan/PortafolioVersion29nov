<!--

Autor: christian Vera N
Hora: 15:54

-->

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
        <title>Gestion de Proveedores</title>
    </head>
    <body>
         <div id="wrapper">
            <%@include file="menu.jspf" %>
            <div id="page-wrapper">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-12">
                    
                        <sj:tabbedpanel id="tabs" cssClass="list">
                                
                                <sj:tab id="ingreso_cotizacion" target="tabIngresarCotizacion" label="Ingresar Cotizacion"/>
                                <sj:tab id="lista_cotizacion" target="tabListaCotizacion" label="lista de Cotizaciones " />
                                <sj:tab id="modificacion_cotizacion" target="tabModificarCotizacion" label="Modificar Cotizacion"/>    
                          
                                <div id="tabListaCotizacion">
                                  <h3>Lista de Cotizaciones
                                  </h3>
                                    <table class="table table-bordered">
                                        <thead>
                                        <th>rut</th>
                                        <th>Razon Social</th>
                                        <th>Direcciòn</th>
                                        <th>Contacto</th>
                                        <th>Telefono</th>
                                        <th>E-mail</th>
                                        <th>Sitio Web</th>
                                        <th>Activo</th>
                                        <th>Ciudad</th>
                                        <th>Forma de pago</th
                                        <th>Acciones</th>
                                        
                                        </thead>
                                        <tbody>

                                            <s:iterator value="records" var="dato" status="estado">
                                                <tr>
                                                    <!-- los nombre de valores de las propiedades deben ser los mismos que en la clase del modelo-->
                                                    <td><s:property value="rut" /></td>
                                                    <td><s:property value="razon_social" /></td>
                                                    <td><s:property value="direccion" /></td>
                                                    <td><s:property value="contacto" /></td>
                                                    <td><s:property value="telefono" /></td>
                                                    <td><s:property value="email" /></td>
                                                    <td><s:property value="website" /></td>
                                                    <td><s:property value="activo" /></td>
                                                    <td><s:property value="ciudad" /></td>
                                                    <td><s:property value="formaPago" /></td>
                                                    
                                                    <td>
                                                        <s:url id="url" action="buscaPorCodigo">
                                                                <s:param name="rut">
                                                                    <s:property value="rut"></s:property>                                                                    
                                                                </s:param>                                                               
                                                        </s:url>
                                                        <s:a href="%{url}" cssClass="fs1" aria-hidden="true"  onclick="agregaYactivaPestana()">Actualizar</s:a>
                                                            
                                                            
                                                        <s:a action="eliminarProveedor">
                                                            <s:param name="rut" value="Rut" />
                                                            <i class="glyphicon glyphicon-trash"></i>
                                                        </s:a>    
                                                    </td>
                                                    
                                                 
                                                    
                                                </tr>
                                            </s:iterator>
                                        </tbody>
                                    </table>  
                                </div>
                                
                                <div id="tabIngresarCotizacion">                          
                                    <s:form action="ingresarProveedor" theme="bootstrap" label="Ingrese Cotizaciòn" >
                                        <s:textfield label="Rut" name="rut"/>
                                        <s:textfield label="Razon Social" name="razon_social"/>
                                        <s:textfield label="Direcciòn" name="direccion"/>
                                        <s:textfield label="Contacto" name="contacto"/>
                                        <s:textfield label="Telefono" name="telefono"/>
                                        <s:textfield label="E-Mail" name="email"/>
                                        <s:textfield label="Sitio Web" name="website"/>
                                        <s:textfield label="Activo" name="activo"/>
                                        <s:textfield label="Ciudad" name="ciudad"/>
                                        <s:textfield label="Forma de Pago" name="formaPago"/>
                                          
                                        <br>
                                        <s:submit value="Grabar datos" cssClass="btn btn-primary"/>
                                    </s:form>                         
                               </div>
                                
                                
                             <div id="tabModificarCotizacion">                                
                               
                                 <s:form action="actualizarProveedor"  theme="bootstrap">   
                                    <s:textfield name="rut" label="Rut" value="%{record.rut}"  readonly="true"></s:textfield>
                                    <s:textfield name="razon_social" label="Razon Social" value="%{record.razon_social}"></s:textfield>
                                    <s:textfield name="direccion" label="Direcciòn" value="%{record.direccion}"></s:textfield>            
                                    <s:textfield name="contacto" label="Contacto" value="%{record.contacto}"></s:textfield>
                                    <s:textfield name="telefono" label="Telefono" value="%{record.telefono}"></s:textfield>
                                    <s:textfield name="email" label="E-Mail" value="%{record.email}"></s:textfield>
                                    <s:textfield name="website" label="Sitio Web" value="%{record.website}"></s:textfield>
                                    <s:textfield name="activo" label="Activo" value="%{record.activo}"></s:textfield>
                                    <s:textfield name="ciudad" label="Ciudad" value="%{record.ciudad}"></s:textfield>
                                    <s:textfield name="formaPago" label="Forma de Pago" value="%{record.formaPago}"></s:textfield>
                                    <s:submit value="Actualizar"></s:submit>
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


<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>           
        <%@include file="header.txt" %>
        <%@include file="footer.txt" %>
      
         <sj:head jqueryui="true" jquerytheme="start"/> 
        <meta charset=UTF-8">
        <title>Proyectos</title>
    </head>
    <body>
        <div id="wrapper">
            <%@include file="menu.jspf" %>
            <div id="page-wrapper">
                <div class="container-fluid">
                    <div class="row"> 
                        <div col-lg-12>
                            <sj:tabbedpanel id="localtabs" cssClass="list">
                                <sj:tab id="tab1" target="tabIngresar" label="Agregar nuevo Proyecto"/>
                                <sj:tab id="tab2" target="tabConsulta" label="Consulta de Proyectos"/>
                                <sj:tab id="tab3" target="tabModificar" label="Modificar Proyecto"/>
                           

                                <div id="tabIngresar">
                                    <s:form action="IngresarProyecto" theme="bootstrap" label="Ingrese los datos">
                                        <s:textfield
                                            label="Nombre del proyecto"
                                            name="nomProyecto"/>
                                        <s:textfield
                                            label="Ubicacion del Proyecto"
                                            name="ubiProyecto"/>
                                       <sj:spinner name="sto" label="Stock"  readonly="false" max="100" min="0" tooltip="Ingresar una cantidad" />
                                    <s:textarea
                                            label="Descripcion del Proyecto"
                                            name="descProyecto"
                                            cols="40"
                                            rows="3"/>
                                        <sj:datepicker name="fechIniProyecto" label="Fecha Inicio"  displayFormat="dd/mm/yy"></sj:datepicker>
                                        <sj:datepicker name="fechTermProyecto" label="Fecha Término"  displayFormat="dd/mm/yy"></sj:datepicker>
                                       
                                        <s:select
                                            label="Seleccione jefe Proyecto"
                                            list="{'Jorge', 'Carlos', 'Cristian','Milton','Cristobal'}"
                                            name="jefProyecto"
                                            emptyOption="true"
                                            headerKey="None"
                                            headerValue="Ninguno"/>       
                                        <br>
                                        <s:submit value="Grabar datos" cssClass="btn btn-primary"/>
                                    </s:form>
                                </div>
                                <div id="tabConsulta">                                   
                                           
                                  <table class="table table-bordered">
                                        <thead>
                                        <th>Código</th>
                                        <th>Ubicación</th>
                                        <th>Descripción</th>
                                        <th>Fecha Inicio</th>
                                        <th>Fecha Término</th>
                                        <th>Ingeniero Originador</th>
                                        <th>Jefe Proyecto</th>
                                        <th>Acciones</th>
                                        </thead>
                                        <tbody>
                                         <s:iterator value="records" var="dato" status="estado">
                                                <tr>
                                                    <!-- los nombre de valores de las propiedades deben ser los mismos que en la clase del modelo-->
                                                    <td><s:property value="id" /></td>
                                                    <td><s:property value="nombre" /></td>                                          
                                                    <td><s:property value="ubicacion" /></td>
                                                    <td><s:property value="descripcion" /></td>
                                                    <td>
                                                           <s:url id="url" action="buscaPorCodigo">
                                                                <s:param name="codigoMaterial">
                                                                    <s:property value="codigo"></s:property>                                                                    
                                                                </s:param>                                                               
                                                            </s:url>
                                                        <s:a href="%{url}" cssClass="fs1" aria-hidden="true"  onclick="agregaYactivaPestana()">Actualizar</s:a>
                                                            
                                                            
                                                        <s:a action="eliminarMaterialAccion">
                                                            <s:param name="codigo" value="codigo" />
                                                            <i class="glyphicon glyphicon-trash"></i>
                                                        </s:a>    
                                                    </td>
                                                </tr>
                                            </s:iterator>
                                         
                                        </tbody>
                                    </table>  
                                    
                                </div>
                                <div id="tabModificar">
                                </div>
                             </sj:tabbedpanel>                         
                        </div>                  
                    </div>                   
                </div> <!-- /.container-fluid -->
            </div> <!-- /#page-wrapper -->
        </div>  <!-- /#wrapper -->    
    </body>
</html>

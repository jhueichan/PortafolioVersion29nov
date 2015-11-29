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
        <title>Gestion de Materiales</title>
    </head>
    <body>
        <div id="wrapper">
            <%@include file="menu.jspf" %>
            <div id="page-wrapper">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-12">
                    
                        <sj:tabbedpanel id="tabs" cssClass="list">
                                <sj:tab id="lista_materiales" target="tabListaMateriales" label="lista de Materiales" />
                                <sj:tab id="ingreso_materiales" target="tabIngresarMateriales" label="Ingresar Materiales"/>
                                <sj:tab id="modificacion_materiales" target="tabModificarMateriales" label="Modificar Materiales" ondblclick=""/>    

                                <div id="tabListaMateriales">
                                  <h3>Materiales de Construcción </h3>
                                    <table class="table table-bordered">
                                        <thead>
                                        <th>Codigo</th>
                                        <th>Articulo</th>
                                        <th>Unidad Medida</th>
                                        <th>Marca</th>
                                        <th>Acciones</th>
                                        </thead>
                                        <tbody>

                                            <s:iterator value="records" var="dato" status="estado">
                                                <tr>
                                                    <!-- los nombre de valores de las propiedades deben ser los mismos que en la clase del modelo-->
                                                    <td><s:property value="codigo" /></td>
                                                    <td><s:property value="articulo" /></td>                                          
                                                    <td><s:property value="u_medida" /></td>
                                                    <td><s:property value="marca" /></td>
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
                                
                                
                                <div id="tabIngresarMateriales">                          
                                    <s:form action="ingresarMaterial" theme="bootstrap" label="Ingrese los datos" >
                                        <s:textfield
                                            label="Artículo"
                                            name="articulo"/>
                                        <s:textfield
                                            label="Unidad de medida"
                                            name="u_medidasd"/>
                                       <s:textfield
                                            label="Marca"
                                            name="marca"/>    
                                        <br>
                                        <s:submit value="Grabar datos" cssClass="btn btn-primary"/>
                                    </s:form>                         
                               </div>
                                
                                
                             <div id="tabModificarMateriales">                                
                               
                                 <s:form action="actualizaMaterial"  theme="bootstrap">   
                                    <s:textfield name="codigo" label="Código" value="%{record.codigo}"  readonly="true"></s:textfield>
                                    <s:textfield name="articulo" label="Artículo" value="%{record.articulo}"></s:textfield>
                                    <s:textfield name="u_medida" label="Unidad de Medida" value="%{record.u_medida}"></s:textfield>            
                                    <s:textfield name="marca" label="Marca" value="%{record.marca}"></s:textfield>
                                    <s:submit value="Actualizar"></s:submit>
                                 </s:form>
                               <!---  < //s:url var="remoteurl" action="jsontable"/>
                                    <#/ sjg:grid
                                        id="gridtable"
                                        caption="Customer Examples"
                                        dataType="json"
                                        href="%{remoteurl}"
                                        pager="true"
                                        gridModel="gridModel"
                                        rowList="10,15,20"
                                        rowNum="15"
                                        rownumbers="true"
                                        >
                                        <#sjg:gridColumn name="codigo" index="codigo" title="Código" formatter="integer" sortable="false"/>
                                        <#/sjg:grid>
                                  -->
                                </div> 
                                    
                                    
                               </sj:tabbedpanel>              
                         
                        </div>

                    </div><!-- /.row -->  
                </div> <!-- /.container-fluid -->
            </div> <!-- /#page-wrapper -->
        </div>  <!-- /#wrapper -->
 
    </body>
</html>

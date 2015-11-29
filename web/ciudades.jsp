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
        <title>Gestion de Ciudades</title>
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
                          
                                <div id="tabListaMateriales">
                                  <h3>Lista de Ciudades
                                  </h3>
                                    <table class="table table-bordered">
                                        <thead>
                                        <th>id</th>
                                        <th>nombre</th>
                                        
                                        </thead>
                                        <tbody>

                                            <s:iterator value="records" var="dato" status="estado">
                                                <tr>
                                                    <!-- los nombre de valores de las propiedades deben ser los mismos que en la clase del modelo-->
                                                    <td><s:property value="id" /></td>
                                                    <td><s:property value="nombre" /></td>                                          
                                                    
                                                </tr>
                                            </s:iterator>
                                        </tbody>
                                    </table>  
                                </div>
           
                               </sj:tabbedpanel>              
                         
                        </div>

                    </div><!-- /.row -->  
                </div> <!-- /.container-fluid -->
            </div> <!-- /#page-wrapper -->
        </div>  <!-- /#wrapper -->
 
    </body>
</html>

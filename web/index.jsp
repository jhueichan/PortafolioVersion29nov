
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<!DOCTYPE html>
<html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
    <link href="css/bootstrap.min.css" rel="stylesheet">   
    <link href="css/sb-admin.css" rel="stylesheet"> 
    <link href="css/plugins/morris.css" rel="stylesheet">  
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
   
    
    
    <title>Sistema Web Vialis</title>
      <sj:head jqueryui="true"/>
      <sj:head jqueryui="true" jquerytheme="blitzer"></sj:head>
    </head>
    <body>
         <div id="wrapper">
        <!-- Navigation desde el archivo menu.jspf -->
         <%@include file="menu.jspf" %>
        
        <!--  comienzo del cntenedor dinámico -->
        <div id="page-wrapper">
            <div class="container-fluid">
                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-4">
                        <h1 class="page-header">
                            Dashboard <small>Statistics Overview</small>
                        </h1>
                        <ol class="breadcrumb">
                            <li class="active">
                                <i class="fa fa-dashboard"></i> Dashboard
                            </li>
                        </ol>
                        
                        
                      

                    </div>
                      <div class="col-lg-4">
                        <h1 class="page-header">
                            Dashboard <small>Statistics Overview</small>
                        </h1>
                        <ol class="breadcrumb">
                            <li class="active">
                                <i class="fa fa-dashboard"></i> Dashboard
                            </li>
                        </ol>
                        
                        
                      

                    </div>
                    <div class="col-lg-4">
                     <h1 class="page-header">
                            Dashboard <small>Statistics Overview</small>
                        </h1>
                        <ol class="breadcrumb">
                            <li class="active">
                                <i class="fa fa-dashboard"></i> Dashboard
                            </li>
                        </ol>
                         <% //@ include file="dePrueba.jsp" %> 
                   </div>
                </div><!-- /.row -->   

            </div> <!-- /.container-fluid -->

        </div> <!-- /#page-wrapper -->

    </div><!-- /#wrapper -->  
    
      <%@include file="footer.txt" %>
    </body>
</html>

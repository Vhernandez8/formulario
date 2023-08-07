<%-- 
    Document   : salida
    Created on : 23-07-2023, 06:08:08
    Author     : victor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <div><link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"></div>
        <div><link href="css.css" rel="stylesheet" type="text/css"></div>
        <title>Tasa De Interes</title>
    </head>
    <body>
        <h1>Resultado de Datos</h1>
       <div><table align="center" Table BORDER="4" CELLSPACING="2"
       WIDTH="100" size="50">
       <th> 
        <%
            String nombre = (String) request.getAttribute("nombre");
            String apellido = (String) request.getAttribute("apellido");
            String direccion = (String) request.getAttribute("direccion");
            String correo = (String) request.getAttribute("correo");
           
      
        %>
           <tr>
           <td><p>Hola <%=nombre%>, El Resultado de Tus datos es:</td>
           </tr>
           <tr>
            <td><p>nombre: <%=nombre%> </td>
            </tr>
            <tr>
            <td><p>apellido:<%=apellido%></p></td>
            </tr>
            <tr>
            <td><p>direccion:<%=direccion%></p></td>
            </tr>
            <tr>
            <td>><p>correo:<%=correo%></p></td>
            </tr>
    </body>
</html>
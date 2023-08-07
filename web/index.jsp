<%-- 
    Document   : index
    Created on : 23-07-2023, 05:38:27
    Author     : victor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <title>Identificacion</title>
        <div><link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"></div>
    <div><link href="css.css" rel="stylesheet" type="text/css"></div>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
       <div><table align="center" Table BORDER="4" CELLSPACING="2"
       WIDTH="100" size="50">
       <th> 
       <div><h1>DATOS DE IDENTIFICACION</h1></div>
       </th>
        <br>
        <br>
       <form action="controller" method="POST">
       <tr>
       <br>
       <td>nombre: <input type="text" name="nombre" value="" size="9"  /></td>
       </tr>
       <tr> 
       <td>apellido: <input type="text" name="apellido" value="" size="9"/></td> 
        </tr>
        <tr>
       <td>direccion: <input type="text" name="direccion" value="" size="9"  /></td>
       </tr>
        <tr>
        <td>correo: <input type="text" name="correo" value="" size="9"/></td>
        <tr>
        <br>
         <tr>
      <td><input type="submit" value="Calcular datos" /></td>
        </form>
    </tr>
    </td>
    </body>
</html>
    </tbody>
</table>

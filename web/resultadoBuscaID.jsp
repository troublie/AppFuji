<%-- 
    Document   : resultadoBuscaID
    Created on : Jan 10, 2017, 11:08:45 AM
    Author     : juliano.lopes
--%>
<%@page import="fuji.entities.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultado</title>
    </head>
    <body>
        <h1>Resultado da busca por ID</h1>
        <% Usuario usuario = (Usuario) request.getAttribute("usuarioID");%>
        <table>
            <tr>
                <td><%=usuario.getId()%></td>
                <td><%=usuario.getUsuarioFirstName()%></td>
                <td><%=usuario.getUsuarioLastName()%></td>
            </tr>
        </table>
    </body>
</html>

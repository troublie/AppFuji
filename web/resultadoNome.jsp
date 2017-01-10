<%-- 
    Document   : resultadoNome
    Created on : Jan 10, 2017, 11:18:32 AM
    Author     : juliano.lopes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Collection"%>
<%@page import="fuji.entities.Usuario"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type"
              content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Resultado da busca pelo nome</h1>
        <%
            Collection<Usuario> usuarios = (Collection<Usuario>) request.getAttribute("nome");
        %>
        <%if (!usuarios.isEmpty()) { %>
        <table>
            <% for (Usuario u : usuarios) {%>
            <tr>
                <td><%=u.getUsuarioFirstName()%></td>
                <td><%=u.getUsuarioLastName()%></td>
            </tr>
            <%}%>
        </table>
        <%}%>
    </body>
</html>

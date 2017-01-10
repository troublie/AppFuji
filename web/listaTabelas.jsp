<%-- 
    Document   : listaTabelas
    Created on : Jan 10, 2017, 1:52:36 PM
    Author     : juliano.lopes
--%>

<%@page import="fuji.entities.TabelaPreco"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type"
              content="text/html; charset=UTF-8">
        <title>Lista de Tabelas</title>
    </head>
    <body>
        <h1>Tabelas:</h1>
        <%
            List<TabelaPreco> tabelas
                    = (List<TabelaPreco>) request.getAttribute("tabelas");
        %>

        <% if (tabelas.size() == 0) { %>
        <h1>Não há tabelas cadastradas!</h1>
        <% } %>

        <%if (tabelas.size() > 0) { %>
        <table>
            <% for (TabelaPreco t : tabelas) {%>
            <tr>
                <td>ID: <%=t.getId()%> |</td>
                <td><%=t.getNome()%></td>
                <td><%=t.getDuhn()%> |</td>
                <td><%=t.getDuhe()%> |</td>
                <td><%=t.getDuhe2()%> |</td>
                <td><%=t.getDdu()%> |</td>
                <td><%=t.getFshn()%> |</td>
                <td><%=t.getFshe()%> |</td>
                <td><%=t.getFshe2()%> |</td>
                <td><%=t.getDfs()%> |</td>
            </tr>
            <%}%>
        </table>
        <%}%>
    </body>
</html>

<%-- 
    Document   : index
    Created on : 04/10/2020, 23:30:57
    Author     : bruno
--%>

<%@page import="br.fatecpg.poo.Disciplina"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="WEB-INF/jspf/menu.jspf" %>
        <h3>Início</h3>
        <h4>Bruno Pereira Tyba</h4>
        <h4>Matricula: 1290481823005</h4>
        <h4>Quantidade de disciplinas matriculadas: <%= Disciplina.getList().size() %> </h4>
    </body>
</html>

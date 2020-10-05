<%-- 
    Document   : disciplinas
    Created on : 04/10/2020, 23:31:16
    Author     : bruno
--%>

<%@page import="br.fatecpg.poo.Disciplina"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>P1 - POO</title>
    </head>
    <body>
        <%if(request.getParameter("salvar")!= null){
            int nota = Integer.parseInt(request.getParameter("nota"));
            int codigo = Integer.parseInt(request.getParameter("codigo"));
            Disciplina alterarNota = Disciplina.getList().get(codigo);
            alterarNota.setNota(nota);
        }%>
        <%@include file="WEB-INF/jspf/menu.jspf" %>
        <h3>Minhas Disciplinas</h3>
        <table border="1">
            <tr>
                <th>Disciplina</th>
                <th>Ementa</th>
                <th>Ciclo</th>
                <th>Nota</th>
                <th>Alterar nota</th>
            </tr>
            <% for(int i=0; i < Disciplina.getList().size(); i++ ){
                Disciplina disciplina = Disciplina.getList().get(i);%>
                <tr>
                    <td><%=disciplina.getNome()%></td>
                    <td><%=disciplina.getEmenta()%></td>
                    <td><%=disciplina.getCiclo()%>º Ciclo</td>
                    <td><%=disciplina.getNota()%></td>
                    <td>
                        <form method="get">
                            <input type="number" name="nota" value="<%=disciplina.getNota()%>"/>
                            <input type="submit" name="salvar" value="Salvar"/>
                            <input type="hidden" name="codigo" value="<%= i%>"/>
                        </form>
                    </td>
                </tr>
            <%}%>
        </table>
    </body>
</html>

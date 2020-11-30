<%-- 
    Document   : disciplinas
    Created on : 04/10/2020, 23:31:16
    Author     : bruno
--%>

<%@page import="br.fatecpg.poo.Disciplina"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String exceptionMessage = null;
    if(request.getParameter("Cancelar") != null){
        response.sendRedirect(request.getRequestURI());
    }
    
    if(request.getParameter("formInsert") != null){
        try{
            String nome = request.getParameter("nome");
            String ementa = request.getParameter("ementa");
            int ciclo = Integer.parseInt(request.getParameter("ciclo"));
            double nota = Double.parseDouble(request.getParameter("nota"));
            Disciplina.insert(nome, ementa, ciclo, nota);
            response.sendRedirect(request.getRequestURI());
        }catch(Exception ex){
            exceptionMessage = ex.getLocalizedMessage();
        }
    }
    
    if(request.getParameter("formUpdate")!=null){
        try{
            long rowId = Long.parseLong(request.getParameter("rowId"));
            String nome = request.getParameter("nome");
            String ementa = request.getParameter("ementa");
            int ciclo = Integer.parseInt(request.getParameter("ciclo"));
            double nota = Double.parseDouble(request.getParameter("nota"));
            Disciplina.update(rowId, nome, ementa, ciclo, nota);
            response.sendRedirect(request.getRequestURI());
        }catch(Exception ex){
            exceptionMessage = ex.getLocalizedMessage();
        }
    }
    
    if(request.getParameter("FormDelete")!=null){
        try{
            long rowId = Long.parseLong(request.getParameter("rowId"));
            Disciplina.delete(rowId);
            response.sendRedirect(request.getRequestURI());
        }catch(Exception ex){
            exceptionMessage = ex.getLocalizedMessage();
        }
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>P1 - POO</title>
    </head>
    <body>
        <%@include file="WEB-INF/jspf/menu.jspf" %>
        <h3>Minhas Disciplinas</h3>
        <%if(request.getParameter("insertButton") != null){%>
        <h3>Inserir Disciplina</h3>
        <form>
            Nome:<input type="text" name="nome"/>
            Ementa:<input type="text" name="ementa"/>
            Ciclo:<input type="text" name="ciclo"/>
            Nota:<input type="text" name="nota"/>
            <input type="submit" name="formInsert" value="Inserir"/>
            <input type="submit" name="Cancelar" value="Cancelar"/>
        </form>
        <%}else if(request.getParameter("updateButton") != null){%>
        <h3>Alterar Disciplina</h3>
        <form>
            <%
                String rowId = request.getParameter("rowId");
                String nome = request.getParameter("nome");
                String ementa = request.getParameter("ementa");
                String ciclo = request.getParameter("ciclo");
                String nota = request.getParameter("nota");
            %>
            <input type="hidden" name="rowId" value="<%= rowId %>"/>
            Nome:<input type="text" name="nome" value="<%= nome %>"/>
            Ementa:<input type="text" name="ementa" value="<%= ementa %>"/>
            Ciclo:<input type="text" name="ciclo" value="<%= ciclo %>"/>
            Nota:<input type="text" name="nota" value="<%= nota %>"/>
            <input type="submit" name="formUpdate" value="Alterar"/>
            <input type="submit" name="Cancelar" value="Cancelar"/>
        </form>
            <%} else if(request.getParameter("deleteButton") != null){%>
            <h3>Excluir Disciplina</h3>
            <form>
                <%String rowId = request.getParameter("rowId");%>
                <input type="hidden" name="rowId" value="<%= rowId %>"/>
                Excluir a Disciplina <b><%= rowId %></b>, confirmar?
                <input type="submit" name="FormDelete" value="Confirmar"/>
                <input type="submit" name="Cancelar" value="Cancelar"/>
            </form>
            <%} else {%>
            <form>
                <input type="submit" name="insertButton" value="Inserir"/>
            </form>
            <%}%>
        <table border="1">
            <tr>
                <th>Id</th>
                <th>Disciplina</th>
                <th>Ementa</th>
                <th>Ciclo</th>
                <th>Nota</th>
                <th>Alterar nota</th>
            </tr>
            <% for(int i=0; i < Disciplina.getList().size(); i++ ){
                Disciplina disciplina = Disciplina.getList().get(i);%>
                <tr>
                    <td><%=disciplina.getRowId()%></td>
                    <td><%=disciplina.getNome()%></td>
                    <td><%=disciplina.getEmenta()%></td>
                    <td><%=disciplina.getCiclo()%>º Ciclo</td>
                    <td><%=disciplina.getNota()%></td>
                    <td>
                        <form method="get">
                            <input type="hidden" name="rowId" value="<%=disciplina.getRowId()%>" />
                            <input type="hidden" name="nome" value="<%=disciplina.getNome()%>" />
                            <input type="hidden" name="ementa" value="<%=disciplina.getEmenta()%>" />
                            <input type="hidden" name="ciclo" value="<%=disciplina.getCiclo()%>" />
                            <input type="hidden" name="nota" value="<%=disciplina.getNota()%>" />
                            <input type="submit" name="updateButton" value="Alterar"/>
                            <input type="submit" name="deleteButton" value="Excluir"/>
                        </form>
                    </td>
                </tr>
            <%}%>
        </table>
    </body>
</html>

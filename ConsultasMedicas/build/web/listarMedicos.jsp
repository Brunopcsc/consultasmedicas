<%-- 
    Document   : listarMedicos
    Created on : 19/04/2018, 08:42:20
    Author     : Bruno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Médicos</title>
    </head>
    <body>
        <form action="VerMedicosServlet" method="post">
         Filtrar Médico por Especialidade:<input name="especialidade" type="text" value="">
           <button type="submit">Filtrar</button> </br>         
        </form>
        <h1>Lista de Médicos</h1>
        <hr>
        <c:if test="${empty requestScope.listaMedicos}">
            Não há médicos!
        </c:if>
        <c:if test="${!empty requestScope.listaMedicos}">
            <table>
                <tr>
                    <th class="esquerda">Nome</th>
                    <th>CRM</th>
                    <th>Especialidade</th>
                </tr>
                <c:forEach items="${requestScope.listaMedicos}" var="medico">
                    <tr>
                        <td class="esquerda">${medico.nome}</td>
                        <td>${medico.CRM}</td>
                        <td>${medico.especialidade}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
        
    </body>
</html>

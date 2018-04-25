<%-- 
    Document   : agendarConsultas
    Created on : 19/04/2018, 10:22:59
    Author     : Bruno
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agendar Consulta</title>
    </head>
    <body>
        ${mensagens}
       <form action="agendarConsultasServlet" method="post">
           CRM do médico: <input name="CRM" type="text" value="" /><br/>
           Data da consulta: <input name="data" type="text" value="" /><br/>        
           <button type="submit">Confirmar</button>
        </form>
    </body>
</html>

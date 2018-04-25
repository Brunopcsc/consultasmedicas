<%-- 
    Document   : index
    Created on : 12/04/2018, 09:19:16
    Author     : Bruno
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Clínica São Guilherme</title>
        <link rel="stylesheet" type="text/css" href="estilo.css" />        
    </head>
    <body>
        ${mensagens}
        ${mensagem}
        ${erro}
        <h3> <a href="LoginServlet?acao=cadMed">Cadastro de Médico</a></h3>
        <h3> <a href="LoginServlet?acao=cadPac">Cadastro de Paciente</a></h3>
        <h3> <a href="VerMedicosServlet">Listagem de Médicos</a></h3>       
        <h3> <a href="LoginServlet?acao=agendar">Agendar Consulta</a></h3>      
        <h3> <a href="LoginServlet?acao=listConsulta">Listar Consultas</a></h3>
    </body>
</html>
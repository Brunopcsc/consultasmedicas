<%-- 
    Document   : index
    Created on : 12/04/2018, 09:19:16
    Author     : Bruno
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:remove scope="session" var="novoPaciente" />
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Clínica São Guilherme</title>
        <link rel="stylesheet" type="text/css" href="estilo.css" />        
    </head>
    <body>
        ${mensagens}
        ${mensagem}
        <h3> <a href="cadastroMedico.jsp">Cadastro de Médico</a></h3>
        <h3> <a href="cadastroPaciente.jsp">Cadastro de Paciente</a></h3>
        <h3> <a href="listarMedicos.jsp">Listagem de Médicos</a></h3>       
        <h3> <a href="login.jsp">Agendar Consulta</a></h3>      
        <h3> <a href="listarConsultas.jsp">Listar Consultas</a></h3>
    </body>
</html>
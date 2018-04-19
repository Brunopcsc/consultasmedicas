<%-- 
    Document   : cadastroPaciente
    Created on : 12/04/2018, 09:41:07
    Author     : Bruno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Paciente</title>
    </head>
    <body>    
        <form action="cadastrarPacServlet" method="post">
           CPF: <input name="CPF" type="text" value="" /><br/>
           Nome: <input name="nome" type="text" value="" /><br/>
           Senha: <input name="senha" type="password" value="" /><br/>
           Telefone: <input name="telefone" type="text" value="" /><br/>   
           Sexo: <input name="sexo" type="text" value="" /><br/>           
           Data de Nascimento: <input name="dataNascimento" type="text" value="" /><br/>
           <button type="submit">Confirmar</button>
        </form>
    </body>
</html>

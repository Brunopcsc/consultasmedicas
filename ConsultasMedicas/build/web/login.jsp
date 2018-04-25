<%-- 
    Document   : login
    Created on : 12/04/2018, 09:28:47
    Author     : Bruno
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        
        ${erro}
        ${mensagens}
        <form action="LoginServlet?pagina=login" method="post">
            Digite suas informações de login:<br/>
            Login: <input name="login" type="text" value="" /><br/>
            Senha: <input name="senha" type="password" value="" /><br/>
             <select name="tipo">
                <option value="administrador">Administrador</option>
                <option value="paciente">Paciente</option>
                <option value="medico">Médico</option>
            </select> 
            <input type="hidden" name="acao" value="<%= request.getParameter("acao") %>"/>
            <button type="submite">Confirmar</button>
        </form>
    </body>
</html>

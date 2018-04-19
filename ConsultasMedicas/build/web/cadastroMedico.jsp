<%-- 
    Document   : cadastroMedico
    Created on : 12/04/2018, 09:46:12
    Author     : Bruno
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <form action="cadastrarMedServlet" method="post">
           CRM: <input name="CRM" type="text" value="" /><br/>
           Nome: <input name="nome" type="text" value="" /><br/>
           Senha: <input name="senha" type="password" value="" /><br/>
           Especialidade: <input name="especialidade" type="text" value="" /><br/>           
           <button type="submit">Confirmar</button>
        </form>
    </body>
</html>

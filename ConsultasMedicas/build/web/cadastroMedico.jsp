<%-- 
    Document   : cadastroMedico
    Created on : 12/04/2018, 09:46:12
    Author     : Bruno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <form action="cadastrarMedServlet" method="post">
           CRM: <input name="cpf" type="text" value="" /><br/>
           Nome: <input name="nome" type="text" value="" /><br/>
           Senha: <input name="senha" type="password" value="" /><br/>
           Especialidade: <input name="telefone" type="text" value="" /><br/>           
           <button type="submite">Confirmar</button>
        </form>
    </body>
</html>

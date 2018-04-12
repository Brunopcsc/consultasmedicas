<%-- 
    Document   : login
    Created on : 12/04/2018, 09:28:47
    Author     : Bruno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        

        <form action="LoginServelet" method="post">
            Digite suas informações de login:<br/>
            Nome: <input name="nome" type="text" value="" /><br/>
            Senha: <input name="senha" type="password" value="" /><br/>
            <input type="submit" value="Enviar"/>
    </body>
</html>

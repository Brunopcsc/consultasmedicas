<%-- 
    Document   : login
    Created on : 12/04/2018, 09:28:47
    Author     : Bruno
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:remove scope="session" var="novoPaciente" />
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title>Clínica São Guilherme - Login</title>
  </head>
  <body>
    <nav class="navbar navbar-light bg-primary">
      <a class="navbar-brand" href="#">
        <h3 class="font-weight-bold text-white" font>Clínica São Guilherme</h3>
      </a>
    </nav>
    <br>
    <br>

    <div class="container">
      <div>
        ${erro}
        ${mensagens}
        <form action="LoginServlet?pagina=login" method="post">
          <div class="form-group">
            <label for="exampleInputEmail1">Login</label>
            <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter login">
          </div>
          <div class="form-group">
            <label for="exampleInputPassword1">Password</label>
            <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
          </div>

          <div class="input-group mb-3">
            <select class="custom-select" id="inputGroupSelect02">
              <option value="administrador">Administrador</option>
              <option value="paciente">Paciente</option>
              <option value="medico">Médico</option>
            </select>
            <input type="hidden" name="acao" value="<%= request.getParameter("acao") %>"/>
          </div>

          <button type="submit" class="btn btn-primary">Entrar</button>
        </form>
      </div>

    </div>


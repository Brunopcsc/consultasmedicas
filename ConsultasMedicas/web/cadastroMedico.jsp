<%-- 
    Document   : cadastroMedico
    Created on : 12/04/2018, 09:46:12
    Author     : Bruno
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title>Clínica São Guilherme - Cadastro de m�dicos</title>
  </head>
  <body>
    <nav class="navbar navbar-light bg-primary justify-content-between">
      <h3 class="font-weight-bold text-white" font>Clínica São Guilherme</h3>
        <form class="form-inline">
          <button class="btn btn-dark my-2 my-sm-0" type="submit">Logout</button>
        </form>
    </nav>
    <br>
    <br>

    <div class="container">
      <div>
        <form action="cadastrarMedServlet" method="post">
          <div class="form-group">
            <label for="exampleInputEmail1">CRM</label>
            <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter CRM">
          </div>
          <div class="form-group">
            <label for="exampleInputPassword1">Nome</label>
            <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Nome">
          </div>
          <div class="form-group">
            <label for="exampleInputPassword1">Password</label>
            <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
          </div>
          <div class="form-group">
            <label for="exampleInputPassword1">Especialidade</label>
            <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Especialidade">
          </div>
          <button type="submit" class="btn btn-primary">Cadastrar</button>
        </form>
      </div>

    </div>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  </body>
</html>

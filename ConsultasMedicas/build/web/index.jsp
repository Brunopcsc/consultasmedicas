<%-- 
    Document   : index
    Created on : 12/04/2018, 09:19:16
    Author     : Bruno
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:remove scope="session" var="novoPaciente" />
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title>Clínica São Guilherme</title>

  </head>
  <body class="bg-light">

    <nav class="navbar navbar-light bg-primary justify-content-between">
      <h3 class="font-weight-bold text-white" font>Clínica São Guilherme</h3>
        <form class="form-inline">
          <button class="btn btn-dark my-2 my-sm-0" type="submit">Logout</button>
        </form>
    </nav>
    <br>
    <br>
    <div class="container ">
      <div class="row">
        <div class="col-md-4">
          <div class="card" style="width: 18rem;">
            <div class="card-body">
              <h5 class="card-title">Cadastro de Médico</h5>
              <h6 class="card-subtitle mb-2 text-muted">Cadastre um novo médico</h6>
              <p class="card-text">Cadastrar médicos é uma ação que requer login de administrador.</p>
              <a href="LoginServlet?acao=cadMed" class="card-link">Cadastrar médico</a>
            </div>
          </div>
        </div>

          <div class="col-md-4">
            <div class="card" style="width: 18rem;">
              <div class="card-body">
                <h5 class="card-title">Cadastro de Paciente</h5>
                <h6 class="card-subtitle mb-2 text-muted">Cadastre novos pacientes</h6>
                <p class="card-text">Cadastrar médicos é uma ação que requer login de administrador.</p>
                <a href="LoginServlet?acao=cadPac" class="card-link">Cadastrar Paciente</a>
              </div>
            </div>
          </div>

          <div class="col-md-4">
            <div class="card" style="width: 18rem;">
              <div class="card-body">
                <h5 class="card-title">Listagem de Médicos</h5>
                <h6 class="card-subtitle mb-2 text-muted">Liste os médicos cadastrados no sistema</h6>
                <p class="card-text">Esta ação não requer login, aproveite!</p>
                <a href="VerMedicosServlet">Listagem de Médicos</a>
              </div>
            </div>
          </div>


      </div>
      <br>
      <br>



      <div class="row">
        <div class="col-md-4">
          <div class="card" style="width: 18rem;">
            <div class="card-body">
              <h5 class="card-title">Agendar Consulta</h5>
              <h6 class="card-subtitle mb-2 text-muted">Agende uma consulta</h6>
              <p class="card-text">"Agendamento de consulta" é uma atividade que requer login do paciente via CPF + senha.</p>
              <a <a href="LoginServlet?acao=agendar">Agendar Consulta</a>
            </div>
          </div>
        </div>

          <div class="col-md-4">
            <div class="card" style="width: 18rem;">
              <div class="card-body">
                <h5 class="card-title">Listar Consultas</h5>
                <h6 class="card-subtitle mb-2 text-muted">Liste as consultas cadstradas</h6>
                <p class="card-text">"Listar de consulta" é uma atividade que requer login do médico via CRM + senha.</p>
                <a <a href="LoginServlet?acao=listConsulta">Listar Consultas</a>
              </div>
            </div>
          </div>



      </div>
    </div>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  </body>
</html>

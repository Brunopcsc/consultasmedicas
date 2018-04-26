<%-- 
    Document   : listarMedicos
    Created on : 19/04/2018, 08:42:20
    Author     : Bruno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
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
      <div class="row">
        <form>
          <div class="form-group">
            <label for="exampleFormControlInput1">Filtrar Médico por Especialidade</label>
            <input type="email" class="form-control" id="exampleFormControlInput1">
            <br>
            <button class="btn btn-primary my-2 my-sm-0" type="submit">Filtrar</button>
          </div>

        </form>
      </div>

        <h1>Lista de Médicos</h1>
        <hr>
        <c:if test="${empty requestScope.listaMedicos}">
            Não há médicos!
        </c:if>
        <c:if test="${!empty requestScope.listaMedicos}">
            <table>
                <tr>
                    <th class="esquerda">Nome</th>
                    <th>CRM</th>
                    <th>Especialidade</th>
                </tr>
                <c:forEach items="${requestScope.listaMedicos}" var="medico">
                    <tr>
                        <td class="esquerda">${medico.nome}</td>
                        <td>${medico.CRM}</td>
                        <td>${medico.especialidade}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>

      </div>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  </body>
</html>


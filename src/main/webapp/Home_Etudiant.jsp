<%--
  Created by IntelliJ IDEA.
  User: WALID-PC
  Date: 1/18/2024
  Time: 11:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

    <title>Etudiant Panel</title>
</head>
<body>
    <div class="alert alert-success" role="alert">
        <img src="img/logo_haute_qualité.png" style="height: 100px; width: 150px">
        <h1 style="text-align: center">welcome <%= request.getSession().getAttribute("nomComplet")%></h1>
    </div>
            <div class="container">
                <table>


                </table>
          </div>
</body>
</html>

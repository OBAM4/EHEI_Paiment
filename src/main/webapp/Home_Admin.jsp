<%--
  Created by IntelliJ IDEA.
  User: WALID-PC
  Date: 1/18/2024
  Time: 11:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

    <title>Admin Panel</title>
</head>
<% String query = request.getQueryString(); %>
<body>
<main class="container" style="min-width: 90vw">
    <img src="img/logo_haute_qualité.png" width="150">
    <div class="row p-3" style="height: 100vh;">
        <%if(query != null && query.split("&")[0].equals("ajouter")){%>
            <p>Etudiant a été ajouté</p>
        <% } %>
        <div class="col-6" >
            <form class="d-flex justify-content-around align-items-center">
                <input type="search" name="textNomaa" class="form-control form-control-lg w-50" placeholder="Rechercher Etudiant" />
                <button type="submit" class="btn btn-primary btn-lg">Rechercher</button>
            </form>
            <table class="table bordered-table">
                <thead>
                <tr>
                    <th>Nom</th>
                    <th>Prenom</th>
                    <th>Email</th>
                    <th>Annee Scolaire Debut</th>
                    <th>Annee Scolaire Fin</th>
                </tr>
                </thead>
                <tbody></tbody>
            </table>
        </div>

        <div class="col-6" style="border-left: 2px solid black">
            <div class="walid">
                <button type="button" id="btn-toggle" class="btn btn-primary">Afficher Formulaire d'ajout</button>

                <form id="togle" action="AddEtudiant"  style="margin-top: 10px" method="post">
                    <div class="form-outline mb-4">
                        <input type="text" name="txtNomA" class="form-control form-control-lg" placeholder="Enter Nom"  />

                    </div>

                    <div class="form-outline mb-4">
                        <input type="text" name="txtPrenomA" class="form-control form-control-lg"
                               placeholder="Enter Prenom" />

                    </div>
                    <div class="form-outline mb-4">
                        <input type="text" name="txtpassA" class="form-control form-control-lg"
                               placeholder="Enter password" />

                    </div>
                    <div class="form-outline mb-4">
                        <input type="text" name="txtEmailA" class="form-control form-control-lg"
                               placeholder="Enter Email" />
                    </div>

                    <div class="form-outline mb-4">
                        <input type="date" name="Debut" class="form-control form-control-lg"
                               placeholder="Enter date debut" />
                    </div>

                    <div class="form-outline mb-4">
                        <input type="date" name="Fin" class="form-control form-control-lg"
                               placeholder=" Enter date fin" />
                    </div>

                    <button type="submit" class="btn btn-primary btn-lg">Ajouter</button>

                </form>
            </div>
        </div>

    </div>
</main>

</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

<script>
    var show = false;
    $(document).ready(function(){
        $("#btn-toggle").click(function(){
            if(show) {
                show = false;
                $("#btn-toggle").text("Afficher Formulaire d'ajout");
            } else {
                show = true;

                $("#btn-toggle").text("Fermer Formulaire d'ajout");
            }
            $("#togle").toggle();
        });
    });
</script>

</html>

<%@page import="java.util.ArrayList"%>
<%@page import="com.example.ehei_pament.Etudiant"%>
<%@include file="/WEB-INF/jspf/header.jspf" %>
<%
	String messageSucces = (String)request.getAttribute("messageSucces");
	String messageErreur = (String)request.getAttribute("messageErreur");
%>

    <div class="row p-3" style="height: 100vh;">
    	<%if(messageSucces != null){%>
    	<div class="alert alert-success" role="alert">
  			<%= messageSucces %>
		</div>
        <% } %>
        <%if(messageErreur != null){%>
    	<div class="alert alert-danger" role="alert">
  			<%= messageErreur %>
		</div>
        <% } %>
        <div class="col-6" >
            <form action="RechercherEtudiant" class="d-flex justify-content-around align-items-center">
                <input type="search" name="nom" class="form-control form-control-lg w-50" placeholder="Rechercher Etudiant" />
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
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                	<% for
                	(Etudiant etudiant: (ArrayList<Etudiant>)request.getAttribute("etudiants") ) {
                	%>
                		<tr>
                			<td><%= etudiant.getNom() %> </td>
                			<td><%= etudiant.getPrenom() %> </td>
                			<td><%= etudiant.getEmail() %> </td>
                			<td><%= etudiant.getAnnneScolaireDebut() %> </td>
                			<td><%= etudiant.getAnnneScolaireFin() %> </td>
                			<td>
                				<a class="btn btn-danger" href="#" >Supprimer</a>
                			</td>
                		</tr>
                	<%} %>
                </tbody>
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
                        <input type="number" name="Debut" class="form-control form-control-lg"
                               placeholder="Enter date debut" />
                    </div>

                    <div class="form-outline mb-4">
                        <input type="number" name="Fin" class="form-control form-control-lg"
                               placeholder=" Enter date fin" />
                    </div>

                    <button type="submit" class="btn btn-primary btn-lg">Ajouter</button>

                </form>
            </div>

            <form method="post" action="DeleteEtudiant" style="margin-top: 20px">
                <div class="form-outline mb-4">
                    <input type="text" name="supp" class="form-control form-control-lg"/>
                </div>

                <button type="submit" class="btn btn-danger">Supprimer</button>
            </form>

            <form method="post" action="UpdateE " style="margin-top: 20px">
                <div class="form-outline mb-4">
                    <input type="text" name="txtNomAq" class="form-control form-control-lg" placeholder="Enter Nom"  />

                </div>

                <div class="form-outline mb-4">
                    <input type="text" name="txtPrenomAq" class="form-control form-control-lg"
                           placeholder="Enter Prenom" />

                </div>
                <div class="form-outline mb-4">
                    <input type="text" name="txtpassAq" class="form-control form-control-lg"
                           placeholder="Enter password" />

                </div>
                <div class="form-outline mb-4">
                    <input type="text" name="txtEmailAq" class="form-control form-control-lg"
                           placeholder="Enter Email" />
                </div>

                <div class="form-outline mb-4">
                    <input type="number" name="Debutq" class="form-control form-control-lg"
                           placeholder="Enter date debut" />
                </div>

                <div class="form-outline mb-4">
                    <input type="number" name="Finq" class="form-control form-control-lg"
                           placeholder=" Enter date fin" />
                </div>

                <button type="submit" class="btn btn-success">Modifier</button>
            </form>



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
<%@include file="/WEB-INF/jspf/footer.jspf" %>
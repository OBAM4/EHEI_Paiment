<%@include file="/WEB-INF/jspf/header.jspf" %>
    <div class="alert alert-success" role="alert">
        <img src="img/logo_haute_qualité.png" style="height: 100px; width: 150px">
        <h1 style="text-align: center">welcome <%= request.getSession().getAttribute("nomComplet")%></h1>
    </div>
    <form>
    	<select>
    		<%for(int annee=(int)request.getAttribute("anneeScolaireDebut");
    				annee<=(int)request.getAttribute("anneeScolaireFin");annee++) {%>
    				<option><%= annee %></option>
    				<%} %>
    	</select>
    </form>
            <div class="container">
                <table class="table bordered-table">
					<thead>
						<tr>
							<th>Mois</th>
							<th>Payé</th>
						</tr>
					</thead>
					<tbody>
						<%for(int i = 1;i <= 12; i++){ %>
							<tr>
								<td><%= i %></td>
								<td>
									
								</td>
							</tr>
						<%} %>
					</tbody>

                </table>
          </div>
</body>
</html>

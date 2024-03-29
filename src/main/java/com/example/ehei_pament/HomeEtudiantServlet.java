package com.example.ehei_pament;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;



/**
 * Servlet implementation class HomeEtudiant
 */
@WebServlet("/HomeEtudiant")
public class HomeEtudiantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public HomeEtudiantServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		if(session.getAttribute("nomComplet") == null || 
				session.getAttribute("estAdmin") != null) {
			response.sendRedirect("LoginEtudiant");
			return;
		}
		int id = (int)session.getAttribute("id");
		Etudiant etudiant = new Etudiant();
		etudiant.getById(id);
		int anneeActuelle = etudiant.getAnnneScolaireDebut();
		if(request.getParameter("annee") != null) {
			anneeActuelle = Integer.parseInt(request.getParameter("annee"));
		}
		ArrayList<Integer> lesMoisPaye = etudiant.getTousPaiement(id, anneeActuelle);
		request.setAttribute("anneeScolaireDebut", etudiant.getAnnneScolaireDebut());
		request.setAttribute("anneeScolaireFin", etudiant.getAnnneScolaireFin());
		request.setAttribute("lesMoisPaye", lesMoisPaye);
		request.getRequestDispatcher("HomeEtudiant.jsp").forward(request, response);
	}

}

package com.example.ehei_pament;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class HomeEtudiant
 */
@WebServlet("/HomeEtudiant")
public class HomeEtudiantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeEtudiantServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
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

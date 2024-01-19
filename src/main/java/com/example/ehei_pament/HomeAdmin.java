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
 * Servlet implementation class HomeAdmin
 */
@WebServlet("/HomeAdmin")
public class HomeAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		if(session.getAttribute("estAdmin") == null) {
			response.sendRedirect("LoginAdmin");
			return;
		}
		ArrayList<Etudiant> etudiantRechercher = (ArrayList<Etudiant>)
				session.getAttribute("etudiantsRechercher");
		if(etudiantRechercher != null) {
			session.removeAttribute("etudiantsRechercher");
			request.setAttribute("etudiants", etudiantRechercher);
		} else {
			Etudiant etudiant = new Etudiant();
			ArrayList<Etudiant> etudiants = etudiant.getAll();
			
			request.setAttribute("etudiants", etudiants);	
		}
		//
		String messageSucces = (String)session.getAttribute("messageSucces");
		String messageErreur= (String)session.getAttribute("messageErreur");
		if(messageSucces != null) {
			session.removeAttribute("messageSucces");
			request.setAttribute("messageSucces", messageSucces);
		}
		if(messageErreur != null) {
			session.removeAttribute("messageErreur");
			request.setAttribute("messageErreur", messageErreur);
		}
		
		request.getRequestDispatcher("Home_Admin.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

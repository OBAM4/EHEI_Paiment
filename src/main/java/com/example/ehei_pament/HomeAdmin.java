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
 * Servlet implementation class HomeAdmin
 */
@WebServlet("/HomeAdmin")
public class HomeAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public HomeAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }


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

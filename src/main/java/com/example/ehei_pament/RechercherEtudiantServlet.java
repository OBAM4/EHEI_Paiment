package com.example.ehei_pament;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;


@WebServlet("/RechercherEtudiant")
public class RechercherEtudiantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public RechercherEtudiantServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nom = request.getParameter("nom");
        Etudiant etudiant = new Etudiant();
        ArrayList<Etudiant> etudiants = etudiant.getByNom(nom);
        request.getSession().setAttribute("etudiantsRechercher", etudiants);
        response.sendRedirect("HomeAdmin");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

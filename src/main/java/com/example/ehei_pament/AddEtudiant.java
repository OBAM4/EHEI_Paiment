package com.example.ehei_pament;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


@WebServlet("/AddEtudiant")
public class AddEtudiant extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            Connection cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/ehei_paiment", "root", "");


            String  nom = req.getParameter("txtNomA");

            String Prenom  = req.getParameter("txtPrenomA");

            String pass  = req.getParameter("txtpassA");


            String email  = req.getParameter("txtEmailA");

            String Debut = req.getParameter("Debut");

            String Fin = req.getParameter("Fin");
            
            try {
            	int DebutInt = Integer.parseInt(Debut);
            	int FinInt = Integer.parseInt(Fin);
            	if(DebutInt >= FinInt) {
            		resp.sendRedirect("HomeAdmin");
            		return;
            	}
            }catch(Exception ex) {
            	
            }

            PreparedStatement cmd =  cnx.prepareStatement("INSERT INTO etudiant (Nom, Prenom, Password , Email , Annee_Scolaire_Debut  , Annee_Scolaire_Fin )"
                    +  "VALUES (?, ?, ?, ? , ? , ?); ");


            cmd.setString(1,nom);
            cmd.setString(2,Prenom);
            cmd.setString(3,pass);
            cmd.setString(4,email);
            cmd.setString(5,Debut);
            cmd.setString(6,Fin);

            cmd.execute();
            req.getSession().setAttribute("messageSucces", "Etudiant a été ajouté avec succès");
            resp.sendRedirect("HomeAdmin");





        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}

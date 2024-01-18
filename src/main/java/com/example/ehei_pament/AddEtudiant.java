package com.example.ehei_pament;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


@WebServlet(name = "AddEtudiant", value = "/AddEtudiant")
public class AddEtudiant extends HttpServlet {

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

            PreparedStatement cmd =  cnx.prepareStatement("INSERT INTO etudiant (Nom, Prenom, Password , Email , Annee_Scolaire_Debut  , Annee_Scolaire_Fin )"
                    +  "VALUES (?, ?, ?, ? , ? , ?); ");


            cmd.setString(1,nom);
            cmd.setString(2,Prenom);
            cmd.setString(3,pass);
            cmd.setString(4,email);
            cmd.setString(5,Debut);
            cmd.setString(6,Fin);

            cmd.execute();
            resp.sendRedirect("Home_Admin.jsp?ajouter");













        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}

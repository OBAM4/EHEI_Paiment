package com.example.ehei_pament;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/UpdateE")
public class UpdateE extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Connection cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/ehei_paiment", "root", "");

            String nom = req.getParameter("txtNomAq");
            String Prenom = req.getParameter("txtPrenomAq");
            String pass = req.getParameter("txtpassAq");
            String email = req.getParameter("txtEmailAq");
            String Debut = req.getParameter("Debutq");
            String Fin = req.getParameter("Finq");

            String updateQuery = "UPDATE etudiant SET Prenom = ?, Password = ?, Email = ?, Annee_Scolaire_Debut = ?, Annee_Scolaire_Fin = ? WHERE Nom = ?;";

            // Create a PreparedStatement
            PreparedStatement cmd = cnx.prepareStatement(updateQuery);

            // Set parameters in the correct order
            cmd.setString(1, Prenom);
            cmd.setString(2, pass);
            cmd.setString(3, email);
            cmd.setString(4, Debut);
            cmd.setString(5, Fin);
            cmd.setString(6, nom);

            cmd.executeUpdate();

            req.getSession().setAttribute("messageSucces", "Etudiant a été modifié avec succès");
            resp.sendRedirect("HomeAdmin");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

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

@WebServlet("/DeleteEtudiant")
public class DeleteEtudiant extends HttpServlet {


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Connection cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/ehei_paiment", "root", "");

            String nom = req.getParameter("supp");

            PreparedStatement cmd = cnx.prepareStatement("DELETE FROM etudiant WHERE Nom = ?");

            cmd.setString(1, nom);

            int rowsAffected = cmd.executeUpdate();

            if (rowsAffected > 0) {
                req.getSession().setAttribute("messageSucces", "Etudiant a été supprimé avec succès");
            } else {
                req.getSession().setAttribute("messageErreur", "Aucun étudiant trouvé avec le nom fourni");
            }

            resp.sendRedirect("HomeAdmin");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}





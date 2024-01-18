package com.example.ehei_pament;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Rechercher extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nom = req.getParameter("textNomaa");

        try {
            Connection cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/ehei_paiment", "root", "");

            PreparedStatement cmd =  cnx.prepareStatement("select * from etudiant where Nom=?");
            cmd.setString(1,nom);



            cmd.execute();

        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }

    }
}

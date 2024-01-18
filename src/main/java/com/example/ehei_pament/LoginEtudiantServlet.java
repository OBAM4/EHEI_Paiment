package com.example.ehei_pament;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.IOException;
import java.sql.*;

@WebServlet(name = "LoginEtudiantServlet", value = "/LoginEtudiant")
public class LoginEtudiantServlet extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.getRequestDispatcher("Login.jsp").forward(req, resp);;
	}
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        try {
            Connection cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/ehei_paiment", "root", "");

            String email = req.getParameter("txtEmail");
            String pass = req.getParameter("txtpass");



            PreparedStatement cmd =  cnx.prepareStatement("select * from etudiant where Email=? and password=?");
            cmd.setString(1,email);
            cmd.setString(2,pass);




            ResultSet rs  = cmd.executeQuery();

            if(rs.next())
            {
                String nom = rs.getString("Nom");
                String prenom = rs.getString("Prenom");
                HttpSession session = req.getSession();
                session.removeAttribute("estAdmin");
                session.setAttribute("nomComplet" , nom + " " + prenom);
                resp.sendRedirect("Home_Etudiant.jsp");
            }
            else
            {
                resp.sendRedirect("Login.jsp");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
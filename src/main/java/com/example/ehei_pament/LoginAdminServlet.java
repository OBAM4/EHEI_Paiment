package com.example.ehei_pament;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.IOException;
import java.sql.*;

@WebServlet(name = "LoginAdminServlet", value = "/LoginAdmin")
public class LoginAdminServlet extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.getRequestDispatcher("LoginAdmin.jsp").forward(req, resp);
	}
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        try {
            Connection cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/ehei_paiment", "root", "");

            String email = req.getParameter("txtEmail");
            String pass = req.getParameter("txtpass");

            PreparedStatement cmd =  cnx.prepareStatement("select * from administrateur where Email=? and password=?");
            cmd.setString(1,email);
            cmd.setString(2,pass);

            ResultSet rs  = cmd.executeQuery();

            if(rs.next())
            {
            	String nomComplet = rs.getString("Nom") + " " + rs.getString("Prenom");
            	HttpSession session = req.getSession();
            	session.setAttribute("estAdmin", true);
            	session.setAttribute("nomComplet", nomComplet);
                resp.sendRedirect("HomeAdmin");
            }
            else
            {
                resp.sendRedirect("LoginAdmin.jsp");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
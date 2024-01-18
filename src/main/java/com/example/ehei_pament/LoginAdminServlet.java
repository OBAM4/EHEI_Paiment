package com.example.ehei_pament;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.*;

@WebServlet(name = "LoginAdminServlet", value = "/LoginAdmin")
public class LoginAdminServlet extends HttpServlet {

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
                resp.sendRedirect("Home_Admin.jsp");
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
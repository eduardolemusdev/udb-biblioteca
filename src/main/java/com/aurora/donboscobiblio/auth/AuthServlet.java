package com.aurora.donboscobiblio.auth;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/signin")
public class AuthServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        System.out.println(email + " " + password);

        boolean isAdmin = email.equals("admin") && password.equals("admin");

        if (isAdmin) {
            response.sendRedirect(request.getContextPath() + "/admin/home");
        }else{
            request.setAttribute("errorMessage", "Invalid email or password, try again");
            request.getRequestDispatcher("/").forward(request, response);
        }
    }

}

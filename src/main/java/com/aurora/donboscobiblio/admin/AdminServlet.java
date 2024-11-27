package com.aurora.donboscobiblio.admin;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AdminHomeServlet" , value="/Admin")
public class AdminServlet extends HttpServlet {
      public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
       System.out.println("Reached");
       RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/admin/home.jsp");
       dispatcher.forward(request, response);
    }
}

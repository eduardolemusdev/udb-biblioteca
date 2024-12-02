package com.aurora.donboscobiblio.admin;

import com.aurora.donboscobiblio.database.MaterialLanguageService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/admin/home")
public class AdminHomeServlet extends HttpServlet {
      private final MaterialLanguageService materialLanguageService = new MaterialLanguageService();
      public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
          Map<Integer, String> mapLanguages = materialLanguageService.getMaterialLanguages();
          request.setAttribute("languages", mapLanguages);
          request.getRequestDispatcher("/WEB-INF/admin/adminHomeContainer.jsp").forward(request, response);
    }
}

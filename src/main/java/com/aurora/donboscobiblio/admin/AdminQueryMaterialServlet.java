package com.aurora.donboscobiblio.admin;

import com.aurora.donboscobiblio.database.SearchMaterialService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/query-material")
public class AdminQueryMaterialServlet extends HttpServlet {
      private final SearchMaterialService searchMaterialService = new SearchMaterialService();

      public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {



       request.getRequestDispatcher("/WEB-INF/admin/queryMaterial/adminQueryMaterialContainer.jsp").forward(request, response);
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
       String searchType = request.getParameter("searchType");
       String searchCriteria = request.getParameter("target");

       if (searchType.equals("id")){
           request.setAttribute("results", searchMaterialService.searchById(searchCriteria));
       }
       request.getRequestDispatcher("/WEB-INF/admin/queryMaterial/adminQueryMaterialContainer.jsp").forward(request, response);
    }
}
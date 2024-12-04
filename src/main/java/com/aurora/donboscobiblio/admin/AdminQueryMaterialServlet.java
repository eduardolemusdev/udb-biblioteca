package com.aurora.donboscobiblio.admin;

import com.aurora.donboscobiblio.database.SearchMaterialService;
import com.aurora.donboscobiblio.database.models.MaterialEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

          try {
              Integer id = Integer.parseInt(searchCriteria);
              request.setAttribute("results", searchMaterialService.searchById(id));
          }catch (Exception e){

              request.setAttribute("results", new ArrayList<MaterialEntity>())  ;
          }

       }

       if (searchType.equals("title")){
           List<MaterialEntity> list = searchMaterialService.searchByTitle(searchCriteria);
           System.out.println("Title: " + list.size());
           list.forEach(e ->System.out.println(e.toString()));
           request.setAttribute("results", list);
       }
       request.getRequestDispatcher("/WEB-INF/admin/queryMaterial/adminQueryMaterialContainer.jsp").forward(request, response);
    }
}
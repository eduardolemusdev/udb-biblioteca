package com.aurora.donboscobiblio.admin;

import com.aurora.donboscobiblio.database.CategoriesService;
import com.aurora.donboscobiblio.database.MaterialLanguageService;
import com.aurora.donboscobiblio.database.MaterialLocationService;

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
      private final MaterialLocationService materialLocationService = new MaterialLocationService();
      private  final CategoriesService categoriesService = new CategoriesService();

      public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
          Map<Integer, String> mapLanguages = materialLanguageService.getMaterialLanguages();
          Map<Integer, String> mapBuildings = materialLocationService.getBuildings();
          Map<Integer, Integer> mapBuildingFloor = materialLocationService.getBuildingFloors();
          Map<Integer, Integer>  mapBuildingShelf = materialLocationService.getBuildingShelfs();
          Map<Integer, String> mapCategories = categoriesService.getCategories();
          Map<Integer, String> mapMaterialType = categoriesService.getMaterialTypes();





          request.setAttribute("languages", mapLanguages);
          request.setAttribute("buildings", mapBuildings);
          request.setAttribute("buildingFloors", mapBuildingFloor);
          request.setAttribute("buildingShelfs", mapBuildingShelf);
          request.setAttribute("categories", mapCategories);
          request.setAttribute("materialTypes", mapMaterialType);

          request.getRequestDispatcher("/WEB-INF/admin/adminHomeContainer.jsp").forward(request, response);
    }
}

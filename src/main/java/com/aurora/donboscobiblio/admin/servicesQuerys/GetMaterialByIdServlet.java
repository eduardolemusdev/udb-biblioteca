package com.aurora.donboscobiblio.admin.servicesQuerys;

import com.aurora.donboscobiblio.database.SearchMaterialService;
import com.aurora.donboscobiblio.database.models.MaterialEntity;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/admin/material-id")
public class GetMaterialByIdServlet extends HttpServlet {
    private SearchMaterialService searchMaterialService = new SearchMaterialService();
    public void doGet(HttpServletRequest req, HttpServletResponse response) throws IOException {


        Integer materialId = Integer.parseInt(req.getParameter("materialId"));
        MaterialEntity material = searchMaterialService.searchPlainMaterialById(materialId);

        if(material != null) {

            response.setContentType("application/json");
            response.setStatus(HttpServletResponse.SC_OK);

            PrintWriter out = response.getWriter();

            out.print("{\"message\": \"Material cargado.\"}");
            out.flush();
        }else{
            response.setContentType("application/json");
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);

            PrintWriter out = response.getWriter();

            out.print("{\"message\": \"Material no existe.\"}");
            out.flush();
        }
    }
}

package com.aurora.donboscobiblio.admin.servicesQuerys;

import com.aurora.donboscobiblio.database.LoansService;
import com.aurora.donboscobiblio.database.models.LoanConfigEntity;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/admin/loans-config")
public class GetLoansConfigByRoleServlet extends HttpServlet {
    private LoansService loansService = new LoansService();
   public void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {


        Integer userRoleId = Integer.parseInt(req.getParameter("userRoleID"));

        List<LoanConfigEntity> loanConfigList = loansService.getLoanConfigByUserRoleId(userRoleId);


        if(!loanConfigList.isEmpty()) {

            Gson gson = new Gson();
            String jsonResponse = gson.toJson(loanConfigList);


            response.setContentType("application/json");
            response.setStatus(HttpServletResponse.SC_OK);

            PrintWriter out = response.getWriter();

            out.print(jsonResponse);
            out.flush();
        }else{
            response.setContentType("application/json");
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);

            PrintWriter out = response.getWriter();

            out.print("{\"message\": \"No existen configuraciones habilitadas para ese rol de usuario.\"}");
            out.flush();
        }   }
}

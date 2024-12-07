package com.aurora.donboscobiblio.admin;

import com.aurora.donboscobiblio.database.LoansService;
import com.aurora.donboscobiblio.database.dtos.CreateMaterialLoanDto;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/admin/material-loan")
public class AdminAddMaterialLoanServlet extends HttpServlet {
    private LoansService loansService = new LoansService();

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/admin/loans/materialLoan/adminCreateMaterialLoanContainer.jsp").forward(req, resp);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = request.getReader()) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        }
        String jsonString = sb.toString();

        Gson gson = new Gson();
        CreateMaterialLoanDto createMaterialLoanDto = gson.fromJson(jsonString, CreateMaterialLoanDto.class);

        try {
            loansService.createMaterialLoan(createMaterialLoanDto);
            response.setContentType("application/json");
            response.setStatus(HttpServletResponse.SC_OK);

            PrintWriter out = response.getWriter();
            out.print("{\"message\": \"Prestamo realizado con exito.\"}");
            out.flush();
        }catch (Exception e) {
            response.setContentType("application/json");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);

            PrintWriter out = response.getWriter();
            out.print("{\"message\": \""+e.getMessage()+".\"}");
            out.flush();
        }    }
}

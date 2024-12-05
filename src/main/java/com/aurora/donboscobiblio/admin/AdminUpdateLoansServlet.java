package com.aurora.donboscobiblio.admin;

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
import java.util.List;

import java.io.BufferedReader;
@WebServlet("/admin/loans/update")
public class AdminUpdateLoansServlet extends HttpServlet {
    private final LoansService loansService = new LoansService();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<LoanConfigEntity> loans = loansService.listLoanConfig();
        request.setAttribute("elements", loans);
        request.getRequestDispatcher("/WEB-INF/admin/loans/updateLoans/adminUpdateLoansContainer.jsp").forward(request, response);
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
        LoanConfigEntity loan = gson.fromJson(jsonString, LoanConfigEntity.class);

       System.out.println("Configuracion a actualizar"+loan);


         try {
             loansService.updateLoanConfig(loan);

            response.setContentType("application/json");
            response.setStatus(HttpServletResponse.SC_OK);

            PrintWriter out = response.getWriter();
            out.print("{\"message\": \"Configuracion de Prestamo actualizada con exito.\"}");
            out.flush();
        }catch (Exception e) {
            response.setContentType("application/json");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);

            PrintWriter out = response.getWriter();
            out.print("{\"message\": \"Error, intentelo nuevamente.\"}");
            out.flush();
        }
    }
}

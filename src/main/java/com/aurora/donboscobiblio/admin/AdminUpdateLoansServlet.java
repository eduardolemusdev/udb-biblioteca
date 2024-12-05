package com.aurora.donboscobiblio.admin;

import com.aurora.donboscobiblio.database.LoansService;
import com.aurora.donboscobiblio.database.models.LoanConfigEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/loans/update")
public class AdminUpdateLoansServlet extends HttpServlet {
    private final LoansService loansService = new LoansService();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<LoanConfigEntity> loans = loansService.listLoanConfig();
        request.setAttribute("elements", loans);
        request.getRequestDispatcher("/WEB-INF/admin/loans/updateLoans/adminUpdateLoansContainer.jsp").forward(request, response);
    }
}

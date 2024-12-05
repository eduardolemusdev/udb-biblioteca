package com.aurora.donboscobiblio.admin;

import com.aurora.donboscobiblio.database.LoansService;
import com.aurora.donboscobiblio.database.UserRolesService;
import com.aurora.donboscobiblio.database.models.LoanConfigEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/admin/loans")
public class AdminLoansServlet extends HttpServlet {

      private final UserRolesService userRolesService = new UserRolesService();
      private final LoansService loansService = new LoansService();

      public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
           Map<Integer, String> roles = userRolesService.getRoles();
           request.setAttribute("roles", roles);
           request.getRequestDispatcher("/WEB-INF/admin/loans/adminLoansContainer.jsp").forward(request, response);
      }

      public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
          Integer daysLimit = Integer.parseInt(request.getParameter("days_limit"));
          double taxPenaltyPerDay = Double.parseDouble(request.getParameter("tax_penalty_per_day"));
          Integer activeLoansLimit = Integer.parseInt(request.getParameter("active_loans_limit"));
          Integer userRoleId = Integer.parseInt(request.getParameter("userRole"));

          LoanConfigEntity loanConfigEntity = new LoanConfigEntity(daysLimit,taxPenaltyPerDay,activeLoansLimit,userRoleId);
          loansService.createLoanConfig(loanConfigEntity);

          response.sendRedirect(request.getContextPath()+"/admin/loans/update");
      }
}
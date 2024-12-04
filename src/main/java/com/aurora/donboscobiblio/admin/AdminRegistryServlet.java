package com.aurora.donboscobiblio.admin;

import com.aurora.donboscobiblio.database.UserRolesService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;


@WebServlet("/admin/registry")
public class AdminRegistryServlet extends HttpServlet {
      private final UserRolesService userRolesService = new UserRolesService();

      public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

          Map<Integer, String> roles = userRolesService.getRoles();
          roles.values().forEach(System.out::println);
          request.setAttribute("roles", roles);
       request.getRequestDispatcher("/WEB-INF/admin/registry/adminRegistryContainer.jsp").forward(request, response);
      }

      public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

          response.sendRedirect(request.getContextPath()+"/admin/password-recovery");
      }
}
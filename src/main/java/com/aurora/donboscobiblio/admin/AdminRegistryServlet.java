package com.aurora.donboscobiblio.admin;

import com.aurora.donboscobiblio.database.UserRolesService;
import com.aurora.donboscobiblio.database.UsersService;

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
      private final UsersService usersService = new UsersService();

      public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

          Map<Integer, String> roles = userRolesService.getRoles();
          request.setAttribute("roles", roles);
       request.getRequestDispatcher("/WEB-INF/admin/registry/adminRegistryContainer.jsp").forward(request, response);
      }

      public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
          String username = request.getParameter("username");
          String password = request.getParameter("password");
          Integer roleId = Integer.parseInt(request.getParameter("userRole"));

          try {
             usersService.insertUser(username, password, roleId);
             response.sendRedirect(request.getContextPath()+"/admin/password-recovery");
          }catch(Exception e) {
              Map<Integer, String> roles = userRolesService.getRoles();
              request.setAttribute("roles", roles);
             request.setAttribute("errorMessage", e.getMessage());
              request.getRequestDispatcher("/WEB-INF/admin/registry/adminRegistryContainer.jsp").forward(request, response);
          }

      }
}
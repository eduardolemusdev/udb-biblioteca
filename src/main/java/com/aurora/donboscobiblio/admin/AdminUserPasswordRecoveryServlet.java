package com.aurora.donboscobiblio.admin;

import com.aurora.donboscobiblio.database.UsersService;
import com.aurora.donboscobiblio.database.dtos.UpdatePasswordDto;
import com.aurora.donboscobiblio.database.models.UserEntity;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/admin/password-recovery")
public class AdminUserPasswordRecoveryServlet extends HttpServlet {
      private final UsersService usersService = new UsersService();
      public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
          Integer page = null;

          try {
            page = Integer.parseInt(request.getParameter("page"));
          }catch (Exception e){
            page = 1;
          }

          List<UserEntity> users = usersService.getUsers(page,5);
          Integer totalUsers = usersService.usersCount();
          Integer totalPages = (int) Math.ceil((double) totalUsers/5);

          request.setAttribute("users", users);
          request.setAttribute("page", page);
          request.setAttribute("totalPages", totalPages);

          System.out.println("Total pages: "+totalPages);
       request.getRequestDispatcher("/WEB-INF/admin/usersPasswordRecovery/usersPasswordRecoveryContainer.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = request.getReader()) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        }
        String jsonString = sb.toString();

        Gson gson = new Gson();
        UpdatePasswordDto updatePasswordDto = gson.fromJson(jsonString, UpdatePasswordDto.class);

        try {
            usersService.updateUserPassword(updatePasswordDto.getUserId(), updatePasswordDto.getNewPassword());
            response.setContentType("application/json");
            response.setStatus(HttpServletResponse.SC_OK);

            PrintWriter out = response.getWriter();
            out.print("{\"message\": \"Contraseña actualizada con exito.\"}");
            out.flush();
        }catch (Exception e) {
            response.setContentType("application/json");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);

            PrintWriter out = response.getWriter();
            out.print("{\"message\": \"Contraseña actualizada con exito.\"}");
            out.flush();
        }
    }
}
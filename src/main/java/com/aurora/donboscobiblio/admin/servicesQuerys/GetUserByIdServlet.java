package com.aurora.donboscobiblio.admin.servicesQuerys;

import com.aurora.donboscobiblio.database.UsersService;
import com.aurora.donboscobiblio.database.models.UserEntity;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/admin/user-id")
public class GetUserByIdServlet extends HttpServlet {
    private UsersService usersService = new UsersService();
    public void doGet(HttpServletRequest req, HttpServletResponse response) throws IOException {

        Integer userId = Integer.parseInt(req.getParameter("userId"));
        UserEntity user = usersService.getUser(userId);
        if(user != null) {

            response.setContentType("application/json");
            response.setStatus(HttpServletResponse.SC_OK);

            PrintWriter out = response.getWriter();

            out.print("{\"message\": \"Usuario cargado.\"}");
            out.flush();
        }else{
            response.setContentType("application/json");
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);

            PrintWriter out = response.getWriter();

            out.print("{\"message\": \"Usuario no existe.\"}");
            out.flush();
        }
    }

}

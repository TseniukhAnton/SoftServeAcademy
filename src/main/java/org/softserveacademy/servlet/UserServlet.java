package org.softserveacademy.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.softserveacademy.model.User;
import org.softserveacademy.repository.jdbc.JdbcUserRepositoryImpl;
import org.softserveacademy.view.UserView;

import java.io.IOException;


//@WebServlet(name = "UserServlet")
public class UserServlet extends HttpServlet {
    //private final JdbcUserRepositoryImpl jdbcUserRepository = new JdbcUserRepositoryImpl();
    UserView userView = new UserView();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //User user = jdbcUserRepository.getById((Integer) request.getSession().getAttribute("id"));
        User user = userView.getUserFromController();
        response.setContentType("application/json");
        response.getWriter().write(new ObjectMapper().writeValueAsString(user));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        User user = new User(request.getParameter("name"), request.getParameter("email"));
        System.out.println(user);
        //jdbcUserRepository.save(user);
        userView.createUserFromController();
    }
}

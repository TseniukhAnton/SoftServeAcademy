package org.softserveacademy.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.*;
import org.softserveacademy.model.User;
import org.softserveacademy.repository.UserRepository;
import org.softserveacademy.repository.jdbc.JdbcUserRepositoryImpl;
import org.softserveacademy.services.impl.UserServiceImpl;

import java.io.IOException;
import java.util.List;


//@WebServlet(name = "UserServlet")
public class UserServlet extends HttpServlet {
    private JdbcUserRepositoryImpl jdbcUserRepository;

    @Override
    public void init() {
        jdbcUserRepository = new JdbcUserRepositoryImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //new UserRepository().getById()
        User user = jdbcUserRepository.getById((Integer) request.getSession().getAttribute("id"));
        response.setContentType("application/json");
        response.getWriter().write(new ObjectMapper().writeValueAsString(user));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        User user = new User(request.getParameter("name"), request.getParameter("email"));
        System.out.println(user);
        jdbcUserRepository.save(user);
    }

    @Override
    public void destroy() {

    }
}

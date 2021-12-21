package org.softserveacademy.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.softserveacademy.model.User;
import org.softserveacademy.repository.jdbc.JdbcUserRepositoryImpl;

import java.io.IOException;
import java.util.List;


//@WebServlet(name = "UserServlet")
public class UserServlet extends HttpServlet {

//    @Override
//    public void init() {
//        jdbcUserRepository = new JdbcUserRepositoryImpl();
//        System.out.println("This is UserServlet msg");
//    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        JdbcUserRepositoryImpl jdbcUserRepository = new JdbcUserRepositoryImpl();
        List<User> users = jdbcUserRepository.getAll();
        response.setContentType("application/json");
        response.getWriter().write(new ObjectMapper().writeValueAsString(users));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request,response);
    }

    public void destroy() {

    }
}

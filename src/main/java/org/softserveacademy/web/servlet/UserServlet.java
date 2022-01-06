package org.softserveacademy.web.servlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.softserveacademy.model.User;
import org.softserveacademy.repository.UserRepository;
import org.softserveacademy.repository.jdbc.JdbcUserRepositoryImpl;
import org.softserveacademy.service.impl.UserServiceImpl;

import java.io.IOException;
import java.util.List;


//@WebServlet(name = "UserServlet")
public class UserServlet extends HttpServlet {
    private UserServiceImpl userServiceImpl = new UserServiceImpl();
    private UserRepository userRepository = new JdbcUserRepositoryImpl();

    @Override
    public void init() {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<User> users = userRepository.getAll();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.getWriter().write(String.valueOf(users));
        //new ObjectMapper().writeValueAsString(users);
        User user = userServiceImpl.getByEmail((String) request.getSession().getAttribute("anton.tseniukh@gmail.com"));
        response.setContentType("application/json");
        response.getWriter().write(String.valueOf(user));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request,response);
        User user = userServiceImpl.getByEmail((String) request.getSession().getAttribute("anton.tseniukh@gmail.com"));
        String newUsername = request.getParameter("newUserName");
        String newEmail = request.getParameter("newEmail");
        System.out.println(user.getId());
        userServiceImpl.update(user, newUsername, newEmail);
    }

}

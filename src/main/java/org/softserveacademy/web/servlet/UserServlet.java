package org.softserveacademy.web.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.softserveacademy.repository.UserRepository;
import org.softserveacademy.repository.jdbc.JdbcUserRepositoryImpl;
import org.softserveacademy.service.impl.UserServiceImpl;

import java.io.IOException;


//@WebServlet(name = "UserServlet")
public class UserServlet extends HttpServlet {
    private UserServiceImpl userServiceImpl = new UserServiceImpl();
    private UserRepository userRepository = new JdbcUserRepositoryImpl();

    @Override
    public void init() {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/user-list.jsp");
        request.setAttribute("user", userServiceImpl.getAll() );
        requestDispatcher.forward(request, response);
//        List<User> users = userRepository.getAll();
//        response.setCharacterEncoding("UTF-8");
//        response.setContentType("application/json");
//        response.getWriter().write(String.valueOf(users));
//        //new ObjectMapper().writeValueAsString(users);
//        User user = userServiceImpl.getByEmail((String) request.getSession().getAttribute("email"));
//        response.setContentType("application/json");
//        response.getWriter().write(String.valueOf(user));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request,response);
//        User user = userServiceImpl.getByEmail((String) request.getSession().getAttribute("email"));
//        String newUsername = request.getParameter("name");
//        String newEmail = request.getParameter("email");
//        System.out.println(user.getId());
//        userServiceImpl.update(user, newUsername, newEmail);
    }

}

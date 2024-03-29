package org.softserveacademy.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.softserveacademy.model.User;
import org.softserveacademy.service.UserService;
import org.softserveacademy.service.impl.UserServiceImpl;

import java.io.IOException;

public class CreateUserServlet extends HttpServlet {
    private final UserService userService = new UserServiceImpl();

    @Override
    public void init() {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
       request.getRequestDispatcher("/WEB-INF/create-user.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        User user = User.builder()
                .name(name)
                .email(email)
                .build();
        userService.save(user);
        response.sendRedirect("/listUserServlet");
    }
}

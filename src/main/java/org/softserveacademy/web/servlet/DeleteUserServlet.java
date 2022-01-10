package org.softserveacademy.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.softserveacademy.service.UserService;
import org.softserveacademy.service.impl.UserServiceImpl;

import java.io.IOException;

public class DeleteUserServlet extends HttpServlet {
    private final UserService userService = new UserServiceImpl();

    @Override
    public void init() {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        userService.deleteById(Integer.parseInt(request.getParameter("id")));
        response.sendRedirect("/listUserServlet");
    }
}

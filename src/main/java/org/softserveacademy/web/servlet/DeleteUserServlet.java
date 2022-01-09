package org.softserveacademy.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.softserveacademy.service.impl.UserServiceImpl;

import java.io.IOException;

public class DeleteUserServlet extends HttpServlet {
    private final UserServiceImpl userServiceImpl = new UserServiceImpl();

    @Override
    public void init() {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/WEB-INF/delete-user.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String idStr = request.getParameter("id");
        Integer id = Integer.parseInt(idStr);
        userServiceImpl.deleteById(id);
        response.sendRedirect("/userServlet");
    }
}

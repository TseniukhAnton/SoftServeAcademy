package org.softserveacademy.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.softserveacademy.model.User;
import org.softserveacademy.service.impl.UserServiceImpl;

import java.io.IOException;

public class RetrieveUserServlet extends HttpServlet {

    @Override
    public void init() {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        User user = UserServiceImpl.getInstance().getById(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("user", user);
        request.getRequestDispatcher("/WEB-INF/retrieve-user.jsp").forward(request,response);
    }
}

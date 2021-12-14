package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.softserveacademy.model.User;
import org.softserveacademy.repository.jdbc.JdbcUserRepositoryImpl;

import java.io.IOException;


@WebServlet(name = "UserServlet")
public class UserServlet extends HttpServlet {
    private JdbcUserRepositoryImpl jdbcUserRepository;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = jdbcUserRepository.getById((Integer) request.getSession().getAttribute("id"));
        response.setContentType("application/json");
        response.getWriter().write(new ObjectMapper().writeValueAsString(user));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        User user = jdbcUserRepository.getById((Integer) request.getSession().getAttribute("id"));
        user.setName(request.getParameter("name"));
        user.setEmail(request.getParameter("email"));
        System.out.println(user.getId());
        jdbcUserRepository.save(user);
    }
}

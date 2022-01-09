package org.softserveacademy.web.servlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.softserveacademy.service.impl.UserServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;

public class UpdateUserServlet extends HttpServlet {
    private final UserServiceImpl userServiceImpl = new UserServiceImpl();

    @Override
    public void init() {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        out.print("""
                <!DOCTYPE html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <title>Create new User</title>
                </head>
                <body>

                    <form action="/updateUserServlet" method="post">
                        <table>
                            <tr>
                               <td>
                                    <label for="name">ID : </label>
                                </td>
                                <td>
                                    <input type="text" id="id" name="id">
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label for="name">Username : </label>
                                </td>
                                <td>
                                    <input type="text" id="name" name="name">
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label for="email">Email : </label>
                                </td>
                                <td>
                                    <input type="text" id="email" name="email">
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <input type="submit" value="Update">
                                </td>
                                <td>
                                    <input type="reset" value="Clear">
                                </td>
                            </tr>
                        </table>
                    </form>

                </body>
                </html>""");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String idStr = request.getParameter("id");
        Integer id = Integer.parseInt(idStr);
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        userServiceImpl.update(id,name, email);
    }
}

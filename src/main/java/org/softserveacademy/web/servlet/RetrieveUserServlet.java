package org.softserveacademy.web.servlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.softserveacademy.service.impl.UserServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;

public class RetrieveUserServlet extends HttpServlet {
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
                           <title>Retrieve user by ID</title>
                       </head>
                       <body>
                           <form action="/retrieveUserServlet" method="post">
                               <table>
                                   <tr>
                                       <td>
                                           <label for="id">ID : </label>
                                       </td>
                                       <td>
                                           <input type="text" id="id" name="id">
                                       </td>
                                   </tr>
                                   <tr>
                                       <td>
                                           <input type="submit" value="Get User">
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
        //userServiceImpl.getById(id);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.getWriter().write(String.valueOf(userServiceImpl.getById(id)));
    }
}

package com.sample;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        User user = Validate.checkUser(email, pass);

        if(user.getUsername() != null && user.getPassword() != null)
        {
            out.println("Invalid email or password");
            RequestDispatcher rs = request.getRequestDispatcher("/register.html");
            rs.include(request, response);
        }
        else
        {
            if (Validate.addUser(email, pass)) {
                Validate.addUser(email, pass);
                RequestDispatcher rs = request.getRequestDispatcher("/index.html");
                rs.forward(request, response);
            } else {
                RequestDispatcher rs = request.getRequestDispatcher("/error.html");
                rs.forward(request, response);
            }
        }
    }
}

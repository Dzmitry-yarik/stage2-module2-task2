package com.example.servlet;

import com.example.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        Users user = (Users) session.getAttribute("user");

        if (user == null)
            resp.sendRedirect("/user/hello.jsp");
         else
            resp.sendRedirect("/login.jsp");


    }

     @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Users user = Users.getInstance();
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        boolean rightLogin = user.getUsers().contains(login);
        boolean rightPassword = password != null && !password.trim().isEmpty();

        if (rightLogin && rightPassword) {
            req.getSession().setAttribute("user", login);
            resp.sendRedirect("/user/hello.jsp");
        } else {
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }

    }
}

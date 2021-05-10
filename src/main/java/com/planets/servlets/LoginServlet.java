package com.planets.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

import com.planets.model.User;
import com.planets.utils.UserDAO;
import java.util.concurrent.atomic.AtomicReference;

@WebServlet(name = "LoginServlet", value = "/admin/login")
public class LoginServlet extends HttpServlet {
    private final String LOGIN_JSP = "/WEB-INF/view/login.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("errorAuthorization", false);
        getServletContext().getRequestDispatcher(LOGIN_JSP).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get user data for authorization
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        // Base validate data
        if (login == null || password == null) {
            response.setContentType("text/html");
            PrintWriter writer = response.getWriter();
            writer.println("<h1>Валидация данных не прошла</h1>");
            writer.close();
            return;
        }

        AtomicReference<UserDAO> userDAOAtomicReference = new AtomicReference<>(new UserDAO());
        User user = userDAOAtomicReference.get().getUserByLoginPassword(login, password);

        if (user == null) {
            request.setAttribute("errorAuthorization", true);
            getServletContext().getRequestDispatcher(LOGIN_JSP).forward(request, response);
            return;
        }

        HttpSession session = request.getSession();
        session.setAttribute("current-user", user);
        // Set timeout for session 1h or 3600sec
        session.setMaxInactiveInterval(3600);
        response.sendRedirect("/admin");
    }
}

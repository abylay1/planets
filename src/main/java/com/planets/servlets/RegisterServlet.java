package com.planets.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import com.planets.model.User;
import com.planets.utils.UserDAO;
import java.util.concurrent.atomic.AtomicReference;

@WebServlet(name = "RegisterServlet", value = "/admin/register")
public class RegisterServlet extends HttpServlet {
    private final String REGISTER_JSP = "/WEB-INF/view/register.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("isLoginExist", false);
        request.setAttribute("isSuccessRegister", false);
        getServletContext().getRequestDispatcher(REGISTER_JSP).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get user data for registration
        String firstName = request.getParameter("userFirstName");
        String lastName = request.getParameter("userLastName");
        String email = request.getParameter("userEmail");
        String login = request.getParameter("userLogin");
        String password = request.getParameter("userPassword");

        // Base validate data
        if (firstName == null || lastName == null || email == null || login == null || password == null) {
            response.setContentType("text/html");
            PrintWriter writer = response.getWriter();
            writer.println("<h1>Валидация данных не прошла</h1>");
            writer.close();
            return;
        }

        User user = new User(firstName, lastName, email, login, password);
        AtomicReference<UserDAO> userDAOAtomicReference = new AtomicReference<>(new UserDAO());

        if (userDAOAtomicReference.get().isLoginAlreadyExist(user.getLogin())) {
            request.setAttribute("isLoginExist", true);
            request.setAttribute("isSuccessRegister", false);
            getServletContext().getRequestDispatcher(REGISTER_JSP).forward(request, response);
            return;
        }

        int result = userDAOAtomicReference.get().createUser(user);

        if (result == 0) {
            response.setStatus(500);
            PrintWriter writer = response.getWriter();
            writer.println("<h1>Ошибка сервера</h1>");
            writer.close();
        } else {
            request.setAttribute("isLoginExist", false);
            request.setAttribute("isSuccessRegister", true);
            getServletContext().getRequestDispatcher(REGISTER_JSP).forward(request, response);
        }
    }
}

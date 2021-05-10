package com.planets.servlets;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private final String JSPLocation = "/WEB-INF/view/test.jsp";

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String name = request.getParameter("name");
        String surname = request.getParameter("surname");

        System.out.println(name);
        System.out.println(surname);

        HttpSession session = request.getSession();

        Integer count = (Integer) session.getAttribute("count");

        if (count == null) {
            session.setAttribute("count", 1);
            count = 1;
        } else {
            session.setAttribute("count", count + 1);
        }

        if (name == null) {
            name = "No data";
        }
        if (surname == null) {
            surname = "No data";
        }

        request.setAttribute("name", name);
        request.setAttribute("surname", surname);
        request.setAttribute("count", count);

        getServletContext().getRequestDispatcher(JSPLocation).forward(request, response);
    }

    public void destroy() {
    }
}
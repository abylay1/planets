package com.planets.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

import com.planets.model.Planet;
import com.planets.utils.PlanetDAO;

import java.util.concurrent.atomic.AtomicReference;
import com.planets.model.User;

@WebServlet(name = "HomeServlet", value = "/admin")
public class HomeServlet extends HttpServlet {
    private final String HOME_JSP = "/WEB-INF/view/home.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("current-user");
        request.setAttribute("user", user);

        AtomicReference<PlanetDAO> planetDAOAtomicReference = new AtomicReference<>(new PlanetDAO());
        ArrayList<Planet> planets = planetDAOAtomicReference.get().getAllPlanets();
        request.setAttribute("planets", planets);

        getServletContext().getRequestDispatcher(HOME_JSP).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

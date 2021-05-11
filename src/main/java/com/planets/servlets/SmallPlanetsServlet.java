package com.planets.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

import com.planets.model.Planet;
import com.planets.model.User;
import com.planets.utils.PlanetDAO;

import java.util.concurrent.atomic.AtomicReference;
@WebServlet(name = "SmallPlanetsServlet", value = "/admin/small-planets")
public class SmallPlanetsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("current-user");
        request.setAttribute("user", user);

        AtomicReference<PlanetDAO> planetDAOAtomicReference = new AtomicReference<>(new PlanetDAO());
        ArrayList<Planet> planets = planetDAOAtomicReference.get().getSmallPlanets();
        request.setAttribute("planets", planets);
        request.setAttribute("page", "small-planets");

        getServletContext().getRequestDispatcher("/WEB-INF/view/home.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

package com.planets.servlets;

import com.planets.model.Planet;
import com.planets.model.User;
import com.planets.utils.PlanetDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

@WebServlet(name = "CalculateServlet", value = "/admin/calculate")
public class CalculateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("current-user");
        request.setAttribute("user", user);

        AtomicReference<PlanetDAO> planetDAOAtomicReference = new AtomicReference<>(new PlanetDAO());
        ArrayList<Planet> planets = planetDAOAtomicReference.get().getAllPlanets();
        request.setAttribute("planets", planets);
        request.setAttribute("distance", null);

        getServletContext().getRequestDispatcher("/WEB-INF/view/calculate.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("current-user");
        request.setAttribute("user", user);

        AtomicReference<PlanetDAO> planetDAOAtomicReference = new AtomicReference<>(new PlanetDAO());
        ArrayList<Planet> planets = planetDAOAtomicReference.get().getAllPlanets();
        request.setAttribute("planets", planets);

        int id1 = Integer.parseInt(request.getParameter("first-planet-ID"));
        int id2 = Integer.parseInt(request.getParameter("second-planet-ID"));
        Planet planet1 = planetDAOAtomicReference.get().getPlanetByID(id1);
        Planet planet2 = planetDAOAtomicReference.get().getPlanetByID(id2);

        int distance = Planet.calculateDistance(planet1, planet2);
        request.setAttribute("distance", distance);
        request.setAttribute("planet1", planet1);
        request.setAttribute("planet2", planet2);

        getServletContext().getRequestDispatcher("/WEB-INF/view/calculate.jsp").forward(request, response);
    }
}

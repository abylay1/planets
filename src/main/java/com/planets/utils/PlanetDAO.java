package com.planets.utils;

import java.sql.*;
import com.planets.model.Planet;
import java.util.ArrayList;

public class PlanetDAO {
    private static final String DB_URL = "jdbc:mysql://localhost/planets";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "root";

    public PlanetDAO() {

    }

    public ArrayList<Planet> getAllPlanets() {
        ArrayList<Planet> planets = new ArrayList<Planet>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();

            try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)){

                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM planets");

                while(resultSet.next()){

                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    String mass = resultSet.getString(3);
                    int area = resultSet.getInt(4);
                    int distance = resultSet.getInt(5);
                    int periodCircle = resultSet.getInt(6);
                    double radius = resultSet.getDouble(7);
                    double gravity = resultSet.getDouble(8);
                    boolean small = resultSet.getBoolean(9);
                    boolean big = resultSet.getBoolean(10);
                    String image = resultSet.getString(11);

                    Planet planet = new Planet(id, name, mass, area, distance, periodCircle, radius, gravity, big, small, image);
                    planets.add(planet);
                }
            }
        }
        catch (Exception exception){
            System.err.println("Some error with DataBase in PlanetDAO.java");
            System.err.println(exception);
        }
        return planets;
    }

}

package com.planets.utils;

import java.sql.*;
import com.planets.model.User;
import at.favre.lib.crypto.bcrypt.BCrypt;

public class UserDAO {
    private static final String DB_URL = "jdbc:mysql://localhost/planets";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "root";
    private static final int BCRYPT_PASS_HASH_COST = 6;

    public UserDAO() {

    }

    public User getUserByLoginPassword(String login, String password) {
        User user = null;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();

            try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)){

                String sql = "SELECT * FROM users WHERE login = ?, password = ?";

                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, login);
                    String hashedPassword = UserDAO.hashPassword(password);
                    preparedStatement.setString(2, hashedPassword);
                    ResultSet resultSet = preparedStatement.executeQuery();

                    if(resultSet.next()){
                        int userId = resultSet.getInt(1);
                        String userFirstName = resultSet.getString(2);
                        String userLastName = resultSet.getString(3);
                        String userEmail = resultSet.getString(4);
                        String userLogin = resultSet.getString(5);
                        String userPassword = resultSet.getString(6);

                        user = new User(userFirstName, userLastName, userEmail, userLogin, userPassword);
                    } else {
                        System.err.println("No such user by this login and pass");
                    }
                }
            }
        }
        catch(Exception ex){
            System.err.println("Some error with DataBase in UserDAO.java");
            System.err.println(ex);
        }
        return user;
    }

    public int createUser(User newUser) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();

            try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)){

                String sql = "INSERT INTO users (first_name, last_name, email, login, password) Values (?, ?, ?, ?, ?)";

                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, newUser.getFirstName());
                    preparedStatement.setString(2, newUser.getLastName());
                    preparedStatement.setString(3, newUser.getEmail());
                    preparedStatement.setString(4, newUser.getLogin());

                    // Get hash with bcrypt
                    String hashedPassword = UserDAO.hashPassword(newUser.getPassword());
                    newUser.setPassword(hashedPassword);

                    preparedStatement.setString(5, newUser.getPassword());
                    return preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.err.println("Some error with DataBase in UserDAO.java");
            System.err.println(ex);
        }
        return 0;
    }

    private static String hashPassword(String password) {
        return BCrypt.withDefaults().hashToString(BCRYPT_PASS_HASH_COST, password.toCharArray());
    }
}

package com.infinite.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcConnections  {

	public static void main(String[] args) {
        // Database connection parameters
    	
        String jdbcUrl = "jdbc:mysql://localhost:3305/your_database";
        String jdbcUser = "root";
        String jdbcPassword = "Victor@2307";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword)) {
            // Insert a new record
            insertRecord(connection, "John Doe", 25);

            // Delete a record
            deleteRecord(connection, "John Doe");

            // Update a record
            updateRecord(connection, "Jane Smith", 30, "John Doe");

            System.out.println("Operations completed successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Insert a new record
    private static void insertRecord(Connection connection, String name, int age) throws SQLException {
        String insertSQL = "INSERT INTO your_table (name, age) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, age);
            preparedStatement.executeUpdate();
        }
    }

    // Delete a record
    private static void deleteRecord(Connection connection, String name) throws SQLException {
        String deleteSQL = "DELETE FROM your_table WHERE name = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL)) {
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
        }
    }

    // Update a record
    private static void updateRecord(Connection connection, String newName, int newAge, String oldName) throws SQLException {
        String updateSQL = "UPDATE your_table SET name = ?, age = ? WHERE name = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(updateSQL)) {
            preparedStatement.setString(1, newName);//can be achieved using 4th step.
            preparedStatement.setInt(2, newAge);
            preparedStatement.setString(3, oldName);
            preparedStatement.executeUpdate();
        }
        }
    }    
        	
        
	



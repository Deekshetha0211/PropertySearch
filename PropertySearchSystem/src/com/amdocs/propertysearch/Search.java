package com.amdocs.propertysearch;

import com.amdocs.DbOperation.PropertyDAO;
import com.amdocs.connection.DatabaseConnection;
import com.amdocs.exception.PropertySearchException;
import com.amdocs.pojo.Property;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Search {
    private PropertyDAO propertyDAO;
    private Connection connection;
    
    public Search() {
        // Initialize PropertyDAO and database connection
        propertyDAO = new PropertyDAO();
        connection = DatabaseConnection.getConnection();
    }
    
    // Helper method to map ResultSet to Property object (List returning)
    private Property mapResultSetToProperty(ResultSet resultSet) throws SQLException {
        int propertyId = resultSet.getInt("property_id");
        String noOfRooms = resultSet.getString("no_of_rooms");
        float areaInSqft = resultSet.getFloat("area_in_sqft");
        int floorNo = resultSet.getInt("floor_no");
        String city = resultSet.getString("city");
        String state = resultSet.getString("state");
        float cost = resultSet.getFloat("cost");
        String ownerName = resultSet.getString("owner_name");
        String ownerContactNo = resultSet.getString("owner_contact_no");
        
        Property property = new Property(propertyId, noOfRooms, areaInSqft, floorNo, city, state, cost, ownerName, ownerContactNo);
        
        return property;
    }

    // Search properties by city
    public List<Property> searchByCity(String city) throws PropertySearchException {
        String sql = "SELECT * FROM PROPERTY WHERE LOWER(city) = LOWER(?)";
        List<Property> properties = new ArrayList<>();
        
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, city);
            
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Property property = mapResultSetToProperty(resultSet);
                    properties.add(property);
                }
                
                if (properties.isEmpty()) {
                    throw new PropertySearchException("Property not available");
                }
            }
        } catch (SQLException e) {
            throw new PropertySearchException("Error in searching, e");
        }
        
        return properties;
    }
    
    // Search properties by cost range
    public List<Property> searchByCost(float minCost, float maxCost) throws PropertySearchException {
        String sql = "SELECT * FROM PROPERTY WHERE cost BETWEEN ? AND ?";
        List<Property> properties = new ArrayList<>();
        
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setFloat(1, minCost);
            statement.setFloat(2, maxCost);
            
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Property property = mapResultSetToProperty(resultSet);
                    properties.add(property);
                }
                
                if (properties.isEmpty()) {
                    throw new PropertySearchException("Property not available");
                }
            }
        } catch (SQLException e) {
            throw new PropertySearchException("Error in searching");
        }
        
        return properties;
    }

    // Search properties by number of rooms and city
    public List<Property> searchByNoOfRoomsAndCity(String noOfRooms, String city) throws PropertySearchException {
        String sql = "SELECT * FROM PROPERTY WHERE no_of_rooms = ? AND LOWER(city) = LOWER(?)";
        List<Property> properties = new ArrayList<>();
        
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, noOfRooms);
            statement.setString(2, city);
            
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Property property = mapResultSetToProperty(resultSet);
                    properties.add(property);
                }
                
                if (properties.isEmpty()) {
                    throw new PropertySearchException("Property not available");
                }
            }
        } catch (SQLException e) {
            throw new PropertySearchException("Error in searching");
        }
        
        return properties;
    }

    // Close the database connection
    public void close() {
        propertyDAO.close();
    }
}

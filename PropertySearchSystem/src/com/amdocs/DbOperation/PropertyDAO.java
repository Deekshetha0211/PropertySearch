package com.amdocs.DbOperation;

import com.amdocs.connection.*;
import com.amdocs.exception.PropertySearchException;
import com.amdocs.pojo.Property;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PropertyDAO {
    private Connection connection;

	public PropertyDAO() {
	        connection = DatabaseConnection.getConnection();
	    }

	    public int addProperty(Property property)throws PropertySearchException {
	        String sql = "INSERT INTO PROPERTY (property_id, no_of_rooms, area_in_sqft, floor_no, city, state, cost, owner_name, owner_contact_no) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
	        	statement.setInt(1, property.getPropertyId());
	        	statement.setString(2, property.getNoOfRooms());
	            statement.setFloat(3, property.getAreaInSqft());
	            statement.setInt(4, property.getFloorNo());
	            statement.setString(5, property.getCity());
	            statement.setString(6, property.getState());
	            statement.setFloat(7, property.getCost());
	            statement.setString(8, property.getOwnerName());
	            statement.setString(9, property.getOwnerContactNo());

	            int affectedRows = statement.executeUpdate();
	            if (affectedRows == 0) {
	                throw new SQLException("Adding property failed, no rows affected.");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            
	            return -1; // Return a negative value to indicate failure
	        }
			return 0;
	    }

	    public int deleteProperty(int propertyId) throws PropertySearchException {
	        String sql = "DELETE FROM PROPERTY WHERE property_id = ?";
	        try (PreparedStatement statement = connection.prepareStatement(sql)) {
	            statement.setInt(1, propertyId);
	            return statement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            System.out.println("Property is not found");
	            return -1; // Return a negative value to indicate failure
	        }
	    }

	    public boolean updatePropertyCost(int propertyId, float newCost) throws PropertySearchException {
	        String sql = "UPDATE PROPERTY SET cost = ? WHERE property_id = ?";
	        try (PreparedStatement statement = connection.prepareStatement(sql)) {
	            statement.setDouble(1, newCost);
	            statement.setInt(2, propertyId);
	            return statement.executeUpdate() > 0; 
	        } catch (SQLException e) {
	            e.printStackTrace();
	            System.out.println("Property is not found");
	            return false;
	        }
	    }


	    public List<Property> showAllProperties() throws PropertySearchException {
	        String sql = "SELECT * FROM PROPERTY";
	        List<Property> properties = new ArrayList<>();
	        try (Statement statement = connection.createStatement();
	             ResultSet resultSet = statement.executeQuery(sql)) {
	            while (resultSet.next()) {
	                Property property = mapResultSetToProperty(resultSet);
	                properties.add(property);
	            }
	  
	        } 
	        catch (SQLException e) {
	            e.printStackTrace();

	        }
	        return properties;
	    }

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
	        
	        Property property = new Property(propertyId,noOfRooms,areaInSqft,floorNo,city,state,cost,ownerName,ownerContactNo);
	        
	        return property;
	    }

	    public void close() {
	    }
	}

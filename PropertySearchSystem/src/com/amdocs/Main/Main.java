package com.amdocs.Main;

import com.amdocs.DbOperation.PropertyDAO;
import com.amdocs.exception.PropertySearchException;
import com.amdocs.pojo.Property;
import com.amdocs.propertysearch.Search;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PropertyDAO propertyDAO = new PropertyDAO();
        @SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
        int propertyId;
        String noOfRooms;
        float areaInSqft;
        int floorNo;
        String city;
        String state;
        float cost;
        float mincost;
        float maxcost;
        String ownerName;
        String ownerContactNo;
        
        System.out.println("Property Search System has started:");
        while (true) {
        	PropertyDAO propertydao;
            Search search;
            Property property;
            // Display the menu and get user's choice
            System.out.println("Enter your choice:");
            System.out.println("1. Add new property");
            System.out.println("2. Update property cost");
            System.out.println("3. Delete property");
            System.out.println("4. Find by city");
            System.out.println("5. View all properties");
            System.out.println("6. Find by cost");
            System.out.println("7. Find by no. of rooms and city");
            System.out.println("8. Exit");

            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    // Add new property
                    // Read property details from the user and call propertyDAO.addProperty
                	System.out.print("Enter property ID:");
                	propertyId = scanner.nextInt();
                	
                	System.out.print("Enter the no of roooms (in terms of BHK):");
                	noOfRooms = scanner.next();
                    
                	System.out.print("Enter the area in sqft:");
                    areaInSqft = scanner.nextFloat();
                    
                    System.out.print("Enter the floor No.:");
                    floorNo = scanner.nextInt();
                    
                    System.out.print("Enter the city:");
                    city = scanner.next().toUpperCase();
                    
                    System.out.print("Enter the state:");
                    state = scanner.next();
                    
                    System.out.print("Enter the cost:");
                    cost = scanner.nextFloat();
                    
                    System.out.print("Enter the owner name:");
                    ownerName = scanner.next();
                    
                    System.out.print("Enter owner contact number:");
                    ownerContactNo = scanner.next();
  
                	propertydao = new PropertyDAO();
                    property = new Property(propertyId,noOfRooms,areaInSqft,floorNo,city,state,cost,ownerName,ownerContactNo);
                    System.out.println(property.toString());
                    try {
            			int r = propertydao.addProperty(property);
            			if (r == 0){
            				System.out.println("Property Added successfully");
            			}
            		} catch (PropertySearchException e) {
            			// TODO Auto-generated catch block
            			e.printStackTrace();
            		}
                	break;
                case 2:
                    // Update property cost
                    // Read property ID and new cost from the user and call propertyDAO.updatePropertyCost
                	System.out.print("Enter property ID:");
                	propertyId = scanner.nextInt();
                    
                	System.out.print("Enter the cost:");
                	cost = scanner.nextFloat();
                    propertydao = new PropertyDAO();
                    try {
            			boolean r = propertydao.updatePropertyCost(propertyId,cost);
            			if (r){
            				System.out.println("Property Updated successfully");
            			}
            		} catch (PropertySearchException e) {
            			// TODO Auto-generated catch block
            			e.printStackTrace();
            		}
                	break;
                case 3:
                    // Delete property
                    // Read property ID from the user and call propertyDAO.deleteProperty
                	System.out.print("Enter property ID:");
                	propertyId = scanner.nextInt();
                    
                    propertydao = new PropertyDAO();
                    try {
            			int r = propertydao.deleteProperty(propertyId);
            			if (r!=0)
            			{
            				System.out.println("Property Deleted successfully");
            			}
            			else {
            				System.out.println("Property not found");
            			}
            		} catch (PropertySearchException e) {
            			// TODO Auto-generated catch block
            			e.printStackTrace();
            		}
                    break;
                case 4:
                    // Find by city
                    // Read city name from the user and call propertyDAO.searchByCity
                	System.out.print("Enter the city:");
                	city = scanner.next().toUpperCase();
     
                    search = new Search();
                    
                    try {
            			List<Property> r = search.searchByCity(city);
            			
            			if (!r.isEmpty()){
            				System.out.println("Property found successfully");
            				for (int i=0;i<r.size();i++)
            				{
            					System.out.println(r.get(i).toString());
            				}
            				
            			}
            		} catch (PropertySearchException e) {
            			// TODO Auto-generated catch block
            			e.printStackTrace();
            		}
                    search.close();
                    break;
                    
                case 5:
                    // View all properties
                    // Call propertyDAO.showAllProperties and display the results
                    propertydao = new PropertyDAO();
                    try {
            			List<Property> r = propertydao.showAllProperties();
            			
            			if (!r.isEmpty()){
            				System.out.println("Properties found successfully");
            				for (int i=0;i<r.size();i++)
            				{
            					System.out.println(r.get(i).toString());
            				}
            				
            			}
            		} catch (PropertySearchException e) {
            			// TODO Auto-generated catch block
            			e.printStackTrace();
            		}
                    break;
                case 6:
                    // Find by cost
                    // Read and max cost from the user and call propertyDAO.searchByCost
                	System.out.print("Enter the Minimum cost:");
                	mincost = scanner.nextFloat();
                	System.out.print("Enter the Maximum cost:");
                    maxcost = scanner.nextFloat();
                    search = new Search();
                    
                    try {
            			List<Property> r = search.searchByCost(mincost,maxcost);
            			
            			if (!r.isEmpty()){
            				System.out.println("Property found successfully");
            				for (int i=0;i<r.size();i++)
            				{
            					System.out.println(r.get(i).toString());
            				}
            				
            			}
            			else
            			{
            				System.out.println("No properties found in the specified cost range");
            			}
            		} catch (PropertySearchException e) {
            			// TODO Auto-generated catch block
            			e.printStackTrace();
            		}
                    search.close();
                    break;
                case 7:
                    // Find by no of rooms and city
                    // Read number of rooms and city from the user and call propertyDAO.searchByNoOfRoomsAndCity
                	System.out.print("Enter the no of roooms (in terms of BHK):");
                	noOfRooms = scanner.next();
                	System.out.print("Enter the city:");
                	city = scanner.next().toUpperCase();
                    
                    search = new Search();
                    
                    try {
            			List<Property> r = search.searchByNoOfRoomsAndCity(noOfRooms,city);
            			
            			if (!r.isEmpty()){
            				System.out.println("Property found successfully");
            				for (int i=0;i<r.size();i++)
            				{
            					System.out.println(r.get(i).toString());
            				}
            				
            			}
            			else
            			{
            				System.out.println("No properties found in the specified requirement");
            			}
            			
            		} catch (PropertySearchException e) {
            			// TODO Auto-generated catch block
//            			e.printStackTrace();
            		}
                    search.close();
                    break;
                case 8:
                    // Exit
                	System.out.println("Thanks for visiting the property search system");
                	propertyDAO.close();
                    System.exit(0);
                    
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            } 
        }
    }
}



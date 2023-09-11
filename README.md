# PropertySearch
# 1. Introduction

# Purpose of the Document
The purpose of this document is to provide an overview of the Property Search System project developed using Core Java. It outlines the system's requirements, architecture, features, user interface.

# Project Overview
The Property Search System is a console-based application that allows users to perform various property search activities such as property details management, view all properties, search properties by city, cost and more. The system aims to provide user-friendly interface for property owners and buyers to access their property details and search it as per requirement.
Note: for core java track participants will do this project as console-based menu driven code.

# Scope
The scope of the Property Search System project includes the following functionalities:
- Property management (add, update, delete properties).
- View all properties available for sale.
- Search properties by city, by cost range 
- Search by no of rooms(1BHK/2BHK) and city.

# 2. System Requirements

# Functional Requirements
1. Property Management: Users should be able to add, update, and delete their property details.
2. View All: Users should be able to view all properties available for sale.
3. Search by city: Users should be able to search properties by city.
4. Search by cost range: Users should be able to search properties by cost range(between min and max cost)
5. Search by no of rooms and city: Users should be able to search properties by number of rooms (1BHK/2BHK) as well as city

# 4. User Interface
The Property Search System should have menu to select operation to perform. Wherever search operation doesn’t return any result, show appropriate message. E.g., If for given city property doesn’t exist , show message “Property not available”.
Menu should have below options
Enter your choice:
1. Add new property
2. Update property cost
3. Delete property
4. Find by city
5. View all properties
6. Find by cost
7. Find by no of rooms and city
8. Exit
After user selects one option, take input from user wherever applicable. E.g. If option 6 is selected, application should ask to enter city name and then show result.

# 5. Technologies Used
Core Java, JDBC, Oracle

# 6. Conclusion
The Property Search System will help property owner to advertise their properties for sale  and buyers can search it as per their requirement.

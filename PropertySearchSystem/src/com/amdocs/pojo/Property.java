package com.amdocs.pojo;

public class Property {
    // Private fields to represent property details
    private int propertyId;
    private String noOfRooms;
    private float areaInSqft;
    private int floorNo;
    private String city;
    private String state;
    private float cost;
    private String ownerName;
    private String ownerContactNo;

    // Constructor to initialize a Property object
    public Property(int propertyId, String noOfRooms, float areaInSqft, int floorNo, String city, String state,
            float cost, String ownerName, String ownerContactNo) {
        this.propertyId = propertyId;
        this.noOfRooms = noOfRooms;
        this.areaInSqft = areaInSqft;
        this.floorNo = floorNo;
        this.city = city;
        this.state = state;
        this.cost = cost;
        this.ownerName = ownerName;
        this.ownerContactNo = ownerContactNo;
    }

    // Getter and Setter methods for each property field
    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    public String getNoOfRooms() {
        return noOfRooms;
    }

    public void setNoOfRooms(String noOfRooms) {
        this.noOfRooms = noOfRooms;
    }

    public float getAreaInSqft() {
        return areaInSqft;
    }

    public void setAreaInSqft(float areaInSqft) {
        this.areaInSqft = areaInSqft;
    }

    public int getFloorNo() {
        return floorNo;
    }

    public void setFloorNo(int floorNo) {
        this.floorNo = floorNo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerContactNo() {
        return ownerContactNo;
    }

    public void setOwnerContactNo(String ownerContactNo) {
        this.ownerContactNo = ownerContactNo;
    }

    // Override the toString() method to provide a string representation of the object
    @Override
    public String toString() {
        return "Property: [propertyId=" + propertyId + ", noOfRooms=" + noOfRooms + ", areaInSqft=" + areaInSqft
                + ", floorNo=" + floorNo + ", city=" + city + ", state=" + state + ", cost=" + cost + ", ownerName="
                + ownerName + ", ownerContactNo=" + ownerContactNo + "]";
    }
}
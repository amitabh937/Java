package com.amit.mep.controller;

public class ProjectRequest {
    private double area;
    private int floors;
    private String mepType;
    
    // Getters and Setters
    public double getArea() { return area; }
    public void setArea(double area) { this.area = area; }
    public int getFloors() { return floors; }
    public void setFloors(int floors) { this.floors = floors; }
    public String getMepType() { return mepType; }
    public void setMepType(String mepType) { this.mepType = mepType; }
}

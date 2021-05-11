package com.planets.model;

public class Planet {
    private int ID;
    private String name;
    private String mass;
    private int area;
    private int distance;
    private int periodCircle;
    private double radius;
    private double gravity;
    private boolean small = false;
    private boolean big = false;
    private String image;

    public Planet() {

    }

    public Planet(int ID, String name, String mass, int area, int distance, int periodCircle, double radius, double gravity, boolean big, boolean small, String image) {
        this.ID = ID;
        this.name = name;
        this.mass = mass;
        this.area = area;
        this.distance = distance;
        this.periodCircle = periodCircle;
        this.radius = radius;
        this.gravity = gravity;
        this.big = big;
        this.small = small;
        this.image = image;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMass() {
        return mass;
    }

    public void setMass(String mass) {
        this.mass = mass;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getPeriodCircle() {
        return periodCircle;
    }

    public void setPeriodCircle(int periodCircle) {
        this.periodCircle = periodCircle;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getGravity() {
        return gravity;
    }

    public void setGravity(double gravity) {
        this.gravity = gravity;
    }

    public boolean isSmall() {
        return small;
    }

    public void setSmall(boolean small) {
        this.small = small;
    }

    public boolean isBig() {
        return big;
    }

    public void setBig(boolean big) {
        this.big = big;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

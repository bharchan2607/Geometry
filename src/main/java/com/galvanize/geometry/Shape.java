package com.galvanize.geometry;

public abstract class Shape {
    private String color = "Burnt Umber";
    private Point centerLocation;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public abstract double getPerimeter();

    public abstract double getArea();

    public Point getCenterLocation() {
        return this.centerLocation;
    }

    public void setCenterLocation(Point centerLocation) {
        this.centerLocation = centerLocation;
    }

    public abstract String display(boolean onPlane);
}

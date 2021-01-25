package com.galvanize.geometry;

public abstract class Shape {
    private String color = "Burnt Umber";

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public abstract double getPerimeter();

    public abstract double getArea();
}

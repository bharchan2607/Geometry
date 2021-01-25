package com.galvanize.geometry;

public class Circle {
    private int radius;

    public Circle(int radius){
        this.radius = radius;
    }

    public Circle(){
        this.radius = 1;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}

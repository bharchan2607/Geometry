package com.galvanize.geometry;

public class Circle extends Shape {
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

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * this.radius;
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(this.radius,2);
    }

    @Override
    public String display(boolean onPlane) {
        if (getCenterLocation() != null) {

                return "circle of radius <" + this.getRadius() + "> at (" +
                        getCenterLocation().getXCoordinate() + "," +
                        getCenterLocation().getYCoordinate()
                        + ")";
            } else {
                return "circle of radius <" + this.getRadius() + ">";
            }
    }

}

package com.galvanize.geometry;

public class Rectangle extends Shape {
    private int length;
    private int width;

    public Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public Rectangle() {
        this.length = 1;
        this.width = 1;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public double getPerimeter(){
        return 2 * (this.length+this.width);
    }

    public double getArea(){
        return this.length * this.width;
    }

    @Override
    public String display(boolean onPlane) {
        if (getCenterLocation() != null) {
            return "<" + this.getLength() + "> X <" + this.getWidth() + "> rectangle at (" +
                    getCenterLocation().getXCoordinate() + "," +
                    getCenterLocation().getYCoordinate()
                    + ")";
        } else {
            return "<" + this.getLength() + "> X <" + this.getWidth() + "> rectangle";
        }
    }


}

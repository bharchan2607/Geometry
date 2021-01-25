package com.galvanize.geometry;

public class Point {
    private double xCoordinate;
    private double yCoordinate;

    public Point(double x, double y) {
        this.xCoordinate = x;
        this.yCoordinate = y;
    }

    public double getXCoordinate() {
        return this.xCoordinate;
    }

    public double getYCoordinate() {
        return this.yCoordinate;
    }
}

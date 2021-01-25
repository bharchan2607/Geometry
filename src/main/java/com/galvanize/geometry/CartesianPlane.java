package com.galvanize.geometry;

public class CartesianPlane {
    private Shape shape;
    private Point point;
    public CartesianPlane(Shape shape, Point point) {
        this.shape = shape;
        this.point = point;
    }


    public void setCenterLocation() {
        shape.setCenterLocation(point);
    }

    public Point retrieveLocation(Shape shape){
        return shape.getCenterLocation();
    }

    public Shape getShape() {
        return shape;
    }

    public Point getPoint() {
        return point;
    }
}

package com.galvanize.geometry;

import java.util.ArrayList;
import java.util.List;

public class CartesianPlane {
    List<Shape> shapeList;

    public CartesianPlane() {
        shapeList = new ArrayList<Shape>();
    }

    public void addShapesOnPlane(Shape shape, Point point){
        shape.setCenterLocation(point);
        shapeList.add(shape);
    }

    public Point retrieveLocation(Shape shape){
        int index =this.shapeList.indexOf(shape);
        if(index >= 0 ) {
            return this.shapeList.get(index).getCenterLocation();
        }
        return null;
    }

    public List<Shape> getShapeList() {
        return shapeList;
    }

    public void move(Shape shape, Point point2) {
        Point point = retrieveLocation(shape);
        Point newPoint = new Point(
                point.getXCoordinate()+point2.getXCoordinate(),
                point.getYCoordinate()+ point2.getYCoordinate());
        shape.setCenterLocation(newPoint);
    }
    //d=sqrt((x2−x1)2+(y2−y1)2)
    public double distance(Shape rectangleShape, Shape circleShape) {
        Point rectangularPoint = retrieveLocation(rectangleShape);
        Point circlePoint = retrieveLocation(circleShape);
        double xCoordinateDiff = circlePoint.getXCoordinate() - rectangularPoint.getXCoordinate();
        double yCoordinateDiff = circlePoint.getYCoordinate() - rectangularPoint.getYCoordinate();
        return Math.sqrt(
                Math.pow(xCoordinateDiff,2)
                + Math.pow(yCoordinateDiff,2));
    }


    public String display(Shape shape) {
        Point locationPoint = retrieveLocation(shape);
        if(shape instanceof Rectangle) {
            Rectangle rectangle = (Rectangle) shape;
            if (locationPoint != null) {
                return "<" + rectangle.getLength() + "> X <" + rectangle.getWidth() + "> rectangle at (" +
                        locationPoint.getXCoordinate() + "," +
                        locationPoint.getYCoordinate()
                        + ")";
            } else {
                return "<" + rectangle.getLength() + "> X <" + rectangle.getWidth() + "> rectangle";
            }
        }else if(shape instanceof Circle) {
            Circle circle = (Circle) shape;
            if (locationPoint != null) {

                return "circle of radius <" + circle.getRadius() + "> at (" +
                        locationPoint.getXCoordinate() + "," +
                        locationPoint.getYCoordinate()
                        + ")";
            } else {
                return "circle of radius <" + circle.getRadius() + ">";
            }
        }
        return null;
    }
}

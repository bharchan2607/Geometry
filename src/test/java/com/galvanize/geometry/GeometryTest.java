package com.galvanize.geometry;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class GeometryTest {

    /**
     * When I create a rectangle with a length and width
     * Then I can retrieve the length and width from the rectangle
     */
    @Test
    public void getLengthAndWidth_rectangle(){
        Rectangle rectangle = new Rectangle(3,5);
        assertEquals(3, rectangle.getLength());
        assertEquals(5, rectangle.getWidth());
    }

    /**
     * When I create a rectangle without a length and width
     * Then the length and width I retrieve are both 1
     */
    @Test
    public void getLengthAndWidth_returnOne_rectangle(){
        Rectangle rectangle = new Rectangle();
        assertEquals(1,rectangle.getLength());
        assertEquals(1, rectangle.getWidth());
    }

    /**
     * When I change the width of the rectangle
     * Then the width I retrieve is the new width
     *
     * When I change the length of the rectangle
     * Then the length I retrieve is the new length
     */
    @Test
    public void changeLengthAndWidth_rectangle(){
        Rectangle rectangle = new Rectangle(3,5);
        assertEquals(3, rectangle.getLength());
        assertEquals(5, rectangle.getWidth());
        rectangle.setLength(5);
        assertEquals(5, rectangle.getLength());
        rectangle.setWidth(7);
        assertEquals(7, rectangle.getWidth());
    }

    /**
     * When I create a circle with a radius
     * Then I can retrieve the radius from the circle
     */
    @Test
    public void createCirleWithRadius(){
        Circle circle = new Circle(10);
        assertEquals(10, circle.getRadius());
    }

    /**
     * When I create a circle without a radius
     * Then the radius I retrieve is 1
     */
    @Test
    public void createCirleWithoutRadius(){
        Circle circle = new Circle();
        assertEquals(1, circle.getRadius());
    }

    /**
     * When I change the radius of a circle
     * Then the radius I retrieve is the new radius
     */
    @Test
    public void changeRadiusOfACircle(){
        Circle circle = new Circle(6);
        assertEquals(6, circle.getRadius());
        circle.setRadius(8);
        assertEquals(8, circle.getRadius());
    }

    /**
     * When I set the color of any shape
     * Then I can retrieve the color of that shape
     *
     * When I have not set the color of a shape
     * Then the color I retrieve is “Burnt Umber"
     */
    @Test
    public void getColorOfShape(){
        Shape shape = new Rectangle();
        shape.setColor("Yellow");
        assertEquals("Yellow", shape.getColor());
        Shape circleShape = new Circle();
        assertEquals("Burnt Umber", circleShape.getColor());

    }

    /**
     * When I have a shape
     * Then I can retrieve its perimeter
     */
    @Test
    public void getPerimeterOfShape(){
        Shape shape = new Rectangle(5,6);
        assertEquals(2 * (5+6),shape.getPerimeter());
        Shape circleShape = new Circle(4);
        assertEquals(2*Math.PI*4, circleShape.getPerimeter());
    }

    /**
     * When I have a shape
     * Then I can retrieve its area
     */
    @Test
    public void getAreaOfShape(){
        Shape shape = new Rectangle(5,6);
        assertEquals(30, shape.getArea());
        Shape circleShape = new Circle(4);
        assertEquals(Math.PI*Math.pow(4,2), circleShape.getArea());
    }
    /**
     * When I create a point (x,y)
     * Then I can retrieve its x and y coordinates
     */
    @Test
    public void createPoint(){
        Point point = new Point(5, 3);
        assertEquals(5, point.getXCoordinate());
        assertEquals(3, point.getYCoordinate());
    }
    /**
     * When I have a shape and a point
     * Then I can set the shape’s center location to the point
     */
    @Test
    public void placeShapeOnCartesianPlane(){
        Shape rectangleShape = new Rectangle(5,6);
        Point point = new Point(2,3);
        CartesianPlane cartesianPlane = new CartesianPlane();
        cartesianPlane.addShapesOnPlane(rectangleShape, point);

        assertTrue(cartesianPlane.getShapeList().contains(rectangleShape));
        assertEquals(point,cartesianPlane.getShapeList().get(0).getCenterLocation());


        //Circle
        Shape circleShape = new Circle(5);
        Point point1 = new Point(2,3);
        cartesianPlane.addShapesOnPlane(circleShape, point1);

        assertTrue(cartesianPlane.getShapeList().contains(circleShape));
        assertEquals(point1,cartesianPlane.getShapeList().get(1).getCenterLocation());

    }

    /**
     * When I have a shape that’s been placed on my plane
     * Then I can retrieve the point at which it is located
     */
    @Test
    public void retrieveCenterLocationOfShape(){
        Shape rectangleShape = new Rectangle(5,6);
        Point point = new Point(2,3);
        CartesianPlane cartesianPlane = new CartesianPlane();
        cartesianPlane.addShapesOnPlane(rectangleShape, point);

        assertEquals(2, cartesianPlane.retrieveLocation(rectangleShape).getXCoordinate());
        assertEquals(3, cartesianPlane.retrieveLocation(rectangleShape).getYCoordinate());

        //Circle
        Shape circleShape = new Circle(5);
        Point point1 = new Point(2,3);
        CartesianPlane cartesianPlane1 = new CartesianPlane();
        cartesianPlane1.addShapesOnPlane(circleShape, point1);
        assertEquals(2, cartesianPlane1.retrieveLocation(circleShape).getXCoordinate());
        assertEquals(3, cartesianPlane1.retrieveLocation(circleShape).getYCoordinate());
    }

    /**
     * When I have a shape that’s not been placed on my plane
     * Then attempting to retrieve its location informs me that the shape is not on the plane
     */
    @Test
    public void retrieveCenterLocationOfShapeNotOnPlane() {
        Shape rectangleShape = new Rectangle(5, 6);
        Point point = new Point(2, 3);
        CartesianPlane cartesianPlane = new CartesianPlane();
        cartesianPlane.addShapesOnPlane(rectangleShape, point);
        Shape circleShape = new Circle(5);
        assertEquals(point, cartesianPlane.retrieveLocation(rectangleShape));
        assertEquals(null, cartesianPlane.retrieveLocation(circleShape));

    }

    /**
     * When I have a point
     * Then if I give that point an (x, y) offset
     * Then the point changes to the sum of its coordinates and those I’ve provided
     */
    @Test
    public void moveAnyShapeOnPlane(){
        Shape rectangleShape = new Rectangle(5, 6);
        Point point = new Point(2, 3);
        Shape circleShape = new Circle(5);
        Point point1 = new Point(6, 8);
        CartesianPlane cartesianPlane = new CartesianPlane();
        cartesianPlane.addShapesOnPlane(rectangleShape, point);
        cartesianPlane.addShapesOnPlane(circleShape, point1);
        Point point2 = new Point(2, 2);
        cartesianPlane.move(rectangleShape, point2);
        assertEquals(4, cartesianPlane.getShapeList().get(0).getCenterLocation().getXCoordinate());
        assertEquals(5, cartesianPlane.getShapeList().get(0).getCenterLocation().getYCoordinate());

    }
    /**
     * If I have two shapes on my plane
     * Then I can find the absolute linear distance between their centers
     */
    @Test
    public void distanceBetweenTwoShapes(){
        Shape rectangleShape = new Rectangle(5, 6);
        Point point = new Point(2, 3);
        Shape circleShape = new Circle(5);
        Point point1 = new Point(6, 8);
        CartesianPlane cartesianPlane = new CartesianPlane();
        cartesianPlane.addShapesOnPlane(rectangleShape, point);
        cartesianPlane.addShapesOnPlane(circleShape, point1);

        assertEquals(6.4031242374328485,cartesianPlane.distance(rectangleShape, circleShape));

    }

    /**
     * If I have a rectangle on my plane
     * Then I should see “<length> X <width> rectangle at (x,y)"
     *
     * If I have a rectangle not on my plane
     * Then I should see “<length> X <width> rectangle"
     *
     * If I have a circle on my plane
     * Then I should see “circle of radius <radius> at (x,y)"
     *
     * If I have a rectangle not on my plane
     * Then I should see “circle of radius <radius>"
     *
     * If I have any items on my plane
     * Then I should be able to see a representation of all of them
     */
    @Test
    public void displayRepresentation(){
        Shape rectangleShape = new Rectangle(5, 6);
        Point point = new Point(2, 3);
        Shape circleShape = new Circle(5);
        Point point1 = new Point(6, 8);
        CartesianPlane cartesianPlane = new CartesianPlane();
        cartesianPlane.addShapesOnPlane(rectangleShape, point);
        cartesianPlane.addShapesOnPlane(circleShape, point1);

        Shape rectangleShapeNotOnPlane = new Rectangle(8, 5);
        Shape circleShapeNotOnPlane = new Circle(8);
        assertEquals("<5> X <6> rectangle at (2.0,3.0)",cartesianPlane.display(rectangleShape));
        assertEquals("<8> X <5> rectangle",cartesianPlane.display(rectangleShapeNotOnPlane));
        assertEquals("circle of radius <5> at (6.0,8.0)",cartesianPlane.display(circleShape));
    }

}

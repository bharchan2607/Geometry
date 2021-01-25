package com.galvanize.geometry;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;


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

}

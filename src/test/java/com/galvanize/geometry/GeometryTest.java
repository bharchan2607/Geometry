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
        rectangle.changeLengthAndWidth(5,7);
        assertEquals(5, rectangle.getLength());
        assertEquals(7, rectangle.getWidth());
    }
}

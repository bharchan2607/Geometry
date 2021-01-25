package com.galvanize.geometry;

public class Rectangle {
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

    public void changeLengthAndWidth(int length, int width) {
        this.length = length;
        this.width = width;
    }
}

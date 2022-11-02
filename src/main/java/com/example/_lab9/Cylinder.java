package com.example._lab9;

public class Cylinder extends Circle {
    private double height;

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        if (height > 0)
            this.height = height;
        else
            this.height = -1;
    }

    public static double isHeightCorrect(String heightval) {
        double value = -1;
        try {
            value = Double.parseDouble(heightval) > 0 ? Double.parseDouble(heightval) : -1;
        } catch (Exception e) {

        }

        return value;
    }

    public double getVolume() {
        return super.getSquare() * getHeight();
    }

    @Override
    public double getSquare() {
        return 2 * super.getSquare() + super.getCircumference() * getHeight();
    }

    public Cylinder() {
    }

    public Cylinder(double radius, double height) {
        super(radius);
        setHeight(height);
    }

}

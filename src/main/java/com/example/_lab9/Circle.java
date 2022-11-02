package com.example._lab9;

public class Circle  {
    private double radius;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        if (radius > 0)
            this.radius = radius;
        else
            this.radius = -1;
    }

    public static double isRadiusCorrect(String radiusval) {
        double value = -1;
        try {
            value = Double.parseDouble(radiusval) > 0 ? Double.parseDouble(radiusval) : -1;
        } catch (Exception e) {

        }

        return value;
    }

    public double getSquare() {
        return Math.PI * getRadius() * getRadius();
    }

    public double getCircumference() {

        return 2 * Math.PI * getRadius();
    }

    public Circle() {
    }

    public Circle(double radius) {
        setRadius(radius);
    }

}

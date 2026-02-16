package com.my.app.calc.geometrymate;

public class AreaCalculator {

    public static double rectangle(double width, double height) {
        return width * height;
    }

    public static double circle(double radius) {
        return Math.PI * Math.pow(radius, 2);

    }

    public static double triangle(double base, double height) {
        return 0.5 * base * height;

    }

}

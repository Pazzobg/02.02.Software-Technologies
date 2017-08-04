package Java_Basics_Exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;

public class E22_IntersectionOfCircles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] circleOneData = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();

        double[] circleTwoData = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();


        Circle firstCircle = new Circle();
        firstCircle.setX(circleOneData[0]);
        firstCircle.setY(circleOneData[1]);
        firstCircle.setRadius(circleOneData[2]);


        Circle secondCircle = new Circle();
        secondCircle.setX(circleTwoData[0]);
        secondCircle.setY(circleTwoData[1]);
        secondCircle.setRadius(circleTwoData[2]);

        boolean bothCirclesIntersect = Intersect(firstCircle, secondCircle);

        System.out.println(bothCirclesIntersect ? "Yes" : "No");
    }

    // As per rule, if the distance between the centers of two circles is less or equal of
    // the sum of their radii, the two circles overlap - they could either touch in a single point
    // or partially overlap, or one is completely inside the other.
    // If the distance between the centers is greater than the sum of the radii,
    // both circles do NOT overlap / intersect.

    public static boolean Intersect(Circle firstCircle, Circle secondCircle)
    {
        double distance = CalculateDistance(firstCircle, secondCircle);
        double sumOfRadiuses = firstCircle.getRadius() + secondCircle.getRadius();

        return distance <= sumOfRadiuses;
    }

    // Calculating the distance between the centers of both circles
    public static double CalculateDistance(Circle firstCircle, Circle secondCircle)
    {
        double sideOne = firstCircle.getX() - secondCircle.getX();
        double sideTwo = firstCircle.getY() - secondCircle.getY();

        double distance = Math.sqrt(Math.pow(sideOne, 2) + Math.pow(sideTwo, 2));

        return distance;
    }
}

class Circle {
    private double X;

    private double Y;

    private double Radius;

    private double Center;

    private double Area;

    private double Perimeter;

    public double getX() {
        return X;
    }

    public void setX(double x) {
        X = x;
    }

    public double getY() {
        return Y;
    }

    public void setY(double y) {
        Y = y;
    }

    public double getRadius() {
        return Radius;
    }

    public void setRadius(double radius) {
        Radius = radius;
    }

    public double getCenter() {
        return Center;
    }

    public void setCenter(double center) {
        Center = center;
    }

    public double getArea() {
        return Area;
    }

    public void setArea(double area) {
        Area = Math.PI * getRadius() * getRadius();
    }

    public double getPerimeter() {
        return Perimeter;
    }

    public void setPerimeter(double perimeter) {
        Perimeter = 2 * Math.PI * getRadius();
    }
}
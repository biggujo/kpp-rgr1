package Interpolation;

import Points.Point2D;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;

public class ArrayListInterpolator extends Interpolator {

    private ArrayList<Point2D> list;

    public ArrayListInterpolator() {
        this.list = new ArrayList<Point2D>();
    }

    public ArrayListInterpolator(ArrayList<Point2D> list) {
        this.list = list;
    }

    public ArrayListInterpolator(Point2D[] list) {
        this();

        for (Point2D point : list) {
            pushPoint(point);
        }
    }

    public Point2D getPoint(int index) {
        if (index < 0 || index >= list.size()) {
            return null;
        }
        return list.get(index);
    }

    public boolean setPoint(int index, Point2D point2D) {
        if (index < 0 || index > list.size()) {
            return false;
        }

        if (index == list.size()) {
            pushPoint(point2D);
            return true;
        }

        list.set(index, point2D);
        return true;
    }

    public int pushPoint(Point2D point2D) {
        list.add(point2D);
        return list.size();
    }

    public Point2D popPoint() {
        return list.remove(list.size() - 1);
    }

    public void clear() {
        list.clear();
    }

    public int pointsAmount() {
        return list.size();
    }

    public void sort() {
        Collections.sort(list);
    }

    public static void main(String[] args) {
        FileArrayListInterpolator interpolator = new FileArrayListInterpolator();
        Scanner in = new Scanner(System.in);

        // Set locale
        DecimalFormatSymbols localeUS = new DecimalFormatSymbols(Locale.US);
        DecimalFormat decimalFormat = new DecimalFormat("#.######", localeUS);

        int amountOfPoints = 0;

        while (amountOfPoints <= 0) {
            System.out.print("Amount of points: ");
            amountOfPoints = in.nextInt();
        }

        // Create points
        for (int i = 0; i < amountOfPoints; i++) {
            double randX = Double.parseDouble(decimalFormat.format(Math.random()));
            double randY = Math.sin(randX);

            interpolator.pushPoint(new Point2D(randX, randY));
        }

        System.out.println("Sorted points:");
        interpolator.sort();

        for (int i = 0; i < amountOfPoints; i++) {
            System.out.println(interpolator.getPoint(i));
        }
        
        int newAmount = interpolator.pointsAmount();

        double minX = interpolator.getPoint(0).getX();
        double maxX = interpolator.getPoint(newAmount - 1).getX();

        double avgX = (minX + maxX) / 2;

        double correctValue = Math.sin(avgX);
        double interpolatedValue = interpolator.evalf(avgX);
        double diff = interpolatedValue - correctValue;

        System.out.printf("Min x: %f, max x: %f\n", minX, maxX);
        System.out.printf("Average x: %f\n", avgX);
        System.out.printf("sin(x) = %f\n", correctValue);
        System.out.printf("interpolation(x) = %f\n", interpolatedValue);
        System.out.printf("Difference: %f\n", diff);
    }
}

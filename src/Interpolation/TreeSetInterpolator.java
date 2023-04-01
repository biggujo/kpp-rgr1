package Interpolation;

import Points.Point2D;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Iterator;
import java.util.Locale;
import java.util.Scanner;
import java.util.TreeSet;

public class TreeSetInterpolator extends Interpolator {

    private final TreeSet<Point2D> set;

    public TreeSetInterpolator() {
        set = new TreeSet<>();
    }

    public TreeSetInterpolator(TreeSet<Point2D> set) {
        this.set = set;
    }

    public TreeSetInterpolator(Point2D[] list) {
        this();

        for (Point2D point : list) {
            pushPoint(point);
        }
    }

    public Point2D getPoint(int index) {
        if (index == 0) {
            return set.first();
        }

        Iterator<Point2D> iterator = set.iterator();
        for (int i = 0; iterator.hasNext() && i < index; i++) {
            iterator.next();
        }

        return iterator.next();
    }

    public boolean setPoint(int i, Point2D pt) {
        set.add(pt);
        return true;
    }

    public int pushPoint(Point2D pt) {
        set.add(pt);
        return set.size();
    }

    public Point2D popPoint() {
        Point2D removedPoint2D = set.last();
        set.remove(set.last());
        return removedPoint2D;
    }

    public void clear() {
        set.clear();
    }

    public int pointsAmount() {
        return set.size();
    }

    public void sort() {
    }

    public static void main(String[] args) {
        TreeSetInterpolator interpolator = new TreeSetInterpolator();
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
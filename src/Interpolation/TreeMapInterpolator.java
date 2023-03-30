package Interpolation;

import Points.Point2D;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.*;

public class TreeMapInterpolator extends Interpolator {

    private TreeMap<Double, Double> map;

    public TreeMapInterpolator() {
        map = new TreeMap<>();
    }

    public TreeMapInterpolator(TreeMap<Double, Double> map) {
        this.map = map;
    }

    public TreeMapInterpolator(Point2D[] list) {
        this();

        for (Point2D point : list) {
            pushPoint(point);
        }
    }

    public Point2D getPoint(int index) {
        if (index == 0) {
            Map.Entry<Double, Double> entry = map.firstEntry();
            return new Point2D(entry.getKey(), entry.getValue());
        }

        Iterator<Map.Entry<Double, Double>> iterator = map.entrySet().iterator();
        for (int i = 0; iterator.hasNext() && i <= index; i++) {
            iterator.next();
        }

        Map.Entry<Double, Double> returnEntry = map.firstEntry();

        return new Point2D(returnEntry.getKey(), returnEntry.getValue());
    }

    public boolean setPoint(int index, Point2D pt) {
        map.put(pt.getX(), pt.getY());
        return true;
    }

    public int pushPoint(Point2D point2D) {
        map.put(point2D.getX(), point2D.getY());
        return map.size();
    }

    public Point2D popPoint() {
        Map.Entry<Double, Double> removedPointEntry = map.lastEntry();
        Point2D removedPoint2D = new Point2D(removedPointEntry.getKey(), removedPointEntry.getValue());
        map.remove(map.lastKey());
        return removedPoint2D;
    }

    public void clear() {
        map.clear();
    }

    public int pointsAmount() {
        return map.size();
    }

    public void sort() {
    }

    public static void main(String[] args) {
        ArrayListInterpolator interpolator = new ArrayListInterpolator();
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
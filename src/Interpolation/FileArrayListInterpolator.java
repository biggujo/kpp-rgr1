package Interpolation;

import Points.Point2D;

import java.io.*;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Scanner;
import java.util.StringTokenizer;

public class FileArrayListInterpolator extends ArrayListInterpolator {

    private static final String FILE_TBL = FileArrayListInterpolator.class.getSimpleName() + "Original.csv";
    private static final String FILE_TBL_INT = FileArrayListInterpolator.class.getSimpleName() + "Interpolated.csv";

    public FileArrayListInterpolator() {
        super();
    }

    public void readFromFile(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        BufferedReader in = new BufferedReader(fileReader);

        String curLine = in.readLine(); // pass header
        clear();

        while ((curLine = in.readLine()) != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(curLine, ",");

            double x = Double.parseDouble(stringTokenizer.nextToken());
            double y = Double.parseDouble(stringTokenizer.nextToken());

            pushPoint(new Point2D(x, y));
        }
    }

    public void writeToFile(String filename) throws IOException {
        FileWriter fileWriter = new FileWriter(filename);
        PrintWriter out = new PrintWriter(fileWriter);

        int len = pointsAmount();

        out.println("x,y");

        for (int i = 0; i < len; i++) {
            Point2D curPoint = getPoint(i);
            out.printf("%f,%f\n", curPoint.getX(), curPoint.getY());
        }
        out.close();
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
            double randX = 1.0 + (5.0 - 1.0) * Math.random();
            double randY = Math.sin(randX);

            interpolator.pushPoint(new Point2D(randX, randY));
        }

        System.out.println("Sorted points:");
        interpolator.sort();

        for (int i = 0; i < amountOfPoints; i++) {
            System.out.println(interpolator.getPoint(i));
        }

        try {
            interpolator.writeToFile(FILE_TBL);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            interpolator.readFromFile(FILE_TBL);
        } catch (IOException e) {
            e.printStackTrace();
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

import Points.Point2D;
import Points.Point2DArrayListDriver;

import java.io.IOException;
import java.util.ArrayList;

public class ApplicationWordDeser {

    private static final String FILE_NAME_FUNC_RES = "ResultsFunction.csv";
    private static final String FILE_NAME_DERIV_RES = "ResultsDerivative.csv";

    public static void main(String[] args) {
        System.out.println("Loading data...");

        ArrayList<Point2D> point2DArrayListFunc;
        ArrayList<Point2D> point2DArrayListDeriv;

        try {
            point2DArrayListFunc = Point2DArrayListDriver.readFromFile(FILE_NAME_FUNC_RES);
            point2DArrayListDeriv = Point2DArrayListDriver.readFromFile(FILE_NAME_DERIV_RES);

            System.out.println("Function results:");
            point2DArrayListFunc.forEach(p -> {
                System.out.println("x = " + p.getX() + ", y = " + p.getY());
            });

            System.out.println("Derivative results:");
            point2DArrayListDeriv.forEach(p -> {
                System.out.println("x = " + p.getX() + ", y = " + p.getY());
            });
        } catch (IOException e) {
            System.out.println("Read error!");
            System.exit(1);
        }

        System.exit(0);
    }
}

import Points.Point2D;
import Points.Point2DArrayListDriver;
import edu.hws.jcm.data.Expression;
import edu.hws.jcm.data.Parser;
import edu.hws.jcm.data.Variable;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

public class ApplicationWordInput {

    private static final String FILE_NAME_FUNC_RES = "ResultsFunction.csv";
    private static final String FILE_NAME_DERIV_RES = "ResultsDerivative.csv";

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        in.useLocale(Locale.US);
        String input = "";

        ArrayList<Point2D> point2DArrayListFunc = new ArrayList<>();
        ArrayList<Point2D> point2DArrayListDeriv = new ArrayList<>();

        // Math initialisation
        Parser parser = new Parser(Parser.STANDARD_FUNCTIONS);

        Variable varX = new Variable("x");
        Variable varA = new Variable("a");

        parser.add(varX);
        parser.add(varA);

        Expression function;
        Expression derivative;

        // END Math

        System.out.print("Input maximal precision: ");
        int precision = in.nextInt();
        in.nextLine();

        if (precision < 0) {
            System.out.println("Input error!");
            System.exit(1);
        }

        DecimalFormat decimalFormat = new DecimalFormat("###." + "#".repeat(precision));

        System.out.println("(input \"0\" to save last results & exit)");
        while (true) {
            System.out.print("Input function: ");
            input = in.nextLine();

            if (Objects.equals(input, "0")) {
                break;
            }

            function = parser.parse(input);
            derivative = function.derivative(varX);

            System.out.println("Function: " + function);
            System.out.println("Derivative: " + derivative);

            if (input.contains("a")) {
                System.out.println("Function with parameter!");
                System.out.print("Input a: ");
                varA.setVal(in.nextDouble());
            } else {
                varA.setVal(1.0);
            }

            double xMin;
            double xMax;
            double xStep;
            System.out.print("Input x_min: ");
            xMin = in.nextDouble();
            System.out.print("Input x_max: ");
            xMax = in.nextDouble();
            System.out.print("Input step: ");
            xStep = in.nextDouble();

            // Checks
            if (xMin < xMax) {
                if (xStep <= 0) {
                    System.out.println("Input error! Step must be more than zero");
                }
            } else {
                if (xStep > 0) {
                    System.out.println("Input error! Step must be less than zero");
                }
            }

            point2DArrayListFunc = new ArrayList<>();
            point2DArrayListDeriv = new ArrayList<>();

            // Calculations
            for (double xCur = xMin; xCur <= xMax; xCur += xStep) {
                varX.setVal(xCur);

                double functionResult = function.getVal();
                double derivativeResult = derivative.getVal();
                point2DArrayListFunc.add(new Point2D(xCur, functionResult));
                point2DArrayListDeriv.add(new Point2D(xCur, derivativeResult));

                if (xCur == xMax) {
                    break;
                }
            }

            System.out.println("Function results:");
            point2DArrayListFunc.forEach(p -> {
                System.out.println("x = " + decimalFormat.format(p.getX()) + ", y = " + decimalFormat.format(p.getY()));
            });

            System.out.println("Derivative results:");
            point2DArrayListDeriv.forEach(p -> {
                System.out.println("x = " + decimalFormat.format(p.getX()) + ", y = " + decimalFormat.format(p.getY()));
            });

            in.nextLine();
        }

        try {
            Point2DArrayListDriver.writeToFile(point2DArrayListFunc, 2, FILE_NAME_FUNC_RES);
            Point2DArrayListDriver.writeToFile(point2DArrayListFunc, 2, FILE_NAME_DERIV_RES);

            System.out.println("File: " + FILE_NAME_FUNC_RES);
            System.out.println("File: " + FILE_NAME_DERIV_RES);

            System.out.println("Write done!");
        } catch (IOException e) {
            System.out.println("Write error!");
            System.exit(1);
        }

        System.exit(0);
    }
}

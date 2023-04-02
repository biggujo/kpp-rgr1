package Functions;

import Interfaces.Evaluatable;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

public class LeftHand implements Evaluatable {

    private double a;

    public LeftHand() {
        this(0.0);
    }

    public LeftHand(double a) {
        this.a = a;
    }

    @Override
    public double evalf(double x) {
        return 1.0 / Math.pow(Math.cosh(x), 2) - a * x;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public static void main(String[] args) throws IOException {

        LeftHand function = new LeftHand();

        Scanner in = new Scanner(System.in);
        in.useLocale(Locale.US);

        System.out.println("1.0 / Math.pow(Math.cosh(x), 2) - a * x");

        System.out.println("Test 1");

        System.out.println("Please, enter new a:");
        double a = in.nextDouble();
        System.out.println("Please, enter new x_min:");
        double xMin = in.nextDouble();
        System.out.println("Please, enter new x_max:");
        double xMax = in.nextDouble();
        System.out.println("Please, enter new x_step:");
        double xStep = in.nextDouble();

        System.out.println("a = " + a);
        function.setA(a);

        PrintWriter out = new PrintWriter(new FileWriter("LeftHand_A=" + a + ".csv"));
        out.println("x,y");
        for (double xCur = xMin; xCur <= xMax; xCur += xStep) {
            double curResult = function.evalf(xCur);
            System.out.printf("x = %f, res = %f\n", xCur, function.evalf(xCur));
            out.printf("%f,%f\n", xCur, curResult);
        }
        out.close();
    }
}

package Functions;

import Interfaces.Evaluatable;

import java.util.Locale;
import java.util.Scanner;

public class FFunction implements Evaluatable {

    private double a;

    public FFunction() {
        this(1.0);
    }

    public FFunction(double a) {
        this.a = a;
    }

    @Override
    public double evalf(double x) {
        return Math.exp(-a * x * x) * Math.sin(x);
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }


    public static void main(String[] args) {

        FFunction function = new FFunction();

        Scanner in = new Scanner(System.in);
        in.useLocale(Locale.US);

        System.out.println("Math.exp(-a * x * x) * Math.sin(x)");

        System.out.println("Test 1");

        System.out.println("Please, enter new x:");
        double x = in.nextDouble();
        System.out.println("Please, enter new a_min:");
        double aMin = in.nextDouble();
        System.out.println("Please, enter new a_max:");
        double aMax = in.nextDouble();
        System.out.println("Please, enter new a_step:");
        double aStep = in.nextDouble();

        System.out.println("x = " + x);

        for (double a = aMin; a <= aMax; a += aStep) {
            function.setA(a);
            System.out.printf("a = %f, res = %f\n", function.getA(), function.evalf(x));
        }

        System.out.println("Test 2");

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

        for (double xCur = xMin; xCur <= xMax; xCur += xStep) {
            System.out.printf("x = %f, res = %f\n", xCur, function.evalf(x));
        }
    }
}

package Practice2Code.src.test4;

import Practice2Code.src.test3.ArrayListPointStorage;
import Practice2Code.src.test3.DataStorage;
import Practice2Code.src.test3.Point;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

public class InterpMain {
    private static DataStorage<Double> data = new ArrayListPointStorage();

    public static double interpolate(double x) {
        double res = 0.0;
        int numData = data.size();
        double numer, denom;

        for (int k = 0; k < numData; k++) {
            numer = 1.0;
            denom = 1.0;
            for (int j = 0; j < numData; j++) {
                if (j != k) {
                    numer *= x - data.point(j).x().doubleValue();
                    denom *= data.point(k).x().doubleValue() - data.point(j).x().doubleValue();
                }
            }
            res += data.point(k).y().doubleValue() * numer / denom;
        }

        return res;
    }

    public static double f(double x) {
        return Math.sin(x);
        //return Math.exp(-Math.abs(x))*Math.sin(x);
    }

    //https://uk.wikipedia.org/wiki/%D0%A4%D0%B5%D0%BD%D0%BE%D0%BC%D0%B5%D0%BD_%D0%A0%D1%83%D0%BD%D0%B3%D0%B5
    public static double g(double x) {
        return 1.0 / (1.0 + 25.0 * x * x);
    }


    public static void main(String[] args) throws IOException {
        boolean good = false;
        int num = 8; //30;
        double x, appr, err, fun, left = -1.0, right = 1.0, step = 0.1;

        for (int i = 0; i < num; i++) {
            x = 2.0 * i / num - 1.0;
            if (good) {
                data.add(new Point(x, f(x)));
            } else {
                data.add(new Point(x, g(x)));
            }
        }

        PrintWriter out = new PrintWriter(new FileWriter("result.dat"));
        x = left;
        while (x <= right) {
            appr = interpolate(x);
            if (good) {
                fun = f(x);
            } else {
                fun = g(x);
            }
            err = Math.abs(fun - appr);
            System.out.printf(Locale.ENGLISH, "x: % 9.3e, appr: % 10.4e, error: %12.6e%n", x, appr, err);
            out.println(x + "\t" + fun + "\t" + appr);
            x += step;
        }
        out.close();
    }
}

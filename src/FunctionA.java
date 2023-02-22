import Interfaces.Evaluatable;

import java.lang.reflect.Array;
import java.util.Arrays;

public class FunctionA implements Evaluatable {

    private double a;

    public FunctionA() {
        this(1.0);
    }

    public FunctionA(double a) {
        this.a = a;
    }

    public static void main(String[] args) {
        System.out.println("FunctionA");
        System.out.println(Arrays.deepToString(args));
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


}

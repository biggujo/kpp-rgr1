package Practice2Code.src.test0;

public class Numeric {
    private Numeric() {
    }

    public static double derivative(Evaluatable f, double x) {
        double deltaX = 1.0e-4;
        return (f.evalf(x + deltaX) - f.evalf(x - deltaX)) / 2.0 / deltaX;
    }
}

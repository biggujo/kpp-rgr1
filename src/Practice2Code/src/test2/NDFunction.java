package Practice2Code.src.test2;

public class NDFunction extends Function {
    private double deltaX = 1.0e-4;

    @Override
    public double evalf(double x) {
        return (super.evalf(x + deltaX) - super.evalf(x - deltaX)) / 2.0 / deltaX;
    }

}

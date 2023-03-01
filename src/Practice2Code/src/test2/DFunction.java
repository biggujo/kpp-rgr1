package Practice2Code.src.test2;

public class DFunction extends Function {
    private double deltaX = 1.0e-4;

    public double deriv(double x) {
        return (this.evalf(x + deltaX) - this.evalf(x - deltaX)) / 2.0 / deltaX;
    }
}

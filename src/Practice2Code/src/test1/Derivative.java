package Practice2Code.src.test1;

public class Derivative implements Evaluatable {
    private final Evaluatable fun;

    public Derivative(Evaluatable fun) {
        this.fun = fun;
    }

    @Override
    public double evalf(double x) {
        double deltaX = 1.0e-4;
        //System.out.println("Derivative calculation");
        return (this.fun.evalf(x + deltaX) - this.fun.evalf(x - deltaX)) / 2.0 / deltaX;
    }

}

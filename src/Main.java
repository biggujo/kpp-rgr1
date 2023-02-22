public class Main {

    public static void main(String[] args) {

        FunctionA functionA = new FunctionA(1);

        FunctionA.main(new String[]{});

        double minX = -3;
        double maxX = 3;

        double step = 0.5;


        System.out.println("Min x: " + minX);
        System.out.println("Max x: " + maxX);
        System.out.println("Step: " + step);

        for (double x = minX; x <= maxX; x += step) {
            System.out.printf("f(%f) = %f\n", x, functionA.evalf(x));
        }
    }
}

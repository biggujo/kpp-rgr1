package Practice2Code.src.test0;

public class Main {
    public static void main(String[] args) {
        Evaluatable[] functs = new Evaluatable[]{new Function(), x -> Math.sin(x)};
        for (double x = 0; x < 1.0; x += 0.2) {
            System.out.print(x + " : ");
            for (Evaluatable f : functs) {
                System.out.print(" : " + f.evalf(x) + " : " + Numeric.derivative(f, x));
            }
            System.out.println();
        }
    }

}

package Practice2Code.src.test2;

public class Main {

    public static void main(String[] args) {
        boolean test = false;
        if (test) {
            Evaluatable f = new Function();
            NDFunction d = new NDFunction();
            for (double x = 0; x < 3.5; x += 0.5) {
                System.out.println(x + " : " + f.evalf(x) + " : " + d.evalf(x));
            }
        } else {
            DFunction d = new DFunction();
            for (double x = 0; x < 3.5; x += 0.5) {
                System.out.println(x + " : " + d.evalf(x) + " : " + d.deriv(x));
            }
        }
    }

}

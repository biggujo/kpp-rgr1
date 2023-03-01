package Practice2Code.src.test4;

import java.util.Locale;

public class DerivMain {

    public static float f(float x) {
        return x * x - 3.0f * x;
    }

    public static float fDerA(float x) {
        return 2.0f * x - 3.0f;
    }

    public static float fDerN(float x, float h, boolean improved) {
        if (improved) {
            return (f(x + h) - f(x - h)) / 2.0f / h;
        } else {
            return (f(x + h) - f(x)) / h;
        }
    }

    public static void main(String[] args) {
        float x = 1.0f;
        float h = 0.1f;
        for (int i = 0; i < 8; i++) {
            double appr = fDerN(x, h, true);
            double err = Math.abs(appr - fDerA(x));
            //System.out.println("h: " + h + ", appr: " + appr + ", error: " + err);
            //https://docs.oracle.com/javase/tutorial/java/data/numberformat.html
            System.out.printf(Locale.ENGLISH, "h: %9.3e, appr: % 10.4e, error: %12.6e%n", h, appr, err);
            h = 0.1f * h;
        }
    }

}

package Practice2Code.src.test1;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        Evaluatable[] functs = new Evaluatable[]{new Function(), x -> Math.sin(x)};
        Evaluatable[] derivs = Arrays.stream(functs).map(Derivative::new).toArray(Evaluatable[]::new);
        Evaluatable[] deriv2 = Arrays.stream(derivs).map(Derivative::new).toArray(Evaluatable[]::new);

        double x = 0.5;
        IntStream.range(0, functs.length)
                .forEach(i -> System.out.println(functs[i].evalf(x) + " : " + derivs[i].evalf(x) + " : " + deriv2[i].evalf(x)));
    }

}

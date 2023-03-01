import edu.hws.jcm.data.Expression;
import edu.hws.jcm.data.Parser;
import edu.hws.jcm.data.Variable;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Parser parser = new Parser(Parser.STANDARD_FUNCTIONS);

        Variable varX = new Variable("x");
//        Variable varA = new Variable("a");

        parser.add(varX);
//        parser.add(varA);

        String myInput = in.next();

        Expression functionParsed = parser.parse(myInput);
        Expression derivativeParsed = functionParsed.derivative(varX);

        System.out.println("Parsed function: " + functionParsed);
        System.out.println("Derivative: " + derivativeParsed);
    }
}

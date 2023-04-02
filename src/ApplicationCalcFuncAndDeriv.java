import Functions.FFunction;
import Functions.SolveEqFunction;
import Interfaces.Evaluatable;
import Interpolation.FileTreeSetInterpolator;
import Math.NumMethods;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

public class ApplicationCalcFuncAndDeriv {

    public static void main(String[] args) throws IOException {
        Evaluatable[] functions = new Evaluatable[4];
        functions[0] = new FFunction(0.5);
        functions[1] = new FFunction(1.0);
        functions[2] = new SolveEqFunction();
        functions[3] = new FileTreeSetInterpolator();

        ((SolveEqFunction) functions[2]).setRootApprox(0.7);

        String fileNameToSave;
        double precision = 1.0e-4;

        System.out.println("Function calculator");
        System.out.println("Precision: " + precision);

        try {
            ((FileTreeSetInterpolator) functions[3]).readFromFile("FileTreeSetInterpolator.csv");
        } catch (IOException ex) {
            ex.printStackTrace();
            System.exit(-1);
        }

        for (Evaluatable function : functions) {
            // Create files by class name
            // Make other naming for function with parameter
            if (function.getClass().getSimpleName().equals("FFunction")) {
                FFunction cur = (FFunction) function;
                fileNameToSave = function.getClass().getSimpleName() + "_A=" + cur.getA() + "_Results.csv";
            } else {
                fileNameToSave = function.getClass().getSimpleName() + "_Results.csv";
            }

            System.out.println("Function: " + function.getClass().getSimpleName());
            System.out.println("File: " + fileNameToSave);

            FileWriter fileWriter = new FileWriter(fileNameToSave);
            PrintWriter out = new PrintWriter(fileWriter);

            out.println("x,y,derivative");

            for (double x = 1.5; x <= 6.5; x += 0.05) {
                double fInterpolated = function.evalf(x);
                double fDerivative = NumMethods.der(x, precision, function);

                String data = String.format(Locale.US, "%1.1f,%8.14f,%8.14f", x, fInterpolated, fDerivative);

                System.out.println(data);
                out.println(data);
            }

            System.out.println("Done!");
            out.close();
        }
    }
}

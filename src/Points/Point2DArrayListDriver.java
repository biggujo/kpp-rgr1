package Points;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Point2DArrayListDriver {
    public static ArrayList<Point2D> readFromFile(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        BufferedReader in = new BufferedReader(fileReader);

        ArrayList<Point2D> point2DArrayList = new ArrayList<>();

        String curLine = in.readLine(); // pass header

        while ((curLine = in.readLine()) != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(curLine, ",");

            double x = Double.parseDouble(stringTokenizer.nextToken());
            double y = Double.parseDouble(stringTokenizer.nextToken());

            point2DArrayList.add(new Point2D(x, y));
        }

        return point2DArrayList;
    }

    public static void writeToFile(ArrayList<Point2D> point2DArrayList, int precision, String filename) throws IOException {
        if (precision < 0) {
            throw new IOException();
        }

        FileWriter fileWriter = new FileWriter(filename);
        PrintWriter out = new PrintWriter(fileWriter);

        out.println("x,y");

        for (Point2D curPoint : point2DArrayList) {
            out.printf("%." + precision + "f,%." + precision + "f\n",
                    curPoint.getX(), curPoint.getY());
        }
        out.close();
    }
}

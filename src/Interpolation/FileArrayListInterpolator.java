package Interpolation;

import Points.Point2D;

import java.io.*;

public class FileArrayListInterpolator extends ArrayListInterpolator {

    FileArrayListInterpolator() {
        super();
    }

    public void readFromFile(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        BufferedReader in = new BufferedReader(fileReader);

        String curLine = in.readLine(); // pass header

        while ((curLine = in.readLine()) != null) {
            String[] pointCoords = curLine.split("[,]");

            double x = Double.parseDouble(pointCoords[0]);
            double y = Double.parseDouble(pointCoords[1]);

            pushPoint(new Point2D(x, y));
        }
    }

    // TODO: file writer
//    public void writeToFile(String filename) throws IOException {
//        FileWriter fileWriter = new FileWriter(filename);
//        BufferedWriter out = new BufferedWriter(fileWriter);
//    }
}

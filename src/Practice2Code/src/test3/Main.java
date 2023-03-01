package Practice2Code.src.test3;

import java.io.IOException;
import java.text.ParseException;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        String[] fileNames = {"TblFunc.dat", "ExcelForCSV.csv", "test.csv"};
        DataStorage<Double> data = new ArrayListPointStorage();
        System.out.println("Read data from file to dataset");
        //FileStorage fromFile = new FileStorage(data);      //Or this
        FileDataReader fromFile = new FileDataReader(data);  //Or this

        int index = 0;
        System.out.println("\tProccessed file: " + fileNames[index]);
        try {
            //tab separated data columns; point - delimiter in number
            fromFile.read(fileNames[index], "\\t", Locale.ENGLISH, true);
            for (int i = 0; i < data.size(); i++) {
                System.out.println(data.point(i));
            }
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
        System.out.println("Number of data: " + data.size());
        data.clear();

        index = 1;
        System.out.println("\tProccessed file: " + fileNames[index]);
        try {
            //csv ; separated data columns; comma - delimiter in number
            fromFile.read(fileNames[index], ";", Locale.FRANCE, false);
            for (int i = 0; i < data.size(); i++) {
                System.out.println(data.point(i));
            }
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
        System.out.println("Number of data: " + data.size());
        data.clear();

        index = 2;
        System.out.println("\tProccessed file: " + fileNames[index]);
        try {
            //csv , separated data columns; point - delimiter in number
            fromFile.read(fileNames[index], ",", Locale.ENGLISH, false);
            for (int i = 0; i < data.size(); i++) {
                System.out.println(data.point(i));
            }
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
        System.out.println("Number of data: " + data.size());
        data.clear();
    }

}

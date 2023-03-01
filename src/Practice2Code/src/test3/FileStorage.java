package Practice2Code.src.test3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
//import java.util.function.Function;

public class FileStorage implements DataStorage<Double> {

    private final DataStorage<Double> data;

    public FileStorage(DataStorage<Double> data) {
        super();
        this.data = data;
    }

    //Not very good. It shall be better to encapsulate file format choosing and tuning features in special types
    public void read(String name, String delimiter, Locale locale, boolean isHeaderPresent) throws FileNotFoundException, ParseException, IOException {
        NumberFormat format = NumberFormat.getInstance(locale);
        //must be try block in the body of lambda function
        //Function<String, Double> f = number -> Double.valueOf(format.parse(number).doubleValue());
        try (BufferedReader br = new BufferedReader(new FileReader(name))) {
            String line;
            if (isHeaderPresent) line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(delimiter);
                //Double x = f.apply(values[0]);
                //Double y = f.apply(values[1]);
                //System.out.println(line + " : " + java.util.Arrays.toString(values));
                Double x = Double.valueOf(format.parse(values[0]).doubleValue());
                Double y = Double.valueOf(format.parse(values[1]).doubleValue());
                this.data.add(new Point(x, y));
            }
        }
    }

    @Override
    public int size() {
        return this.data.size();
    }

    @Override
    public DataPoint<Double> point(int ind) {
        return this.data.point(ind);
    }

    @Override
    public void clear() {
        this.data.clear();
    }

    @Override
    public void add(DataPoint<Double> pt) {
        this.data.add(pt);
    }

    @Override
    public void set(int i, DataPoint<Double> pt) {
        this.data.set(i, pt);
    }

    @Override
    public void removeLast() {
        this.data.removeLast();
    }

    @Override
    public void sort() {
        this.data.sort();
    }

}

package Practice2Code.src.test3;

import java.util.ArrayList;
import java.util.List;

public class ArrayListPointStorage implements DataStorage<Double> {
    private final List<DataPoint<Double>> data;

    public ArrayListPointStorage() {
        super();
        this.data = new ArrayList<>();
    }

    public ArrayListPointStorage(List<DataPoint<Double>> data) {
        super();
        this.data = data;
    }

    public ArrayListPointStorage(DataPoint<Double>[] data) {
        this();
        for (DataPoint<Double> d : data) {
            this.data.add(d);
        }
    }

    @Override
    public int size() {
        return this.data.size();
    }

    @Override
    public DataPoint<Double> point(int ind) {
        return this.data.get(ind);
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
        this.data.remove(this.data.size() - 1);
    }

    @Override
    public void sort() {
        java.util.Collections.sort(this.data);
    }

}

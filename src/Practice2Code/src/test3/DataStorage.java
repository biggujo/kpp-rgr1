package Practice2Code.src.test3;

public interface DataStorage<T extends Number> {
    int size();

    DataPoint<T> point(int ind);

    void clear();

    void add(DataPoint<T> pt);

    void set(int i, DataPoint<T> pt);

    void removeLast();

    void sort();
}

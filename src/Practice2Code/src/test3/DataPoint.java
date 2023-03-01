package Practice2Code.src.test3;

public interface DataPoint<T extends Number> extends Comparable<DataPoint<T>> {
    T x();

    T y();
}

package Practice2Code.src.test3;

public class Point implements DataPoint<Double> {
    private final double x;
    private final double y;

    public Point(double x, double y) {
        super();
        this.x = x;
        this.y = y;
    }

    @Override
    public Double x() {
        return this.x;
    }

    @Override
    public Double y() {
        return this.y;
    }

    @Override
    public int compareTo(DataPoint<Double> pt) {
        return Double.compare(this.x(), pt.x());
    }

    @Override
    public String toString() {
        return "Point [x=" + x + ", y=" + y + "]";
    }
}

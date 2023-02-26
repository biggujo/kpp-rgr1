public class Point2D extends Point implements Comparable<Point2D> {

    public Point2D(double x, double y) {
        super(2);
        setCoord(1, x);
        setCoord(2, y);
    }

    public Point2D() {
        this(0, 0);
    }

    @Override
    public int compareTo(Point2D givenPoint) {
        return Double.compare(this.getCoord(1), givenPoint.getCoord(1));
    }

    public double getX() {
        return getCoord(1);
    }

    public void setX(double newX) {
        setCoord(1, newX);
    }

    public double getY() {
        return getCoord(2);
    }

    public void setY(double newY) {
        setCoord(2, newY);
    }
}

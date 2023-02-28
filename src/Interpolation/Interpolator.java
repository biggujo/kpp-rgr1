package Interpolation;

import Interfaces.Evaluatable;
import Points.Point2D;

public abstract class Interpolator implements Evaluatable {

    abstract public Point2D getPoint(int index);

    abstract public boolean setPoint(int index, Point2D point2D);

    abstract public int pushPoint(Point2D point2D);

    abstract public Point2D popPoint();

    abstract public void clear();

    abstract public int pointsAmount();

    abstract public void sort();

    @Override
    public double evalf(double x) {
        double res = 0.0;
        int numData = pointsAmount();
        double numer, denom;
        for (int k = 0; k < numData; k++) {
            numer = 1.0;
            denom = 1.0;
            for (int j = 0; j < numData; j++) {
                if (j != k) {
                    numer = numer * (x - getPoint(j).getX());
                    denom = denom * (getPoint(k).getX() - getPoint(j).getX());
                }
            }
            res = res + getPoint(k).getY() * numer / denom;
        }
        return res;
    }
}

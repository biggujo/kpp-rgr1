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
        double result = 0;
        double number;
        double denom;

        int numData = pointsAmount();
        for (int i = 0; i < numData; i++) {
            number = 1;
            denom = 1;

            for (int j = 0; j < numData; j++) {

                if (j != i) {
                    number = number * (x - getPoint(j).getX());
                    denom = denom * (getPoint(i).getX() - getPoint(j).getX());
                }
            }
            
            result = result + getPoint(i).getY() * number / denom;
        }
        return result;
    }
}

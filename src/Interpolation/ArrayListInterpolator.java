package Interpolation;

import Points.Point2D;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListInterpolator extends Interpolator {

    private ArrayList<Point2D> list;

    public ArrayListInterpolator() {
        this.list = new ArrayList<Point2D>();
    }

    public ArrayListInterpolator(ArrayList<Point2D> list) {
        this.list = list;
    }

    public ArrayListInterpolator(Point2D[] list) {
        this();

        for (Point2D point : list) {
            pushPoint(point);
        }
    }

    public Point2D getPoint(int index) {
        if (index < 0 || index >= list.size()) {
            return null;
        }
        return list.get(index);
    }

    public boolean setPoint(int index, Point2D point2D) {
        if (index < 0 || index > list.size()) {
            return false;
        }

        if (index == list.size()) {
            pushPoint(point2D);
            return true;
        }

        list.set(index, point2D);
        return true;
    }

    public int pushPoint(Point2D point2D) {
        list.add(point2D);
        return list.size();
    }

    public Point2D popPoint() {
        return list.remove(list.size() - 1);
    }

    public void clear() {
        list.clear();
    }

    public int pointsAmount() {
        return list.size();
    }

    public void sort() {
        Collections.sort(list);
    }
}

import Points.Point2D;

public class Main {

    public static void main(String[] args) {

        Point2D firstPoint = new Point2D(2, 3);
        Point2D secondPoint = new Point2D(3, 2);

        System.out.println(firstPoint.compareTo(secondPoint));
    }
}

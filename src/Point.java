public abstract class Point {

    double[] coords = null;

    public Point(int size) {
        this.coords = new double[size];
    }

    public void setCoord(int position, double number) {
        this.coords[position - 1] = number;
    }

    public double getCoord(int position) {
        return this.coords[position - 1];
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("(");

        for (double coord : this.coords) {
            stringBuilder.append(coord);
            stringBuilder.append(", ");
        }

        stringBuilder.append(")");

        return stringBuilder.toString();
    }
}

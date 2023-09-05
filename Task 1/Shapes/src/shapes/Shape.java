package shapes;

public abstract class Shape implements Comparable<Shape> {
    public abstract double getArea();
    @Override
    public int compareTo(Shape o) {
        return (int) (this.getArea() - o.getArea());
    }
}

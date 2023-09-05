import shapes.Reactangle;
import shapes.Shape;
import shapes.Square;

public class Main {
    public static void main(String[] args) {
        Shape rectangle = new Reactangle(2,8);
        Shape square = new Square(5);
        System.out.println(rectangle.compareTo(square));
    }
}
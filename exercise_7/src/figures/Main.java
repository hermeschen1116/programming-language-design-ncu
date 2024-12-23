package figures;

public class Main {

    public static void main(String[] args) {
        Point p1 = new Point(10, 10);
        Point p2 = new Point(10, 10);
        Line line = new Line(p1, p2);
        System.out.println();
        System.out.println("Point moves...");
        p1.setX(11);
        p1.setY(11);
        p2.setX(11);
        p2.setY(11);
        System.out.println();
        System.out.println("Line moves...");
        line.moveBy(20, 20);
    }
}
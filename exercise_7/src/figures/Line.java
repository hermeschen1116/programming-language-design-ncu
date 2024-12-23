package figures;

public class Line implements Shape {
    private Point p1, p2;

    Line(Point p1, Point p2) {
        super();
        this.p1 = p1;
        this.p2 = p2;
    }

    public Point getP1() { return p1; }
    public Point getP2() { return p2; }

    public void setP1(Point p1) { 
        this.p1 = p1; 
    }
    public void setP2(Point p2) { 
        this.p2 = p2; 
    }

    public void moveBy(int dx, int dy) {
        getP1().moveBy(dx, dy);
        getP2().moveBy(dx, dy);
    }
}
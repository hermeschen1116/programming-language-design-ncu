package figures;

public aspect Logging {
    pointcut lineConstructor(): execution(Line.new(..));

    after(): lineConstructor() {
        System.out.println("A line is created");
    }

    pointcut pointSetMethods():
        (execution(void Point.setX(int)) || execution(void Point.setY(int)))
        && !cflow(execution(void Point.moveBy(..)));

    before(): pointSetMethods() {
        System.out.println("A point is set directly");
    }

    pointcut pointMoveBy(int dx, int dy):
        execution(void Point.moveBy(int, int)) && args(dx, dy);

    after(int dx, int dy): pointMoveBy(dx, dy) {
        System.out.println("A point is moved! dx=" + dx + ", dy=" + dy);
    }

    pointcut lineGetPointMethods():
        execution(Point Line.getP1()) || execution(Point Line.getP2());

    Point around(): lineGetPointMethods() {
        Point p = proceed();
        System.out.println("Point " + p + " is obtained through the line");
        return p;
    }
}

package exercise;

// BEGIN
public class Segment {
    Point beginPoint;
    Point endPoint;

    public Segment(Point beginPoint, Point endPoint) {
        this.beginPoint = beginPoint;
        this.endPoint = endPoint;
    }

    public Point getBeginPoint() {
        return beginPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }
    public Point getMidPoint() {
        var x = (getBeginPoint().getX() + getEndPoint().getX()) * 0.5;
        var y = (getBeginPoint().getY() + getEndPoint().getY()) * 0.5;
        return new Point((int) x, (int) y);
    }
}
// END

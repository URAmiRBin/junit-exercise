public class Point{
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override public boolean equals(Object o) {
        if (o == this) return true;

        if (!(o instanceof Point)) return false;

        Point p = (Point)o;
        
        return (this.x == p.x) && (this.y == p.y);
    }

    @Override public int hashCode() {
        return 69 * this.x + 96 * this.y+ 420;
    }
}

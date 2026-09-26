package laba12.entity;

public class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Point parse(String s) {
        String[] parts = s.split(",");
        return new Point(Integer.parseInt(parts[0].trim()), Integer.parseInt(parts[1].trim()));
    }

    @Override
    public String toString() {
        return x + "," + y;
    }
}

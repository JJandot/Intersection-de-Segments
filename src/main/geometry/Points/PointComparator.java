package main.geometry.Points;

import java.util.Comparator;

public class PointComparator implements Comparator<Point> {

    @Override
    public int compare(Point p1, Point p2) {
        return p1.y < p2.y ? - 1 : p1.y == p2.y ? 0 : 1;
    }
}

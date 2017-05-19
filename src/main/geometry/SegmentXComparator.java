package main.geometry;

import java.util.Comparator;

public class SegmentXComparator implements Comparator<Segment> {

    public int compare(Segment s1, Segment s2) {
        return s1.topPoint.x < s2.topPoint.x ? - 1 : s1.topPoint.x == s2.topPoint.x ? 0 : 1;
    }
}

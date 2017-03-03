package geometry;

import java.util.Vector;

public class Algorithms {

    private Algorithms(){}

    public static void getSegments(Vector<Point> points, Vector<Segment> segments){
        for(Point p : points){
            System.out.println("Le point : " + p + "appartient au segment : " + p.getSegments(segments));
        }
    }

    public static void printIntersectionPossibility(Vector<Segment> segments){
        for (Segment s1 : segments){
            for (Segment s2 : segments) {
                if (s1 == s2) {
                    continue;
                }
                if (isOverlapping(s1, s2))
                    System.out.println(s1.toStringNb() + " is overlapping with " + s2.toStringNb());
            }
        }
    }

    private static boolean isOverlapping(Segment s1, Segment s2){
        return ((s1.topPoint.y > s2.topPoint.y && s1.topPoint.y < s2.bottomPoint.y) || (s2.topPoint.y > s1.topPoint.y && s2.topPoint.y < s1.bottomPoint.y));
    }
}

package main.geometry;

import main.geometry.Points.Point;

import java.util.*;

public class Utils {

    private Utils(){}

    static void getSegments(Vector<Point> points, Vector<Segment> segments){
        for(Point p : points){
            System.out.println("Le point : " + p + "appartient au segment : " + p.getSegments(segments));
        }
    }

    private static double crossProduct(Point originPoint, Point ext1, Point ext2) {
        return ((ext1.x - originPoint.x) * (ext2.y - originPoint.y)) - ((ext1.y - originPoint.y) * (ext2.x - originPoint.x));
    }

    static boolean pointIsInside(Point p, Segment s){
        return  crossProduct(p, s.topPoint, s.bottomPoint) == 0;
    }

    @SafeVarargs
    public static List<Segment> makeUnion(List<Segment> ... segmentsLists){
        Set<Segment> segments = new HashSet<>();
        for (List<Segment> list : segmentsLists)
            segments.addAll(list);
        return new ArrayList<>(segments);
    }
}

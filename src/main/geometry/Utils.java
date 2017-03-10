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

    static double crossProduct(Point originPoint, Point ext1, Point ext2){
        return  ((ext1.x - originPoint.x) * (ext2.y - originPoint.y)) - ((ext1.y - originPoint.y) * (ext2.x - originPoint.x));
    }

    public static List<Segment> makeUnion(List<Segment> ... lists){
        Set<Segment> segmentSet = new HashSet<>();
        //List<Segment> segments = new ArrayList<>();
        for (List<Segment> l : lists)
            segmentSet.addAll(l);
        return new ArrayList<>(segmentSet);
    }
}

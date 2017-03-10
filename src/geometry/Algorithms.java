package geometry;

import geometry.Points.Point;
import geometry.Points.PointComparator;

import java.util.*;

public class Algorithms {

    private Algorithms(){}

    public static void findIntersection(Vector<Point> points, Vector<Segment> segments){
        /*Map<Point, Segment> pointSegmentMap = new HashMap<>();
        for(Segment s : segments){
            pointSegmentMap.put(s.topPoint, s);
            pointSegmentMap.put(s.bottomPoint, null);
        }*/
        System.out.println(points);
        List<Point> pointList = new ArrayList<>(points);
        pointList.sort(new PointComparator());
        System.out.println(pointList);
    }
}

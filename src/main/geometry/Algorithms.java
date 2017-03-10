package main.geometry;

import main.geometry.Points.Point;
import main.geometry.Points.PointComparator;

import java.util.*;

public class Algorithms {

    public static void findIntersection(Vector<Point> points, Vector<Segment> segments){
        List<Point> pointList = new ArrayList<>(points);
        pointList.sort(new PointComparator());

        List<Segment> containers;
        while (!pointList.isEmpty()){
            Point point = pointList.get(0);
            containers = new ArrayList<>(point.getSegments(segments));
            pointList.remove(point);
            handleEventPoint(point, containers);
        }
    }

    private static void handleEventPoint(Point point, List<Segment> segments){
        List<Segment> pointIsUpper = new ArrayList<>();
        List<Segment> pointIsLower = new ArrayList<>();
        List<Segment> pointIsInside = new ArrayList<>();
        for (Segment s : segments){
            if (s.topPoint == point)
                pointIsUpper.add(s);
            else if(s.bottomPoint == point)
                pointIsLower.add(s);
            else if(Utils.crossProduct(point, s.topPoint, s.bottomPoint) == 0)
                pointIsInside.add(s);
        }



    }
}

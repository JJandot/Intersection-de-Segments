package main.geometry;

import main.geometry.Points.Point;
import main.geometry.Points.PointComparator;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Algorithms {

    private static List<Segment> sweepLine = new ArrayList<>();

    public static void findIntersection(Vector<Point> points, Vector<Segment> segments) {
        List<Point> pointList = new ArrayList<>(points);
        pointList.sort(new PointComparator());

        while (!pointList.isEmpty()){
            Point point = pointList.get(0);
            pointList.remove(point);
            handleEventPoint(point, segments);
            System.out.println(sweepLine);
        }
    }

    private static void handleEventPoint(Point point, Vector<Segment> segments){
        if(point.isUpper)
            sweepLine.addAll(point.getSegments(segments));
        else
            sweepLine.removeAll(point.getSegments(segments));
    }

    /*public static void findIntersection(Vector<Point> points, Vector<Segment> segments){
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
            else if(Utils.pointIsInside(point, s))
                pointIsInside.add(s);
        }

        List<Segment> unionList = Utils.makeUnion(pointIsUpper, pointIsInside, pointIsLower);

        System.out.println(point);
        if(unionList.size() > 1){
            System.out.println(" est une intersection");
        }
        else
            System.out.println(" n'est pas une intersection");
    }*/
}

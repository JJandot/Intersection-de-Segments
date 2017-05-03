package main;

import main.geometry.Point;
import main.geometry.Segment;

import java.util.*;

public class Utils {

    private Utils(){}

    private static double crossProduct(Point originPoint, Point ext1, Point ext2) {
        return ((ext1.x - originPoint.x) * (ext2.y - originPoint.y)) - ((ext1.y - originPoint.y) * (ext2.x - originPoint.x));
    }

    public static boolean pointIsInside(Point p, Segment s){
        return  crossProduct(p, s.topPoint, s.bottomPoint) == 0;
    }

    @SafeVarargs
    public static List<Segment> makeUnion(List<Segment> ... segmentsLists){
        Set<Segment> segments = new HashSet<>();
        for (List<Segment> list : segmentsLists)
            segments.addAll(list);
        return new ArrayList<>(segments);
    }

    public double getCurrentY(Segment segment, double x){
        Point a = segment.getMinXPoint();
        Point b = segment.getMaxXPoint();

        double coeffDir = (b.y - a.y)/(b.x - a.x);
        double constante = a.y - (coeffDir * a.x);

        System.out.println("eqn : y = " + coeffDir + "* X" + constante);

        return coeffDir * x + constante;
    }
}

package geometry;

import geometry.Points.Point;

import java.util.Vector;

public class Utils {

    private Utils(){}

    public static void getSegments(Vector<Point> points, Vector<Segment> segments){
        for(Point p : points){
            System.out.println("Le point : " + p + "appartient au segment : " + p.getSegments(segments));
        }
    }
}

package main;

import main.geometry.Events.Event;
import main.geometry.Events.EventYComparator;
import main.geometry.Point;
import main.geometry.Segment;
import main.geometry.SegmentXComparator;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.Vector;

public class Algorithms {

    private static TreeSet<Segment> segmentTreeSet = new TreeSet<>(new SegmentXComparator());
    private static List<Event> events = new ArrayList<>();


    public static void findIntersection(Vector<Point> points, Vector<Segment> segments) {
        for(Point point : points){
            events.add(new Event(point, point.getU(segments), point.getL(segments), point.getC(segments)));
        }
        events.sort(new EventYComparator());

        while (!events.isEmpty()){
            Event event = events.get(0);
            events.remove(event);
            handleEventPoint(event, points);
            System.out.println(segmentTreeSet);
        }
    }

    private static void handleEventPoint(Event event, Vector<Point> points) {
        List<Segment> union = Utils.makeUnion(event.getU(), event.getC(), event.getL());
        if(union.size() > 1) {
            points.add(event.getPoint());
            System.out.println("bla intersection");
        }

        //5
        //segmentTreeSet.removeAll(Utils.makeUnion(event.getL(),event.getC()));
        List<Segment> l = event.getL();
        if(!l.isEmpty())
            segmentTreeSet.removeAll(event.getL());

        //6
        List<Segment> uc = Utils.makeUnion(event.getU(), event.getC());
        segmentTreeSet.addAll(event.getU());

        //8
        if (uc.isEmpty()){
            Segment base = event.getL().get(0);
            Segment floorBase = segmentTreeSet.floor(base);
            Segment ceilingBase = segmentTreeSet.ceiling(base);
            if(base != null && floorBase != null && ceilingBase != null && base != floorBase && base != ceilingBase)
                findNewEvent(segmentTreeSet.floor(base), segmentTreeSet.ceiling(base), event, points);
        }
        else{
            Segment left = uc.get(0);
            Segment floorLeft = segmentTreeSet.floor(left);
            if(left != null && floorLeft != null && left != floorLeft)
                findNewEvent(floorLeft, left, event, points);
            Segment right = uc.get(uc.size()-1);
            Segment ceilingRight = segmentTreeSet.ceiling(right);
            if(right != null && ceilingRight != null && right != ceilingRight)
                findNewEvent(ceilingRight, right, event, points);
        }
    }

    private static void findNewEvent(Segment sg, Segment sd, Event event, Vector<Point> points){
        Point intersection = Utils.getIntersectionPoint(sg, sd);
        System.out.println("Intersection possible : " + intersection);

        if(intersection.x < sg.getMinXPoint().x || intersection.x < sd.getMinXPoint().x || intersection.x > sg.getMaxXPoint().x || intersection.x > sd.getMaxXPoint().x)
            System.out.println("Pas d'intersection");
            //refaire avec que le point le plus à gauche
        else
            points.add(intersection);
        /*if(event.getPoint().y < intersection.y)
            System.out.println("intersection");
        else if(event.getPoint().y == intersection.y && event.getPoint().x < event.getPoint().x)
            System.out.println("intersection");*/
    }
}

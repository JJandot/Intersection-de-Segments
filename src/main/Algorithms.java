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

    private static Vector<Segment> segmentsList;


    public static void findIntersection(Vector<Point> points, Vector<Segment> segments) {
        segmentsList = new Vector<>(segments);
        for(Point point : points){
            events.add(new Event(point, point.getU(segments), point.getL(segments), point.getC(segments)));
        }
        events.sort(new EventYComparator());

        while (!events.isEmpty()){
            System.out.println(segmentTreeSet);
            Event event = events.get(0);
            events.remove(event);
            handleEventPoint(event, points);
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
            System.out.println("-------VIDE-----------");
            Segment base = null;
            if(!event.getL().isEmpty())
                base = event.getL().get(0);
            if(base == null) return;
            Segment floorBase = segmentTreeSet.floor(base);
            Segment ceilingBase = segmentTreeSet.ceiling(base);
            if(floorBase != null && ceilingBase != null && base != floorBase && base != ceilingBase)
                findNewEvent(segmentTreeSet.floor(base), segmentTreeSet.ceiling(base), event, points);
        }
        else{
            System.out.println("---------UC---------");
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
        System.out.println("Sg : " + sg + ", Sd : " + sd);
        Point intersection = Utils.getIntersectionPoint(sg, sd);

        System.out.println("Intersection possible : " + intersection);

        if(intersection.x > sd.getMaxXPoint().x)
            return;
        if(intersection.x > sg.getMaxXPoint().x)
            return;
        if(intersection.x < sg.getMinXPoint().x)
            return;
        if(intersection.x < sd.getMinXPoint().x)
            return;

        if(intersection.y < sd.topPoint.y)
            return;
        if(intersection.y < sg.topPoint.y)
            return;
        if(intersection.y > sd.bottomPoint.y)
            return;
        if(intersection.y > sg.bottomPoint.y)
            return;

        points.add(intersection);
        Event e = new Event(intersection, intersection.getU(segmentsList), intersection.getL(segmentsList), intersection.getC(segmentsList));
        System.out.println(" E : " + event);
        if(!events.contains(e)) {
            events.add(e);
            events.sort(new EventYComparator());
        }
    }
}

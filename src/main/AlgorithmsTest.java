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

public class AlgorithmsTest {

    private static TreeSet<Segment> segmentTreeSet = new TreeSet<>(new SegmentXComparator());
    private static List<Event> events = new ArrayList<>();


    public static void findIntersection(Vector<Point> points, Vector<Segment> segments) {
        for(Point point : points){
            events.add(new Event(point, point.getU(segments), point.getL(segments), point.getC(segments)));
        }
        events.sort(new EventYComparator());
        System.out.println(events);

        while (!events.isEmpty()){
            Event event = events.get(0);
            events.remove(event);
            handleEventPoint(event);
        }
    }

    private static void handleEventPoint(Event event) {
        List<Segment> union = Utils.makeUnion(event.getU(), event.getC(), event.getL());
        if(union.size() > 1) {
            //event.getPoint();
            System.out.println("intersection");
        }



    }

    private static void findNewEvent(Segment sg, Segment sd, Event event){

    }
}

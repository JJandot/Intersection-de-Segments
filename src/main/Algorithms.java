package main;

import main.geometry.Events.Event;
import main.geometry.Events.EventXComparator;
import main.geometry.Events.EventYComparator;
import main.geometry.Point;
import main.geometry.Segment;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.Vector;

public class Algorithms {

    private static TreeSet<Event> eventTreeSet = new TreeSet<>(new EventXComparator());

    public static void findIntersection(Vector<Point> points, Vector<Segment> segments) {
        List<Event> events = new ArrayList<>();
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

    }
}

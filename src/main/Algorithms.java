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
        if(union.size() != 1) {
            //event.getPoint();
            System.out.println("intersection");
        }

        //ligne 5
        List<Segment> lc = Utils.makeUnion(event.getL(), event.getC());
        for(Segment s : lc){
            Point p = s.bottomPoint;
            for(Event e : eventTreeSet)
                if(e.getPoint() == p)
                    eventTreeSet.remove(e);
        }

        //ligne6
        List<Segment> uc = Utils.makeUnion(event.getU(), event.getC());
        for(Segment s : lc){
            Point p = s.topPoint;
            for(Event e : eventTreeSet)
                if(e.getPoint() == p)
                    eventTreeSet.add(e);
        }

        if(uc.size() == 0){
            if(uc.size() > 1) {
                List<Segment> segmentsGauche = eventTreeSet.floor(event).getU();
                List<Segment> segmentsDroite = eventTreeSet.ceiling(event).getU();
                Segment sg = segmentsGauche.get(segmentsGauche.size() - 1);
                Segment sd = segmentsDroite.get(0);
                findNewEvent(sg, sd, event);
            }
        }
        else{
            //eventTreeSet.floor()
        }
    }

    private static void findNewEvent(Segment sg, Segment sd, Event event){

    }
}

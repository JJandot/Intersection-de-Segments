package main.geometry.Events;

import main.geometry.Point;
import main.geometry.Segment;

import java.util.List;

public class Event {

    private Point point;
    private List<Segment> u;
    private List<Segment> l;
    private List<Segment> c;
    private EventType type;

    public Point getPoint(){
        return point;
    }
    public double getY(){
        return point.y;
    }
    public double getX(){
        return point.x;
    }

    public Event(Point point, List<Segment> u, List<Segment> l, List<Segment> c) {
        this.point = point;
        this.u = u;
        this.l = l;
        this.c = c;
        if(this.u.size() != 0)
            type = EventType.DEBUT;
        else
            type = EventType.FIN;
    }

    @Override
    public String toString() {
        /*return "Event{" +
                "point=" + point +
                ", u=" + u +
                ", l=" + l +
                ", c=" + c +
                '}';*/
        return "Event[]";
    }

    public List<Segment> getU() {
        return u;
    }

    public List<Segment> getL() {
        return l;
    }

    public List<Segment> getC() {
        return c;
    }
}

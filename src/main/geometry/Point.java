package main.geometry;

import main.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/** La classe main.geometry.Point. */
public class Point {

    /**
     * La valeur de x.
     */
    public double x;

    /**
     * La valeur de y.
     */
    public double y;

    /**
     * Constructeur avec initialisation de x et y.
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }


    public Vector<Segment> getSegments(Vector<Segment> segments){
        Vector<Segment> containers = new Vector<>();
        for(Segment s : segments){
            if(s.topPoint == this || s.bottomPoint == this || Utils.pointIsInside(this, s))
                containers.add(s);
        }
        return containers;
    }

    public List<Segment> getU(Vector<Segment> segments){
        List<Segment> u = new ArrayList<>();
        for(Segment s : segments){
            if(s.topPoint == this)
                u.add(s);
        }
        return u;
    }

    public List<Segment> getL(Vector<Segment> segments){
        List<Segment> l = new ArrayList<>();
        for(Segment s : segments){
            if(s.bottomPoint == this)
                l.add(s);
        }
        return l;
    }

    public List<Segment> getC(Vector<Segment> segments){
        List<Segment> c = new ArrayList<>();
        for(Segment s : segments){
            if(Utils.pointIsInside(this, s))
                c.add(s);
        }
        return c;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
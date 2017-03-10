package geometry.Points;

import geometry.Segment;

import java.util.Vector;

/** La classe geometry.Points.Point. */
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
            if(s.topPoint == this || s.bottomPoint == this)
                containers.add(s);
        }
        return containers;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
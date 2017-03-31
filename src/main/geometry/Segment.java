package main.geometry;

import main.geometry.Points.Point;

/** La classe segment */
public class Segment {

    private static int num = 0;
    /**
     * L'extremite topPoint.
     */
    public Point topPoint;

    /**
     * L'extremite bottomPoint.
     */
    public Point bottomPoint;

    public int number;
    /**
     * Constructeur avec initialisation de topPoint et bottomPoint.
     */
    public Segment(Point a, Point b) {
        if(a.y < b.y){
            topPoint = a;
            bottomPoint = b;
            a.isUpper = true;
        }
        else {
            topPoint = b;
            bottomPoint = a;
            b.isUpper = true;
        }
        number = ++num;
    }

    @Override
    public String toString(){
        return "Segment n°" + number;
    }
}

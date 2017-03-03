package geometry;

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
        }
        else {
            topPoint = b;
            bottomPoint = a;
        }
        number = ++num;
    }

    @Override
    public String toString() {
        return "Segment{" +
                "topPoint=" + topPoint +
                ", bottomPoint=" + bottomPoint +
                '}';
    }

    public String toStringNb(){
        return "Segment n°" + number;
    }
}

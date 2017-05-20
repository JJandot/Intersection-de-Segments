package tests;

import main.Utils;
import main.geometry.Point;
import main.geometry.Segment;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class UtilsTest {
    @Test
    public void getIntersectionPoint() throws Exception {

        Segment sg = new Segment(new Point(1, 1), new Point(2,3));
        Segment sd = new Segment(new Point(1, 3), new Point(2,1));

        double coeffSg = Utils.getCoeffDir(sg);
        double coeffSd = Utils.getCoeffDir(sd);
        double constSg = Utils.getConstante(sg);
        double constSd = Utils.getConstante(sd);

        System.out.println(coeffSg);
        System.out.println(coeffSd);
        System.out.println(constSg);
        System.out.println(constSd);


        double coeff = coeffSg - coeffSd;
        double constante = constSd - constSg;

        System.out.println(coeff);
        System.out.println(constante);

        double x = constante / coeff;
        System.out.println(x);

        double y = coeffSg * x + constSg;
        System.out.println(y);

        Assert.assertEquals(x, 1.5, 0);
        Assert.assertEquals(y, 2.0, 0);


    }

    @Test
    public void makeUnion() throws Exception {
        Segment s1 = new Segment(new Point(50, 20), new Point(15, 15));

        List<Segment> l1 = new ArrayList<>();
        List<Segment> l2 = new ArrayList<>();
        List<Segment> l3 = new ArrayList<>();
        l1.add(s1);
        l2.add(s1);
        l2.add(s1);
        l3.add(s1);

        List<Segment> finalList = new ArrayList<>();
        finalList.add(s1);

        List<Segment> test = Utils.makeUnion(l1, l2, l3);
        Assert.assertEquals(test, finalList);
    }
}

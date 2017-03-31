package tests;

import main.geometry.Points.Point;
import main.geometry.Segment;
import main.geometry.Utils;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class UtilsTest {

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

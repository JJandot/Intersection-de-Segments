package main.geometry.Events;

import java.util.Comparator;

public class EventXComparator implements Comparator<Event> {

    @Override
    public int compare(Event e1, Event e2) {
        return e1.getX() < e2.getX() ? - 1 : e1.getX() == e2.getX() ? 0 : 1;
    }
}

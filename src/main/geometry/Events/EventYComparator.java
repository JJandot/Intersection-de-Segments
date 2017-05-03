package main.geometry.Events;

import java.util.Comparator;

public class EventYComparator implements Comparator<Event> {

    @Override
    public int compare(Event e1, Event e2) {
        return e1.getY() < e2.getY() ? - 1 : e1.getY() == e2.getY() ? 0 : 1;
    }
}

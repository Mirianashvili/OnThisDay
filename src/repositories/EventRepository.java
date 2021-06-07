package repositories;

import models.Event;

import java.util.ArrayList;
import java.util.Comparator;

public class EventRepository implements IEventRepository {

    ArrayList<Event> events;

    public EventRepository(ArrayList<Event> events){
        this.events = events;
        events.sort(Comparator.comparingInt(Event::getYear));
    }

    @Override
    public ArrayList<Event> getAll() {
        return events;
    }
}

package repositories;

import models.Event;

import java.util.ArrayList;

public class EventRepository implements IEventRepository {

    ArrayList<Event> events;

    public EventRepository(ArrayList<Event> events){
        this.events = events;
    }

    @Override
    public ArrayList<Event> getAll() {
        return events;
    }
}

package repositories;

import models.Event;
import repositories.IEventRepository;

import java.util.ArrayList;
import java.util.Random;

public class InMemoryEventRepository implements IEventRepository {

    ArrayList<Event> events;

    public InMemoryEventRepository(){
        this.events = new ArrayList<>();
        Random rand = new Random();
        for(int i = 0 ; i < 100 ; i++){
            Event event = new Event();
            event.setYear(rand.nextInt(2021));
            event.setDescription("Something awesome happened today!");
            events.add(event);
        }
    }

    @Override
    public ArrayList<Event> getAll() {
        return events;
    }
}

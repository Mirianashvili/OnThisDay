import models.Event;
import repositories.IEventRepository;

import java.util.ArrayList;

public class Main {
    public static void main(String []args) {

        IEventRepository eventRepository = FactsProvider.getEvents(TimeGenerator.getTime("october",14));
        ArrayList<Event> events = eventRepository.getAll();
        for(int i = 0; i < events.size() ; i++){
            Event event = events.get(i);
            System.out.println(event.getYear() + " " + event.getDescription());
        }

    }
}

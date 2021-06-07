import models.Event;
import providers.FactsProvider;
import repositories.IEventRepository;

import java.util.ArrayList;

public class Main {
    public static void main(String []args) {

        IEventRepository eventRepository = providers.FactsProvider.getEvents(
                utils.TimeGenerator.getTime("may",5)
        );

        //IEventRepository eventRepository = FactsProvider.getToday();

        ArrayList<Event> events = eventRepository.getAll();

        for(int i = 0; i < events.size() ; i++){
            Event event = events.get(i);
            System.out.println(event);
        }

    }
}

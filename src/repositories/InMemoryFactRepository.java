package repositories;

import models.Fact;

import java.util.ArrayList;
import java.util.Random;

public class InMemoryFactRepository implements IFactRepository {

    ArrayList<Fact> events;

    public InMemoryFactRepository(){
        this.events = new ArrayList<>();
        Random rand = new Random();
        for(int i = 0 ; i < 100 ; i++){
            Fact event = new Fact();
            event.setYear(rand.nextInt(2021));
            event.setDescription("Something awesome happened today!");
            events.add(event);
        }
    }

    @Override
    public ArrayList<Fact> getAll() {
        return events;
    }
}

package repositories;

import models.Fact;

import java.util.ArrayList;
import java.util.Comparator;

public class FactRepository implements IFactRepository {

    ArrayList<Fact> events;

    public FactRepository(ArrayList<Fact> events){
        this.events = events;
        events.sort(Comparator.comparingInt(Fact::getYear));
    }

    @Override
    public ArrayList<Fact> getAll() {
        return events;
    }
}

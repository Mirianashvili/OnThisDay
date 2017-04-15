package repositories;

import models.Event;

import java.util.ArrayList;

public interface IEventRepository {
    ArrayList<Event> getAll();
}

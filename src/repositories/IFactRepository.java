package repositories;

import models.Fact;

import java.util.ArrayList;

public interface IFactRepository {
    ArrayList<Fact> getAll();
}

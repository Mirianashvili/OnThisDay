package models;

public class Event {
    int year;
    String description;

    public Event() { }

    public Event(int year, String description) {
        this.year = year;
        this.description = description;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Event{" +
                "year=" + year +
                ", description='" + description + '\'' +
                '}';
    }
}

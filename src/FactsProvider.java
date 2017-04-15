import models.Event;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import repositories.EventRepository;
import repositories.IEventRepository;
import repositories.InMemoryEventRepository;

import java.util.ArrayList;

public class FactsProvider {

    private static String BaseUrl = "http://www.historynet.com/today-in-history/";

    private static Elements getFactsTodayTableHtml(String url) {
        Elements facts = null;
        try {
            Document doc = Jsoup.connect(url).get();
            facts = doc.select("section.entry-content.clearfix table tbody tr");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return facts;
    }

    private static ArrayList<Event> getEvents(Elements facts){
        ArrayList<Event> events = new ArrayList<>();
        for(int i = 0 ; i < facts.size() ; i++){
            Element fact = facts.get(i);
            String yearString = fact.select("td b").get(0).text();

            if(yearString.contains("Born")){
                continue;
            }

            int year = Integer.parseInt(yearString);

            String desc = fact.select("td").get(2).text();
            Event event = new Event(year,desc);
            events.add(event);
        }
        return events;
    }


    public static IEventRepository getToday(){
        Elements facts = getFactsTodayTableHtml(BaseUrl);
        IEventRepository eventRepository = new EventRepository(getEvents(facts));
        return eventRepository;
    }

    public static IEventRepository getEvents(String time){
        Elements facts = getFactsTodayTableHtml(BaseUrl + time);
        IEventRepository eventRepository = new EventRepository(getEvents(facts));
        return eventRepository;
    }

    public static IEventRepository getInMemoryEvents(){
        return new InMemoryEventRepository();
    }

}

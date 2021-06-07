package providers;

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

    private static final String BaseUrl = "https://www.historynet.com/today-in-history/";

    private static Elements getFactsHtmlList(String url) {
        Elements facts = null;
        try {
            Document doc = Jsoup.connect(url).get();
            facts = doc.select("div.war-event,div.birth-event");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return facts;
    }

    private static ArrayList<Event> getEvents(Elements facts){
        ArrayList<Event> events = new ArrayList<>();
        for(int i = 0 ; i < facts.size() ; i++){
            Element fact = facts.get(i);
            String yearString = fact.select("[itemprop=startDate]").get(0).text();

            int year = Integer.parseInt(yearString);

            String desc = fact.select("p[itemprop=description]").get(0).text();
            Event event = new Event(year,desc);
            events.add(event);
        }
        return events;
    }


    public static IEventRepository getToday(){
        Elements facts = getFactsHtmlList(BaseUrl);
        return new EventRepository(getEvents(facts));
    }

    public static IEventRepository getEvents(String time){
        Elements facts = getFactsHtmlList(BaseUrl + time);
        return new EventRepository(getEvents(facts));
    }

    public static IEventRepository getInMemoryEvents(){
        return new InMemoryEventRepository();
    }

}

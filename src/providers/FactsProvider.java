package providers;

import models.Fact;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import repositories.FactRepository;
import repositories.IFactRepository;
import repositories.InMemoryFactRepository;

import java.util.ArrayList;

public class FactsProvider {

    private static final String BaseUrl = "https://www.historynet.com/today-in-history/";

    /*
    * get facts as elements
    * */
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
    /*
    * fact elements to arrayList<Fact>
    * */
    private static ArrayList<Fact> getDocumentFacts(Elements facts){
        ArrayList<Fact> events = new ArrayList<>();

        if (facts == null){ return events; }

        for(int i = 0 ; i < facts.size() ; i++){
            Element fact = facts.get(i);

            String yearString = fact.select("[itemprop=startDate]").get(0).text();
            int year = Integer.parseInt(yearString);

            String desc = fact.select("p[itemprop=description]").get(0).text();

            Fact event = new Fact(year,desc);
            events.add(event);
        }
        return events;
    }


    public static IFactRepository getToday(){
        Elements factElements = getFactsHtmlList(BaseUrl);
        return new FactRepository(getDocumentFacts(factElements));
    }

    public static IFactRepository getDocumentFacts(String time){
        Elements factElements = getFactsHtmlList(BaseUrl + time);
        return new FactRepository(getDocumentFacts(factElements));
    }

    public static IFactRepository getInMemoryEvents(){
        return new InMemoryFactRepository();
    }

}

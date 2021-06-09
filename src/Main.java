import models.Fact;
import repositories.IFactRepository;
import utils.*;
import java.util.ArrayList;

public class Main {
    public static void main(String []args) {

        IFactRepository factRepository = providers.FactsProvider.getDocumentFacts(
                TimeGenerator.getTime("may",5)
        );

        //IEventRepository factRepository = FactsProvider.getToday();

        ArrayList<Fact> facts = factRepository.getAll();

        for(int i = 0; i < facts.size() ; i++){
            Fact fact = facts.get(i);
            System.out.println(fact);
        }

    }
}

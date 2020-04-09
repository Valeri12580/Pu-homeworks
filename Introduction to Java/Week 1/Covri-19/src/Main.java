import models.Accounting;
import models.Bar;
import models.NightStream;
import models.PartyNight;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.TreeMap;

public class Main {

    private static Bar bar=new Bar(new Accounting(new TreeMap<>()));

    public static void main(String[] args) {


        PartyNight partyNight=new PartyNight("EXTREME PARTY",1500.12, LocalDate.now(),300,new NightStream());

        bar.addPartyNight(partyNight);
        bar.getAccounting().addData("2020/04/2020",1500.321);

        System.out.println(bar.getAccounting().getData().get("2020/04/2020"));
        System.out.println();
    }
}

package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bar {
    private List<PartyNight> partyNightList;
    private  Accounting accounting;

    public Bar( Accounting accounting) {
        this.partyNightList = new ArrayList<>();
        setAccounting(accounting);
    }

    public List<PartyNight> getPartyNightList() {
        return Collections.unmodifiableList(partyNightList);
    }

    public void setPartyNightList(List<PartyNight> partyNightList) {
        this.partyNightList = partyNightList;
    }
    public void addPartyNight(PartyNight partyNight){
        partyNightList.add(partyNight);
    }

    public Accounting getAccounting() {
        return accounting;
    }

    public void setAccounting(Accounting accounting) {
        this.accounting = accounting;
    }
}

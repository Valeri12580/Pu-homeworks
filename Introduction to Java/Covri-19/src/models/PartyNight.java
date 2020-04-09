package models;

import java.time.LocalDate;


public class PartyNight {
    private String partyName;
    private double entityPrice;
    private LocalDate date;
    private int maxClients;
    private NightStream stream;


    public PartyNight(String partyName, double price, LocalDate date, int maxClients, NightStream stream) {
        setPartyName(partyName);
        setEntityPrice(price);
     setDate(date);
  setMaxClients(maxClients);
      setStream(stream);
    }

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public double getEntityPrice() {
        return entityPrice;
    }

    public void setEntityPrice(double entityPrice) {
        this.entityPrice = entityPrice;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getMaxClients() {
        return maxClients;
    }

    public void setMaxClients(int maxClients) {
        this.maxClients = maxClients;
    }

    public NightStream getStream() {
        return stream;
    }

    public void setStream(NightStream stream) {
        this.stream = stream;
    }
}


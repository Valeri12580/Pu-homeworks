package models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Map;

public class Accounting {

   private Map<String,Double>data;

    public Accounting(Map<String, Double> data) {
        setData(data);
    }

    public Map<String, Double> getData() {
        return Collections.unmodifiableMap(data);
    }

    public void setData(Map<String, Double> data) {
        this.data = data;
    }

    public  void addData(String date,double income){
        data.put(date,income);
    }




}

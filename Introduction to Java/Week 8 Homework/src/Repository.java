
import models.Adult;

import java.util.ArrayList;
import java.util.List;


public class Repository {
    private List<Adult> data;

    public Repository() {
        this.data=new ArrayList<>();
    }


    public void addList(List<Adult>person){
        this.data.addAll(person);
    }

    public List<Adult> getData() {
        return data;
    }


}

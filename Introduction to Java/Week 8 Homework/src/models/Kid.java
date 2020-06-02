package models;

public class  Kid  extends Person{

    public Kid(String firstName, String familyName, int age,char type) {
        super(firstName, familyName, age, type);


    }

    @Override
    public String toString() {
        return String.format("%s %s %d",this.getFirstName(),this.getLastName(),this.getAge());
    }
}

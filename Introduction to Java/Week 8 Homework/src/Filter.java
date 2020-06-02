import models.Adult;


import java.util.function.Predicate;

public class Filter {


    public Filter() {

    }

    public Predicate<Adult>getPredicate(String criteria, String value){


        switch (criteria){
            case "FNAME":
                return person -> person.getFirstName().equals(value);
            case "LNAME":
                return person -> person.getLastName().equals(value);
            case "AGE":
                int age=Integer.parseInt(value);
                return person -> person.getAge()==age;
            case "SEX":
                return person->person.getSex()==value.charAt(0);
            case "TYPE":
                return person->person.getType()==value.charAt(0);
            case "ADDRESS":
                return person->person.getAddress().equals(value);
            case "PHONENUMBER":
                return person->person.getPhonenumber().equals(value);
            case "PENSION":
            case "SALARY":
                return person->person.getMoney()==Double.parseDouble(value);
            case "KFNAME":
            case "KLNAME":
                return person->person.containsKidName(value);
            case "KAGE":
                return person->person.containsKidAge(Integer.parseInt(value));
            default:

        }
        //this can make some bugs..
        return null;
    }


}

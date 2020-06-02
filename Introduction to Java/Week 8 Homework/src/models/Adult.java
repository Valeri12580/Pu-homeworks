package models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Adult  extends Person{
    private String address;
    private String phonenumber;
    private char sex;
    private List<Kid> kids;
    private double money;


    public Adult(char type,String firstName, String lastName, int age, String address,  String phonenumber, char sex) {
        super(firstName, lastName, age, type);
        this.address = address;
        this.phonenumber = phonenumber;
        this.sex = sex;
        this.money = 0;
        this.kids=new ArrayList<>();
    }

    public String getAddress() {
        return address;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public char getSex() {
        return sex;
    }

    public List<Kid> getKids() {
        return kids;
    }

    public boolean containsKidName(String name){
        return this.getKids().stream().anyMatch(e -> e.getFirstName().equals(name) || e.getLastName().equals(name));
    }
    public boolean containsKidAge(int age){
        return this.getKids().stream().anyMatch(e -> e.getAge()==age);
    }

    public void setKids(List<Kid> kids) {
        this.kids = kids;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getMoney() {
        return money;
    }

    @Override
    public String toString() {
       String res= "";
       if(this.kids.size()==0){
           res=String.format("Money: %.2f",this.getMoney());
       }
       else{
           res="Kids: "+this.kids.stream().map(e->e.toString()).collect(Collectors.joining(","));
       }

        return String.format("%s | Address: %s | Phonenumber: %s | Sex: %s | %s |",super.toString()
                ,this.getAddress(),this.getPhonenumber(),this.getSex()
                ,res);
    }
}

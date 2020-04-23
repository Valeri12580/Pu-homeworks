package models;

public class Battery {
    private int power=4;

    public Battery() {
    }

    public void decreasePower(){
        this.power--;
    }

    public void fillThePower(){
        this.power=4;
    }

    public int getPower() {
        return power;
    }
}

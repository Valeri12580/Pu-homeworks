package models;


import helpers.GenerateRandomNumber;

public class Robot {
    private String name;
    private Battery battery;


    public Robot(String name) {
        this.name = name;
        this.battery = new Battery();

    }

    public String getName() {
        return name;
    }


    public boolean checkIfBatteryHavePower() {
        return this.battery.getPower() > 0;
    }

    public boolean findTheObject(int pixels) {

        return pixels % 2 == 0;
    }

    public void recharge() {
        int firstNumber;
        int secondNumber;

        do {
            firstNumber =  GenerateRandomNumber.generateRandomNumber(1000);
            secondNumber =  GenerateRandomNumber.generateRandomNumber(1000);

        } while (firstNumber == secondNumber);

        if (firstNumber > secondNumber) {
            this.battery.fillThePower();
            System.out.println("This socket have electricity.Recharging....");
        }else{
            System.out.println("No electricity.Pay your bills!!!:@@");
        }
    }

    public void attack() {
        this.battery.decreasePower();
       int powerOfAttack=GenerateRandomNumber.generateRandomNumber(10);
       String result=powerOfAttack==5?"Besides the mouse, the furniture also went away .. :(":"The mouse is dead!";
        System.out.println(result);

    }

    public void talk(){
        StringBuilder message = new StringBuilder();
        for (int i = 10; i >0 ; i--) {
            if(i%2==0){
                message.append("I am roboooootttttt!@#!@#@! -- ");
            }
            message.append(i).append(System.lineSeparator());

        }
        System.out.println(message.toString());

    }




}

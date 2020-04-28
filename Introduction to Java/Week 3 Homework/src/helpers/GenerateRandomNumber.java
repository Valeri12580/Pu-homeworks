package helpers;

import java.util.Random;


public final class GenerateRandomNumber {

    private  static Random random;

    static {
        random=new Random();
    }

    private GenerateRandomNumber(){

    }

    public static int generateRandomNumber(int bound){
        return  random.nextInt(bound)+1;
    }
}

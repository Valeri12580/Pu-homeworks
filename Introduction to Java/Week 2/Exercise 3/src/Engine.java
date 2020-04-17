import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Engine  implements Runnable{


    public Engine() {

    }

    @Override
    public void run() {

        for (int i = 8; i>0 ; i--) {

            switch (i){
                case 8:
                    System.out.println("Пепииии");
                    break;
                case 7:
                    System.out.println("Ваняя");
                    break;
                case 6:
                    System.out.println("Никоол");
                    break;
                case 5:
                    System.out.println("Гретаа");
                    break;
                case 4:
                    System.out.println("Пенкааа");
                    break;
                case 3:
                    System.out.println("Даянааа");
                    break;
                case 2:
                    System.out.println("Айшеее");
                    break;
                case 1:
                    System.out.println("Генкаа");
                    break;

            }
        }
        System.out.println("Ауч!");

    }
}

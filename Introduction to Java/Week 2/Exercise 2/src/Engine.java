import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;

public class Engine  implements Runnable{
    private final BufferedReader reader;
    private final LocalDate localDate;

    public Engine() {
        this.reader=new BufferedReader(new InputStreamReader(System.in));
        this.localDate=LocalDate.now();
    }

    @Override
    public void run() {
        try {
            String monthName=reader.readLine();
            this.printTheResult(monthName);

        } catch (Exception e) {
            System.out.println("Error!");
        }

    }

    private void printTheResult(String monthName){
        int days=0;
        //бих го направил с switch-case,но в условието така пише...
        if("January".equals(monthName)){
            days= localDate.withMonth(1).lengthOfMonth();
        }else if ("February".equals(monthName)){
            days= localDate.withMonth(2).lengthOfMonth();
        }
        else if ("March".equals(monthName)){
            days= localDate.withMonth(3).lengthOfMonth();
        }
        else if ("April".equals(monthName)){
            days= localDate.withMonth(4).lengthOfMonth();
        }
        else if ("May".equals(monthName)){
            days= localDate.withMonth(5).lengthOfMonth();
        }
        else if ("June".equals(monthName)){
            days= localDate.withMonth(6).lengthOfMonth();
        }
        else if ("July".equals(monthName)){
            days= localDate.withMonth(7).lengthOfMonth();
        }
        else if ("August".equals(monthName)){
            days= localDate.withMonth(8).lengthOfMonth();
        }
        else if ("September".equals(monthName)){
            days= localDate.withMonth(9).lengthOfMonth();
        }
        else if ("October".equals(monthName)){
            days= localDate.withMonth(10).lengthOfMonth();
        }
        else if ("November".equals(monthName)){
            days= localDate.withMonth(11).lengthOfMonth();
        }
        else if ("December".equals(monthName)){
            days= localDate.withMonth(12).lengthOfMonth();
        }

        System.out.println(String.format("%d days",days));
    };




}

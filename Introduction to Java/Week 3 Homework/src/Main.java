import models.Robot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        String robotName = getRobotName(reader);

        Action action=new Action(reader,new Robot(robotName));

        action.start();



    }

    private static String getRobotName(BufferedReader reader) throws IOException {
        System.out.println("Enter the name of the robot:");
        return reader.readLine();
    }
}

import enums.FrontObjects;
import models.Robot;

import java.io.BufferedReader;
import java.io.IOException;

public class Action {
    private final BufferedReader reader;
    private final Robot robot;

    public Action(BufferedReader reader, Robot robot) {
        this.reader = reader;
        this.robot = robot;
    }


    public void start() throws IOException {
        String command = "";

        while (!"End".equals(command)) {
            System.out.println("What is the object in front of me[Nothing,Chair,Wall]?");

            try {
                command = FrontObjects.valueOf(reader.readLine()).toString();
            } catch (IllegalArgumentException e) {
                System.out.println("Wrong option!");
                continue;
            }

            if (!command.equals("Nothing")) {

                System.out.printf("The robot will %s!\n", command.equals("Chair") ? "jump" : command.equals("End")?"stop..":"go sideway");
                continue;
            }

            if (this.robot.checkIfBatteryHavePower()) {
                System.out.println("Pixels:");
                int pixels = Integer.parseInt(reader.readLine());

                if (this.robot.findTheObject(pixels)) {
                    this.robot.attack();
                }
            } else {
                System.out.println("Searching for working socket...");
                this.robot.recharge();
            }

        }

        this.robot.talk();

    }


}


import data.Menus;
import logic.ArrayNumberUtil;
import logic.ArrayStringUtil;
import logic.base.ArrayUtil;

import java.util.Scanner;

public class Program {
    private final ArrayUtil<String> arrayStringUtil;
    private final ArrayUtil<Integer> arrayNumberUtil;
    private final Scanner scanner;

    public Program() {
        this.arrayStringUtil = new ArrayStringUtil();
        this.arrayNumberUtil = new ArrayNumberUtil();
        this.scanner = new Scanner(System.in);
    }


    public void start()  {
        printMainMenu();
        int mainChoice;
        while ((mainChoice = Integer.parseInt(scanner.nextLine())) != 3) {
            if (mainChoice == 1) {
                arrayNumberUtil.run();
            } else {
                arrayStringUtil.run();
            }


            printMainMenu();

        }

        System.out.println("Stopping..");


    }


    private void printMainMenu() {
        System.out.println(Menus.MAIN_MENU);
    }
}

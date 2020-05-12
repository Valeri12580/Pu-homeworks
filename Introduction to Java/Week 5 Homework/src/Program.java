import messages.CommandMessages;
import utils.ArrayUtil;
import utils.formatter.Formatter;

import java.util.Scanner;

public class Program implements Runnable {
    private final Scanner scanner;
    //    private final  ArrayOperations operations;
    private double[] numbers;

    public Program() {
        this.scanner = new Scanner(System.in);
//        this.operations = new ArrayOperations();

        init();
    }

    @Override
    public void run() {
        int command = 0;

        while (command != 12) {

            printCommands();
            System.out.print("Choose: ");
            command = Integer.parseInt(scanner.nextLine());
            System.out.println(this.executeCommand(command));


        }

    }

    private String executeCommand(int number) {
        String message = null;
        switch (number) {
            case 1:
                //implement interface
                ArrayUtil.sorter.sort("ascending", numbers);
                break;
            case 2:
                ArrayUtil.sorter.sort("descending", numbers);
                break;
            case 3:
                System.out.print("Enter the number: ");
                double desiredNumber = Double.parseDouble(scanner.nextLine());
                int position = ArrayUtil.searcher.search("binary", desiredNumber, numbers);
                message = position == -1 ? "The number's position can't be found!" : String.format("The number %s is on index %d (the array is sorted in  ascending order)",Formatter.format(desiredNumber) ,position);
                break;
            case 4:
                ArrayUtil.randomize(numbers);
                break;
            case 5:
                message = String.format("The sum of the numbers is: %s", Formatter.format(ArrayUtil.math.sum(numbers)));
                break;
            case 6:
                message = String.format("The max number is : %s", Formatter.format(ArrayUtil.math.findMax(numbers)));
                break;
            case 7:
                message = String.format("The min number is: %s", Formatter.format(ArrayUtil.math.findMin(numbers)));
                break;
            case 8:
                message = String.format("The average of the numbers is: %s", Formatter.format(ArrayUtil.math.findAvg(numbers)));
                break;
            case 9:
                String result=ArrayUtil.isSymmetric(numbers) ? "The array is symmetric:" : "The array is not symmetric:";
                String array=ArrayUtil.printer.formatPrint(numbers);
                message=String.format("The array %s %s",result,array);
                break;
            case 10:
                ArrayUtil.reverseArray(numbers);
                break;
            case 11:
                message = ArrayUtil.printer.formatPrint(numbers);
                break;
            case 12:
                message = "Ending..";
                break;
            default:
                message = "Error!";
                break;

        }
        message = message == null ? "Done!" : message;

        return message;

    }

    private void init() {
        System.out.print("Length of the array: ");

        int length = Integer.parseInt(scanner.nextLine());

        this.numbers = new double[length];

        for (int i = 0; i < length; i++) {
            System.out.print("Number: ");
            double input = Double.parseDouble(scanner.nextLine());
            if (input < 0 || input > 100) {
                System.out.println("Invalid input..");
                continue;
            }
            numbers[i] = input;
        }

    }


    private void printCommands() {
        System.out.println(CommandMessages.COMMAND_MESSAGES);
    }
}

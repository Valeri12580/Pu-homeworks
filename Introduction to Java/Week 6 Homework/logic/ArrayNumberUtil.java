package logic;

import data.Menus;
import logic.base.ArrayUtil;

import java.util.*;
import java.util.stream.Collectors;


public class ArrayNumberUtil extends ArrayUtil<Integer> {

    public ArrayNumberUtil() {
        super();
    }

    @Override
    public void run() {

        this.fill();

        printMenu();

        int choice;

        while ((choice = Integer.parseInt(super.scanner.nextLine())) != 7) {

            System.out.println(executeCommand(choice));
            printMenu();
        }

    }

    @Override
    protected void fill() {
        System.out.println("Enter the size:");
        int size = Integer.parseInt(scanner.nextLine());

        int i = 0;
        while (size > i) {
            System.out.println("Enter number in range 0-10000");
            int number = Integer.parseInt(super.scanner.nextLine());
            if (number < 0 || number > 10000) {
                System.out.println("Invalid number");
                continue;
            }

            this.data.add(number);
            i++;
        }
    }


    @Override
    protected void printMenu() {
        System.out.println(Menus.ARRAY_NUMBER_UTIL_MENU);
    }

    @Override
    protected String executeCommand(int number) {
        String result = "";

        switch (number) {
            case 1:
                result = String.format("Simple numbers are:%s", getSimpleNumbersAsString());
                break;
            case 2:
                result = String.format("The most common number is %d", findMostCommonElementInTheArray());
                break;
            case 3:
                result = String.format("The max sequence of ascending numbers %s", this.findMaxSequenceOf("ascending"));
                break;
            case 4:
                result = String.format("The max sequence of descending numbers %s", this.findMaxSequenceOf("descending"));
                break;
            case 5:
                result = String.format("The max sequence of equal numbers %s", this.findMaxSequenceOf("equal"));
                break;
            case 6:

                result = findSequenceSumRandom();
                result = result == null ? "There is not result" : String.format("%s", result);
                break;

        }
        return result;
    }


    private int findMostCommonElementInTheArray() {
        Map<Integer, Integer> data = new HashMap<>();

        for (Integer element : super.data) {
            if (!data.containsKey(element)) {
                data.put(element, 0);
            }

            data.put(element, data.get(element) + 1);
        }

        return data.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();

    }


    private String getSimpleNumbersAsString() {
        StringBuilder sb = new StringBuilder();
        for (Integer number : super.data) {
            boolean isSimple = true;
            for (int i = 2; i <= number / 2; i++) {
                if (number % i == 0) {
                    isSimple = false;
                    break;
                }
            }
            if (isSimple) {
                sb.append(number).append(" ");
            }
        }
        return sb.toString().trim().replaceAll("\\s+", ",");
    }


    //5 1 0 6 8
    private String findMaxSequenceOf(String type) {
        List<Integer> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        boolean clear = true;
        int previousNumberIndex = 0;

        for (int i = 0; i <= super.data.size() - 1; i++) {
            int currentNumber = super.data.get(i);

            if (temp.isEmpty()) {
                temp.add(currentNumber);
                continue;
            }
            int previousNumber = temp.get(previousNumberIndex);

            switch (type) {
                case "ascending":
                    if (currentNumber > previousNumber) {
                        temp.add(currentNumber);
                        previousNumberIndex++;
                        clear = false;
                    } else {
                        clear = true;
                    }
                    break;
                case "descending":
                    if (currentNumber < previousNumber) {
                        temp.add(currentNumber);
                        previousNumberIndex++;
                        clear = false;
                    } else {
                        clear = true;
                    }
                    break;
                case "equal":
                    if (currentNumber == previousNumber) {
                        temp.add(currentNumber);
                        previousNumberIndex++;
                        clear = false;
                    } else {
                        clear = true;
                    }
                    break;
            }

            if (temp.size() > result.size()) {
                result = new ArrayList<>(temp);
            }

            if (clear) {
                temp = new ArrayList<>();
                temp.add(currentNumber);
                previousNumberIndex = 0;
            }


        }

        return String.join(",", String.valueOf(result));

    }

    private String findSequenceSumRandom() {

        Random random = new Random();

        int sumOfData = super.data.stream().mapToInt(Integer::intValue).sum();

        int randomNumber = random.nextInt(sumOfData) + 1;
        System.out.printf("Generated number: %d\n", randomNumber);

        List<Integer> temp = new ArrayList<>();

        int currentSum = 0;


        for (int i = 0; i < super.data.size(); i++) {
            for (int j = i; j < super.data.size(); j++) {

                int number = super.data.get(j);

                currentSum += number;

                if (currentSum == randomNumber) {
                    temp.add(number);
                    return String.join(",", String.valueOf(temp));
                }
                if (currentSum < randomNumber) {
                    temp.add(number);

                } else {
                    currentSum = 0;
                    temp.clear();
                    break;
                }
            }
        }
        return null;


    }
}


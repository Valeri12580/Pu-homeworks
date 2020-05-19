package logic;

import data.Menus;
import logic.base.ArrayUtil;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArrayStringUtil extends ArrayUtil<String> {

    public ArrayStringUtil() {
        super();
    }

    @Override
    public void run() {
        this.fill();

        printMenu();

        int choice;

        while ((choice = Integer.parseInt(super.scanner.nextLine())) != 5) {

            System.out.println(executeCommand(choice));
            printMenu();
        }

    }


    @Override
    protected void fill() {
        int i = 0;
        System.out.println("Enter the size:");

        int size = Integer.parseInt(scanner.nextLine());

        while (size > i) {
            System.out.println("Enter word with symbols less than 20");
            String word = scanner.nextLine();

            if (word.length() > 20 || !word.matches("[a-zA-Z]+")) {
                System.out.println("Invalid word!");
                continue;
            }

            this.data.add(word);
            i++;
        }

    }


    @Override
    protected void printMenu() {
        System.out.println(Menus.ARRAY_STRING_UTIL_MENU);
    }

    @Override
    protected String executeCommand(int number) {
        String message = "";
        switch (number) {
            case 1:
                message = this.reverseWordsInArr();
                break;

            case 2:
                message = this.repeatingSymbolsInWord();
                break;

            case 3:
                message = this.getSymbolsForEachWord();
                break;

            case 4:
                message = this.findRepeatingWords();
                break;
            case 5:
            default:

        }
        return message;
    }


    private String getSymbolsForEachWord() {
        StringBuilder sb = new StringBuilder();

        for (String word : super.data) {
            sb.append(String.format("%s ->%d%n", word, word.length()));
        }

        return sb.toString().trim();
    }


    private String findRepeatingWords() {
        Map<String, Integer> data = new HashMap<>();

        for (String element : super.data) {
            element = element.toLowerCase();
            if (!data.containsKey(element)) {
                data.put(element, 0);
            }

            data.put(element, data.get(element) + 1);
        }


        return data.entrySet().stream().map(e -> String.format("%s->%s", e.getKey(), e.getValue())).collect(Collectors.joining("\n"));

    }


    private String reverseWordsInArr() {
        StringBuilder sb = new StringBuilder();

        for (String word : super.data) {
            Stream.of(word.split("")).collect(Collectors.toCollection(ArrayDeque::new)).descendingIterator().forEachRemaining(sb::append);
            sb.append(System.lineSeparator());
        }


        return sb.toString().trim();
    }

    private String repeatingSymbolsInWord() {
        StringBuilder sb = new StringBuilder();

        for (String word : super.data) {

            Map<String, Integer> data = new HashMap<>();

            for (String symbol : word.split("")) {
                symbol = symbol.toLowerCase();
                if (!data.containsKey(symbol)) {
                    data.put(symbol, 0);
                }

                data.put(symbol, data.get(symbol) + 1);
            }
            String result = data.entrySet().stream().map(e -> String.format("%s->%d", e.getKey(), e.getValue())).collect(Collectors.joining(" "));
            sb.append(String.format("%s -> %s%n", word, result));

        }

        return sb.toString();
    }

}

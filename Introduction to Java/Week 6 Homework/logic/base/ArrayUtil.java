package logic.base;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class ArrayUtil<T> {
    protected Scanner scanner;
    protected List<T> data;

    public ArrayUtil() {
        this.scanner = new Scanner(System.in);
        this.data = new ArrayList<>();
    }

    public abstract void run();


    protected abstract void fill();


    protected abstract void printMenu();

    protected abstract String executeCommand(int number);


}

package utils;

import utils.math.ArrayMath;
import utils.printer.Printer;
import utils.search.Search;
import utils.sort.Sort;

import java.util.Random;

public final  class ArrayUtil {

    public static ArrayMath math;
    public static Sort sorter;
    public static Search searcher;
    public static Printer printer;

    //init
    static {
        math=new ArrayMath();
        sorter=new Sort();
        searcher=new Search();
        printer=new Printer();
    }

    //can't be instantiated
    private ArrayUtil() {
    }

    public static void reverseArray(double[]arr){
        for (int i = 0; i < arr.length/2; i++) {
            double temp =arr[i];
            arr[i]=arr[arr.length-1-i];
            arr[arr.length-1-i]=temp;
        }
    }

    public static boolean isSymmetric(double[]arr){
        for (int i = 0; i < arr.length/2; i++) {
            if(arr[i]!=arr[arr.length-1-i]){
                return false;
            }
        }
        return true;
    }

    public static void randomize(double[] array){
        Random random=new Random();
        for (int i = 0; i <array.length ; i++) {
            int randomPosition=random.nextInt(array.length);
            swap(randomPosition,i,array);

        }
    }


    public static void swap(int firstIndex, int secondIndex, double[] arr){
        double temp=arr[firstIndex];
        arr[firstIndex]=arr[secondIndex];
        arr[secondIndex]=temp;
    }

    public static void fillArray(int length,double[]arr){

    }


}

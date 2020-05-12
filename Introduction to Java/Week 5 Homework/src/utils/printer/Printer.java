package utils.printer;

import utils.formatter.Formatter;

public class Printer {


    public  String formatPrint(double[] arr){
        StringBuilder sb=new StringBuilder();
        for (double i : arr) {
            sb.append(Formatter.format(i)).append(" ");
        }

       return sb.toString().trim().replaceAll("\\s+",",");
    }
}

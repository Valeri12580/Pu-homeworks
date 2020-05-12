package utils.math;

public class ArrayMath {

    public  double sum(double[] arr) {
        double result = 0;
        for (double i : arr) {
            result += i;
        }
        return result;

    }


    public  double findMax(double[] arr) {
        double max = Double.MIN_VALUE;
        for (double i : arr) {
            if (i > max) {
                max = i;
            }
        }

        return max;
    }

    public  double findMin(double[] arr) {
        double min = Double.MAX_VALUE;
        for (double i : arr) {
            if (i < min) {
                min = i;
            }
        }

        return min;
    }

    public  double findAvg(double[] arr) {
        return sum(arr) / arr.length;

    }
}

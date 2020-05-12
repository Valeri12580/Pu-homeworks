package utils.sort;

import utils.ArrayUtil;

//ascending sort
public final class QuickSort {

    public void sort(double[] arr, int start, int end) {
        if (start < end) {
            int pivotIndex = partition(arr, start, end);
            sort(arr, start, pivotIndex - 1);
            sort(arr, pivotIndex + 1, end);
        }
    }


    private int partition(double[] arr, int start, int end) {
        int pivotIndex = start;
        double pivot = arr[end];
        for (int i = start; i < end; i++) {
            if (arr[i] <= pivot) {
                ArrayUtil.swap(i, pivotIndex, arr);
                pivotIndex++;

            }

        }
        ArrayUtil.swap(pivotIndex, end, arr);
        return pivotIndex;

    }

}

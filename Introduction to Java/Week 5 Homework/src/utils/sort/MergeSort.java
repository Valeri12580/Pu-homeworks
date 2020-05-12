package utils.sort;

//descending
public final class MergeSort {

    public void sort(double[] originalArray) {

        int originalArrayLength = originalArray.length;

        if (originalArrayLength <= 1) {
            return;
        }
        int middle = originalArrayLength / 2;

        double[] leftArray = new double[middle];
        double[] rightArray = new double[originalArrayLength - middle];

        for (int i = 0; i < middle; i++) {
            leftArray[i] = originalArray[i];

        }
        for (int i = middle; i < originalArrayLength; i++) {
            rightArray[i - middle] = originalArray[i];
        }
        sort(leftArray);
        sort(rightArray);
        merge(originalArray, leftArray, rightArray);
    }

    private void merge(double[] originalArray, double[] leftArray, double[] rightArray) {
        int leftArrayIndex = 0;
        int rightArrayIndex = 0;
        int originalArrayIndex = 0;

        while (leftArrayIndex < leftArray.length && rightArrayIndex < rightArray.length) {
            if (leftArray[leftArrayIndex] > rightArray[rightArrayIndex]) {
                originalArray[originalArrayIndex] = leftArray[leftArrayIndex];
                leftArrayIndex++;
            } else {
                originalArray[originalArrayIndex] = rightArray[rightArrayIndex];
                rightArrayIndex++;
            }
            originalArrayIndex++;
        }

        while (leftArrayIndex < leftArray.length) {
            originalArray[originalArrayIndex] = leftArray[leftArrayIndex];
            leftArrayIndex++;
            originalArrayIndex++;
        }
        while (rightArrayIndex < rightArray.length) {
            originalArray[originalArrayIndex] = rightArray[rightArrayIndex];
            rightArrayIndex++;
            originalArrayIndex++;
        }

    }
}

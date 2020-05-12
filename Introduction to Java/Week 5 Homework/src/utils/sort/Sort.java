package utils.sort;

public final class Sort {
    private QuickSort ascending;
    private MergeSort descending;

    public Sort() {
        this.ascending = new QuickSort();
        this.descending = new MergeSort();
    }

    public void sort(String type, double[] numbers) {
        if (type.equals("ascending")) {
             ascending.sort(numbers,0,numbers.length-1);
        }else{
            descending.sort(numbers);
        }
    }


}

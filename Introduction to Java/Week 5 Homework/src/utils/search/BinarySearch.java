package utils.search;

public class BinarySearch {
    public  int search(double number, int start, int end, double[] arr){
        if(end>=start){
            int mid =(start+end)/2;

            if(arr[mid]==number){
                return mid;
            }

            if(arr[mid]>number){
                return  search(number, start, mid-1, arr);

            }
            return search(number, mid+1, end, arr);


        }
        else{
            return -1;
        }

    }
}

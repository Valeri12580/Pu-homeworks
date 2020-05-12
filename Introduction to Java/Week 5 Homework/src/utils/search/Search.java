package utils.search;

import utils.ArrayUtil;

public final class Search {
    private  BinarySearch binarySearch;

    public Search() {
        this.binarySearch = new BinarySearch();
    }




    /*
    направих го така,защото в бъдеще могат лесно да се добавят други типове търсения
    няма как да намерим число с binary search без да сортираме,затова сортирам масива..
     */
    public int search(String type,double number,double[]arr){
        if(type.equals("binary")){
            System.out.println("The array will be sorted in  ascending order to work properly..");
            ArrayUtil.sorter.sort("ascending",arr);
            return binarySearch.search(number, 0, arr.length-1, arr);
        }
        return -1;
    }
}

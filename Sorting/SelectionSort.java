package Sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {13,46,24,52,20};
        System.out.print(Arrays.toString(selection(arr)));
        System.out.println(" Finally");
    }
    public static int[] selection(int [] arr){
        for(int i = 0 ; i < arr.length-1 ; i++){
            int min = Integer.MAX_VALUE;
            int x = 0;
            for(int j = i+1 ; j < arr.length ;j++){
                min = Math.min(arr[j],min);
                x = j;
            }
            System.out.print(Arrays.toString(arr));
            System.out.println(" Step : "+(i+1));
            int temp = arr[i];
            arr[i] = arr[x] ;
            arr[x] = temp;
        }
        return arr;
    }
}

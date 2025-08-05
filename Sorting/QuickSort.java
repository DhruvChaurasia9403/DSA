package Sorting;

import java.util.*;


public class QuickSort {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,4,3,6,2,5,7};
        sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    public static void sort(int []nums , int low , int hi){
        if(low>=hi){
            return;
        }
        int s = low;
        int e = hi;
        int m = (s+e)/2;
        int pivot = nums[m];
        while (s<=e){
            while(nums[s]<pivot){
                s++;
            }
            while(nums[e]>pivot){
                e--;
            }
            if(s<=e){
                int temp = nums[s];
                nums[s]=nums[e];
                nums[e]=temp;
                s++;
                e--;
            }
        }
        sort(nums,low,e);
        sort(nums,s,hi);
    }
}

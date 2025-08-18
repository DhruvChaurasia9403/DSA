package Arrays;
//https://leetcode.com/problems/subarray-sum-equals-k/
import java.util.*;
public class SubarraySum {
    public static void main(String[] args) {

    }


    //this is a brute force but will not work on many of the test cases
    public static int ss(int[] nums , int k){
        int r = 0, l = 0;
        int count = 0;
        while(r < nums.length){
            int sum = 0;
            while(r<nums.length && sum<= k){
                sum+=nums[r];
                r++;
                if(sum == k) count++;
            }
            l++;
            r=l;
        }
        return count;
    }



    //this will work on all the test cases but still not optimised
    public static int ss1(int[] nums , int k){
        int count =0;
        for(int i = 0 ; i < nums.length  ; i++){
            int sum = 0;
            for(int j = i ; j< nums.length ;j++){
                sum+=nums[j];
                if(sum==k) count++;
            }
        }
        return count;
    }



    public static int ss2(int[] nums, int k){

    }
}

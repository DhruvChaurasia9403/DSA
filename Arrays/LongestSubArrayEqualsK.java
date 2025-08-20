package Arrays;

import java.util.*;

public class LongestSubArrayEqualsK {
    public static void main(String[] args) {

    }
    public static int LSubAEK(int[] arr , int k){
        //the Approach we are gonna be using is prefix sum which is a most optimal approach and brute force approach
        //will be to find all the sub arrays and then find the subarrays whos sum == k and then store the longest one
        int max=0;
        int[] p = new int[arr.length];
        Map<Integer,Integer> mp = new HashMap<>();
        p[0]=arr[0];
        for(int i = 1 ; i < arr.length ; i++){
            p[i] = p[i-1]+arr[i];
            if(!mp.containsKey(p[i])){
                mp.put(p[i],i);
            }
        }
        for(int i = 0 ;i< arr.length ; i++){
            if(p[i]==k) max = Math.max(max,i+1);
            int val = p[i]-k;
            if(mp.containsKey(val)){
                max = Math.max(max,i-mp.get(val));
            }
        }
        return max;
    }
}

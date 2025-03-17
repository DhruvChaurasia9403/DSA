package DynamicProgramming.knapsack01;

import java.util.*;

public class subsetSumDifferenceEquaalsTarget {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3};
        int diff = 1;
        int ts = 0 ;
        for(int x : arr){
            ts+=x;
        }
        int totalSum = ts;
        ts = ts/2;
        Map<Integer,Integer> qualifiers = new HashMap<>();
        for(int i = 0 ; i <= ts ; i++){
            if(subsetSum(arr , i , arr.length)){
                qualifiers.put(i,subsetSumCount(arr,i,arr.length));
            }
        }
        int count =0;
        for(Map.Entry<Integer,Integer> entry : qualifiers.entrySet()){
            int s1 = entry.getKey();
            if(totalSum - 2 * s1 == diff) {
                count += entry.getValue();
            }
        }
        System.out.println(count);
    }


    public static int subsetSumCount(int [] arr , int sum , int n){
        if(sum == 0) return 1;
        if(n==0) return 0;
        if(arr[n-1]>sum) return subsetSumCount(arr,sum,n-1);
        else return subsetSumCount(arr,sum-arr[n-1],n-1)+subsetSumCount(arr,sum ,n-1);
    }
    public static boolean subsetSum(int [] arr , int sum , int n){
        if(sum == 0) return true;
        if(n==0) return false;
        if(arr[n-1]>sum) return subsetSum(arr,sum,n-1);
        else return subsetSum(arr,sum-arr[n-1],n-1)||subsetSum(arr,sum ,n-1);
    }
}

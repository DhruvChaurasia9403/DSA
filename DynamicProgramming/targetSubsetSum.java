package DynamicProgramming;

import java.util.Arrays;

public class targetSubsetSum {
    // we have to return the number of subsets having sum equal to the target sum.
    public static void main(String[] args) {
        int[]arr = {2,3,5,8,10};
        int sum= 10;
        int n = arr.length;
        int [][] dp = new int[n+1][sum+1];
        for(int[] a : dp ){
            Arrays.fill(a,-1);
        }
        System.out.println(subsetSum(arr,sum,n));
//        System.out.println(memoSubsetSum(arr,dp,sum,n));
//        System.out.println(dpSubsetSum(arr,dp,sum,n));
    }
    public static int subsetSum(int []arr , int sum , int n ){
        if(sum == 0 ) return 1;
        if(n==0) return 0;
        if(arr[n-1]>sum)return subsetSum(arr,sum,n-1);
        else return subsetSum(arr,sum-arr[n-1] , n-1 )+subsetSum(arr,sum,n-1);
    }
    public static int memoSubsetSum(int []arr , int[][]dp , int sum , int n){
        if(sum==0) return 1;
        if(n==0) return 0;
        if(dp[n][sum]!=-1) return  dp[n][sum];
        if(arr[n-1]>sum) return dp[n][sum] = memoSubsetSum(arr,dp,sum,n-1);
        else return dp[n][sum] = memoSubsetSum(arr,dp,sum-arr[n-1],n-1) + memoSubsetSum(arr,dp,sum,n-1);
    }
    public static int dpSubsetSum(int[] arr, int [][] dp , int sum , int n){
        for(int i =0; i <= n ; i++){
            for(int j =0 ; j <= sum ; j ++){
                if(j==0) dp[i][j] = 1;
                else dp[i][j] = 0;
            }
        }
        for(int i= 1 ; i <= n ; i++){
            for(int j = 1 ; j <= sum ; j++){
                if(arr[i-1]>j){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j-arr[i-1]]+dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }
}

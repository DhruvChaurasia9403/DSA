package DynamicProgramming.knapsack01;

import java.util.Arrays;

public class Knapsack01 {
    public static void main(String[] args) {
        int[] wt  = {1,3,4,5};
        int[] val = {2,4,5,7};
        int n = val.length;
        int k = 7;
        int[][] dp = new int[val.length+1][k+1];
        for(int [] row : dp){
            Arrays.fill(row,-1);
        }
        System.out.println(topDownKnapsack(wt,val,dp,k,n));


//        System.out.println(memoKnapsack(wt,val,dp,k,n));

//        System.out.println(knapsack(wt,val,7,n));
    }
    public static int knapsack(int[] wt, int[] val, int k, int n){
        if(n==0||k==0){
            return 0;
        }
        // excluding the val as the weight of the item is greater than the knapsack
        if(wt[n-1]>k){
            return knapsack(wt,val,k,n-1);
        }
        else{
            return Math.max(val[n-1]+knapsack(wt,val,k-wt[n-1],n-1),knapsack(wt,val,k,n-1));
        }
    }

//memoization
    public static int memoKnapsack(int[] wt , int[] val , int[][] dp ,int k , int n){
        if(n==0||k==0) return 0;
        if(!(dp[n][k] ==-1)) return dp[n][k];
        if(wt[n-1]>k) return dp[n][k]=memoKnapsack(wt,val,dp,k,n-1);
        else{
            return dp[n][k] = Math.max(val[n-1]+memoKnapsack(wt,val,dp,k-wt[n-1],n-1),memoKnapsack(wt,val,dp,k,n-1));
        }
    }


// Top-down approach
    public static int topDownKnapsack(int[] wt , int[] val , int[][]dp , int k , int n){
        for(int i = 0 ; i<=n;i++){
            for(int j =0 ; j <= k ; j++){
                if(i==0||j==0) dp[i][j]=0;
            }
        }
        for(int i = 1 ; i<=n;i++){
            for(int j = 1 ; j <= k ; j++){
                if(wt[i-1]>j){
                    dp[i][j]=dp[i-1][j];
                }
                else{
                    dp[i][j] = Math.max(val[i-1]+dp[i-1][j-wt[i-1]],dp[i-1][j]);
                }
            }
        }
        return dp[n][k];
    }
}

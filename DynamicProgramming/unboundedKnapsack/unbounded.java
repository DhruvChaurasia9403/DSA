package DynamicProgramming.unboundedKnapsack;

import java.util.Arrays;

public class unbounded {
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
    }
    public static int knapsack(int[] val , int[] wt , int w , int n){
        if(n==0||w==0) return 0;
        if(wt[n-1] > w) return knapsack(val,wt,w,n-1);
        // Just this line of code is changed form the 01 knapsack the whole code is same
        else return Math.max(val[n-1] + knapsack(val,wt,w-wt[n-1],n) , knapsack(val,wt,w,n-1));
    }
    public static int memoKnapsack(int[] val , int[] wt , int w , int n , int[][]dp){
        if(n==0||w==0) return dp[n][w]= 0;
        if(wt[n-1] > w) return dp[n][w] = knapsack(val,wt,w,n-1);
        if(dp[n][w]!=-1) return dp[n][w];
            // Just this line of code is changed form the 01 knapsack the whole code is same
        else return dp[n][w] = Math.max(val[n-1] + knapsack(val,wt,w-wt[n-1],n) , knapsack(val,wt,w,n-1));
    }
    public static int topDownKnapsack(int[] wt , int[] val , int[][]dp , int w , int n){
        for(int i = 0 ; i<=n;i++){
            for(int j =0 ; j <= w ; j++){
                if(i==0||j==0) dp[i][j]=0;
            }
        }
        for(int i = 1 ; i<=n;i++){
            for(int j = 1 ; j <= w ; j++){
                if(wt[i-1]>j){
                    dp[i][j]=dp[i-1][j];
                }
                else{
                    dp[i][j] = Math.max(val[i-1]+dp[i-1][j-wt[i-1]],dp[i-1][j]);
                }
            }
        }
        return dp[n][w];
    }
}

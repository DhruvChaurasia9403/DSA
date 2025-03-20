package DynamicProgramming.knapsack01.unboundedKnapsack;

public class coinChange1 {
    //leetcode coin change
    public static void main(String[] args) {
        int[] coins = {1,2,3};
        int amount =5;
        int [][] dp = new int[coins.length+1][amount+1];
        System.out.println(coin(coins,amount,coins.length,dp));
    }
    public static int coin(int[] coins,int amount , int n , int dp[][]){
        for(int i = 0; i <= n ; i++){
            for(int j = 0 ; j <= amount ; j++){
                if(i==0) dp[i][j] = Integer.MAX_VALUE -1;
                else if(j==0) dp[i][j] = 0;
            }
        }
        for(int i = 1; i<= n ; i++){
            for(int j = 1 ; j <= amount ; j++){
                if(coins[i-1]>j) dp[i][j] = dp[i-1][j];
                else dp[i][j] = Math.min(1+dp[i][j-coins[i-1]],dp[i-1][j]);
            }
        }
        return dp[n][amount] == Integer.MAX_VALUE-1 ? -1 : dp[n][amount];
    }
}

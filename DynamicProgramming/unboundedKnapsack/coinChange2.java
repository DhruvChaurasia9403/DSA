package DynamicProgramming.unboundedKnapsack;

public class coinChange2 {
    public static void main(String[] args) {
        int[] coins = {1,2,3};
        int sum =5;
        System.out.println(coin(coins,sum,coins.length));
    }
    public static int coin(int[] coins , int sum , int n){
        if(sum==0) return 1;
        if(n==0) return 0;
        if(coins[n-1]>sum) return coin(coins,sum,n-1);
        else return coin(coins,sum,n-1)+coin(coins,sum-coins[n-1],n);
    }
}

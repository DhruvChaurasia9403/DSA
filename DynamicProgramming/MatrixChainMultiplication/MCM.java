package DynamicProgramming.MatrixChainMultiplication;
import java.util.*;
public class MCM {
    public static void main(String[] args) {
        int []arr = {40 , 20 , 30, 10, 30};
        int dp[][] = new int[arr.length][arr.length];
        for(int[] a : dp){
            Arrays.fill(a,-1);
        }
        int ans =solveMemo(arr,1,arr.length-1,dp);
        System.out.println(ans==Integer.MAX_VALUE?0:ans);
    }
    public static int solve(int arr[] , int i , int j){
        if(i>=j) return 0;
        int min = Integer.MAX_VALUE;
        for(int k = i ; k < j ; k++){
            int temp = solve(arr,i,k) + solve(arr,k+1,j)+arr[i-1]*arr[k]*arr[j];
            min=Math.min(min,temp);
        }
        return min;
    }
    public static int solveMemo(int arr[] , int i , int j , int[][] dp){
        if(i>=j) return 0;
        if(dp[i][j] !=-1) return dp[i][j];
        int min = Integer.MAX_VALUE;
        for(int k = i ; k< j ; k++){
            int l = solveMemo(arr,i,k,dp);
            int r = solveMemo(arr,k+1,j,dp);
            int cost = l+r+arr[i-1]*arr[k]*arr[j];
            min = Math.min(min,cost);
        }
        return dp[i][j] = min;
    }
}

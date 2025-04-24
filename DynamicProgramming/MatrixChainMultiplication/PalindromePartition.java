package DynamicProgramming.MatrixChainMultiplication;
import java.util.*;
public class PalindromePartition {
    public static void main(String[] args) {
        String s = "itins";
        int[][] dp = new int[s.length()][s.length()];
        for(int[] a : dp){
            Arrays.fill(a,-1);
        }
        int ans = solve(s,0,s.length()-1,dp);
        System.out.println(ans==Integer.MAX_VALUE ? 0 : ans);;
    }
    //this is memoized code but still this can be improved only 1010/1111 test cases passed
    static int solve(String s , int i , int j,int[][] dp ){
        if(i>j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(isPalindrome(s,i,j)) return 0;
        int min = Integer.MAX_VALUE;
        for(int k = i ; k<j ; k++){
            int l = dp[i][k] != -1 ?dp[i][k] : solve(s,i,k,dp);
            int r = dp[k+1][j] != -1 ?  dp[k+1][j] : solve(s,k+1,j,dp);
            dp[i][k] = l;
            dp[k+1][j] = r;
            int parts = l+r+1;
            min = Math.min(parts,min);
        }
        return dp[i][j] = min;
    }
    public static int partition(String s , int i, int j){
        if(i>j) return 0;
        if(isPalindrome(s,i,j)) return 0;
        int min = Integer.MAX_VALUE;
        for(int k = i ; k< j ; k++){
            int l = partition(s,i,k);
            int r = partition(s,k+1,j);
            int parts = l+r+1;
            min = Math.min(min,parts);
        }
        return min;
    }
    public static boolean isPalindrome(String s , int i , int j){
        if(i>j) return true;
        if(s.charAt(i) != s.charAt(j)) return false;
        return isPalindrome(s,i+1,j-1);
    }
}

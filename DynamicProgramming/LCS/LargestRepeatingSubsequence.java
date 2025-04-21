package DynamicProgramming.LCS;

public class LargestRepeatingSubsequence {
    public static void main(String[] args) {
        String a = "AABEBCDD";
        System.out.println(LRS(a));
    }
    public static int LRS(String a ){
        int n = a.length();
        String b = a;
        int dp[][] = new int[n+1][n+1];
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j<= n ; j++){
                if(a.charAt(i-1) == b.charAt(j-1)) dp[i][j]=dp[i-1][j-1]+1;
                else dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
            }
        }
        return dp[n][n];
    }
}

package DynamicProgramming.LCS;

public class LongestCommonSubstring {
    public static void main(String[] args) {
        String a = "abcde";
        String b = "abfce";
        lcs(a,b);
    }
    public static int lcs(String a , String b){
        int n = a.length();
        int m = b.length();
        int max = Integer.MIN_VALUE;
        int[][] dp = new int[n+1][m+1];
        for(int i = 0 ; i <= n ; i++){
            for(int j = 0 ; j <= m ; j++){
                if(i==0||j==0) dp[i][j] = 0;
            }
        }
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= m ; j++){
                if(a.charAt(i-1)==b.charAt(j-1)) {
                    dp[i][j] = 1+dp[i-1][j-1];
                    max = Math.max(max,dp[i][j]);
                }
                else{
                    dp[i][j] = 0;
                }
            }
        }
        return max == Integer.MIN_VALUE ? 0 : max;
    }
}

package DynamicProgramming.LCS;

public class ShortestSuperSequence {
    public static void main(String[] args) {
        String a = "aggtab";
        String b = "gxtkayb";
        int n = a.length();
        int m = b.length();
        int[][] dp = new int[n+1][m+1];
        int ss = m+n-sss(a,b,dp);
        System.out.println(ss);
    }
    public static int sss(String a , String b , int[][] dp){
        for(int i = 0 ; i<=a.length()  ; i++){
            for(int j = 0 ; j<=b.length() ; j++){
                if(i==0||j==0) dp[i][j] = 0;
            }
        }
        for(int i = 1 ; i<= a.length() ; i++){
            for(int j = 1 ; j<=b.length() ; j++){
                if(a.charAt(i-1) == b.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
                }
            }
        }
        return dp[a.length()][b.length()];
    }
}

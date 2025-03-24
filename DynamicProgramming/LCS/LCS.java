package DynamicProgramming.LCS;
public class LCS {
    public static void main(String[] args) {
        String x = "absdefgh";
        String y = "akjhdfkgh";
        System.out.println(lcs(x,y,x.length(),y.length()));
    }
    public static int lcs(String x , String y , int n , int m){
        if(n==0||m==0) return 0;
        if(y.charAt(m-1) == x.charAt(n-1)) {
            return 1 + lcs(x,y,n-1,m-1);
        } else return Math.max(lcs(x,y,n-1,m),lcs(x,y,n,m-1));
    }
    //top-down approach
    public static int dpLCS(String x , String y, int n , int m , int[][] dp){
        for(int i = 0 ; i <= n ; i++){
            for(int j = 0 ; j <= m ; j++){
                if(i==0||j==0){
                    dp[i][j]=0;
                }
            }
        }
        for(int i =1 ; i <= n ; i++){
            for(int j = 1 ; j <= m ; j++){
                if(x.charAt(i-1) == y.charAt(j-1)) dp[i][j] = 1+dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
            }
        } return dp[n][m];
    }
}
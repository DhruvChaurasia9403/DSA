package DynamicProgramming.LCS;

public class printLCS {
    public static void main(String[] args) {
        String x = "absdefgh";
        String y = "akjhdfkgh";
        int n = x.length();
        int m = y.length();
        int[][] dp = new int[n+1][m+1];
        System.out.println(printlcs(x,y,x.length(),y.length(),dp));
    }
    public static String printlcs(String a , String b , int n , int m , int[][] dp){
        for(int i = 0 ; i <= n ; i++){
            for(int j = 0 ; j <= m ; j++){
                if(i==0||j==0) dp[i][j] = 0;
            }
        }
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j<= m ; j++){
                if(a.charAt(i-1)==b.charAt(j-1)) dp[i][j] = 1 + dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        int i = n , j = m;
        StringBuilder x = new StringBuilder();
        while(i>0&&j>0){
            if(a.charAt(i-1) == b.charAt(j-1)){
                x = x.append(a.charAt(i-1));
                i--;
                j--;
            }
            else {
                if(dp[i-1][j] > dp[i][j-1]) {
                    i--;
                } else {
                    j--;
                }
            }
        }
        return x.reverse().toString();
    }
}

package unboundedKnapsack;

public class rodCutting {
    public static void main(String[] args) {

    }
    public static int dpCut(int [] price , int[] length , int[][] dp , int n , int rod){
        for(int i = 0; i <= n ; i++){
            for(int j = 0 ; j <= rod ; j++){
                if(n==0||rod==0) dp[i][j] = 0;
            }
        }
        for(int i = 1; i <= n ; i ++ ){
            for(int j = 1 ; j <= rod ; j++){
                if(length[i-1] > j) dp[i][j] = dp[i-1][j];
                else dp[i][j] = Math.max(price[i-1]+dp[i][j-length[i-1]],dp[i-1][j]);
            }
        }
        return dp[n][rod];
    }
}

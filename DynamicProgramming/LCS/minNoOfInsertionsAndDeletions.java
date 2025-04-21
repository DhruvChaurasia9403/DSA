package DynamicProgramming.LCS;

public class minNoOfInsertionsAndDeletions {
    public static void main(String[] args) {
        System.out.println(minDistance("heap","pea"));
    }
    public static int minDistance(String word1, String word2) {
        if(word1==word2) return 0;
        int a = word1.length();
        int b = word2.length();
        int deletions = a-lcs(word1,word2);
        int insertions = b-lcs(word1,word2);
        return deletions+insertions;
    }
    public static int lcs(String a , String b){
        int n = a.length();
        int m = b.length();
        int dp[][] = new int[n+1][m+1];
        for(int i = 0 ; i <= n ; i++){
            for(int j = 0 ; j <= m ; j++){
                if(i==0||j==0) dp[i][j] = 0 ;
            }
        }
        for(int i =1 ; i <= n ; i++){
            for(int j = 1 ; j <= m ;j++){
                if(a.charAt(i-1) == b.charAt(j-1))dp[i][j] = 1+dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[n][m];
    }
}

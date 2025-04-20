package DynamicProgramming.LCS;

public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        String a = "agbcba";
        String b = reverse(a);
        System.out.println(lcs(a,b));
    }
    public static int lcs(String a , String b){
        int n = a.length();
        int m = b.length();
        int dp[][] = new int[n+1][m+1];
        for(int i  = 0; i <= n ; i++){
            for(int j = 0 ; j <=m ;j ++){
                if(i==0 || j==0)dp[i][j] = 0;
            }
        }
        for(int i =1 ; i <= n ; i++){
            for(int j = 1 ; j<= m ; j++){
                if(a.charAt(i-1) == b.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
    public static String reverse(String a){
        char[] ch = a.toCharArray();
        int l = 0 , r = ch.length-1;
        while(l<r){
            char temp = ch[l];
            ch[l] = ch[r];
            ch[r] = temp;
            l++;
            r--;
        }
        return new String(ch);
    }
}

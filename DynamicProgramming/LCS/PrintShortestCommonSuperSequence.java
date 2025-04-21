package DynamicProgramming.LCS;

public class PrintShortestCommonSuperSequence {
    public static void main(String[] args) {
        String a = "aebcf";
        String b = "abcdaf";
        System.out.println(printWithLCS(a,b));
    }
    public static String printWithLCS(String a , String b){
        int n = a.length();
        int m = b.length();
        int[][] dp = new int[n+1][m+1];
        for(int i = 0 ; i <= n ; i++){
            for(int j = 0 ; j <= m ; j++){
                if(i==0 || j==0){
                    dp[i][j] = 0;
                }
            }
        }
        for(int i = 1 ; i <= n ; i++){
            for (int j = 1; j <= m  ; j++) {
                if(a.charAt(i-1) == b.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
                }
            }
        }
        StringBuilder x = new StringBuilder();
        int i = dp.length - 1 , j = dp[0].length-1;
        while(i>0&&j>0){
            if(a.charAt(i-1) == b.charAt(j-1)){
                x.append(a.charAt(i-1));
                i--;
                j--;
            }
            else{
                if(dp[i-1][j] > dp[i][j-1]){
                    x.append(a.charAt((i-1)));
                    i--;
                }
                else{
                    x.append( b.charAt(j-1));
                    j--;
                }
            }
        }
        return x.reverse().toString();
    }
}

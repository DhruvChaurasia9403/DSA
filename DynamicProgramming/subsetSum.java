package DynamicProgramming;

public class subsetSum {
    public static void main(String[] args) {
        int arr[] = {2,3,7,8,10};
        int target_sum = 11;
        int n = arr.length;
        boolean dp[][] = new boolean [n+1][target_sum+1];
        for(int i = 0 ; i <= n ; i++){
            for(int j = 0 ; j <= target_sum ; j++){
                dp[i][j] = false;
            }
        }
        System.out.println(dpSubsetSum(arr,dp,target_sum,arr.length));
    }

    //only Recursion
    public static boolean subsetSum(int[] arr , int sum , int n){
        if(sum==0) return true;
        if(n==0) return false;
        if(arr[n-1]>sum) return subsetSum(arr,sum , n-1);
        else return subsetSum(arr,sum-arr[n-1],n-1)||subsetSum(arr,sum,n-1);
    }
    //Recursion + dp
    public static boolean memoSubsetSum(int arr[] , boolean [][]dp , int sum , int n){
        if(sum == 0 ) return dp[n][sum] = true;
        if(n==0) return dp[n][sum] = false;
        if(dp[n][sum]) return dp[n][sum];
        if(arr[n-1]>sum) return dp[n][sum] = memoSubsetSum(arr , dp , sum , n-1);
        else return dp[n][sum] = memoSubsetSum(arr, dp , sum - arr[n-1] , n-1)||memoSubsetSum(arr,dp , sum , n-1);
    }
    //only dp
    public static boolean dpSubsetSum(int arr[] , boolean[][] dp , int sum , int n){
        for(int i = 0 ; i <= n ; i++){
            for(int j = 0 ;  j <= sum ; j++){
                if(j==0) dp[i][j] = true;
                else dp[i][j] = false;
            }
        }
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ;  j <= sum ; j++){
                if(j<arr[i-1]) dp[i][j] = dp[i-1][j];
                else dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
            }
        }
        return dp[n][sum];
    }
}

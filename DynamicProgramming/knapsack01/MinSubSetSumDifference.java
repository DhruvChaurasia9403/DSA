package DynamicProgramming.knapsack01;
import java.util.*;

public class MinSubSetSumDifference {
    public static void main(String[] args) {
        int[] arr = {1, 2, 7};
        int ts = 0 ;
        for(int x : arr){
            ts+=x; // ts = 10
        }
        int totalSum = ts; // Store original sum
        ts = ts/2; // ts = 10 ====> ts = 5
        List<Integer> qualifiers = new ArrayList<>();
        for(int i = 0 ; i <= ts ; i++){ // i ==> 0 - ts  i.e      i=0 to i=5
            if(subsetSum(arr , i , arr.length)){ // qualifiers => 0+ 1+ 2+ 3+      not qualifies => 4- 5-
                qualifiers.add(i); // qualifiers = [0, 1, 2, 3]
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i < qualifiers.size() ; i++){
            int s1 = qualifiers.get(i); // s1 = 0 , 1 , 2 , 3
            min = Math.min(min , Math.abs(totalSum - 2 * s1)); // min = {10 - 0 , 10 - 2*1 , 10 - 2*2 , 10 - 2*3} i.e. min = 10-2*3 = 4
        }
        System.out.println(min); // prints 4
    }

    public static boolean subsetSum(int [] arr , int sum , int n){
        if(sum == 0) return true;
        if(n==0) return false;
        if(arr[n-1]>sum) return subsetSum(arr,sum,n-1);
        else{
            return subsetSum(arr,sum-arr[n-1],n-1)||subsetSum(arr,sum ,n-1);
        }
    }

    public static boolean memoSubsetSum(int [] arr , int sum , int n , boolean [][]dp){
        if(n==0) return dp[n][sum] = false;
        if(sum == 0 ) return dp[n][sum] = true;
        if(dp[n][sum]) return dp[n][sum];
        if(arr[n-1]>sum) return dp[n][sum] = memoSubsetSum(arr,sum,n-1,dp);
        else{
            return dp[n][sum] = memoSubsetSum(arr,sum-arr[n-1],n-1,dp)||memoSubsetSum(arr,sum ,n-1,dp);
        }
    }


    public static boolean dpSubsetSum(int [] arr , int sum , int n , boolean [][]dp){
        for(int i = 0 ; i <= n ; i++){
            for(int j = 0 ; j <= sum ; j++){
                if(sum == 0 ) dp[i][j] = true;
                else dp[i][j] = false;
            }
        }
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= sum ; j++){
                if(arr[i-1]>j) dp[i][j] = dp[i-1][j];
                else{
                    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }
}

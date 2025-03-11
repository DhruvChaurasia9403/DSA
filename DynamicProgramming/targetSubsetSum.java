package DynamicProgramming;

public class targetSubsetSum {
    // we have to return the number of subsets having sum equal to the target sum.
    public static void main(String[] args) {
        int[]arr = {2,3,5,8,10};
        int sum= 10;
        System.out.println(subsetSum(arr,sum,arr.length));
    }
    public static int subsetSum(int [
            ]arr , int sum , int n ){
        if(n==0) {
            if(sum == 0 ) return 1;
            else return 0;
        }

        if(arr[n-1]>sum){
            return subsetSum(arr,sum,n-1);
        }
        else{
            return subsetSum(arr,sum-arr[n-1] , n-1 )+subsetSum(arr,sum,n-1);
        }
    }
}

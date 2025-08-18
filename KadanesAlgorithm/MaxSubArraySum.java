package KadanesAlgorithm;
//love babbar
public class MaxSubArraySum {
    public static void main(String[] args) {
        int[] arr = {1,2,4,5,3,-3,-3,2,2};
        System.out.println(sum(arr));
    }
    public static int sum(int arr[]){
        int sum = 0 , max = Integer.MIN_VALUE;
        for(int num : arr){
            sum += num;
            max = Math.max(sum,max);
            if(sum<0) sum=0;
        }
        return max;
    }
}

import java.util.*;
public class slidingWindowSubArrayLessThanK{
    public static void main(String[] args) {
        int[] arr = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] nums = swm(arr,k);
        for(int i : nums){
            System.out.println(i);
        }
    }
    public static int[] swm(int[] arr, int k){
        int[] nums = new int[arr.length-k+1];
        int x = 0;
        Deque<Integer> dq = new LinkedList<>();
        for(int i = 0 ; i < k ; i++){
            while(!dq.isEmpty() && arr[dq.peekLast()]<=arr[i]){
                dq.pollLast();
            }
            dq.offerLast(i);
        }
        nums[x++] = arr[dq.peekFirst()];
        for(int i = k ; i < arr.length ; i++){
            while(!dq.isEmpty() && dq.peekFirst()<=i-k){
                dq.pollFirst();
            }
            while(!dq.isEmpty() && arr[dq.peekLast()]<arr[i]){
                dq.pollLast();
            }
            dq.offerLast(i);
            nums[x++] = arr[dq.peekFirst()];
        }
        return nums;
    }
}

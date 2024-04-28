package stacks;
import java.util.*;

public class Pattern132 {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,7,6,5,10};
        System.out.println(pattern(arr));
    }
    public static boolean pattern(int [] nums){
        Stack<Integer> a = new Stack<>();
        int current = Integer.MIN_VALUE;
        for(int i = nums.length -1 ; i>=0 ; i--){
            if(current > nums[i]) return true;
            while(!a.isEmpty()&&a.peek()<nums[i]) {
                current = a.pop();
            }
            a.push(nums[i]);
        }
        return false;
    }
}

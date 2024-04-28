package stacks;
import java.util.*;
public class nextGreatestElement {
    public static void main(String[] args) {
        int [] arr = {1,5,3,2,1,6,3,4};
        greatest(arr);
        System.out.println(Arrays.toString(greatest(arr)));
    }
    public static int[] greatest(int[] arr){
        Stack<Integer> a = new Stack<>();
        int []ret = new int[arr.length];
        for(int i = arr.length-1 ; i>=0 ; i--){
            ret[i] = -1;
            while(!a.isEmpty()&&a.peek()<arr[i]){
                a.pop();
            }
            if (a.isEmpty()) ret[i]=-1;
            else ret[i]=a.peek();
            a.push(arr[i]);
        }
        return ret;
    }
}

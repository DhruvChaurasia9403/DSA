package SlidingWindow;
import java.util.*;
public class LongestSubarrayLessthanEqualsK {
    public static void main(String[] args) {
        int[] arr = {2,5,1,7,10};
        int x = longestSub(arr,14);
        System.out.println(x);
    }
    public static int longestSub(int[] arr,int k){
        int r = 0, l = 0, max = 0,sum=0;
        while(r<arr.length){
            sum+=arr[r];
            while(sum>k){
                sum-= arr[l];
                l++;
            }
            if(sum<=k){
                max = Math.max(max,r-l+1);
            }
            r++;
        }
        return max;
    }
}

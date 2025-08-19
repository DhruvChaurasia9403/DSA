package Arrays;
import java.util.*;

public class SubArrayXorEqualsK {
    public static void main(String[] args) {

    }
    public static int ssk(int[] arr , int k){
        int count = 0;
        int[] p = new int[arr.length];
        p[0] = arr[0];
        for(int i = 0 ; i < arr.length ; i++){
            p[i] = p[i-1]^arr[i];
        }
        Map<Integer,Integer> mp = new HashMap<>();
        for(int i = 0 ; i<arr.length ; i++){
            if(p[i]==k)count++;
            int val = p[i]^k;
            count+=mp.getOrDefault(val,0);
            mp.put(p[i],mp.getOrDefault(p[i],0)+1);
        }
        return count;
    }
}

package Arrays;
import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        int[] arr = {1,5,3,7,8,-9,-2,3,-5,4};
        System.out.println(sum1(arr));
    }
    public static Set<List<Integer>> sum(int[] arr){
        Set<List<Integer>> h = new HashSet<>();
        for(int i = 0 ; i < arr.length ; i++){
            for(int j = i+1 ; j < arr.length ; j++){
                for(int k = j+1 ; k < arr.length ; k++){
                    if(arr[i]+arr[j]+arr[k]==0) {
                        List<Integer> l1 = Arrays.asList(arr[i],arr[j],arr[k]);
                        Collections.sort(l1);
                        h.add(l1);
                    }
                }
            }
        }
        return h;
    }



    public static Set<List<Integer>> sum1(int[] arr){
        Set<List<Integer>> s= new HashSet<>();
        for(int i=0 ; i< arr.length ; i++){
            Set<Integer> s1 = new HashSet<>();
            for(int j = i+1 ; j < arr.length ; j++){
                int x = -(arr[i]+arr[j]);
                if(s1.contains(x)){
                    List<Integer> ls = Arrays.asList(arr[i],arr[j],x);
                    Collections.sort(ls);
                    s.add(ls);
                }
                s1.add(arr[j]);
            }
        }
        return s;
    }


}

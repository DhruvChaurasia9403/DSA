package RecursionRevision;
import java.util.*;

public class duplicateSub {
    public static void main(String[] args) {
        int arr[] = {1,2,2};
        List<List<Integer>> ls = duplicate(arr);
        System.out.println(ls);
    }
    public static List<List<Integer>> duplicate(int []nums){
        Arrays.sort(nums);
        List<List<Integer>> ls = new ArrayList<>();
        ls.add(new ArrayList<>());
        int start = 0;
        int end = 0;
        for(int i = 0 ; i < nums.length ; i++){
            int size = ls.size();
            if(i>0 && nums[i]==nums[i-1]){
                 start = end+1;
            }
            end = ls.size()-1;
            for(int j = start ; j< size ; j++){
                List<Integer> l = new ArrayList<>(ls.get(j));
                l.add(nums[i]);
                ls.add(l);
            }
        }
        return ls;
    }

}

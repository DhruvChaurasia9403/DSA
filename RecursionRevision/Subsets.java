package RecursionRevision;

import java.util.*;

public class Subsets {
    public static void main(String[] args) {

    }
    public static List<List<Integer>> sub(int[] arr){
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        for(int num:arr){
            int n = outer.size();
            for( int i = 0 ; i < n ; i++) {
                List<Integer> inner = new ArrayList<>(outer.get(i));
                inner.add(num);
                outer.add(inner);
            }
        }return outer;
    }
}

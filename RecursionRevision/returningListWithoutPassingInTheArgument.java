package RecursionRevision;
import java.util.*;

public class returningListWithoutPassingInTheArgument {
    public static void main(String[] args) {
        int [] nums = {1,2,4,5,5,5,5,6,7};
        System.out.println(rl(nums,5,0));
    }
    public static List<Integer> rl(int []arr , int target , int index){
        List<Integer> list = new ArrayList<>();
        if(index==arr.length){
            return list;
        }
        List<Integer> listContainingPrevElements = rl(arr,target,index+1);
        if(arr[index]==target){
            list.add(index);
        }
        list.addAll(listContainingPrevElements);
        return list;
    }
}

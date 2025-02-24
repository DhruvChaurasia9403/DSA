package RecursionRevision;
import java.util.*;
public class diceRollingSum {
    public static void main(String[] args) {
        System.out.println(sum("",3));
    }
    public static List<String> sum(String p, int target){
        if(target==0){
            List<String> x = new ArrayList<>();
            x.add(p);
            return x;
        }
        List<String> ls = new ArrayList<>();
        for(int i = 1 ; i<=6 && i<=target ; i++ ){
            ls.addAll(sum(p+String.valueOf(i) , target-i));
        }
        return ls;
    }
}

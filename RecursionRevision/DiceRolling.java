package RecursionRevision;
import java.util.*;

import static RecursionRevision.DiceRolling.rolls;

public class DiceRolling {
    public static void main(String[] args) {
        System.out.println(rollsList("",4));
    }
    public static void rolls(String p , int up){
        if(up==0){
            System.out.println(p);
            return ;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 1 ; i <= 6 && i<=up ; i++ ){
            rolls(p+i, up-i);
        }
    }


    //if list was asked
    public static List<String> rollsList(String p , int up){
        if(up == 0){
            List<String> a = new ArrayList<>();
            a.add(p);
            return a;
        }
        List<String> list = new ArrayList<>();
        for(int i = 1 ; i<= 6 && i<=up ; i++){
            list.addAll(rollsList(p+i,up-i));
        }
        return list;
    }
}

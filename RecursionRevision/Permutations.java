package RecursionRevision;
import javax.xml.transform.Source;
import java.util.*;

import java.util.ArrayList;

public class Permutations {
    public static void main(String[] args) {
        permute("","abc");
    }
    public static void permute(String p , String up){
        if(up.isEmpty()) {
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        for(int i = 0 ; i <= p.length() ; i++){
            String l = p.substring(0,i);
            String r = p.substring(i);
            permute(l+ch+r,up.substring(1));
        }
    }
    public static List<String> permuteList(String p , String up){
        if(up.isEmpty()){
            ArrayList<String> result = new ArrayList<>();
            result.add(p);
            return result;
        }

        List<String> x= new ArrayList<>();
        char ch = up.charAt(0);
        for(int i = 0 ; i <= p.length() ; i++){

            String l = p.substring(0,i);
            String r = p.substring(i);
            x.addAll(permuteList(l+ch+r,up.substring(1)));
        }
        return x;
    }
}

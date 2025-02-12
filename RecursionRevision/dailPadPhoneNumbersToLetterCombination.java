package RecursionRevision;
import java.util.*;

public class dailPadPhoneNumbersToLetterCombination {
    public static void main(String[] args) {
        List<String> a = pad("","23");
        System.out.println(a);
    }
    public static List<String> pad(String p, String up){
        if(up.isEmpty()){
           List<String> a = new ArrayList<>();
           a.add(p);
           return a;
        }
        int digit  = up.charAt(0)-'0'-1;
        List<String> list = new ArrayList<>();
        for(int i = (digit-1)*3;i<digit*3;i++){
            char ch = (char)('a'+i);
            list.addAll(pad(p+ch,up.substring(1)));
        }
        return list;
    }
}

package RecursionRevision;
import java.util.*;

public class subsequence {
    public static void main(String[] args) {
        List<String> p = new ArrayList<>();
        List<List<String>> result = new ArrayList<>();
        subSeqList(p,"123",result);
    }
    public static void subseq(String p , String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        subseq(p+ch,up.substring(1));
        subseq(p,up.substring(1));
    }
    public static void subSeqList(List<String> p, String up, List<List<String>> result) {
        if (up.isEmpty()) {
            result.add(new ArrayList<>(p));
//            System.out.println(p);
//            System.out.println(result);
            return;
        }
        char ch = up.charAt(0);
        List<String> pWithCh = new ArrayList<>(p);
        pWithCh.add(String.valueOf(ch));
        subSeqList(pWithCh, up.substring(1), result);
        subSeqList(p, up.substring(1), result);
    }
}

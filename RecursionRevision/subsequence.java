package RecursionRevision;
import java.util.*;

public class subsequence {
    public static void main(String[] args) {
        List<String> p = new ArrayList<>();
//        List<List<String>> result = new ArrayList<>();
//        subSeqList(p,"123",result);
        System.out.println(subseqIt("abc"));
    }
    // printing the list of subsequence
    public static void subseq(String p , String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        subseq(p+ch,up.substring(1));
        subseq(p,up.substring(1));
    }

    //print the list of list of the subsequence
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
    //return the list of the subsequence
    public static List<String> subSeqList(List<String> p , String up ){
        if(up.isEmpty()) return p;
        char ch = up.charAt(0);
        List<String> newlist = new ArrayList<>(p);
        int size = newlist.size();
        for(int i = 0 ; i  < size; i++){
            newlist.add(newlist.get(i)+ch);
        }
        newlist.add(String.valueOf(ch));

        return subSeqList(newlist,up.substring(1));
    }
    //   Iterative approach for the subsequence
    public static List<List<String>> subseqIt(String up){
        List<List<String>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        for(int i = 0 ; i < up.length() ; i++){
            char ch = up.charAt(i);
            int size = outer.size();
            for(int j = 0 ; j < size ; j++){
                List<String> inner = new ArrayList<>(outer.get(j));
                inner.add(String.valueOf(ch));
                outer.add(inner);
            }
        }
        return outer;
    }

}

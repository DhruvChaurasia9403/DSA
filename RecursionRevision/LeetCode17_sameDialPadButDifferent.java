package RecursionRevision;
import java.util.*;

import java.util.ArrayList;

public class LeetCode17_sameDialPadButDifferent {
    public static void main(String[] args) {

    }
    public static List<String> padList(String p , String up) {
        if (up.isEmpty()) {
            List<String> a = new ArrayList<>();
            a.add(p);
            return a;
        }
        int digit = up.charAt(0) - '0';
        List<String> list = new ArrayList<>();
        String Letters[] = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        String letter = Letters[digit];
        for(int i = 0 ; i < letter.length() ; i++ ){
            char ch= letter.charAt(i);
            list.addAll(padList(p+ch,up.substring(1)));
        }
        return list;
    }
}

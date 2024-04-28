package stacks;
import java.util.*;
public class LongestValidParanthese {
    public static void main(String[] args) {
        String a = "(())(((()))";
        System.out.println(longestValidParentheses(a));

    }
//    public static int parenthese(String s){
//        Stack<Integer> a = new Stack<>();
//        a.push(-1);
//        int max=0;
//        for (int i= 0;  i<s.length() ; i++) {
//            int c = s.charAt(i);
//            if(c=='(') a.push(i);
//            else{
//                a.pop();
//                if(a.isEmpty()) a.push(i);
//                else max = Math.max(max,i-a.peek());
//            }
//        }
//        return max;
//    }
    public static int longestValidParentheses(String s) {
        if(s.length()==0){
            return 0;
        }
        int count=0;
        Stack<Integer> a = new Stack<>();
        a.push(-1);
        for(int i = 0 ; i< s.length() ; i++){
            if(s.charAt(i)=='(') a.push(i);
            else{
                a.pop();
                if(a.isEmpty()){
                    a.push(i);
                }
                else{
                    count = Math.max(count,i-a.peek());
                }
            }
        }
        return count;
    }
}

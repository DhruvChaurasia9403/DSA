package stacks;

import java.util.*;
public class balancedBrackets {
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        String ch = a.nextLine();
        System.out.println(balanced(ch));
    }
    public static boolean balanced(String c){
        Stack<Character> st = new Stack<>();
        for ( int i = 0 ; i<c.length() ; i++){
            char a = c.charAt(i);
            if(a=='('){
                st.push(a);
            }
            else{
                if(st.isEmpty()==true) return false;
                if(st.peek()=='(') st.pop();
            }
        }
        return st.isEmpty();
    }
}

package stacks;
import java.util.*;

public class postfixEvaluation {
    public static void main(String[] args) {
        String a = "243844*/+9**/";
        Stack<Integer> s = new Stack<>();
        for(int i = 0 ; i<a.length() ; i++){
            char ch = a.charAt(i);
            int ascii = (int)ch;
            if(ascii<=57&&ascii>=48){
                s.push(ascii-48);
            }
            else{
                int val2 = s.pop();
                int val1 = s.pop();
                if(ch=='+') s.push(val1+val2);
                if(ch=='-') s.push(val1-val2);
                if(ch=='*') s.push(val1*val2);
                if(ch=='/') s.push(val1/val2);
            }
        }
        System.out.println(s.peek());
    }
}

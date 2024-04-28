package stacks;
import java.util.*;

public class prefixEvaluation {
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
                int v2 = s.pop();
                int v1 = s.pop();
                if(ch=='+')s.push(v1+v2);
                if(ch=='-')s.push(v1-v2);
                if(ch=='*')s.push(v1*v2);
                if(ch=='/')s.push(v1/v2);
            }
        }
        System.out.println(s.pop());
    }
}

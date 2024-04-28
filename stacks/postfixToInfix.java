package stacks;

import java.util.Stack;

public class postfixToInfix {
    public static void main(String[] args) {

        String a = "243844*/+9**/";
        Stack<String> s = new Stack<>();
        for(int i = 0 ; i<a.length() ; i++){
            char c = a.charAt(i);
            int ascii = (int)c;
            if(ascii>=48&&ascii<=57){
                String o = ""+c;
                s.push(o);
            }
            else{
                String v2 = s.pop();
                String v1 = s.pop();
                char op = c;
                s.push("("+v1+op+v2+")");
            }
        }
        System.out.println(s.peek());
    }
}

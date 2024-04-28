package stacks;
import java.util.*;
public class infix {
    public static void main(String[] args) {
        String a = "9*(4*4/8+3)*4/2";
        int n = a.length();
        Stack<Integer> st = new Stack<>();
        Stack<Character> st2 = new Stack<>();
        for(int i = 0; i<n; i++){
            char ch = a.charAt(i);
            int ascii = (int)(a.charAt(i));
            if(ascii >=48 && ascii<=57) st.push(ascii-48);
            else if(st2.isEmpty()||ch=='('||st2.peek()=='(') st2.push(ch);
            else if(ch==')'){
                while(st2.peek()!='('){
                    int val1 = st.pop();
                    int val2 = st.pop();
                    if(st2.peek()=='+') st.push(val1+val2);
                    if(st2.peek()=='-') st.push(val2-val1);
                    if(st2.peek()=='*') st.push(val2*val1);
                    if(st2.peek()=='/') st.push(val2/val1);
                    st2.pop();
                }
                st2.pop();//opening bracket removed from stack
            }
            else{
                if(ch=='+'||ch=='-'){
                    int val1 = st.pop();
                    int val2 = st.pop();
                    if(st2.peek()=='+') st.push(val1+val2);
                    if(st2.peek()=='-') st.push(val2-val1);
                    if(st2.peek()=='*') st.push(val2*val1);
                    if(st2.peek()=='/') st.push(val2/val1);
                    st2.pop();
                    st2.push(ch);
                }
                else{
                    if(st2.peek() == '+'||st2.peek()=='-') st2.push(ch);
                    else{
                        int val1 = st.pop();
                        int val2 = st.pop();
                        if(st2.peek()=='*') st.push(val2*val1);
                        if(st2.peek()=='/') st.push(val2/val1);
                        st2.pop();
                        st2.push(ch);
                    }
                }
            }
        }
        while(st.size()>1){
            int val1 = st.pop();
            int val2 = st.pop();
            if(st2.peek()=='+') st.push(val1+val2);
            if(st2.peek()=='-') st.push(val2-val1);
            if(st2.peek()=='*') st.push(val2*val1);
            if(st2.peek()=='/') st.push(val2/val1);
            st2.pop();
        }
        System.out.println(st.pop());
    }
}

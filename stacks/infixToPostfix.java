package stacks;

import java.util.Stack;

public class infixToPostfix {
    public static void main(String[] args) {
        String a = "9*(4*4/8+3)*4/2";
        int n = a.length();
        Stack<String> st = new Stack<>();
        Stack<Character> st2 = new Stack<>();
        for(int i = 0; i<n; i++){
            char ch = a.charAt(i);
            int ascii = (int)(a.charAt(i));
            if(ascii >=48 && ascii<=57) {
                String s = ""+ch;
                st.push(s);
            }
            else if(st2.isEmpty()||ch=='('||st2.peek()=='(') st2.push(ch);
            else if(ch==')'){
                while(st2.peek()!='('){
                    String val1 = st.pop();
                    String val2 = st.pop();
                    char c = st2.pop();
                    String o = val1+val2+c;
                    st.push(o);
                }
                st2.pop();//opening bracket removed from stack
            }
            else{
                if(ch=='+'||ch=='-'){
                    String val1 = st.pop();
                    String val2 = st.pop();
                    char c = st2.pop();
                    String o = val1+val2+c;
                    st.push(o);
                    st2.push(ch);
                }
                else{
                    if(st2.peek() == '+'||st2.peek()=='-') st2.push(ch);
                    else{
                        String val1 = st.pop();
                        String val2 = st.pop();
                        char c = st2.pop();
                        String o = val1+val2+c;
                        st.push(o);
                        st2.push(ch);
                    }
                }
            }
        }
        while(st.size()>1){
            String val1 = st.pop();
            String val2 = st.pop();
            char c = st2.pop();
            String o = val1+val2+c;
            st.push(o);
        }
        System.out.println(st.pop());
    }
}

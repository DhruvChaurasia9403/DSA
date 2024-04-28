package stacks;

import java.util.Stack;
public class BasicsOfStack {
    public static void main(String[] args) {
        Stack<Integer> st= new Stack();
        st.push(5);
        st.push(6);
        System.out.println(st.peek());
        System.out.println(st);
        st.push(7);
        int a = st.size();
        System.out.println(st);
        System.out.println(a);
        System.out.println(st.isEmpty());
    }
}

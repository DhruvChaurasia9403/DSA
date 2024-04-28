package stacks;

import java.util.*;
public class reversingTheStack {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack();
        s.push(5);
        s.push(4);
        s.push(3);
        s.push(2);
        s.push(1);
        Stack<Integer> a = new Stack();
        while(s.size()>0){
            a.push(s.pop());
        }
        Stack<Integer> d = new Stack();
        while(a.size()>0){
            d.push(a.pop());
        }
        while(d.size()>0){
            s.push(d.pop());
        }
        System.out.println(s);
        reverse(s);
        System.out.println(s);
    }
    //recursively reversing the stack
    public static void reverse(Stack<Integer> a ){
        if(a.size()==1) return ;
        int top = a.pop();
        reverse(a);
        PushAtBottom(a,top);
    }
    public static void PushAtBottom(Stack<Integer> a,int top){
        if(a.size()==0){
            a.push(top);
            return;
        }
        int Top = a.pop();
        PushAtBottom(a,top);
        a.push(Top);
    }
}

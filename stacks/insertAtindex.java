package stacks;

import java.util.Stack;
import java.util.*;
public class insertAtindex {
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        Stack<Integer> s1 = new Stack();
        Stack<Integer> s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        reversePrint(s);
        System.out.println();
        System.out.println(s);
        straightPrint(s);
//        int n = a.nextInt();
//        System.out.print("Enter the element : ");
//        int item = a.nextInt();
//        if(n==0){
//            InsertAtBottom(s,item);
//        }
//        //insert at the end
//        else if(n==s.size()){
//            s.push(item);
//        }
//        else {
//            while (s.size() > n) {
//                s1.push(s.pop());
//            }
//            s.push(item);
//            while (s1.size() > 0) {
//                s.push(s1.pop());
//            }
//        }
//        System.out.println(s);
    }
    public static void InsertAtBottom(Stack<Integer> s,int item){
        Stack<Integer> a = new Stack();
        while(s.size()>0){
            a.push(s.pop());
        }
        a.push(item);
        while(a.size()>0){
            s.push(a.pop());
        }
    }
    //printing the reversed stack
    public static void reversePrint(Stack<Integer> a){
        if(a.size()==0) return;
        int x = a.pop();
        System.out.print(x+" ");
        reversePrint(a);
        a.push(x);
    }
    public static void straightPrint(Stack<Integer> a){
        if (a.size()==0){
            return;
        }
        int x = a.pop();
        straightPrint(a);
        a.push(x);
        System.out.print(x+" ");
    }
}

package stacks;

import java.util.*;
public class InsertAtIndexRec {
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        Stack<Integer> s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        int ind = a.nextInt();
        System.out.println("Enter the elements : " );
        int item = a.nextInt();
        System.out.println(s);
        InsertAt(s,item,ind);
        System.out.println(s);
    }
    public static void InsertAt(Stack<Integer> s , int item , int ind){
        if(ind == s.size()){
            s.push(item);
            return;
        }
        int x = s.pop();
        InsertAt(s,item,ind);
        s.push(x);
    }
}

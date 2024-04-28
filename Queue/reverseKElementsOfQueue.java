package Queue;
import java.util.*;


public class reverseKElementsOfQueue {
    public static void main(String[] args) {
        Queue<Integer> a = new ArrayDeque<>();
        a.add(3);
        a.add(5);
        a.add(6);
        a.add(8);
        a.add(9);
        Stack <Integer> s = new Stack<>();
        while(!a.isEmpty()) {
            s.push(a.remove());
        }
        while(!s.isEmpty()){
            a.add(s.pop());
        }
        while(!a.isEmpty()){
            System.out.print (a.remove()+" ");
        }
    }
}

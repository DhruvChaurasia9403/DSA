package Queue;
import java.util.*;


public class queuesBasics {
    public static void main(String[] args) {
        Queue<Integer> a = new LinkedList<>();
        a.add(5);
        a.add(4);
        a.add(3);
        a.add(2);
        a.add(1);
        System.out.println(a);
        a.poll();
        System.out.println(a);
        System.out.println(a.peek());

    }
}
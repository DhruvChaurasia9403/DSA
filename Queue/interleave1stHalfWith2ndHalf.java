package Queue;
import java.util.*;
public class interleave1stHalfWith2ndHalf {
    public static void main(String[] args) {
        Queue<Integer> a = new ArrayDeque<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(5);
        a.add(6);
        a.add(7);
        a.add(8);
        Stack<Integer> s = new Stack<>();
        while(a.size()<=a.size()/2){
            s.push(a.remove());
        }
        while(s.isEmpty()){
            a.add(s.pop());
        }
        while(a.size()<=a.size()/2){
            s.push(a.remove());
        }
        while(s.isEmpty()){
            a.add(s.pop());
            a.add(a.remove());
        }
    }
}

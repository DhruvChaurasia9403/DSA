package Tree;
import java.util.*;

public class levelOrder {
    static class Node{
        int val ;
        Node left , right;
        Node(int val){
            this.val = val;
            left=right=null;
        }
    }
    public static List<List<Integer>> LO(Node node){
        if(node==null) return new ArrayList<List<Integer>>();
        Queue<Node> open = new LinkedList<>();
        List<List<Integer>> close = new ArrayList<>();
        open.offer(node);
        while(!open.isEmpty()){
            int n = open.size();
            List<Integer> sub = new ArrayList<>();
            for(int i = 0 ; i < n ; i++){
                Node current = open.poll();
                if(current.left != null) open.offer(current.left);
                if(current.right != null) open.offer(current.right);
                sub.add(current.val);
            }
            close.add(sub);
        }
        return close;
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right.left = new Node(6);
        node.right.right = new Node(7);
        node.left.right.left = new Node(8);
        node.right.right.left = new Node(9);
        node.right.right.right = new Node(10);

        List<List<Integer>> close = LO(node);
        for(List<Integer> x : close){
            System.out.println(x);
        }
    }
}

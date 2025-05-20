package Tree;
import java.util.*;

public class topViewOfBinaryTree {
    public static class Node{
        Node left,right;
        int val ;
        Node(int val){
            this.val = val;
        }
    }
    public static class pair{
        Node node;
        int level;
        pair(int level, Node node){
            this.node = node;
            this.level = level;
        }
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
        System.out.println(Top(node));
    }
    public static List<Integer> Top(Node node){
        List<Integer> ls = new ArrayList<>();
        if(node == null) return ls;
        Queue<pair> q = new LinkedList<>();
        q.offer(new pair(0,node));
        Map<Integer , Integer> temp = new TreeMap<>();
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0 ; i < size ; i++){
                pair curr = q.poll();
                temp.putIfAbsent(curr.level , curr.node.val);
                if(curr.node.left!=null) q.offer(new pair(curr.level-1,curr.node.left));
                if(curr.node.right!=null) q.offer(new pair(curr.level+1,curr.node.right));
            }
        }
        for(int x : temp.values()){
            ls.add(x);
        }
        return ls;
    }

}

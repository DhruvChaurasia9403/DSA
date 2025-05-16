package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class zigzaktraversal {
    static class Node{
        Node right;        Node left;
        int val;
        Node(int val){
            this.val = val;
        }
    }
    public static List<List<Integer>> LO(Node node){
        Queue<Node> open = new LinkedList<>();
        List<List<Integer>> close = new ArrayList<>();
        open.offer(node);
        boolean flag = false;
        while(!open.isEmpty()){
            int size = open.size();
            List<Integer> wrap = new ArrayList<>();
            for(int i = 0; i < size ; i++ ){
                Node curr = open.poll();
                if(flag) wrap.add(0,curr.val);
                else wrap.add(curr.val);
                if(curr.left != null) open.offer(curr.left);
                if(curr.right != null) open.offer(curr.right);
                wrap.add(curr.val);
            }
            close.add(wrap);
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
        for (List<Integer> x : close) {
            System.out.println(x);
        }
    }
}

package Tree;

import java.util.List;

public class MaxHeight {
    static class Node{
        int val ;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
            left=right=null;
        }
    }
    public static int maxH(Node node , int max){
        if(node==null) return max;
        return max =1+Math.max(maxH(node.left,max),maxH(node.right,max));
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

        System.out.println(maxH(node,0));
    }
}

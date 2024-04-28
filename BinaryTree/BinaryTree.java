package BinaryTree;
import java.util.*;

public class BinaryTree {
    public BinaryTree(){
    }
    public static class Node{
        int val;
        static Node left;
        static Node right;
        public Node(int val){
            this.val = val;
        }
    }
    public Node root;
    public void populate(Scanner sc){
        System.out.println("Enter the root node: ");
        int value = sc.nextInt();
        root = new Node(value);
        populate(sc,root);
    }
    public void populate(Scanner sc , Node root){
        System.out.println("want to add the left node : ");
        boolean replyLeft = sc.nextBoolean();
        if(replyLeft){
            int valueLeft = sc.nextInt();
            Node.left = new Node(valueLeft);
            populate(sc,Node.left);
        }
        System.out.println("want to add the right node : ");
        boolean replyRight = sc.nextBoolean();
        if(replyRight){
            int valueRight = sc.nextInt();
            Node.right = new Node(valueRight);
            populate(sc,Node.right);
        }
    }
}

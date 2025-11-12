package Tree.physicswallah;

public class sizeMaxSumHeight {
    public static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
    public static void main(String[] args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
    }
    public static void traversalPreOrder(Node node){
        if(node == null) return;
        System.out.println(node.val);
        traversalPreOrder(node.left);
        traversalPreOrder(node.right);
    }
}

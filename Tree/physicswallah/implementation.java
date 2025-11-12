package Tree.physicswallah;

public class implementation {
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
        Node root = new Node(2);
        root.left = new Node(4);
        root.right = new Node(10);
        root.left.left = new Node(6);
        root.left.right = new Node(5);
        root.right.right = new Node(11);
    }
}

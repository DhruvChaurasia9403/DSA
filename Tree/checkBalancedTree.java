package Tree;

public class checkBalancedTree {
    static class Node{
        int val ;
        Node left , right;
        Node(int val){
            this.val = val;
            left=right=null;
        }
    }
    public static boolean isBalanced(Node node){
        int height = maxH(node);
        return height!=-1;
    }
    public static int maxH(Node node){
        if(node == null) return 0;
        int left = maxH(node.left);
        int right = maxH(node.right);
        if(left == -1 || right==-1) return -1;
        if(Math.abs(left-right) > 1){
            return -1;
        }
        return 1+Math.max(left,right);
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
        node.right.right.right.right = new Node(11);


        System.out.println("Tree is balanced ? : " +isBalanced(node));
    }
}

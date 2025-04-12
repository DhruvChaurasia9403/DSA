package Tree;

public class diameterOfTree {
    static class Node{
        int val ;
        Node left , right;
        Node(int val){
            this.val = val;
            left=right=null;
        }
    }
    public static int diameter(Node node , int[] max){
        if(node == null) return 0;
        int left = diameter(node.left , max);
        int right = diameter(node.right , max);
        max[0] = Math.max(max[0] , left+right);
        return Math.max(left,right)+1;
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
        int[] max = new int[1];
        diameter(node,max);
        System.out.println(max[0]);
    }
}

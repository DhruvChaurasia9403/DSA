package Tree;

public class maxPathSum {
    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(2);
        node.left.right.right = new Node(6);
        int[] max = new int[1];
        System.out.println(maxPS(node , max[0]));;
    }
    public static class Node{
        Node left , right;
        int val;
        Node (int val){
            this.val = val;
        }
    }
    public static int maxPS(Node node , int sum){
        if(node == null) return 0;
        int l = maxPS(node.left,sum);
        int r = maxPS(node.right,sum);
        sum = Math.max(sum , l+r + node.val);
        return Math.max(l,r)+node.val;
    }
}

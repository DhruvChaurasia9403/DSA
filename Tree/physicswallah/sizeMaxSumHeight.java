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
        root.right.right.right = new Node(10);
        System.out.println(sizeOf(root));
        System.out.println(maxHeight(root));
        System.out.println(allSum(root));

        int max[] = new int[1];
        System.out.println(diameter(root,max));
    }
    public static void traversalPreOrder(Node node){
        if(node == null) return;
        System.out.println(node.val);
        traversalPreOrder(node.left);
        traversalPreOrder(node.right);
    }
    public static int sizeOf(Node node){
        if(node==null) return 0;
        return sizeOf(node.left)+sizeOf(node.right)+1;
    }
    public static int maxHeight(Node node){
        if(node==null) return 0;
        int l = maxHeight(node.left);
        int r = maxHeight(node.right);
        return 1+Math.max(l,r);
    }
    public static int allSum(Node node){
        if(node == null) return 0;
        int val = node.val;
        return val+allSum(node.left)+allSum(node.right);
    }
    public static int diameter(Node node,int[] max){
        if(node==null){
            return 0;
        }
        int l = diameter(node.left,max);
        int r = diameter(node.right,max);
        max[0] = Math.max(l+r,max[0]);
        return 1+Math.max(l,r);
    }
}

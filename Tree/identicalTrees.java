package Tree;

public class identicalTrees {
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


        Node node2 = new Node(1);
        node2.left = new Node(2);
        node2.right = new Node(3);
        node2.left.left = new Node(4);
        node2.left.right = new Node(5);
        node2.right.left = new Node(6);
        node2.right.right = new Node(7);
        node2.left.right.left = new Node(8);
        node2.right.right.left = new Node(9);
        node2.right.right.right = new Node(11);

        System.out.println(check(node,node2));
    }
    static class Node{
        int val ;
        Node left , right;
        Node(int val){
            this.val = val;
            left=right=null;
        }
    }
    public static boolean check(Node n1 , Node n2){
        if(n1 == null && n2 == null) return true;
        if(n1 == null || n2 == null) return false;
        if(n1.val != n2.val) return false;
        return check(n1.right , n2.right) && check(n1.left,n2.left);
    }
}

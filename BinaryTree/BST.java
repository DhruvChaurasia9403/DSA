package BinaryTree;

public class BST {
    public class Node{
        int val, height;
        Node left ,right;
        public Node (int val){
            this.val = val;
        }
        public int getValue(){
            return val;
        }
    }
    public Node root;
    public BST(){
    }
    public void insert(int value){
        root = insert(value,root);
    }
    public Node insert(int val, Node node ){
        if(node==null){
            node = new Node(val);
            return node;
        }
        if(val<node.val){
            node.left = insert(val,node.left);
        }
        else if(val > node.val){
            node.right = insert(val,node.right);
        }
        node.height = Math.max(height(node.left),height(node.right))+1;
        return node;
    }
    public int height(Node node){
        if(node==null){
            return -1;
        }
        return node.height;
    }
    public boolean isEmpty(Node node){
        return node==null;
    }
    public boolean isBalanced(Node node){
        if(node==null)
            return true;
        return (Math.abs(height(node.left) - height(node.right)) <= 1) && isBalanced(node.left) && isBalanced(node.right);
    }
    public void display(){

    }
}

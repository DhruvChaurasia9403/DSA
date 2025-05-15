package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class treeDFS {
    static class TreeNode{
        TreeNode left , right;
        int val;
        TreeNode(int val){
            this.val = val;
            left=right=null;
        }
    }
    public static List<Integer> preOrderinterative(TreeNode node){
        List<Integer> ls = new ArrayList<>();
        if(node == null ) return ls;

        Stack<TreeNode> close = new Stack<>();
        close.add(node);
        while(!close.empty()){
            TreeNode curr = close.pop();
            ls.add(curr.val);
            if(curr.right!=null) close.add(curr.right);
            if(curr.left!=null) close.add(curr.left);
        }
        return ls;
    }
    public static void preorder(TreeNode node){
        if(node== null) return ;
        System.out.print(node.val+" ");
        preorder(node.left);
        preorder(node.right );
    }
    public static List<Integer> postOrderinterative(TreeNode node){
        List<Integer> ls = new ArrayList<>();
        if(node == null ) return ls;
        Stack<TreeNode> close2 = new Stack<>();
        Stack<TreeNode> close = new Stack<>();
        close.add(node);
        while(!close.empty()){
            TreeNode curr = close.pop();
            close2.add(curr);
            if(curr.left!=null) close.add(curr.left);
            if(curr.right!=null) close.add(curr.right);
        }
        while(!close2.empty()){
            ls.add(close2.pop().val);
        }
        return ls;
    }
    public static void postorder(TreeNode node){
        if(node== null) return ;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.val+ " ");
    }
    public static void inorder(TreeNode node){
        if(node== null) return ;
        inorder(node.left);
        System.out.print(node.val + " ");
        inorder(node.right);
    }
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(7);
        node.left.right.left = new TreeNode(8);
        node.right.right.left = new TreeNode(9);
        node.right.right.right = new TreeNode(10);

//        System.out.print("InOrder Traversal : ");
//        inorder(node);
//        System.out.println();
//
//
//        System.out.print("PreOrder Traversal : ");
//        System.out.println(preOrderinterative(node));
//        System.out.println();


        System.out.print("PostOrder Traversal : ");
        postorder(node);
        System.out.println(postOrderinterative(node));;

        System.out.println();
    }
}

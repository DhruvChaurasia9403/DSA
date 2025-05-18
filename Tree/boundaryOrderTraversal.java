package Tree;
import java.util.*;

public class boundaryOrderTraversal {
    public class Node{
        Node left , right;
        int val;
        Node(int val) {
            this.val = val;
        }
    }
    public static ArrayList<Integer> BOT(Node node){
        ArrayList<Integer> ls = new ArrayList<>();
        if(node == null) return ls;
        if(isLeaf(node)) {
            ls.add(node.val);
            return ls;
        }
        ls.add(node.val);
        addLeft(node,ls);
        addLeaf(node,ls);
        addRight(node,ls);
        return ls;
    }
    public static void addLeft(Node node,ArrayList<Integer> ls){
        Node curr = node.left;
        while(curr!=null) {
            if (isLeaf(curr) == false) ls.add(curr.val);
            if (curr.left != null) curr = curr.left;
            else curr = curr.right;
        }
    }
    public static void addLeaf(Node node,ArrayList<Integer> ls){
        if(isLeaf(node)){
            ls.add(node.val);
            return ;
        }
        if(node.left!=null) addLeaf(node.left,ls);
        if(node.right!=null) addLeaf(node.right, ls);
    }
    public static void addRight(Node node , ArrayList<Integer> ls){
        ArrayList<Integer> temp = new ArrayList<>();
        Node curr = node.right;
        while(curr!=null){
            if(isLeaf(curr)==false) temp.add(curr.val);
            if(curr.right!=null) curr = curr.right;
            else curr = curr.left;
        }
        Collections.reverse(temp);
        ls.addAll(temp);
    }
    public static boolean isLeaf(Node node){
        return node.left==null && node.right==null;
    }
    public static void main(String[] args) {

    }
}

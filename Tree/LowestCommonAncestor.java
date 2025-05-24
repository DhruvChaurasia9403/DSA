package Tree;
import java.util.*;

public class LowestCommonAncestor {
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

        List<Integer> ls1 = new ArrayList<>();
        List<Integer> ls2 = new ArrayList<>();
        path(node,ls1,6);
        path(node,ls2,10);
        System.out.println(ls1);
        System.out.println(ls2);
        int common = 0;
        int i =0;
        while(ls1.get(i)==ls2.get(i)){
            i++;
        }
        System.out.println(ls1.get(i-1));
    }
    public static class Node{
        Node left , right;
        int val;
        Node(int val){
            this.val = val;
        }
    }
    public static boolean path(Node node,List<Integer> ls , int value){
        if(node == null) return false;
        ls.add(node.val);
        if(node.val == value) return true;
        if(path(node.left , ls , value) || path(node.right , ls , value)) return true;
        ls.remove(ls.size()-1);
        return false;
    }
}

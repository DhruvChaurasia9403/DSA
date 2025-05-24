package Tree;
import java.util.*;

public class PathToNode {
    public static class Node{
        Node left , right ;
        int val ;
        Node(int val){
            this.val = val;
        }
    }
    // this code prints path to the particular or targeted node
    public static boolean path(Node node,List<Integer> ls,int valueOfNode){
        if(node==null) return false;
        ls.add(node.val);
        if(node.val==valueOfNode) return true;
        if(path(node.left , ls,valueOfNode) || path(node.right,ls,valueOfNode)){
            return true;
        }
        ls.remove(ls.size()-1);
        return false;
    }



    //This code prints the path to the leaf node
    public static void pathToNode(Node node , List<Integer> ls , List<List<Integer>> res){
        if(node == null) return ;
        ls.add(node.val);
        if(node.left!=null) pathToNode(node.left , ls , res);
        if(node.right!=null) pathToNode(node.right , ls, res);
        if(node.left==null&&node.right==null) res.add(new ArrayList<>(ls));
        ls.remove(ls.size()-1);
    }
}

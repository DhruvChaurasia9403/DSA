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
}

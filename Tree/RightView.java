package Tree;
import java.util.*;
public class RightView {
    public static class Node{
        Node left,right;
        int val;
        Node(int val ){
            this.val = val;
        }
    }

    public static void main(String[] args) {

    }
    public static List<Integer> rightView(Node node){
        List<Integer> ls = new ArrayList<>();
        if(node == null) return ls;
        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0 ; i < size ; i++){
                Node curr = q.poll();
                if(i==size-1) ls.add(curr.val);
                if(curr.left!=null) q.offer(curr.left);
                if(curr.right!=null) q.offer(curr.right);
            }
        }
        return ls;
    }
}

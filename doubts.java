import java.util.*;

public class doubts {
    static class Node{
        Node right;
        Node left;
        int val;
        Node(int val){
            this.val = val;
        }
    }
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

        List<List<Integer>> close = LOT(node);
        for(List<Integer> x : close){
            System.out.println(x);
        }
    }
    public static List<List<Integer>> LOT(Node node){
        Queue<Node> q = new LinkedList<>();
        List<List<Integer>> ls = new ArrayList<>();
        q.offer(node);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> wrap = new ArrayList<>();
            for(int i = 0 ; i < size ; i++){
                Node curr = q.poll();
                if(curr.left != null) q.offer(curr.left);
                if(curr.right != null) q.offer(curr.right);
                wrap.add(curr.val);
            }
            ls.add(wrap);
        }
        return ls;
    }
    public static int diameter(Node node,int max){
        if(node == null) return 0;
        int l = diameter(node.left,max);
        int r = diameter(node.right,max);
        max = Math.max(max,l+r);
        return Math.max(l,r)+1;
    }

    public static List<List<Integer>> zigZag(Node node){
        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        boolean flag = false;
        List<List<Integer>> ls = new ArrayList<>();
        while(!q.isEmpty()){
            int s = q.size();
            List<Integer> close = new ArrayList<>();
            for(int i = 0; i <s ; i++){
                Node curr = q.poll();
                if(flag) close.add(curr.val);
                else close.add(0,curr.val);
                if(curr.left!= null) q.offer(curr.left);
                if(curr.right!=null) q.offer(curr.right);
            }
            ls.add(close);
            flag = !flag;
        }
        return ls;
    }
}

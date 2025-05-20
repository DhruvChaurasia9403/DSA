package Tree;
import java.util.*;

public class VerticalOrderTraversal {
    public static class Node{
        Node left,right;
        int val;
        Node(int val){
            this.val=val;
        }
    }

    public static void main(String[] args) {

    }



    public static List<List<Integer>>VOT(Node node){
        List<List<Integer>> ls = new ArrayList<>();
        if(node==null) return ls;
        Queue<pair> open = new LinkedList<>();
        Map<Integer , ArrayList<Integer>> mp = new TreeMap<>();
        open.offer(new pair(0,node));
        while(!open.isEmpty()){
            int size = open.size();
            Map<Integer, ArrayList<Integer>> levelMap = new HashMap<>();
            for(int i = 0 ; i < size ; i ++){
                pair curr = open.poll();
                levelMap.putIfAbsent(curr.level,new ArrayList<>());
                levelMap.get(curr.level).add(curr.node.val);
                if(curr.node.left!=null){
                    open.offer(new  pair(curr.level-1,curr.node.left));
                }
                if(curr.node.right!=null){
                    open.offer(new pair(curr.level+1,curr.node.right));
                }
            }
            for(Map.Entry<Integer,ArrayList<Integer>> entry : levelMap.entrySet()){
                List<Integer> temp = entry.getValue();
                Collections.sort(temp);
                mp.putIfAbsent(entry.getKey(), new ArrayList<>());
                mp.get(entry.getKey()).addAll(temp);
            }
        }
        for(List<Integer> temp: mp.values()){
            ls.add(temp);
        }
        return ls;
    }
    public static class pair{
        int level;
        Node node;
        pair(int level , Node node){
            this.level = level;
            this.node = node;
        }
    }
}

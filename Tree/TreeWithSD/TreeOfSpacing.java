package Tree.TreeWithSD;
import java.util.*;


public class TreeOfSpacing {
    public static class Node{
        String name;
        Node parent;
        int id;
        boolean isLocked;
        int anc;
        int des;
        List<Node> children;
        Node(String name , Node parent){
            this.name = name;
            this.parent = parent;
            this.children = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();
        sc.nextLine();
        Map<String,Node> map = new HashMap<>();
        Node root = new Node(sc.nextLine(),null);
        map.put(root.name,root);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int ind = 0;
        while(!queue.isEmpty()&&ind<n){
            Node parentNode = queue.poll();
            for(int i = 0 ; i  < m && ind < n ; i++){
                Node child = new Node(sc.nextLine() , null);
                parentNode.children.add(child);
                map.put(child.name,child);
                queue.add(child);
                ind++;
            }
        }
        for(int i = 0 ; i < q ; i++){
            String[] parts = sc.nextLine().split(" ");
            int operations = Integer.parseInt(parts[0]);
            String name = parts[1];
            int id = Integer.parseInt(parts[2]);
            boolean res = false;
            Node node = map.get(name);
            if(operations == 1) res = lock(node,id);
            else if(operations == 2) res = unlock(node,id);
            else res =upgrade(node,id);
            System.out.println(res);
        }
    }
    public static boolean lock(Node node , int id){
        if(node.isLocked || node.anc > 0 || node.des > 0) return false;
        informAnc(node,1);
        informDes(node,1);
        node.isLocked = true;
        node.id = id;
        return true;
    }
    private static void informAnc(Node node ,int val){
        Node curr = node.parent;
        while(curr!=null){
            curr.des+=val;
            curr = curr.parent;
        }
    }
    private static void informDes(Node node,int val){
        if(node == null) return;
        node.anc+=val;
        for(Node child : node.children){
            informDes(child,val);
        }
    }
    public static boolean unlock(Node node , int id){
        if(!node.isLocked || node.id != id) return false;
        informDes(node,-1);
        informAnc(node,-1);
        node.isLocked = false;
        node.id = 0;
        return true;
    }
    public static boolean upgrade(Node node , int id){
        if(node.isLocked || node.anc > 0 || node.des ==0) return false;
        List<Node> ld = new ArrayList<>();
        if(!getAllChild(node,ld,id)) return false;
        informAnc(node,1);
        informDes(node,1);
        for(Node child:node.children){
            unlock(child,id);
        }
        node.isLocked = true;
        node.id = id;
        return true;
    }
    private static boolean getAllChild(Node node, List<Node> ld , int id){
        if(node == null)return true;
        if(node.isLocked){
            if(node.id!=id) return false;
            ld.add(node);
        }
        for(Node child : node.children){
            if(!getAllChild(child,ld,id)) return false;
        }
        return true;
    }
}

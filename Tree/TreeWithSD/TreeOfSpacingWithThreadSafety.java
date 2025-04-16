package Tree.TreeWithSD;
import java.util.*;

public class TreeOfSpacingWithThreadSafety {
    public static class Node{
        String name ;
        int id ;
        boolean isLocked;
        Node parent;
        int anc ;
        int des;
        List<Node> children;
        Node(String name, Node parent){
            this.parent = parent;
            this.name = name;
            children = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();
        sc.nextLine();
        Map<String , Node> map = new HashMap<>();
        Node root = new Node(sc.nextLine(),null);
        map.put(root.name,root);
        Queue<Node> open = new LinkedList<>();
        open.add(root);
        int ind = 0;
        while(!open.isEmpty()){
            Node parentNode = open.poll();
            for(int i=0;i<m&&i<n ; i++ ){
                Node child = new Node(sc.nextLine(),null);
                map.put(child.name,child);
                parentNode.children.add(child);
                open.add(child);
                ind++;
            }
        }
        for(int i = 0 ; i < q ; i ++){
            String[] s = sc.nextLine().split(" ");
            int operation = Integer.parseInt(s[0]);
            String name = s[1];
            int id = Integer.parseInt(s[2]);
            boolean res = false;
            Node node = map.get(name);
            if(operation == 1) lock(node,id);
            else if(operation == 2) res = unlock(node,id);
            else res =upgrade(node,id);
            System.out.println(res);
        }
    }
    public static boolean lock(Node node , int id){
        if(node.isLocked||node.anc>0||node.des>0) return false;
        informAnc(node,1);
        informDes(node,1);
        node.isLocked=true;
        node.id=id;
        return true;
    }
    private static void informAnc(Node node,int val){
        Node cur = node.parent;
        while(cur!=null){
            cur.des+=val;
            cur = cur.parent;
        }
    }
    private static void informDes(Node node , int val){
        if(node == null) return ;
        node.anc+=val;
        for(Node child : node.children){
            informDes(child,val);
        }
    }
    public static boolean unlock(Node node , int id){
        if(!node.isLocked || node.id!=id) return false;
        informAnc(node,-1);
        informDes(node,-1);
        node.isLocked = false;
        node.id = 0;
        return true;
    }
    public static boolean upgrade(Node node,int id){
        if(node.isLocked||node.anc>0||node.des==0) return false;
        List<Node> ld = new ArrayList<>();
        if(!getAllDes(node,ld,id)){
            return false;
        }
        for(Node child: node.children){
            unlock(child,id);
        }
        node.isLocked = true;
        node.id = id;
        return false;
    }
    private static boolean getAllDes(Node node,List<Node> ld , int id){
        if(node == null) return true;
        if(node.isLocked){
            if(node.id!=id) return false;
            ld.add(node);
        }
        for(Node child  : node.children){
            if(!getAllDes(child,ld,id)) return false;
        }
        return true;
    }
}

package Tree.TreeWithSD;
import java.util.*;


public class TreeOfSpacing {
    static class Node{
        String name;
        int id;
        boolean isLocked;
        int anc;
        int des;
        Node parent;
        List<Node> children = new ArrayList<>();
        Node(String name , Node parent ){
            this.name = name ;
            this.parent = parent;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();
        sc.nextLine();
        Map<String, Node> map = new HashMap<>();
        Node root = new Node(sc.nextLine(),null);
        map.put(root.name, root);
        Queue<Node> open= new LinkedList<>();
        open.add(root);
        int ind = 0;
        while(!open.isEmpty()&&ind<n){
            Node parentNode = open.poll();
            for(int i = 0; i < m && ind < n; i++){
                Node child = new Node(sc.nextLine() , parentNode);
                parentNode.children.add(child);
                map.put(child.name,child);
                open.add(child);
                ind++;
            }
        }
        for(int i = 0 ; i < q ; i++){
            String[] parts = sc.nextLine().split(" ");
            int operation = Integer.parseInt(parts[0]);
            String name = parts[1];
            int id = Integer.parseInt(parts[2]);
            Node node = map.get(name);
            boolean res = false;
            if(operation == 1){
                res = lock(node,id);
            }else if(operation == 2){
                res = unlock(node,id);
            }else{
                res = upgrade(node,id);
            }
            System.out.println(res);
        }
    }
    public static boolean lock(Node node,int id){
        if(node.isLocked || node.anc >0 || node.des > 0) return false;
        informAnc(node , 1);
        informDec(node , 1);
        node.isLocked = true;
        node.id = id;
        return false;
    }
    private static void informAnc(Node node , int val){
        Node cur = node.parent;
        while(cur!=null){
            cur.des+=val;
            cur = cur.parent;
        }
    }
    private static void informDec(Node node , int val){
        if(node == null) return ;
        node.des+=val;
        for(Node child :node.children){
            informDec(child,val);
        }
    }
    public static boolean unlock(Node node , int id){
        if(!node.isLocked || node.id!= id) return false;
        informDec(node,id);
        informAnc(node,id);
        node.isLocked = false;
        node.id = 0;
        return true ;
    }
    public static boolean upgrade(Node node, int id){
        if(node.isLocked || node.anc>0 || node.des==0) return false;
        List<Node> lockedDes = new ArrayList<>();
        if(!LockedDes(node,lockedDes,id)) return false;
        for(Node des : lockedDes){
            unlock(des,id);
        }
        informAnc(node,id);
        informDec(node,id);
        node.isLocked = true;
        node.id = id;
        return true;
    }
    private static boolean LockedDes(Node node,List<Node> ld , int id){
        if(node==null) return true;
        if(node.isLocked){
            if(node.id!=id) return false;
            ld.add(node);
        }
        for(Node child:node.children){
            if(!LockedDes(node,ld,id)) return false;
        }
        return true;
    }
}

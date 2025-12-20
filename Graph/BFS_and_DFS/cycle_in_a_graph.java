package Graph.BFS_and_DFS;
import java.util.*;

public class cycle_in_a_graph {
    //using bfs
    public static class pair{
        int c , parent;
        public pair(int c, int parent){
            this.c = c;
            this.parent = parent;
        }
    }
    public static boolean isCyclebfs(int v, int[][] edges){
        // first convert into adjacency list
        ArrayList<ArrayList<Integer>> ls = new ArrayList<>();
        for(int i = 0 ; i < v ; i++){
            ls.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int a = edge[0];
            int b = edge[1];
            ls.get(a).add(b);
            ls.get(b).add(a);
        }
        boolean[] isv = new boolean[v];
        for(int i = 0 ; i < v ; i++){
            if(isv[i] == false){
                return bfs(ls,i,isv)==true;
            }
        }
        return false;
    }
    public static boolean bfs(ArrayList<ArrayList<Integer>> ls , int s ,boolean[] isv ){
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(s,-1));
        isv[s] = true;
        while(!q.isEmpty()){
            pair curr = q.poll();
            int node = curr.c;
            int parent = curr.parent;
            for(int i : ls.get(node)){
                if(isv[i] == false){
                    isv[i] = true;
                    q.add(new pair(i,node));
                }
                else if(i != parent){
                    return true;
                }
            }
        }
        return false;
    }



    // same detecting cycle but using dfs
    public static boolean isCycledfs(int v, int[][] edges){
        // first convert into adjacency list
        ArrayList<ArrayList<Integer>> ls = new ArrayList<>();
        for(int i = 0 ; i < v ; i++){
            ls.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int a = edge[0];
            int b = edge[1];
            ls.get(a).add(b);
            ls.get(b).add(a);
        }
        boolean[] isv = new boolean[v];
        //this is for the disconnected graph
        for(int i = 0 ; i < v ; i++){
            if(isv[i] == false){
                return dfs(ls,i,-1,isv)==true;// list, starting , parent , isVisited boolean array
            }
        }
        return false;
    }
    public static boolean dfs(ArrayList<ArrayList<Integer>> ls, int s , int parent , boolean[] isv){
        isv[s] = true;
        for(int x : ls.get(s)){
            if(isv[x] == false){
                return dfs(ls,x,s,isv)==true;
            }
            else if(x != parent) return true;
        }
        return false;
    }
}

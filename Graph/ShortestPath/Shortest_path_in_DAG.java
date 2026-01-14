package Graph.ShortestPath;
import java.util.*;
public class Shortest_path_in_DAG {
    public class pair{
        int v,wt;
        pair(int v,int wt){
            this.v = v;
            this.wt = wt;
        }
    }
    public int[] shortestPath(int V, int E, int[][] edges) {
        // Code here
        ArrayList<ArrayList<pair>> ls = new ArrayList<>();
        for(int i = 0 ; i < V ; i++){
            ls.add(new ArrayList<pair>());
        }
        Stack<Integer> st = new Stack<>();
        int[] isv = new int[V];
        for(int[] edge : edges){
            int to = edge[1];
            int from = edge[0];
            int wt = edge[2];
            ls.get(from).add(new pair(to,wt));
        }
        for(int i = 0 ; i < V ; i++){
            if(isv[i] == 0){
                dfs(i,st,isv,ls);
            }
        }
        int dis[] = new int[V];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[0] = 0;
        while(!st.isEmpty()){
            int curr = st.pop();
            for(pair n : ls.get(curr)){
                int v = n.v;
                int wt = n.wt;
                if(dis[curr] != Integer.MAX_VALUE && dis[curr] + wt < dis[v]){
                    dis[v] = dis[curr]+wt;
                }
            }
        }
        for(int i = 0 ; i < V ; i++){
            if(dis[i] == Integer.MAX_VALUE){
                dis[i] = -1;
            }
        }
        return dis;
    }
    public void dfs(int s,Stack<Integer> st, int[] isv, ArrayList<ArrayList<pair>> ls){
        isv[s] = 1;
        for(pair x : ls.get(s)){
            int v = x.v;
            int wt = x.wt;
            if(isv[v] == 0){
                dfs(v,st,isv,ls);
            }
        }
        st.push(s);
    }
}
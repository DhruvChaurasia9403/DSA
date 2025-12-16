package Graph.BFS_and_DFS;
import java.util.*;
//STRIVER KA CODE HAI
public class bfs_dfs {

    // Create Graph (Adjacency List)
    static void createGraph(ArrayList<ArrayList<Integer>> adj, int V) {
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(1);
        adj.get(0).add(2);

        adj.get(1).add(0);
        adj.get(1).add(3);

        adj.get(2).add(0);
        adj.get(2).add(4);

        adj.get(3).add(1);
        adj.get(3).add(4);
        adj.get(3).add(5);

        adj.get(4).add(2);
        adj.get(4).add(3);
        adj.get(4).add(5);

        adj.get(5).add(3);
        adj.get(5).add(4);
        adj.get(5).add(6);

        adj.get(6).add(5);
    }

    // BFS Function (Striver Style)
    static void breathFirstSearch(int start, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {

        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        vis[start] = true;

        while (!q.isEmpty()) {
            int node = q.poll();
            System.out.print(node + " ");
            for (int it : adj.get(node)) {
                if (!vis[it]) {
                    vis[it] = true;
                    q.add(it);
                }
            }
        }
    }


    // DFS Function (Striver Style)
    static void depthFirstSearch(ArrayList<ArrayList<Integer>> adj, int curr , boolean[] isv){
        System.out.println(curr+ " ");
        isv[curr] = true;
        for(int i : adj.get(curr)){
            if(!isv[i]){
                depthFirstSearch(adj,i,isv);
            }
        }
    }

    public static void main(String[] args) {

        int V = 7;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        createGraph(adj, V);

        boolean[] vis = new boolean[V];

        // For disconnected graph
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                breathFirstSearch(i, adj, vis);
            }
        }
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                depthFirstSearch( adj,i, vis);
            }
        }
    }
}

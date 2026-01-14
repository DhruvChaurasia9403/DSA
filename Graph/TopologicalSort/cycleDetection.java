package Graph.TopologicalSort;
import java.util.*;
public class cycleDetection {
    public static boolean isCyclic(int V, int[][] edges) {
        // code here
        // using topological sort (Kahn's algorithm)
        ArrayList<ArrayList<Integer>> ls = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            ls.add(new ArrayList<>());
        }
        int indeg[] = new int[V];
        for (int edge[] : edges) {
            int to = edge[1];
            int from = edge[0];
            indeg[to]++;
            ls.get(from).add(to);
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i : indeg){
            if(i == 0) q.add(i);
        }
        ArrayList<Integer> l = new ArrayList<>();
        while(!q.isEmpty()){
            int curr = q.poll();
            for(int x : ls.get(curr)){
                indeg[x]--;
                if(indeg[x] == 0) q.add(x);
            }
            l.add(curr);
        }
        return l.size() == V;
    }
}

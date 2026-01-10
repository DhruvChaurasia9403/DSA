package Graph.TopologicalSort;

import java.util.*;

public class kahnsAlgorithm {
    public static ArrayList<Integer> topo(int V, ArrayList<ArrayList<Integer>> ls){
        // this includes creating a indegree array that tracks the number of edges incomming in a vertex in a directed acyclic graph(DAG)
        int[] indeg  = new int[V];
        for(int i = 0 ; i < V ; i++){
            for(int x : ls.get(i)){
                indeg[x]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        // where ever the indegree of a element is zero
        for(int i = 0; i < V ; i++){
            if(indeg[i] == 0){
                q.add(i);
            }
        }
        ArrayList<Integer> l = new ArrayList<>();
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0 ; i < size ; i++){
                int curr = q.poll();
                for(int x : ls.get(curr)){
                    indeg[x]--; // reducing the count ie. now the current element is not connected to the neigbhour anymore
                    if(indeg[x] == 0){
                        q.add(x);
                    }
                }
                l.add(curr); // adding the current element
            }
        }
        return l;
    }
}

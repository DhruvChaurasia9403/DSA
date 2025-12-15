package Graph;
import java.util.*;

public class basics {

    // ADJACENCY LIST Building for the Graph
    public static class edge{
        int src;
        int dest;
        public edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }
    public static void createGraph(ArrayList<edge> graph[]) {
        for(int i = 0 ; i < graph.length ; i++){
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new edge(0,2));

        graph[1].add(new edge(1,2));
        graph[1].add(new edge(1,3));

        graph[2].add(new edge(2,0));
        graph[2].add(new edge(2,1));
        graph[2].add(new edge(2,3));

        graph[3].add(new edge(3,1));
        graph[3].add(new edge(3,2));
    }
    public static void main(String[] args) {
        int v= 4;
        ArrayList<edge> graph[] = new ArrayList[v];
        createGraph(graph);
        //mere ko 2 wali vertex ke sare neigbours print karane hai

        for(int i = 0 ; i < graph[2].size() ; i++){
            System.out.println(graph[2].get(i).dest);
        }
    }


    // If there was weights in the edge
    public static class Edge{
        int s;
        int d;
        int w; //weight
        public Edge(int s , int d,int w){
            this.s = s;
            this.d = d;
            this.w = w;
        }
    }

    public static void createWeightedGraph(ArrayList<Edge> graph[]){
        for(int i = 0 ; i < graph.length ; i++){
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0,2,2));

        graph[1].add(new Edge(1,2,10));
        graph[1].add(new Edge(1,3,0));

        graph[2].add(new Edge(2,0,2));
        graph[2].add(new Edge(2,1,10));
        graph[2].add(new Edge(2,3,-1));

        graph[3].add(new Edge(3,1,0));
        graph[3].add(new Edge(3,2,-1));
    }
}

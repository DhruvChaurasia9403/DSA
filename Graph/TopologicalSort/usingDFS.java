package Graph.TopologicalSort;

import java.util.*;


public class usingDFS {
    // observe some change in topological sort we use stack.
    public static ArrayList<Integer> topo(int V , ArrayList<ArrayList<Integer>> ls){
        Stack<Integer> st = new Stack<>();
        int isv[] = new int[V];
        for(int i = 0 ; i < V ; i++){
            if(isv[i] ==0){
                dfs(i,st,isv,ls);
            }
        }
        ArrayList<Integer> l  = new ArrayList<>();
        while(!st.isEmpty()){
            l.add(st.peek());
            st.pop();
        }
        return l;
    }
    public static void dfs(int s , Stack<Integer> st , int[] isv ,  ArrayList<ArrayList<Integer>> ls){
        isv[s] = 1;
        for(int x : ls.get(s)){
            if(isv[x] == 0){
                dfs(x,st,isv,ls);
            }
        }
        st.push(s);
    }
    public static void main(String[] args) {

    }
}

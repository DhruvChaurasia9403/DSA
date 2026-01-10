package Graph.BFS_and_DFS;
import java.util.*;
public class eventualSafeStates {


    public static ArrayList<Integer> safe(int V , ArrayList<ArrayList<Integer>> ls){
        int[] path = new int[V];
        int[] check = new int[V];
        int[] isv = new int[V];
        for(int i = 0 ; i < V ; i++){
            if(isv[i] == 0){
                dfs(i,isv,check,path,ls);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (check[i] == 1) {
                ans.add(i);
            }
        }
        return ans;
    }
    public static boolean dfs(int s,int[] isv ,int[] check, int[] path, ArrayList<ArrayList<Integer>> ls){
        isv[s] = 1;
        check[s] = 0;
        path[s] = 1;
        for(int i : ls.get(s)){
            if(isv[i] == 0){
                if(dfs(i,isv,check,path,ls)) return true;
            }
            else if(path[i] == 1){
                return true;
            }
        }
        path[s] = 0;
        check[s] = 1;
        return false;
    }
}

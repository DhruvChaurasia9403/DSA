package Graph.Matrix_to_list;
import java.util.*;
public class converting {
    public static ArrayList<ArrayList<Integer>> createList(int[][] arr){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < arr.length ; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0 ; i < arr.length ; i++){
            for (int j = 0 ; j < arr[0].length ; j++){
                if(arr[i][j] == 1 && i!=j){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        return adj;
    }
    public static void main(String[] args) {
        int[][] arr = {{1,0,0},{0,1,0},{0,0,1}};
        ArrayList<ArrayList<Integer>> adj = createList(arr);
    }

}

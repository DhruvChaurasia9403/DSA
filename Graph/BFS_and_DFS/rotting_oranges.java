package Graph.BFS_and_DFS;
import java.util.*;

public class rotting_oranges {
    public static class pair{
        int f;
        int s;
        public pair(int f,int s){
            this.f = f;
            this.s = s;
        }
    }
    public static int rotten(int[][] grid){
        int r = grid.length;
        int c = grid[0].length;
        int fresh = 0, time =0;
        Queue<pair> q = new LinkedList<>();
        for(int i = 0 ; i < r ; i++){
            for(int j = 0 ; j < c ; j++){
                if(grid[i][j] == 2){
                    q.add(new pair(i,j));
                }
                else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        // implementing bfs
        while(!q.isEmpty() && fresh>0){
            int size = q.size();
            time++;
            for(int k = 0 ; k < size ; k++){
                pair curr = q.poll();
                int row = curr.f;
                int col = curr.s;
                for(int i = -1; i <= 1 ; i++){
                    for(int j = -1 ; j<= 1 ; j++){
                        int ROW = row + i;
                        int COL = col + j;
                        if(ROW >=0 && ROW<r && COL >= 0 && COL < c && grid[ROW][COL] == 1){
                            grid[ROW][COL] = 2;
                            fresh--;
                            q.add(new pair(ROW,COL));
                        }
                    }
                }
            }

        }
        return fresh == 0 ? time: -1;
    }
    public static void main(String[] args) {

    }
}

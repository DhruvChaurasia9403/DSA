package Graph.BFS_and_DFS;
import java.util.*;
public class number_of_islands {
    // In this question the matrix will be given which will not be a square matrix and we have to use bfs traversal on the adjacency matrix
    //https://www.geeksforgeeks.org/problems/find-the-number-of-islands/1


    public static class pair{
        int f;
        int s;
        public pair(int f , int s){
            this.f = f;
            this.s = s;
        }
    }
    public static int countIslands(char[][] grid){
        int r = grid.length;
        int c = grid[0].length;
        int count =0;
        int[][] isv = new int[r][c];
        for(int i = 0 ; i < r ; i++){
            for(int j = 0 ; j < c ; j++){
                if(isv[i][j] == 0 && grid[i][j] == 'L'){
                    count++;
                    bfs(i , j , grid , isv);
                }
            }
        }
        return count;
    }
    public static void bfs(int r , int c , char[][] grid, int[][] isv){
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(r,c));
        int n = grid.length;
        int m = grid[0].length;
        isv[r][c] = 1;
        while(!q.isEmpty()){
            pair curr = q.poll();
            int row = curr.f;
            int col = curr.s;
            for(int i = -1 ; i <= 1; i++){
                for(int j = -1 ; j <= 1 ; j++){
                    int ROW = row + i;
                    int COL = col + j;
                    if(isv[ROW][COL] == 0 && ROW>=0 && COL >= 0 && ROW<n && COL < m && grid[ROW][COL] == 'L'){
                        isv[ROW][COL] = 1;
                        q.add(new pair(ROW,COL));
                    }
                }
            }
        }
    }
    public static void main(String[] args) {

    }
}

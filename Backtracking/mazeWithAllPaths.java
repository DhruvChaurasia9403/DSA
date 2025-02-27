package Backtracking;

import java.util.Arrays;

public class mazeWithAllPaths {
    public static void main(String[] args) {
        boolean[][] maze = {{true ,true ,true},
                            {true ,true ,true},
                            {true ,true ,true}};
        int[][] path = new int[3][3];
        allPaths4("",maze,0,0,path,0);
    }



    public static void allPaths(String p , boolean[][] maze ,int r ,int c){
        if(r == maze.length-1 && c == maze[0].length-1){
            System.out.println(p);
            return ;
        }
        if(!maze[r][c]) return ;
        if(r<maze.length-1) allPaths(p+'D',maze,r+1,c);
        if(c<maze[0].length-1) allPaths(p+'R',maze,r,c+1);
        if(r>0) allPaths(p+'U',maze,r-1,c);
        if(c>0) allPaths(p+'L',maze,r,c-1);
    }

    //PROBLEM
    // - suppose that you moved down in a maze(1,0) and at that point you have 3 choices 'u','d','r'
    // - lets suppose that you took 'u' i.e. you are back at the starting point (0,0)


    //SOLUTION
    // so to avoid this we will mark the maze block as marked
    // that will let us know that is the block is visited or not so lets see the code



    public static void allPaths2(String p , boolean[][] maze ,int r ,int c){
        if(r == maze.length-1 && c == maze[0].length-1){
            System.out.println(p);
            return ;
        }
        if(!maze[r][c]) return ;

        // here we marked the block as visited
        maze[r][c]=false;
        if(r<maze.length-1) allPaths(p+'D',maze,r+1,c);
        if(c<maze[0].length-1) allPaths(p+'R',maze,r,c+1);
        if(r>0) allPaths(p+'U',maze,r-1,c);
        if(c>0) allPaths(p+'L',maze,r,c-1);
    }




    //PROBLEM with the above code is :-
    // - lets suppose we found a solution
    //       we are again at the starting index to find the next path to reach the solution
    // - if we again start form the 0,0 and traverse we will find some of the block as marked



    //SOLUTION
    // we will unmark(REVERT) the changes to the maze itself when we move back.




    public static void allPaths3(String p , boolean[][] maze , int r , int c){
        if(r==maze.length-1 && c == maze[0].length-1){
            System.out.println(p);
            return;
        }
        if(!maze[r][c]) return ;
        maze[r][c] = false;
        if(r>0) allPaths3(p+'U',maze , r-1,c);
        if(r<maze.length-1) allPaths3(p+'D',maze,r+1,c);
        if(c>0) allPaths3(p+'L',maze,r, c-1);
        if(c<maze[0].length-1) allPaths3(p+'R',maze,r,c+1);
        //here the function calls will end
        maze[r][c]=true; // Unmarked as non visited
    }



    // let's print the path too


    public static void allPaths4(String p , boolean[][] maze , int r , int c ,int[][]path , int step){
        if(r==maze.length-1 && c == maze[0].length-1){
            for(int[] pa : path){
                System.out.println(Arrays.toString(pa));
            }
            System.out.println(p);
            System.out.println();
            return;
        }
        if(!maze[r][c]) return ;
        path[r][c]=step;
        maze[r][c] = false;
        if(r>0) allPaths4(p+'U',maze , r-1,c,path ,step+1);
        if(r<maze.length-1) allPaths4(p+'D',maze,r+1,c,path ,step+1);
        if(c>0) allPaths4(p+'L',maze,r, c-1,path ,step+1);
        if(c<maze[0].length-1) allPaths4(p+'R',maze,r,c+1,path ,step+1);
        //here the function calls will end
        maze[r][c]=true; // Unmarked as non visited
        path[r][c] =0; // Unmarked as non visited
    }
}

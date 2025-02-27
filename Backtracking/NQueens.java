package Backtracking;

import java.util.Arrays;

public class NQueens {
    public static void main(String[] args) {

        boolean[][] board = new boolean[4][4];
        System.out.println(nQueens(board,0));
    }
    public static int nQueens(boolean[][] arr,int r ){
        if(r==arr.length){
            //all the queens are placed
            DisplayBoard(arr);
            System.out.println();
            return 1;
        }int count =0;
        //this for loop is for traversing the column
        for(int i = 0 ; i < arr.length ;i++){
            if(isSafe(arr,r,i)){
                arr[r][i] = true;
                count += nQueens(arr,r+1);
                arr[r][i] = false;
            }
        }
        return count;
    }

    private static boolean isSafe(boolean[][] arr, int r, int c) {
        for(int i = 0 ; i < r ; i++){
            if(arr[i][c]){
                return false;
            }
        }
        int maxLeft = Math.min(r,c);
        for(int i =0 ; i<=maxLeft ; i++){
            if(arr[r-i][c-i]) return false;
        }
        int maxRight = Math.min(r,arr.length - c -1);
        for(int i = 0 ; i <= maxRight; i++){
            if(arr[r-i][c+i]) return false ;
        }
        return true;
    }

    private static void DisplayBoard(boolean[][] arr) {
        for(boolean[] row : arr){
            for(boolean element : row){
                if(element){
                    System.out.print("Q ");
                }
                else{
                    System.out.print("X ");
                }
            }
        System.out.println();
        }
    }
}

package Backtracking;

public class nKnights {
    public static void main(String[] args) {
        boolean[][] board = new boolean[4][4];
        System.out.println("Total ways: " + Knights(board, 0, 0, 4));
    }

    public static int Knights(boolean[][] board, int r, int c, int knig) {
        if (knig == 0) {
            Display(board);
            System.out.println();
            return 1;
        }
        if (r == board.length) {
            return 0;
        }
        if (c >= board[0].length) {
            return Knights(board, r + 1, 0, knig);
        }
        int count = 0;
        if (isSafe(board, r, c)) {
            board[r][c] = true;
            count += Knights(board, r, c + 1, knig - 1);
            board[r][c] = false; // Backtrack
        }
        count += Knights(board, r, c + 1, knig);

        return count;
    }

    public static boolean isSafe(boolean[][] board, int r, int c) {
        if (r >= 1 && c >= 2 && board[r - 1][c - 2]) {
            return false;
        }
        if (r >= 1 && c + 2 < board[0].length && board[r - 1][c + 2]) {
            return false;
        }
        if (r >= 2 && c >= 1 && board[r - 2][c - 1]) {
            return false;
        }
        if (r >= 2 && c + 1 < board[0].length && board[r - 2][c + 1]) {
            return false;
        }
        return true;
    }

    public static void Display(boolean[][] board) {
        for (boolean[] row : board) {
            for (boolean element : row) {
                if (element) {
                    System.out.print('K' + " ");
                } else {
                    System.out.print('X' + " ");
                }
            }
            System.out.println();
        }
    }
}

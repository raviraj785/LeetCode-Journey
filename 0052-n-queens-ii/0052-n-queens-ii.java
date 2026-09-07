class Solution {

    private boolean isSafe(char[][] board, int row, int col) {
        int n = board.length;

        // check row -> East and West
        for (int j = 0; j < n; j++) {
            if (board[row][j] == 'Q') return false;
        }

        // check col -> North and South
        for (int i = 0; i < n; i++) {
            if (board[i][col] == 'Q') return false;
        }

        // check north east
        int i = row;
        int j = col;

        while (i >= 0 && j < n) {
            if (board[i][j] == 'Q') return false;
            i--;
            j++;
        }

        // check south east
        i = row;
        j = col;

        while (i < n && j < n) {
            if (board[i][j] == 'Q') return false;
            i++;
            j++;
        }

        // check south west
        i = row;
        j = col;

        while (i < n && j >= 0) {
            if (board[i][j] == 'Q') return false;
            i++;
            j--;
        }

        // check north west
        i = row;
        j = col;

        while (i >= 0 && j >= 0) {
            if (board[i][j] == 'Q') return false;
            i--;
            j--;
        }

        return true;
    }

    private int nqueen(char[][] board, int row) {
        int n = board.length;

        if (row == n) { // base case
            return 1;
        }

        int count = 0;

        for (int j = 0; j < n; j++) { // work and call

            if (isSafe(board, row, j)) {

                board[row][j] = 'Q';

                count += nqueen(board, row + 1); // recursion

                board[row][j] = '.'; // backtracking
            }
        }

        return count;
    }

    public int totalNQueens(int n) {

        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        return nqueen(board, 0);
    }
}
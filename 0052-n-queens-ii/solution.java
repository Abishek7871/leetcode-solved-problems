class Solution 
{
    int count = 0;

    public int totalNQueens(int n) 
    {
        boolean[][] board = new boolean[n][n];

        queens(board, 0, n);

        return count;
    }

    void queens(boolean[][] board, int row, int n)
    {
        if(row == n)
        {
            count++;
            return;
        }

        for(int col = 0; col < n; col++)
        {
            if(check(board, row, col, n))
            {
                board[row][col] = true;

                queens(board, row + 1, n);

                board[row][col] = false;
            }
        }
    }

    boolean check(boolean[][] board, int x, int y, int n)
    {
        for(int i = x - 1; i >= 0; i--)
        {
            if(board[i][y])
            {
                return false;
            }
        }

        for(int i = x - 1, j = y - 1; i >= 0 && j >= 0; i--, j--)
        {
            if(board[i][j])
            {
                return false;
            }
        }

        for(int i = x - 1, j = y + 1; i >= 0 && j < n; i--, j++)
        {
            if(board[i][j])
            {
                return false;
            }
        }

        return true;
    }
}

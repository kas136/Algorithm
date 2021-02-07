class Solution
{
    public int solution(int [][]board)
    {
        int answer = board[0][0];

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(i != 0 && j != 0 && board[i][j] == 1)
                    board[i][j] = Math.min(board[i - 1][j], Math.min(board[i][j - 1], board[i - 1][j - 1])) + 1;
                if(answer < board[i][j])
                    answer = board[i][j];
            }
        }
        return answer * answer;
    }
}

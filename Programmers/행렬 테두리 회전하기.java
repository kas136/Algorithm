class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] map = new int[rows + 1][columns + 1];

        int count = 1;
        for(int i = 1; i <= rows; i++) {
            for(int j = 1; j <= columns; j++)
                map[i][j] = count++;
        }

        int[] x_cal = {0, 1, 0, -1};
        int[] y_cal = {1, 0, -1, 0};
        for(int i = 0; i < queries.length; i++) {
            int dir = 0;
            int x = queries[i][0];
            int y = queries[i][1];
            int min = map[x][y];
            int current = map[x][y];
            int next = map[x][y];
            while(dir < 4) {
                int new_x = x + x_cal[dir];
                int new_y = y + y_cal[dir];
                next = map[new_x][new_y];
                min = Math.min(min, next);
                map[new_x][new_y] = current;
                current = next;

                x = new_x;
                y = new_y;
                if((x == queries[i][0] && y == queries[i][3]) || (x == queries[i][2] && y == queries[i][3]) || (x == queries[i][2] && y == queries[i][1]) || (x == queries[i][0] && y == queries[i][1]))
                    dir++;
            }
            answer[i] = min;
        }
        return answer;
    }
}

import java.util.Arrays;

class Solution {
    int cur;
    public int solution(int n, int[][] wires) {
        int answer = n;
        boolean[][] map = new boolean[n + 1][n + 1];
        boolean[] isVisited = new boolean[n + 1];

        for(int[] wire : wires) {
            map[wire[0]][wire[1]] = true;
            map[wire[1]][wire[0]] = true;
        }

        for(int[] wire : wires) {
            cur = 0;
            Arrays.fill(isVisited, false);
            map[wire[0]][wire[1]] = false;
            map[wire[1]][wire[0]] = false;
            dfs(wires[0][0], n, map, isVisited);
            answer = Math.min(answer, Math.abs((n - cur) - cur));
            map[wire[0]][wire[1]] = true;
            map[wire[1]][wire[0]] = true;
        }

        return answer;
    }

    void dfs(int start, int n, boolean[][] map, boolean[] isVisited) {
        cur++;
        isVisited[start] = true;
        for(int i = 1; i <= n; i++) {
            if(map[start][i] && isVisited[i] == false) {
                dfs(i, n, map, isVisited);
            }
        }
    }
}

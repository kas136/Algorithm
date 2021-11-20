class Solution {
    int max;
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        max = 0;
        boolean[] visited = new boolean[dungeons.length];

        dfs(k, dungeons, visited, 0);
        answer = max;
        return answer;
    }

    void dfs(int k, int[][] d, boolean[] v, int count) {
        for(int i = 0; i < d.length; i++) {
            if(!v[i] && k >= d[i][0]) {
                v[i] = true;
                dfs(k - d[i][1], d, v, count + 1);
                v[i] = false;
            }
        }
        max = Math.max(max, count);
    }
}

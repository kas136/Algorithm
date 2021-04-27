import java.util.HashSet;

class Solution {
    HashSet<Integer> set = new HashSet<>();

    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[] visited = new int[N + 1];

        for(int i = 0; i < visited.length; i++)
            visited[i] = Integer.MAX_VALUE;

        visited[1] = 0;

        bfs(road, visited, K, 1, 0);
        answer = set.size();

        return answer;
    }

    void bfs(int[][] road, int[] visited, int k, int current, int count) {
        if(count <= k)
            set.add(current);

        for(int i = 0; i < road.length; i++) {
            if(road[i][0] == current && count + road[i][2] < visited[road[i][1]]) {
                visited[road[i][1]] = count + road[i][2];
                bfs(road, visited, k, road[i][1], count + road[i][2]);
            }

            if(road[i][1] == current && count + road[i][2] < visited[road[i][0]]) {
                visited[road[i][0]] = count + road[i][2];
                bfs(road, visited, k, road[i][0], count + road[i][2]);
            }
        }
    }
}

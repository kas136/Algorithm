import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static class Node {
        int x;
        int y;
        int count;

        public Node(int x, int y, int c) {
            this.x = x;
            this.y = y;
            this.count = c;
        }
    }
    public int solution(int[][] maps) {
        int answer = bfs(0, 0, 1, maps);;

        return answer;
    }

    int bfs(int x, int y, int count, int[][] maps) {
        boolean[][] isVisited = new boolean[maps.length][maps[0].length];
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y, count));
        int[] x_dir = {0, 1, 0, -1};
        int[] y_dir = {1, 0, -1, 0};

        while(!q.isEmpty()) {
            Node newNode = q.poll();
            if(newNode.x == maps.length - 1 && newNode.y == maps[0].length - 1)
                return newNode.count;

            for(int i = 0; i < 4; i++) {
                int x_cal = newNode.x + x_dir[i];
                int y_cal = newNode.y + y_dir[i];

                if(x_cal >= 0 && y_cal >= 0 && x_cal < maps.length && y_cal < maps[0].length) {
                    if(maps[x_cal][y_cal] == 1 && !isVisited[x_cal][y_cal]) {
                        isVisited[x_cal][y_cal] = true;
                        q.add(new Node(x_cal, y_cal, newNode.count + 1));
                    }
                }
            }
        }
        return -1;
    }
}

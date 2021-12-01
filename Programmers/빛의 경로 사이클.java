import java.util.ArrayList;
import java.util.Collections;

class Solution {
    ArrayList<Integer> list;
    boolean[][][] visit;
    String[][] map;
    int[] x_dir;
    int[] y_dir;

    public int[] solution(String[] grid) {
        int[] answer = {};
        list = new ArrayList<>();
        x_dir = new int[]{-1, 0, 1, 0};
        y_dir = new int[]{0, -1, 0, 1};
        visit = new boolean[grid.length][grid[0].length()][4];
        map = new String[grid.length][grid[0].length()];

        for(int i = 0; i < grid.length; i++)
            map[i] = grid[i].split("");

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                for (int k = 0; k < 4; k++) {
                    if(visit[i][j][k] == false)
                        list.add(findWay(i, j, k));
                }
            }
        }

        Collections.sort(list);
        answer = list.stream().mapToInt(i -> i).toArray();
        return answer;
    }

    int findWay(int x, int y, int dir) {
        int count = 0;

        while(!visit[x][y][dir]) {
            count++;
            visit[x][y][dir] = true;

            if(map[x][y].equals("L"))
                dir = (dir + 1) % 4;

            else if(map[x][y].equals("R"))
                dir = (dir + 3) % 4;

            x = (x + x_dir[dir] + map.length) % map.length;
            y = (y + y_dir[dir] + map[0].length) % map[0].length;
        }
        return count;
    }
}

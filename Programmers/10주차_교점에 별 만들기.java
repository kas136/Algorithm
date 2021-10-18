import java.util.ArrayList;

class Solution {
    ArrayList<long[]> map = new ArrayList<>();
    long x_min = Long.MAX_VALUE;
    long x_max = Long.MIN_VALUE;
    long y_min = Long.MAX_VALUE;
    long y_max = Long.MIN_VALUE;

    public String[] solution(int[][] line) {
        String[] answer = {};


        for(int i = 0; i < line.length - 1; i++) {
            for(int j = i + 1; j < line.length; j++)
                findDot(line[i][0], line[i][1], line[i][2], line[j][0], line[j][1], line[j][2]);
        }

        answer = drawing();
        return answer;
    }

    void findDot(long a, long b, long e, long c, long d, long f) {
        double gradient = a * d - b * c;

        if(gradient == 0)
            return;

        double x = (b * f - e * d) / gradient;
        double y = (e * c - a * f) / gradient;
        long lx = (long) x;
        long ly = (long) y;

        if(x == lx && y == ly) {
            x_min = Math.min(x_min, lx);
            x_max = Math.max(x_max, lx);
            y_min = Math.min(y_min, ly);
            y_max = Math.max(y_max, ly);
            map.add(new long[]{lx, ly});
        }
    }

    String[] drawing() {
        String[] draw = new String[(int)(y_max - y_min) + 1];

        for(int i = 0; i <= (int)(y_max - y_min); i++)
            draw[i] = ".".repeat((int) (x_max - x_min) + 1);

        for(int i = 0; i < map.size(); i++) {
            int x = (int)(map.get(i)[0] - x_min);
            int y = (int)(y_max - map.get(i)[1]);
            draw[y] = draw[y].substring(0, x) + "*" + draw[y].substring(x + 1);
        }
        return draw;
    }
}

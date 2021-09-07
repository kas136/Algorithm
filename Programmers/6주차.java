import java.util.Arrays;

class Solution {
    public int[] solution(int[] weights, String[] head2head) {
        int[] answer = new int[weights.length];
        int[][] info = new int[weights.length][4];

        for (int i = 0; i < weights.length; i++) {
            int win = 0;
            int no = 0;
            int over_win = 0;

            for (int j = 0; j < head2head[0].length(); j++) {
                if(head2head[i].charAt(j) == 'W') {
                    win++;
                    if(weights[i] < weights[j])
                        over_win++;
                }
                else if(head2head[i].charAt(j) == 'N')
                    no++;
            }

            info[i][0] = i + 1;
            info[i][1] = (int)((double)win / (weights.length - no) * 10000000);
            info[i][2] = over_win;
            info[i][3] = weights[i];
        }

        Arrays.sort(info, (a, b) -> {
            if(a[1] != b[1]) return b[1] - a[1];
            if(a[2] != b[2]) return b[2] - a[2];
            if(a[3] != b[3]) return b[3] - a[3];
            return a[0] - b[0];
        });

        for (int i = 0; i < info.length; i++)
            answer[i] = info[i][0];

        return answer;
    }
}
